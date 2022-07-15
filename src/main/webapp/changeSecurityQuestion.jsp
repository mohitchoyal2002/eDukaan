<%@ include file="changeDetailsHeader.jsp" %>
<%@ page errorPage="error.jsp"%>
<%@ include file="footer.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="project.*" %>
<html>
<head>
<link rel="stylesheet" href="css/changeDetails.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Change Security Question</title>
</head>
<body>
<%
String msg = request.getParameter("msg");
if("done".equals(msg)){
%>
<h3 class="alert">Your security Question successfully changed !</h3>
<%
}
if("wrong".equals(msg)){
%>
<h3 class="alert">Your Password is wrong!</h3>
<%
}if("error".equals(msg)){
%>
<h3 class="alert">Something went wrong ! Please Try Again</h3>
<%
}
%>
<form action="changeSecurity" method="post">
<h3>Select Your New Securtiy Question</h3>
  <select class="input-style" name="securityQuestion">
  		<option value="What is your Birth place ?">What is your Birth place ?</option>
  		<option value="What is Your father name ?">What is your father name ?</option>
  		<option value="What is your pet name ?">What is your pet name ?</option>
  	</select>
 <hr>
 <h3>Enter Your New Answer</h3>
 <input class="input-style" type="text" name="answer" placeholder="Enter Your Answer" required />
<hr>
<h3>Enter Password (For Security)</h3>
<input class="input-style" type="password" name="password" placeholder="Enter Your Password" required />
<hr>
 <button class="input-style" type="submit"> Save <i class='far fa-arrow-alt-circle-right'></i></button>
</form>
</body>
<br><br><br>
</html>