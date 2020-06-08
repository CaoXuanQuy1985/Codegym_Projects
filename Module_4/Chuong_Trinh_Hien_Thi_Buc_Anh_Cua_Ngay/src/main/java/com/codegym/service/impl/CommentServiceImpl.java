package com.codegym.service.impl;

import com.codegym.model.BadWord;
import com.codegym.model.CommentRecord;
import com.codegym.model.LogTable;
import com.codegym.repository.InterfaceCommentProcessDB;
import com.codegym.repository.InterfaceLogProcessDB;
import com.codegym.service.InterfaceCommentService;
import com.codegym.service.exception.FilterBadWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CommentServiceImpl implements InterfaceCommentService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private InterfaceCommentProcessDB interfaceCommentProcessDB;

    @Autowired
    private InterfaceLogProcessDB interfaceLogProcessDB;

    @Override
    public Page<CommentRecord> findAll(Pageable pageable) {
        return interfaceCommentProcessDB.findAll(pageable);
    }

    @Override
    @Transactional
    public CommentRecord save(CommentRecord commentRecord) throws FilterBadWord {
        TypedQuery<BadWord> query = em.createQuery("select b from BadWord b", BadWord.class);
        List<BadWord> badWordList = query.getResultList();
        String feedback = commentRecord.getFeedback();
        String author = commentRecord.getAuthor();
        for (BadWord bw : badWordList) {
            if (feedback.contains(bw.getContent())) {
                interfaceLogProcessDB.save(new LogTable (author, feedback));
                throw new FilterBadWord();
            }
        }
        return interfaceCommentProcessDB.save(commentRecord);
    }

    @Override
    public CommentRecord findById(Long id) throws Exception {
        CommentRecord target = interfaceCommentProcessDB.findOne(id);
        if (target == null) {
            throw new Exception("CommentRecord not found");
        }
        return target;
    }

    @Override
    public void remove(Long id) {
        interfaceCommentProcessDB.delete(id);
    }
}
