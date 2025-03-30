/* ******** SLIP 30 ******* */

/* 1. Write a java program for the implementation of synchronization.  */

class Counter { 
 private int count = 0;  
 public synchronized void increment() { 
 count++; 
 } 
 public int getCount() { 
 return count; 
 } 
} 
class MyThread extends Thread { 
 private Counter counter; 
 public MyThread(Counter counter) { 
 this.counter = counter; 
 } 
 public void run() { 
 for (int i = 0; i < 1000; i++) { 
 counter.increment(); 
 } 

 } 
} 
public class Q1 { 
 public static void main(String[] args) throws InterruptedException { 
 Counter counter = new Counter(); 
 MyThread thread1 = new MyThread(counter); 
 MyThread thread2 = new MyThread(counter); 
 thread1.start(); 
 thread2.start(); 
 thread1.join(); 
 thread2.join(); 
 System.out.println("Count: " + counter.getCount()); 
 } 
}