
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>Login</title>
</head>
<body>
<div id='container'>
  <center><h1>eDukaan</h1></center>
  <div class='whysignLogin'>
  

  </div>
  <div class='signup'>
    <%
String msg=request.getParameter("msg");
if("wrong".equals(msg)){
%>

<h4 class="error"style="color: red;">Incorrect Username or Password</h4>

<%
}
if("error".equals(msg)){
%>

<h4 class="error"style="color: red;">something went wrong please try again</h4>

<%
}
%>
    
    <form action="login" method="post">
      <input type="email" name="email" placeholder="Enter Username" required/>
      <input type="password" name="password" placeholder="Enter Password" required/>
      <input type="submit" value="Login">
    </form>
      <h5><a class="forgot" href="forgotPassword.jsp">Forgot Password ?</a></h5>
      <h5><a class="forgot" href="signup.jsp">new member ?</a></h5>
 </div>
</div>

</body>
</html>