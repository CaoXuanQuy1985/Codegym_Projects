package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="library")
public class Library {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nameCategory;
    private Long quantityRemain;

    @OneToMany
    @JoinColumn(name="bookBorrowed_id")
    private Set<BookBorrowed> booksBorrowed;

    public Library(){}

    public Library(String nameCategory, Long quantityRemain, Set<BookBorrowed> booksBorrowed) {
        this.nameCategory = nameCategory;
        this.quantityRemain = quantityRemain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Long getQuantityRemain() {
        return quantityRemain;
    }

    public void setQuantityRemain(Long quantityRemain) {
        this.quantityRemain = quantityRemain;
    }

    public Set<BookBorrowed> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(Set<BookBorrowed> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
}
