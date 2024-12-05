package programsProblem.practice.string;

import programsProblem.utils.DriverClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInString implements DriverClass<String> {
    @Override
    public void driverMethod() {
        String s = "  hello world  ";
        printElement(reverseWords(s));
    }

    private String reverseWords(String s) {
        String[] words = s.split(" ");

        List<String> strLst = Arrays.stream(words).filter(str -> !str.equals("")).collect(Collectors.toUnmodifiableList());

        StringBuilder res = new StringBuilder();
        for(int i = strLst.size() - 1; i >= 0; i--) {
            res.append(strLst.get(i));
            if(i != 0) res.append(" ");
        }

        return res.toString();
    }
}
