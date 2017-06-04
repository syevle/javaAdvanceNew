package javaPractice.algo.number;

/*
Java program to check if a given number is an Armstrong number or not can be termed as a fresher level interview question. An  Armstrong number is a number that is equal to the sum of the digits in a number raised to the power of number of digits in the number.

As Example if we take 371, it is an Armstrong number as the number of digits here is 3, so

371 = 33 + 73 + 13 = 27 + 343 + 1 = 371
Another Example is 9474, here the number of digits is 4, so

9474 = 94 + 44 + 74 + 44 = 6561 + 256 + 2401 + 256 = 9474
And obviously 0 and 1 are also Armstrong number.

So let's write a Java program to check whether a given number is an Armstrong number or not.


 */
import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println("Please enter a number : ");
        Scanner scanIn = new Scanner(System.in);
        int scanInput = scanIn.nextInt();
        boolean isArmstrong = checkForArmstrongNo(scanInput);
        if(isArmstrong){
            System.out.println(scanInput + "  is an Armstrong number");
        }else{
            System.out.println(scanInput + " is not an Armstrong number");
        }
        scanIn.close();
    }

    private static boolean checkForArmstrongNo(int number){
        // convert number to String
        String temp = number + "";
        int numLength = temp.length();
        int numCopy = number;
        int sum = 0;
        while(numCopy != 0 ){
            int remainder = numCopy % 10;
            // using Math.pow to get digit raised to the power
            // total number of digits
            sum = sum + (int)Math.pow(remainder, numLength);
            numCopy = numCopy/10;
        }
        System.out.println("sum is " + sum );
        return (sum == number) ? true : false;
    }
}
