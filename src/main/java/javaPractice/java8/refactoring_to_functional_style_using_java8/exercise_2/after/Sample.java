package javaPractice.java8.refactoring_to_functional_style_using_java8.exercise_2.after;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Sample {    
  public static void main(String[] args) {
    try {
      String searchWord = "localhost";
      String path = "/etc/hosts";
      
      long count = Files.lines(Paths.get(path))
                        .filter(line -> line.contains(searchWord))
                        .count();

      System.out.printf("The word %s occured %d times\n", searchWord, count);
    } catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }              
}
