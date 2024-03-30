package programsProblem.practice.array;

import programsProblem.practice.common.DriverClass;

public class ThirdMaximumNo implements DriverClass {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{2,2,1,3};
//        int[] nums = new int[]{1,1,2};
//        int[] nums = new int[]{3,2,1};
//        int[] nums = new int[]{1,2};
//        int[] nums = new int[]{1,2,-2147483648};
        int[] nums = new int[]{3, 3, 4, 3, 4, 3, 0, 3, 3};

        System.out.println(thirdMax(nums));
    }

    public int thirdMax1(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (Integer num : nums){
            if(num.equals(max) || num.equals(secondMax) || num.equals(thirdMax)){
                continue;
            }

            if(max == null || num > max){
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if(secondMax == null || num > secondMax){
                thirdMax = secondMax;
                secondMax = num;
            } else if(thirdMax == null || num > thirdMax){
                thirdMax = num;
            }
        }
        if(thirdMax == null){
            return max;
        }
        return thirdMax;
    }

    //[2,2,3,1]
    //1
    public int thirdMax(int[] nums) {
        int count = 0, i = 0, max2 = Integer.MIN_VALUE, max = Integer.MIN_VALUE;

        //finding maximum for max2 which will be returned when count < 3
        for (int k : nums){
            if(max2 < k)
                max2 = k;
        }

        while (i < nums.length && count < 3){
            max = Integer.MIN_VALUE;
            boolean flag = true;

            //finding maximum for max each time when the arr updated
            for (int num : nums){
                if(max < num)
                    max = num;
            }

            for (int j = 0;j < nums.length;j++){
                if(nums[j] == max){
                    //making each value to minimum so that next time it can get second max or third max.
                    nums[j] = Integer.MIN_VALUE;
                    i++;
                    if(flag){
                        //counting only one time in case of repeated values
                        count++;
                        flag = false;
                    }
                }
            }
        }

        if(count == 3){
            return max;
        }
        return max2;
    }
}
