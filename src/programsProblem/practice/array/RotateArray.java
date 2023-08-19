package programsProblem.practice.array;

import java.util.*;

public class RotateArray {
    public int[] getRotatedArray(int[] nums, int k) {
        k = k % nums.length;

        //eg k = 2
        //reverse first nums.length - k - 1 ie 3 elements in the array.
        reverseArr(nums, 0, nums.length - k - 1);

        //then reverse first k ie 2 elements from nums.length - k index in the array.
        reverseArr(nums, nums.length - k, nums.length - 1);

        //at last reverse whole array then it will reflect to the resulting array.
        reverseArr(nums, 0, nums.length - 1);

        return nums;
    }

    private void reverseArr(int[] nums, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
