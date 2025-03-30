 
 /* ********** SLip 18 *********** */
 /* 1. Write a java program to display name and priority of a Thread.  */
 
 
 public class Q1
{ 
 public static void main(String[] args) 
{ 
 Thread thread = Thread.currentThread(); 
 System.out.println("Thread Name: " + thread.getName()); 
 System.out.println("Thread Priority: " + thread.getPriority()); 
 } 
 } 