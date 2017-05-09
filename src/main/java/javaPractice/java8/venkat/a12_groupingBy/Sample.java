package javaPractice.java8.venkat.a12_groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Sample {
    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();

        //given a list of people, create a map where
        //their name is the key and value is all the people with that name.

        System.out.println("==================Group By Name=====================");
        Map<String, List<Person>> personsByName = people.stream()
                .collect(groupingBy(Person::getName));

        System.out.println(personsByName);

        System.out.println("=================Group By Age======================");
        Map<Integer, List<Person>> personsByAge = people
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));
        System.out.println(personsByAge);



        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Hello");
        list.add("World");

        Map<String, Long> counted = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(counted);

        Map<String, List<String>> collect = list.stream().collect(
                Collectors.groupingBy(o -> o));
        System.out.println(collect);
        collect.entrySet().forEach(e -> System.out.println(e.getKey() + " >> " + e.getValue().size()));
    }

}