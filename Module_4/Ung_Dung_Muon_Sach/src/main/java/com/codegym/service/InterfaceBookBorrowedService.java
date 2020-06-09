package com.codegym.service;

import com.codegym.model.BookBorrowed;

public interface InterfaceBookBorrowedService {
    Iterable<BookBorrowed> findAll();

    BookBorrowed findAllBySerialBookBorrowed(Long serialBookBorrowed);

    BookBorrowed findById(Long id);

    BookBorrowed save(BookBorrowed bookBorrowed);

    void remove(Long id);
}
