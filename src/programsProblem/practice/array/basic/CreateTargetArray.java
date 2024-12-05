package programsProblem.practice.array.basic;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};

//        createTargetArray(nums, index);
        createTargetArray1(nums, index);
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        for (int i = 0;i < nums.length;i++){
            target[index[i]] = nums[i];
        }
        return target;
    }

    public int[] createTargetArray1(int[] nums, int[] index) {
        List<Integer> ans = new ArrayList<>();
        int[] res = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            ans.add(index[i], nums[i]);
        }
        int h = 0;
        for (int a : ans){
            res[h++] = a;
        }
        return res;
    }
}
