package javaPractice.java8.lamdaExpression.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

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

    List<String> namesUpperCase1 = people.stream()
                    .filter(person -> person.getAge() > 18)
                    .map(person -> person.getName())
                    .map(name -> name.toUpperCase())
                    .collect(Collectors.toList());
    System.out.println(namesUpperCase1);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    //Stream is abstraciton, it is non-mutatting, can't modified,
    //Stream always pipeline.
    List<String> namesUpperCase2 = people.stream()
            .filter(person -> person.getAge() > 18)
            .map(Person::getName)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    System.out.println(namesUpperCase2);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    List<Person> maleList = people.stream()
                    .filter(person -> person.getGender() == Gender.MALE)
                    .collect(Collectors.toList());
    System.out.println(maleList);

    Set<String> maleSet = people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .map(Person::getName)
            .collect(Collectors.toSet());
    System.out.println(maleSet);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    //map - Print all male but in name in upper case, not modified orignal list.
    //her we not modified orignal list, we create all new Person.
    // This is key point.
    List<Person> maleUpperNameList = people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .map(person -> new Person(person.getName().toUpperCase(),person.getGender(),person.getAge()))
            .collect(Collectors.toList());
    System.out.println(maleUpperNameList);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    //Reduce - Reduce give you back to concrete representaion.
    // so Stream take you up, map and filter write stream,Reduce give you back to concrete representaion.
    // Reduce bring down to one or more concrete represention.
    // Total a age of every body.
    int allPersonAge1 = people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .map(Person::getAge)
            .reduce(0,(carry,age) -> carry + age);
    System.out.println(allPersonAge1);

    int allPersonAge2 = people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .map(Person::getAge)
            .reduce(0,Integer::sum);
    System.out.println(allPersonAge2);

    /// below code give compilation error, we can't do sum of person.
//    Integer allPersonAge3 = people.stream()
//            .filter(person -> person.getGender() == Gender.MALE)
//            .map(Person::getAge)
//            .sum());
//    System.out.println(allPersonAge3);

    //mapToInt is like typeCheck, so we convert Stream Collection to Stream Integer.
    // so below not give compilation error.
    int allPersonAge4 = people.stream()
            .filter(person -> person.getGender() == Gender.MALE)
            .mapToInt(Person::getAge)
            .sum();
    System.out.println(allPersonAge4);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");
// find max and max age person
    Optional<Person> maxAgePerson = people.stream()
            .max((person1,person2) ->
                    person1.getAge() > person2.getAge() ? 1:-1);
    System.out.println(maxAgePerson);

// find max and min age person
    Optional<Person> minAgePerson = people.stream()
            .min((person1,person2) ->
                    person1.getAge() > person2.getAge() ? 1:-1);
    System.out.println(minAgePerson);

// count non adult person.
    long countPerson = people.stream()
            .filter(person -> person.getAge() < 18)
            .count();

    System.out.println(countPerson);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

// get all adult name.
// below code give idea about effective and correct code.
    // Please don't do below style code.
    // below code fails in multi thraded enviormnet.
    List<String> worngWayadultNameList = new ArrayList<>();
    people.stream()
            .filter(person -> person.getAge() > 17)
            .map(person -> person.getName().toUpperCase())
            .forEach(name -> worngWayadultNameList.add(name));

    System.out.println(worngWayadultNameList);

    List<String> goodWayList1 = people.stream()
            .filter(person -> person.getAge() > 17)
            .map(person -> person.getName().toUpperCase())
            .collect(Collectors.toList());

    System.out.println(goodWayList1);


    List<String> goodWayList2 = people.stream()
            .filter(person -> person.getAge() > 17)
            .map(person -> person.getName().toUpperCase())
            .collect(() -> new ArrayList<>(),
                    (list,name)->list.add(name),
                    (list1,list2) -> list1.addAll(list2));

    System.out.println(goodWayList2);

    System.out.println("++++++++++++++++++++++++++++++++++++++++");
    Map<String,List<Integer>> map1= people.stream()
            .collect(groupingBy(Person::getName,
                    mapping(Person::getAge, toList())));

    map1.forEach((k,v)->System.out.println(k+" -- "+v));
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    Map<String,List<Person>> map2= people.stream()
            .collect(groupingBy(Person::getName,
                    mapping(person -> person, toList())));

    map2.forEach((k,v)->System.out.println(k+" -- "+v));
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    Map<String,List<Person>> map3= people.stream()
            .collect(groupingBy(Person::getName));

    map3.forEach((k,v)->System.out.println(k+" -- "+v));
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

    //find first person whose name is four letters but is older than 25.

    Optional<Person> person1 =people.stream()
            .filter(person -> person.getName().length() == 4)
            .filter(person -> person.getAge() > 25)
            .findFirst();

    System.out.println(person1);
    System.out.println("++++++++++++++++++++++++++++++++++++++++");

  }
}