package programsProblem.practice;

import java.util.Arrays;
import java.util.List;

public class Testing {
    public static void main(String[] args){
        //sayHi(10420);
//        System.out.println(factorialNo(5));

        List<Integer> lst = Arrays.asList(3, 5, 6, 8, 9);
        lst.stream()
                .sorted((a, b) -> b - a)
                .forEach(System.out::print);
    }

    private static int factorialNo(int i) {
        if(i == 1 || i == 0)
            return 1;
        else
            return i * factorialNo(i - 1);
    }

    private static void sayHi(int i) {
        System.out.println("hi");

        if(i <= 1) return;

        sayHi(i - 1);
    }
}
