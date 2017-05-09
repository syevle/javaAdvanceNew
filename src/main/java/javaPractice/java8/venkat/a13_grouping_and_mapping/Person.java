package javaPractice.java8.venkat.a13_grouping_and_mapping;

public class Person {
  private final String name;
  private final Gender gender;
  private final int age;

  public Person(String theName, Gender theGender, int theAge) {
    name = theName;
    gender = theGender;
    age = theAge;
  }

  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  public Gender getGender() { return gender; }
  
  public String toString() {
    return String.format("%s -- %s -- %d", name, gender, age);
  }  
}