<%@page import="java.sql.*" %>
<%@page import="project.*" %>

<%
try{
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String status = "delivered";
	Connection con = ConnectionProvider.getCon();
	Statement st = con.createStatement();
	st.executeUpdate("update cart set status='"+status+"' where product_id='"+id+"' and email='"+email+"' and address is not NULL");
	response.sendRedirect("ordersReceived.jsp?msg=delivered");
}
catch(Exception e){
	System.out.println(e);
	response.sendRedirect("ordersReceived.jsp?msg=error");
}
%>