package Que150.LinkedList8;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        //capacity表示最大容量，0.75F是负载因子，true表示按照访问顺序来进行排序
        super(capacity, 0.75F,true);//这个会根据访问顺序进行排序，而不是根据插入顺序排序
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /**这个方法是LinkedHashMap的一个钩子方法，
     * 用于在插入新条目时决定是否移除最旧的条目。在这个实现中，
     * 当缓存的大小超过了设定的capacity时，就会返回true，
     * 表示应该移除最旧的条目（即最少最近使用的条目）
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
