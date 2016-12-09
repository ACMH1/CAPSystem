<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="WebContent/menu.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<% if (session.getAttribute("role").equals("admin")) { %>
<div class="container" id="admin">
         <div class="row">
  <div class="col-md-3">

      <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
      <div class="panel panel-primary" >
        <div class="panel-heading"  role="tab"  style ="background-color:#191919"  id="headingOne">
          <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseOne" class="collapsed">
              <a href="adminstudent">Manage Students</a> 
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseTwo">
              <a href="adminlecturer">Manage Lecturers</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="true" aria-controls="collapseThree">
             <a href="${pageContext.request.contextPath}/admin_managecourses"> Manage Courses </a> 
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="true" aria-controls="collapseThree">
             <a href="${pageContext.request.contextPath}/admin_manageenrolment">  Manage Enrollment </a> 
            </a>
          </h4>
        </div>
      </div>
    </div>
  </div>
           
</div>
</div>
<%} %>
<% if (session.getAttribute("role").equals("student")) { %>
<div class="container" id="admin">
         <div class="row">
  <div class="col-md-3">

      <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
      <div class="panel panel-primary" >
        <div class="panel-heading"  role="tab"  style ="background-color:#191919"  id="headingOne">
          <h4 class="panel-title">
            <a class="collapsed" href="CourseGradeController" aria-expanded="false" aria-controls="collapseOne" class="collapsed">
              Grades and GPA
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a class="collapsed" href="StudentController" aria-expanded="false" aria-controls="collapseTwo">
              View Courses 
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" href="courseEnroll" aria-expanded="true" aria-controls="collapseThree">
             Enroll for a Course
            </a>
          </h4>
        </div>
      </div>
    </div>
  </div>          
</div>
</div>
<%} %>

<% if (session.getAttribute("role").equals("lecturer")) { %>
<div class="container" id="lecturer">
         <div class="row">
  <div class="col-md-3">

      <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
      <div class="panel panel-primary" >
        <div class="panel-heading"  role="tab"  style ="background-color:#191919"  id="headingOne">
          <h4 class="panel-title">
            <a href="coursecontoller" aria-expanded="false" aria-controls="collapseOne" class="collapsed">
              View Courses Taught
            </a>
          </h4>
        </div>
      </div>
        <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a href="CourseEnrolInit"" aria-expanded="false" aria-controls="collapseTwo">
              View Course Enrollment
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a href="FindCourseForGrade" aria-expanded="false" aria-controls="collapseTwo">
              Grade a Course
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a href="StudentPerformanceInit" aria-expanded="true" aria-controls="collapseThree">
            View a Student Performance 
            </a>
          </h4>
        </div>
      </div>
    </div>
  </div>
           
</div>
</div>
<%} %>
</div>
</body>
</html>