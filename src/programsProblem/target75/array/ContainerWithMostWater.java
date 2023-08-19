package programsProblem.target75.array;

import java.util.Arrays;

public class ContainerWithMostWater {
	/***
	 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints 
	 * of the i'th line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container, such 
	 * that the container contains the most water. Return the maximum amount of water a container can store. Notice that 
	 * you may not slant the container. For more details visit: https://leetcode.com/problems/container-with-most-water/
	 * 
	 * Input: height = [1,8,6,2,5,4,8,3,7]
	 * Output: 49
	 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water 
	 * (blue section) the container can contain is 49.
	 */
	
	//It's not working as when same element occurs. XXXXXXXXXXXX
	public int maxArea(int[] height) {
        int[] arr = new int[height.length];
        
        for(int i = 0; i < height.length; i++)
        	arr[i] = height[i];
        Arrays.sort(arr);
        
        int max = 0, area = 0;
        for(int i = arr.length - 1; i > 0; i--) {
        	area = Math.min(arr[i], arr[i - 1]) * makePositive(getIndex(height, arr[i]) - getIndex(height, arr[i - 1]));
        	
        	if(area > max) {
        		max = area;
        	}
        }
        
        return max;
    }
	
	static int getIndex(int[] height, int num) {
		int index = 0 ;
		for(int i = 0; i  < height.length; i++) {
			if(height[i] == num)
				index = i;
		}
		return index;
	}
	
	static int makePositive(int num) {
		if(num < 0) {
			num = -(num);
		}
		return num;
	}
	
	//	[1,8,6,2,5,4,8,3,7]
	public int maxArea1(int[] height) {
		int area = 0, max = 0;
		
		int i = 0, j = height.length - 1;
        
        while(i <= j) {
        	area = Math.min(height[i], height[j]) * (j - i);
        
        	if(area > max)
        		max = area;
            
        	if(height[i] < height[j])
                i++;
            else
                j--;
        }
        
        return max;
    }
	
	public int maxAreaBestSol(int[] height) {
		int area = 0;
		int start = 0, end = height.length - 1;
		
		while(start < end) {
			int mheight = Math.min(height[start], height[end]);
			int mwidth = end - start;
			
			area = Math.max(area, mwidth*mheight);
			
			if(height[start] < height[end]) start++;
			
			else if(height[start] > height[end]) end--;
			
			else {
				start++;
				end--;
			}
		}
		
		return area;
	}
}
