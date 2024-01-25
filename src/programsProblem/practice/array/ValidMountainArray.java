package programsProblem.practice.array;

import programsProblem.practice.DriverClass;

public class ValidMountainArray implements DriverClass {
    @Override
    public void driverMethod() {
        int[] arr = new int[]{0, 2, 3, 4, 5, 2, 1, 0};
        System.out.println(validMountainArray(arr));
    }

    private boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;

        int hill = arr[0];
        int hillIndex = 0;

        for (int i = 0;i < arr.length;i++){
            if(hill < arr[i]){
                hill = arr[i];
                hillIndex = i;
            }
        }

        if(hillIndex == arr.length - 1 || hillIndex == 0) return false;

        for (int i = 0;i < hillIndex;i++){
            if(arr[i] >= arr[i + 1]){
                return false;
            }
        }

        for (int i = hillIndex;i < arr.length - 1;i++){
            if(arr[i] <= arr[i + 1]){
                return false;
            }
        }
        return true;
    }
}
