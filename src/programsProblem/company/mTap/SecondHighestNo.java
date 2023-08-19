package programsProblem.company.mTap;

public class SecondHighestNo {
	/**
	 * Question: Find secind highest no from an array of nos.
	 * Algo: First take 2 int varaible called max1 and max2.
	 * Assign max1 with maximum value and max2 with less than max1 value of first two element in the array.
	 * Now iterate the array from index 2 and update max2 if max2 < nums[i] if there is a condition if 
	 * max1 < nums[i] then just update the max2 first with the old max1 vlaue and then update max1 value with
	 * the nums[i].
	 * To protect from duplicates values in second condition max2 < nums[i] puth one more condition is that
	 * max1 != nums[i], it will protect with the duplicate value to put in both the variable max1 and max2.
	 * @param nums
	 * @return
	 */
	
	public int getSecondMax(int[] nums) {
		
		int max1 = nums[0] < nums[1] ? nums[1] : nums[0];
		int max2 = nums[0] > nums[1] ? nums[1] : nums[0];
		
		for(int i = 2; i < nums.length; i++) {
			if(max1 < nums[i]) {
				max2 = max1;
				max1 = nums[i];
			}
			else if(max2 < nums[i] && max1 != nums[i]) {
				max2 = nums[i];
			}
		}
		return max2;
	}
}
