<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setBundle basename="messages" />
<title><fmt:message key="lecturer.title" /></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="css/student/student_style.css" rel="stylesheet"
	type="text/css" />
<%@include file="header.jsp"%>

<style>
#login {
	display: none;
}
.pagebanner {
	display: none;
}
</style>
</head>
<body id="body">
	<div id="wrapper">
		<%
			session.setAttribute("role", "admin");
		%>
		<div class="row">
			<div class="col-sm-3">
				<%@include file="menu.jsp"%>
			</div>


			<div class="col-sm-9">
				&nbsp;&nbsp;<span id="title"> <fmt:message
						key="label.lecturer.title" /></span>

				<div class="right-content">
					&nbsp;

					<div id="content" class="align">

						<div id="subtitle">
							&nbsp;&nbsp;
							<fmt:message key="label.lecturer.subtitle" />
						</div>
						<br /> <a href="add_edit_lecturer.jsp"><button type="submit"
								id="add-button">
								<img src="images/add_student.png" />
								<fmt:message key="button.lecturer.add" />
								&nbsp;
							</button></a> <br />
						<p class="message">${message}</p>
						<p class="error">${error}</p>
						<center>

							<display:table name="llist" pagesize="10" requestURI="/adminlecturer"
								id="llist" class="table-fill">
								<display:column property="lecturerID" title="Lecturer ID"
									class="text-center" />
								<display:column property="firstMidName" title="First Name"
									class="text-center" />
								<display:column property="lastName" title="Last Name"
									class="text-center" />
								<display:column property="email" title=" Email"
									class="text-center" />

								<display:column>
									<c:url var="updurl" scope="page" value="adminlecturer">
										<c:param name="action" value="edit" />
										<c:param name="lecturerId" value="${llist.lecturerID}" />

									</c:url>
									<a href="${updurl}">
										<button type="submit" id="add-button">
											<img src="images/edit_student.png" />
											<fmt:message key="button.lecturer.edit" />
										</button>
									</a>
								</display:column>

								<display:column>
									<c:url var="delurl" scope="page" value="adminlecturer">
										<c:param name="action" value="delete" />
										<c:param name="lecturerId" value="${llist.lecturerID}" />
									</c:url>
									<a href="${delurl}"><button type="submit" id="add-button">
											<img src="images/delete_student.png" />
											<fmt:message key="button.lecturer.delete" />
										</button></a>
								</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />
									</display:table>

								<%-- <table border="1" class="student-list">
								<tr>
									<th class="text-center">Lecturer ID</th>
									<th class="text-center">First Name</th>
									<th class="text-center">Last Name</th>
									<th class="text-center">Email</th>
									<th class="text-center">Action</th>
								</tr>

								<c:forEach var="lecturer" items="${llist}">
									<tr>
										<td class="text-center">${lecturer.lecturerID}</td>
										<td class="text-center">${lecturer.firstMidName}</td>
										<td class="text-center">${lecturer.lastName}</td>
										<td class="text-center">${lecturer.email}</td>
										<td class="text-center"><a
											href="lecturer?action=edit&lecturerId=${lecturer.lecturerID}">
												<button type="submit" id="add-button">
													<img src="images/edit_student.png" />Edit
												</button>
										</a> <a
											href="lecturer?action=delete&lecturerId=${lecturer.lecturerID}">
												<button type="submit" id="add-button">
													<img src="images/delete_student.png" />Delete
												</button>
										</a></td>
									</tr>
								</c:forEach>

							</table> --%>
						</center>
						<br />

					</div>

				</div>

			</div>
		</div>

	</div>



	<div id="below"><jsp:include page="footer.jsp" /></div>
</body>
</html>