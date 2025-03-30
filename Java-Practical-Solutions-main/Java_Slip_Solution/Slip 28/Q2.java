/* 2. Write a java program to display name of currently executing Thread in multithreading. */

public class Q2 { 
 public static void main(String[] args) { 
 Thread t = Thread.currentThread(); 
 System.out.println("Currently executing thread: " + t.getName()); 
 } 
}