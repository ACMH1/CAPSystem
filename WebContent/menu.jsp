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
              <a href="student">Manage Students</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseTwo">
              <a href="lecturer">Manage Lecturers</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="true" aria-controls="collapseThree">
             <a href=" ">Manage Courses</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="true" aria-controls="collapseThree">
             <a href=" ">Manage Enrolment</a>
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
            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="/CAPSystem/CourseGradeController" aria-expanded="false" aria-controls="collapseOne" class="collapsed">
              <a href="/CAPSystem/CourseGradeController">Grades and GPA</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseTwo">
              <a href=" ">View Courses</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="true" aria-controls="collapseThree">
             <a href=" ">Enroll for a Course</a>
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
<div class="container" id="admin">
         <div class="row">
  <div class="col-md-3">

      <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
      <div class="panel panel-primary" >
        <div class="panel-heading"  role="tab"  style ="background-color:#191919"  id="headingOne">
          <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseOne" class="collapsed">
              <a href=" ">View Courses Taught</a>
            </a>
          </h4>
        </div>
      </div>
        <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseTwo">
              <a href=" ">View Course Enrolment</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading"  style ="background-color:#191919" role="tab" id="headingTwo">
          <h4 class="panel-title">
            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="false" aria-controls="collapseTwo">
              <a href=" ">Grade a Course</a>
            </a>
          </h4>
        </div>
      </div>
      <div class="panel panel-primary">
        <div class="panel-heading" style ="background-color:#191919" role="tab" id="headingThree">
          <h4 class="panel-title">
            <a class="" role="button" data-toggle="collapse" data-parent="#accordion" href=" " aria-expanded="true" aria-controls="collapseThree">
            <a href=" ">View a Student Performance</a>
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