package programsProblem.practice.string;

import programsProblem.practice.common.DriverClass;

public class GcdOfString implements DriverClass<String> {
    @Override
    public void driverMethod() {
        printElement(gcdOfStrings("ABABAB", "ABAB"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        while(b % a != 0) {
            int remainder = b % a;
            b = a;
            a = remainder;
        }
        return a;
    }
}
