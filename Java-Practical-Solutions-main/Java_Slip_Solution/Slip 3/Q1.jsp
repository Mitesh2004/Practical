<!--****************Slip 3***************-->

<!--1. Write a JSP program to display the details of Patient (PNo, PName, Address, age,
disease) in tabular form on browser. -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Details</title>
</head>
<body>

<%@ page import="java.sql.*" %>

<h2>Patient Details</h2>

<%
    // Declare variables for patient details
    int pno;
    String pname, address, disease;
    int age;

    try {
        // Load JDBC driver
        Class.forName("org.postgresql.Driver");  
        
        // Connect to the database
        Connection con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");  
        
        // Create SQL statement
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Patient"); // Ensure table name matches your DB schema

%>

<!-- Create table layout -->
<table border="1" width="60%" cellspacing="0" cellpadding="10">
    <tr>
        <th>Patient No</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Disease</th>
    </tr>

<%
    // Loop through the ResultSet and display each patient's details
    while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("PNo") %></td>
        <td><%= rs.getString("PName") %></td>
        <td><%= rs.getString("Address") %></td>
        <td><%= rs.getInt("Age") %></td>
        <td><%= rs.getString("Disease") %></td>
    </tr>
<%
    }

    // Close connections
    con.close();

} catch (Exception e) {
    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
}
%>

</table>

</body>
</html>
