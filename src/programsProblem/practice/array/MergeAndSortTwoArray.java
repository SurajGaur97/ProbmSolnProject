package programsProblem.practice.array;

public class MergeAndSortTwoArray {
    public void driverMethod() {
        int[] A = new int[]{1, 3, 5, 7, 8, 9};
        int[] B = new int[]{2, 4, 6};

        int[] res = mergeAndSort(A, B);
        for (int l = 0; l < res.length; l++) {
            System.out.print(res[l] + " ");
        }
    }

    private int[] mergeAndSort(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];

        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if(A[i] <= B[j]) {
                res[k] = A[i];
                i++;
            } else {
                res[k] = B[j];
                j++;
            }
            k++;
        }

        if(B.length < A.length) {
            for (int l = i; l < A.length; l++) {
                res[k] = A[l];
                k++;
            }
        } else if(B.length > A.length) {
            for (int l = i; l < B.length; l++) {
                res[k] = A[l];
                k++;
            }
        }

        return res;
    }

}
