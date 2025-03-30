/* *********** Slip 6 ********** */
/*1. Write a Java program to accept ‘n’ integers from the user and store them in a collection.
Display them in the sorted order. The collection should not accept duplicate elements.
(Use a suitable collection). Search for a particular element using predefined search
method in the Collection framework.  */

import java.io.*;
import java.util.*;

class Q1 {
    public static void main(String[] args) throws IOException {
        int no, element;

        // Setup BufferedReader for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Use TreeSet to store elements in sorted order without duplicates
        TreeSet<Integer> ts = new TreeSet<>();

        // Accept number of elements
        System.out.print("Enter the number of elements: ");
        no = Integer.parseInt(br.readLine());

        // Input 'n' elements
        for (int i = 0; i < no; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            element = Integer.parseInt(br.readLine());
            if (ts.add(element)) {
                System.out.println("Element added.");
            } else {
                System.out.println("Duplicate element! Skipping...");
            }
        }

        // Display elements in sorted order
        System.out.println("\nThe elements in sorted order: " + ts);

        // Accept an element to search
        System.out.print("\nEnter element to search: ");
        element = Integer.parseInt(br.readLine());

        // Search the element in the TreeSet
        if (ts.contains(element))
            System.out.println("✅ Element found!");
        else
            System.out.println("❌ Element NOT found!");
    }
}
