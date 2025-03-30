 /* 2. Write a java program to accept ‘N’ student names through command line, store them
into the appropriate Collection and display them by using Iterator and ListIterator
interface. */
 
 import java.util.ArrayList;
 import java.util.Iterator; 
 import java.util.ListIterator; 
 public class Q2 { 
 public static void main(String[] args) { 
 ArrayList<String> studentNames = new ArrayList<>(); 
 
 for (int i = 0; i < args.length; i++) { 
 studentNames.add(args[i]); 
 } 
 
 System.out.println("Student names using Iterator:"); 
 Iterator<String> iterator = studentNames.iterator(); 
 while (iterator.hasNext()) { 
 System.out.println(iterator.next()); 
 } 
 
 System.out.println("\nStudent names using ListIterator:"); 
 ListIterator<String> listIterator = studentNames.listIterator(); 
 while (listIterator.hasNext()) { 
 System.out.println(listIterator.next());
 } 
 } 
}