<!--2. Write a JSP script to accept username and password from user, if they are same then
display “Login Successfully” message in Login.html file, otherwise display “Login
Failed” Message in Error.html file. -->

<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Login page</title>
</head>
<body>
<% String uname=request.getParameter("name");
   String pass=request.getParameter("password");

if(uname.equals("computer") && pass.equals("123"))
      response.sendRedirect("logins.html");
else
      response.sendRedirect("error.html");
%>
</body>
</html>


<!-- logins.html-->
<html>
<body>
<form action="login.jsp">
<h1>Login Successfully!!!</h1>
</form>
</body>
</html>


<!-- login.html-->
<html>
<body>
<form action="login.jsp">
      User name:<input type="text" name="name"><br>
      password:<input type="password" name="password"><br>
      <input type="Submit" value="Sign in">
      <input type="reset" value="clear">
</form>
</body>
</html>
      

<!-- error.html-->
<html>
<body>
<form action="login.jsp">
<h1>Login Fail!! Please Retry</h1></form>
</body>
</html>