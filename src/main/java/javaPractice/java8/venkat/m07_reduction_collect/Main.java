package javaPractice.java8.venkat.m07_reduction_collect;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> roster = createRoster();

        double average = roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        System.out.println("Average age (bulk data operations): " + average);

        Integer totalAge = roster
                .stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println("total age (bulk data operations): " + totalAge);


//        The reduce operation always returns a new value. However, the accumulator function also returns a new value every time
// it processes an element of a stream. Suppose that you want to reduce the elements of a stream to a more complex object,
// such as a collection. This might hinder the performance of your application. If your reduce operation involves adding
// elements to a collection, then every time your accumulator function processes an element,
// it creates a new collection that includes the element, which is inefficient.
// It would be more efficient for you to update an existing collection instead.
// You can do this with the Stream.collect method, which the next section describes.
        Integer totalAgeReduce = roster
                .stream()
                .map(Person::getAge)
                .reduce(
                        0,
                        (a, b) -> a + b);
        System.out.println("total age (bulk data operations): " + totalAgeReduce);

    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2008, 9, 12),
                        Person.Sex.MALE, "bob8@example.com"));

        return roster;
    }
}

