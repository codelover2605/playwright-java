package com.playwright.java.library.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Injector;

import java.time.Duration;

public class InjectorsCache {

  private LoadingCache<String, Injector> cache;

  public InjectorsCache() {
    cache =
        CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(Duration.ofHours(3))
            .build(
                new CacheLoader<>() {
                  @Override
                  public Injector load(String key) {
                    return cache.getIfPresent(key);
                  }
                });
  }

  public void putInjector(Injector value) {
    cache.put(currentThreadId(), value);
  }

  public Injector getInjector() {
    return cache.getIfPresent(currentThreadId());
  }

  private String currentThreadId() {
    return String.valueOf(Thread.currentThread().getId());
  }

  public <T> T getInstance(Class<T> tClass) {
    return getInjector().getInstance(tClass);
  }
}
