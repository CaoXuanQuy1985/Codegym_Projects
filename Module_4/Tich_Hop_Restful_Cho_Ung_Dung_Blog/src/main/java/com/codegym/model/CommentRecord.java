package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="comments")
public class CommentRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ratingPoint_id")
    private com.codegym.model.RatingPoint ratingPoint;

    @JsonIgnore
    @OneToMany
    private Set<com.codegym.model.BadWord> badWords;

    public Set<com.codegym.model.BadWord> getBadWords() {
        return badWords;
    }

    public void setBadWords(Set<com.codegym.model.BadWord> badWords) {
        this.badWords = badWords;
    }

    private final String nameImage = "Image Of Day";
    private String author;
    private String feedback;
    private LocalDateTime dateTime = LocalDateTime.now();

    public Long getNumberLikes() {
        return numberLikes;
    }

    public void setNumberLikes(Long numberLikes) {
        this.numberLikes = numberLikes;
    }

    private Long numberLikes = 0L;

    public CommentRecord(com.codegym.model.RatingPoint ratingPoint, Set<com.codegym.model.BadWord> badWords, String author, String feedback, LocalDateTime dateTime, Long numberLikes) {
        this.ratingPoint = ratingPoint;
        this.badWords = badWords;
        this.author = author;
        this.feedback = feedback;
        this.dateTime = dateTime;
        this.numberLikes = numberLikes;
    }

    public String getNameImage() {
        return nameImage;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CommentRecord(){}


    public CommentRecord(com.codegym.model.RatingPoint ratingPoint, String author, String feedback) {
        this.ratingPoint = ratingPoint;
        this.author = author;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.codegym.model.RatingPoint getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(com.codegym.model.RatingPoint ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
