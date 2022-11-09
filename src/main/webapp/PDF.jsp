<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DhXWdTRQ9oBH4Q4l2YsjL2w4wqBfWwgP2br5U4VZg0cjqcg8JiUtngkOCjfQxSX" crossorigin="anonymous">  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Smart Library</title>
<link rel =icon href = SL.jpg type = image/x-icon>
<style>
    :root {
  --container-bg-color: #333;
  --left-bg-color: rgba(223, 39, 39, 0.7);
  --left-button-hover-color: rgba(161, 11, 11, 0.3);
  --right-bg-color: rgba(43, 43, 43, 0.8);
  --right-button-hover-color: rgba(92, 92, 92, 0.3);
  --hover-width: 75%;
  --other-width: 25%;
  --speed: 1000ms;
}

html, body {
  padding:0;
  margin:0;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  width: 100%;
  height: 100%;
  overflow-x: hidden;
}

h1 {
  font-size: 4rem;
  color: #fff;
  position: absolute;
  left: 50%;
  top: 20%;
  transform: translateX(-50%);
  white-space: nowrap;
}

.button {
  display: block;
  position: absolute;
  left: 50%;
  top: 40%;
  width: 15rem;
  text-align: center;
  color: #fff;
  border: #fff solid 0.2rem;
  font-size: 2rem;
  font-weight: bold;
  text-transform: uppercase;
  text-decoration: none;
  transform: translateX(-50%);
}
.split.left .button:hover {
  background-color: var(--left-button-hover-color);
  border-color: var(--left-button-hover-color);
}

.split.right .button:hover {
  background-color: var(--right-button-hover-color);
  border-color: var(--right-button-hover-color);
}

.container {
  position: relative;
  width: 100%;
  height: 100%;
  background: var(--container-bg-color);
}

.split {
  position: absolute;
  width: 50%;
  height: 100%;
  overflow: hidden;
}

.split.left {
  left:0;
  background: url('index.jpg') center center no-repeat;
  background-size: cover;
}

.split.left:before {
  position:absolute;
  content: "";
  width: 100%;
  height: 100%;
  background: var(--left-bg-color);
}

.split.right {
  right:0;
  background: url('index.jpg') center center no-repeat;
  background-size: cover;
}

.split.right:before {
  position:absolute;
  content: "";
  width: 100%;
  height: 100%;
  background: var(--right-bg-color);
}

.split.left, .split.right, .split.right:before, .split.left:before {
  transition: var(--speed) all ease-in-out;
}

.hover-left .left {
  width: var(--hover-width);
}

.hover-left .right {
  width: var(--other-width);
}

.hover-left .right:before {
  z-index: 2;
}


.hover-right .right {
  width: var(--hover-width);
}

.hover-right .left {
  width: var(--other-width);
}

.hover-right .left:before {
  z-index: 2;
}

@media(max-width: 800px) {
  h1 {
    font-size: 2rem;
  }

  .button {
    width: 12rem;
  }
}

@media(max-height: 700px) {
  .button {
    top: 70%;
  }
}
.logo img{
	display: block;
  margin-left: auto;
  margin-right: auto;
  padding: 10px; 
  margin-top: 250px;
}
.logo1 img{
	display: block;
  margin-left: auto;
  margin-right: auto;
  padding: 10px; 
  margin-top: 220px;
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
      label{
        display: block;
        color: black;
        font-size: 18px;
        margin-top: 10px;
    }
    form{
        margin: 20px;
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
h1{
        text-align: center;
        color: white;
        text-transform: uppercase;
        font-family:"Times New Roman", Times, serif;
       
    }
.Heading{
  font-size: 4rem;
  color: #fff;
  position: absolute;
  left: 50%;
  top: 5%;
  transform: translateX(-50%);
  white-space: nowrap;
    }
    .Heading h1{
      font-size: 4rem;
  color: #fff;
  
  
 
    } 
.button1{
 display: block;
        width: 95%;
        padding: 8px;
        border: none;
        outline: none;
        background: linear-gradient(to right, #b90800, 
       #181717);
       
        font-size: 18px;
        cursor: pointer;
        margin-top: 20px;
         color:#e2e2e2

}
</style>
<body> 
<div class="container">
    <button class="button1" onclick="history.back()">Go Back</button>
    <div class="split left">
      <a class="Heading">Identfying the correct TextBooks</a>
      <h1>PDF File</h1>
      <div class="logo">
        <img src="pdf.png">
      </div>
      <a href="#popup1" class="button">Upload</a>
    </div>
    <div class="split right">
      <a class="Heading">Matches with the Sem Syllabus</a>
      <h1>Image</h1>
      <div class="logo1">
        <img src="Image.jpg">
      </div>
      <a href="#popup0" class="button">Upload</a>
    </div>

  </div>

  <div class="popup" id="popup0">
    <div class="popup__content">
            <a href="#section-tours" class="popup__close">×</a>
        <form action="PDF" method = "post" enctype="multipart/form-data">
            <label>Upload IMAGE</label>
            <input type="file" name="pdf_file">
            <button onclick="myFunction1()">Submit</button>
    </form></div>
</div>
<div class="popup" id="popup1">
  <div class="popup__content">
          <a href="#section-tours" class="popup__close">×</a>
      <form action="PDF" method = "post" enctype="multipart/form-data">
          <label>Upload PDF</label>
          <input type="file" name="pdf_file">
          <button onclick="myFunction1()">Submit</button>
  </form></div>
</div>
<script>
    const left = document.querySelector(".left");
const right = document.querySelector(".right");
const container = document.querySelector(".container");

left.addEventListener("mouseenter", () => {
  container.classList.add("hover-left");
});

left.addEventListener("mouseleave", () => {
  container.classList.remove("hover-left");
});

right.addEventListener("mouseenter", () => {
  container.classList.add("hover-right");
});

right.addEventListener("mouseleave", () => {
  container.classList.remove("hover-right");
});

</script>
</body>
</html>
