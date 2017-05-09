package javaPractice.java8.simplestream;

import java.util.Arrays;
import java.util.Collection;

import static javaPractice.java8.simplestream.SimpleStream.stream;

public class Sample {

  public static void main(String[] args) {
    Collection<Integer> values = Arrays.asList(1, 5, 2, 4, 3);

/* Simpler collector methods */
    stream(values).map(x -> x + 1).toList(); // [2, 6, 3, 5, 4]

/* Less confusing filtering */
    stream(values).select(x -> x % 2 == 0).toList(); // [2, 4]
    stream(values).remove(x -> x % 2 == 0).toList(); // [1, 5, 3]

/* Comparison operations (for streams of Comparable elements) */
    stream(values).min(); // 1
    stream(values).max(); // 5
    stream(values).sort().toList(); // [1, 2, 3, 4, 5]

/* Numeric operations (for streams of numbers) */
    stream(values).sumAsInt(); // 15
    stream(values).average(); // 3.0

/* Miscellaneous operations */
    stream(values).groupBy(x -> x % 2 == 0 ? "even" : "odd"); // {even=[2, 4], odd=[1, 5, 3]}
    stream(values).contains(4); // true
    stream(values).join("+"); // "1+5+2+4+3"
  }
}