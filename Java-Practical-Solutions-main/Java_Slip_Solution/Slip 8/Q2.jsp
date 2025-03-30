<!-- 2.Write a JSP program to check whether a given number is prime or not. Display the result
in red color-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prime Number Checker</title>
</head>
<body>
    <h1>Prime Number Checker</h1>
    <form method="post" action="primeChecker.jsp">
        Enter a number: <input type="text" name="n1" />
        <input type="submit" value="Check" />
    </form>

    <% 
    // Get user input
    String n1 = request.getParameter("n1");
    
    if (n1 != null && !n1.isEmpty()) {  
        try {
            int n = Integer.parseInt(n1);
            boolean isPrime = (n > 1); // Assume prime if n > 1

            // Check for divisibility
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            // Display result in red color
    %>
            <h2 style="color: red;">
                <%= n %> is <%= isPrime ? "a prime number." : "not a prime number." %>
            </h2>
    <%
        } catch (NumberFormatException e) {  
    %>
            <h2 style="color: red;">Invalid input! Please enter a valid integer.</h2>
    <%
        }
    }
    %>

</body>
</html>
