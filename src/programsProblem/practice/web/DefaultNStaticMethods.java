package programsProblem.practice.web;

//@FunctionalInterface  //When applied 1.the interface take only one abstract method and 2.can override multiple Object class's methods and 'default and static' methods (as normal methods can do except point 1).
public interface DefaultNStaticMethods {
    static void getNMsg() {
        System.out.println("static msg1");
    }

    static void getNMsg1() {
        System.out.println("static msg1");
    }

    void abc();

    void bcd();

    @Override
    String toString();

    default void getMsg() {
        System.out.println("default msg");
    }

    default void getMsg1() {
        System.out.println("default msg1");
    }

}
