<%@page import="model.CourseDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
<link rel="stylesheet" href="lecturer_style.css" >
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="footer.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie CRUD</title>
</head>
<div id="footer">
 <%@include file="footer.jsp"%>
</div>
<body id="body">
<%@include file="header.jsp"%>
<div class="row">
<div class="col-sm-3"  >
        <%@include file="menu.jsp"%>
</div>
 
 <div>
 <div class="col-sm-9" id="upleft">
   <c:if test="${fn:length(elist)==0}"> 
 <h1 style="color:white;">No details found</h1>
  </c:if>      
    <c:if test="${fn:length(elist)>0}"> 
    <h1 style="color:white;">Grade a Course</h1>
<table border=1 id="tablist" style="width: 90%" >
<tr>
<th class="text-center">S.NO</th>
<th class="text-center">STUDEN ID</th>
<th class="text-center">LAST NAME</th>
<th class="text-center">FIRST NAME</th>
<th class="text-center">COURSE ID</th>
<th class="text-center">GRADE</th>
<th class="text-center">RESPONSE</th>
</tr>
<c:forEach items="${elist}" var="EnrolmentDTO" varStatus="status">
<tr>
<td class="text-center">${status.index}</td>
<td class="text-center">${EnrolmentDTO.getStudent().getStudentID()}</td>
<td class="text-center">${EnrolmentDTO.getStudent().getLastName()}</td>
<td class="text-center">${EnrolmentDTO.getStudent().getFirstMidName()}</td>
<td class="text-center">${EnrolmentDTO.getCourse().getCourseID()}</td>
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
    </select>  <td><input type="submit" value="submit"> </td>
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
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/paging.js"></script> 
<script type="text/javascript">
            $(document).ready(function() {
                $('#tablist').paging({limit:10});
            });
        </script>




<br>
<!-- <script src="js.js"></script> -->
</body>
</html>