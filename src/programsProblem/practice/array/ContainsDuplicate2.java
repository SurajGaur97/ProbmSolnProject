package programsProblem.practice.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 4, 3, 2, 5, 2};
        System.out.println(containsNearbyDuplicate1(nums, 2));
    }

    private boolean containsNearbyDuplicate1(int[] nums, int k) {
        //https://www.youtube.com/watch?v=1Vl4UCI7FXs
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                int lstIdx = hm.get(nums[i]);

                if(i - lstIdx <= k)
                    return true;
                else
                    hm.put(nums[i], i);

            } else {
                hm.put(nums[i], i);
            }
        }

        return false;
    }

    //By me
    private boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 1;

        while (i < nums.length && j < nums.length) {
            if(nums[i] == nums[j]) {
                int val = (i - j) < 0 ? (j - i) : (i - j);
                if(val <= k) {
                    return true;
                }
            }
            if(j == nums.length - 1) {
                i++;
                j = i;
            }
            j++;
        }

        return false;
    }
}
