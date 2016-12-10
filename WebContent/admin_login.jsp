<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
<link rel="stylesheet" href="Login_css.css" >
<link rel="stylesheet" href="footer.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>
<div id="footer">
 <%@include file="footer.jsp"%>
</div>
<body>
 <%@include file="header.jsp"%>
 <br>
 <br>
 <h1 style="color:#D67F63;text-align:center; margin-top:60px;">ADMIN LOGIN PAGE</h1>
 <div class="log-form">
 
   
    <form action="/CAPSystem/AuthenticateAdmin" method="post">
			<input type="text" name="adminID" class="form-control" id="username" placeholder="LecturerID" />
			<br>		
			    <input type="password"  class="form-control" name="password" id="username" placeholder="Password" />		
			    <br>
			<button type="submit" id="btn">Login</button>	
			
<font face="verdana" color="red"><%
if (request.getSession().getAttribute("status")!=null)
out.println(request.getSession().getAttribute("status")); 
%></font>
	</form>
	</div>
<div>
</div>
</body>

</html>