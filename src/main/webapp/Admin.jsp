<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

*{
	margin:0;
	padding:0;	
}
header {
  background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("2.jpg");
  background-position: center;
  height:100vh;
  background-size: cover;
 }
 ul{
 	float:right;
 	list-style-type:none;
 	margin-top:15px;
 	margin-right:-30px;	
 }
ul li{
display:inline-flex;
}
.container ul li{
padding:15px;
width:60px;
margin:15px;

}
ul li a{
   
	text-decoration:none;
	color:#fff;
	padding:5px 10px;
	border:1px solid transparent;
	transition:0.6s ease;
	font-family:Century Gothic;

}
ul li.active a{
background-color:#fff;
color:#000;
border-radius:20px;
}
ul li a:hover{
	background-color:#fff;
	color:#000;
	border-radius:20px;
}
.logo img{
	float:left;
	width:150px;
	height:auto;
}
.container{
	max-width:1200px;
	margin:auto;
	
}

.sub-menu{
display:none;

}

ul li:hover .sub-menu
{
	display:block;
	position:absolute;
	margin-top:2px;
	margin-left:-25px;

}
ul li:hover .sub-menu ul
{
	display:block;
	position:absolute;
	
}
ul li:hover .sub-menu ul li
{	
	width:150px;
	padding:5px;
	border-bottom: 2px solid #f51c40;
	background:transparent;
	border-radius:20px;
	text-align:left;

}
.title{
	position:absolute;
	top:50%;
	left:50%;
	transform:translate(-50%,-50%);
}

.title h1{
	color:#fff;
	font-size:70px;
	font-family:Bauhaus 93;
}


.titles{
	position:absolute;
	top:30%;
	left:50%;
	transform:translate(-50%,-50%);
}

.titles h1{
	color:#fff;
	font-size:65px;
	font-family:Bauhaus 93;
}



.t{
	position:absolute;
	top:60%;
	left:50%;
	transform:translate(-50%,-50%);
}

.t h3{
	color:#fff;
	font-family:Bauhaus 93;
	font-size:30px;
}

.popup{
    height: 100vh;
    width: 100%;
    position: fixed;
    top: 0;
    left: 0;
    background-color: rgba(192,192,192,0.3);
    z-index: 99999;
    opacity: 0;
    visibility: hidden;
    transition: all .3s;
     backdrop-filter: blur(10px);
     }
 
   
@supports (-webkit-backdrop-filter: blur(10px)) or (backdrop-filter: blur(10px)) {
      .popup .popup1
      {
        -webkit-backdrop-filter: blur(80px);
        backdrop-filter: blur(10px);
        background-color: rgba(0,0,0,0.65); } }
    .popup__content {
      width: 350px;
      padding: 20px;
      border-radius: 4px;
      background:hsl(290,60%,70%);
      border: 1px solid rgba(255, 255, 255, 0.18);
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      box-shadow: 0 2rem 4rem rgba(0, 0, 0, 0.2);
      display: table;
      overflow: hidden;
      opacity: 0;
      transform: translate(-50%, -50%) scale(0.25);
      transition: all .5s .2s; 
      background-color: #747873;}

    .popup:target {
      opacity: 1;
      visibility: visible; }
    .popup:target .popup__content {
      opacity: 1;
      transform: translate(-50%, -50%) scale(1); }
      
    
      
    .popup__close:link, .popup__close:visited {
      color: #000;
      position: absolute;
      top: 2.5rem;
      right: 2.5rem;
      font-size: 3rem;
      text-decoration: none;
      display: inline-block;
      transition: all .2s;
      line-height: 1; }
    .popup__close:hover {
      color: #fff; }


      h1{
        text-align: center;
        color: white;
        text-transform: uppercase;
        font-family:"Times New Roman", Times, serif;
       
    }
    
    form{
        margin: 20px;
    }
    label{
        display: block;
        color: black;
        font-size: 18px;
        margin-top: 10px;
    }
    
    input{
        display: block;
        width: 90%;
        background: transparent;
        border: none;
        outline: none;
        border-bottom: 1px solid white;
        padding: 10px;
        color: white;
    }
    
    button{
        display: block;
        width: 95%;
        padding: 8px;
        border: none;
        outline: none;
        background: linear-gradient(to right, #b90800, 
        #20002c);
       
        font-size: 18px;
        cursor: pointer;
        margin-top: 20px;
         color:#e2e2e2
    
    }
    
    a{
        text-decoration: none;
        color: #20002c;
    
    }
    
    .link{
        margin-top: 30px;
        text-align: center;
        color:white;
    }
    
    a:hover{
        text-decoration: underline;
    }

.button1 {
  border: none;
  
 padding:5px 10px;
  text-align: center;
  text-decoration: none;
  display: block;
  margin: 2px 0px;
  cursor: pointer;
  border-radius: 160px;
   background: transparent;
   color:white;
   	border:1px solid transparent;
   	font-size:15px
}

.button1:hover {
  background-color:white;
  color:black;
}


</style>
</head>
<body>
<header>

<div class="logo">
	<img src="StackOfBooks.png">
</div>
<div class="container">

<ul>
		<li class="active"><a href="#Home">Home</a></li>
		<li><form action="UData" method="post">
			<button class="button1">User</button>
			</form>
		</li>
		<li><a href="#Book Entry">Books</a>
		<div class="sub-menu">
		<ul>
				<li><a href="#popup4">Entry Details</a></li>
				<li><a href="#popup0">Issue Details</a></li>
				<li><a href="#popup1">Return Details</a></li>
				<li><a href="#popup2">Re-usage</a></li>
				<li><a href="#popup3">Statistics</a></li>
		</ul> 
		</div>
		</li>
		
		<li><a href="Start.jsp" onclick="myFunction()">Logout</a></li>
		
	</ul>

	
</div>

<div class="popup" id="popup0">
    <div class="popup__content">
        
        
            <a href="#section-tours" class="popup__close">×</a>
            <h1>Issue Details</h1>
        <form action="book_entry" method = "post">
            <label>Roll Number</label>
            <input type="text" name="Roll Number">
            <label>Book Name</label>
            <input type="text" name="Book Name">
            <label>Book ID</label>
            <input type="text" name="Book ID">
            <label>Issue Date</label>
            <input type="date" name="Issue Date">
            <label>Return Date</label>
            <input type="date" name="Return Date">
            <button onclick="myFunction1()">Submit</button>
    </form></div>
</div>

<div class="popup" id="popup1">
    <div class="popup__content">
        
        
            <a href="#section-tours" class="popup__close">×</a>
            <h1>Return Details</h1>
        <form action="Bookreturn" method="post">
            <label>Roll Number</label>
            <input type="text" name="Roll Number">
            <label>Book Name</label>
            <input type="text" name="Book Name">
            <label>Book ID</label>
            <input type="text" name="Book ID">
            <label>Submit Date</label>
            <input type="date" name="Submit Date">
            <button onclick="myFunction2()">Submit</button>
    </form></div>
</div>


<div class="popup" id="popup2">
    <div class="popup__content">
        
        
            <a href="#section-tours" class="popup__close">×</a>
            <h1>Re-Usage</h1>
        <form action="BuyBooks" method="post">
            <label>Book Name</label>
            <input type="text"  name="Book Name">
            <label>Book ID</label>
            <input type="text" name="Book ID">
            <label>Cost</label>
            <input type="text" name="Cost">
            <button onclick="myFunction3()">Submit</button>
    </form></div>
</div>


<div class="popup" id="popup4">
    <div class="popup__content">
        
        
            <a href="#section-tours" class="popup__close">×</a>
            <h1>Entry Details</h1>
        <form action="BookUpload" method = "post">
            <label>Book ID</label>
            <input type="text" name="Book ID">
            <label>Book Name</label>
            <input type="text" name="Book Name">
            <label>Book Author</label>
            <input type="text" name="Book Author">
             <label>Book ISBN</label>
            <input type="text" name="Book ISBN">
            <label>Book Index</label>
            <input type="file" name="Book Index" id="Image" placeholder="Upload your Image">
            <button onclick="myFunction4()">Submit</button>
    </form></div>
</div>


<div class="title">
	<h1>ADmin zone</h1>
	
</div>
<div class="t">
	<h3>Welcome to Admin Panel!</h3>
	</div>
	<script type="text/javascript">

		function myFunction() {
			if (confirm("Are you Sure to logout!")==false) {
		
				event.preventDefault();
		   }
		}
		
		
		
		function myFunction2() {
			if (confirm("Sucess fully Registered!")==false) {
				
				event.preventDefault();
		   }
		}
		function myFunction4() {
			if (confirm("Sucess fully Registered!")==false) {
				
				event.preventDefault();
		   }
		}
		function myFunction3() {
			alert("Hello! I am an alert box!");
		}
		

	
	</script>
</header>
</body>
</html>