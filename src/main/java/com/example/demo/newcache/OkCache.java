package com.example.demo.newcache;

import com.example.demo.newcache.hash.impl.GuavaHashAlgorithm;
import com.example.demo.newcache.manager.DefaultDistributedCacheNodeManager;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author apple
 * @Date 2020/7/10 6:30 下午
 */
public class OkCache implements Cachable {
    private DefaultDistributedCacheNodeManager manager;

    public OkCache(DefaultDistributedCacheNodeManager manager) {
        this.manager = manager;
    }

    @Override
    public String get(String key) {
        Node node = manager.lookupNode(key);
        return node.get(key);
    }

    @Override
    public void put(String key, String value) {
        Node node = manager.lookupNode(key);
        node.put(key, value);
    }

    public void info() {
        List<Node> nodes = manager.getAllNode();

        //每台服务器存储kv的数量
        List<Integer> nodeCount = new ArrayList<Integer>();
        nodes.stream().forEach(node -> {
            int num = node.getMap().size();
            nodeCount.add(num);
            System.out.println(String.format("服务器(%s): 存储%d个数据", node.getIp(), num));
        });

        //统计汇总
        final IntSummaryStatistics statistics = nodeCount.stream().mapToInt(Integer::intValue).summaryStatistics();
        long sum = statistics.getSum();
        double average = statistics.getAverage();
        int max = statistics.getMax();
        int min = statistics.getMin();
        int range = max - min;
        double standardDeviation = nodeCount.stream().mapToDouble(n -> Math.abs(n - average)).summaryStatistics().getAverage();
        System.out.println(String.format("总共%d台服务器, kv总数据量：%d个", nodes.size(), sum));
        System.out.println(String.format("平均值：%.2f", average));
        System.out.println(String.format("最大值：%d,（%.2f%%）", max, 100.0 * max / average));
        System.out.println(String.format("最小值：%d,（%.2f%%）", min, 100.0 * min / average));
        System.out.println(String.format("极差：%d,（%.2f%%）", range, 100.0 * range / average));
        System.out.println(String.format("标准差：%.2f,（%.2f%%）", standardDeviation, 100.0 * standardDeviation / average));
    }

    public static void main(String[] args) {
        //定义测试数据
        final int DATA_NUM = 1000_0000;
        final int SERVER_NUM = 100;
        final int VNODE_NUM = 100;

        //构造节点管理器（虚拟节点数+hash算法）
        DefaultDistributedCacheNodeManager nodeManager = new DefaultDistributedCacheNodeManager();
        nodeManager.setVirtualNodeNum(VNODE_NUM);
        nodeManager.setHashAlgorithm(new GuavaHashAlgorithm());

        IntStream.range(0, SERVER_NUM).forEach(i -> nodeManager.addNode(new Node("node" + i, "192.168.0." + i)));

        OkCache okCache = new OkCache(nodeManager);

        System.out.println(String.format("开始存储%d个kv数据", DATA_NUM));
        for (int i = 0; i < DATA_NUM; i++) {
            okCache.put("Name" + i, String.valueOf(Math.random()));
        }
        System.out.println("测试输出一个数据：");
        String key = "Name93939";
        System.out.println(String.format("%s:%s", key, okCache.get(key).toString()));

        System.out.println("打印缓存统计信息如下:");
        okCache.info();
    }
}
