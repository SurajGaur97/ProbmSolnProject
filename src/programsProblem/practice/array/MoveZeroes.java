package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

public class MoveZeroes implements DriverClass {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 0};

        moveZeroes(nums);

        for (int num : nums){
            System.out.print(num + " ");
        }
    }

    //[0,1,0,3,12]
    //[1,0,3,12,0]
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0;j < nums.length;j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }

        for (int k = i;k < nums.length;k++){
            nums[k] = 0;
        }
    }
}
