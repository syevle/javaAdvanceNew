package javaPractice.java8.thinking_in_functional_style.rethinking_how_we_code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sample {
//  public static boolean isPrime(int number) {
//    boolean divisible = false;
//    for(int i = 2; i < number; i++) {
//      if(number % i == 0) {
//        divisible = true;
//        break;
//      }
//    }
//    return number > 1 && !divisible;
//  }
  
  public static boolean isPrime(int number) {
    return number > 1 && 
      IntStream.range(2, number)
               .noneMatch(index -> number % index == 0);
  }
  
	public static void main(String[] args) {
	  List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
	  
    for(int i : list) {
      System.out.println(isPrime(i));
    }
	}
}











