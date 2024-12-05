package programsProblem.practice.array.basic;

import programsProblem.utils.DriverClass;

public class ProductExceptSelf implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 3, 4};
        printElement(productExceptSelf(nums));
    }

    public int[] productExceptSelf(int[] nums) {
        int pre = 1, post = 1;
        int[] result = new int[nums.length];

        for (int i = 0;i < nums.length;i++){
            result[i] = pre;
            pre = pre * nums[i];
        }

        for (int i = nums.length - 1;i >= 0;i--){
            result[i] = result[i] * post;
            post = post * nums[i];
        }

        return result;
    }
}
