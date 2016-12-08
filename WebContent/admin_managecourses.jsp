<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="css/student/student_style.css" rel="stylesheet"
	type="text/css" />
<style>
.pagebanner {
	display: none;
}
</style>
<%@include file="header.jsp"%>
</head>
<body id="body">
	<div id="wrapper container">
		<div class="row">
			<div class="col-sm-3">
				<%@include file="menu.jsp"%>
			</div>

			<div>
				<div class="col-sm-9">
					
							<%
								if (request.getAttribute("usefor").equals("Course")) {
							%>
&nbsp;&nbsp;<span id="title"> Manage Course Page</span>
					<div class="right-content">
						&nbsp;

						<div id="content" class="align">
						
							<div id="subtitle">&nbsp;&nbsp;List of Course</div>
							<br />
							<c:url var="url" scope="page" value="/processCourse.jsp">
							</c:url>
							<a href="${url}"><button id="add-button">
									<img src="images/add_student.png" />Add Course&nbsp;
								</button></a>
								<p class="message">${message}</p>
<center>
							<display:table  name="course" pagesize="10" requestURI="/admin_managecourses"
								id="course" class="student-list">
								<display:column property="courseID" title="CourseID" class="text-center" />
								<display:column property="courseName" title="Course Name" class="text-center" />
								<display:column property="size" title="Course Size" class="text-center" />
								<display:column property="credits" title="Course Credits" class="text-center" />
								<display:column property="lecturer.lecturerID" title="LecturerID" class="text-center" />
								<display:column property="startDate" title="Start Date" class="text-center" />
								<display:column property="endDate" title="End Date" class="text-center" />
								<display:column title="Edit">
								<c:url var="editurl" scope="page"
												value="/admin_managecourses">
												<c:param name="courseID" value="${course.courseID}" />
												<c:param name="action" value="edit" />
											</c:url> <a href="${editurl}">
												<button type="submit" id="add-button">
													<img src="images/edit_student.png" />Edit
												</button>
										</a>
								</display:column>
								<display:column title="Delete">
								<c:url var="delurl" scope="page"
												value="/admin_managecourses">
												<c:param name="courseID" value="${course.courseID}" />
												<c:param name="action" value="delete" />
											</c:url> <a href="${delurl}">
												<button type="submit" id="add-button">
													<img src="images/delete_student.png" />Delete
												</button>
										</a>
								</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />
							
							</display:table>
							</center>
						</div>
					</div>
				
						
						<%
							}
						%>
<%if (request.getAttribute("usefor").equals("enrolment")) {%>
&nbsp;&nbsp;<span id="title"> Manage Enrolment Page</span>
					<div class="right-content">
						&nbsp;

						<div id="content" class="align">
						
<div id="subtitle">&nbsp;&nbsp;List of Course</div>
							<br />
<center>
							<display:table class="student-list" name="course" pagesize="10" requestURI="/admin_managecourses"
								id="course" >
							
							<display:column property="courseID" title="CourseID" class="text-center" />
								<display:column property="courseName" title="Course Name" class="text-center" />
								<display:column property="size" title="Course Size" class="text-center" />
								<display:column property="credits" title="Course Credits" class="text-center" />
								<display:column property="lecturer.lecturerID" title="LecturerID" class="text-center" />
								<display:column property="startDate" title="Start Date" class="text-center" />
								<display:column property="endDate" title="End Date" class="text-center" />
							<display:column title="View">
							<c:url var="viewurl" scope="page" value="/admin_manageenrolment">
                            <c:param name="CourseID" value="${course.courseID}"/>
                             <c:param name="action" value="view"/>
                        </c:url>
                        
                        <a href="${viewurl}"><button type="submit" id="add-button"><img src="images/edit_student.png" />View Enrollment</button></a>
							</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />
							</display:table>
							</center>
			</div>
		</div>

<%}%>
						<!-- content -->
					</div>
	
	</div>		
</div>
</div>



	<div><%@include file="footer.jsp"%></div>


</body>
</html>