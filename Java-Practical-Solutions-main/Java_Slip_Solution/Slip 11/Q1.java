/* ********** SLip 11 ********** */
/* 1. Design an HTML page which passes customer number to a search servlet. The servlet
searches for the customer number in a database (customer table) and returns customer
details if found the number otherwise display error message. */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Q1 extends HttpServlet {
    private Connection conn;

    // Initialize the database connection
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");
        } catch (Exception e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    // Handle GET request from the form
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        try {
            // Get the customer number from the form
            String custNum = req.getParameter("custNum");

            if (custNum == null || custNum.isEmpty()) {
                pw.println("<h3 style='color:red;'>Please enter a Customer Number!</h3>");
                return;
            }

            int customerNumber = Integer.parseInt(custNum);

            // Prepare and execute the SQL query
            String query = "SELECT * FROM customer WHERE cust_number = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, customerNumber);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Display customer details if found
                pw.println("<h2>Customer Details</h2>");
                pw.println("<table border=1 cellpadding=10>");
                pw.println("<tr><th>Customer Number</th><th>Name</th><th>Email</th></tr>");
                pw.println("<tr>");
                pw.println("<td>" + rs.getInt("cust_number") + "</td>");
                pw.println("<td>" + rs.getString("cust_name") + "</td>");
                pw.println("<td>" + rs.getString("cust_email") + "</td>");
                pw.println("</tr>");
                pw.println("</table>");
            } else {
                // Show error message if customer not found
                pw.println("<h3 style='color:red;'>No customer found with number: " + customerNumber + "</h3>");
            }

            // Close resources
            rs.close();
            pst.close();

        } catch (NumberFormatException e) {
            pw.println("<h3 style='color:red;'>Invalid Customer Number. Please enter a number.</h3>");
        } catch (SQLException se) {
            pw.println("<h3 style='color:red;'>Database Error: " + se.getMessage() + "</h3>");
        } catch (Exception e) {
            pw.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        } finally {
            pw.close();
        }
    }

    // Close the connection when the servlet is destroyed
    public void destroy() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
