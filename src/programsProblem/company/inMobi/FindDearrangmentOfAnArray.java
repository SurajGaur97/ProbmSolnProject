package programsProblem.company.inMobi;

public class FindDearrangmentOfAnArray {
    public int findDearrangment1(int n) {
        int max = 1000000007;   //for large value of integer
        //Base condition
        if(n == 0) return 1;
        else if(n == 1) return 0;

        //Choice diagram
        else
            return ((n - 1) * (findDearrangment1(n - 1) + findDearrangment1(n - 2))) % max;
    }
    public int findDearrangment(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1L;
        dp[1] = 0L;

        if(n == 0 || n == 1) return (int)dp[n];
        int max = 1000000007;
        for(int i = 2; i < n + 1; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % max;
        }

        return (int)dp[n];
    }
}
