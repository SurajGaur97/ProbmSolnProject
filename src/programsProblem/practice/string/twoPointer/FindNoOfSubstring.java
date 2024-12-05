package programsProblem.practice.string.twoPointer;

import programsProblem.utils.DriverClass;

public class FindNoOfSubstring implements DriverClass<String> {
    @Override
    public void driverMethod() {
//        String str = "abcdabcbcabcdabc";
        String str = "abcbacabc";
        String subStr = "abc";

        System.out.println(findSubstringCount(str, subStr));
    }

    private int findSubstringCount(String str, String subStr) {
        int i = 0, j = 0, resCount = 0;
        StringBuilder tmp = new StringBuilder();

        while (i < str.length()){
            if(tmp.length() == subStr.length() && tmp.toString().equals(subStr)){
                resCount++;
                i = j + 1;
                j = i - 1;
                tmp = new StringBuilder();
            }
            if(tmp.length() == subStr.length() && !tmp.toString().equals(subStr)){
                i++;
                j = i - 1;
                tmp = new StringBuilder();
            }
            if(j < str.length()){
                tmp.append(str.charAt(j));
            }
            j++;
        }
        return resCount;
    }
}
