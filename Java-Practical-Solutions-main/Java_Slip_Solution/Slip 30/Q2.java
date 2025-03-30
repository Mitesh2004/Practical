/* 2. Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher
table with attributes (TID, TName, Salary) is already created.  */

import java.sql.*; 
public class Q2 { 
 public static void main(String[] args) {
try {  
 Class.forName("com.mysql.jdbc.Driver");  
 Connection con =DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723"); 
 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
 ResultSet rs = st.executeQuery("SELECT * FROM Teacher"); 
 
 rs.last(); 
  
 int rowCount = rs.getRow(); 
 
 rs.beforeFirst(); 

 ResultSetMetaData rsmd = rs.getMetaData(); 
 for (int i = 1; i <= rsmd.getColumnCount(); i++) { 
 System.out.print(rsmd.getColumnName(i) + "\t"); 
 } 
 System.out.println(); 
  
 while (rs.next()) { 
 System.out.print(rs.getInt("TID") + "\t"); 
 System.out.print(rs.getString("TName") + "\t"); 
 System.out.print(rs.getInt("Salary") + "\t"); 
 System.out.println(); 
 } 
 rs.close(); 
 st.close(); 
 con.close(); 
 } 
 catch (Exception ex) 
 { 
 ex.printStackTrace(); 
 } 
 } 
}