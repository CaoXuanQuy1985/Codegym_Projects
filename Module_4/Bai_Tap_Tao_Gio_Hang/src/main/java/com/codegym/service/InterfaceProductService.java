package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ShoppingCart;

public interface InterfaceProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    Product save(Product shoppingCart);

    void remove(Long id);
}
