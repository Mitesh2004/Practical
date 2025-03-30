/* 2. Write a SERVLET program which counts how many times a user has visited a web
page. If user is visiting the page for the first time, display a welcome message. If the
user is revisiting the page, display the number of times visited. (Use Cookie) */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Q2 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get cookies from request
        Cookie[] cookies = request.getCookies();
        boolean isNewUser = true;
        int visitCount = 1;

        // Check if the "visit" cookie exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visit")) {
                    visitCount = Integer.parseInt(cookie.getValue()) + 1;
                    isNewUser = false;
                    break;
                }
            }
        }

        // Set or update the "visit" cookie
        Cookie visitCookie = new Cookie("visit", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 365); // Cookie expires after 1 year
        response.addCookie(visitCookie);

        // Display appropriate message
        if (isNewUser) {
            out.println("<h2>Welcome to the web page for the first time!</h2>");
        } else {
            out.println("<h2>Welcome back! You've visited this page " + visitCount + " times.</h2>");
        }

        out.close();
    }
}
