package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

public class ValidMountainArray implements DriverClass {
    @Override
    public void driverMethod() {

    }

    private boolean validMountainArray(int[] arr) {
        int hill = arr[0];
        int hillIndex = 0;

        for (int i = 0;i < arr.length;i++){
            if(hill < arr[i]){
                hill = arr[i];
                hillIndex = i;
            }
        }

        for (int i = 0;i < hillIndex;i++){
            if(arr[i] >= arr[i] + 1){
                return false;
            }
        }

        for (int i = hillIndex;i < arr.length - 1;i++){
            if(arr[i] <= arr[i] + 1){
                return false;
            }
        }
        return true;
    }
}
