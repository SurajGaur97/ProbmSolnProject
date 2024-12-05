package programsProblem.practice.array;

import programsProblem.utils.DriverClass;

public class PlusMultArray implements DriverClass<String> {
    @Override
    public void driverMethod() {
//        int[] nums = new int[]{12,3,5,7,13,12};
//        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] nums = new int[]{1,3,5,7,9,11,13,15,17,19};

        printElement(solveIt(nums));
    }

    private String solveIt(int[] nums) {
        int rEven = nums[0], rOdd = nums[1];
        boolean isMult = true;
        for(int i = 2; i < nums.length; i += 2) {
            if(isMult) {
                rEven *= nums[i];
                isMult = false;
            }
            else {
                rEven += nums[i];
                isMult = true;
            }
        }

        isMult = true;
        for(int i = 3; i < nums.length; i += 2) {
            if(isMult) {
                rOdd *= nums[i];
                isMult = false;
            }
            else {
                rOdd += nums[i];
                isMult = true;
            }
        }

        if(rEven % 2 > rOdd % 2) return "EVEN";
        else if(rEven % 2 < rOdd % 2) return "ODD";
        else return "NUETRAL";
    }
}
