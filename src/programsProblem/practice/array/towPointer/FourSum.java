package programsProblem.practice.array.towPointer;

import programsProblem.utils.DriverClass;

import java.util.*;

public class FourSum implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{1,0,-1,0,-2,2}; int target = 0;
//        int[] nums = new int[]{2,2,2,2,2}; int target = 8;
//        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000}; int target = -294967296;
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        long target = 4000000000L;
        System.out.println(fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, long target) {
        Arrays.sort(nums);
        Set<List<Integer>> resList = new HashSet<>();

        for (int i = 0;i < nums.length - 1;i++){
            for (int j = i + 1;j < nums.length;j++){
                int l = j + 1, r = nums.length - 1;

                while (l < r){  //l < r not equal(=) because we need distinct nums elements.
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];

                    if(sum == target){
                        resList.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1]) l++;    //if repetitive value comes then increase l by 1
                        while (l < r && nums[r] == nums[r - 1]) r--;    //if repetitive value comes then decrease r by 1

                        l++;
                        r--;
                    } else if(sum < target) l++;
                    else r--;
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1])
                    j++;  //if repetitive value comes then increase j by 1
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;  //if repetitive value comes then increase i by 1
        }
        return new ArrayList<>(resList);
    }
}
