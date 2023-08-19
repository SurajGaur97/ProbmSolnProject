package programsProblem.target75.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	/***
	 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every 
	 * element is distinct.
	 * 
	 * Example 1:
	 * Input: nums = [1,2,3,1]
	 * Output: true
	 * 
	 * @param nums
	 * @return boolean
	 */
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!hs.contains(nums[i])) {
                hs.add(nums[i]);
            }
            else
                return true;
        }
        
        return false;
    }
}
