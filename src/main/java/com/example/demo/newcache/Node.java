package com.example.demo.newcache;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache的Server端实现
 * @author zhangxy
 * @date 2020-07-15 17:28:58
 */
@Data
public class Node  implements Cachable {
    private String name;
    private String ip;
    private Map<String, String> map = new HashMap<>();

    public Node(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public void put(String key, String value) {
        map.put(key, value);
    }
}
