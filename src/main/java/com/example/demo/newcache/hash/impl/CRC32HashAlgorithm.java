package com.example.demo.newcache.hash.impl;

import com.example.demo.newcache.hash.HashAlgorithm;

import java.util.zip.CRC32;

/**
 * @Description  通过CRC32生成hash值
 * @Author apple
 * @Date 2020/7/14 7:51 下午
 */
public class CRC32HashAlgorithm implements HashAlgorithm {
    @Override
    public long generate(String key) {
        CRC32 crc32 = new CRC32();
        crc32.update(key.getBytes());
        return crc32.getValue();
    }
}
