package com.zxy.learn.cache.hash.impl;

import com.zxy.learn.cache.hash.HashGenerateStrategy;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 *  使用Guava 的sha256算法的java实现
 * @author apple
 * @date 2020/7/14 7:51 下午
 */
public class GuavaSha256 implements HashGenerateStrategy {
    @Override
    public long generate(String key) {
        HashFunction hashFunction = Hashing.sha256();
        return hashFunction.hashUnencodedChars(key).asLong();
    }
}
