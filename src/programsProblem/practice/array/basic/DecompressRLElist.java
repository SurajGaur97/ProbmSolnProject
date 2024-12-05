package programsProblem.practice.array.basic;

import programsProblem.utils.DriverClass;

public class DecompressRLElist implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] nums = new int[]{1, 2, 3, 4};
        printElement(decompressRLElist(nums));
    }

    public int[] decompressRLElist1(int[] nums) {
        int resLen = 0;
        for (int i = 0;i < nums.length;i += 2){
            resLen += nums[i];
        }

        int[] res = new int[resLen];
        int ndx = 0;
        for (int i = 0;i < nums.length / 2;i++){
            int perLen = 0;
            while (perLen++ < nums[2 * i]){
                res[ndx++] = nums[2 * i + 1];
            }
        }

        return res;
    }

    public int[] decompressRLElist(int[] nums) {
        int resLen = 0;
        for (int i = 0;i < nums.length;i += 2){
            resLen += nums[i];
        }

        int[] res = new int[resLen];
        int ndx = 0;
        for (int i = 0;i < nums.length;i += 2){
            int startNdx = 0;
            for (int j = startNdx;j < nums[i];j++){
                res[ndx++] = nums[i + 1];
            }
            startNdx += nums[i];
        }
        return res;
    }
}
