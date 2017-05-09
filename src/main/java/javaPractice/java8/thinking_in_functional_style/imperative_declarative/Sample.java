package javaPractice.java8.thinking_in_functional_style.imperative_declarative;

import java.util.Arrays;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
	  List<String> names = Arrays.asList("Sara", "Sam", "Brad", "Bruce", "Kim", "Joseph");
	  
	  boolean found = false;
	  
	  for(String name : names) {
	    if(name.equals("Kim"))
	      found = true;
	  }
	  System.out.println("Found Kim? " + found);
	  
	  System.out.println("Found Kim? " + names.contains("Kim"));	  
	}
}











