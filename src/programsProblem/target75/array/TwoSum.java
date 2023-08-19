package programsProblem.target75.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	
	/***
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they 
	 * add up to target. You may assume that each input would have exactly one solution, and you may not use 
	 * the same element twice. You can return the answer in any order.
	 * 
	 * Example 1:
	 * Input: nums = [2,7,11,15], target = 9
	 * Output: [0,1]
	 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	 * 
	 * @param nums
	 * @param target
	 * @return List(Integer)
	 */
	public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int j = 0; j < nums.length; j++) {
            if(hm.containsKey(target - nums[j])) {
            	return new int[] {hm.get(target - nums[j]), j}; 
            }
            else {
            	hm.put(nums[j], j);
            }
        }
        return null;
    }
	
	public List<Integer> twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int j = 0; j < nums.length; j++) {
            if(!hm.containsKey(target - nums[j])) {
            	hm.put(nums[j], j);
            }
            else {
            	result.add(hm.get(target - nums[j]));
            	result.add(j);
            	break;
            }
        }
        
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
        	res[i] = result.get(i);
        }
        return result;
    }
	
}
