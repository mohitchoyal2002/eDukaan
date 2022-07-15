<%@page import="project.ConnectionProvider"%>
<%@ include file="header.jsp" %>
<%@ page errorPage="error.jsp" %>
<%@ include file="footer.jsp" %>
<%@ page import="java.sql.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">Home <i class="fa fa-institution"></i></div>
<table>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col"><i class="fa fa-inr"></i> Price</th>
            <th scope="col">Add to cart <i class='fas fa-cart-plus'></i></th>
          </tr>
        </thead>
        <tbody>
			<%
			String search = request.getParameter("search");
			int z=0;
			try{
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();
				String q1 = "select * from product where name like '%"+search+"%' or category like '%"+search+"%' or id like '%"+search+"%' and active='yes'";
				ResultSet rs = st.executeQuery(q1);
				while(rs.next()){
					z=1;
			%>
          <tr>
            <td><%=rs.getString(1) %></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td>
            <td><i class="fa fa-inr"></i> <%=rs.getString(4) %></td>
            <td><a href="addToCartAction.jsp?id=<%=rs.getString(1)%>">Add to cart <i class='fas fa-cart-plus'></i></a></td>
          </tr>
         <%
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
         %>
        </tbody>
      </table>
      	<%
      	if(z==0){
      	%>
	<h1 style="color:white; text-align: center;">Nothing to show</h1>
	<%
      	}
	%>
      <br>
      <br>
      <br>
      <div class="footer">
          <p>All right reserved by Mohit Choyal</p>
      </div>

</body>
</html>