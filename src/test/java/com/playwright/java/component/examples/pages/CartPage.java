package com.playwright.java.component.examples.pages;

import com.microsoft.playwright.Page;
import com.playwright.java.library.testbases.WebPage;

import java.util.Map;

public class CartPage extends WebPage {
    public CartPage(Page page) {
        super(page);
    }

    public CartPage navigateToCart() {
        element(".shopping_cart_link").click(true);
        return this;
    }

    public Map<String, String> getItemsInTheCartAndTheirPrices() {
        return cartItemsList().getItemsAndPrices();
    }
}
