package programsProblem.practice.array;

import programsProblem.utils.DriverClass;

public class SortArrayByParity implements DriverClass {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{3, 1, 2, 4};

        for (int num : sortArrayByParity(nums)){
            System.out.print(num + " ");
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        int k = 0;

        for (int i = 0;i < nums.length;i++){
            if(nums[i] % 2 == 0){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }

        return nums;
    }
}
