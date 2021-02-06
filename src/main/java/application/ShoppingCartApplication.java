package application;

import com.thoughtworks.ddd.domain.Cart;
import com.thoughtworks.ddd.domain.Item;
import com.thoughtworks.ddd.domain.Product;
import com.thoughtworks.ddd.domain.service.CompetitorPriceBasedPricer;

import java.util.Currency;

public class ShoppingCartApplication {

    public static void main(String[] args) {
        Cart cart = new Cart();
        Currency inr = Currency.getInstance("INR");
        Product ipadPro = new Product("IPad Pro", CompetitorPriceBasedPricer.priceFor("IPad Pro"));
        Product heroInkPen = new Product("Hero Ink Pen", CompetitorPriceBasedPricer.priceFor("Hero Ink Pen"));
        Product gmCricketBat = new Product("GM Cricket Bat", CompetitorPriceBasedPricer.priceFor("GM Cricket Bat"));

        Item iPadProItem = new Item(ipadPro);
        Item heroInkPenItem = new Item(heroInkPen);
        Item gmCricketBatItem = new Item(gmCricketBat, 2);

        cart.add(iPadProItem);
        cart.add(heroInkPenItem);
        cart.add(gmCricketBatItem);

        System.out.println(cart.getItems());

        cart.remove(iPadProItem);

        System.out.println(cart.getItems());
        System.out.println(cart.getDeletedItems());

        System.out.println(ipadPro.getPrice());
    }

}
