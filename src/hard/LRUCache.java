package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 /* capacity / );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */
public class LRUCache {

    private int capacity;
    private int size;
    private Queue<Integer> que;
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.que = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        // 判断是否存在
        if (map.containsKey(key)) {
            // 调整队列, 并返回
            if (que.contains(key)){
                que.remove(Integer.valueOf(key));
            }
            que.offer(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key, value);
        }else {
            if (this.size >= this.capacity){
                map.remove(que.poll());
            }else size++;
            map.put(key, value);
        }
        if (que.contains(key)){
            que.remove(Integer.valueOf(key));
        }
        que.offer(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);    // evicts key 2
        cache.put(4, 1);    // evicts key 1
        cache.get(1);       // returns 1
        cache.get(2);       // returns -1 (not found)
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }

}
