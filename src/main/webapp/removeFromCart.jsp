<%@ page import="java.sql.*"  %>
<%@page import="project.ConnectionProvider"%>
<%
String email = session.getAttribute("email").toString();
String id = request.getParameter("id");
try{
	Connection con = ConnectionProvider.getCon();
	Statement st = con.createStatement();
	st.executeUpdate("delete from cart where email='"+email+"' and product_id='"+id+"'");
	response.sendRedirect("myCart.jsp?msg=remove");
}
catch(Exception e){
	System.out.println(e);
}
%>