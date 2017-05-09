package javaPractice.java8.venkat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class ListPractice {
    public static void main(String[] args) {
//        test_1();
//        test_2();
//        test_3();
//        test_4();
//        test_5();
//        test_6();
//        test_7();
        test_8();


    }

    private static void test_1() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        // Find Duplicate numbers.
        Integer[] numbers1 = new Integer[] { 1, 2, 1, 3, 4, 4 };
        Set<Integer> allItems = new HashSet<>();
        Set<Integer> duplicates = Arrays.stream(numbers1)
                .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
                .collect(Collectors.toSet());
        System.out.println(duplicates);
    }

    private static void test_2() {
        List<String> names = asList("John", "Jack", "Jacob");

        names.stream().forEach(name -> System.out.println("Hello " + name + "!"));
    }

    private static void test_3() {
        List<String> names = asList("John", "Jack", "Jacob");

        names.stream()
                .map(name -> "Hello " + name + "!")
                .forEach(System.out::println);

    }

    private static void test_4() {
        List<String> names = asList("John", "Jack", "Jacob");

        List<String> captains = names.stream()
                .map(name -> "Captain " + name)
                .collect(toList());

        System.out.println(captains);

    }

    private static void test_5() {
        List<Integer> numbers = asList(9, 8, 0, 5, 6, 2, 3, 4, 9, 0, 6, 2, 3, 5, 0, 9, 6, 3, 4, 9, 3);

        List<Integer> processed = numbers.stream()
                .distinct()
                .sorted()
                .collect(toList());

        System.out.println(processed);

    }

    private static void test_6() {
        Stream.of(1, 2, 3, 4).reduce((a, b) -> a + b).ifPresent(System.out::println);

        Stream<Integer> emptyStream = Stream.empty();
        Optional<Integer> optionalResult = emptyStream.reduce((a, b) -> a + b);
        System.out.println(optionalResult);

    }

    private static void test_7() {
        // int stream contains extra useful methods such as sum, min or max
        int sum = IntStream.of(1, 2, 3, 4).sum();
        System.out.println(sum);

        List<Integer> list = asList(-1, -2, -3, -4);

//        sum = list.stream().sum(); // doesn't compile, not an int stream
        sum = list.stream().mapToInt(x -> x).sum();
        System.out.println(sum);

    }

    private static void test_8() {
        Stream<Stream<Integer>> streamOfStream = Stream.of(
                Stream.of(1, 2, 3, 4),
                Stream.of(5, 6),
                Stream.of(7, 8, 9)
        );

        Stream<Integer> flattenedStream = streamOfStream.flatMap(stream -> stream);

        String concatenated = flattenedStream
                .map(String::valueOf)
                .collect(joining(", "));

        System.out.println(concatenated);

    }


}
