<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Information</title>
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
 &nbsp;&nbsp;<span id="title">We are sorry</span>


<span id="title">The page you are trying is currently not available.</span>
<span>Please try after some time.</span>

    
           
 </div>
 </div>
 </div>
 	<div><%@include file="footer.jsp"%></div>
</body>
</html>