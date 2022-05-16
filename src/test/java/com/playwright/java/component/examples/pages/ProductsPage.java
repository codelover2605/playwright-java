package com.playwright.java.component.examples.pages;

import com.microsoft.playwright.Page;
import com.playwright.java.library.testbases.WebPage;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ProductsPage extends WebPage {

  public ProductsPage(Page page) {
    super(page);
  }

  public ProductsPage addItemsToCart(List<String> items) {
    inventoryList().addItemsToCart(items);
    return this;
  }

  public Map<String, String> getItemPrices(List<String> items) {
    return inventoryList().getItemsPrices(items);
  }
}
