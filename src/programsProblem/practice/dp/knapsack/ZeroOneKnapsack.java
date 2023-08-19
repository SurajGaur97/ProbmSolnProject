package programsProblem.practice.dp.knapsack;

public class ZeroOneKnapsack {
    //Recursive Method
    public int knapsack(int[] wt, int[] val, int c, int n) {

        //base condition
        if(n == 0 || c == 0) {
            return 0;
        }

        //choice diagram
        if (wt[n - 1] <= c) {
            //Max Of (no of ways when (chosen, not-chosen))
            return Math.max(val[n - 1] + knapsack(wt, val, c - wt[n - 1], n - 1), knapsack(wt, val, c, n - 1));
        } else {
            //no of ways when (not-chosen)
            return knapsack(wt, val, c, n - 1);
        }
    }

    //Iterative Method
    public int knapsackIter(int[] wt, int[] val, int c, int n) {
        int[][] t = new int[n + 1][c + 1];

        //base condition
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < c + 1; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        //choice diagram
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if(wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }
                else if(wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][c];
    }
}
