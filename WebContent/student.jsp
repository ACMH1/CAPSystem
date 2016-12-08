<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setBundle basename="messages" />
<title><fmt:message key="student.title" /></title>
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
	<div id="wrapper">
		<%
			session.setAttribute("role", "admin");
		%>
		<div class="row">
			<div class="col-sm-3">
				<%@include file="menu.jsp"%>
			</div>


			<div class="col-sm-9">
				&nbsp;&nbsp;<span id="title"><fmt:message
						key="label.student.title" /> </span>

				<div class="right-content">
					&nbsp;

					<div id="content" class="align">
						<div id="subtitle">
							&nbsp;&nbsp;
							<fmt:message key="label.student.subtitle" />
						</div>
						<br /> <a href="add_edit_student.jsp"><button type="submit"
								id="add-button">
								<img src="images/add_student.png" />
								<fmt:message key="button.student.add" />
								&nbsp;
							</button></a>
						<p class="message">${message}</p>
						<p class="error">${error}</p>
						<center>
							<display:table name="slist" pagesize="10" requestURI="/student"
								id="slist" class="table-fill">
								<display:column property="studentID" title="Student ID"
									class="text-center" />
								<display:column property="firstMidName" title="First Name" class="text-center" />
								<display:column property="lastName" title="Last Name" class="text-center"/>
								<display:column property="email" title=" Email" class="text-center"/>

								<display:column>
									<c:url var="updurl" scope="page" value="student">
										<c:param name="action" value="edit" />
										<c:param name="studentId" value="${slist.studentID}" />

									</c:url>
									<a href="${updurl}">
										<button type="submit" id="add-button">
											<img src="images/edit_student.png" />
											<fmt:message key="button.student.edit" />
										</button>
									</a>
								</display:column>

								<display:column>
									<c:url var="delurl" scope="page" value="student">
										<c:param name="action" value="delete" />
										<c:param name="studentId" value="${slist.studentID}" />
									</c:url>
									<a href="${delurl}"><button type="submit" id="add-button">
											<img src="images/delete_student.png" />
											<fmt:message key="button.student.delete" />
										</button></a>
								</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />


								<%-- 	<tr>
									<th class="text-center"><fmt:message
											key="label.student.studentlist.studentid" /></th>
									<th class="text-center"><fmt:message
											key="label.student.studentlist.firstname" /></th>
									<th class="text-center"><fmt:message
											key="label.student.studentlist.lastname" /></th>
									<th class="text-center"><fmt:message
											key="label.student.studentlist.email" /></th>
									<th class="text-center"></th>
								</tr>

								<c:forEach var="student" items="${slist}">
									<tr>
										<td class="text-center">${student.studentID}</td>
										<td class="text-center">${student.firstMidName}</td>
										<td class="text-center">${student.lastName}</td>
										<td class="text-center">${student.email}</td>
										<td class="text-center">
											<a
											href="student?action=edit&studentId=${student.studentID}">
												<button type="submit" id="add-button">
													<img src="images/edit_student.png" />Edit
												</button>
										</a>  <c:url var="updurl" scope="page" value="student">
												<c:param name="action" value="edit" />
												<c:param name="studentId" value="${student.studentID}" />

											</c:url> <a href="${updurl}">
												<button type="submit" id="add-button">
													<img src="images/edit_student.png" />
													<fmt:message key="button.student.edit" />
												</button>
										</a> 	<a
											href="student?action=delete&studentId=${student.studentID}">
												<button type="submit" id="add-button">
													<img src="images/delete_student.png" />Delete
												</button>
										</a> <c:url var="delurl" scope="page" value="student">
												<c:param name="action" value="delete" />
												<c:param name="studentId" value="${student.studentID}" />
											</c:url> <a href="${delurl}"><button type="submit"
													id="add-button">
													<img src="images/delete_student.png" />
													<fmt:message key="button.student.delete" />
												</button></a>

										</td>
									</tr>
								</c:forEach> --%>

							</display:table>
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