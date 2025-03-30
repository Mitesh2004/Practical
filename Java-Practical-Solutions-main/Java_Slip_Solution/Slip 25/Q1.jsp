<!-- ****** SLip 25 ***********-->

<!-- 1. Write a JSP program to accept Name and Age of Voter and check whether he is
eligible for voting or not. -->

<!-- **********voter.jsp************ -->

<%@ page language="java"%>
<html>
<body>
<%
String Name1= request.getParameter("Name1");
int age= Integer.parseInt(request.getParameter("age"));

if(age>=18)
{
	out.println("You are Eligible for Vote..!"+ Name1);
}
else
{
	out.println("You aren't Eligible for Vote..!" +Name1);
}
%>
</body>
</html>

<!-- ************voter.html******* -->

<html>
<head>
<title> Voter Eligibility Check</title>
</head>
<body>
<form action="voter.jsp">
<h2>Enter the Name:<input type="text" name="name"></h2><br>
<h2>Enter the Age:<input type="text"name="age"></h2><br>
<input type="submit" value="Check Eligibility">
</form>
</body>
</html>
