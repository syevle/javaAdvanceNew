package javaPractice.java8.thinking_in_functional_style.immutable_state;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Sample {
	public static void main(String[] args) {
	  List<Integer> prices = Arrays.asList(10, 20, 25, 30, 35, 15);
	  
	  //reduce $1 off each price
	  
    List<Integer> reducedPrices = 
      prices.stream()
            .map(price -> price - 1)
            .collect(toList());
            
    System.out.println(reducedPrices);
	}
}











