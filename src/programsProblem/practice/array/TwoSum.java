package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{2,7,11,15}; int target = 9;    //[0,1]
        int[] nums = new int[]{3, 2, 4};
        int target = 6;  //[1,2]
//        int[] nums = new int[]{3,2,5,7,1,4}; int target = 6;  //[1,2]
//        int[] nums = new int[]{3,3}; int target = 6;  //[0,1]
//        int[] nums = new int[]{2,3,4,1,5,6}; int target = 7;  //3

        printElement(twoSum(nums, target));
//        printElement(twoSumCountPairs(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length;i++){
            if(!map.containsKey(target - nums[i])) map.put(nums[i], i);
            else return new int[]{i, map.get(target - nums[i])};
        }

        return new int[]{};
    }

    private int twoSumCountPairs(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, resCount = 0;

        while (l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                resCount++;
                l++;
                r--;
            } else if(sum < target) l++;
            else if(sum > target) r--;
        }
        return resCount;
    }

}
