package programsProblem.practice.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamMethods {
    public void driverMethod() {
        List<Integer> intLst = Arrays.asList(2, 23, 22, 5, 7, 88, 7, 5, 23);
        List<String> strLst = Arrays.asList("Suraj", "Ankit", "Ram", "Prakash");
        getAvgOfList(intLst);
        getSumOfList(intLst);
        getUpperLowerCases(strLst);
        removeDuplicateItems(intLst);
        countOfSpecificLetterStr(strLst, "S");
        sortByAlphabet(strLst);
        minMaxValueFromList(intLst);
        secondHighLowNo(intLst);
    }

    private void secondHighLowNo(List<Integer> lst) {
        Integer secMin = lst.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .get();

        Integer secMax = lst.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
//                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("Second min no: " + secMin);
        System.out.println("Second max no: " + secMax);
    }

    private void minMaxValueFromList(List<Integer> list) {
        Integer min = list.stream()
                .min(Integer::compareTo)
//                .orElse(null)
                .get();

        Integer max = list.stream()
                .max(Integer::compareTo)
//                .orElse(null)
                .get();

        System.out.println("Min and Max values: " + min + " & " + max);
    }

    private void sortByAlphabet(List<String> lst) {
        List<String> srtedList = lst.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> revSrted = lst.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Sorted by alphabet: " + srtedList);
        System.out.println("Sorted by alphabet reverse: " + revSrted);
    }

    private void countOfSpecificLetterStr(List<String> lst, String chr) {
        long count = lst.stream()
                .filter(value -> value.startsWith(chr))
                .count();

        System.out.println("Count of strings start with '" + chr + "' is: " + count);
    }

    private void removeDuplicateItems(List<Integer> lst) {
        List<Integer> distinctInt = lst.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct values: " + distinctInt);
    }

    private void getUpperLowerCases(List<String> lst) {
        List<String> uperCaseList = lst.stream()
                .map(String::toUpperCase)
                //.map(value -> value.toUpperCase())
                .collect(Collectors.toList());

        List<String> loweCaseList = lst.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println("Upper Case Words: " + uperCaseList);
        System.out.println("Lower Case Words: " + loweCaseList);
    }

    private void getSumOfList(List<Integer> lst) {
        int evenSum = lst.stream()
                .filter(value -> value % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        int oddSum = lst.stream()
                .filter(value -> value % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of Even values of list is: " + evenSum);
        System.out.println("Sum of Odd values of list is: " + oddSum);
    }

    private void getAvgOfList(List<Integer> lst) {
        double res = lst.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Average value of list is: " + res);
    }
}
