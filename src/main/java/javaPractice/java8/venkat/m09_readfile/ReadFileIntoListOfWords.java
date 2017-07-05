package javaPractice.java8.venkat.m09_readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Santosh on 7/5/17.
 */
public class ReadFileIntoListOfWords {
    public static List<String> readFileIntoListOfWords() {
        try {
            return Files.readAllLines(Paths.get("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data3.txt"))
                    .stream()
                    .map(l -> l.split(","))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        System.out.println("Java 8 Read File Example with Files.lines() function");

        List<String> wordList = readFileIntoListOfWords();
        System.out.println(wordList);

        String s1 = new String("santosh");
        String s2 = new String("santosh");

        Set<String> stringset = new HashSet<>();
        stringset.add(s1);
        stringset.add(s2);

        System.out.println(s1 == s2);
//        System.out.println(s2.hashCode());
        System.out.println(stringset.size());

    }
}
