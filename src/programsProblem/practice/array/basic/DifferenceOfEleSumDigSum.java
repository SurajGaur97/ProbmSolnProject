package programsProblem.practice.array.basic;

import programsProblem.practice.common.DriverClass;

public class DifferenceOfEleSumDigSum implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 115, 6, 3};
        printElement(differenceOfSum(nums));
    }

    public int differenceOfSum(int[] nums) {
        int eleSum = 0, digSum = 0;

        for (int i = 0;i < nums.length;i++){
            eleSum += nums[i];

            int tmp = nums[i];
            while (tmp > 0){
                int a = tmp % 10;
                digSum += a;
                tmp /= 10;
            }
        }

        return Math.abs(eleSum - digSum);
    }

    //Failed element >= 10000
    public int differenceOfSum2(int[] nums) {
        int eleSum = 0;
        int digSum = 0;
        for (int num : nums){
            if(num < 10) continue;

            eleSum += num;

            if(num >= 1000){
                digSum += num / 1000;
                num = num % 1000;
            }
            if(num >= 100){
                digSum += num / 100;
                num = num % 100;
            }
            if(num < 100){
                digSum += num / 10 + num % 10;
            }
        }
        return Math.abs(eleSum - digSum);
    }

    public int differenceOfSum1(int[] nums) {
        int result = 0;
        for (int v : nums)
            result += v - (v / 1000 + v / 100 % 10 + v % 100 / 10 + v % 10);
        return Math.abs(result);
    }
}
