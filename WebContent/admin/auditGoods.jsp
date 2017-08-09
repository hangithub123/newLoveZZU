<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int a=1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="<%=basePath%>js/admin.js"></script>

<title>Insert title here</title>
<style type="text/css">
td {
	text-align: center; /*设置水平居中*/
	vertical-align: middle; /*设置垂直居中*/
}
</style>


</head>
<body>
	<center>
		<font size="5"><p>请输入搜索关键语句,为空则查询所有商品</p></font>
		<form action="adminAction_search" method="post" namespace="/">
			<font size="5"> 搜索:<input type="text" name="SearchGoods"
				placeholder="例如:商品名/分类/校区/描述等"
				style="width: 250px; height: 40px;" />
				 <input type="submit"
				value="提交" style="width: 50px; height: 30px;" />
			</font>
			
		</form>
		
		<s:include value="searchResult.jsp"></s:include>
		
		
	</center>
	
</body>
</html>