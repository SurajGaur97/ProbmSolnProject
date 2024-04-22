package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] strs = new String[]{"runnable", "running", "runner"};

        String commonSubstring = strs[0];

//        for (int i = 1; i < strs.length; i++) {
//            while (strs[i].indexOf(commonSubstring) != 0) {
//                commonSubstring = commonSubstring.substring(0, commonSubstring.length() - 1);
//                if (commonSubstring.isEmpty()) {
//                    System.out.println("");
//                    return;
//                }
//            }
//        }
//        System.out.println(commonSubstring);

        String str = Arrays.stream(strs)
                .reduce((s1, s2) -> findCommonSubstring(s1, s2))
                .orElse("");
        System.out.println(str);
    }

    private static String findCommonSubstring(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());

        StringBuilder common = new StringBuilder();
        for (int i = 0;i < minLen;i++){
            if(s1.charAt(i) == s2.charAt(i)){
                common.append(s1.charAt(i));
            } else
                break;
        }
        return common.toString();
    }
}
