package programsProblem.practice.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        Integer floorKey = map.get(key).floorKey(timestamp);
        if(floorKey == null)
            return "";

        return map.get(key).get(floorKey);
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
}
