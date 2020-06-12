package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ratingpoints")
public class RatingPoint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String point;

    @JsonIgnore
    @OneToMany(mappedBy = "ratingPoint")
    private Set<CommentRecord> commentRecords;

    public Set<CommentRecord> getCommentRecords() {
        return commentRecords;
    }

    public void setCommentRecords(Set<CommentRecord> commentRecords) {
        this.commentRecords = commentRecords;
    }

    public RatingPoint(String point) {
        this.point = point;
    }

    public RatingPoint() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
