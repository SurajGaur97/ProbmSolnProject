package programsProblem.practice.dp.gfg;

//Similar to 'Subset Sum' Problem
public class CoinChange {
    public void driverMethod() {
        int[] coin = new int[]{1,2,3};
        int sum = 4;
//        System.out.println(coinChange1(coin, sum, 3));

        Integer[][] dp = new Integer[coin.length + 1][sum + 1];
        System.out.println(coinChange2(coin, sum, 3, dp));
    }

    //Tabulation Approach
    private int coinChange3(int[] coin, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];

        //base condition
        for(int i = 0; i <= n; i++) {
            for(int j = 0; i <= sum; j++) {
                if(i == 0)
                    dp[i][j] = 1;
                if(j == 0)
                    dp[i][j] = 1;
            }
        }
        return 0;
    }

    //Memoization Approach | Recursive Optimised Solution
    private int coinChange2(int[] coin, int sum, int n, Integer[][] dp) {
        if(sum == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][sum] != null) return dp[n][sum];

        int include = 0, exclude = 0;
        if(coin[n - 1] <= sum) {
            include = coinChange2(coin, sum - coin[n - 1], n, dp);
            exclude = coinChange2(coin, sum, n - 1, dp);
            dp[n][sum] = include + exclude;
        }
        else {
            dp[n][sum] = coinChange2(coin, sum, n - 1, dp);
        }
        return dp[n][sum];
    }

    //Aditya Verma's Algo technique
    private int coinChange(int[] coin, int sum, int n) {
        if(sum == 0) return 1;
        if(n == 0) return 0;

        int include = 0, exclude = 0;
        if(coin[n - 1] <= sum) {
            include = coinChange(coin, sum - coin[n - 1], n);
            exclude = coinChange(coin, sum, n - 1);
            return include + exclude;
        }
        else {
            return coinChange(coin, sum, n - 1);
        }
    }

    //GFG Technique
    private int coinChange1(int[] coin, int sum, int n) {
        if(sum == 0) return 1;
        if(n == 0 || sum < 0) return 0;

        int include = 0, exclude = 0;
        include = coinChange1(coin, sum - coin[n - 1], n);
        exclude = coinChange1(coin, sum, n - 1);

        return include + exclude;
    }

}
