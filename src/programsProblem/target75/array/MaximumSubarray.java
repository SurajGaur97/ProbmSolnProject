package programsProblem.target75.array;

public class MaximumSubarray {
	
	/***
	 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has 
	 * the largest sum and return its sum.A subarray is a contiguous part of an array.
	 * 
	 * Example 1:
	 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	 * Output: 6
	 * Explanation: [4,-1,2,1] has the largest sum = 6.
	 * 
	 * @param nums
	 * @return int
	 */
	public int maxSubArray(int[] nums) {
		int sum = 0, max = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
            if(sum < 0) {
                sum =  0;
            }
            sum += nums[i];
            if(sum > max) {
                max = sum;
            }
        }
        
        return max;
    }
}
