package programsProblem.practice.array.towPointer;

import programsProblem.practice.DriverClass;

import java.util.Arrays;

public class ThreeSumClosest implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{-1, 2, 1, -4};
//        int[] nums = new int[]{1,2,3,-1,-4,5};
        int target = 1;
        printElement(threeSumClosest1(nums, target));
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum with the sum of the first three elements

        for (int i = 0;i < nums.length - 2;i++){
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum; // Update closest sum if the current sum is closer to the target
                }

                if(sum <= target){
                    j++; // Increment j to increase the sum
                } else {
                    k--; // Decrement k to decrease the sum
                }
            }
        }

        return closestSum;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int resSum = 0, gap = Integer.MAX_VALUE;

        for (int i = 0;i < nums.length;i++){
            int l = i + 1, r = nums.length - 1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum <= target){
                    if(target - sum < gap){
                        gap = target - sum;
                        resSum = sum;
                    }
                    l++;
                } else if(sum > target){
                    if(sum - target < gap){
                        gap = sum - target;
                        resSum = sum;
                    }
                    r--;
                }
            }
        }

        return resSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE, resSum = 0;
        int[] resNdx = new int[3];

        for (int i = 0;i < nums.length - 2;i++){
            for (int j = i + 1;j < nums.length - 1;j++){
                for (int k = j + 1;k < nums.length;k++){
                    if(Math.abs(nums[i] + nums[j] + nums[k] - target) < min){
                        min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        resSum = nums[i] + nums[j] + nums[k];
                        resNdx[0] = i;
                        resNdx[1] = j;
                        resNdx[2] = k;
                    }
                }
            }
        }
        printElement(resNdx);
        return resSum;
    }
}

