package programsProblem.practice.array.basic;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumIndicesWithKSetBits implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        List<Integer> nums = new ArrayList<>(Arrays.asList(5,10,1,5,2));
        List<Integer> nums = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        System.out.println(sumIndicesWithKSetBits(nums, 1));
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int desLen = 0, resSum = 0;

        for (int i = 0;i < nums.size();i++){
            if(nums.size() <= Math.pow(2, i)){
                desLen = i;
                break;
            }
        }
        for (int i = 0;i < desLen;i++){
            resSum += nums.get((int) Math.pow(2, i));
        }
        return resSum;
    }
}
