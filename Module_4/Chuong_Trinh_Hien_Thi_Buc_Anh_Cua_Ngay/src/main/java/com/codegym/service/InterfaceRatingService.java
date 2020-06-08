package com.codegym.service;

import com.codegym.model.RatingPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterfaceRatingService {
    Iterable<RatingPoint> findAll();

    RatingPoint findById(Long id);

    void save(RatingPoint image);

    void remove(Long id);
}
