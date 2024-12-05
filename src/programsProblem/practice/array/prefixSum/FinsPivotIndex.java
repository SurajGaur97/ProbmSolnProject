package programsProblem.practice.array.prefixSum;

import programsProblem.utils.DriverClass;

public class FinsPivotIndex implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1,7,3,6,5,6};
        printElement(pivotIndex(nums));
    }

    private int pivotIndex(int[] nums) {
        int lSum = 0, rSum = 0, j = 0;

        for(int i = 0; i < nums.length; i++) {
            lSum = 0; rSum = 0;
            j = i;
            while(j >= 0) lSum += nums[j--];
            j = i;
            while(j < nums.length) rSum += nums[j++];

            if(lSum - nums[i] == rSum - nums[i])
                return i;
        }
        return -1;
    }
}
