package programsProblem.practice.array.matrix;

import programsProblem.utils.DriverClass;

public class Rotate90Degree implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[][] arr1 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate90Degree(arr1);

        printElement(arr1);
    }

    private void rotate90Degree(int[][] a) {
        int len = a[0].length;
        for (int i = 0;i < len;i++){
            for (int j = i + 1;j < len;j++){
                if(i != j){
                    int tmp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = tmp;
                }
            }
        }

        for (int i = 0;i < len;i++){
            for (int j = 0;j < len / 2;j++){
                int tmp = a[i][j];
                a[i][j] = a[i][len - j - 1];
                a[i][len - j - 1] = tmp;
            }
        }
    }
}
