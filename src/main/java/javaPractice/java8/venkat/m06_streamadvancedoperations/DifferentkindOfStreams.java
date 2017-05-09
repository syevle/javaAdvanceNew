package javaPractice.java8.venkat.m06_streamadvancedoperations;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentkindOfStreams {

	public static void main(String[] args) {

		example1();
	}

	static void example1() {
//		Besides regular object streams Java 8 ships with special kinds of streams for working with the primitive
//      data types int, long and double. As you might have guessed it's IntStream, LongStream and DoubleStream
		IntStream.range(1, 4)
				.forEach(System.out::println);


//		All those primitive streams work just like regular object streams with the following differences:
//      Primitive streams use specialized lambda expressions, e.g. IntFunction instead of Function or IntPredicate instead of Predicate.
//      And primitive streams support the additional terminal aggregate operations sum() and average()
		Arrays.stream(new int[] {1, 2, 3})
				.map(n -> 2 * n + 1)
				.average()
				.ifPresent(System.out::println);


//		Sometimes it's useful to transform a regular object stream to a primitive stream or vice versa.
//      For that purpose object streams support the special mapping operations mapToInt(), mapToLong() and mapToDouble
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println);

//      Primitive streams can be transformed to object streams via mapToObj()
		IntStream.range(1, 4)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

//		Here's a combined example: the stream of doubles is first mapped to an int stream and than mapped to an object stream of strings
		Stream.of(1.0, 2.0, 3.0)
				.mapToInt(Double::intValue)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);


	}



}