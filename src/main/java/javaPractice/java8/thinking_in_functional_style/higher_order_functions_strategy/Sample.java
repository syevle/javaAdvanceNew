package javaPractice.java8.thinking_in_functional_style.higher_order_functions_strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
  public static int totalSelectedValues(List<Integer> numbers, Predicate<Integer> selector) {
    return numbers.stream()
                  .filter(selector)
                  .mapToInt(e -> e)
                  .sum();
  }
  
	public static void main(String[] args) {
	  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	  
	  System.out.println(totalSelectedValues(numbers, e -> true));
	  System.out.println(totalSelectedValues(numbers, e -> e % 2 == 0));
	  System.out.println(totalSelectedValues(numbers, e -> e % 2 != 0));
	  System.out.println(totalSelectedValues(numbers, e -> e > 4));
	}
}











