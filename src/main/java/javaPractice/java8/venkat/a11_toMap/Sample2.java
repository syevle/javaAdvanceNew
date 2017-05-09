package javaPractice.java8.venkat.a11_toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Sample2 {
    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();

        //create a Map with name and age as key, and the person as value.
        System.out.println("when duplicate object with same key try to add in map.");
        Map<String, Person> p = people.stream()
                .collect(toMap(
                        person -> person.getName() + "-" + person.getAge(),
                        person -> person, (p1, p2) -> p1));

        System.out.println(p);

//      Map<String, Person> p = people.stream()
//              .collect(toMap(
//                      person -> person.getName() + "-" + person.getAge(),
//                      person -> person, (p1, p2) -> {
//                          return p1;
//                      }));
//
//      System.out.println(p);
    }
}

/*
when duplicate object with same key try to add in map.
{Sara-20=Sara -- FEMALE -- 20, Jill-12=Jill -- FEMALE -- 12, Paula-32=Paula -- FEMALE -- 32, Jack-2=Jack -- MALE -- 2, Jack-72=Jack -- MALE -- 72, Sara-22=Sara -- FEMALE -- 22, Paul-32=Paul -- MALE -- 32, Bob-20=Bob -- MALE -- 20}

 */