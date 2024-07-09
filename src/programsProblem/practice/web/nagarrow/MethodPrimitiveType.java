package programsProblem.practice.web.nagarrow;

import programsProblem.practice.common.DriverClass;

public class MethodPrimitiveType implements DriverClass<Integer> {
    static void method(Integer i) {
        System.out.println(1);
    }

    static void method(Double d) {
        System.out.println(2);
    }

    static void method(Number n) {
        System.out.println(4);
    }

    static void method(Object o) {
        System.out.println(5);
    }

    @Override
    public void driverMethod() {
        method((short) 12);
    }

}
