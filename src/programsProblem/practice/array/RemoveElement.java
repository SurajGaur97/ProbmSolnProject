package programsProblem.practice.array;

public class RemoveElement {
    public void driverMethod() {
//        int[] nums = new int[]{4,5};
//        int val = 4;
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int length = removeElement(nums, val);

        System.out.println(length);
        for (int num : nums){
            System.out.print(num + " ");
        }
    }

    //LeetCode optimal sol
    public int removeElement1(int[] nums, int val) {
        int idx = 0;
        int store = nums.length;
        while (idx < store){
            if(nums[idx] == val){
                nums[idx] = nums[store - 1];
                nums[store - 1] = val;
                store -= 1;
            } else
                idx += 1;
        }
        return store;
    }

    //By me
    public int removeElement(int[] nums, int val) {
        int count = 0, contIndx = 0;

        for (int i = 0;i < nums.length;i++){
            if(nums[i] == val)
                count++;
        }

        for (int i = nums.length - 1;i >= 0;i--){
            if(nums[i] != val){
                contIndx = i;
                break;
            }
        }

        for (int i = 0;i < nums.length;i++){
            if(nums[i] == val){
                deleteElement(nums, i + 1);
                contIndx--;
            }
            if(nums[i] == val){
                i--;
                if(i == contIndx + 1)
                    break;
            }
        }

        //returning remained length
        return nums.length - count;
    }

    private void deleteElement(int[] nums, int indx) {
        for (int i = indx;i < nums.length;i++){
            nums[i - 1] = nums[i];
        }
    }
}
