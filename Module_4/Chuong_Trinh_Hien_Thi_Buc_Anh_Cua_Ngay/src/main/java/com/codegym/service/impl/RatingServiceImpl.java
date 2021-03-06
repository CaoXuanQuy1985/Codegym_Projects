package com.codegym.service.impl;

import com.codegym.model.RatingPoint;
import com.codegym.repository.InterfaceRatingProcessDB;
import com.codegym.service.InterfaceRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class RatingServiceImpl implements InterfaceRatingService {
    @Autowired
    private InterfaceRatingProcessDB interfaceRatingProcessDB;

    @Override
    public Iterable<RatingPoint> findAll() {
       return interfaceRatingProcessDB.findAll();
    }

    @Override
    public void save(RatingPoint image) {
        interfaceRatingProcessDB.save(image);
    }

    @Override
    public RatingPoint findById(Long id) {
        return interfaceRatingProcessDB.findOne(id);
    }

    @Override
    public void remove(Long id) {
        interfaceRatingProcessDB.delete(id);
    }
}
