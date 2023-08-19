package programsProblem.practice.dp.knapsack;

import java.util.Arrays;

//01-07-2023
//Same as TargetSum
public class CountSubsetSumWithGivenDiff {
    public int getSubsetSum(int[] nums, int diff, int size) {
        int sumOfArr = Arrays.stream(nums, 0, size).sum();

        int sum1 = (sumOfArr + diff) / 2;

        return countSumSetSum(nums, sum1, size);
    }

    //Used Recursive Method
    private int countSumSetSum(int[] nums, int sum, int size) {
        if(sum == 0)
            return 1;
        if(size == 0)
            return 0;

        if(nums[size - 1] <= sum)
            return countSumSetSum(nums, sum - nums[size - 1], size - 1) + countSumSetSum(nums, sum, size - 1);
        else {
            return countSumSetSum(nums, sum, size - 1);
        }
    }
}
