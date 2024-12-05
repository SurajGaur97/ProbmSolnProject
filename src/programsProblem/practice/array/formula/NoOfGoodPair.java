package programsProblem.practice.array.formula;

import programsProblem.utils.DriverClass;

import java.util.HashMap;
import java.util.Map;

public class NoOfGoodPair implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
//        int[] nums = new int[] {1,1,1,1};
        printElement(numIdenticalPairs1(nums));
    }

    //LeetCode sol
    public int numIdenticalPairs1(int[] nums) {
        int ans = 0;
        int[] count = new int[101];
        for (int a : nums){
            int cout = count[a];
            ans = ans + cout;
            count[a] = cout + 1;

            //above three line in one line:
            //ans += count[a]++;
        }
        return ans;
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        int res = 0;
        for (Integer value : map.values()){
            if(value > 1){
                int pairs = (value * (value - 1)) / 2;
                res += pairs;
            }
        }
        return res;
    }
}
