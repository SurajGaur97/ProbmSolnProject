package programsProblem.practice.streamApi;

import programsProblem.practice.common.DriverClass;

import java.util.Arrays;
import java.util.List;

public class SumOfNosInList implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        List<Integer> lst = Arrays.asList(3, 5, 6, 8, 9);
        int sumOfOdd = lst.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum);
        int sumOfEven = lst.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);

        int evenSum = lst.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum();
        int sum = lst.stream().mapToInt(n -> n).sum();


        printElement(sumOfOdd);
        printElement(sumOfEven);
        printElement(evenSum);
        printElement(sum);

    }
}
