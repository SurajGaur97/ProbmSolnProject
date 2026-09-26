package programsProblem.practice.implementation;

import programsProblem.utils.DriverClass;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LruCacheNew implements DriverClass<String> {

    @Override
    public void driverMethod() {
        LruCacheNew lRUCache = new LruCacheNew(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    Map<Integer, LruValue> cache;
    int capacity;

    public LruCacheNew() {}
    public LruCacheNew(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        LruValue lruValue = cache.getOrDefault(key, null);
        if(lruValue != null) {
            lruValue.setOrder(lruValue.getOrder() + 1);
            cache.put(key, lruValue);
            return lruValue.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.size() < this.capacity) {
            LruValue lruValue = new LruValue(value, 0);
            cache.put(key, lruValue);
        } else {
            Optional<Map.Entry<Integer, LruValue>> minEntry = cache
                    .entrySet().stream()
                    .min(Comparator.comparingInt(e -> e.getValue().getOrder()));

            minEntry.ifPresent(entry -> {
                cache.remove(entry.getKey());
                cache.put(key, new LruValue(value, 0));
            });
        }
    }

    static class LruValue {
        int value;
        int order;

        public LruValue(int value, int order) {
            this.value = value;
            this.order = order;
        }

        public int getValue() {
            return this.value;
        }

        public int getOrder() {
            return this.order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
}
