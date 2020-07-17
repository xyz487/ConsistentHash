package com.zxy.learn.cache.manager;

import com.zxy.learn.cache.Node;
import com.zxy.learn.cache.hash.HashGenerateStrategy;
import com.zxy.learn.cache.hash.impl.JdkCrc32;
import lombok.Setter;

import java.util.*;

/**
 *  通过Treemap 实现一致性哈希环，使用默认100个虚拟节点来避免一致性哈希算法的数据便宜问题（请看OkCache使用此类管理节点，最终的数据标准差测试结果）
 * @author apple
 * @date 2020/7/14 8:06 下午
 */
public class ConsistentHashDistributedNodeManager implements DistributedNodeManager {
    //虚拟节点数:默认值100
    @Setter  private int virtualNums = 100;
    private List<Node> nodes = new ArrayList<>();
    private SortedMap<Long, Node> hashRing = new TreeMap<>();

    /** hash生成实现: 默认值使用JdkCrc32 */
    @Setter
    HashGenerateStrategy hashGenerateStrategy = new JdkCrc32();

    @Override
    public void addNode(Node node) {
        this.nodes.add(node);
        for (int i = 0; i < virtualNums; i++) {
            String key = String.format("%s_%d", node.getIp(), i);
            long hash= hashGenerateStrategy.generate(key);
            hashRing.put(hash, node);
        }
    }

    @Override
    public Node lookupNode(String key) {
        long hashCode = hashGenerateStrategy.generate(key);

        // 获取key值大于等于hashCode的子环
        SortedMap<Long, Node> tailMap = hashRing.tailMap(hashCode);

        // 顺时针找出最近的Node节点
        long nodeHash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        return hashRing.get(nodeHash);
    }

    @Override
    public List<Node> getAllNode(){
        return this.nodes;
    }
}
