<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Library</title>
<link rel =icon href = SL.jpg type = image/x-icon>
<style>
body {
  background-image: url("2.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
h1{
font-size:30px;
padding:7px;
border-radius:40px 0px 0px 40px;
margin-top:120px;
color:White;
text-align:center;
background:rgba(0,0,0,0.7);

}
h2{
font-size:30px;
padding:7px;
border-radius:40px 0px 0px 40px;
text-align:center;
color:White;
background:rgba(0,0,0,0.7);
}
h3{
font-size:40px;
color:White;
text-align:center;
text-shadow:1px 1px 10px white;
margin-bottom:47px;
}
.form-control{
background:transparent;
margin-top:27px;
font-size:21px;
color:white;
height:44px;
}

.btn-info{
margin-top:-10px;
margin-left:10px;
width:200px;
font-size:20px;
}
hr{
margin-top:-40px;
}
a{

font-size:22px;
color:gray;
margin-left:30px;
}
.col-md-6{
margin-top:90px;
border-radius:0px 80px 0px 80px;
height:450px;
}
</style>
</head>
<body>
<form action="{{url_for('logins')}}" method="post" onsubmit="return myFunction()">
<div class="container">
<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8">
<div class="row">
<div class="col-md-6">
<h1>TextBook Syllabus</h1>
<h2>Semester Syllabus</h2>
</div>
<div class="col-md-6" style="background:rgba(0,0,0,0.7);">
<h3>Checking</h3>
<input type="file" class="form-control" name="Image" id="Image1" placeholder="Upload your Image"><br>
<input type="file" class="form-control" name="Image" id="Image" placeholder="Upload your Image"><br>
<h3><button type="submit" value="Submit" class="btn btn-info">Check</button></h3>
<script>

function myFunction() {
	 let x = document.forms["Login"]["EmailID"].value;
	  if (x == "") {
	    alert("EmailID must be filled out");
	    return false;
	  }
	  let y = document.forms["Login"]["PASSWORD"].value;
	  if (y == "") {
	    alert("PASSWORD must be filled out");
	    return false;
	  }
}
</script>
<hr>
</div>
</div>
</div>
</div>
</div>
</form>
</body>
</html>
