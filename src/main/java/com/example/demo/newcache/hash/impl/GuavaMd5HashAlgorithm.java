package com.example.demo.newcache.hash.impl;

import com.example.demo.newcache.hash.HashAlgorithm;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.security.Key;

/**
 * @Description 通过Guava 生成hash值
 * @Author apple
 * @Date 2020/7/14 7:51 下午
 */
public class GuavaMd5HashAlgorithm implements HashAlgorithm {
    @Override
    public long generate(String key) {
        HashFunction hashFunction = Hashing.md5();
        return hashFunction.hashUnencodedChars(key).asLong();
    }
}
