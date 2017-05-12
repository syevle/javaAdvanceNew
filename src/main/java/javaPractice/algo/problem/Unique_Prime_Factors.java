package javaPractice.algo.problem;

/**
 *
 Java Program to Perform the Unique Factorization of a Given Number
 This is the java program to find out all the prime factors of a given number.
 Any number can be represented as a product of its prime numbers.
 User have to input the number and output is the list of prime factors.

 Here is the source code of the Java Program to perform the unique factorization of a given number.
 The Java program is successfully compiled and run on a Windows system. The program output is also shown below.
 */
import java.util.HashSet;

import java.util.Scanner;

import java.util.Set;



public class Unique_Prime_Factors

{

    static Set primeFactors(long number)

    {

        long copy = number, i;

        Set primeFactor = new HashSet<>();

        for (i = 2; i <= copy; i++)

        {

            if (copy % i == 0)

            {

                primeFactor.add(i);

                copy /= i;

                i--;

            }

        }

        return primeFactor;

    }



    public static void main(String args[])

    {

        Scanner input = new Scanner(System.in);

        long n;

        System.out.println("Enter the number: ");

        n = input.nextLong();

        System.out.println("The Prime Factors of " + n + " is: "

                + primeFactors(n));

    }

}

/*
$ javac Unique_Prime_Factors.java
$ java Unique_Prime_Factors
Enter the number:
35
The Prime Factors of 35 is: [5, 7]

Enter the number:
1225
The Prime Factors of 1225 is: [5, 7]
 */
