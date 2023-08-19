package programsProblem.target75.array;

public class MaximumProductSubarray {
	
	/***
	 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the 
	 * largest product, and return the product. The test cases are generated so that the answer will fit in a 
	 * 32-bit integer. A subarray is a contiguous subsequence of the array.
	 * 
	 * Example 1:
	 * Input: nums = [2,3,-2,4]
	 * Output: 6
	 * Explanation: [2,3] has the largest product 6.
	 * 
	 * @param nums
	 * @return int
	 */
	public int maxProduct(int[] nums) {
        int product = 1, max = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
        	product *= nums[i];
        	
        	if(product == 0)
        		product = 1;
        	
        	if(product > max)
        		max = product;
        }
        
        product = 1;
        
        for(int i = nums.length - 1; i >= 0; i--) {
        	product *= nums[i];
        	
        	if(product == 0)
                product = 1;
        	
            if(product > max)
                max = product;
        }
        
        return max;
    }
}
