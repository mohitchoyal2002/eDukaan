<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body
{
 background-color: #53e7bb;
}

h1{
color: white;
text-align: center;
}
a
{
color:white;}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
<h1>Some thing went Wrong!</h1>
<h1>So go for login! Try again!</h1>
<%
try{
%>
<h1><a href="login.jsp"> Customer login</a></h1>
<h1><a href="../login.jsp"> Admin login</a></h1>
<%
} catch(Exception e){
	out.println("Error 404 try Another link");
	RequestDispatcher rd =request.getRequestDispatcher("error.jsp");
	rd.forward(request, response);
}
%>
</body>
</html>