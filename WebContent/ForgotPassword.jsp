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
<form action="LecturerForgotPassword" method="post">
<label>Lecturer ID</label>
<input type=text name="lecid" id="lecid" placeholder="LecturerID" required="required">
<label>EmailID</label>
<input type=text name="email" id="email" placeholder="EmailID"required="required">
<br>
<input type=submit name=submit>

</form>
<h3 style="color:white;">${message}</h1>
</body>
</html>