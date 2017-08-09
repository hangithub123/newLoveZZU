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
<p>发布商品</p>
<form action="publishgoodsAction" method="post">

SessionID:<input type="text"name="SessionID"/><br/><br/>
Gtype:<input type="text"name="Gtype"/><br/><br/>
Gname:<input type="text"name="Gname"/><br/><br/>
Gcampus:<input type="text"name="Gcampus"/><br/><br/>
Gimage:<input type="text"name="Gimage"/><br/><br/>
Gdescribe:<input type="text"name="Gdescribe"/><br/><br/>
Gprice:<input type="text"name="Gprice"/><br/><br/>
<input type="submit" value="提交">
</form>

</center>
</body>
</html>