package javaPractice.java8.thinking_in_functional_style.composition_and_lazy;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
  public static boolean isPrime(int number) {
    return number > 1 && 
      IntStream.range(2, number)
               .noneMatch(index -> number % index == 0);
  }

	public static void main(String[] args) {
    //Find the first prime number greater than 100, where it's sqrt greater than 20
    
    System.out.println(
      Stream.iterate(100, e -> e + 1)
            .filter(e -> isPrime(e))
            .filter(e -> Math.sqrt(e) > 20)
            .findFirst()
            .get());
	}
	
	//Composition makes the code highly expressive.
	//Lazy makes it efficient - sqrt was not performed on any number that's not prime.
	//Execution stops when result encountered.
}











