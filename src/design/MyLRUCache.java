package design;

import java.util.HashMap;

//146. LRU 缓存机制
public class MyLRUCache {
    static final int START_KEY = -1, LAST_KEY = Integer.MAX_VALUE;

    private final int capacity;

    static class MyNode {
        int key;
        int value;
        MyNode next;
        MyNode before;
    }

    HashMap<Integer, MyNode> map;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        MyNode first = new MyNode();
        MyNode end = new MyNode();
        first.key = START_KEY;
        first.next = end;
        first.value = -1;
        map.put(START_KEY, first);
        end.key = LAST_KEY;
        end.value = -1;
        end.before = first;
        map.put(LAST_KEY, end);
    }

    //尾插节点
    public void insertLastNode(MyNode node) {
        MyNode lastNode = map.get(LAST_KEY);
        MyNode beforeNode = lastNode.before;
        beforeNode.next = node;
        node.before = beforeNode;
        lastNode.before = node;
        node.next = lastNode;
        map.put(beforeNode.key, beforeNode);
        map.put(lastNode.key, lastNode);
    }

    public void deleteNode(MyNode node) {
        MyNode nextNode = node.next;
        MyNode beforeNode = node.before;
        nextNode.before = beforeNode;
        beforeNode.next = nextNode;
        map.put(nextNode.key, nextNode);
        map.put(beforeNode.key, beforeNode);
    }


    public int get(int key) {
        MyNode keyNode = map.get(key);
        if (keyNode == null) {
            return -1;
        } else {
            deleteNode(keyNode);
            insertLastNode(keyNode);
            return keyNode.value;
        }
    }

    public void put(int key, int value) {
        MyNode keyNode = map.get(key);
        if (keyNode != null) {
            deleteNode(keyNode);
            insertLastNode(keyNode);
            keyNode.value = value;
            map.put(key, keyNode);
        } else {
            if (map.size() > capacity + 1) {
                MyNode first = map.get(START_KEY).next;
                deleteNode(first);
                map.remove(first.key);
            }
            keyNode = new MyNode();
            keyNode.key = key;
            keyNode.value = value;
            insertLastNode(keyNode);
            map.put(key, keyNode);
        }
    }

    public static void main(String[] args) {
        MyLRUCache lruCache = new MyLRUCache(2);
        lruCache.put(2, 6);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        int a1 = lruCache.get(2);
        lruCache.put(1, 2);
        lruCache.put(4, 1);
        int a3 = lruCache.get(2);
//        ["LRUCache","get","put","get","put","put","get","get"]
//                [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
//        int a1 = lruCache.get(2);
//        lruCache.put(2, 6);
//        int i2 = lruCache.get(1);
//        lruCache.put(1, 5);
//        lruCache.put(1, 2);
//        int i1 = lruCache.get(1);
//        int i = lruCache.get(2);
        System.out.println("...");
    }
}
