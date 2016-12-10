<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="css/enroll_style.css" rel='stylesheet' type='text/css'>
 <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

 <%@include file="header.jsp"%>
 <fmt:setBundle basename="messages" />
<title> <fmt:message key="title.grade"/> </title>
   
</head>

<body style="font-family: 'open sans', helvetica, arial, sans;background:url(http://farm8.staticflickr.com/7064/6858179818_5d652f531c_h.jpg) no-repeat center center fixed;-webkit-background-size:
 cover;-moz-background-size: cover;-o-background-size: cover; background-size: cover; ">
 <div class="footer">
 <%@include file="footer.jsp"%> 
 </div>
<div id="wrapper">
  
   <div class="row">
<div class="col-sm-3"  >
   <%@include file="menu.jsp"%>
</div>
 <div>
 <div class="col-sm-9" id="upleft">
  <center> 
<c:if test="${gpa != 'null'}">
Your GPA:<input type="text" value="${gpa}"  readonly="readonly"><br/><br/>
</c:if>

  <c:if test="${ not empty courseGradeList}"> 
  
   <table border=1 width="80%" id="gradeList">
 <thead>
 <tr>
 <th><fmt:message key="label.course.courseId"></fmt:message></th>
 <th><fmt:message key="label.course.courseName"></fmt:message></th>
  <th><fmt:message key="label.course.credit"></fmt:message></th>
   <th><fmt:message key="label.grade"></fmt:message></th>
 </tr>
 </thead>
 <c:forEach var="completed" items="${courseGradeList}" varStatus="status">
                <tr>
                    
                    <td>${completed.getCourse().getCourseID()}</td>
                    <td>${completed.getCourse().getCourseName()}</td>
                    <td>${completed.getCourse().getCredits()}</td>
                    <td>${completed.getGrade()}</td>
                   
                </tr>
    </c:forEach>
  
  </table>
  </c:if>
</center>
    </div>
</div>
</div>

</div>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/paging.js"></script> 
 <script type="text/javascript">
             $(document).ready(function() {
                 $('#gradeList').paging({limit:5});
             });
         </script> 
</body>

 
 
</html>