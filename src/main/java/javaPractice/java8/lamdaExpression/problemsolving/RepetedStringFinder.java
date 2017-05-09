package javaPractice.java8.lamdaExpression.problemsolving;

/**
 * Created by anjalhussan on 5/4/16.
 */
public class RepetedStringFinder {


/* Problem: Given a string, return true if the first instance of "x"
    in the string is immediately followed by another "x". */



    private static boolean compare (String msg){
        msg=msg.toLowerCase();
        int index = msg.indexOf("x");
        if (index+1<msg.length() && msg.charAt(index+1)=='x'){
            return true;
        }
        return false;
    }

    public static void main(String [] args){
        System.out.println(compare("axxbb"));   // → true
        System.out.println(compare("axaxax") ); // → false
        System.out.println(compare("xxxxx") );  // → true
        System.out.println(compare("xaxxx") );  // → false
        System.out.println(compare("aaaax"));   // → false
        System.out.println(compare(""));        // → false
        System.out.println(compare("abc"));     // → false
        System.out.println(compare("x"));       // → false
        System.out.println(compare("xx"));      // → true
        System.out.println(compare("xax"));     // → false
        System.out.println(compare("xaxx") );   // → false
    }
}
