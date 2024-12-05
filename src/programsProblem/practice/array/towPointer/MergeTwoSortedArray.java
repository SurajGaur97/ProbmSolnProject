package programsProblem.practice.array.towPointer;

import programsProblem.utils.DriverClass;

public class MergeTwoSortedArray implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums1 = new int[]{1, 4, 5};
        int[] nums2 = new int[]{2, 3, 5, 6};
        printElement(mergeIt(nums1, nums2));
    }

    private int[] mergeIt(int[] nums1, int[] nums2) {
        int[] resNums = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                resNums[k++] = nums1[i++];
            } else {
                resNums[k++] = nums2[j++];
            }
        }

        if(i < nums1.length)
            resNums[k++] = nums1[i++];
        else if(j < nums2.length)
            resNums[k++] = nums2[j++];

        return resNums;
    }
}
