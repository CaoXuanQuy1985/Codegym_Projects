package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="shoppingcarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nameProduct;
    private Double priceProduct;
    private Long quantity;

    @OneToMany(mappedBy="shoppingCart")
    private Set<Product> products;

    public ShoppingCart() {}

    public ShoppingCart(String nameProduct, Double priceProduct, Long quantity) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameBookBorrowed) {
        this.nameProduct = nameBookBorrowed;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantityRemain) {
        this.quantity = quantityRemain;
    }

    public Set<Product> getProductSet() {
        return products;
    }

    public void setProduct(Set<Product> products) {
        this.products = products;
    }
}
