package programsProblem.practice.array;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubArraysOfSizeK implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;

        printElement(solve1(arr, k));
    }

    private List<Integer> solve1(int[] arr, int k){
        int sum = 0, i = 0, j = 3;
        List<Integer> ans = new ArrayList<>();

        for(int l = 0;l < k;l++)
            sum += arr[l];
        ans.add(sum);

        while (j < arr.length){
            sum = sum - arr[i++] + arr[j++];
            ans.add(sum);
        }

        return ans;
    }

    private List<Integer> solve(int[] arr, int k){
        int sum = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0;i < k;i++)
            sum += arr[i];

        ans.add(sum);

        for(int i = k;i < arr.length;i++){
            sum = sum + arr[i] - arr[i - k];
            ans.add(sum);
        }

        return ans;
    }
}
