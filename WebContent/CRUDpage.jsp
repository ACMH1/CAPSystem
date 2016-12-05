<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie CRUD</title>
</head>
<body>
<table border=1>
<tr>
<th>#</th>
<th>course id</th>
<th>course name</th>
<th>size</th>
<th>credits</th>
<th>lecturer</th>
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
<td>${CourseDTO.lecturer}</td>
<td>${CourseDTO.startDate}</td>
<td>${CourseDTO.endDate}</td>
<td></td>
<td></td>
</tr>
</c:forEach>

</table>
</body>
</html>