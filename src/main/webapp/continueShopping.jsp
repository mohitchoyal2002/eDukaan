<%@ page import="project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
<%
String email = session.getAttribute("email").toString();
String status="processing";
try {
	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps = con.prepareStatement("update cart set status=? where email=? and status='bill'");
	ps.setString(1, status);
	ps.setString(2, email);
	ps.executeUpdate();
	response.sendRedirect("home.jsp");
}
catch(Exception e) {
	System.out.println(e);
}
%>
</body>
</html>