package javaPractice.java8.lamdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by anjalhussan on 5/4/16.
 */
public class java8StreamLamda {

    private static List<String> techCompanies = Arrays.asList(
            "Google",
            "Yahoo",
            "Facebook",
            "",
            "Twitter",
            "LinkedIn",
            "");

    public static void main(String args[]){
        System.out.println("Company List: " + techCompanies);

        // print how many empty items in the list
        Long emptyCount = techCompanies.stream().filter(c->c.isEmpty()).count();
        System.out.println("Test1: Number of Empty Strings" + emptyCount);

        //print number of companies who has >6 char in their name
        Long longername = techCompanies.stream().filter(c->c.length()>6).count();
        System.out.println("Test2: Number of companies with char length > 6: " + longername);

        //collect all the items that has >6 char
        List<String> list = techCompanies.stream().filter(c->c.length()>6).collect(Collectors.toList());
        System.out.println("Test3: companies with char length > 6: "+ list);

        // Match the pattern which starts with letter 'T' and print number of items
        Long countT = techCompanies.stream().filter(c->c.startsWith("T")).count();
        System.out.println("Test4: number of companies starts with T is: ".concat(countT.toString()));

        // Match the patter which starts with letter "T" and print all the numbers
        List<String> startsT = techCompanies.stream().filter(t->t.startsWith("T")).collect(Collectors.toList());
        System.out.println("Test5: Companies that starts with T are: ".concat(startsT.toString()));

        // Remove all empty Strings from List
        // we can use ! sign to indicate not equal to our condition
        List<String> newList = techCompanies.stream().filter(x->!x.isEmpty()).collect(Collectors.toList());
        System.out.println("Test6: List without empty name: ".concat(newList.toString()));

        // Convert String to UPPERCASE
        List<String > upperCaseList = techCompanies.stream().map(x->x.toUpperCase()).collect(Collectors.toList());

        // Convert String to UPPERCASE AND join them using space
        String fullsentence =techCompanies.stream().map(x->x.toUpperCase()).collect(Collectors.joining(" "));
        System.out.println("Sentence after converting upper case" +fullsentence);

    }


}
