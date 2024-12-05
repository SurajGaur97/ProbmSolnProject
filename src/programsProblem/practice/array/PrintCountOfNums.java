package programsProblem.practice.array;

import programsProblem.utils.DriverClass;

public class PrintCountOfNums implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{1,2,3,2,1,2,3,4,5,4,3,2,3,4,5,6,7,7,7,8,9,9,0,0};
        int[] nums = new int[]{1, 1, 2, 3, 3, 2, 4, 5, 10};
        printCounts(nums);
    }

    private void printCounts(int[] nums) {
        int maxCount = nums[0];
        for (int num : nums){
            if(maxCount < num) maxCount = num;
        }
        int[] resNums = new int[maxCount + 1];

        for (int num : nums){
            resNums[num]++;
        }

        printElement(resNums);
    }
}
