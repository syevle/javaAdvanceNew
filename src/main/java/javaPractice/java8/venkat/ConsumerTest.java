package javaPractice.java8.venkat;

import java.util.function.Consumer;

/**
 * Created by Santosh on 5/3/17.
 */
public class ConsumerTest {



    public static void main(String[] args) {
        Consumer<String> consumer = ConsumerTest::printNames;
        consumer.accept("Jeremy");
        consumer.accept("Paul");
        consumer.accept("Richard");
    }

    /*private static void printNames(Object o) {
        System.out.println(o);
    }*/

    private static void printNames(String name) {
        System.out.println(name);
    }
}
