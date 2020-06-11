package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterfaceShoppingCartService {
    Page<ShoppingCart> findAll(Pageable pageable);

    ShoppingCart findById(Long id);

    ShoppingCart save(ShoppingCart shoppingCart);

    void remove(Long id);
}
