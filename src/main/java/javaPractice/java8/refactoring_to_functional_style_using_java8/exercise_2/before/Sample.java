package javaPractice.java8.refactoring_to_functional_style_using_java8.exercise_2.before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Sample {    
  public static void main(String[] args) {
    try {
      String searchWord = "localhost";
      String path = "/etc/hosts";
      
      long count = 0;
      BufferedReader bufferedReader =
        new BufferedReader(new FileReader(path));

      String line = null;

      while((line = bufferedReader.readLine()) != null) {
        if(line.contains(searchWord))
          count++;
      }

      System.out.printf("The word %s occured %d times\n", searchWord, count);
    } catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }              
}
