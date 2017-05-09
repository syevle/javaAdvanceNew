package javaPractice.java8.venkat.m02_flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentSample {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Robert", "5st grade", Arrays.asList(new String[]{"history", "math", "geography"})));
        studentList.add(new Student("Martin", "8st grade", Arrays.asList(new String[]{"economics", "biology"})));
        studentList.add(new Student("Robert", "9st grade", Arrays.asList(new String[]{"science", "math","history"})));

        //Old Code
        Set<String> coursesSet = new HashSet<>();

        for (Student student : studentList) {
            List<String> courses = student.getCourse();
            for (String course : courses) {
                coursesSet.add(course);
            }
        }

        System.out.println("Old way output :");
        System.out.println(coursesSet);


        Set<String> courses = studentList.stream()
                                         .flatMap(e -> e.getCourse().stream())
                                         .collect(Collectors.toSet());

        System.out.println("Java 8 way output :");
        System.out.println(courses);

    }
}











