package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

public class ReplaceElementsWithGreatestElementOnRightSide implements DriverClass {
    @Override
    public void driverMethod() {

    }

    // 17,18,5,4,6,1
    // 18,6,6,6,1,-1
    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1;i >= 0;i--){
            int ele = arr[i];
            if(i == arr.length - 1) arr[i] = -1;

            if(arr[i] > arr[i - 1]){
                arr[i - 1] = arr[i];
            }
        }

        return arr;
    }
}
