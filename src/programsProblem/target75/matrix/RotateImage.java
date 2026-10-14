package programsProblem.target75.matrix;

import programsProblem.utils.DriverClass;

public class RotateImage implements DriverClass<Integer> {

    @Override
    public void driverMethod() {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
