/* ******** SLIP 27 ********** */

/* 1. Write a Java Program to display the details of College (CID, CName, address, Year)
on JTable.  */

import java.sql.*;
import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
public class Q1 extends JFrame 
{ 
 static final String DB_URL = "jdbc:postgresql://localhost:5432/amresh"; 
 static final String DB_USER = "postgres"; 
 static final String DB_PASSWORD = "8624807723";
 public Q1() { 
 super("College Details"); 
 JTable table = new JTable(); 
 String[] columnNames = {"CID", "CName", "Address", "Year"}; 
 DefaultTableModel model = new DefaultTableModel(columnNames, 0); 
 try { 
  
 Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
 
 
 Statement st = conn.createStatement(); 
  
 ResultSet rs = st.executeQuery("SELECT * FROM college"); 
 
  
 while (rs.next()) { 
 String cid = rs.getString("CID"); 
 String cname = rs.getString("CName"); 
 String address = rs.getString("Address"); 
 int year = rs.getInt("Year"); 
 model.addRow(new Object[] { cid, cname, address, year }); 
 } 
 
  
 rs.close(); 
 st.close(); 
 conn.close(); 
 } 
 catch (SQLException e) 
 { 
 e.printStackTrace(); 
 } 

 table.setModel(model);  
 JScrollPane scrollPane = new JScrollPane(table); 
 
 
 getContentPane().add(scrollPane); 
  
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 setLocationRelativeTo(null); 
 pack(); 
 setVisible(true); 
 } 
 public static void main(String[] args) { 
 new Q1(); 
 } 
}