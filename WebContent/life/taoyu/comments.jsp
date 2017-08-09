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
<p>查询一级评论</p>
<form action="comments_L1Action" method="post">
action:<input type="text"name="action" value="querycomments_L1"/><br/><br/>
goods_id:<input type="text"name="goods_id" value="1"/><br/><br/>
<input type="submit" value="提交">
</form>
<br/>
<br/>
<br/>
 
 
<p>查询二级评论</p>
<form action="comments_L2Action" method="post">
action:<input type="text"name="action" value="querycomments_L2"/><br/><br/>
l1_Cid:<input type="text"name="l1_Cid" value="1"/><br/><br/>
<input type="submit" value="提交">
</form>
<br/>
<br/>

<p>发表一级评论</p>
<form action="comments_L1Action" method="post">
action:<input type="text"name="action" value="postcomments_L1"/><br/><br/>

goods_id:<input type="text"name="goods_id" value="4"/><br/><br/>
SessionID:<input type="text"name="SessionID"  value="ab658cee-f1bd-4aa4-a7a3-0293a6f9b3b2"/><br/><br/>
comments:<input type="text"name="comments"  value="发表了一级评论"/><br/><br/>

<input type="submit" value="提交">
</form>
<br/>
<br/>
<br/>

<p>发表二级评论</p>
<form action="comments_L2Action" method="post">
action:<input type="text"name="action" value="postcomments_L2"/><br/><br/>
l1_Cid:<input type="text"name="L1_Cid" value="1"/><br/><br/>
l2_Cid:<input type="text"name="L2_Cid" value="1"/><br/><br/>
SessionID:<input type="text"name="SessionID"  value="36620df2-d1c0-4a23-b41d-3e46415a4784"/><br/><br/>
comments:<input type="text"name="comments"  value="发表了二级评论"/><br/><br/>
comments为空时，Thumb为1就是点赞，0是取消<br/><br/>
Thumb:<input type="text"name="ThumbNum"  value="1"/><br/><br/>
<input type="submit" value="提交">
</form>
<br/>
<br/>
</center>
</body>
</html>