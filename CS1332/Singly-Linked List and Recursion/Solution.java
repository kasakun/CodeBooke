import java.io.*;
import java.lang.Exception;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Test");
        Recursion recursion = new Recursion();

        System.out.println("Case 0, Palindrome");
        System.out.println("str0: abccba, str1: abcba, str3:abcc.");
        System.out.println("str0:" + recursion.isPalindrome("abccba"));
        System.out.println("str0:" + recursion.isPalindrome("abcba"));
        System.out.println("str0:" + recursion.isPalindrome("abcc"));
        System.out.println("===============================================================");

        System.out.println("Case 1, recursion");
        int x = 10, y = 11;
        System.out.println("gcd (" + x + ", " + y + ") = " + recursion.gcd(x, y));
        x = 8;y = 10;
        System.out.println("gcd (" + x + ", " + y + ") = " + recursion.gcd(x, y));
        x = 100;y = 125;
        System.out.println("gcd (" + x + ", " + y + ") = " + recursion.gcd(x, y));
        System.out.println("===============================================================");
        System.out.println("Case 3, singlylinkedlist.");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println("Test isEmpty()");
        System.out.println("List is empty: " + list.isEmpty());
        System.out.println("Test addToFront(34).");
        list.addToFront(34);
        list.print();
        System.out.println("Test addToBack(45), addToBack(25).");
        list.addToBack(45);
        list.addToBack(25);
        list.print();
        System.out.println("Test addAtIndex(15, 0).");
        list.addAtIndex(15, 0);
        list.print();
        System.out.println("Test addAtIndex(105, 2).");
        list.addAtIndex(105, 2);
        list.print();
        System.out.println("Test addAtIndex(65, 5).");
        list.addAtIndex(75, 4);
        list.print();
        System.out.println("Test addAtIndex(65, 5).");
        list.addAtIndex(65, 5);
        list.print();
        System.out.println("===============================================================");
        System.out.println("Test removeFromFront().");
        System.out.println("Output: " + list.removeFromFront());
        list.print();
        System.out.println("Test removeFromBack().");
        System.out.println("Output: " + list.removeFromBack());
        list.print();
        System.out.println("Test removeAtIndex(3).");
        System.out.println("Output: " + list.removeAtIndex(3));
        list.print();
        System.out.println("===============================================================");
        System.out.println("Test get().");
        list.print();
        System.out.println("Output: get(0), " + list.get(0));
        System.out.println("Output: get(3), " + list.get(3));
        System.out.println("Output: get(2), " + list.get(2));
        System.out.println("===============================================================");
        System.out.println("Test toArray().");
        Object[] arr = list.toArray();
        System.out.print("Output:");
        for(Object ele:arr) 
            System.out.print(" " + ele);
        System.out.println();
        System.out.println("===============================================================");
        System.out.println("Test findLargestElement().");        
        list.print();
        System.out.println("Largest element: " + list.findLargestElement());
    }

}