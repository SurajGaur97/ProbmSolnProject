package programsProblem.practice.string;

import programsProblem.practice.array.mapping.EqualRowAndColumnPairs2352;
import programsProblem.practice.common.DriverClass;

public class RemovingStarsFromString2390 implements DriverClass<String> {
    @Override
    public void driverMethod() {
        String s = "leet**cod*e";
        printElement(removeStars(s));
    }

    public String removeStars(String s) {
        char[] chrs = new char[s.length()];
        int i = 0, j = 0;

        while(j < s.length()) {
            if(s.charAt(j) == '*') {
                i--;
            }
            else {
                chrs[i] = s.charAt(j);
                i++;
            }
            j++;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < i; k++)
            if (chrs[k] != '\0') {
                sb.append(chrs[k]);
            }

        return sb.toString();
    }
}
