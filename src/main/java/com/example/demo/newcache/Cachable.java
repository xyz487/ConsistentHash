package com.example.demo.newcache;

public interface Cachable {
    String get(String key);
    void put(String key, String value);
}
