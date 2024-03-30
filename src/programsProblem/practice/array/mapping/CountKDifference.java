package programsProblem.practice.array.mapping;

import programsProblem.practice.common.DriverClass;

import java.util.HashMap;
import java.util.Map;

public class CountKDifference implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{1,2,2,1};    //4
//        int k = 1;
//        int[] nums = new int[]{1,3};    //0
//        int k = 3;
        int[] nums = new int[]{3, 2, 1, 5, 4};  //2
        int k = 3;

        printElement(countKDifference(nums, k));
    }

    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i] + k))
                res += map.get(nums[i] + k);

            if(map.containsKey(nums[i] - k))
                res += map.get(nums[i] - k);

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }

    public int countKDifference2(int[] nums, int k) {
        final int kMax = 100;
        int ans = 0;
        int[] count = new int[kMax + 1];

        for (final int num : nums)
            ++count[num];

        for (int i = k + 1;i <= kMax;++i)
            ans += count[i] * count[i - k];

        return ans;
    }

    public int countKDifference1(int[] nums, int k) {
        int i = 0, j = 1, res = 0;

        while (j < nums.length){
            if(Math.abs(nums[i] - nums[j]) == k){
                res++;
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
