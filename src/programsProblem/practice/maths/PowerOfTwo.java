package programsProblem.practice.maths;

public class PowerOfTwo {
    public void driverMethod() {
        System.out.println(isPowerOfTwo1(2097153));
    }

    //By me
    private boolean isPowerOfTwo1(int n) {
        while (true) {
            if(n == 1) return true;     //2 raise to the power 0 = 1
            if(n == 0 || n % 2 != 0) return false;
            n = n / 2;
        }
    }

    //LeetCode Sol
    private boolean isPowerOfTwo(int n) {
        if(n == 1) return true;     //2 raise to the power 0 = 1
        if(n == 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
}
