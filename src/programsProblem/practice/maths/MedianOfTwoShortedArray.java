package programsProblem.practice.maths;

public class MedianOfTwoShortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totLen = nums1.length + nums2.length;
        int[] nums = new int[totLen];
        int indx = 0;
        for(int i = 0; i < nums1.length; i++) {
        	nums[indx] = nums1[i];
        	indx++;
        }
        for(int i = 0; i < nums2.length; i++) {
        	nums[indx] = nums2[i]; 
        	indx++;
        }
        
        if((totLen) % 2 == 0) {
        	double sum = 0; 
        	return (double)(nums[(totLen / 2) - 1] + nums[((totLen / 2) + 1) - 1]) / 2;
        }
        return nums[(totLen + 1)/2];
    }
}
