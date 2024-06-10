package programsProblem.practice.array.towPointer;

import programsProblem.practice.common.DriverClass;

public class MaxTrappingRainWater implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        printElement(trap(height));
    }

    public int trap(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;

        while(i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i - 1);
            int k = i + 1, lostArea = 0;
            while(k < j) {
                lostArea += Math.min(height[k], minHeight);
                k++;
            }
            area = area - lostArea;
            if(maxArea < area) maxArea = area;

            if(height[i] < height[j]) i++;
            else j--;
        }

        return maxArea;
    }
}
