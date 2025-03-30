<!-- 2. Write a JSP program to calculate sum of first and last digit of a given number. Display
sum in Red Color with font size 18. -->

<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Calculate Sum of First and Last Digit</h2>
    <form method="post" action="">
        Enter Any Number: <input type="text" name="num" required><br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <%
        // Retrieve number from the form
        String numStr = request.getParameter("num");

        try {
            int n = Integer.parseInt(numStr);
            int firstDigit = 0;
            int lastDigit = n % 10;

            // Get the first digit
            while (n >= 10) {
                n = n / 10;
            }
            firstDigit = n;

            // Calculate the sum of first and last digits
            int sum = firstDigit + lastDigit;

            // Display the result in red color and font size 18
            out.println("Sum of first and last digit is: ");
    %>
            <font size="18" color="red"><%= sum %></font>
    <%
        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red;'>Please enter a valid number!</h3>");
        }
    %>
</body>
</html>

