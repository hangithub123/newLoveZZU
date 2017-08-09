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
<br/><br/><br/><p>购物車</p><br/><br/><br/>
<form action="cartAction" method="post">
   SessionID:<input type="text"name="SessionID"/><br/>
goods_id:<input type="text"name="goods_id"/><br/>
count:<input type="text"name="count"/><br/>
action:<input type="text"name="action"/><br/>
        <p>action:添加/删除/查询</p>
<input type="submit"value="提交"/>
</form>
</center>
</body>
</html>