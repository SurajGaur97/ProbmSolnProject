package programsProblem.easyLeetcode;

public class SquareRoot {
    public int mySqrt(int x) {
        int low = 1, high = x, result = -1;

        //modified binary search
        while(low <= high) {
            long mid = ((long)low + (long)high) / 2;
            long val = mid * mid;
            if(val == x) {
                // prefect square root
                return (int)mid;
            }
            else if (val < x) {
                // store the floor value, in-case the number is not perfect square root, we can print the floor value
                result = (int)mid;
                low = (int)mid + 1;
            }
            else {
                high = (int)mid - 1;
            }
        }
        return result;
    }

    public int mySqrt1(int x) {
        Long num = 1L;
        while(num * num <= x) {
            num++;
        }

        return (num.intValue() - 1);
    }
}
