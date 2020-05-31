package com.codegym.service.implement;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "vinalmilk", "M001", "20/12/2020"));
        products.put(2, new Product(2, "sugar", "S002", "09/09/2019"));
        products.put(3, new Product(3, "coffee", "C003", "12/05/2018"));
        products.put(4, new Product(4, "vagetable", "V002", "09/10/2017"));
    }

    public List<Product> listAllProduct() {
        return new ArrayList<Product>(products.values());
    }

    public Product findById(int id) {
        return products.get(id);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
    public void removeProduct(int id) {
        products.remove(id);
    }
    public void updateProduct(int id, Product product) {
        products.put(id, product);
    }
}
