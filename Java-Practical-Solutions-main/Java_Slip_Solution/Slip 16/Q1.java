/* ********* Slip 16 ********** */
/* 1. Write a java program to create a TreeSet, add some colors (String) and print out the
content of TreeSet in ascending order.  */

import java.io.*;
import java.util.*; 
public class Q1 { 
public static void main(String args[]) throws IOException 
{ 
 Set ts = new TreeSet(); 
 ts.add("Red"); 
 ts.add("Blue"); 
 ts.add("Yellow"); 
 ts.add("Pink"); 
 ts.add("Baby Pink"); 
 System.out.println("TreeSet in ascending order: " + ts); 
 } 
} 
