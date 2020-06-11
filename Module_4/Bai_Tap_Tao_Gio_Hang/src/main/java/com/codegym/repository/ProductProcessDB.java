package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.model.ShoppingCart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductProcessDB extends PagingAndSortingRepository<Product, Long> {
}
