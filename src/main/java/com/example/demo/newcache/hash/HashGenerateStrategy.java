package com.example.demo.newcache.hash;

/**
 * 哈希生成策略
 * @author apple
 * @date 2020/7/15 3:36 下午
 *
 */
public interface HashGenerateStrategy {
    /**
     * 生成hash值
     * @author zhangxy
     * @date 2020-07-15 17:21:54
     * @param key
     * @return
     */
    long generate(String key);

}
