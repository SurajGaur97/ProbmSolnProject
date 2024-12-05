package programsProblem.practice.implementation;

import programsProblem.utils.DoublyListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;   //size of cache.
    private final DoublyListNode head;   //Ordering list head
    private final DoublyListNode tail;   //Ordering list tail
    private final Map<Integer, DoublyListNode> cache;   //Cache memory

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DoublyListNode(0, 0);
        this.tail = new DoublyListNode(0, 0);

        //Linking head and tail node
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DoublyListNode node = cache.get(key);   //getting the existing node
            removeNode(node);   //removing from old position
            addToFront(node);   //adding to near head position for marking it as the MRU(Most Recent Used)
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DoublyListNode node = cache.get(key);
//            cache.put(key, node);   //updating the value of cache | Separately we do not need to do it as in next line we are updating the reference by assigning the value to it.
            node.value = value;     //updating ordering list
            removeNode(node);   //removing from old position
            addToFront(node);   //adding to near head position for marking it as the MRU(Most Recent Used)
        } else {
            if(cache.size() == capacity){
                DoublyListNode lruNode = tail.prev; //getting the LRU element
                removeNode(lruNode);    //removing the ele from ordering list
                cache.remove(key);  //removing the ele from cache
            }
            DoublyListNode newNode = new DoublyListNode(key, value);    //creating new ele
            cache.put(key, newNode);    //putting it in cache
            addToFront(newNode);    //adding to MRU position in ordering list
        }
    }

    private void removeNode(DoublyListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(DoublyListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

}
