package javaPractice.sunPractice.overrriding;

/**
 * Created by Santosh on 6/9/17.
 */
class TestA {
    public void start() { System.out.println("TestA"); }
}
public class TestB extends TestA {
    public void start() { System.out.println("TestB"); }
    public static void main(String[] args) {
        ((TestA)new TestB()).start();
    }
}