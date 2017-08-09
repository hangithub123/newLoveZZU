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
<p>分类查询:出行,娱乐,学习。
<br/>
输入关键句查询:商品ID,类型,名字,校区,描述</p>
<form action="querygoodsAction" method="post">

action:<input type="text"name="action"/><br/><br/>
num:<input type="text"name="num"/><br/><br/>
goods_id:<input type="text"name="goods_id"/>用于删除发布的商品的<br/><br/>
<input type="submit" value="提交">
</form>
<br/>

</center>
</body>
</html>