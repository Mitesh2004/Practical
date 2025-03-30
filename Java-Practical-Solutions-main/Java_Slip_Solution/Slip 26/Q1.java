/* *********** SLIP 26 ********* */

/* 1. Write a Java program to delete the details of given employee (ENo EName Salary).
Accept employee ID through command line. (Use PreparedStatement Interface) */

import java.sql.*; 
public class Q1 { 
 public static void main(String[] args) { 
 try 
{ 
  
 Class.forName("com.mysql.jdbc.Driver"); 
  
 String url = "jdbc:postgresql:amresh"; 
 String username = "postgres"; 
 String password = "8624807723"; 
 Connection con = DriverManager.getConnection(url, username, password);  
 PreparedStatement pstmt = con.prepareStatement("DELETE FROM Employee WHERE ENo=?"); 
 
 int employeeID = Integer.parseInt(args[0]); 
 pstmt.setInt(1, employeeID); 
  
 int rowsAffected = pstmt.executeUpdate(); 
 System.out.println(rowsAffected + " row(s) deleted."); 
 
 pstmt.close(); 
 con.close(); 
 } catch (Exception e) { 
 e.printStackTrace(); 
 } 
 } 
}