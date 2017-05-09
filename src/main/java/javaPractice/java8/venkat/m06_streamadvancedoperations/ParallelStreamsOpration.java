package javaPractice.java8.venkat.m06_streamadvancedoperations;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Santosh on 2/25/17.
 */
public class ParallelStreamsOpration {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

//        example1();
//        example2();
        example3();
    }

    static void example1() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        //        The third reduce method accepts three parameters: an identity value,
//        a BiFunction accumulator and a combiner function of type BinaryOperator.
//        Since the identity values type is not restricted to the Person type,
//        we can utilize this reduction to determine the sum of ages from all persons:
        System.out.println("\n==============================");
        Integer ageSum = persons
                .stream()
                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum);  // 76


        ageSum = persons
                .stream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

// accumulator: sum=0; person=Max
// accumulator: sum=18; person=Peter
// accumulator: sum=41; person=Pamela
// accumulator: sum=64; person=David

//        As you can see the accumulator function does all the work. It first get called with the initial identity value 0 and
//        the first person Max.
//        In the next three steps sum continually increases by the age of the last steps person up to a total age of 76.
//        Wait wat? The combiner never gets called? Executing the same stream in parallel will lift the secret:

        ageSum = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

// accumulator: sum=0; person=Pamela
// accumulator: sum=0; person=David
// accumulator: sum=0; person=Max
// accumulator: sum=0; person=Peter
// combiner: sum1=18; sum2=23
// combiner: sum1=23; sum2=12
// combiner: sum1=41; sum2=35

//        Executing this stream in parallel results in an entirely different execution behavior. Now the combiner is actually called.
//        Since the accumulator is called in parallel, the combiner is needed to sum up the separate accumulated values.

    }

    static void example2() {
//        Streams can be executed in parallel to increase runtime performance on large amount of input elements.
//        Parallel streams use a common ForkJoinPool available via the static ForkJoinPool.commonPool() method.
//        The size of the underlying thread-pool uses up to five threads - depending on the amount of available physical CPU cores:
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    // 3

//        On my machine the common pool is initialized with a parallelism of 3 per default.
//        This value can be decreased or increased by setting the following JVM parameter:


//        -Djava.util.concurrent.ForkJoinPool.common.parallelism=5


    }

    static void example3() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    // 7
    }


//    On my machine the common pool is initialized with a parallelism of 3 per default. This value can be decreased or increased
//    by setting the following JVM parameter:

//    -Djava.util.concurrent.ForkJoinPool.common.parallelism=5

}
