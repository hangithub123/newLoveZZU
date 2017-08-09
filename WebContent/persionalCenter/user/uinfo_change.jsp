<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

body{
    font-size:18px;
    color: white;
}

</style>
<body>
<center>
<p>更新用户信息</p>
<form action="userinfoAction" method="post">
phone:<input type="text"name="phone"/><br/><br/>
nickname:<input type="text"name="nickname"/><br/><br/>
gender:<input type="text"name="gender"/><br/><br/>
hometown:<input type="text"name="hometown"/><br/><br/>
imageurl:<input type="text"name="imageUrl"/><br/><br/>
Qr_codeurl:<input type="text"name="Qr_codeUrl" /><br/><br/>
academy:<input type="text"name="academy"/><br/><br/>
departments:<input type="text"name="departments"/><br/><br/>
professional:<input type="text"name="professional"/><br/><br/><br/>
<input type="submit" value="提交">
</form>
</center>
</body>
</html>