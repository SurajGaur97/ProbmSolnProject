package programsProblem.target75.matrix;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes1(matrix);

        printElement(matrix);
    }

    public void setZeroes1(int[][] matrix){
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for(int i = 0;i < matrix.length;i++)
            for(int j = 0;j < matrix[0].length;j++)
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }

        for(int i = 0;i < matrix.length;i++)
            for(int j = 0;j < matrix[0].length;j++)
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
    }

    //By me
    public void setZeroes(int[][] matrix){
        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    List<Integer> crt = new ArrayList<>();
                    crt.add(i);
                    crt.add(j);
                    lst.add(crt);
                }
            }
        }

        for(List<Integer> l : lst){
            makeZero(l.get(0), l.get(1), matrix);
        }
    }

    private void makeZero(int x, int y, int[][] matrix){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(i == x || j == y)
                    matrix[i][j] = 0;
            }
        }
    }
}
