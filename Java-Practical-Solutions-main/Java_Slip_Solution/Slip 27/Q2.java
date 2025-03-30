/* 2. Write a SERVLET program to change inactive time interval of session */

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class Q2 extends HttpServlet { 
 public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {  
 
 HttpSession session = request.getSession(); 
 
 session.setMaxInactiveInterval(600); 
  
 response.setContentType("text/html"); 
 PrintWriter out = response.getWriter(); 
 out.println("<html><body>"); 
 out.println("<h3>Session Timeout Changed to 10 Minutes</h3>"); 
 out.println("</body></html>"); 
 } 
} 