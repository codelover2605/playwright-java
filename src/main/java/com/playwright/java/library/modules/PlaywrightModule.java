package com.playwright.java.library.modules;

import com.google.inject.AbstractModule;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.java.library.providers.BrowserContextProvider;
import com.playwright.java.library.providers.BrowserProvider;
import com.playwright.java.library.providers.PlaywrightPageProvider;
import com.playwright.java.library.providers.PlaywrightProvider;

public class PlaywrightModule extends AbstractModule {

  @Override
  public void configure() {
    bind(Playwright.class).toProvider(PlaywrightProvider.class).asEagerSingleton();
    bind(Browser.class).toProvider(BrowserProvider.class).asEagerSingleton();
    bind(BrowserContext.class).toProvider(BrowserContextProvider.class).asEagerSingleton();
    bind(Page.class).toProvider(PlaywrightPageProvider.class).asEagerSingleton();
  }
}
