package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();
    Product findById(int id);
    void addProduct(Product product);
    void removeProduct(int id);
    void updateProduct(int id, Product product);
}
