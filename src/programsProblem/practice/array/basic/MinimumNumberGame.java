package programsProblem.practice.array.basic;

import programsProblem.utils.DriverClass;

public class MinimumNumberGame implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{5, 4, 2, 3};
        printElement(numberGame(nums));
    }

    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        int n = 0;

        while (n < nums.length - 1){
            int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
            min = minNdx(nums);
            secMin = minNdx(nums);

            arr[n++] = nums[secMin];
            arr[n++] = nums[min];

            nums[min] = 0;
            nums[secMin] = 0;
        }
        return arr;
    }

    private int minNdx(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minNdx = 0;
        for (int i = 0;i < nums.length;i++){
            if(min > nums[i] && nums[i] != 0){
                min = nums[i];
                minNdx = i;
            }
        }
        return minNdx;
    }
}
