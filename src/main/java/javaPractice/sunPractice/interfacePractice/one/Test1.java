package javaPractice.sunPractice.interfacePractice.one;

/**
 * Created by Santosh on 6/6/17.
 */
public class Test1 {

    public static void parse(String str) {

        try {
            float f = Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
//            f = 0;
        } finally {
//            System.out.println(f);
        }
    }
    public static void main(String[] args) {
        parse("invalid");
    }
}
