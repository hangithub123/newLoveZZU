<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>

</head>
<style type="text/css">

body{
    font-size:18px;
    color: white;
}

</style>
<body>
<center>
<p>单文件上传测试</p>
<s:form action="upload" namespace="/"
 enctype="multipart/form-data"
 method="post"  theme="simple">
 <s:token></s:token>
 <s:debug></s:debug>
<s:actionerror/>
<s:fielderror name="myUpload"></s:fielderror>

<br/>
file:<s:file name="myUpload" lable="myUpload"></s:file>

<br/>
SessionID<s:textfield name="SessionID"></s:textfield>
<br/>
<s:submit name="submit" value="上传文件"></s:submit>

</s:form>
<br/>
<p>ab658cee-f1bd-4aa4-a7a3-0293a6f9b3b2</p>
<br/>
<p>f9ddc0f6-35b6-49da-a323-8f12058995a0</p>
<br/>

<p>多文件上传测试</p>
<s:form action="imagesupload" namespace="/"
 enctype="multipart/form-data"
 method="post"  theme="simple">
 <s:token></s:token>
 <s:debug></s:debug>
<s:actionerror/>
<s:fielderror name="image"></s:fielderror>

<br/>
file:<s:file name="images" lable="选择文件"></s:file><br/>
 <s:file name="images" label="选择文件"/><br/>
<br/>
SessionID<s:textfield name="SessionID"></s:textfield><br/>
goods_id<s:textfield name="goods_id"></s:textfield><br/>
action指令<s:textfield name="action" value="删除图片"></s:textfield><br/>
要删的图片名<s:textfield name="DNames"></s:textfield><br/>
要删的图片名<s:textfield name="DNames"></s:textfield><br/>
<br/>
<s:submit name="submit" value="上传文件"></s:submit>

</s:form>
</center>

</body>
</html>