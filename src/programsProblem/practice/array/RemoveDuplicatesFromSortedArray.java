package programsProblem.practice.array;

public class RemoveDuplicatesFromSortedArray {
    public void driverMethod() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int length = removeDuplicates(nums);
        System.out.println(length);

        for (int num : nums)
            System.out.print(num + " ");
    }

    private int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length - 1;i++){
            if(nums[i] != nums[i + 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = nums[nums.length - 1];

        return (j + 1);
    }
}
