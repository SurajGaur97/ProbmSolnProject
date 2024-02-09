package programsProblem.practice;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DriverClass<T> {
    void driverMethod();

    default void printElement(int[] nums) {
        for (int ele : nums){
            System.out.print(ele + " ");
        }
    }

    default void printElement(T[] array) {
        for (T ele : array){
            System.out.print(ele + " ");
        }
    }

    default void printElement(List<T> List) {
        for (T ele : List){
            System.out.print(ele + " ");
        }
    }

    default void printElement(T element) {
        System.out.println(element);
    }

    default void printElement(Set<T> set) {
        for (T ele : set){
            System.out.print(ele + " ");
        }
    }

    default void printElement(Map<T, T> map) {
        for (Map.Entry<T, T> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
