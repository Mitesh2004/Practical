/* ************** SLIP 29 **************** */

/* 1. Write a Java program to display information about all columns in the DONAR table
using ResultSetMetaData.  */

import java.sql.*; 
 public class Q1 { 
 public static void main(String[] args) { 
 String url = "jdbc:pstgresql://localhost:5432/amresh";  
 String username = "postgres"; 
 String password = "8624807723";  
 
 try (Connection con = DriverManager.getConnection(url, username, password)) \
{ 
 String query = "SELECT * FROM DONAR"; 
 PreparedStatement ps = con.prepareStatement(query); 
 ResultSet rs = ps.executeQuery(); 
 
 ResultSetMetaData rsmd = rs.getMetaData(); 
 int columnCount = rsmd.getColumnCount(); 
 
 System.out.println("Column Name\t\tData Type"); 
 System.out.println("------------------------------------------"); 
 
 for (int i = 1; i <= columnCount; i++) { 
 String columnName = rsmd.getColumnName(i); 
 String dataType = rsmd.getColumnTypeName(i); 
 System.out.println(columnName + "\t\t\t" + dataType); 
 } 
 } catch (SQLException e) { 
 System.out.println("Error: " + e.getMessage()); 

 } 
 } 
} 