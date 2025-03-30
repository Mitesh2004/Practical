/*2. Write a Java program to create LinkedList of String objects and perform the following:
i. Add element at the end of the list
ii. Delete first element of the list
iii. Display the contents of list in reverse order */

import java.util.*;

public class Q2 
{

    public static void main(String[] args) 
    {
        LinkedList<String> list = new LinkedList<>();

        // i. Add elements at the end of the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        System.out.println("Original LinkedList: " + list);

        // ii. Delete the first element of the list
        if (!list.isEmpty()) 
        {
            list.removeFirst();
            System.out.println("After deleting first element: " + list);
        } 
        else 
        {
            System.out.println("The list is empty.");
        }

        // iii. Display the contents of the list in reverse order
        System.out.print("List in reverse order: ");
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) 
        {
            System.out.print(iterator.previous() + " ");
        }
    }
}
