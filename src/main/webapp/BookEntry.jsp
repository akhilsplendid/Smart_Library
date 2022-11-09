<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Smart Library</title>
<link rel =icon href = SL.jpg type = image/x-icon>
<style type="text/css">
*{
margin:0;
padding:0;
box-sizing:bordex-box;
font-family:'Poppins',sans-serif;
}
body{
display:flex;
height:100vh;
justify-content:center;
align-items:center;
background:linear-gradient(135deg,#71b7e6,#9b59b6);
padding:10px;
}
.container{
max-width:700px;
width:100%;
background:#fff;
padding:25px 30px;
border-radius:5px;
}
.container .title{
font-size:25px;
font-weight:500;
position:relative;

}
.container .title::before{
content:'';
position:absolute;
height:3px;
width:30px;
left:0;
bottom:0;
background:linear-gradient(135deg,#71b7e6,#9b59b6);
}
.container form .user-details{
display:flex;
flex-wrap:wrap;
justify-content:space-between;
margin:20px 0 12px 0;

}
form .user-details .input-box{
width:calc(100%/2-20px);
margin-bottom:15px;
}
.user-details .input-box input{
height:45px;
width:100px;
outline:none;
border-radius:5px;
transition:all 0.3s ease;
border:1px solid #ccc;
padding-left:15px;
font-size:16px;

}
.user-details .input-box .details{
font-weight:500;
margin-bottom:5px;
display:block;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
border-color:#9b59b6;
}

</style>
</head>
<body>
<div class="container">
	<div class="title">Book Entry</div>
	<form action=#>
		<div class="user-details">
			<div class="input-box">
				<span class="details">Roll Number</span>
				<input type="text" placeholder="Enter the Roll number" required>
			</div>
			<div class="input-box">
				<span class="details">Book Name</span>
				<input type="text" placeholder="Enter the Book Name" required>
			</div>
			<div class="input-box">
				<span class="details">Book ID</span>
				<input type="text" placeholder="Enter the Book ID" required>
			</div>
			<div class="input-box">
				<span class="details">Issue Date</span>
				<input type="date" placeholder="Enter the Issue Date" required>
			</div>
			<div class="input-box">
				<span class="details">Return Date</span>
				<input type="date" placeholder="Enter the Return Date" required>
			</div>
			
		</div>
		<div class="button">
			<input type="submit" value="Submit">
		</div>
	</form>
</div>
</body>
</html>