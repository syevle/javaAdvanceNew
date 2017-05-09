package javaPractice.java8.venkat.m02_flatMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

	public static void main(String[] args) {
		String[] arrayOfWord = {"STACK","OOOVER"};
		Stream<String> streamOfWords =Arrays.stream(arrayOfWord);
//		System.out.println(streamOfWords
//				.map(s-> s.split(""))
//				.map(Arrays::stream)
//				.distinct()
//				.collect(Collectors.toList()).toArray());
//		List<String> words = Arrays.asList("STACK","OOOVER");
//		List tt =words.stream()
//				.map(s-> s.split(""))
//				.map(Arrays::stream)
//				.distinct()
//				.collect(Collectors.toList());
//		System.out.print(tt);

		List<String> words = Arrays.asList("STACK","OOOVER");

		List  outputString1 =words.stream()
				.map(s-> s.split(""))
				.collect(Collectors.toList());
		System.out.print(outputString1);

		List<String>  outputString =words.stream()
				.map(s-> s.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.print(outputString);

	}
}











