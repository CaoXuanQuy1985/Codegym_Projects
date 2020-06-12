package com.codegym.service;

import com.codegym.model.RatingPoint;

public interface InterfaceRatingService {
    Iterable<RatingPoint> findAll();

    RatingPoint findById(Long id);

    void save(RatingPoint image);

    void remove(Long id);
}
