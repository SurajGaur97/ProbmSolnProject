package programsProblem.target75.matrix;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0;
        int r = matrix[0].length;
        int t = 0;
        int d = matrix.length;
        List<Integer> res = new ArrayList<>();

        while(t == d && l == r) {
            for(int i = l; i < r; i++)
                res.add(matrix[t][i]);
            t++;

            for(int i = t; i < d; i++)
                res.add(matrix[i][r - 1]);
            r--;

            for(int i = r - 1; i >= l; i--)
                res.add(matrix[d - 1][i]);
            d--;

            for(int i = d - 1; i >= t; i--)
                res.add(matrix[i][l]);
            l++;
        }

        return res;
    }
}
