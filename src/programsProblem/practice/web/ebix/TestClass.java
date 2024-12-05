package programsProblem.practice.web.ebix;

public class TestClass implements TestInterface1, TestInterface2 {

    @Override
    public void method(){
        TestInterface1.super.method();
    }

}
