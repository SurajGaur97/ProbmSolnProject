package programsProblem.practice.streamApi;

import programsProblem.utils.DriverClass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Medium65streamApi implements DriverClass<String> {
    @Override
    public void driverMethod() {
        /*filterEvenNumbersFromAList();
        maxInAList();
        sortAList();
        countStringWithSpecificPrefix();
        firstNonRepeatingChar();
        listOfStringToUppercase();
        sumOfNoInList();
        reverseEachStringInList();
        filterAndConvertMapToList();
        removeDuplicatesWithoutCollectors();*/

        reverseString();
    }

    /*1*/
    private void filterEvenNumbersFromAList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }

    /*2*/
    private void maxInAList() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Integer maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();

                        /*OR*/
        /*OptionalInt maxNumber1 = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();*/

        System.out.println("Max No: " + maxNumber);
    }

    /*3*/
    private void sortAList() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 4, 2);
        List<Integer> sorted = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sorted);
    }

    /*4*/
    private void countStringWithSpecificPrefix() {
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        Long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println(count);
    }

    /*5*/
    private void firstNonRepeatingChar() {
        String input = "swiss";
        Optional<Character> chr = input.chars()
                .mapToObj(ch -> (char)ch)
                .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst();
        System.out.println(chr.orElse(null));
    }

    /*6*/
    private void listOfStringToUppercase() {
        List<String> names = Arrays.asList("java", "stream", "api");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseNames);
    }

    /*7*/
    private void sumOfNoInList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    /*8*/
    private void reverseEachStringInList() {
        List<String> words = Arrays.asList("Java", "Stream", "API");
        List<String> revWords = words.stream()
                .map(item -> new StringBuilder(item).reverse().toString())
                .collect(Collectors.toList());

        System.out.println(revWords);
    }

    private void filterAndConvertMapToList() {
        Map<String, Integer> map = Map.of("A", 5, "B", 15, "C", 10, "D", 20);
        List<String> ans = map.entrySet().stream()
                .filter(item -> item.getValue() > 10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(ans);
    }

    private void removeDuplicatesWithoutCollectors() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);

        /*List<Integer> ansNum = numbers.stream()
                .collect(Collectors.toSet());*/

        List<Integer> ansNum = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(ansNum);
    }

    private void reverseString() {
        String str = "Suraj Gaur";

        /*String rev = IntStream.rangeClosed(1, str.length())
                .mapToObj(i -> str.charAt(str.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());*/

        /*String rev = new StringBuilder(
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()).toString())
                .reverse()
                .toString();*/

        /*String rev = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            StringBuilder sb = new StringBuilder();
                            list.forEach(sb::append);
                            return sb.toString();
                        }
                ));*/

        String rev = str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);

        System.out.printf(rev);
    }
}
