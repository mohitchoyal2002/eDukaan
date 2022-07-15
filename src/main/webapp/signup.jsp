<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>Signup</title>
</head>
<body>
<div id='container'>

<div class='whysign'>

</div>

  <div class='signup'>
  <%
	String msg=request.getParameter("msg");
	if("valid".equals(msg)){
	%>
	
	<h4 class="error"style="color: red;">Successfully Updated</h4>
	<%
	}
	else if("invalid".equals(msg)){
	%>
	
	<h4 class="error"style="color: red;">Something went wrong please try again</h4>
	<%
	}
	%>
  <form action=signup method="post">
  
  	<input type="text" name="name" placeholder="Enter Name" required/>
  	<input type="email" name="email" placeholder="Enter Email" required/>
  	<input type="number" name="mobileNumber" placeholder="Enter Mobile No." required/>
  	<select name="securityQuestion">
  		<option value="What is your Birth place ?">What is your Birth place ?</option>
  		<option value="What is Your father name ?">What is your father name ?</option>
  		<option value="What is your pet name ?">What is your pet name ?</option>
  	</select>
  	<input type="text" name="answer" placeholder="Enter Answer" required/>
  	<input type="password" name="password" placeholder="Enter Password" required/>
  	<input type="submit" value="sign up" />
  </form>
    
      <h5><a class="forgot" href="login.jsp">already a member</a></h5>
  </div>
  
</div>

</body>
</html>