package com.codegym.repository.impl;

import com.codegym.model.CommentRecord;
import com.codegym.repository.InterfaceCommentProcessDB;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CommentsRepositoryImpl implements InterfaceCommentProcessDB {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CommentRecord> findAll() {
        TypedQuery<CommentRecord> query = em.createQuery("select c from CommentRecord c", CommentRecord.class);
        return query.getResultList();
    }

    @Override
    public CommentRecord findById(Long id) {
        TypedQuery<CommentRecord> query = em.createQuery("select c from CommentRecord c where c.id =:id", CommentRecord.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(CommentRecord model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        CommentRecord CommentRecord = findById(id);
        if (CommentRecord != null) {
            em.remove(CommentRecord);
        }
    }
}
