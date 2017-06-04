package javaPractice.algo.number;

import java.util.Scanner;

public class PrintPrime {

    public static void main(String[] args) {
        // take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number till which prime numbers are to be printed - ");
        int num = sc.nextInt();
        for(int i = 2; i <= num; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }

    }

    private static boolean isPrime(int num){
        boolean flag = true;
        // loop from 2, increment it till number/2
        for(int i = 2; i < num/2; i++){
            // no remainder, means divides
            if(num % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
