package programsProblem.practice.dp.knapsack;

//01-07-2023
public class CountSubsetSumWithGivenSum {
    public int countSubSetSum(int[] nums, int sum, int size) {
        if(sum == 0)
            return 1;
        if(size == 0)
            return 0;

        if(nums[size - 1] <= sum)
            return countSubSetSum(nums, sum - nums[size - 1], size - 1) + countSubSetSum(nums, sum, size - 1);
        else {
            return countSubSetSum(nums, sum, size - 1);
        }
    }
    public int countSubSetSum1(int[] nums, int sum, int size) {
        int[][] t = new int[size + 1][sum + 1];

        //Base condition
        for(int i = 0; i < size + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }

        //Choice Diagram
        for(int i = 1; i < size + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[size][sum];
    }
}
