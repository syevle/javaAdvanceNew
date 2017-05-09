package javaPractice.java8.lamdaExpression.PredicateTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by anjalhussan on 4/26/16.
 */
public class PredicateFunctionalInterface {

    public static void main(String [] ags){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // find if given parameter is in the list
        //since 10 is in the list, return true;
        boolean ispresent = evaluateNumbers(list,x->x.equals(10));
        System.out.println(ispresent);

        // find if given parameter is in the list
        //since 19 is in the list, return false;
        boolean notpresent = evaluateNumbers(list,x->x.equals(19));
        System.out.println(notpresent);

        //Predicate Chaining
        Predicate<Integer> greaterThanTen = i->i>10;
        Predicate<Integer> smallerThanTwenty = s->s<20;
        //test
        System.out.println("Predicate chaining test:");
        System.out.println(greaterThanTen.and(smallerThanTwenty).test(15)); // true
        System.out.println(greaterThanTen.test(11)); // true
        System.out.println(smallerThanTwenty.test(90)); // false
        System.out.println(greaterThanTen.or(smallerThanTwenty).test(90));//true

    }

    public static boolean evaluateNumbers(List<Integer> list, Predicate<Integer>predicate){
        for (Integer n:list){
            if (predicate.test(n)){
                return true;
            }
        }
        return false;
    }
}
