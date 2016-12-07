<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="footer.css" >
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
  <form action="courseEnrollment">
   <input type="text" name="cid" placeholder="CourseID" required="required">
   <input type="submit" name="submit">
   </form>
    <c:if test="${fn:length(elist)>0}"> 
 
    <table border=1>
<tr>
<th>#</th>
<th>Student ID</th>
<th>Last Name</th>
<th>FirstMidName</th>
<th>Enrolment Date</th>
<th>Email ID</th>
</tr>
<c:forEach items="${elist}" var="studentDTO" varStatus="status">
<tr>
<td>${status.index}</td>
<td>${studentDTO.getStudentID()}</td>
<td>${studentDTO.getLastName()}</td>
<td>${studentDTO.getFirstMidName()}</td>
<td>${studentDTO.getEnrolmentDate()}</td>
<td>${studentDTO.getEmail()}</td>

</tr>
</c:forEach>

</table>
</c:if>
    
    </div>
</div>
</div>


<div>
<div id="footer">
 <%@include file="footer.jsp"%>
</div>



</body>
</html>