/* 2. Write a SERVLET application to accept username and password, search them into
database, if found then display appropriate message on the browser otherwise display
error message. */

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
public class Q2 extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response) 
 throws ServletException, IOException { 
 response.setContentType("text/html;charset=UTF-8"); 
 PrintWriter out = response.getWriter(); 
 String username = request.getParameter("username"); 
 String password = request.getParameter("password"); 
 try { 
  
 Class.forName("com.mysql.cj.jdbc.Driver"); 
 

 Connection con = 
DriverManager.getConnection("jdbc:mysql:amresh", "postgres", "8624807723"); 
  
 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?"); 
 stmt.setString(1, username); 
 stmt.setString(2, password); 
  
 ResultSet rs = stmt.executeQuery(); 
 
 if (rs.next()) { 
 out.println("<h1>Login successful!</h1>"); 
 } else { 
 out.println("<h1>Error: Invalid username or password.</h1>"); 
 }  
 rs.close(); 
 stmt.close(); 
 con.close(); 
 } catch (ClassNotFoundException | SQLException e) { 
 e.printStackTrace(); 
 } 
 } 
} 