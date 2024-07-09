package programsProblem.practice.array;

import programsProblem.practice.common.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class KthMaxAndMinElement implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{10, 20, 30, 1, 2};

        printElement(getKthHighest(nums, 5));
    }

    private int getKthHighest(int[] nums, int k) {
        int max = Integer.MIN_VALUE, res = 0;

        List<Integer> lst = new ArrayList<>();
        for (int n : nums)
            lst.add(n);

        int times = 0;
        int i = 0;
        while (times < k){
            if(max < lst.get(i))
                max = lst.get(i);

            if(i == lst.size() - 1){
                lst.remove(Integer.valueOf(max));
                i = -1;
                res = max;
                max = 0;
                times++;
            }

            i++;
        }

        return res;
    }
}
