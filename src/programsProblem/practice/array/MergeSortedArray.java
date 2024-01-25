package programsProblem.practice.array;

import java.util.Arrays;

public class MergeSortedArray {
    public void driverMethod() {
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
//        int[] nums1 = new int[]{2,0};
//        int[] nums2 = new int[]{1};
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
//        int[] nums1 = new int[]{1,2,0,0,7,0};
//        int[] nums2 = new int[]{2,5,6};

        merge2(nums1, nums1.length - nums2.length, nums2, nums2.length);

        for (int num : nums1){
            System.out.print(num + " ");
        }
    }

    private void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    //Not working correctly by me
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //4,5,6,0,0,0      1,2,3
        int i = 0, j = 0;
        while (i < m + n && j < n){
            if(nums1[i] >= nums2[j]){
                for (int k = m + n - 1;k >= i + 1;k--){
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[j];
                j++;
            } else if(nums1[i] == 0){
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m;i < m + n;i++){
            nums1[i] = nums2[j];
            System.out.println(nums1[i] + " " + i);
            j++;
        }

        Arrays.sort(nums1);
    }
}
