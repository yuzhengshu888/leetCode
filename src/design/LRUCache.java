package design;

import java.util.*;

/**
 * @description: 146. LRU 缓存机制
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 15:38
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        int a1 = lruCache.get(1);
//        lruCache.put(3, 3);
//        int a2 = lruCache.get(2);
//        lruCache.put(4, 4);
//        int a3 = lruCache.get(1);
//        int a4 = lruCache.get(3);
//        int a5 = lruCache.get(4);
//        ["LRUCache","get","put","get","put","put","get","get"]
//                [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        int a1 = lruCache.get(2);
        lruCache.put(2, 6);
        int i2 = lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        int i1 = lruCache.get(1);
        int i = lruCache.get(2);
        System.out.println("...");
    }
}
