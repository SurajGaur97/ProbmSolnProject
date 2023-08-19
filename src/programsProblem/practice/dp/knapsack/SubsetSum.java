package programsProblem.practice.dp.knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//01-07-2023
public class SubsetSum {
    //Recursive Method

    //Memoization by ChatGPT3
    //Memoization table to store computed results
    static Map<String, Boolean> memo = new HashMap<>();
    public boolean subSetSum3(int[] nums, int target, int index) {
        // Base case: if target is 0, subset is found
        if (target == 0) {
            return true;
        }

        // Base case: if index reaches negative or target becomes negative, no subset found
        if (index == 0) {
            return false;
        }

        // Check if result is already memoized
        String key = index + ":" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Include the current element or exclude it and move to the next element
        boolean include = subSetSum3(nums, target - nums[index - 1], index - 1);
        boolean exclude = subSetSum3(nums, target, index - 1);

        if(nums[index - 1] <= target) {
            boolean result = include || exclude;

            // Memoize the result and return
            memo.put(key, result);
            return memo.get(key);
        }
        else {
            memo.put(key, exclude);
            return memo.get(key);
        }
    }

    public boolean subSetSum1(int[] arr, int sum, int n) {
        if(n == 0) {
            return false;
        }
        if(sum == 0) {
            return true;
        }

        if(arr[n - 1] <= sum) {
            return subSetSum1(arr, sum - arr[n - 1], n - 1) || subSetSum1(arr, sum, n - 1);
        }
        else {
            return subSetSum1(arr, sum, n - 1);
        }
    }

    //Iterative Method
    public boolean subSetSum(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];

        //base condition
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        //choice diagram
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
