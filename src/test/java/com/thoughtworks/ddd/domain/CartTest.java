package com.thoughtworks.ddd.domain;

import com.thoughtworks.ddd.domain.service.CompetitorPriceBasedPricer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

public class CartTest {

    @Test
    public void shouldAddItemToCart() {
        Cart cart = new Cart();
        Product product = new Product("dummy Item", new Price(10f, Currency.getInstance("INR")));
        Item item = new Item(product);

        cart.add(item);

        Assert.assertEquals(item, cart.getItems().get(0));
    }

    @Test
    public void shouldRemoveItemAsCart() {
        Cart cart = new Cart();
        Product product = new Product("dummy Item", new Price(10f, Currency.getInstance("INR")));
        Item item = new Item(product);

        cart.add(item);
        cart.remove(item);

        Assert.assertEquals(0, cart.getItems().size());
    }

    @Test
    public void shouldReturnListOfRemovedCart() {
        Cart cart = new Cart();
        Product product = new Product("dummy Item", new Price(10f, Currency.getInstance("INR")));
        Item item = new Item(product);

        cart.add(item);
        cart.remove(item);

        Assert.assertEquals(item, cart.getDeletedItems().get(0));
    }

    @Test
    public void shouldDifferentiateTwoCartsWithSameItems() {
        Product product = new Product("dummy Item", new Price(10f, Currency.getInstance("INR")));
        Item item = new Item(product);
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.add(item);
        cart2.add(item);

        Assert.assertNotEquals(cart1, cart2);
    }


    @Test
    public void shouldReturnPriceOfAProduct() {
        Product product = new Product("dummy Item", new Price(10f, Currency.getInstance("INR")));

        Assert.assertEquals(new Price(10f, Currency.getInstance("INR")), product.getPrice());
    }

    @Test
    public void shouldSetTheDiscountedPriceOfTheProduct() {
        Product product = new Product("IPad Pro", CompetitorPriceBasedPricer.priceFor("IPad Pro"));

        Assert.assertEquals(new Price(90000f, Currency.getInstance("INR")), product.getPrice());
    }

    @Test
    public void shouldMarkTheCartAsCheckedOut() {
        Cart cart = new Cart();
        Product product = new Product("IPad Pro", CompetitorPriceBasedPricer.priceFor("IPad Pro"));
        Item item = new Item(product );

        Address address = new Address("Pune");

        cart.add(item);
        cart.checkOut(address);

        Assert.assertTrue(cart.isCheckedOut());
    }

    @Test
    public void shouldCreateOrderWhenCartIsCheckedOut() {
        Cart cart = new Cart();
        Product product = new Product("IPad Pro", CompetitorPriceBasedPricer.priceFor("IPad Pro"));
        Item item = new Item(product );

        Address address = new Address("Pune");

        cart.add(item);
        Order order = cart.checkOut(address);

        Assert.assertEquals(address,order.getAddress());
        Assert.assertEquals(product,order.getProducts().get(0));
    }
}