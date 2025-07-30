package programsProblem.target75;

import programsProblem.practice.streamApi.AvgSalary;
import programsProblem.utils.DriverClass;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Test implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        List<AvgSalary.Employee> employees = Arrays.asList(
                new AvgSalary.Employee(1, "Alice", "Delhi", 50000, true),
                new AvgSalary.Employee(2, "Bob", "Delhi", 60000, false),
                new AvgSalary.Employee(3, "Charlie", "Delhi", 70000, true),
                new AvgSalary.Employee(4, "David", "Mumbai", 55000, true),
                new AvgSalary.Employee(5, "Eve", "Delhi", 65000, true)
        );

        OptionalDouble averageSalary = employees.stream()
                .filter(item -> {
                    return item.getLocation().equalsIgnoreCase("DELHI") && item.isActive();
                })
                .mapToDouble(AvgSalary.Employee::getSalary)
                .average();

        averageSalary.ifPresentOrElse(
                avg -> System.out.println("Average salary of active employees in Delhi: " + avg),
                () -> System.out.println("No active employees found in Delhi.")
        );

//        String s1 = new String("ABC");
//        String s2 = "ABC";
//        String s3 = null;
//        s3 = s2;
//
//        System.out.println(s1 = s2);
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1.equals(s2));

//        String str = "0P";
//        StringBuilder res = new StringBuilder();
//
//        for(char ch: str.toCharArray())
//            if(((int)ch >= 65 && (int)ch <= 90) || ((int)ch >= 97 && (int)ch <= 122) || (Character.getNumericValue(ch) >=0 && Character.getNumericValue(ch) <= 10))
//                res.append(String.valueOf(ch).toLowerCase());
//
//        System.out.println(res.toString());

//        int c = (7 & 1);
//        System.out.println(c);

//        int[] nums = new int[]{2,5,3,1,4,6};
//        int sum = 7, count = 0;
//
//        Set<Integer> set = new HashSet<>();
//
//        for(int num : nums){
//            if(set.contains(num))
//                count++;
//            else
//                set.add(num);
//        }
//        System.out.println(count);
    }
}
