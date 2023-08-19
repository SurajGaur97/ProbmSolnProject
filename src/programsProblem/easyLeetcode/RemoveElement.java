package programsProblem.easyLeetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
    public int removeElement1(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
    public int removeElement(int[] nums, int val) {
        List<Integer> lst = new ArrayList<>();
        for (int num : nums) {
            if (num != val) {
                lst.add(num);
            }
        }

        for(int i = 0; i < lst.size(); i++) {
            nums[i] = lst.get(i);
        }

        return lst.size();
    }

}
