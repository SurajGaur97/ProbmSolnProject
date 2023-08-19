package programsProblem.practice.sortingAlgo;

public class SelectionSort {
    public void sortIt(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
