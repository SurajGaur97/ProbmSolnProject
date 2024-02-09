package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

import java.util.HashMap;
import java.util.Map;

public class SortColor implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{2,0,2,1,1,0};
        int[] nums = new int[]{2, 0, 2, 1, 1, 0, 0, 1, 2, 2, 2, 1, 1, 1, 0, 0, 1, 0, 2, 0, 1, 0};
//        int[] nums = new int[]{2};
        sortColors2(nums);
        printElement(nums);
    }

    public void sortColors2(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;

        for (int num : nums){
            if(num == 0) zeroCount++;
            if(num == 1) oneCount++;
            if(num == 2) twoCount++;
        }

        for (int i = 0;i < nums.length;i++){
            if(i < zeroCount) nums[i] = 0;
            else if(i < zeroCount + oneCount) nums[i] = 1;
            else if(i < zeroCount + oneCount + twoCount) nums[i] = 2;
        }
    }

    //Take more memory as contiguous memory allocation is greater than individual memory allocation
    public void sortColors1(int[] nums) {
        int[] countNum = new int[3];

        for (int num : nums){
            countNum[num]++;
        }

        for (int i = 0;i < nums.length;i++){
            if(i < countNum[0]) nums[i] = 0;
            else if(i < countNum[0] + countNum[1]) nums[i] = 1;
            else if(i < countNum[0] + countNum[1] + countNum[2]) nums[i] = 2;
        }
    }

    // 1ms sol
    public void sortColors(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int num : nums){
            if(!hm.containsKey(num)){
                hm.put(num, 1);
            } else {
                hm.put(num, hm.get(num) + 1);
            }
        }

        for (int k = 0;k < nums.length;k++){
            if(k < (hm.get(0) == null ? 0 : hm.get(0))){
                nums[k] = 0;
            } else if(k < (hm.get(0) == null ? 0 : hm.get(0)) + (hm.get(1) == null ? 0 : hm.get(1))){
                nums[k] = 1;
            } else if(k < (hm.get(0) == null ? 0 : hm.get(0)) + (hm.get(1) == null ? 0 : hm.get(1)) + (hm.get(2) == null ? 0 : hm.get(2))){
                nums[k] = 2;
            }
        }
    }
}
