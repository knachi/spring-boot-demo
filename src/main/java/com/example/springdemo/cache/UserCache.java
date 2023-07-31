package com.example.springdemo.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserCache {

    private final LoadingCache<String, String> userCache;

    @Autowired
    public UserCache() {
        this.userCache = CacheBuilder.newBuilder()
                // records present in cache for more than specified time will be removed
                .expireAfterWrite(7, TimeUnit.DAYS)
                // maximum specified records at a time
                .maximumSize(100).build(new CacheLoader<>() {
                    @Override
                    public String load(final String key) {
                        return "Default";
                    }
                });
    }

    public void put(final String key, final String value) {
        userCache.put(key, value);
    }

    public String get(final String key) {
        return userCache.getIfPresent(key);
    }
}
