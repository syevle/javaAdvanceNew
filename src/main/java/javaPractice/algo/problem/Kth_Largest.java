package javaPractice.algo.problem;

/**
 *
 Java Program to Find kth Largest Element in a Sequence
 This is a java program to find kth largest element form the given sequence of numbers.
 We find the kth largest by sorting the sequence first and then returning the element at position N-k,
 which qualifies as the kth largest element of the sequence.

 Here is the source code of the Java Program to Find kth Largest Element in a Sequence.
 The Java program is successfully compiled and run on a Windows system. The program output is also shown below.
 */
import java.util.Random;

import java.util.Scanner;



public class Kth_Largest

{

    static int N = 20;

    static int []sequence = new int[N];

    public static void sort()

    {

        System.out.println("The Sequence is: ");

        for(int i=0; i<N; i++)

            System.out.print(sequence[i] + " ");

        System.out.println();



        int i, j, temp;

        for (i = 1; i< N; i++)

        {

            j = i;

            temp = sequence[i];

            while (j > 0 && temp < sequence[j-1])

            {

                sequence[j] = sequence[j-1];

                j = j-1;

            }

            sequence[j] = temp;

        }

    }



    public static void main(String args[])

    {

        Random random = new Random();



        for(int i=0; i<N; i++)

            sequence[i] = Math.abs(random.nextInt(100));



        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the kth largest to find");

        int k = sc.nextInt();



        sort();

        System.out.println(k+"th largest element is " + sequence[N-k-1]);

        sc.close();

    }

}

/*
$ javac Kth_Largest.java
$ java Kth_Largest

Enter the kth largest to find
5
The Sequence is:
77 20 91 48 29 55 2 53 29 7 20 91 78 21 87 81 49 53 77 1
5th largest element is 77
 */
