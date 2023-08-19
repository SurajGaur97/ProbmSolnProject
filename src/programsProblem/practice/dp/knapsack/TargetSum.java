package programsProblem.practice.dp.knapsack;
//01-07-2023
//Same as countSubsetSumWithGivenDiff
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sumOfArr = 0;
        for (int num : nums) sumOfArr += num;

        int sum1 = (sumOfArr + target) / 2;

        return countSumSetSum(nums, sum1, nums.length);
    }

    //Used Recursive Method
    private int countSumSetSum(int[] nums, int sum, int size) {
        //base condition
        if(sum == 0)
            return 1;
        if(size == 0)
            return 0;

        //choice diagram
        if(nums[size - 1] <= sum)
            return countSumSetSum(nums, sum - nums[size - 1], size - 1) + countSumSetSum(nums, sum, size - 1);
        else {
            return countSumSetSum(nums, sum, size - 1);
        }
    }
}
