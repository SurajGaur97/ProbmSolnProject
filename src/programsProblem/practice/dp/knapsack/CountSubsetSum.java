package programsProblem.practice.dp.knapsack;

public class CountSubsetSum {
    //Recursive Method
    public int getCount(int[] arr, int sum, int size) {
        //base condition
        if(size == 0)
            return 0;
        if(sum == 0)
            return 1;

        //choice diagram
        if(arr[size - 1] <= sum)
            return getCount(arr, sum - arr[size - 1], size - 1) + getCount(arr, sum, size - 1);
        else
            return getCount(arr, sum, size - 1);
    }

    //Iterative Method
    public int getCount1(int[] arr, int sum, int size) {
        int[][] t = new int[size + 1][sum + 1];

        //Base condition
        for(int i = 0; i < size + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }

        //Choice diagram
        for(int i = 1; i < size + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] <= j)
                    t[i][j] = t[i][j - arr[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[size][sum];
    }
}
