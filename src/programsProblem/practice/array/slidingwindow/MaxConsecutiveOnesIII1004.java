package programsProblem.practice.array.slidingwindow;

import programsProblem.utils.DriverClass;

public class MaxConsecutiveOnesIII1004 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};    //10
//        int k = 3;
        int[] nums = new int[]{0,0,0,1};    //4
        int k = 4;
        printElement(longestOnes(nums, k));
    }

    private int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        while(j < nums.length) {
            if(nums[j] == 0)
                k--;

            if(k < 0) {
                if(nums[i] == 0)
                    k++;
                i++;
            }

            j++;
        }
        return j - i;
    }
}
