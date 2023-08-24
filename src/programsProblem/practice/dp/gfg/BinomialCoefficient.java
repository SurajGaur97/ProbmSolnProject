package programsProblem.practice.dp.gfg;

import java.util.Arrays;

public class BinomialCoefficient {
    public void driverMethod() {
//        System.out.println(getBc(4, 2));
//        System.out.println(getBc(5, 2));

        int n = 5, k = 2;
//        int[][] dp = new int[n + 1][k + 1];
//        for(int[] td : dp) {
//            Arrays.fill(td, -1);
//        }
//        System.out.println(getBc1(n , k, dp));

        System.out.println(getBc2(n, k));
    }

    //Tabulation approach
    private int getBc2(int n, int k) {
        int[][] t = new int[n + 1][k + 1];

        //base condition
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if(j == 0)
                    t[i][j] = 1;
                if(i == j)
                    t[i][j] = 1;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
            }
        }

        return t[n][k];
    }

    //Memoization Approach
    private  int getBc1(int n, int k, int[][] dp) {
        if(k > n) return 0;
        if(k == 0 || n == k) return 1;

        if(dp[n][k] != -1) return dp[n][k];

        dp[n][k] = getBc1(n - 1, k - 1, dp) + getBc1(n - 1, k, dp);

        return  dp[n][k];
    }

    //Recursive approach
    private int getBc(int n, int k) {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        return getBc(n - 1, k - 1) + getBc(n - 1, k);
    }
}
