package javaPractice.java8.venkat.m06_streamadvancedoperations;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AdvancedOperations {

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

        example1();
    }

    static void example1() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(filtered);    // [Peter, Pamela]

//        The next example groups all persons by age:
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

// age 18: [Max]
// age 23: [Peter, Pamela]
// age 12: [David]

//        Collectors are extremely versatile. You can also create aggregations on the elements of the stream,
//        e.g. determining the average age of all persons:

        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge);     // 19.0

//        If you're interested in more comprehensive statistics, the summarizing collectors return a special built-in summary
//        statistics object. So we can simply determine min, max and arithmetic average age of the persons as well as the sum and count.

        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
// In Germany Max and Peter and Pamela are of legal age.


//        The join collector accepts a delimiter as well as an optional prefix and suffix.
//        In order to transform the stream elements into a map, we have to specify how both the keys and the values should be mapped. Keep in mind that the mapped keys must be unique, otherwise an IllegalStateException is thrown. You can optionally pass a merge function as an additional parameter to bypass the exception:

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
// {18=Max, 23=Peter;Pamela, 12=David}

        map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) ->  name2));

        System.out.println(map);
// {18=Max, 23=Pamela, 12=David}

        map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1));

        System.out.println(map);
// {18=Max, 23=Peter, 12=David}

//        Now that we know some of the most powerful built-in collectors, let's try to build our own special collector.
// We want to transform all persons of the stream into a single string consisting of all names in upper letters
// separated by the | pipe character. In order to achieve this we create a new collector via Collector.of().
// We have to pass the four ingredients of a collector: a supplier, an accumulator, a combiner and a finisher.
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID

//        Since strings in Java are immutable, we need a helper class like StringJoiner to let the collector construct our string.
//        The supplier initially constructs such a StringJoiner with the appropriate delimiter.
//        The accumulator is used to add each persons upper-cased name to the StringJoiner.
//        The combiner knows how to merge two StringJoiners into one. In the last step the finisher constructs the desired String
//        from the StringJoiner.



//        Reduce
//        The reduction operation combines all elements of the stream into a single result.
//        Java 8 supports three different kind of reduce methods.
//        The first one reduces a stream of elements to exactly one element of the stream.
//        Let's see how we can use this method to determine the oldest person:

//        The reduce method accepts a BinaryOperator accumulator function.
//        That's actually a BiFunction where both operands share the same type, in that case Person. BiFunctions are like Function
//        but accept two arguments. The example function compares both persons ages in order to return the person with the maximum age.
        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);    // Pamela



//        The second reduce method accepts both an identity value and a BinaryOperator accumulator.
//        This method can be utilized to construct a new Person with the aggregated names and ages
//        from all other persons in the stream:
        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.age += p2.age;
                            p1.name += p2.name;
                            return p1;
                        });

        System.out.format("name=%s; age=%s", result.name, result.age);
// name=MaxPeterPamelaDavid; age=76


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

}
