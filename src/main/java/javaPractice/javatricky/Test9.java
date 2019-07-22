package javaPractice.javatricky;

/*
Link : https://www.caveofprogramming.com/java/are-you-a-java-expert-test-your-knowledge-with-these-four-tricky-questions.html

The reason for this is that
the Java compiler parses the unicode character \u000d as a new line and gets transformed into:

 */


class Fruit {
    protected static String name = "Sue";
}

class Apple extends Fruit {

}

public class Test9 {
    public static void main(String[] args) {
        System.out.println(Apple.name);
    }
}

/*
Yes.


The protected access modifier allows variables to be accessed by
derived classes or classes within the same package.
Since all our code here is in the default package, it compiles.
 */