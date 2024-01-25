package programsProblem.practice.array;

import java.util.ArrayList;
import java.util.List;

public class MinBin {
    public void driverMethod() {
        int input1 = 0;
        int[] input2 = new int[]{};

        System.out.println(minBin(input1, input2));
    }

    private int minBin(int input1, int[] input2) {
        int minVal = 0;
        if(input1 == 1)
            minVal = input2[0];

        else {
            List<Integer> candidateVals = new ArrayList<>();
            int i = 0, j = 1;
            while (i < input2.length && j < input2.length){
                candidateVals.add(input2[i] & input2[j]);

                if(j == input2.length - 1){
                    i++;
                    j = i;
                }
                j++;
            }

            for (int val : candidateVals){
                if(minVal < val)
                    minVal = val;
            }
        }

        int p = 0;
        int powerVal = 1;

        while (powerVal < minVal){
            powerVal = 2 * powerVal;
            p++;
        }

        if(p == 0)
            return 1;

        return p;
    }
}
