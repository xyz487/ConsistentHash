package com.example.demo.newcache.hash.impl;

import com.example.demo.newcache.hash.HashGenerateStrategy;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 *  使用Guava 的murmur算法的java实现
 * @author apple
 * @date 2020/7/14 7:51 下午
 */
public class GuavaMurmur3_32 implements HashGenerateStrategy {
    @Override
    public long generate(String key) {
        HashFunction hashFunction = Hashing.murmur3_32();
        return hashFunction.hashUnencodedChars(key).asLong();
    }
}
