package javaPractice.practice;

/**
 * Created by Santosh on 5/18/17.
 *
 * http://www.programcreek.com/2012/12/leetcode-reverse-integer/
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x%10;
            x = x/10;
        }

        return rev;
    }

    public static void main(String[] args) {

        System.out.println(reverse(1234));
    }

}
