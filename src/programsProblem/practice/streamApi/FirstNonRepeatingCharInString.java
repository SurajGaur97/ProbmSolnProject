package programsProblem.practice.streamApi;

import programsProblem.utils.DriverClass;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharInString implements DriverClass<Integer> {
    public static Character findFirstNonRepeatedCharacter(String input) {
        Map<Character, Long> charsVsCount = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        int[] arr = new int[]{1,2,3,4,5};
        int a = Arrays.stream(arr).findFirst().orElse(0);

        return charsVsCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void driverMethod() {
        String input = "Interview";
        Character result = findFirstNonRepeatedCharacter(input);
        System.out.println(result);
    }
}
