package com.thoughtworks.ddd.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cart {
    private final UUID identifier;
    private final List<Item> items;
    private final List<Item> deletedItems;
    private Boolean checkedOut;

    public Cart() {
        identifier = UUID.randomUUID();
        items = new ArrayList<>();
        deletedItems = new ArrayList<>();
        checkedOut = false;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        deletedItems.add(item);
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Item> getDeletedItems() {
        return deletedItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return this.identifier.equals(cart.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public Order checkOut(Address address) {
        checkedOut = true;
        List<Product> products = items.stream()
                .map(item -> item.product)
                .collect(Collectors.toList());
        return new Order(products,address);
    }
}


