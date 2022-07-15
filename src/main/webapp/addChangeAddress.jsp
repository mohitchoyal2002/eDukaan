<%@ include file="changeDetailsHeader.jsp" %>
<%@ page errorPage="error.jsp"%>
<%@ include file="footer.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="project.*" %>
<html>
<head>
<link rel="stylesheet" href="css/changeDetails.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Change Address</title>
</head>
<body>
<%
String msg = request.getParameter("msg");
if("done".equals(msg)){
%>
<h3 class="alert">Address Successfully Updated !</h3>
<%
}
if("error".equals(msg)){
%>
<h3 class="alert">Some thing Went Wrong! Try Again!</h3>
<%
}
%>

<form method = "post" action="changeAdd">
<h3>Enter Address</h3>
 <input class="input-style" type="text" name ="address" placeholder="Enter Address" required />
 <hr>
 <h3>Enter city</h3>
 <input class="input-style" type="text" name ="city" placeholder="Enter City" required />
<hr>
<h3>Enter State</h3>
<input class="input-style" type="text" name ="state" placeholder="Enter State" required />
<hr>
<h3>Enter country</h3>
<input class="input-style" type="text" name ="country" placeholder="Enter Country" required />
<hr>
 <button class="input-style" type="submit"> Save <i class='far fa-arrow-alt-circle-right'></i></button>
</form>
</body>
<br><br><br>
</html>