package javaPractice.algo.number;

import java.util.Scanner;

public class PrimeCheck {

    public static void main(String[] args) {
        // take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number - ");

        int num = sc.nextInt();
        boolean flag = isPrime(num);
        if(flag){
            System.out.println(num + " is a prime number.");
        }else{
            System.out.println(num + " is not a prime number.");
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
