package programsProblem.practice.array;

public class CheckNandItsDoubleExists {
    public void driverMethod() {
        int[] arr = new int[]{3, 1, 7, 11};
        System.out.println(checkIfExist(arr));
    }

    private boolean checkIfExist(int[] arr) {
        int i = 0, j = 1;
        while (i < arr.length && j < arr.length){
            if((float) arr[i] / 2 == arr[j] || arr[i] * 2 == arr[j]){
                return true;
            }
            if(j == arr.length - 1){
                i++;
                j = i;
            }
            j++;
        }
        return false;
    }
}
