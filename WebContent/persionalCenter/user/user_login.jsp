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
<p>用户手机号和密码登录或身份标识登陆</p>
<s:form action="loginAction" method="post" theme="simple">
<p>手机号和密码登陆</p>
 phone:<input type="text"name="phone" placeholder="请输入11位手机号"/><br/><br/>
 password:<input type="text"name="password"/><br/><br/>
 

 
 <p>唯一标识符登陆</p>
 sessionid:<input type="text"name="SessionID"/><br/><br/>
<input type="submit"value="提交"/>
<input type="reset"value="重置"/>
</s:form>
 
    
</center>
</body>
</html>