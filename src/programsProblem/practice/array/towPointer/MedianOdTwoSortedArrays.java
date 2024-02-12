package programsProblem.practice.array.towPointer;

import programsProblem.practice.DriverClass;

public class MedianOdTwoSortedArrays implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] nums1 = new int[]{1,3,5}, nums2 = new int[]{2,3,4,6};
        int[] nums1 = new int[]{1, 3, 5, 7, 8, 9};
        int[] nums2 = new int[]{2, 4, 6};
//        int[] nums1 = new int[]{}, nums2 = new int[]{1};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Ndx = nums1.length - 1, num2Ndx = nums2.length - 1;

        int[] nums = new int[nums1.length + nums2.length];
        int k = nums.length - 1;

        //Storing merged element in sorted order
        while (k >= 0 && num2Ndx >= 0 && num1Ndx >= 0){
            if(nums1[num1Ndx] <= nums2[num2Ndx]) nums[k--] = nums2[num2Ndx--];
            else nums[k--] = nums1[num1Ndx--];
        }
        while (num1Ndx >= 0) nums[k--] = nums1[num1Ndx--];
        while (num2Ndx >= 0) nums[k--] = nums2[num2Ndx--];

        //returning median value
        if(nums.length % 2 != 0) return nums[nums.length / 2];
        else return (double) (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
    }
}
