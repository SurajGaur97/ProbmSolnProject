package programsProblem.practice.streamApi;

import programsProblem.practice.common.DriverClass;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharInString implements DriverClass<Integer> {
    public static Character findFirstNonRepeatedCharacter(String input) {
        Map<Character, Long> charsVsCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

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
