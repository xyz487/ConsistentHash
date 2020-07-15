package com.example.demo.newcache.hash.impl;

import com.example.demo.newcache.hash.HashGenerateStrategy;

import java.util.zip.CRC32;

/**
 *  使用Jdk自带 的CRC32算法实现
 * @author apple
 * @date 2020/7/14 7:51 下午
 */
public class JdkCrc32 implements HashGenerateStrategy {
    @Override
    public long generate(String key) {
        CRC32 crc32 = new CRC32();
        crc32.update(key.getBytes());
        return crc32.getValue();
    }
}
