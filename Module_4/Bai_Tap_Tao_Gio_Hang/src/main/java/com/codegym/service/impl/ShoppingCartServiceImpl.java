package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.model.ShoppingCart;
import com.codegym.repository.ShoppingCartProcessDB;
import com.codegym.service.InterfaceShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class ShoppingCartServiceImpl implements InterfaceShoppingCartService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ShoppingCartProcessDB shoppingCartProcessDB;

    @Override
    public Page<ShoppingCart> findAll(Pageable pageable) {
        return shoppingCartProcessDB.findAll(pageable);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartProcessDB.save(shoppingCart);
    }

    @Override
    public ShoppingCart findById(Long id) {
        return shoppingCartProcessDB.findOne(id);
    }

    @Override
    public void remove(Long id) {
        shoppingCartProcessDB.delete(id);
    }
}
