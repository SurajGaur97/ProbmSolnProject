package programsProblem.practice.array.mapping;

import programsProblem.practice.common.DriverClass;

import java.util.*;

public class FindPosNegPair implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{5, 3, -1, 2, -3, -4, 1, 4, -5};

        System.out.println(findPair(nums));
    }

    private List<List<Integer>> findPair(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            if(num > 0)
                set.add(num);
        }

        for (int num : nums){
            if(num < 0 && set.contains(-num)){
                List<Integer> lst = new ArrayList<>(Arrays.asList(-num, num));
                res.add(lst);
            }
        }
        return res;
    }
}
