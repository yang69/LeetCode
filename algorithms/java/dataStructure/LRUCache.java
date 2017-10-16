package dataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Yang on 2017/10/14.
 */
public class LRUCache {
    private final LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
