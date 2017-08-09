<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="s" uri="/struts-tags" %>
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
<p>用户注册</p>
<form action="userAction" method="post">
    phone:<input type="text"name="phone" placeholder="请输入11位手机号"/><br/><br/>
 password:<input type="text"name="password"/><br/><br/>
  验证码:<s:textfield name="verification_code"></s:textfield>
      <br/>
　　　　　 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 
　　　　　<!--若要点击图片刷新，重新得到一个验证码，要在后面加上个随机数，这样保证每次提交过去的都是不一样的path，防止因为缓存而使图片不刷新-->
        <img src="creatimage" onclick="this.src='creatimage?'+ Math.random()" title="点击图片刷新验证码"/><br>
        <s:actionerror cssStyle="color:red"/>
<input type="submit"value="提交"/>
<input type="reset"value="重置"/>
</form>
</center>
</body>
</html>