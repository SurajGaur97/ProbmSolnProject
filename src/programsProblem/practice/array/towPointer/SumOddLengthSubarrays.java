package programsProblem.practice.array.towPointer;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class SumOddLengthSubarrays implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[] arr = new int[]{1, 4, 2, 5, 3};
        printElement(sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int loop = 1, i = 0, j = 0, res = 0, n = arr.length;
        List<Integer> tmp = new ArrayList<>();

        while (n < arr.length){
            while (tmp.size() < loop * 2 + 1){
                tmp.add(arr[j]);
                j++;
            }

            if(tmp.size() == loop * 2 + 1){
                res += tmp.stream().mapToInt(Integer::intValue).sum();
                i++;
                j = 0;
                tmp.clear();
            }

            if(n == arr.length){
                loop++;
                i = 0;
                j = -1;
            }
            n++;
        }
        return res;
    }
}
