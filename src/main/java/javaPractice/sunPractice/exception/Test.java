package javaPractice.sunPractice.exception;

/**
 * Created by Santosh on 6/9/17.
 */


public class Test {
    static void test() throws Error {
        if (true) throw new AssertionError();
        System.out.print("test ");
    }
    public static void main(String[] args) {
        try { test(); }
        catch (Exception ex) { System.out.print("exception "); }
        System.out.print("end ");
    }
}
/*
OUTPUT : -
Exception in thread "main" java.lang.AssertionError
	at javaPractice.sunPractice.exception.Test.test(Test.java:10)
	at javaPractice.sunPractice.exception.Test.main(Test.java:14)
 */
