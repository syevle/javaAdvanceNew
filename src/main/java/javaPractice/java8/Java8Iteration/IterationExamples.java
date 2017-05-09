package javaPractice.java8.Java8Iteration;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterationExamples {

    public static void main(String[] args){
        List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});

        for(String letter: alphabets){
            System.out.println(letter.toUpperCase());
        }

        Iterator<String> iterator = alphabets.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toUpperCase());
        }

        System.out.println();
        System.out.println("1) Internal iteration");
        alphabets = Arrays.asList(new String[]{"a","b","b","d"});

        alphabets.forEach(l -> l.toUpperCase());
    }
}


/*
A
B
B
D
A
B
B
D
 */