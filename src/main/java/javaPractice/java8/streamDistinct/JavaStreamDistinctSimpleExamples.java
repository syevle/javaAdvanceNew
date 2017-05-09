package javaPractice.java8.streamDistinct;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Santosh on 1/15/17.
 */
public class JavaStreamDistinctSimpleExamples {

    public static void main(String sa[]){
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

// Get collection without duplicate i.e. distinct only
        List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());

//Let's verify distinct elements
        System.out.println(distinctElements);
    }
}
