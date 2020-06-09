package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="bookborrowed")
public class BookBorrowed {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nameBookBorrowed;
    private Long serialBookBorrowed;
    private Long quantityRemain;

    @ManyToOne
    private Library library;

    public BookBorrowed() {}

    public BookBorrowed(String nameBookBorrowed, Long serialBookBorrowed, Long quantityRemain) {
        this.nameBookBorrowed = nameBookBorrowed;
        this.serialBookBorrowed = serialBookBorrowed;
        this.quantityRemain = quantityRemain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBookBorrowed() {
        return nameBookBorrowed;
    }

    public void setNameBookBorrowed(String nameBookBorrowed) {
        this.nameBookBorrowed = nameBookBorrowed;
    }

    public Long getSerialBookBorrowed() {
        return serialBookBorrowed;
    }

    public void setSerialBookBorrowed(Long serialBookBorrowed) {
        this.serialBookBorrowed = serialBookBorrowed;
    }

    public Long getQuantityRemain() {
        return quantityRemain;
    }

    public void setQuantityRemain(Long quantityRemain) {
        this.quantityRemain = quantityRemain;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
