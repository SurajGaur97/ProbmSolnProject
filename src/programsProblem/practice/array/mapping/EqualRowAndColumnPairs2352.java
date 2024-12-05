package programsProblem.practice.array.mapping;

import programsProblem.utils.DriverClass;

public class EqualRowAndColumnPairs2352 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        printElement(equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int lclCount = 0, pirCount = 0;

        for(int i = 0; i < n; i++) {
            int k = 0;
            for(int j = 0; j < n * n; j++) {
                if(grid[i][j % n] == grid[j % n][k]){
                    lclCount++;
                }
                if(j % n == n - 1) {
                    k++;
                    if(lclCount == n) pirCount++;
                    lclCount = 0;
                }
            }
        }
        return pirCount;
    }
}
