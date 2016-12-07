<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="footer.css" >
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie CRUD</title>
</head>
<body>
 <%@include file="header.jsp"%>
 <div class="row">
<div class="col-sm-3"  >
        <%@include file="menu.jsp"%>
</div>
 
 <div>
 <div class="col-sm-9" id="upleft">
    
<table border=1>
<tr>
<th>#</th>
<th>course id</th>
<th>course name</th>
<th>size</th>
<th>credits</th>
<th>start date</th>
<th>end date</th>
</tr>
<c:forEach items="${mlist}" var="CourseDTO" varStatus="status">
<tr>
<td>${status.index}</td>
<td>${CourseDTO.courseID}</td>
<td>${CourseDTO.courseName}</td>
<td>${CourseDTO.size}</td>
<td>${CourseDTO.credits}</td>
<td>${CourseDTO.startDate}</td>
<td>${CourseDTO.endDate}</td>
<td></td>
<td></td>
</tr>
</c:forEach>

</table>    
    </div>
</div>
</div>
<div id="footer">
 <%@include file="footer.jsp"%>
</div>
</body>
</html>