package programsProblem.practice.array.mapping;

import programsProblem.utils.DriverClass;

public class Sort012 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 0, 1, 1, 2};
        printElement(sortIt(nums));
    }

    private int[] sortIt(int[] nums) {
        int[] count = new int[3];

        for (int num : nums)
            count[num]++;

        for (int i = 0;i < nums.length;i++){
            if(count[0] != 0){
                nums[i] = 0;
                count[0]--;
            } else if(count[1] != 0){
                nums[i] = 1;
                count[1]--;
            } else if(count[2] != 0){
                nums[i] = 2;
                count[2]--;
            }
        }

        return nums;
    }

}
