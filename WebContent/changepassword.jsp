<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
<link rel="stylesheet" href="footer.css" >
<link rel="stylesheet" href="lecturer_style.css" >
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie CRUD</title>
</head> <%@include file="header.jsp"%>
  <div id="footer">
 <%@include file="footer.jsp"%>
</div> 
<body id="body">

 <div class="row">
<div class="col-sm-3"  >
        <%@include file="menu.jsp"%>
</div>
 <div class="col-sm-9" id="upleft">
  <h1 style="color:white;">Change Password</h1>
  <br>
  <% if (session.getAttribute("role").equals("admin")) { %> 
<form class="pure-form" action="AdminChangePassword" method=post>
   <div>
        <input type="password" name="oldpassword" placeholder="Old-Password" id="oldpassword" required>
        </div>
<br>
        <input type="password" name="password" placeholder="Password" id="password" required>
        <br>
        <input type="password" placeholder="Confirm Password" id="confirm_password" required>
        <br>

        <button type="submit" class="pure-button pure-button-primary">Confirm</button>
    
</form>
<h3 style="color:white;">${message}</h1>
 <%} %> 
<% if (session.getAttribute("role").equals("student")) { %>
<form class="pure-form" action="StudentChangePassword" method=post>
   <div>
        <input type="password" name="oldpassword" placeholder="Old-Password" id="oldpassword" required>
        </div>
<br>
        <input type="password" name="password" placeholder="Password" id="password" required>
        <br>
        <input type="password" placeholder="Confirm Password" id="confirm_password" required>
        <br>

        <button type="submit" class="pure-button pure-button-primary">Confirm</button>
    
</form>
<h3 style="color:white;">${message}</h1>
<%} %>
<% if (session.getAttribute("role").equals("lecturer")) { %>
<form class="pure-form" action="LecturerChangePassword" method=post>
   <div>
        <input type="password" name="oldpassword" placeholder="Old-Password" id="oldpassword" required>
        </div>
<br>
        <input type="password" name="password" placeholder="Password" id="password" required>
        <br>
        <input type="password" placeholder="Confirm Password" id="confirm_password" required>
        <br>

        <button type="submit" class="pure-button pure-button-primary">Confirm</button>
    
</form>
<h3 style="color:white;">${message}</h1>
<%} %>
<% if (session.getAttribute("role").equals(null)) { %>
<%RequestDispatcher dd = request.getRequestDispatcher("/lecturer_login.jsp");
				dd.forward(request, response);%>
<%} %>
<script>
var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
  </div>
</body>
</html>






































