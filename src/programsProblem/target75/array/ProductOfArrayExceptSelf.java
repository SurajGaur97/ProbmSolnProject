package programsProblem.target75.array;

public class ProductOfArrayExceptSelf {
	
	/***
	 * Given an integer array nums, return an array answer such that answer[i] is equal to the product 
	 * of all the elements of nums except nums[i].
	 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
	 * You must write an algorithm that runs in O(n) time and without using the division operation.
	 * 
	 * Example 1:
	 * Input: nums = [1,2,3,4]
	 * Output: [24,12,8,6]
	 * 
	 * @param nums
	 * @return int[]
	 */
	public int[] productExceptSelf(int[] nums) {
        
		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			result[i] = 1;
			for(int j = 0; j < nums.length; j++) {
				if(i != j) {
					result[i] *= nums[j];
				}
			}
		}
		
		return result;
    }
	
	/***
	 * It fails when there is any zero element in the array.
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf1(int[] nums) {
        int product = 1;
		for(int num: nums) {
			product *= num;
		}
		
		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			result[i] = product/nums[i];
		}
		
		return result;
    }
	
	public int[] productExceptSelf2(int[] nums) {
		int pre = 1, post = 1;
		int[] result = new int[nums.length]; 
		
		for(int i = 0; i < nums.length; i++) {
			result[i] = pre;
			pre = pre * nums[i];
		}
		
		for(int i = nums.length - 1; i >= 0; i--) {
			result[i] = result[i] * post;
			post = post * nums[i];
		}
		
		return result;
	}
}
