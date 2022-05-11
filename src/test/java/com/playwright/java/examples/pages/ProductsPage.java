package com.playwright.java.examples.pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;

public class ProductsPage extends WebPage {

  public ProductsPage(Page page) {
    super(page);
  }

  public ProductsPage validateOnProductsPage() {
    Assert.assertTrue(page.locator("[class='title']:has-text('Products')").count() == 1);
    return this;
  }
}
