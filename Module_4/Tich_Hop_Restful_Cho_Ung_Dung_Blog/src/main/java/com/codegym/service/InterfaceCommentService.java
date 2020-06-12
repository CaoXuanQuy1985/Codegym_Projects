package com.codegym.service;

import com.codegym.model.CommentRecord;
import com.codegym.service.exception.FilterBadWord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterfaceCommentService {
    List<CommentRecord> findAll();

    CommentRecord findById(Long id) throws Exception;

    void save(CommentRecord commentRecord) throws FilterBadWord;

    void remove(Long id);
}
