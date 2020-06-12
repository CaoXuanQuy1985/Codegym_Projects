package com.codegym.service.impl;

import com.codegym.model.RatingPoint;
import com.codegym.repository.InterfaceRatingProcessDB;
import com.codegym.service.InterfaceRatingService;
import org.springframework.beans.factory.annotation.Autowired;

public class RatingServiceImpl implements InterfaceRatingService {
/*    @Autowired
    private InterfaceRatingProcessDB interfaceRatingProcessDB;*/

    @Override
    public Iterable<RatingPoint> findAll() {
       //return interfaceRatingProcessDB.findAll();
        return null;
    }

    @Override
    public void save(RatingPoint image) {
        //interfaceRatingProcessDB.save(image);
    }

    @Override
    public RatingPoint findById(Long id) {
        //return interfaceRatingProcessDB.findById(id);
        return null;
    }

    @Override
    public void remove(Long id) {
        //interfaceRatingProcessDB.remove(id);
    }
}
