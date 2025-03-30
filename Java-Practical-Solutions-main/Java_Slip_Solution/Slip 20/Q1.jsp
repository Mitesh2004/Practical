<!-- ******** SLip 20 *******-->

<!-- 1. Create a JSP page to accept a number from a user and display it in words: Example:
123 – One Two Three. The output should be in red color. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Number to Words Converter</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        .red {
            color: red;
            font-size: 20px;
        }

        input {
            margin: 5px;
        }
    </style>
</head>

<body>
    <h1>Number to Words Converter</h1>
    <form method="post">
        Enter a number: <input type="text" name="number" />
        <input type="submit" value="Convert" />
    </form>

    <br />

    <%-- Get the number from the request parameter --%>
    <% 
        String numberStr = request.getParameter("number");
        if (numberStr != null && !numberStr.trim().isEmpty()) { 
            numberStr = numberStr.trim();

            // Validate if it's a numeric input
            try {
                Long.parseLong(numberStr); // Ensures only numbers get processed

                // Array of words for each digit
                String[] words = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    %>

    <h2>Converted to Words:</h2>
    <span class="red">
        <% 
            for (int i = 0; i < numberStr.length(); i++) {
                out.print(words[Character.getNumericValue(numberStr.charAt(i))] + " ");
            }
        %>
    </span>

    <% 
            } catch (NumberFormatException e) {
                out.println("<span class='red'>Please enter a valid number!</span>");
            }
        } else {
            out.println("<span class='red'>Please enter a number!</span>");
        }
    %>

</body>
</html>