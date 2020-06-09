package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="logtables")
public class LogTable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String author;
    private String content;
    private LocalDateTime dateTime = LocalDateTime.now();

    public LogTable() {}

    public LogTable(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
