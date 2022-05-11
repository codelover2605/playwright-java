package com.playwright.java.examples;

import com.microsoft.playwright.Page;
import com.playwright.java.library.testbases.WebTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import java.util.List;

import static com.playwright.java.library.cache.InjectorCacheProvider.injectorsCache;

public class PlaywrightTests extends WebTest {

  @Test(description = "Validate Nav Bar Title upon navigating to respective language binding")
  public void validateNavBarTitle() {
    var playwrightPage = injectorsCache().getInstance(Page.class);
    List.of(
            Pair.of("https://playwright.dev/java/", "Playwright for Java"),
            Pair.of("https://playwright.dev/python/", "Playwright for Python"),
            Pair.of("https://playwright.dev/dotnet/", "Playwright for .NET"))
        .forEach(
            urlTitlePair -> {
              var url = urlTitlePair.first();
              var expectedTitle = urlTitlePair.second();

              playwrightPage.navigate(url);
              var navBarTitle = playwrightPage.textContent("[class='navbar__title']");
              Assert.assertEquals(navBarTitle, expectedTitle);
            });
  }

  @Test
  public void validateGitHubLinkIsPresentInTheNavBar() {
    var playwrightPage = injectorsCache().getInstance(Page.class);
    playwrightPage.navigate("https://playwright.dev");
    var githubRepoLinkPresent =
        playwrightPage.locator("[aria-label= 'GitHub repository']").count() == 1;
    Assert.assertTrue(githubRepoLinkPresent);
  }
}
