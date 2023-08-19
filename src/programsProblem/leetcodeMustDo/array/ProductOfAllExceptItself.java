package programsProblem.leetcodeMustDo.array;

import java.util.ArrayList;
import java.util.List;

public class ProductOfAllExceptItself {
	
	public List<Integer> getProductOfAllExceptItself1(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int multiply = 1;
		
		for(int i = 0; i < nums.length; i ++) {
			multiply *= nums[i];
		}
		
		for(int i = 0; i < nums.length; i++) {
			res.add(multiply / nums[i]);
		}
		
		return res;
	}
	
	public List<Integer> getProductOfAllExceptItself(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < nums.length; i++) {
			int resNo = 1;
			for(int j = 0; j < nums.length; j++) {
				if(i != j) {
					resNo *= nums[j];
				}
			}
			res.add(resNo);
		}
		
		return res;
	}
}
