package programsProblem.practice.array.binarySearch;

import programsProblem.practice.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class Permutation implements DriverClass<Integer> {
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

    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 3};
        permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
}
