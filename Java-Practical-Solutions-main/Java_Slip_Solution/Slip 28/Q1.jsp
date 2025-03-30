<!-- ************* SLIP 28 **************-->

<!-- 1. Write a JSP script to accept a String from a user and display it in reverse order. -->
 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reverse String</title>
</head>
<body>
    <h2>Enter a string to reverse:</h2>
    <form method="post" action="reverse.jsp">
        <input type="text" name="stringToReverse" required>
        <input type="submit" value="Reverse">
    </form>

    <%
        String inputString = request.getParameter("stringToReverse");

        if (inputString != null && !inputString.trim().isEmpty()) {
            // Use StringBuilder for better performance in reversing
            String reversedString = new StringBuilder(inputString).reverse().toString();
            out.print("<h2>Reversed string: <span style='color:blue;'>" + reversedString + "</span></h2>");
        }
    %>
</body>
</html>
