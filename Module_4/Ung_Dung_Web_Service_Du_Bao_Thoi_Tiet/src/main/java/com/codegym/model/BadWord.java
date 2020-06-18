package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="badwords")
public class BadWord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String content;

    public BadWord(){}

    public BadWord(String content, CommentRecord commentRecord) {
        this.content = content;
        this.commentRecord = commentRecord;
    }

    @JsonIgnore
    @ManyToOne
    private CommentRecord commentRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentRecord getCommentRecord() {
        return commentRecord;
    }

    public void setCommentRecord(CommentRecord commentRecord) {
        this.commentRecord = commentRecord;
    }
}
