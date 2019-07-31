package javaPractice.lamdapractice.PredicateExample;
//http://www.java2s.com/Tutorials/Java/Java_Lambda/0110__Java_Predicate_Interface.htm
import java.util.function.Predicate;
//from w w w  .j  a  v  a2 s.  c om
public class PredicateMain {

    public static void main(String[] args) {
        Predicate<String> i  = (s)-> s.length() > 5;

        System.out.println(i.test("java2s.com "));
    }
}


