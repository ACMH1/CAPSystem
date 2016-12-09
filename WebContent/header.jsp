<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
  <link rel="shortcut icon" type="image/x-icon" href="pic/cap2.ico" />
<meta charset="UTF-8">
<title>CAPS-Home</title>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<style>
.mySlides {display:none;}
</style>
</head>
<body>
<header>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span> 
	      </button>
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-globe"></span> CAPS</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
    <% if (session.getAttribute("role")==" "){ %>
      <li id="home" class="active"><a href="#">Home</a></li> 
      
        <li id="about"><a href="#"><span class="glyphicon glyphicon-eye-open"></span> About-CAPS</a></li>
          <li id="contact"><a href="home.jsp#contacthome"><span class="glyphicon glyphicon-earphone"></span> Contact us</a></li>
               <% } else if (session.getAttribute("role")!=" " ){ %>
               <% if (session.getAttribute("role")=="admin" ){ %>
            <li id="welcome" class="active"><a href="#" ><span class="glyphicon glyphicon-user"></span> Welcome "user name"</a></li>
             <%}else if (session.getAttribute("role")=="lecturer" ){ %>
              <li id="welcome" class="active"><a href="#" ><span class="glyphicon glyphicon-user"></span> Welcome &nbsp<c:out value="${lecturername}"/></a></li>
              <%}else if (session.getAttribute("role")=="student" ){ %>
               <li id="welcome" class="active"><a href="#" ><span class="glyphicon glyphicon-user"></span> Welcome "user name"</a></li>
                 <%} %>
      <%} %>
    </ul>
      <ul class="nav navbar-nav navbar-right">
       <% if (session.getAttribute("role")==" "|| session.getAttribute("role")==null){ %>
      <li id="login"class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-log-in"></span>  Login</a>
        <ul class="dropdown-menu"> 
          <li><a href="admin_login.jsp"><span class="glyphicon glyphicon-user"></span> Admin login</a></li>
          <li><a href="lecturer_login.jsp"><span class="glyphicon glyphicon-user"></span> Lecturer login</a></li>
          <li><a href="student_login.jsp"><span class="glyphicon glyphicon-user"></span> Student login</a></li> 
      </ul>
      </li> 
       <% } else if (session.getAttribute("role")!="") {%> 
      <li id="logout"><a href="${pageContext.request.contextPath}/logoutcontroller?log=out">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>
       <%} %>
      </ul>   
 </div>
 </div>
 </nav>
 </header>
 </body>
 </html>


