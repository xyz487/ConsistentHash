package com.zxy.learn.cache;

/**
 *
 * @author zhangxy
 * @date 2020-07-15 17:29:48
 */
public interface Cachable {
    String get(String key);
    void put(String key, String value);
}
