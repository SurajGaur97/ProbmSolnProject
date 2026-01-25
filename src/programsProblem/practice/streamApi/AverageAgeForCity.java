package programsProblem.practice.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageAgeForCity {

    private void avgAgeByCity() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Delhi", 30),
                new Employee("Bob", "Delhi", 25),
                new Employee("Charlie", "Mumbai", 35),
                new Employee("David", "Mumbai", 40),
                new Employee("Eve", "Bangalore", 28)
        );

        Map<String, Double> averageAgeByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.averagingInt(Employee::getAge)
                ));

        // Display the result
        averageAgeByCity.forEach((city, avgAge) ->
                System.out.printf("City: %s, Average Age: %.2f%n", city, avgAge)
        );
    }

    private static class Employee {
        private String name;
        private String city;
        private Integer age;

        public Employee(String name, String city, int age) {
            this.name = name;
            this.city = city;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
