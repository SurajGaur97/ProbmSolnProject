package programsProblem.easyLeetcode;

public class SearchInsertPosition {
    public int searchPosition(int[] nums, int target) {
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
            if(i < nums.length - 1) {
                if(nums[i] < target && target < nums[i + 1]) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}
