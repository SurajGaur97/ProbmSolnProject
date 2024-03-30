package programsProblem.practice.array.pathFinding;

import programsProblem.practice.common.DriverClass;

public class FindNoOfPathsInMatrix implements DriverClass<Integer> {
    static int[][] memo;

    static int numOfPathsToDest(int n) {
        FindNoOfPathsInMatrix.memo = new int[n][n];
//        return solve(n, 0, 0);     //old one solved

        return solve1(n, n - 1, 0); //by me
    }

    static int solve(int n, int r, int c) {
        if(r == n - 1 && c == n - 1) return 1;
        if(r < c || r >= n || c >= n) return 0;
        if(memo[r][c] != 0) return memo[r][c];
        memo[r][c] = solve(n, r + 1, c) + solve(n, r, c + 1);
        return memo[r][c];
    }

    //by me
    static int solve1(int len, int row, int col) {
        if(row == 0 && col == len - 1)
            return 1;

        if(row < col || row >= len || col >= len)   //if boundary exceed i.e. pointer is in second half triangle, less than row, or less than column.
            return 0;

        if(memo[row][col] != 0)
            return memo[row][col];

        memo[row][col] = solve1(len, row + 1, col) + solve1(len, row, col + 1);
        return memo[row][col];
    }

    @Override
    public void driverMethod() {

    }
}
