package programsProblem.practice.streamApi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintCountOfCharInString {
    public void driverMethod() {
        String str = "surajj";
        printCountOfCharInString(str);
    }

    //By mySelf
    private void printCountOfCharInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char lastChar = str.charAt(str.length() - 1);

        str.chars().forEach(x -> {
            char c = (char) x;
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        });

        //Chat GPT
        Map<Character, Long> charCountMap = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        charCountMap.forEach((c, n) -> {
            System.out.print(c + " : " + n);
            if(c != lastChar) System.out.print(", ");
        });

    }
}
