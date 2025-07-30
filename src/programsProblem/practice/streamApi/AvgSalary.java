package programsProblem.practice.streamApi;

import programsProblem.utils.DriverClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AvgSalary implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Delhi", 50000, true),
                new Employee(2, "Bob", "Delhi", 60000, false),
                new Employee(3, "Charlie", "Delhi", 70000, true),
                new Employee(4, "David", "Mumbai", 55000, true),
                new Employee(5, "Eve", "Delhi", 65000, true),
                new Employee(6, "Priya", "Bangalore", 75000.0, true)
        );
        avgSalOfDelhiLoc(employees);
        avgSalByLocation(employees);
    }

    //Finding avg salary of employees who is active and belongs to Delhi location.
    private void avgSalOfDelhiLoc(List<Employee> employees){
        OptionalDouble averageSalary = employees.stream()
                .filter(emp -> emp.isActive() && "Delhi".equalsIgnoreCase(emp.getLocation()))  // Filter active employees in Delhi
                .mapToDouble(Employee::getSalary)   // Map to salary values
       // OR    .mapToDouble(emp -> emp.getSalary())
                .average();     // Calculate average

        averageSalary.ifPresentOrElse(
                avg -> System.out.println("Average salary of active employees in Delhi: " + avg),
                () -> System.out.println("No active employees found in Delhi.")
        );
    }

    private void avgSalByLocation(List<Employee> employees){
        Map<String, Double> averageSalaryByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getLocation,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        // Display the result
        averageSalaryByCity.forEach((city, avgSalary) ->
                System.out.printf("City: %s, Average Salary: %.2f%n", city, avgSalary)
        );

    }

    public static class Employee {
        private final int empId;
        private final String empName;
        private final String location;
        private final double salary;
        private final boolean isActive;

        public Employee(int empId, String empName, String location, double salary, boolean isActive){
            this.empId = empId;
            this.empName = empName;
            this.location = location;
            this.salary = salary;
            this.isActive = isActive;
        }

        public String getLocation(){
            return location;
        }

        public double getSalary(){
            return salary;
        }

        public boolean isActive(){
            return isActive;
        }
    }
}
