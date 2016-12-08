<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lecturer Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="shortcut icon" type="image/x-icon" href="pic/cap2.ico" />
<meta name="viewport" content="width=device-width" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
   <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="style.css"/>
<meta charset="UTF-8">
<title>CAPS</title>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>
<body>
 <%@include file="header.jsp"%>
<div id="wrapper">
  
   <div class="row">
<div class="col-sm-3"  >
</div>

 <div>
 <div class="col-sm-9" id="upleft">
   <h1 align="center"> Lecturer Login Page</h1>
    <form action="/CAPSystem/AuthenticateLecturer" method="post" style="">

	<table > 
		<tr>
			<td width="35%">Lecturer ID:</td>
			<td><input type="text" name="lecturerid" size=25 maxlength=30>
			</td>
		</tr>
		<tr>
			<td width="35%">Password:</td>
			<td><input type="text" name="password" size=25 maxlength=30>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="SUBMIT">
			</td>
		</tr>
<font face="verdana" color="red"><%
if (request.getSession().getAttribute("status")!=null)
out.println(request.getSession().getAttribute("status")); 
%></font>
	</table>
	</form>
    
    </div>
</div>
</div>

</div>

<div>
<foot>
 <%@include file="footer.jsp"%>
</foot>
</div>


</body>
</html>