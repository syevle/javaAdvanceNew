package javaPractice.java8.venkat.m09_readfile;

/**
 * Created by Santosh on 6/17/17.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWithFilesLines {

    public static void main(String[] args) {
        System.out.println("Java 8 Read File Example with Files.lines() function");

        try {

            Files.lines(new File("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data.txt").toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
