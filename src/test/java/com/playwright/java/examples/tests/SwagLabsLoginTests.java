package com.playwright.java.examples.tests;

import com.playwright.java.examples.pages.LoginPage;
import com.playwright.java.examples.pages.ProductsPage;
import com.playwright.java.library.testbases.WebTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsLoginTests extends WebTest {

  @Test
  public void shouldValidateLoginWithValidCredentials() {
    webPageInstance(LoginPage.class)
        .login("standard_user", "secret_sauce", ProductsPage.class)
        .validateOnProductsPage();
  }

  @Test
  public void shouldValidateLoginWithInValidCredentials() {
    var errorMessage =
        webPageInstance(LoginPage.class)
            .login("standard_user", "standard_user", LoginPage.class)
            .getErrorMessage();

    Assert.assertEquals(
        errorMessage, "Epic sadface: Username and password do not match any user in this service");
  }
}
