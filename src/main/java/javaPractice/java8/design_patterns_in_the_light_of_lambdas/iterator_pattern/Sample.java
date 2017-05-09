package javaPractice.java8.design_patterns_in_the_light_of_lambdas.iterator_pattern;

import java.util.stream.IntStream;

public class Sample {  
  public static int factorial(int number) {
    int product = 1;
    for(int i = 1; i <= number; i++) {
      product *= i;
    }
    return product;
  }
  
  public static int factorialFunctional(int number) {
    return IntStream.rangeClosed(1, number)
                    .reduce(1, (product, index) -> product * index);
  }
  
  public static void main(String[] args) {
    System.out.println(factorial(5));
    System.out.println(factorialFunctional(5));
  }
}