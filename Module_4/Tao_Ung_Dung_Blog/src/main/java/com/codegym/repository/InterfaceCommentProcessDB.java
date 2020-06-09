package com.codegym.repository;

import com.codegym.model.CommentRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterfaceCommentProcessDB extends PagingAndSortingRepository<CommentRecord, Long> {
}
