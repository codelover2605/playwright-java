package com.playwright.java.library.testbases;

import com.google.inject.Guice;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.playwright.java.library.modules.PlaywrightModule;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.playwright.java.library.cache.InjectorCacheProvider.injectorsCache;

public class WebTest {

  @BeforeMethod(alwaysRun = true)
  public void init() {
    var injector = Guice.createInjector(new PlaywrightModule());
    injectorsCache().putInjector(injector);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    injectorsCache().getInstance(BrowserContext.class).close();
    injectorsCache().getInstance(Playwright.class).close();
  }
}
