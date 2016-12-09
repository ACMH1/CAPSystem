<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</style>
<script type="text/javascript">
	function AlertIt() {
		var answer = confirm("Do you want to reset password.")
		if (answer) {
			document.getElementById('password').value = "12345";
			document.getElementById('messagepw').innerHTML = "Password Reset Succesfully";
		}
	}
	function myFunction() {
		document.getElementById("contactform").reset();
	}
</script>
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
					<%
						if (request.getAttribute("status") == null) {
					%>
					<div id="content" class="align">
						<br />
						<div id="subtitle">
							&nbsp;&nbsp;
							<fmt:message key="label.lecturer.subtitle" />
						</div>
						<br />

						<center>

							<div class="registration">
								<div class="form">

									<form id="contactform" action="adminlecturer?action=add"
										method="post">

										<p class="contact">
											<label for="name"><fmt:message
													key="label.lecturer.lecturerlist.firstname" /></label>
										</p>

										<input id="name" name="firstName" placeholder="First Name"
											required="" tabindex="1" type="text" maxlength="20">

										<p class="contact">
											<label for="name"><fmt:message
													key="label.lecturer.lecturerlist.lastname" /></label>
										</p>

										<input id="name" name="lastName" placeholder="Last Name"
											required="" tabindex="2" type="text" maxlength="20">



										<p class="contact">
											<label for="email"><fmt:message
													key="label.lecturer.lecturerlist.email" /></label>
										</p>

										<input id="email" name="email"
											placeholder="example@domain.com" required="" tabindex="3"
											type="email">
										<p class="contact">
											<label for="email"><fmt:message
													key="label.lecturer.lecturerlist.cofirmemail" /></label>
										</p>

										<input id="confirmEmail" name="confirmEmail"
											placeholder="example@domain.com" required="" tabindex="4"
											type="email"> <br /> <br />
										<!-- <input class="buttom"
											name="submit" id="submit" tabindex="5"
											value="Create An Account!" type="submit"> -->


										<div style="float: left; width: 130px">
											<input class="buttom" name="add" id="submit" tabindex="5"
												value="Create An Account!" type="submit">
										</div>

										<div style="float: right; width: 650px">

											<input type="button" onclick="myFunction()" value="Reset"
												class="buttom">


										</div>
									</form>

								</div>
							</div>
						</center>
						<%
							}
							if (request.getAttribute("status") == "edit") {
						%>%>
						<div id="content" class="align">
							<br />
							<div id="subtitle">
								&nbsp;&nbsp;
								<fmt:message key="label.lecturer.modify.form" />
							</div>
							<br />

							<center>
								<div class="modification">
									<div class="form">

										<form id="contactform" action="adminlecturer?action=modify"
											method="post">


											<p class="contact">
												<label for="name"><fmt:message
														key="label.lecturer.lecturerlist.lecturerid" /></label>
											</p>

											<input id="lecturerID" name="lecturerID"
												placeholder="First Name" required="" tabindex="1"
												type="text" value="${lecturerID}" readOnly="readonly"
												">

											<p class="contact">
												<label for="name"><fmt:message
														key="label.lecturer.lecturerlist.firstname" /></label>
											</p>

											<input id="firstName" name="firstName"
												placeholder="First Name" required="" tabindex="1"
												type="text" value="${firstName}" maxlength="20">

											<p class="contact">
												<label for="name"><fmt:message
														key="label.lecturer.lecturerlist.lastname" /></label>
											</p>

											<input id="lastName" name="lastName" placeholder="Last Name"
												required="" tabindex="2" type="text" value="${lastName}"
												maxlength="20">



											<p class="contact">
												<label for="email"><fmt:message
														key="label.lecturer.lecturerlist.email" /></label>
											</p>

											<input id="email" name="email"
												placeholder="example@domain.com" required="" tabindex="3"
												type="email" value="${email}" readonly="readonly"> <br />
											<br />

											<%-- <p class="contact">
												<label for="pw"><fmt:message
											key="label.lecturer.lecturerlist.password" /> &nbsp;&nbsp;(To reset to
													default password)</label>
											</p>
											<u><a href="javascript:AlertIt();"> Forget Password</a></u> <input
												type="hidden" name="password" id="password"
												value="${password}"> <label id="messagepw"></label><br /> --%>
											<br /> <input class="buttom" name="submit" id="submit"
												tabindex="5" value="Modify" type="submit">

										</form>

									</div>
								</div>
							</center>
							<%
								}
							%>

						</div>
					</div>
				</div>
			</div>
		</div>



		<div><jsp:include page="footer.jsp" /></div>
		<script>
			var email = document.getElementById("email"), confirm_email = document
					.getElementById("confirmEmail");

			document.getElementById("confirmEmail").onchange = function() {
				if (email.value != confirm_email.value) {
					confirm_email.setCustomValidity("Emails Don't Match");
				} else {
					confirm_email.setCustomValidity('');
				}
			};
		</script>
</body>
</html>