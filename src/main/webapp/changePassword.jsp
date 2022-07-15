<%@ include file="changeDetailsHeader.jsp" %>
<%@ page errorPage="error.jsp"%>
<%@ include file="footer.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="project.*" %>
<html>
<head>
<link rel="stylesheet" href="css/changeDetails.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Change Detail</title>
</head>
<body>
<%
String msg = request.getParameter("msg");
if("notMatch".equals(msg)){
%>
<h3 class="alert">New password and Confirm password does not match!</h3>
<%
}
if("wrong".equals(msg)){
%>
<h3 class="alert">Your old Password is wrong!</h3>
<%
}
if("done".equals(msg)){
%>
<h3 class="alert">Password change successfully!</h3>
<%
}
if("error".equals(msg)){
%>
<h3 class="alert">Some thing went wrong! Try again!</h3>
<%
}
%>
<form action="changePass" method="post">
<h3>Enter Old Password</h3>
 <input class="input-style" type="password" name="oldPass" placeholder="Enter old Password" required>
  <hr>
 <h3>Enter New Password</h3>
 <input class="input-style" type="password" name="newPass" placeholder="Enter New Password" required>
 <hr>
<h3>Enter Confirm Password</h3>
<input class="input-style" type="password" name="verifyPass" placeholder="Confirm Password" required>
<hr>
 <button class="input-style" type="submit"> Save <i class='far fa-arrow-alt-circle-right'></i></button>
</form>
<br><br><br>
</body>
</html>