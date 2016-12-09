<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
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
  <c:if test="${fn:length(mlist)==0}">
   <h1 style="color:white;">No details found</h1>
  </c:if>
 <c:if test="${fn:length(mlist)>0}">
  <h1 style="color:white;">Courses you Teach</h1>
<table border=1 id="tablist" style="width: 90%" align="left">
<thead>
<tr>
<th class="text-center">S.NO</th>
<th class="text-center">COURSE ID</th>
<th class="text-center">COURSE NAME</th>
<th class="text-center">SIZE</th>
<th class="text-center">CREDITS</th>
<th class="text-center">START DATE</th>
<th class="text-center">END DATE</th>
</tr>
</thead>
<c:forEach items="${mlist}" var="CourseDTO" varStatus="status" >
<tr>
<td class="text-center">${status.index}</td>
<td class="text-center">
<a href="GradeCourse?cid=${CourseDTO.courseID}" id="anc">${CourseDTO.courseID}</a>
</td>
<td class="text-center">${CourseDTO.courseName}</td>
<td class="text-center">${CourseDTO.size}</td>
<td class="text-center">${CourseDTO.credits}</td>
<td class="text-center">${CourseDTO.startDate}</td>
<td class="text-center">${CourseDTO.endDate}</td>

</tr>
</c:forEach>
</table> 
</c:if>
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
</body>
</html>