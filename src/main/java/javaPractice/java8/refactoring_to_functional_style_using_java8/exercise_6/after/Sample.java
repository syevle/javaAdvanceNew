package javaPractice.java8.refactoring_to_functional_style_using_java8.exercise_6.after;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Sample {                                         
  public static boolean isPrime(int number) {
    return number > 1 &&
      IntStream.range(2, number)
               .noneMatch(i -> number % i == 0);
  } 
  
  public static double computeSumOfSqrtOfPrimes(int start, int count) {
    return Stream.iterate(start, e -> e + 1)
                 .filter(Sample::isPrime)
                 .mapToDouble(Math::sqrt)
                 .limit(count)
                 .sum();
  } 
  
  public static void main(String[] args) {
    System.out.println(computeSumOfSqrtOfPrimes(101, 51));
  }              
}