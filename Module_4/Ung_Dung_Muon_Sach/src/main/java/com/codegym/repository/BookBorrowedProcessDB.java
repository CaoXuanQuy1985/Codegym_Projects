package com.codegym.repository;

import com.codegym.model.BookBorrowed;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookBorrowedProcessDB extends PagingAndSortingRepository<BookBorrowed, Long> {
    BookBorrowed findAllBySerialBookBorrowed(Long serialBookBorrowed);
}
