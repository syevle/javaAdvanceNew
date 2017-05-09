package javaPractice.java8.venkat.a04_method_references_different_options;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> dublicateNumbers = Arrays.asList(1,1, 2,2,2, 3, 4, 5, 6, 7, 8, 9, 10);
        
    // numbers.forEach(e -> System.out.println(e));
    // numbers.forEach(System.out::println);

    
    // numbers.stream()
    //        // .map(e -> String.valueOf(e))
    //        .map(String::valueOf)
    //        .forEach(System.out::println);
    
    // numbers.stream()
    //        .map(e -> String.valueOf(e))
    //        // .map(e -> e.toString())
    //        .map(String::toString)
    //        .forEach(System.out::println);

//     System.out.println(
//       numbers.stream()
//              // .reduce(0, (total, e) -> Integer.sum(total, e)));
//              .reduce(0, Integer::sum));

    //Static method call
    System.out.println(
      numbers.stream()
             .map(String::valueOf)
             // .reduce("", (carry, str) -> carry.concat(str)));
             .reduce("", String::concat));


    System.out.println(
            numbers.stream()
                    .map(String::valueOf)
                    .collect(toList()));


    //One way
    Set<Integer> duplicatedNumbersRemovedSet = new HashSet<>();
    Set<Integer> duplicatedNumbersSet = dublicateNumbers.stream()
                                                        .filter(n -> !duplicatedNumbersRemovedSet.add(n))
                                                        .collect(Collectors.toSet());
    System.out.println("find duplicate numbers. "+duplicatedNumbersSet);


//    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 4);
    Set<Integer> duplicated = numbers.stream()
                                     .filter(n -> numbers.stream().filter(x -> x == n).count() > 1)
                                     .collect(Collectors.toSet());
    System.out.println("find duplicate numbers. "+duplicated);

  }
}