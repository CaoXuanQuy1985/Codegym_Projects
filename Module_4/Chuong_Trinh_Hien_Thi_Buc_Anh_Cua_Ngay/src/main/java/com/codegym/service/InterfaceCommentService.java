package com.codegym.service;

import com.codegym.model.CommentRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterfaceCommentService {
    Page<CommentRecord> findAll(Pageable pageable);

    CommentRecord findById(Long id) throws Exception;

    CommentRecord save(CommentRecord commentRecord);

    void remove(Long id);
}
