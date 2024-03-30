package programsProblem.practice.array.pathFinding;

import programsProblem.practice.common.DriverClass;

public class UniquePaths implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        System.out.println(uniquePaths(23, 12));
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        //Initialising for easiness of applying and using memoization
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                memo[i][j] = -1;
            }
        }

        return solve(m, n, 0, 0, memo);
    }

    private int solve(int m, int n, int row, int col, int[][] memo) {
        if(row == m - 1 && col == n - 1)
            return 1;

        if(row >= m || col >= n)
            return 0;

        //Utilisation of memo/dp variable otherwise it will calculate again the calculated value.
        if(memo[row][col] != -1)
            return memo[row][col];

        memo[row][col] = solve(m, n, row + 1, col, memo) + solve(m, n, row, col + 1, memo);

        return memo[row][col];
    }
}
