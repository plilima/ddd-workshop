package com.thoughtworks.ddd.domain;

import java.util.List;

public class Order {
    private List<Product> products;
    private Address address;

    public Order(List<Product> products, Address address) {
        this.products = products;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public List<Product> getProducts() {
        return products;
    }
}
