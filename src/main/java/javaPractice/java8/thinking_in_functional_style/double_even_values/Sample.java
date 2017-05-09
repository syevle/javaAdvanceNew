package javaPractice.java8.thinking_in_functional_style.double_even_values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Sample {
	public static void main(String[] args) {
	  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	  
	  List<Integer> doubled = new ArrayList<>();
	  for(int value : numbers) {
	    if(value % 2 == 0)
	      doubled.add(value * 2);
	  }
	  
	  System.out.println(doubled);
	  
	  System.out.println(
	    numbers.stream()
	           .filter(e -> e % 2 == 0)
	           .map(e -> e * 2)
	           .collect(toList()));
	}
}











