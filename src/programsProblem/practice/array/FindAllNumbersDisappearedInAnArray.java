package programsProblem.practice.array;

import programsProblem.practice.common.DriverClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        printElement(findDisappearedNumbers1(nums));
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        return new MyArrayList(nums);
    }

    //4,3,2,7,8,2,3,1
    private List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        List<Integer> resList = new ArrayList<>();

        for (int num : nums){
            hs.add(num);
        }

        for (int i = 1;i <= nums.length;i++){
            if(!hs.contains(i)){
                resList.add(i);
            }
        }

        return resList;
    }

    private static class MyArrayList extends ArrayList<Integer> {
        int[] nums;

        public MyArrayList(int[] nums) {
            this.nums = nums;
        }

        public int size() {
            if(nums != null)
                method();
            return super.size();
        }

        private void method() {
            boolean[] check = new boolean[nums.length + 1];

//            for(int i = 0; i < nums.length; i++) {
//                check[nums[i]] = true;
//            }
            for (int num : nums){
                check[num] = true;
            }

            for (int i = 1;i <= nums.length;i++){
                if(!check[i])
                    super.add(i);
            }
            this.nums = null;
        }
    }
}
