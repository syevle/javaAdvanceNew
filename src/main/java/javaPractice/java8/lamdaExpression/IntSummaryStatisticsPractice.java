package javaPractice.java8.lamdaExpression;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by anjalhussan on 5/4/16.
 */

    /*A state object for collecting statistics such as count, min, max, sum, and average.*/

public class IntSummaryStatisticsPractice {
    public static void main(String args[]) {
        List<Integer> intlist = Arrays.asList(98, 4, 7, 3, 2, 46, 21, 53, 17, 32, 63, 52);

        // collect all statistical summary into a  list
        IntSummaryStatistics statList = intlist.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("complete stat List is: ".concat(statList.toString()));
        System.out.println("Highest Number: " + statList.getMax());
        System.out.println("Lowest Number: " + statList.getMin());
        System.out.println("Average of the list: " + statList.getAverage());
        System.out.println("Sum of the list: " + statList.getSum());
    }
}
