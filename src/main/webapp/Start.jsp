<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Smart Library</title>
<link rel =icon href = SL.jpg type = image/x-icon>
<style>
body {
  background-image: url("2.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
@import url('https://fonts.googleapis.com/css?family=Roboto:700');
@keyframes showTopText {
  0% { transform: translate3d(0, 100%, 0); }
  100% { transform: translate3d(0, 0, 0); }
}
@keyframes showBottomText {
  0% { transform: translate3d(0, -100%, 0); }
  100% { transform: translate3d(0, 0, 0); }
}
.animated-title {
  color: #222;
  font-family: Roboto, Arial, sans-serif;
  height: 90vmin;
  left: 50%;
  position: absolute;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 90vmin;
}
.animated-title > div {
  height: 50%;
  overflow: hidden;
  position: absolute;
  width: 100%;
}
.animated-title > div div{
  font-size: 12vmin;
  padding: 2vmin 0;
  position: absolute;
}
.animated-title > div div span {
  display: block;
}
.animated-title > div.text-top {
  border-bottom: 1vmin solid #000;
  top: 0;
}
.animated-title > div.text-top div {
  animation: showTopText 0.5s;
  animation-delay: 0.6s;
  animation-fill-mode: forwards;
  bottom: 0;
  transform: translate(0, 100%);
}
.animated-title > div.text-top div span:first-child {
  color: #767676;
}
.animated-title > div.text-bottom {
  bottom: 0;
}
.animated-title > div.text-bottom div {
font-size: 5vmin;
  animation: showBottomText 3s;
  animation-delay: 0.65s;
  animation-fill-mode: forwards;
  top: 0;
  left:320px;
  transform: translate(0, -100%);
}
.center{
  
   text-align: center;
  position: absolute;
  top: 80%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
   }  
.button {
  background-color: #ddd;
  border: none;
  color: black;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 16px;
       }
</style>
</head>
<body>
<div class="animated-title">
  <div class="text-top">
    <div>
      <span>Smart Library</span>
    </div>
  </div>
  <div class="text-bottom">
    <div>--an easier way</div>
    </div>
</div>
<div>

<div class="center">
<a href="Login.jsp"><button style="font-size:20px" class="button" onclick="Login.jsp" name="Admin" value="Admin"><i class="fas fa-user-circle"></i>Login</button></a>
<a href="Registration.jsp"><button style="font-size:20px" class="button" onclick="Registration.jsp"  name="User" value="User"><i class="fas fa-address-card"></i>Register</button></a>
</div>
</div>
</body>
</html>