<html><head></head><body>



<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Library</title>
<link rel="icon" href="SL.jpg" type="image/x-icon">
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
 	margin-top:25px;
 	
 	
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
	padding:5px 20px;
	border:1px solid transparent;
	transition:0.6s ease;
	font-family:Century Gothic;

}
ul li.active a{
background-color:#fff;
color:#000;
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
	border-bottom:1px dotted #fff;
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
.t{
	position:absolute;
	top:60%;
	left:60%;
	transform:translate(-50%,-50%);
}

.t h3{
	color:#fff;
	font-family:Bauhaus 93;
}


.popup {
    height: 100vh;
    width: 100%;
    position: fixed;
    top: 0;
    left: 0;
    background-color: rgba(0, 0, 0, 0.8);
    z-index: 9999;
    opacity: 0;
    visibility: hidden;
    transition: all .3s; }
    @supports (-webkit-backdrop-filter: blur(10px)) or (backdrop-filter: blur(10px)) {
      .popup {
        -webkit-backdrop-filter: blur(10px);
        backdrop-filter: blur(10px);
        background-color: rgba(0, 0, 0, 0.3); } }
    .popup__content {
      width: 350px;
      padding: 20px;
      border-radius: 4px;
      background: rgba(255, 255, 255, 0.25);
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
      transition: all .5s .2s; }

    .popup:target {
      opacity: 1;
      visibility: visible; }
    .popup:target .popup__content {
      opacity: 1;
      transform: translate(-50%, -50%) scale(1); }
    .popup__close:link, .popup__close:visited {
      color: #777;
      position: absolute;
      top: 2.5rem;
      right: 2.5rem;
      font-size: 3rem;
      text-decoration: none;
      display: inline-block;
      transition: all .2s;
      line-height: 1; }
    .popup__close:hover {
      color: #55c57a; }


      h1{
        text-align: center;
        color: white;
        text-transform: uppercase;
    }
    
    form{
        margin: 20px;
    }
    label{
        display: block;
        color: white;
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
        background: linear-gradient(to right, #cbb4d4, 
        #20002c);
        color: white;
        font-size: 18px;
        cursor: pointer;
        margin-top: 20px;
    
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
    

</style>


<header>

<div class="logo">
	<img src="logo.png">
</div>
<div class="container">
<ul>
		<li class="active"><a href="#Home">Home</a></li>
		<li><a href="#Users Data">Users</a></li>
		<li><a href="#Book Entry">Books</a>
		<div class="sub-menu">
		<ul>
				 
				<li><a href="#popup">Book Entry</a></li>
				<li><a href="#popup">Book Return</a></li>
				<li><a href="#popup">Buy Book</a></li>
				<li><a href="#popup">Book Details</a></li>
		</ul>
		</div>
		</li>
		
		<li><a href="#logout">Logout</a></li>
	</ul>
	
</div>

<div class="popup" id="popup">
    <div class="popup__content">
        
        
            <a href="#section-tours" class="popup__close">×</a>
            <h1>Welcome</h1>
        <form action="#">
            <label>Email or Phone</label>
            <input type="text">
            <label>Password</label>
            <input type="password">
            <a href="#">Forgot Password?</a>
            <button>Submit</button>
            <div class="link">Not a member? <a href="#">Sigup here</a></div>

    </form></div>
</div>

<div class="title">
	<h1>Smart Library</h1>
	
</div>
<div class="t">
	<h3>--an easier way</h3>
	</div>
</header>

</body></html>