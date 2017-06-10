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
