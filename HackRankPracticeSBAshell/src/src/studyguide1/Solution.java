package studyguide1;

import java.util.Scanner;  // Import the Scanner class

import javax.imageio.stream.IIOByteBuffer;

import java.util.LinkedList;
import java.util.Random;

// Convert a static array to a Linked list. 
// Implement the following classes:

// 1. The InvalidNumberException class should inherit the inbuilt 
// Exception class. It should also implement the following methods:

// InvalidNumberException(String message): calls the constructor of 
// the parent class.

// 2. The ArrayToLinkedList class should implement the interface MyLinkList. 
// It should have one class variable of type LinkedList<String>, arrayToList. 
// It should also implement the following methods:

//     ArrayToLinkedList( ): initializes the empty list arrayToList
//
//     void convert(String[] a):  adds the strings in the array a, to the 
//     linkedlist arrayToList. Also prints "I have added the string: {string} at 
//     the node: {index}". For example if the string "abcd" is added at the node 0, 
//     it should print "I have added the string: abcd at node: 0".
//
//     public void reverseLinkedList():  will create a new linked list with contents
//     of the original linked list reversed.
//
//     void replace(int idx): replaces the string at the node idx of arrayToList,
//     with an empty string. Also prints "I have replaced the string: 
//     {string} with a null string". For example if the string "abcd" is replaced 
//     with the empty string, it should print 
//     "I have replaced the string: abcd with a null string".
//
//     LinkedList<String> compact(): It should remove all the empty string from 
//     the linked list and return the resulting list.

//Sample Input For Custom Testing

// 2
// abcd
// 1234

// Sample Output
/*
I have added the string: abcd at the node: 0
I have added the string: 1234 at the node: 1
Original Linked List Order
0 element=abcd
1 element=1234
Reversed Linked List Order
0 element=1234
1 element=abcd
I will call replace this many times=1
I have replaced the string: 1234 with a null string
abcd is an invalid Integer
*/
//Explanation

//The first two lines are printed after the two elements are added. 
//Then original and reverse order of linked list contents will be printed.
//The next line is printed when a string is replaced. The last line 
//was automatically printed.


public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random(0);

        int n = Integer.parseInt(sc.nextLine());
        //System.out.print("DBG1="+n);
        String[] a = new String[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextLine();

        MyLinkList obj = new ArrayToLinkedList();

        obj.convert(a);

        obj.displayList();

        int x = rand.nextInt(n);
        System.out.print("I will call replace this many times=" + x + "\n");
        for (int i = 0; i < x; i++)
            obj.replace(rand.nextInt(n));


        LinkedList<String> s = obj.compact();
        obj.reverseLinkedList();

        for (int i = 0; i < s.size(); i++) {

            if (!isAnInteger(s.get(i))) {
                try {
                    throw new InvalidNumberException(s.get(i) + " is an invalid Integer");
                } catch (InvalidNumberException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(s.get(i) + " is a valid Integer!!");
            }

        }
    }

    public static Boolean isAnInteger(String text) {
        try {
            Integer iiInteger = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}