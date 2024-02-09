package programsProblem.practice.array;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class SortedSquares {
    public void driverMethod() {
//        int[] nums = new int[]{-4,-1,0,2,10};
        int[] nums = new int[]{-7, -3, 0, 2, 3, 7, 11};
        for (Integer num : sortedSquares(nums)){
            System.out.print(num + ", ");
        }
    }

    public int[] sortedSquares1(int[] nums) {
        IntUnaryOperator squareOfNum = (x) -> x * x;
        int[] nums1 = Arrays.stream(nums).map(squareOfNum).sorted().toArray();
        return nums1;
    }

    public int[] sortedSquares(int[] nums) {
        int[] resNums = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;

        while (i <= j){
            if(nums[i] * nums[i] < nums[j] * nums[j]){
                resNums[k] = nums[j] * nums[j];
                j--;
            } else {
                resNums[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }
        return resNums;
    }
}
