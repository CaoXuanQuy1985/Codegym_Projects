package com.codegym.service.impl;

import com.codegym.model.BookBorrowed;
import com.codegym.repository.BookBorrowedProcessDB;
import com.codegym.service.InterfaceBookBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookBorrowedServiceImpl implements InterfaceBookBorrowedService {

    @Autowired
    private BookBorrowedProcessDB bookBorrowedProcessDB;

    @Override
    public Iterable<BookBorrowed> findAll() {
       return bookBorrowedProcessDB.findAll();
    }

    @Override
    public BookBorrowed save(BookBorrowed bookBorrowed) {
        return bookBorrowedProcessDB.save(bookBorrowed);
    }

    @Override
    public BookBorrowed findById(Long id) {
        return bookBorrowedProcessDB.findOne(id);
    }

    @Override
    public BookBorrowed findAllBySerialBookBorrowed(Long serialBookBorrowed) {
        return bookBorrowedProcessDB.findAllBySerialBookBorrowed(serialBookBorrowed);
    }

    @Override
    public void remove(Long id) {
        bookBorrowedProcessDB.delete(id);
    }
}
