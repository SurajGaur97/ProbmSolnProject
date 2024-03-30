package programsProblem.practice.array.backtracking;

import programsProblem.practice.common.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 3};
        printElement(nextPermutation(nums));
    }

    private List<Integer> nextPermutation(int[] nums) {
        List<Integer> res = new ArrayList<>();
        backTrack(nums, res);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> res) {
        if(res.size() == nums.length) return;

        for (int i = 0;i < nums.length;i++){
            if(res.contains(nums[i])) continue;
            ;
            res.add(nums[i]);
            backTrack(nums, res);
            break;
        }
    }
}
