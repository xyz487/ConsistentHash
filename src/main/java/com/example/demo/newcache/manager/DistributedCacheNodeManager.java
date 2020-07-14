package com.example.demo.newcache.manager;

import com.example.demo.newcache.Node;

/**
 * @Description 分布式缓存接口定义
 * @Author apple
 * @Date 2020/7/10 6:13 下午
 */
public interface DistributedCacheNodeManager {
    void addNode(Node node);
    Node lookupNode(String key);
}
