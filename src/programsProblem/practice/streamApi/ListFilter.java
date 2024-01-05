package programsProblem.practice.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFilter {
    public void driverMethod() {
        List<Integer> lst = Arrays.asList(2, 23, 22, 5, 7, 88);
        filterList(lst);
    }

    private void filterList(List<Integer> nos) {
        //By Durgesh Sir YouTube
        Stream<Integer> stream = nos.stream();
        List<Integer> filteredData = stream.filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(filteredData);

        //By me: for even no
        nos.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));

        //By me: no greater than 50
        nos.stream().filter(x -> x > 50).forEach(x -> System.out.print(x + " "));

    }
}
