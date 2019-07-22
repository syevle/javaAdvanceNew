package javaPractice.javatricky;

/*
LINK :
https://www.journaldev.com/552/java-tricky-interview-questions#java-tricky-interview-question-1-answer-with-explanation

In this case, java compiler will throw error as “The method method(String) is ambiguous
for the type Test” because String and StringBuffer, none of them are more specific to others.
A method is more specific than another if any invocation handled by the first method
could be passed on to the other one without a compile-time type error.

We can pass String as parameter to Object argument and String argument
but not to StringBuffer argument method.
 */
public class Test2 {
    public static void javaHugry(String s){
        System.out.println("String");
    }
    public static void javaHugry(Object s){
        System.out.println("Object");
    }

    public static void method(StringBuffer i){
        System.out.println("StringBuffer impl");
    }

    public static void main(String [] args){
        javaHugry(null);
    }
}
