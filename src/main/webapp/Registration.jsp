<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
margin-top:110px;
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
margin-top:6px;
font-size:18px;
color:White;
height:35px;
}
.btn-info{
margin-top:10px;
margin-left:40px;
width:200px;
font-size:20px;
}
hr{
margin-top:30px;
}
a{
font-size:19px;
color:gray;
margin-left:30px;
}
.col-md-6{
margin-top:20px;
border-radius:0px 80px 0px 80px;
height:550px;
}
</style>
</head>
<body>

<form name="Register" action="Register" onsubmit="return myFunction()" method="post" enctype="multipart/form-data">
<div class="container">
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-8">
<div class="row">
<div class="col-md-6" style="background:rgba(0,0,0,0.7);">
<h3>Registration</h3>
<input type="text" class="form-control" name="First Name" id="First Name" placeholder="Enter your First Name"><br>
<input type="text" class="form-control" name="Last Name" id="Last Name" placeholder="Enter your Last Name"><br>
<input type="text" class="form-control" name="Roll No" id="Roll No" placeholder="Enter your Roll Number"><br>
<input type="text" class="form-control" name="Phone Number" id="Phone Number" placeholder="Enter your Phone Number"><br>
<input type="text" class="form-control" name="EmailID" id="EmailID" placeholder="Enter your Email"><br>
<input type="password" class="form-control" name="PASSWORD" id="PASSWORD" placeholder="Enter your Password"><br>
<input type="file" class="form-control" name="Image" id="Image" placeholder="Upload your Image"><br>
<h3><button type="submit" value="Submit" class="btn btn-info">Submit</button></h3>
</div>
</div>
</div>
</div>
</div>
<script>

function myFunction() {
	
	let x = document.forms["Register"]["First Name"].value;
	  if (x == "") {
	    alert("FirstName must be filled out");
	    return false;
	  }
	  let y = document.forms["Register"]["Last Name"].value;
	  if (y == "") {
	    alert("LastName must be filled out");
	    return false;
	  }
	  let a = document.forms["Register"]["Roll No"].value;
	  if (a == "") {
	    alert("Rollno must be filled out");
	    return false;
	  }
	  let b = document.forms["Register"]["Phone Number"].value;
	  if (b == "") {
	    alert("Phone Number must be filled out");
	    return false;
	  }
	  var email = document.getElementById('EmailID');
	    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	    if (!filter.test(email.value)) {
	    alert('Please provide a valid email address');
	    email.focus;
	    return false;
	    }
	  let r = document.forms["Register"]["PASSWORD"].value;
	  if (r == "") {
	    alert("PASSWORD must be filled out");
	    return false;
	  }
}
</script>

</form>
</body>
</html>