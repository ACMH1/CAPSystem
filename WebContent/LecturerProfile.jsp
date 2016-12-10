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
  <h1 style="color:white;">Profile</h1>
  <br>
  
  <table border=1 id="tablist" style="width: 90%" align="left">
<thead>
<tr>
<th class="text-center" style="color:white;">LecturerID:</th>
<td class="text-center" >${plist.getLecturerID()}</td>
</tr>
<tr>
<th class="text-center" style="color:white;">Last Name</th>
<td class="text-center" >${plist.getLastName()}</td>
</tr>
<tr>
<th class="text-center" style="color:white;">First Name</th>
<td class="text-center" >${plist.getFirstMidName()}</td>
</tr>
<tr>
<th class="text-center" style="color:white;">EmailID</th>
<td class="text-center" >${plist.getEmail()}</td> 
</tr>
</thead>
</table> 


  
  
  
  
  
  
  </div>
</body>
</html>






































