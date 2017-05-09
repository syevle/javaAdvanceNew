package javaPractice.java8.refactoring_to_functional_style_using_java8.exercise_3.after;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class Sample {    
  public static Map<Integer, List<String>> groupByScores(
    Map<String, Integer> scores) {
                                    
    return scores.keySet()
                 .stream()
                 .collect(groupingBy(scores::get));
  } 
  
  public static void main(String[] args) {
    Map<String, Integer> scores = new HashMap<>();
    
    scores.put("Jack", 12);
    scores.put("Jill", 15);
    scores.put("Tom", 11);
    scores.put("Darla", 15);
    scores.put("Nick", 15);
    scores.put("Nancy", 11);
    
    System.out.println(groupByScores(scores));
  }              
}
