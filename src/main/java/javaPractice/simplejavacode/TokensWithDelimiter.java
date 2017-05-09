package javaPractice.simplejavacode;


import java.util.StringTokenizer;

public class TokensWithDelimiter {
    public static void main(String a[]){
        String msg = "http://10.123.43.67:80/";
        StringTokenizer st = new StringTokenizer(msg,"://.",true);
//        StringTokenizer st = new StringTokenizer(msg,"://.",true);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}