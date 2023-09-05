package programsProblem.practice.web;

public class MainClassSample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThreadClass threadClass = new MyThreadClass();
        MyThreadClass threadClass1 = new MyThreadClass();

        threadClass.start();
        threadClass1.start();

        for(int i = 0; i < 5; i++)
            System.out.println("Hi this is main method");
    }
}
