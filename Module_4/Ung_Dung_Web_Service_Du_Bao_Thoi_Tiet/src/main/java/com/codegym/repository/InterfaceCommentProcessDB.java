package com.codegym.repository;

import com.codegym.model.CommentRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InterfaceCommentProcessDB extends PagingAndSortingRepository<CommentRecord, Long> {
    List<CommentRecord> findAllByAuthor(String author);
}
