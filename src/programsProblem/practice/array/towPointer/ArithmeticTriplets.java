package programsProblem.practice.array.towPointer;

import programsProblem.utils.DriverClass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArithmeticTriplets implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{0, 1, 4, 6, 7, 10};      //output=2
        int diff = 3;
//        int[] nums = new int[] {4,5,6,7,8,9};     //output=2
//        int diff = 2;

        printElement(arithmeticTriplets3(nums, diff));
    }

    public int arithmeticTriplets3(int[] nums, int diff) {
        int res = 0;
        int[] count = new int[201];

        for (int num : nums){
            if(num >= 2 * diff){
                if(count[num - diff] > 0 && count[num - 2 * diff] > 0){
                    res++;
                }
            }
            count[num] = 1;
        }

        return res;
    }

    public int arithmeticTriplets2(int[] nums, int diff) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        for (int i = 0;i < nums.length;i++){
            if(set.contains(nums[i] + diff) && set.contains(nums[i] + 2 * diff))
                res++;
        }
        return res;
    }

    public int arithmeticTriplets1(int[] nums, int diff) {
        int res = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0;i < nums.length;i++){
            hm.put(nums[i], i);
        }

        for (int i = 0;i < nums.length;i++){
            if(hm.containsKey(nums[i] + diff) && hm.containsKey(nums[i] + 2 * diff))
                res++;
        }
        return res;
    }

    //not working
    public int arithmeticTriplets(int[] nums, int diff) {   //{0,1,4,6,7,10}
        int i = 0, j = 1, res = 0;

        while (j < nums.length){
            if(nums[j] - nums[i] == diff){
                i = j;
                j++;
                while (j < nums.length){
                    if(nums[j] - nums[i] == diff){
                        res++;
                        break;
                    }
                    j++;
                }
                j = i;
            }
            if(j == nums.length - 1){
                i++;
                j = i;
            }
            j++;
        }
        return res;
    }

}
