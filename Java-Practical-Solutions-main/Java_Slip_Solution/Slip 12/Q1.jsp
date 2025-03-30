<!-- *********************** SLip 12 **********************-->
 <!-- 1. Write a JSP program to check whether given number is Perfect or not. (Use Include
directive).-->

<!DOCTYPE html>
<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>
    <form action="" method="post">
        <label>Enter Number :</label>
        <input type="text" name="num">
        <input type="submit" value="Submit" name="s1">
    </form>
</body>
</html>
<%@ page import="java.util.*" %>

<%
try {
    // Check if the form was submitted
    if (request.getParameter("s1") != null) {
        int num = Integer.parseInt(request.getParameter("num"));
        int sum = 0;

        // Calculate the sum of divisors
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        // Determine if it's a perfect number
        if (sum == num && num != 0) {
            out.println("<h2 style='color:green;'>" + num + " is a Perfect Number!</h2>");
        } else {
            out.println("<h2 style='color:red;'>" + num + " is NOT a Perfect Number!</h2>");
        }
    }
} catch (NumberFormatException e) {
    out.println("<h2 style='color:red;'>Please enter a valid number!</h2>");
}
%>

