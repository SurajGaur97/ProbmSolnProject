package programsProblem.leetcodeMustDo.array;

public class MoveAllZeroToEnd {
	
	public int[] moveZeroes(int[] nums) {
		int k = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[k] = nums[i];
				k++;
			}
		}
		
		for(int i = k; i < nums.length; i++) {
			nums[i]= 0;		
		}
		
		return nums;
	}
	
	public int[] moveAllZeroToEnd(int[] nums) {
		int indx = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {				
				for(int j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
					indx = j;
				}
				nums[indx + 1] = 0;
			}
		}
		
		return nums;
	}
}
