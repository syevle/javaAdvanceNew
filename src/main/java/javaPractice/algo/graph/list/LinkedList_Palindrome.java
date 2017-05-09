package javaPractice.algo.graph.list;

/**
 * Given a linked list handling string data, check to see whether data is palindrome or not?
 For example,
 Input  : a -> bc -> d -> dcb -> a -> NULL
 Output : True
 String "abcddcba" is palindrome.

 Output : a -> bc -> d -> ba -> NULL
 Output : False
 String "abcdba" is not palindrome.
 We strongly recommend you to minimize your browser and try this yourself first.

 The idea is very simple. Construct a string out of given linked list and check if the constructed string is palindrome or not.

 // Java Program to check if a given linked list of strings
 // form a palindrome
 */
import java.util.Scanner;

// Linked List node
class Node
{
    String data;
    Node next;

    Node(String d)
    {
        data = d;
        next = null;
    }
}

class LinkedList_Palindrome
{
    Node head;

    // A utility function to check if str is palindrome
    // or not
    boolean isPalidromeUtil(String str)
    {
        int length = str.length();

        // Match characters from beginning and
        // end.
        for (int i=0; i<length; i++)
            if (str.charAt(i) != str.charAt(length-i-1))
                return false;

        return true;
    }

    // Returns true if string formed by linked
    // list is palindrome
    boolean isPalindrome()
    {
        Node node = head;

        // Append all nodes to form a string
        String str = "";
        while (node != null)
        {
            str = str.concat(node.data);
            node = node.next;
        }

        // Check if the formed string is palindrome
        return isPalidromeUtil(str);
    }

    /* Driver program to test above function*/
    public static void main(String[] args)
    {
        LinkedList_Palindrome list = new LinkedList_Palindrome();
        list.head = new Node("a");
        list.head.next = new Node("bc");
        list.head.next.next = new Node("d");
        list.head.next.next.next = new Node("dcb");
        list.head.next.next.next.next = new Node("a");

        System.out.println(list.isPalindrome());

    }
}
