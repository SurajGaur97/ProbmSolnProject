package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

import java.util.Arrays;

public class HeightChecker implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] heights = new int[]{1,1,4,2,1,3};
//        int[] heights = new int[]{5,1,2,3,4};
        int[] heights = new int[]{1, 2, 3, 4, 5};
        printElement(heightChecker(heights));
    }

    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;

        for (int i = 0;i < heights.length;i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }
}
