package javaPractice.java8.venkat.m09_readfile;

/**
 * Created by Santosh on 6/17/17.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWithFilesLinesJava7 {
        private static final String SEPARATOR = " ";

    public static void main(String[] args) {
        System.out.println("Java 8 Read File Example with Files.lines() function");

        read1();

    }

    private static void read1() {
        List<Person> persons = new ArrayList<>();
        try {
            File file = new File("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data3.txt");
            Scanner input = new Scanner(file);

            while(input.hasNext()) {
//                String nextToken = input.next();
                //or to process line by line
                String nextLine = input.nextLine();
                String[] parts = nextLine.split(",");
                String part1 = parts[0].replace('"',' ').trim();
                String part2 = parts[1].replace('"',' ').trim();
                String part3 = parts[2].replace('"',' ').trim();
                String part4 = parts[3].replace('"',' ').trim();
                String part5 = parts[4].replace('"',' ').trim();

                Person person = new Person();
                person.setId(Integer.parseInt(part1));
                person.setSalary(Integer.parseInt(part2));
                person.setType(part3);
                person.setName(part4);
                person.setLocation(part5);
                persons.add(person);
            }

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(persons);
    }
}



