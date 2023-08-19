package programsProblem.practice.dp.gfg;

import java.util.Arrays;

public class FibonacciNumbers {
    //finding nth fibonacci no. with different methods:
    public int driverMethod(int n) {
//        return getNthFibonacci1(n);
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        return getNthFibonacci2(n, dp);
        return getNthFibonacci3(n);
    }

    //memoization method (Bottom-Up approach)
    private int getNthFibonacci3(int n) {
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 1;

        for (int i = 0; i < n - 2; i++) {
            dp[i + 2] = dp[i] + dp[i + 1];
        }
        return dp[n - 1];
    }

    //memoization method (Top-Down approach)
    private int getNthFibonacci2(int n, int[] dp) {
        if(n - 1 == 0 || n - 1 == 1)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        dp[n] = getNthFibonacci2(n - 1, dp) + getNthFibonacci2(n - 2, dp);
        return dp[n];
    }

    //recursive method
    private int getNthFibonacci1(int n) {
        if(n - 1 == 0 || n - 1 == 1)
            return 1;

        return getNthFibonacci1(n - 1) + getNthFibonacci1(n - 2);
    }

    //iterative method:
    private int getNthFibonacci(int n) {
        int a = 1, b = 1;
        for(int  i = 2; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
