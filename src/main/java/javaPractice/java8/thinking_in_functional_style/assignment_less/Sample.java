package javaPractice.java8.thinking_in_functional_style.assignment_less;

import java.util.Arrays;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
	  //GOTO is to structured programming like assignment is to functional programming
	  
	  for(int i = 0; i < 10; i++) {
	    if(i > 3)
	      break;
	    System.out.println(i);
	  }
	  
	  //There's no goto in this code, but compile it, run javap -c Sample.class
	  //and take a look at the bytecode. You see the four letter word goto?
	  
	  //Likewise, in the following code
	  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
	  System.out.println(
	    numbers.stream()
	           .mapToInt(e -> e * 2)
	           .sum());
	           
	  //There is not assignment, however, there may be assignment in layers below
	  //at the library level.
	}
}











