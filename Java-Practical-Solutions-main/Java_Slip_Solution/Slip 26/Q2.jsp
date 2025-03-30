<!-- 2. Write a JSP program to calculate sum of first and last digit of a given number. Display
sum in Red Color with font size 18. -->

<!DOCTYPE html> 
<html> 
<head> 
 <title>Sum of First and Last Digit</title> 
</head> 
<body> 
 <h1>Calculate Sum of First and Last Digit</h1> 
 <% 
  int num = Integer.parseInt(request.getParameter("number")); 
 
 int firstDigit = num; 
 while (firstDigit >= 10) { 
 firstDigit /= 10; 
 } 
 int lastDigit = num % 10; 

 int sum = firstDigit + lastDigit; 
 
 out.println("<p style=\"color:red;font-size:18px;\">Sum of first and 
last digit of " + num + " is " + sum + "</p>"); 
 %> 
 <form action="" method="get"> 
 <label for="number">Enter a number:</label> 
 <input type="number" id="number" name="number" required> 
 <button type="submit">Calculate</button> 
 </form> 
</body> 
</html>