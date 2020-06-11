package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name="shoppingCart_id")
    private ShoppingCart shoppingCart;

    public Product(){}

    public Product(String name, Double price, Long quantity, Set<ShoppingCart> booksBorrowed) {
        this.name = name;
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameCategory) {
        this.name = nameCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double quantityRemain) {
        this.price = quantityRemain;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
