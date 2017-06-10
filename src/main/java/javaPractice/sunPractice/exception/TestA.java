package javaPractice.sunPractice.exception;

/**
 * Created by Santosh on 6/9/17.
 */
class TestException extends Exception { }
class A {
    public String sayHello(String name) throws TestException {
        if(name == null) throw new TestException();
        return "Hello " + name;
    }
}
public class TestA {
    public static void main(String[] args) {
//        new A().sayHello("Aiko");
    }
}