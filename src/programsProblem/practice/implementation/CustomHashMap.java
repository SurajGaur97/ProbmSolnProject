package programsProblem.practice.implementation;

import programsProblem.utils.Entry;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private int capacity;
    private List<Entry<K, V>>[] buckets;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new ArrayList[capacity];

        for (int i = 0;i < capacity;i++)
            this.buckets[i] = new ArrayList<>();
    }

    public V get(K key) {
        int hash = hash(key);
        List<Entry<K, V>> bucket = this.buckets[hash & this.capacity];

        for (Entry<K, V> entry : bucket){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        List<Entry<K, V>> bucket = this.buckets[hash & this.capacity];

        for (Entry<K, V> entry : bucket){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        this.size++;

        if((double) size / capacity > LOAD_FACTOR){
            resize();
        }
    }

    private void resize() {
        capacity *= 2;

        List<Entry<K, V>>[] newBuckets = new ArrayList[capacity];
        for (int i = 0;i < capacity;i++)
            newBuckets[i] = new ArrayList<>();

        for (List<Entry<K, V>> bucket : this.buckets){
            for (Entry<K, V> entry : bucket){
                int hash = hash(entry.getKey());
                List<Entry<K, V>> newBucket = newBuckets[hash % capacity];
                newBucket.add(entry);
            }
        }

        this.buckets = newBuckets;
    }

    private int hash(K key) {
        return key.hashCode() & 0x7fffffff;
    }

}
