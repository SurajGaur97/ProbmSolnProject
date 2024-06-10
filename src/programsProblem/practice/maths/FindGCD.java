package programsProblem.practice.maths;

import programsProblem.practice.common.DriverClass;

public class FindGCD implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        printElement(gcd(24, 36));
        printElement(gcd1(24, 36));
        printElement(gcd2(24, 36));
    }

    private int gcd2(int a, int b) {
        if(b == 0) return a;
        return gcd2(b, a % b);
    }

    private int gcd1(int a, int b) {
        if(a % b == 0) return b;
        return gcd1(b, a % b);
    }

    private int gcd(int a, int b) {
        while(a % b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
}
