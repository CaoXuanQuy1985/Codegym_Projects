package com.codegym.repository;

import com.codegym.model.RatingPoint;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterfaceRatingProcessDB extends PagingAndSortingRepository<RatingPoint, Long> {
}
