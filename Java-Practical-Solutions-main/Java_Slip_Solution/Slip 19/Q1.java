 /* ********************* Slip 19 *************** */

 /* 1. Write a java program to accept ‘N’ Integers from a user store them into LinkedList
Collection and display only negative integers.  */
 
 import java.util.LinkedList; 
 import java.util.Scanner; 
 public class Q1 { 
 public static void main(String[] args) { 
 Scanner sc = new Scanner(System.in); 
 LinkedList<Integer> list = new LinkedList<Integer>(); 

 System.out.print("Enter the number of integers: "); 
 int n = sc.nextInt(); 
 System.out.println("Enter " + n + " integers:"); 
 for (int i = 0; i < n; i++) { 
 int num = sc.nextInt(); 
 list.add(num); 
 } 
 System.out.println("Negative Integers:"); 
 for (int i : list) { 
 if (i < 0) { 
 System.out.println(i); 
 } 
 } 
 } 
} 