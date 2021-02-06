package com.thoughtworks.ddd.domain.service;

import com.thoughtworks.ddd.domain.Price;

import java.util.Currency;
import java.util.HashMap;

public class CompetitorPriceBasedPricer {
    public static final float DISCOUNT_RATE = 10;

    public static HashMap<String, Price> competitorPrices() {
        HashMap<String, Price> competitorPrices = new HashMap<>();
        Currency inr = Currency.getInstance("INR");
        competitorPrices.put("IPad Pro", new Price(100000f, inr));
        competitorPrices.put("Hero Ink Pen", new Price(10f, inr));
        competitorPrices.put("GM Cricket Bat", new Price(1000f, inr));
        return competitorPrices;
    }

    public static Price priceFor(String productName) {
        Price price = competitorPrices().get(productName);

        return new Price(price.getAmount() - (price.getAmount() * (DISCOUNT_RATE / 100)), price.getCurrency());
    }
}
