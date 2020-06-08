package com.codegym.service.impl;

import com.codegym.model.CommentRecord;
import com.codegym.repository.InterfaceCommentProcessDB;
import com.codegym.service.InterfaceCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public class CommentServiceImpl implements InterfaceCommentService {

    @Autowired
    private InterfaceCommentProcessDB interfaceCommentProcessDB;

    @Override
    public Page<CommentRecord> findAll(Pageable pageable) {
        return interfaceCommentProcessDB.findAll(pageable);
    }

    @Override
    public CommentRecord save(CommentRecord commentRecord) {
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
