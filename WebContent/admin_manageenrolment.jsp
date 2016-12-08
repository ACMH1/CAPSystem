<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enrolment Information</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="css/student/student_style.css" rel="stylesheet"
	type="text/css" />

	<%@include file="header.jsp"%>
	<style>
.pagebanner {
	display: none;
}
</style>
</head>
<body id="body">
<%@include file="header.jsp"%>

<div id="wrapper">
  
   <div class="row">
<div class="col-sm-3"  >
        <%@include file="menu.jsp"%>
</div>
 <div>
 <div class="col-sm-9">
 &nbsp;&nbsp;<span id="title"> View Enrollment Page</span>
    <div class="right-content">
					&nbsp;
					<div id="content" class="align" style="height=600px">
		<div id="subtitle">&nbsp;&nbsp;List of Enrolment</div>	
										
 <form action="${pageContext.request.contextPath}/admin_manageenrolment?action=addEnrolment" method="post">
 <h2>CourseID: <input type="number" name="CourseID" value="${param['CourseID']}" readonly="readonly" size=15 maxlength=20></h2>  
 <h2>StudentID: <input type="number" placeholder="example10000" name="StudentID" min=10000  size=15 maxlength=20> <span>${param['studentError']}</span>  </h2>                        
<br/>

<input id="add-button" type="submit" value="Add Enrolment">


</form>
<p class="message">${message}</p>


<h2>${noEnrol}</h2>


 <display:table class="student-list" name="enrolment" pagesize="10" requestURI="/admin_manageenrolment" id="enrolment">
       
     <display:column property="student.studentID" title="StudentID" class="text-center" />
	<display:column property="student.lastName" title="Last Name" class="text-center" />
	<display:column property="student.firstMidName" title="First Mid Name" class="text-center" />
	<display:column property="student.enrolmentDate" title="Registration Date" class="text-center" />
	<display:column property="student.email" title="Email" class="text-center" />
	<display:column title="Delete" >
	<c:url var="delurl" scope="page" value="/admin_manageenrolment">                           
                            <c:param name="StudentID" value="${enrolment.student.getStudentID()}"/>
                            <c:param name="CourseID" value="${param['CourseID']}"/>
                            <c:param name="action" value="delete"/>
                        </c:url>
                        <a href="${delurl}">
                        <button type="submit" id="add-button">
                        <img src="images/delete_student.png" />Delete
                        </button>
                        </a>
	</display:column>
	        
            <display:setProperty name="paging.banner.placement"
									value="bottom" />
			<display:setProperty name="basic.msg.empty_list" value="" />
        </display:table>

    
           
 </div>
 </div>
 </div>
 	<div><%@include file="footer.jsp"%></div>
</body>
</html>