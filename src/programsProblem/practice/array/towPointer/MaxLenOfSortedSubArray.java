package programsProblem.practice.array.towPointer;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class MaxLenOfSortedSubArray implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 8};
        printElement(getResult(nums));
    }

    private int getResult(int[] nums) {
        List<Integer> resList = new ArrayList<>();

        int i = 0, j = 1, loop = 0, maxLen = 0;
        resList.add(nums[0]);
        while (i < nums.length - 1){
            if(j < nums.length && nums[i] < nums[j]){
                resList.add(nums[j]);
                int tmp = i;
                i = j;
                if(j + 1 < nums.length && nums[i] > nums[j + 1]){
                    resList.remove(resList.size() - 1);
                    i = tmp;
                }
            }
            if(j == nums.length - 1){
                if(resList.size() > maxLen)
                    maxLen = resList.size();
                resList.clear();
                loop++;
                i = loop;
                j = i;
                resList.add(nums[i]);
            }
            j++;
        }
        return maxLen;
    }
}
