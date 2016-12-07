<%@page import="model.CourseDTO"%>
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
 <form action="GradeCourse">
<!--    <input type="text" name="cid" placeholder="CourseID" required="required"> -->


      <select name="cid" required="required" onchange="this.form.submit()">
       <option>Choose</option>
        <c:forEach items="${mlist}" var="CourseDTO" varStatus="status">  
            <option>${CourseDTO.courseID}</option>
    </c:forEach> 
        </select>
           <!-- <input type="submit" name="submit"> -->
         </form>
         
         
         
         
         
    <c:if test="${fn:length(elist)>0}"> 
    
    <table border=1>
<tr>
<th>#</th>
<th>Student ID</th>
<th>Last Name</th>
<th>FirstMidName</th>
<th>Course ID</th>
<th>Grade</th>
</tr>
<c:forEach items="${elist}" var="EnrolmentDTO" varStatus="status">
<tr>
<td>${status.index}</td>
<td>${EnrolmentDTO.getStudent().getStudentID()}</td>
<td>${EnrolmentDTO.getStudent().getLastName()}</td>
<td>${EnrolmentDTO.getStudent().getFirstMidName()}</td>
<td>${EnrolmentDTO.getCourse().getCourseID()}</td>
<td>
<br>
<!-- -->
<form name="button3" action="DeleteUpdateCompleted?studentId=${EnrolmentDTO.getStudent().getStudentID()}&courseId=${EnrolmentDTO.getCourse().getCourseID()}" method="post" >

   <select size="1" name="grade1" required="required"> 
        <option></option>
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>   
    </select>  <td>
 <input type="submit" value="submit"> </td>
</form></td>
 <td>

</td>
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



<br>
<!-- <script src="js.js"></script> -->
</body>
</html>