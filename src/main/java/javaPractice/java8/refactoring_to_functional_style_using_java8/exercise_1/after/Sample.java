package javaPractice.java8.refactoring_to_functional_style_using_java8.exercise_1.after;

import java.util.stream.IntStream;

class Sample {    
  public static boolean isPrime(int number) {
    return number > 1 && 
      IntStream.range(2, number)
               .noneMatch(i -> number % i == 0);
  } 
  
  public static void main(String[] args) {
    for(int i = 1; i < 8; i++) {
      System.out.printf("isPrime(%d)? %b\n", i, isPrime(i));
    }
  }              
}
