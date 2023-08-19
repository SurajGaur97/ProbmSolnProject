package programsProblem.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> resList = new ArrayList<>();
		
		for(int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				
				if(sum == 0) {
					resList.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
					left++;
					right--;
					
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				}
				else if(sum > 0) {
					right--;
				}
				else if(sum < 0) {
					left++;
				}
			}
		}
			
		return resList;
	}
}