package javaPractice.java8.venkat.m09_readfile;

/**
 * Created by Santosh on 6/17/17.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

public class ReadWithFilesLines {
    private static final String SEPARATOR = " ";

    public static void main(String[] args) {
        System.out.println("Java 8 Read File Example with Files.lines() function");

        read1();
        read2();

    }

    private static void read1() {
        try {

            Files.lines(new File("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data.txt").toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read2() {
        try {

            Files.readAllLines(Paths.get("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data.txt")).parallelStream()
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    Function<String, String> mapToItem = (line) -> {
//        String[] p = line.split(SEPARATOR);// a CSV has comma separated lines
//        return null;
//    };Function<String, String> mapToItem = (line) -> {
//        String[] p = line.split(SEPARATOR);// a CSV has comma separated lines
//        return null;
//    };
}



