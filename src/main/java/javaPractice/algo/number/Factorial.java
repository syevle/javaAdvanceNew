package javaPractice.algo.number;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        // get input from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        int fact = calculateFactorial(num);
        System.out.println("Factorial of " + num + " is " + fact);

    }

    private static int calculateFactorial(int num){
        // base case (exit recursion)
        if(num == 1){
            return 1;
        }else{
            return num * calculateFactorial(num - 1);
        }

    }

}
