package programsProblem.practice.streamApi;

import programsProblem.utils.DriverClass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ThirdHighestNumber implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        List<Integer> list = Arrays.asList(10, 15, 2, 8, 7, 1, 9, 3);
        solve(list);
    }

    private void solve(List<Integer> list){
        Optional<Integer> thirdLargest = list.stream()
                .distinct()                  // Remove duplicate values
                .sorted((a, b) -> b - a)     // Sort in descending order
                .skip(2)                     // Skip the first two largest elements
                .findFirst();                // Get the third largest element

        thirdLargest.ifPresentOrElse(
                num -> System.out.println("The third largest number is: " + num),
                () -> System.out.println("The list does not contain enough unique elements.")
        );
    }
}
