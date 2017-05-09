package javaPractice.java8.thinking_in_functional_style.lambda_vs_closure;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Sample {
  public static int totalSelectedValues(List<Integer> numbers, Predicate<Integer> selector) {
    return numbers.stream()
                  .filter(selector) //there
                  .mapToInt(e -> e)
                  .sum();
  }
  
	public static void main(String[] args) {
	  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	  Predicate<Integer> isGreaterThan3 = e -> e > 3;
	  Predicate<Integer> isGreaterThan4 = e -> e > 4;
	  
	  System.out.println(totalSelectedValues(numbers, isGreaterThan3));
	  System.out.println(totalSelectedValues(numbers, isGreaterThan4));
	  
	  //Above duplicates the logic of comparision.
	  //Not DRY
	  
	  //We know here what we wan to compare. The comparison value, pivot is actually needed above (marked //there)
	  //closures are useful to capture the state from here to send it to there.
	  
	  Function<Integer, Predicate<Integer>> isGreaterThanPivot = pivot -> e -> e > pivot;
	  //In the lambda e -> e -> pivot, e is the parameter, pivot is capture from its lexical scope
	  
	  System.out.println(totalSelectedValues(numbers, isGreaterThanPivot.apply(3)));
	  System.out.println(totalSelectedValues(numbers, isGreaterThanPivot.apply(4)));
	}
}











