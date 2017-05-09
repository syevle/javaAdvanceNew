package javaPractice.java8.java_8_language_capabilities.composing_with_lambda_expressions;

import java.util.Arrays;
import java.util.List;

public class Sample {
  public static boolean isGreaterThan2(int number) {
    return number > 2;
  }
  
  public static boolean isEven(int number) {
    return number % 2 == 0;
  }
  
  public static int doubleIt(int number) {
    return number * 2;
  }
  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    //double the first even number greater than 3 from the list
    
    System.out.println(
      numbers.stream()
      .filter(Sample::isGreaterThan2)
      .filter(Sample::isEven)
      .mapToInt(Sample::doubleIt)
      .findFirst()
      .getAsInt()
    );
  }
}

/*
8
 */