package javaPractice.sunPractice;

/**
 * Created by Santosh on 6/6/17.
 */
public class Boxer1{
    Integer i=0;
    int x;
    public Boxer1(int y) {
        x = i+y;
        System.out.println(x);
    }
    public static void main(String[] args) {
        new Boxer1(new Integer(4));
    }
}