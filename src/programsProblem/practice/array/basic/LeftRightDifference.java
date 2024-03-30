package programsProblem.practice.array.basic;

import programsProblem.practice.common.DriverClass;

import java.util.Arrays;

public class LeftRightDifference implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{10, 4, 8, 3};
        printElement(leftRightDifference(nums));
    }

    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0, rightSum = 0, ndx = 0;
        int[] resNums = new int[nums.length];
        int sum = Arrays.stream(nums).sum();

        while (ndx < nums.length){
            leftSum = 0;
            rightSum = 0;
            for (int i = ndx + 1;i < nums.length;i++){
                leftSum += nums[i];
            }
            for (int i = ndx - 1;i >= 0;i--){
                rightSum += nums[i];
            }
            System.out.println(leftSum + " " + rightSum);
            resNums[ndx] = Math.abs(leftSum - rightSum);
            ndx++;
        }

        return resNums;
    }
}
