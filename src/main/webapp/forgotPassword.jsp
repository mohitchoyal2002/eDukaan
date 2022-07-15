<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>ForgotPassword</title>
</head>
<body>
<div id='container'>
<div class='whyforgotPassword'>
  
  </div>
  <div class='signup'>
  <%
  String msg=request.getParameter("msg");
  if("done".equals(msg)){
  %>
   
<h4 class="error"style="color: red;">Password Changed Successfully!</h4>
<%
  }
  if("invalid".equals(msg)){
%>
<h4 class="error"style="color: red;">Some thing Went Wrong! Try Again !</h4>
<%
  }
%>
     	<form action="forgot" method="post">
     		<input type="text" name="name" placeholder="Enter Name" autofocus required />
     		<input type="email" name="email" placeholder="Enter Email" required />
     		
     		<select name="securityQuestion">
     			<option value="What is your Birth place ?">What is your Birth place ?</option>
		  		<option value="What is Your father name ?">What is your father name ?</option>
		  		<option value="What is your pet name ?">What is your pet name ?</option>
     		</select>
     		<input type="text" name="answer" placeholder="Enter Answer" required />
     		<input type="password" name="new_password" placeholder="Enter Password" required />
     		<input type="submit" value="Save Change" />
     	</form>
      <h5><a class="forgot" href="login.jsp">Login</a></h5>
  </div>
  
</div>
</body>
</html>