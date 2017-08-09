
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/admin.css"/>
<title>管理员</title>
</head>
<script type="text/javascript">
function out() {
	 window.location.href="adminAction_loginout";
}

</script>
<body>
<% String s=null;
   s=(String)session.getAttribute("admin");
if(s!=null && !s.equals("已登录")){
	System.out.print("页面检测到已退出");
	response.sendRedirect("adminlogin.jsp");
}
%>
<div class="top"> 
 <a style="width:10%;height:5%;" ><font style="background-color:#cf6d77;" color="#FDF5E6" size="15">爱上郑大管理界面</font></a>

<div class="top-right"><br/>

<font  size="5" style="background-color:#cf6d77; ">管理员:</font><font  size="5"><%=session.getAttribute("admin")%></font>
&nbsp;&nbsp;
<font  size="6"><a  style=background-color:#cf6d77; href="javascript:out();">退出</a></font>
</div>
</div>



<div class="right">
<iframe src="admin/auditGoods.jsp"width="100%" height="99%" name="right" id="right"scrolling="auto" frameborder="0"></iframe>

</div>
<div class="bottom" >
<font  size="6.5"><a style=background-color:#cf6d77;" href="admin/auditGoods.jsp"  target="right">搜索商品</a></font>&nbsp;

</div>
</body>
</html>