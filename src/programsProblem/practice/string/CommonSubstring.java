package programsProblem.practice.string;

import programsProblem.practice.common.DriverClass;

import java.util.Arrays;

public class CommonSubstring implements DriverClass<String> {
    @Override
    public void driverMethod() {
        String[] strs = new String[]{"run", "running", "runner"};
//        String[] strs = new String[]{"runnable", "running", "runner"};
        printElement(findCommonSubstring1(strs));
    }

    private String findCommonSubstring1(String[] strs) {
        String common = strs[0];

        for (int i = 1;i < strs.length;i++){
            while (strs[i].indexOf(common) != 0){
                common = common.substring(0, common.length() - 1);

                if(common.isEmpty())
                    return "";
            }
        }

        return common;
    }

    //Using Stream API
    private String findCommonSubstring(String[] strs) {

        String res = Arrays.stream(strs)
                .reduce((s1, s2) -> findCommonStr(s1, s2))
                .orElse("");

        return res;
    }

    private String findCommonStr(String s1, String s2) {
        StringBuilder common = new StringBuilder();

        for (int i = 0;i < Math.min(s1.length(), s2.length());i++)
            if(s1.charAt(i) == s2.charAt(i))
                common.append(s1.charAt(i));
            else break;

        return common.toString();
    }
}
