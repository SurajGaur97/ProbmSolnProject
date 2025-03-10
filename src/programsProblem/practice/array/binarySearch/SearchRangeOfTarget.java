package programsProblem.practice.array.binarySearch;

import programsProblem.utils.DriverClass;

import java.util.HashMap;
import java.util.Map;

public class SearchRangeOfTarget implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{5,7,7,8,8,8,9,10}; int target = 8;
//        int[] nums = new int[]{1}; int target = 1;
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
//        int[] nums = new int[]{}; int target = 0;
//        int[] nums = new int[]{2,2,2,3,4,5,6,6,6,6,6,6,7,8,8,8,9}; int target = 6;
        printElement(searchRange(nums, target));
    }

    //Solved and approached by me
    public int[] searchRange2(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int num : nums){
            if(num == target){
                if(!hm.containsKey(num))
                    hm.put(num, 1);
                else
                    hm.put(num, hm.get(num) + 1);
            }
        }

        int start = -1, end = -1;
        for (int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                start = i;
                break;
            }
        }
        if(hm.containsKey(target))
            end = start + hm.get(target) - 1;

        return new int[]{start, end};
    }

    //Taken help of Mahesh solve by me. 1ms on LeetCode
    public int[] searchRange1(int[] nums, int target) {
        int start = firstOccurUsingBinary(nums, target);
        int end = lastOccurUsingBinary(nums, target);
        return new int[]{start, end};
    }

    private int firstOccurUsingBinary(int[] nums, int target) {
        int srt = 0, end = nums.length - 1, ans = -1;

        while (srt <= end){
            //Binary Search
            int mid = srt + (end - srt) / 2;

            if(nums[mid] == target){
                ans = mid;
                end--;
            } else if(nums[mid] < target){
                srt = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private int lastOccurUsingBinary(int[] nums, int target) {
        int srt = 0, end = nums.length - 1, ans = -1;

        while (srt <= end){
            //Binary Search
            int mid = srt + (end - srt) / 2;

            if(nums[mid] == target){
                ans = mid;
                srt++;
            } else if(nums[mid] < target){
                srt = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    //By me, 1ms on LeetCode
    public int[] searchRange(int[] nums, int target) {
        //[5,7,7,8,8,8,8,10]
        int[] res = new int[]{-1, -1};
        int j = 0;
        for (int i = 0;i < nums.length;i++){
//            while(nums[i] != target && i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            if(nums[i] == target){
                res[j] = i;
                j++;

                if(i < nums.length - 1 && nums[i] == nums[i + 1]){
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
                    i--;
                }
            }
        }
        if(res[0] != -1 && res[1] == -1){
            res[1] = res[0];
        }
        return res;
    }
}
