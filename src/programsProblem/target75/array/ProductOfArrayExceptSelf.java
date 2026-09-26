package programsProblem.target75.array;

import programsProblem.utils.DriverClass;

public class ProductOfArrayExceptSelf implements DriverClass<Integer> {
	
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
	 */
	@Override
	public void driverMethod() {
		int[] nums = new int[] { 1, 2, 3, 4 };

		printElement(productExceptSelf3(nums));
	}

	public int[] productExceptSelf3(int[] nums) {
		int size = nums.length;
		int[] res = new int[size];

		int[] left = new int[size];
		left[0] = 1;
		int[] right = new int[size];
		right[size - 1] = 1;

		for(int i = 1; i < nums.length; i++) {
			left[i] = nums[i - 1] * left[i - 1];
			System.out.println(left[i]);
		}

		for(int i = size - 2; i >= 0; i--){
			right[i] = nums[i + 1] * right[i + 1];
			System.out.println(right[i]);
		}

		for(int i = 0; i < size; i++)
			res[i] = left[i] * right[i];

		return res;
	}

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
