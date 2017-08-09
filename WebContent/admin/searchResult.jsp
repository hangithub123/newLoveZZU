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

<s:iterator value="list">
		
			<table border="1">
				<tr><% int b=a-1; %>
					<td><font color="#CD0000"><%=a++ %></font></td>
					<td><a name="<%=a %>"></a>发布者信息</td>
					<td>商品信息</td>
					<td style="text-align: right;">
					
					<form action="adminAction_deletegoods.action#<%=b %>" method="post" >
					
					<input type="hidden" name="a" value="<%=a %>"/>
					<input type="hidden" name="deletegoods" value="<s:property value="goods.Goods_id" />" />
					<input type="submit" value="删除商品" style="background-color: #FFF8DC;"/>
					</form>
					</td>
					
				</tr>
				<tr>
					<td><s:property value="userinfo.nickname" /></td>
					<td><font color="#FF3030;">:用户昵称</font></td>
					<td ><font color="#1C86EE;">商品ID:</font></td>
					<td ><s:property value="goods.Goods_id" /></td>
				</tr>
				<tr>
					<td><s:property value="userinfo.phone" /></td>
					<td><font color="#FF3030;">:用户手机号</font></td>
					<td><font color="#1C86EE;">商品名字:</font></td>
					<td><s:property value="goods.Gname" /></td>
				</tr>
				<tr>
					<td><s:property value="userinfo.gender" /></td>
					<td><font color="#FF3030;">:用户性别</font></td>
					<td><font color="#1C86EE;">商品类型:</font></td>
					<td><s:property value="goods.Gtype" /></td>
				</tr>
				<tr>
					<td><s:property value="userinfo.academy" /></td>
					<td><font color="#FF3030;">:用户学院</font></td>
					<td><font color="#1C86EE;">商品所在校区:</font></td>
					<td><s:property value="goods.Gcampus" /></td>
				</tr>
				<tr>
					<td><s:property value="userinfo.departments" /></td>
					<td><font color="#FF3030;">:用户院系</font></td>
					<td><font color="#1C86EE;">商品描述:</font></td>
					<td><s:property value="goods.Gdescribe" /></td>
				</tr>
				<tr>
					<td><s:property value="userinfo.professional" /></td>
					<td><font color="#FF3030;">:用户专业</font></td>
					<td><font color="#1C86EE;">商品价格:</font></td>
					<td><s:property value="goods.Gprice" /></td>
				</tr>
				<tr>
					<td><s:property value="userinfo.hometown" /></td>
					<td><font color="#FF3030;">:用户家乡</font></td>
					<td><font color="#1C86EE;">商品发布日期:</font></td>
					<td><s:property value="goods.Gdate" /></td>
				</tr>

				<tr>
					<td><img width="100px" height="100px" src="../uploadFiles/<s:property value="userinfo.imageUrl" />" />
						</td>
					<td><font color="#FF3030;">:用户头像</font></td>
					<td><font color="#1C86EE;">商品图片:</font></td>
				   <td><s:iterator value="gimgs">
				   <img src="../goodsuploadImage/<s:property value="img" />" height="100" width="100" />
		
				   </s:iterator></td>
				</tr>
				</table>
		<P style="width: 80%;">✈----------✈-----------✈--------✈-------✈---------✈</P>
		</s:iterator>
</center>
<p id="5"></p>
</body>
</html>