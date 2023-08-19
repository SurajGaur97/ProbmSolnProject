package programsProblem.practice.array;

import java.util.Arrays;

public class CapitaliseFirstLetterOfElementOfArr {
    public String[] doWork(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
        }
        return arr;
    }
}
