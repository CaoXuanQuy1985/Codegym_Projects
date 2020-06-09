package com.codegym.service;

import com.codegym.model.CommentRecord;
import com.codegym.service.exception.FilterBadWord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterfaceCommentService {
    Page<CommentRecord> findAll(Pageable pageable);

    CommentRecord findById(Long id) throws Exception;

    CommentRecord save(CommentRecord commentRecord) throws FilterBadWord;

    void remove(Long id);
}
