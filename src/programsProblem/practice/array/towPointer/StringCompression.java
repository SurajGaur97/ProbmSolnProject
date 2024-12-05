package programsProblem.practice.array.towPointer;

import programsProblem.utils.DriverClass;

public class StringCompression implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        char[] chars = new char[]{'a','b','c'};
//        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        printElement(compress(chars));
    }

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        char curr = chars[0];
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == curr) {
                count++;
            }
            if(i == chars.length - 1 || chars[i] != curr) {
                if(count != 1) {
                    sb.append(curr).append(count);
                    count = 1;
                } else {
                    sb.append(curr);
                }
                curr = chars[i];
            }
        }

        if(chars[chars.length - 1] != chars[chars.length - 2]) {
            sb.append(chars[chars.length - 1]);
        }

        sb.getChars(0, sb.length(), chars, 0);
        return sb.length();
    }
}
