package com.example.demo.newcache.hash.impl;

import com.example.demo.newcache.hash.HashGenerateStrategy;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 *  使用Guava 的md5算法的java实现
 * @author apple
 * @date 2020/7/14 7:51 下午
 */
public class GuavaMd5 implements HashGenerateStrategy {
    @Override
    public long generate(String key) {
        HashFunction hashFunction = Hashing.md5();
        return hashFunction.hashUnencodedChars(key).asLong();
    }
}
