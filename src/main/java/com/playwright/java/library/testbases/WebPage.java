package com.playwright.java.library.testbases;

import com.microsoft.playwright.Page;
import com.playwright.java.library.components.Button;
import com.playwright.java.library.components.Element;
import com.playwright.java.library.components.cart.CartItemsList;
import com.playwright.java.library.components.inventory.InventoryList;
import com.playwright.java.library.components.TextBox;

import javax.inject.Inject;

public abstract class WebPage {

  protected Page page;

  @Inject
  public WebPage(Page page) {
    this.page = page;
  }

  public Element element(String selector) {
    return new Element(page, selector);
  }

  public TextBox textBox(String selector) {
    return new TextBox(page, selector);
  }

  public Button button(String buttonText) {
    return new Button(page, buttonText);
  }

  public InventoryList inventoryList() {
    return new InventoryList(page);
  }

  public CartItemsList cartItemsList() {
    return new CartItemsList(page);
  }

  protected <T extends WebPage> T createWebPageInstance(Class<T> tClass) {
    try {
      return tClass.getDeclaredConstructor(Page.class).newInstance(page);
    } catch (Exception ex) {
      throw new RuntimeException("Error creating Webpage Instance.");
    }
  }
}
