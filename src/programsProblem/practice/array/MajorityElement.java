package programsProblem.practice.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i], 1);
            else
                hm.put(nums[i], hm.get(nums[i]) + 1);
        }

        int max = hm.get(nums[0]);
        int res = -1;
        for(int i = 0; i < nums.length; i++) {
            if(max < hm.get(nums[i]))
                max = hm.get(nums[i]);
        }

        for(Map.Entry entry: hm.entrySet()) {
            if(max == (int)entry.getValue())
                res = (int)entry.getKey();
        }

        return res;
    }
}
