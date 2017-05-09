package javaPractice.java8.venkat.m07_reduction_collect;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<Person> roster = createRoster();


//        The Stream.collect Method
//        Unlike the reduce method, which always creates a new value when it processes an element,
// the collect method modifies, or mutates, an existing value.

//        Consider how to find the average of values in a stream. You require two pieces of data: the total number of values
// and the sum of those values. However, like the reduce method and all other reduction methods,
// the collect method returns only one value. You can create a new data type that contains member variables
// that keep track of the total number of values and the sum of those values, such as the following class, Averager:

        Averager averageCollect = roster.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .map(Person::getAge)
                .collect(Averager::new, Averager::accept, Averager::combine);

        System.out.println("Average age of male members: " +
                averageCollect.average());

    /*    The collect operation in this example takes three arguments:

        supplier: The supplier is a factory function; it constructs new instances. For the collect operation, it creates instances of the result container. In this example, it is a new instance of the Averager class.
        accumulator: The accumulator function incorporates a stream element into a result container. In this example, it modifies the Averager result container by incrementing the count variable by one and adding to the total member variable the value of the stream element, which is an integer representing the age of a male member.
        combiner: The combiner function takes two result containers and merges their contents. In this example, it modifies an Averager result container by incrementing the count variable by the count member variable of the other Averager instance and adding to the total member variable the value of the other Averager instance's total member variable.
        Note the following:

        The supplier is a lambda expression (or a method reference) as opposed to a value like the identity element in the reduce operation.
                The accumulator and combiner functions do not return a value.
                You can use the collect operations with parallel streams; see the section Parallelism for more information. (If you run the collect method with a parallel stream, then the JDK creates a new thread whenever the combiner function creates a new object, such as an Averager object in this example. Consequently, you do not have to worry about synchronization.)

                */

//        The collect operation is best suited for collections. The following example puts the names of the male members in a collection with the collect operation:

        List<String> namesOfMaleMembersCollect = roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .map(p -> p.getName())
                .collect(Collectors.toList());
        System.out.println("List  male members: " + namesOfMaleMembersCollect);
//        This version of the collect operation takes one parameter of type Collector.
// This class encapsulates the functions used as arguments in the collect operation that requires
// three arguments (supplier, accumulator, and combiner functions).

     /*   The Collectors class contains many useful reduction operations, such as accumulating elements into collections and summarizing
     elements according to various criteria. These reduction operations return instances of the class Collector,
     so you can use them as a parameter for the collect operation.

                This example uses the Collectors.toList operation, which accumulates the stream elements into a new instance of List.
                As with most operations in the Collectors class, the toList operator returns an instance of Collector, not a collection.
                */
        System.out.println("===============================================");

        Map<Person.Sex, List<Person>> byGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(Person::getGender));
        System.out.println("ByGender members: " + byGender);

        System.out.println("===============================================");

//        The following example retrieves the names of each member in the collection roster and groups them by gender:
        Map<Person.Sex, List<String>> namesByGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getGender,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList())));
        System.out.println("namesByGender members: " + byGender);

//        The following example retrieves the total age of members of each gender:
        System.out.println("===============================================");
        Map<Person.Sex, Integer> totalAgeByGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getGender,
                                        Collectors.reducing(
                                                0,
                                                Person::getAge,
                                                Integer::sum)));

        System.out.println("totalAgeByGender members: " + totalAgeByGender);

       /* The reducing operation takes three parameters:

        identity: Like the Stream.reduce operation, the identity element is both the initial value of the reduction and the default result if there are no elements in the stream. In this example, the identity element is 0; this is the initial value of the sum of ages and the default value if no members exist.
                mapper: The reducing operation applies this mapper function to all stream elements. In this example, the mapper retrieves the age of each member.
                operation: The operation function is used to reduce the mapped values. In this example, the operation function adds Integer values.

                */

//        The following example retrieves the average age of members of each gender:
        System.out.println("===============================================");
        Map<Person.Sex, Double> averageAgeByGender = roster
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.averagingInt(Person::getAge)));
        System.out.println("averageAgeByGender members: " + averageAgeByGender);

        double average = roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("===============================================");
        System.out.println("averageAgeByGender members: " + average);


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

