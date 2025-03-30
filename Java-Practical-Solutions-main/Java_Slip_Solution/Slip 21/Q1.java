/* *********** SLip 21 ********** */

/* 1. Write a java program to accept ‘N’ Subject Names from a user store them into
LinkedList Collection and Display them by using Iterator interface. */

import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.Scanner; 
public class Q1 
{ 
 public static void main(String[] args) 
{ 
 Scanner sc = new Scanner(System.in); 
 System.out.print("Enter the number of subjects: "); 
 int n = sc.nextInt(); 
 LinkedList<String> subjects = new LinkedList<String>(); 
 System.out.println("Enter the subject names:"); 
 for (int i = 0; i < n; i++) { 
 String subject = sc.next(); 
 subjects.add(subject); 
 } 
 System.out.println("Subject names:"); 
 Iterator<String> iterator = subjects.iterator(); 
 while (iterator.hasNext()) { 
 String subject = iterator.next(); 
 System.out.println(subject); 
 } 
 } 
}