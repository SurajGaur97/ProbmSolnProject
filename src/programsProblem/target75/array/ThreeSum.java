package programsProblem.target75.array;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum implements DriverClass<Integer> {

	/***
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0. Notice that the solution set must not contain duplicate
	 * triplets.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
	 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
	 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
	 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
	 * output and the order of the triplets does not matter.
	 */


	@Override
	public void driverMethod() {
		int[] nums = new int[]{-1,0,1,2,-1,-4};
		int target = 0;

		System.out.println(threeSumNewSol(nums));
	}

	public List<List<Integer>> threeSumNewSol(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();
		int r = nums.length - 1;
		for(int i = 0; i < nums.length; i++) {
			int l = i + 1;

			while(l < r) {
				int sum = nums[i] + nums[l] + nums[r];

				if(sum == 0) {
					while(l < r && nums[l] == nums[l+1])
						l++;
					while(l < r && nums[r] == nums[r-1])
						r--;

					res.add(List.of(nums[i], nums[l], nums[r]));
					l++; r--;
				}
				else if(sum < 0)
					l++;
				else if(sum > 0)
					r--;
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();

		if (nums.length < 3 || nums[0] > 0)
			return new ArrayList<>(result);

		for (int i = 0; i < nums.length; i++) {
			int low = i + 1, high = nums.length - 1;

			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];

				if (sum == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[low]);
					temp.add(nums[high]);
					result.add(temp);
					low++;
					high--;
				}

				else if (sum > 0) {
					high--;
				}

				else {
					low++;
				}
			}
		}
		return new ArrayList<>(result);
	}

	public List<List<Integer>> threeSumBestSoln(int[] nums) {
		Arrays.sort(nums);
		
		List<List<Integer>> ans = new LinkedList<>();
		for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
			
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				
				int sum = nums[left] + nums[right] + nums[i];
				if (sum == 0) {
					
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				} 
				else if (sum < 0) {
					left++;
				} 
				else if (sum > 0) {
					right--;
				}
			}
		}
		return ans;
	}

}
