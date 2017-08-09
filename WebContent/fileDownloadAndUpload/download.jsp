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
<p>下载测试</p>

<form action="filedownload" method="post">
imageURL:<input type="text"name="imageURL"/><br/>
下载头像还是商品:<input type="text"name="action"/><br/>

<input type="submit" value="提交">
</form>
</center>
</body>
</html>