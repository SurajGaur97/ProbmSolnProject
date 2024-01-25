package programsProblem.practice.array;

public class SortedSquares {
    public void driverMethod() {
        int[] nums = new int[]{-7, -3, 0, 2, 3, 7, 11};
        for (Integer num : sortedSquares(nums)){
            System.out.print(num + ", ");
        }
    }

    public int[] sortedSquares(int[] nums) {
        int[] resNums = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;

        while (i <= j){
            if(nums[i] * nums[i] < nums[j] * nums[j]){
                resNums[k] = nums[j] * nums[j];
                j--;
            } else {
                resNums[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }

        return resNums;
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0;i < arr.length - 1;i++){
            if(arr[i] == 0){
                for (int j = arr.length - 1;j >= i + 1;j--){
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
            }
        }
    }
}
