package javaPractice.algo.number;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //user input
        System.out.println("Enter how many numbers are needed in Fibonacci series: ");
        int num = input.nextInt();
        for(int i = 1; i <= num; i++){
            System.out.print(printFibonacci(i) + " ");
        }
        input.close();
    }



    private static int printFibonacci(int num){
        //exit condition
        if(num == 1 || num == 2){
            return 1;
        }
        return printFibonacci(num - 1) + printFibonacci(num - 2);
    }

}

/*
Enter how many numbers are needed in Fibonacci series :
12
1 1 2 3 5 8 13 21 34 55 89 144
 */
