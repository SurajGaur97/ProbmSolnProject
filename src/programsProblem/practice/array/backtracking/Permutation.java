package programsProblem.practice.array.backtracking;

import programsProblem.practice.common.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class Permutation implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        backtrack(nums, new ArrayList<>(), result);

        List<Integer> currentList = new ArrayList<>();
        for (int i : nums){
            currentList.add(i);
        }
        findPermutation(0, nums, result, currentList);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the current permutation is complete
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore all choices
        for (int i = 0;i < nums.length;i++){
            // Skip if the element is already chosen
            if(current.contains(nums[i])){
                continue;
            }

            // Make a choice
            current.add(nums[i]);

            // Explore further
            backtrack(nums, current, result);

            // Undo the choice (backtrack)
            current.remove(current.size() - 1);
        }
    }

    void findPermutation(int index, int[] nums, List<List<Integer>> resultList, List<Integer> currentList) {
        if(index == nums.length){
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index;i < nums.length;i++){
            swap(index, i, currentList);
            findPermutation(index + 1, nums, resultList, currentList);
            swap(index, i, currentList);
        }
    }

    void swap(int index, int i, List<Integer> currentList) {
        int temp = currentList.get(index);
        int temp1 = currentList.get(i);
        currentList.set(index, temp1);
        currentList.set(i, temp);
    }
}
