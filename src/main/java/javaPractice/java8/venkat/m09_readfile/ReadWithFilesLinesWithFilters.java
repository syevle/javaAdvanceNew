package javaPractice.java8.venkat.m09_readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWithFilesLinesWithFilters {

    public static void main(String[] args) {
        System.out.println("Example of Reading file in Java 8 using Files.lines() by applying filter");

        try {
            Files.lines(Paths.get("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
