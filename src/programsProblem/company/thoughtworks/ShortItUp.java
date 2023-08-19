package programsProblem.company.thoughtworks;

import java.util.HashMap;
import java.util.Map;

/**
 * Shorting the arr which contains 0,1 and 2 without using any shorting algo and the space should in-place
 */
//2,0,1,0,2,0,0,2,1,1
public class ShortItUp {
    public  void doSort1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if(!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        int i = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getKey() == 0 && entry.getValue() != 0) {
                while(i < entry.getValue()) {
                    nums[i] = 0;
                    i++;
                }
                count = entry.getValue();
                map.put(entry.getKey(), 0);
            } else if (entry.getKey() == 1 && entry.getValue() != 0) {
                while(i < count + entry.getValue()) {
                    nums[i] = 1;
                    i++;
                }
                count += entry.getValue();
                map.put(entry.getKey(), 0);
            } else if(entry.getKey() == 2 && entry.getValue() != 0){
                while(i < count + entry.getValue()) {
                    nums[i] = 2;
                    i++;
                }
                map.put(entry.getKey(), 0);
            }
        }
    }

    public  void doSort(int[] nums) {
        int start = 0, end = nums.length - 1, current = 0;

        while(current <= end) {
            if(nums[current] == 2) {
                nums[current] = nums[end];
                nums[end] = 2;
                end--;
            } else if(nums[current] == 1) {
                current++;
            }
            else {
                nums[current] = nums[start];
                nums[start] = 0;
                current++;
                start++;
            }
        }
    }
}
