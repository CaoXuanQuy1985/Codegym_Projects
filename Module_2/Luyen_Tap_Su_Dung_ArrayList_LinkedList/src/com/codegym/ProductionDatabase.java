package com.codegym;

import java.util.*;

public class ProductionDatabase<T extends Production> {
    private List<T> storageProduct;
    private List<T> processorProduct;

    public ProductionDatabase() {
        this.storageProduct = new ArrayList<T>();
        this.processorProduct = new LinkedList<T>();
    }

    public boolean addItem(T product) {
        return this.processorProduct.add(product);
    }

    public boolean addAllItems(Collection<? extends T> collectionProduct) {
        return this.processorProduct.addAll(collectionProduct);
    }

    public T editInformation(int id, String name, double price) {
        T product = this.processorProduct.get(id - 1);
        product.setName(name);
        product.setPrice(price);

        return this.processorProduct.set(id - 1, product);
    }

    public T removeProduction(int id) {
        T product =  this.processorProduct.remove(id - 1);
        for (T item : this.processorProduct) {
            item.setId(item.getId() - 1);
        }

        return product;
    }

    public List<T> findProductByName(String name) {
        this.storageProduct = new ArrayList<T>(this.processorProduct);
        List<T> resultList = new ArrayList<T>();

        for (T item : this.storageProduct) {
            String nameT = item.getName();
            if (nameT.equals(name)) {
                resultList.add(item);
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("Không thể tìm thấy sản phẩm có tên là: " + name);
            return null;
        }

        return resultList;
    }

    public void displayStorageProduct() {
        this.storageProduct = new ArrayList<T>(this.processorProduct);
        for (T item : this.storageProduct) {
            System.out.println(item);
        }
    }

    public void sortPriceAscending() {
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T obj1, T obj2) {
                return (obj1.getPrice() < obj2.getPrice()) ? -1 : ((obj1.getPrice() == obj2.getPrice()) ? 0 : 1);
            }
        };
        this.processorProduct.sort(comparator);

        this.storageProduct = new ArrayList<T>(this.processorProduct);
    }

    public void sortPriceDescending() {
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T obj1, T obj2) {
                return (obj1.getPrice() < obj2.getPrice()) ? 1 : ((obj1.getPrice() == obj2.getPrice()) ? 0 : -1);
            }
        };
        this.processorProduct.sort(comparator);

        this.storageProduct = new ArrayList<T>(this.processorProduct);
    }
}