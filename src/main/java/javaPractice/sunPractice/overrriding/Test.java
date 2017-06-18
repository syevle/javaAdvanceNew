package javaPractice.sunPractice.overrriding;

/**
 * Created by Santosh on 6/17/17.
 */
class A {
    int i = 10;

    public void printValue() {
        System.out.println("Value-A");
    }
}

class B extends A {
    int i = 12;

    public void printValue() {
        System.out.print("Value-B");
    }
}

public class Test {
    public static void main(String argv[]) {
        A a = new B();
        a.printValue();
        System.out.println(a.i);
    }
}
