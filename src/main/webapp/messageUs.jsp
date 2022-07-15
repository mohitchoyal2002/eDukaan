<%@page import="project.ConnectionProvider"%>
<%@ include file="header.jsp" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
<link rel="stylesheet" href="css/messageUs.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Message Us</title>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">Message Us <i class='fas fa-comment-alt'></i></div>
<%
String msg = request.getParameter("msg");
if("done".equals(msg)){
%>
<h3 style="text-align:center; color:yellow;">Message successfully sent. Our team will contact you soon!</h3>
<%
}
if("error".equals(msg)){
%>
<h3 style="text-align:center; ">Some thing Went Wrong! Try Again!</h3>
<%
}
%>
<form method="post" action="message">
<input class="input-style" type="text" name="subject" placeholder="Enter Subject" required>
<hr>
<textarea class="input-style" type="text" name="body" placeholder="Enter Message" ></textarea>
<hr>
<button class="button" type="submit">Send<i class="far fa-arrow-alt-circle-right" ></i></button>

</form>
<br><br><br>
</body>
</html>