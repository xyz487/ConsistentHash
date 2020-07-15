package com.example.demo.newcache.manager;

import com.example.demo.newcache.Node;

import java.util.List;

/**
 *  分布式缓存接口定义
 * @author apple
 * @date 2020/7/10 6:13 下午
 */
public interface DistributedCacheNodeManager {
    /**
     * 添加节点
     * @author zhangxy
     * @date 2020-07-15 17:30:05
     * @param node
     * @return
     */
    void addNode(Node node);

    /**
     * 查找key存储的Node
     * @author zhangxy
     * @date 2020-07-15 17:30:24
     * @param key
     * @return
     */
    Node lookupNode(String key);

    /**
     * 获取所有node
     * @author zhangxy
     * @date 2020-07-15 18:55:08
     * @return
     */
    List<Node> getAllNode();
}
