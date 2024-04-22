package programsProblem.practice.streamApi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintCountOfCharInString {
    public void driverMethod() {
        String str = "surajj";
        printIt(str);
    }

    private void printIt(String str) {
        Map<Character, Integer> map = new HashMap<>();

        str.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
        map.forEach((k, v) -> {
            if(v == 1) System.out.print(k + " ");
        });
    }

    //Chat GPT
    private void printIt1(String str) {
        char lastChar = str.charAt(str.length() - 1);

        Map<Character, Long> charCountMap = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        charCountMap.forEach((c, n) -> {
            System.out.print(c + " : " + n);
            if(c != lastChar) System.out.print(", ");
        });
    }

    //By mySelf
    private void printIt2(String str) {
        Map<Character, Integer> map = new HashMap<>();


        str.chars().forEach(x -> {
            char c = (char) x;
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        });
    }
}
