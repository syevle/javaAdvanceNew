package javaPractice.java8.venkat.m07_reduction_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Santosh on 2/25/17.
 */
public class Reduction {

    public static void main(String[] args) {
		 example1();
    }

    static void example1() {
//        Here the reduce operation accepts two arguments: the first is the identity, that represents the base case, or
// the initial value. The base case will be the default value if the stream is empty. Since we are adding up integer values
// we define the base case as zero.

//        The second argument is the accumulator which also takes two arguments: the first is the current partial result of the reduction.
// The second argument is the current item of the stream that is actually being processed.
// The accumulator must return a result that represents a new partial result.
        List<Integer> integerList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

        int result = integerList
                .stream()
                .filter((i) -> i % 2 == 0)
                .reduce(0, (i1, i2) -> i1 + i2);

    // Will print 20
        System.out.println(result);

        System.out.println("_____________________________");


//        If the initial value argument is omitted from the reduce operation, the first stream element to be processed will be used
// as the initial value. Since the stream may be empty, the return type of this kind of reduction must be of type Optional
// (if the stream is empty and no initial value is specified, the reduction will return an Optional without any wrapped value).
        Optional<Integer> result1 = integerList
                .stream()
                .filter((i) -> i % 2 == 0)
                .reduce((i1, i2) -> i1 + i2);

// Will print 20
        System.out.println(result1.isPresent() ? result1.get() : null);
    }
}
