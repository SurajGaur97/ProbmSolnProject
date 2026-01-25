package programsProblem.target75.array;

import programsProblem.utils.DriverClass;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString implements DriverClass<String> {

    @Override
    public void driverMethod() {
        String s = "leetcode";
        printElement(reverseVowels(s));
    }

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');vowelsSet.add('A');
        vowelsSet.add('e');vowelsSet.add('E');
        vowelsSet.add('i');vowelsSet.add('I');
        vowelsSet.add('o');vowelsSet.add('O');
        vowelsSet.add('u');vowelsSet.add('U');

        for(int k = 0; k < chars.length / 2; k++) {
            if(vowelsSet.contains(chars[i]) && vowelsSet.contains(chars[j])) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++; j--;
            } else if(!vowelsSet.contains(chars[i])) {
                i++;
            }
            else if(!vowelsSet.contains(chars[j])) {
                j--;
            }
        }

        return new String(chars);
    }
}
