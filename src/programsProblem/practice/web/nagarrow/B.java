package programsProblem.practice.web.nagarrow;

public class B extends A {

    public B(int i, int j) {
        super(i * j);

        System.out.println(myMethod(i, j));
    }

    //This method can be in different class also.
    public static void main(String[] args) {
        B b = new B(12, 21);
    }

    int myMethod(int i, int j) {
        return myMethod(i * j);
    }

}
