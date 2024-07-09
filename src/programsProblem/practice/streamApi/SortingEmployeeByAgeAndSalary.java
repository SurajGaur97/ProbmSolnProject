package programsProblem.practice.streamApi;

import programsProblem.practice.common.DriverClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @implNote There is an Employee class short the class's list by age in increasing order and if age
 * are equal for 2 employees then sort the employees list by their salary in decreasing order of salary.
 */
public class SortingEmployeeByAgeAndSalary implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1, "Alice", 30, 5000.0f),
                new Employee(2, "Bob", 25, 7000.0f),
                new Employee(3, "Charlie", 30, 6000.0f),
                new Employee(4, "David", 25, 6500.0f)
        ));

        sortTheEmp(employees);

        employees.forEach(System.out::println);
    }

    private void sortTheEmp(List<Employee> employees) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int ageComparator = Integer.compare(o1.getAge(), o2.getAge());
                if(ageComparator != 0)
                    return ageComparator;
                else
                    return Float.compare(o1.getSalary(), o2.getSalary());
            }
        });
    }
}

class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final float salary;

    public Employee(int id, String name, int age, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}
