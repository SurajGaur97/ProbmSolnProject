package programsProblem.practice.web;

public class LambdaExpression {
    interface Operation {
        int getRes(int a, int b);
    }

    public static void main(String[] args) {
        Operation sum = (int a, int b) -> a + b;
        Operation multiply = (int a, int b) -> a * b;
        Operation subtract = (int a, int b) -> b - a;
        Operation divide = (int a, int b) -> b / a;

        Operation doCal = (int a, int b) -> {
            int c = a * 10 + b;
            int d = b * 10 + a;

            return c + d;
        };

        int a = 10, b = 20;
        System.out.println(sum.getRes(a, b));
        System.out.println(multiply.getRes(a, b));
        System.out.println(subtract.getRes(a, b));
        System.out.println(divide.getRes(a, b));
        System.out.println(doCal.getRes(a, b));
    }
}
