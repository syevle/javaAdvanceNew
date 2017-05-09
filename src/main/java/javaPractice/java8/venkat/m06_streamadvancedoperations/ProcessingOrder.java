package javaPractice.java8.venkat.m06_streamadvancedoperations;

import java.util.stream.Stream;

/**
 * Created by Santosh on 2/25/17.
 */
public class ProcessingOrder {

    public static void main(String[] args) {

        example1();
    }

    static void example1() {
//		An important characteristic of intermediate operations is laziness. Look at this sample where a terminal operation is missing
//		When executing this code snippet, nothing is printed to the console. That is because intermediate operations will only be executed when a terminal operation is present.
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });



        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

//		Executing this code snippet results in the desired output on the console:
/*		filter:  d2
		forEach: d2
		filter:  a2
		forEach: a2
		filter:  b1
		forEach: b1
		filter:  b3
		forEach: b3
		filter:  c
		forEach: c */



//		The operation anyMatch returns true as soon as the predicate applies to the given input element.
//      This is true for the second element passed "A2". Due to the vertical execution of the stream chain,
//      map has only to be executed twice in this case. So instead of mapping all elements of the stream,
//      map will be called as few as possible.

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

// map:      d2
// anyMatch: D2
// map:      a2
// anyMatch: A2


//		Why order matters

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

// map:     d2
// filter:  D2
// map:     a2
// filter:  A2
// forEach: A2
// map:     b1
// filter:  B1
// map:     b3
// filter:  B3
// map:     c
// filter:  C


        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

// filter:  d2
// filter:  a2
// map:     a2
// forEach: A2
// filter:  b1
// filter:  b3
// filter:  c


//        Now, map is only called once so the operation pipeline performs much faster for larger numbers of input elements.
//        Keep that in mind when composing complex method chains.
//                Let's extend the above example by an additional operation, sorted
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        //    Sorting is a special kind of intermediate operation. It's a so called stateful operation since in order to sort a collection of elements you have to maintain state during ordering.
//    Executing this example results in the following console output:
/*
sort:    a2; d2
sort:    b1; a2
sort:    b1; d2
sort:    b1; a2
sort:    b3; b1
sort:    b3; d2
sort:    c; b3
sort:    c; d2
filter:  a2
map:     a2
forEach: A2
filter:  b1
filter:  b3
filter:  c
filter:  d2
 */

//    optimize the performance by reordering the chain
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

// filter:  d2
// filter:  a2
// filter:  b1
// filter:  b3
// filter:  c
// map:     a2
// forEach: A2



    }


}
