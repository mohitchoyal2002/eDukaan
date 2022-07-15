<%@page import="java.sql.*" %>
<%@page import="project.*" %>

<%
try{
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String status = "canceled";
	Connection con = ConnectionProvider.getCon();
	Statement st = con.createStatement();
	st.executeUpdate("update cart set status='"+status+"' where product_id='"+id+"' and email='"+email+"' and address is not NULL");
	response.sendRedirect("ordersReceived.jsp?msg=cancel");
}
catch(Exception e){
	System.out.println(e);
	response.sendRedirect("ordersReceived.jsp?msg=error");
}
%>