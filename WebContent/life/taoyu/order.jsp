<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
</head>

<style type="text/css">

body{
    font-size:18px;
    color: white;
    text-align: center;
}

</style>
<body>

<p>订单测试</p>

<form action="OrderAction" method="post">
action:<input type="text" name="action"/><br/><br/>
orderID:<input type="text" name="orderID"/><br/><br/>
SessionID:<input type="text" name="SessionID"/><br/><br/>

<input type="submit" value="提交"/>
</form>


</body>
</html>