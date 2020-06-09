package com.codegym.controller;

import com.codegym.model.BookBorrowed;
import com.codegym.model.Library;
import com.codegym.service.InterfaceBookBorrowedService;
import com.codegym.service.InterfaceLibraryService;
import com.codegym.service.exception.BookNotExists;
import com.codegym.service.exception.OutOfBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class LibraryController {

    @Autowired
    private InterfaceLibraryService interfaceLibraryService;

    @Autowired
    private InterfaceBookBorrowedService interfaceBookBorrowedService;

    @GetMapping(value="/")
    public ModelAndView showLibrary(Pageable pageable) {
        Page<Library> booksList = interfaceLibraryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("booksList", booksList);
        return modelAndView;
    }

    @GetMapping(value="/details/{id}")
    public ModelAndView showDetail(@PathVariable Long id) throws Exception{
        Library library = interfaceLibraryService.findById(id);
        if (library != null) {
            ModelAndView modelAndView = new ModelAndView("book-detail");
            modelAndView.addObject("library", library);
            return modelAndView;
        } else {
            return new ModelAndView("inputs-not-acceptable");
        }
    }

    @PostMapping(value="/borrow")
    public ModelAndView borrowBook(@ModelAttribute("library") Library library) throws OutOfBookException{
        Long oldQuantityBook = library.getQuantityRemain();
        if (oldQuantityBook == 0) {
            throw new OutOfBookException();
        } else {
            Long newQuantityBook = oldQuantityBook - 1;
            library.setQuantityRemain(newQuantityBook);
            interfaceLibraryService.save(library);
            String nameBookBorrowed = library.getNameCategory();
            Long code = generateCode();
            BookBorrowed bookBorrowed = new BookBorrowed();
            bookBorrowed.setNameBookBorrowed(nameBookBorrowed);
            bookBorrowed.setSerialBookBorrowed(code);
            interfaceBookBorrowedService.save(bookBorrowed);
            ModelAndView modelAndView = new ModelAndView("book-detail");
            modelAndView.addObject("message", "Bạn đã mượn sách " + nameBookBorrowed + " thành công"
             + "Hãy để ý số lượng quyển sách đó trong thư viện đã giảm đi 1 đơn vi");
            return modelAndView;
        }
    }

    private Long generateCode() {
        Long code = (long)(10000 + new Random().nextInt(90000));
        return code;
    }

    @RequestMapping(value="/return-book", method= RequestMethod.GET)
    public ModelAndView showReturnBookForm() {
        ModelAndView modelAndView = new ModelAndView("return-book");
        modelAndView.addObject("bookReturned", new BookBorrowed());
        return modelAndView;
    }

    @PostMapping(value="/return-book")
    public ModelAndView returnBook(@ModelAttribute("bookReturned") BookBorrowed bookReturned) throws BookNotExists{
        Iterable<BookBorrowed> bookBorrowedList = interfaceBookBorrowedService.findAll();
        String namebookReturned = bookReturned.getNameBookBorrowed();
        Long code = bookReturned.getSerialBookBorrowed();
        BookBorrowed bookBorrowed;
        bookBorrowed = interfaceBookBorrowedService.findAllBySerialBookBorrowed(code);
        if (bookBorrowed == null) {
            throw new BookNotExists("Sách không tồn tại Exception");
        }
        Long bookBorrowed_id = bookBorrowed.getId();
        String nameBookBorrowed = "";
        Long codeBookBorrowed = 0L;
        for (BookBorrowed bb : bookBorrowedList) {
            nameBookBorrowed = bb.getNameBookBorrowed();
            codeBookBorrowed = bb.getSerialBookBorrowed();
            if (nameBookBorrowed.equals(namebookReturned) && codeBookBorrowed.equals(code)) {
                interfaceBookBorrowedService.remove(bookBorrowed_id);
                Library nameBook = interfaceLibraryService.findAllByNameCategory(namebookReturned);
                Long nameBook_id = nameBook.getId();
                Library book = interfaceLibraryService.findById(nameBook_id);
                Long quantityRemain = book.getQuantityRemain();
                quantityRemain++;
                book.setQuantityRemain(quantityRemain);
                interfaceLibraryService.save(book);
                return new ModelAndView("redirect:/");
            }
        }

        return new ModelAndView("redirect:/error-404-return");
    }

    @ExceptionHandler(BookNotExists.class)
    public ModelAndView showError404Return() {
        return new ModelAndView("error-404-return");
    }

    @ExceptionHandler(OutOfBookException.class)
    public ModelAndView showError404() {
        return new ModelAndView("error-404");
    }
}
