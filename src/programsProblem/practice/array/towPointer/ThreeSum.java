package programsProblem.practice.array.towPointer;

import programsProblem.practice.common.DriverClass;

import java.util.*;

public class ThreeSum implements DriverClass<Integer> {
	@Override
	public void driverMethod() {
//		int[] nums = new int[]{-1,0,1,2,-1,-4};
//		int[] nums = new int[]{0,1,1};
//		int[] nums = new int[]{0,0,0};
//		int[] nums = new int[]{0,0,0,0};
		int[] nums = new int[]{-2, 0, 1, 1, 2};
		int target = 0;

		System.out.println(threeSum2(nums, target));
	}

	//New Solution not optimised than old sol
	public List<List<Integer>> threeSum2(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> resList = new HashSet<>();

		for (int i = 0;i < nums.length;i++){
			int l = i + 1, r = nums.length - 1;

			while (l < r){
				int sum = nums[i] + nums[l] + nums[r];

				if(sum < target){
					l++;
				} else if(sum > target){
					r--;
				} else {
					resList.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
				}
			}
		}
		return new ArrayList<>(resList);
	}

	//Old Solution
	public List<List<Integer>> threeSum1(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> resList = new ArrayList<>();

		for (int i = 0;i < nums.length;i++){
			int left = i + 1, right = nums.length - 1;

			if(i > 0 && nums[i] == nums[i - 1]){
				continue;
			}
			
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if(sum == target){
					resList.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
					left++;
					right--;

					while (left < right && nums[left] == nums[left - 1]){
						left++;
					}
				} else if(sum > 0){
					right--;
				} else if(sum < 0){
					left++;
				}
			}
		}

		return resList;
	}

	//Naive Solution
	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> resList = new ArrayList<>();
		for (int i = 0;i < nums.length - 2;i++){
			for (int j = i + 1;j < nums.length - 1;j++){
				for (int k = j + 1;k < nums.length;k++){
					if(nums[i] + nums[j] + nums[k] == target){
						resList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
					}
				}
			}
		}
		return resList;
	}

}