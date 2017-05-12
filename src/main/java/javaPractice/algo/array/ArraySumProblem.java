package javaPractice.algo.array;

import java.util.Scanner;

public class ArraySumProblem {
    public static void main(String[] args) {
        System.out.println("Welcome to Java program to calculate sum of elements in an array");
        System.out.println("Please enter the length of array?");
        Scanner scnr = new Scanner(System.in);
        int length = scnr.nextInt();
        int[] input = new int[length];
        System.out.println("Please enter elements of array");
        for (int i = 0; i < length; i++) {
            input[i] = scnr.nextInt();
        }
        int total = sumOfElements(input);
        System.out.println("Sum of all elements of array is " + total);
        scnr.close();
    }

    /**
     * A Java method to run sum of all elements of given array * * @param array * @return sum of all elements of int array
     */
    public static int sumOfElements(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        return sum;
    }
}

/*
Output
Welcome to Java program to calculate sum of elements in an array
Please enter the length of an array?
4
Please enter elements of array
1 2 2 3
Sum of all elements of array is 8

Welcome to Java program to calculate
sum of elements in an array
 Please enter the length of an array?
 6
 Please enter elements of array
 202 34 56 6 5 46
 Sum of all elements of array is 349

Read more: http://www.java67.com/2016/10/how-to-calculate-sum-of-array-elements-in-java.html#ixzz4gZQjD8vC
 */

