package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.model.ShoppingCart;
import com.codegym.repository.ProductProcessDB;
import com.codegym.service.InterfaceProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements InterfaceProductService {

    @Autowired
    private ProductProcessDB productProcessDB;

    @Override
    public Iterable<Product> findAll() {
       return productProcessDB.findAll();
    }

    @Override
    public Product save(Product product) {
        return productProcessDB.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productProcessDB.findOne(id);
    }

    @Override
    public void remove(Long id) {
        productProcessDB.delete(id);
    }
}
