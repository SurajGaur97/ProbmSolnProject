package programsProblem.practice.sortingAlgo;

//Merge sort is based on divide and conquer method
public class MergeSort {
    public void driverMethod() {
        int[] list = new int[]{1, 3, 4, 5, 6, 7, 9};
        mergeSort(list);
        for (int ele : list) {
            System.out.print(ele + " ");
        }
    }

    private void mergeSort(int[] list) {
        int left = 0, right = list.length - 1;
        divide(list, left, right);
    }

    private void divide(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        divide(arr, l, mid);
        divide(arr, mid + 1, r);
        conquer(arr, l, mid, r);
    }

    private void conquer(int[] arr, int l, int m, int r) {
        int[] merge = new int[r - l + 1];
        int idx1 = l, idx2 = m + 1, x = 0;

        while (idx1 <= m && idx2 <= r) {
            if (arr[idx1] < arr[idx2]) {
                merge[x] = arr[idx1];
                idx1++;
            } else if (arr[idx2] <= arr[idx1]) {
                merge[x] = arr[idx2];
                idx2++;
            }
            x++;
        }

        while (idx1 <= m) {     //if something is left in indx1 then put it in merge array
            merge[x] = arr[idx1];
            idx1++;
            x++;
        }
        while (idx2 <= r) {     //if something is left in indx2 then put it in merge array
            merge[x] = arr[idx2];
            idx2++;
            x++;
        }

        //Copying sorted items in arr from left index
        for (int i = 0, j = l; i < merge.length; i++, j++)
            arr[j] = merge[i];
    }
}
