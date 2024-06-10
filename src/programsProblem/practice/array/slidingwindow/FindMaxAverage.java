package programsProblem.practice.array.slidingwindow;

import programsProblem.practice.common.DriverClass;

public class FindMaxAverage implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        float maxAvg = 0;

        for(int i = 0; i + k < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            float avg = (float) sum / k;
            if(maxAvg < avg) maxAvg = avg;
        }

        return maxAvg;
    }
}
