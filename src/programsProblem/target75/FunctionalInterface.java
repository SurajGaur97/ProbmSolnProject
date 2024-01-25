package programsProblem.target75;

public interface FunctionalInterface {
    static void printMsg() {
        System.out.println("Print msg");
    }

    static void printMsg1() {
        System.out.println("Print msg1");
    }

    void getName();

    void getSalary();

    void getAddress();

    default void getAge() {

    }

    default void getAge1() {

    }
}