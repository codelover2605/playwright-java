package com.playwright.java.examples.pages;

import com.microsoft.playwright.Page;

import javax.inject.Inject;

public abstract class WebPage {

  protected Page page;

  @Inject
  public WebPage(Page page) {
    this.page = page;
  }

  protected <T extends WebPage> T createWebPageInstance(Class<T> tClass) {
    try {
      return tClass.getDeclaredConstructor(Page.class).newInstance(page);
    } catch (Exception ex) {
      throw new RuntimeException("Error creating Webpage Instance.");
    }
  }
}
