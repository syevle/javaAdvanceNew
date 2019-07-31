package javaPractice.thread.defogexample.sort;


    import java.io.*;
import java.util.*;

    public class SortArray {


        // function for sort array
        static void sortit(int []arr, int n)
        {
            for (int i = 0; i < n; i++)
            {
                arr[i]=i+1;


            }
        }

        // Driver code
        public static void main(String args[])
        {
            int []arr = {10, 7, 9, 2, 8,
                    3, 5, 4, 6, 1};
            int n = arr.length;

            // for sort an array
            sortit(arr, n);

            // for print all the
            // element in sorted way
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }
    }


    /*
    1 2 3 4 5 6 7 8 9 10
     */

// This code is contributed by Manish Shaw
// (manishshaw1)
