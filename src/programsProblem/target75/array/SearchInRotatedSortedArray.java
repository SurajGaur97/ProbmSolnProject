package programsProblem.target75.array;

import programsProblem.utils.DriverClass;

public class SearchInRotatedSortedArray implements DriverClass<Integer> {
    /***
     * There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function,
     * nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might
     * be rotated at pivot index 3 and become [4,5,6,7,0,1,2].Given the array nums after the possible rotation and an integer
     * target, return the index of target if it is in nums, or -1 if it is not in nums.You must write an algorithm with O(log n)
     * runtime complexity.
     * Find Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
     *
     * Example 1:
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */

    @Override
    public void driverMethod(){
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        int target = 7;

        printElement(search(nums, target));
    }

    private int search(int[] nums, int target){
        int l = 0, r = nums.length - 1, p = 0;

        //finding pivot(i.e., the smallest element) for splitting the array and generate two
        //sorted arrays, so that we can apply binary search and search for target.
        while (l < r){
            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        p = l;

        //first half searching
        l = 0;
        r = p;
        while (l <= r){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return mid;
            if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        //second half searching
        l = p;
        r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return mid;
            if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int search1(int[] nums, int target){
        int start = 0, end = nums.length - 1, mid;

        while (start <= end){
            mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }

}
