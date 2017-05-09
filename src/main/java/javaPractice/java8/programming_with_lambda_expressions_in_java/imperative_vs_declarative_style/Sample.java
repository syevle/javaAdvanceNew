package javaPractice.java8.programming_with_lambda_expressions_in_java.imperative_vs_declarative_style;

import java.util.Arrays;
import java.util.List;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    int totalOfValuesDoubled = 0;
    for(int number : numbers) {
      totalOfValuesDoubled += number * 2;
    }
    
    System.out.println(totalOfValuesDoubled);
    
    System.out.println(
      numbers.stream()
      .mapToInt(number -> number * 2)
      .sum());
  }
}
