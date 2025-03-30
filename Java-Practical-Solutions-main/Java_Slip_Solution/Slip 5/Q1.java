
// ************ Slip 5 *******
/* 1. Write a Java Program to create the hash table that will maintain the mobile number and
student name. Display the details of student using Enumeration interface. */

import java.util.*;

public class Q1 
{
    public static void main(String[] args) 
    {
        // Create a Hashtable to store student names and mobile numbers
        Hashtable<String, String> studentData = new Hashtable<>();

        // Adding student data
        studentData.put("Amresh", "9876543210");
        studentData.put("Mitesh", "9823456789");
        studentData.put("Shubham", "9765432101");

        // Displaying student details using Enumeration
        System.out.println("Student Details (Name : Mobile Number):");
        Enumeration<String> studentNames = studentData.keys();

        while (studentNames.hasMoreElements()) 
        {
            String name = studentNames.nextElement();
            System.out.println(name + " : " + studentData.get(name));
        }

        // Searching for a student
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter student name to search: ");
        String searchName = sc.nextLine();

        if (studentData.containsKey(searchName)) 
        {
            System.out.println("Mobile number of " + searchName + " : " + studentData.get(searchName));
        } 
        else 
        {
            System.out.println("Student not found.");
        }

        // Closing scanner
        sc.close();
    }
}
