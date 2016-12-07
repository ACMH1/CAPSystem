<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

 <%@include file="header.jsp"%>
 <fmt:setBundle basename="messages" />
<title> <fmt:message key="title.viewcourse"/> </title>
</head>
<body>
<div id="wrapper">
  
   <div class="row">
<div class="col-sm-3"  >
        <%@include file="menu.jsp"%>
</div>
 
 <div>
 <div class="col-sm-9" id="upleft">
     
   
   <table >
<tr>
<th><fmt:message key="label.course.courseId"></fmt:message></th>
 <th><fmt:message key="label.course.courseName"></fmt:message></th>
  <th><fmt:message key="label.course.credit"></fmt:message></th>
   <th><fmt:message key="label.course.lecture"></fmt:message></th>
   <th><fmt:message key="label.course.startdate"></fmt:message></th>
   <th><fmt:message key="label.course.enddate"></fmt:message></th>
   
</tr>
 <c:forEach var="course" items="${courseList}" varStatus="status">
                <tr>
                    
                    <td>${course.courseID}</td>
                    <td>${course.courseName}</td>
                    <td>${course.credits}</td>
                   <td>${course.lecturer.getFirstMidName()}${course.lecturer.getLastName()}</td>
                   <td>${course.startDate}</td>
                   <td>${course.endDate}</td>
                </tr>
            </c:forEach>

</table>
    
    </div>
</div>
</div>

</div>
<div></div>




</body>

 <%@include file="footer.jsp"%>


</html>