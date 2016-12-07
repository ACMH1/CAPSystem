<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="pic/cap2.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
   <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="style.css"/>
<meta charset="UTF-8">
<title>CAPS</title>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>
<body>
<%@ include file="header.jsp" %>
  <div>
<div class="w3-content w3-section" style="max-width:100%;max-height:100%">
<!--  <img class="mySlides" src="pic/1.jpg" style="width:100%;max-height:100%">
  <img class="mySlides" src="pic/2.jpg" style="width:100%;max-height:100%"> 
  <img class="mySlides" src="pic/3.jpg" style="width:100%;max-height:700px"> -->
  <img class="mySlides" src="pic/4.jpg" style="width:100%;max-height:700px">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
   
  

 <div >
 <div id="videosList"> 
 <div class="video">
<video loop audio muted width=100% height=100% autoplay>
  <source src="video/1.mp4" type="video/mp4">
  </video>
  </div>
  </div>
  </div>
  <script>
  var figure = $(".video").hover( hoverVideo, hideVideo );

  function hoverVideo(e) {  
      $('video', this).get(0).play(); 
  }

  function hideVideo(e) {
      $('video', this).get(0).pause(); 
  }
  
  </script>


<div id="contacthome"class="container-fluid">
<div class="row">
 <img src="pic/contact2.jpg" width=100% height=200px>
 <div class="col-sm-6 myfont">
<h1>Enquiry Line Operating Hours</h1> 
<h3>Monday - Friday: 9:00am to 5:00pm</h3>
<h1>Office Operating Hours</h1>
<h3>Monday - Friday: 9:00am to 5:00pm</h3>
<h3>Saturday: 9:00am to 12:00pm</h3>
<h4>(Closed on Sunday and Public Holiday)</h4>
<h1>Administrative Details</h1>
<h3>Tel: (65) 6516 1654 / 2064 / 7829</h3>
<h3>Email: capscpg@nit.edu.sg<h3></h3>
</div>
<div class="col-sm-6 myfont">
<center><h1>Locate Us</h1></center>
<center>
<script src='https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyAVxOYvCaIpfZpcmJhdl4qc8-TRbtjDkpg'></script>
<div style='overflow:hidden;height:400px;width:600px;'><div id='gmap_canvas' style='height:400px;width:600px;'></div>
<style>#gmap_canvas img{max-width:none!important;background:none!important}</style>
</div>
 <a href='https://add-map.com/'>map generator</a> 
 <script type='text/javascript' src='https://embedmaps.com/google-maps-authorization/script.js?id=3c87d56c3a5c843916ca554831e7fa6877f1c53c'></script>
 <script type='text/javascript'>function init_map(){var myOptions = {zoom:12,center:new google.maps.LatLng(1.3104214,103.7566339),mapTypeId: google.maps.MapTypeId.ROADMAP};
 map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(1.3104214,103.7566339)});
 infowindow = new google.maps.InfoWindow({content:'<strong>NIT UNIVERSITY</strong><br>WEST COAST ROAD<br>120518 SINGAPORE<br>'});google.maps.event.addListener(marker, 'click', function(){infowindow.open(map,marker);});
 infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
 </center>

</div>
</div>
</div> 
 
<div>

</div>


<%@ include file="footer.jsp" %>
</body>
</html>