package programsProblem.practice.array;

import org.jetbrains.annotations.NotNull;
import programsProblem.practice.DriverClass;

public class ReplaceElementsWithGreatestElementOnRightSide implements DriverClass {
    @Override
    public void driverMethod() {
//        int[] arr = new int[]{500};
//        int[] arr = new int[]{17,18,5,4,6,1};
        int[] arr = new int[]{19, 17, 16, 18, 5, 4, 6, 1};

        for (int num : replaceElements1(arr)){
            System.out.print(num + " ");
        }
    }

    //Memory optimised LeetCode Sol
    public int[] replaceElements1(int[] arr) {
        int[] ans = new int[arr.length];
        int maxRight = -1;
        for (int i = arr.length - 1;i >= 0;i--){
            ans[i] = maxRight;
            if(arr[i] > maxRight){
                maxRight = arr[i];
            }
        }
        return ans;
    }

    //By me
    public int[] replaceElements(int @NotNull [] arr) {
        int replValue = arr[arr.length - 1];

        for (int i = arr.length - 1;i >= 0;i--){
            if(replValue < arr[i]){
                int temp = arr[i];
                arr[i] = replValue;
                replValue = temp;
            }
            if(i > 0 && replValue > arr[i - 1]){
                arr[i - 1] = replValue;
            }
        }
        arr[arr.length - 1] = -1;

        return arr;
    }
}
