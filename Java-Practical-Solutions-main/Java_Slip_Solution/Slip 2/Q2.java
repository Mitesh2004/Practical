/*2. Design a servlet that provides information about a HTTP request from a client, such as
IP-Address and browser type. The servlet also provides information about the server on
which the servlet is running, such as the operating system type, and the names of
currently loaded servlets*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Q2 extends HttpServlet 
{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();

        // Get client information
        String userinfo = req.getHeader("User-Agent");
        String ipAddress = req.getRemoteAddr();

        // Get server information
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String serverOS = System.getProperty("os.name");
        String servletName = this.getServletConfig().getServletName();

        // HTML response output
        p.println("<html><head><title>Servlet Info</title></head><body>");
        p.println("<h2>Client Information</h2>");
        p.println("<p><strong>IP Address:</strong> " + ipAddress + "</p>");
        p.println("<p><strong>Browser Details:</strong> " + userinfo + "</p>");

        p.println("<h2>Server Information</h2>");
        p.println("<p><strong>Server Name:</strong> " + serverName + "</p>");
        p.println("<p><strong>Server Port:</strong> " + serverPort + "</p>");
        p.println("<p><strong>Operating System:</strong> " + serverOS + "</p>");
        p.println("<p><strong>Servlet Name:</strong> " + servletName + "</p>");

        // Display all currently loaded servlets
        p.println("<h2>Loaded Servlets:</h2>");
        ServletContext context = getServletContext();
        Enumeration<String> servletNames = context.getServletNames();
        while (servletNames.hasMoreElements()) 
		{
            p.println("<p>Servlet: " + servletNames.nextElement() + "</p>");
        }

        p.println("<br><a href='index.html'>Go Back</a>");
        p.println("</body></html>");

        p.close();
    }
}

/*<!DOCTYPE html>
<html>
<head>
    <title>Servlet Info Form</title>
</head>
<body>
    <h2>Get Your Info!</h2>
    <form action="http://localhost:8080/serv/Q2" method="get">
        Username: <input type="text" name="t1">
        <input type="submit" value="Submit">
    </form>
</body>
</html>*/

