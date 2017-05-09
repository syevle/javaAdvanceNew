package javaPractice.java8.lamdaExpression.PredicateTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by anjalhussan on 5/5/16.
 */

//use predicates to filter a list and extract information form the list;
public class FilterWithPredicateTest {
    private static List<ITUser> users = Arrays.asList(
            new ITUser(1, "Marc", "Gold", "Director"),
            new ITUser(2, "Brett", "GoodMan", "Director"),
            new ITUser(2,"Gerry", "Mendle", "Manager"),
            new ITUser(3,"Syeed", "Sayem", "Automation Engineer" ),
            new ITUser(4,"Natasha", "Wasik", "QA Analyst")
    );

    private static List<ITUser> filtering(List<ITUser> usr, Predicate<ITUser> prdcte){
        List<ITUser> result = new ArrayList<>();
        for (ITUser user: usr){
            if (prdcte.test(user)){
                result.add(user);
            }
        }


        return result;
    }

    public static void main(String arg[]){
        List<ITUser> directors = filtering(users, (u) -> u.gettitle().equals("Director"));
        directors.parallelStream().forEach(a-> System.out.println(a.gettitle()));
    }


}
