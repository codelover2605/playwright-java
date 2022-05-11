package com.playwright.java.library.cache;

import java.util.Objects;

public class InjectorCacheProvider {

  private static volatile InjectorsCache cache;

  public static InjectorsCache injectorsCache() {
    if (Objects.isNull(cache)) {
      synchronized (InjectorCacheProvider.class) {
        if (Objects.isNull(cache)) {
          cache = new InjectorsCache();
        }
      }
    }

    return cache;
  }
}
