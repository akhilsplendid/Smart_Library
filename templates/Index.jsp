<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="{{url_for('logins')}}" method="post">
       
        <input type="text" name="rooms" required>
        <input type="text" name="distance" required>
        <input type="submit" value="submit">
    </form>
</body>
</html>