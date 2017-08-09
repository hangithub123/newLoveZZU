<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>登陆</title>
		
		
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/snap.svg-min.js"></script>
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		
	</head>
	<style type="text/css">

body{
  
    color: #000000;
    text-align: center;
}

</style>
	<body>
		<div id="pagewrap" class="pagewrap">
			<div class="container show" id="page-1">
				<header class="codrops-header">
					<h1 style="margin-top:10%">爱上郑大管理员登陆界面<span></span></h1>
				</header>
				<section class="columns clearfix">
					<div class="column2">
						<nav class="codrops-demos">
						
							<a class="current-demo" href="index7.html"></a>
						
						</nav>
					</div>
					<div class="column">
						 <s:actionerror cssStyle="color:white"/><br/>
						 <s:form id="loginform" action="adminAction"  method="post" namespace="/" >
						账号:<input type="text" name="account" id="account"/><br/>
						密码:<input type="password" name="password" id="password"/><br/>
						
						<p><a class="pageload-link" href="#page-1"><button type="button"  onclick="checkUser();">登陆</button></a></p>
						</s:form>
						<br/>
						<a href="manage.jsp">接口测试界面</a>
						</div>
				</section>
				<div class="footer-banner" style="width:728px; margin:30px auto"></div>
			</div><!-- /container -->

			<!-- The new page dummy; this would be dynamically loaded content -->
			<div class="container" id="pag">
				<br/><br/><br/>
					<h2 ><font size="30px" style="宋体" color="white">欢迎你管理员</font></h2>

			</div><!-- /container -->

			<div id="loader" class="pageload-overlay" data-opening="M 0,60 80,60 80,50 0,40 0,60;M 0,60 80,60 80,25 0,40 0,60;M 0,60 80,60 80,25 0,10 0,60;M 0,60 80,60 80,0 0,0 0,60" 
			   data-closing="M 0,60 80,60 80,20 0,0 0,60;M 0,60 80,60 80,20 0,40 0,60;m 0,60 80,0 0,0 -80,0">
				<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 80 60" preserveAspectRatio="none">
					<path d="m 0,60 80,0 0,0 -80,0"/>
				</svg>
			</div><!-- /pageload-overlay -->
			
		</div><!-- /pagewrap -->
		<script src="js/classie.js"></script>
		<script src="js/svgLoader.js"></script>
		<script>
			(function() {
				var pageWrap = document.getElementById( 'pagewrap' ),
					pages = [].slice.call( pageWrap.querySelectorAll( 'div.container' ) ),
					currentPage = 0,
					triggerLoading = [].slice.call( pageWrap.querySelectorAll( 'a.pageload-link' ) ),
					loader = new SVGLoader( document.getElementById( 'loader' ), { speedIn : 200, easingIn : mina.linear } );

				function init() {
					triggerLoading.forEach( function( trigger ) {
						trigger.addEventListener( 'click', function( ev ) {
							ev.preventDefault();
							loader.show();
							// after some time hide loader
							setTimeout( function() {
								loader.hide();

								classie.removeClass( pages[ currentPage ], 'show' );
								// update..
								currentPage = currentPage ? 0 : 1;
								classie.addClass( pages[ currentPage ], 'show' );

							}, 2000 );
						} );
					} );	
				}

				init();
			})();
		</script>
		
		<script>



function checkUser(){
	   var result = document.getElementById("account").value;
	   var password = document.getElementById("password").value;
	   if(result == ""  ){
	     alert("用户名不能为空");
	     window.location.href = "adminlogin.jsp";
	     return false;
	   }
	   if(password == ""  ){
	    alert("密码不能为空");
	    window.location.href = "adminlogin.jsp";
	    return false;
	   }else{
		   
		   document.getElementById('loginform').submit() 
	   return true;
	   }
	}
	
	
	
</script>
	</body>
</html>