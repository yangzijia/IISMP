<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String error=(String)request.getAttribute("error");

System.out.println("a="+error);

boolean a=(error!=null);
%>
<!DOCTYPE html>  
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>创新实验室自学管理平台</title>
	<link rel="stylesheet" type="text/css" href="css/nologin/login.css"/> 
	<link rel="stylesheet" type="text/css" href="css/nologin/ripple.css"/>
	<script src="js/nologin/ripple.min.js" charset="UTF-8"></script>
	<link rel="Shortcut icon" href="img/favicon.ico">   
	<script type="text/javascript">
	    new Ripple({
	        opacity : 0.6,  //水波纹透明度
	        speed : 1,      //水波纹扩散速度
	        bgColor : "#fff", //水波纹颜色
	        cursor : true  //是否显示手型指针
	    })
	    
		if (navigator.userAgent.indexOf('Firefox') >= 0 || navigator.userAgent.indexOf('Chrome') >= 0){
			url1 = 'http://'+window.location.host+'/IISMP' + '/Functionality/login.jsp';
			window.location.href = url1;
		}
	   // if(window.top!==window.self){window.top.location=window.location};
		var a=<%=a%>;
		if(a){
			alert('<%=error %>');
		}
		function checkLog() {
			if(form1.username.value==""){
				window.alert("用户名不能为空！！");
				return false;
				
			}
			if(form1.m_password.value==""){
				window.alert("密码不能为空！！");
				return false;
			}
			
		}
		$(document).ready(function () { 
		
			var n = new Date();
			nowyear = n.getFullYear();
			$("#toNowdate").html("2016 - "+nowyear);
		})
	</script>
</head>
<body>
<div id="login">  
		<h1>登录界面</h1>  
		<form method="post" action="loginAction">  
			<input type="text"   placeholder="用户名" name="m_username"></input>  
			<input type="password" placeholder="密码" name="m_password"></input> 
			<a class="forgetpwd" href="">忘记密码了？</a>		<br>	<br>
			<button class="but"  data-ripple="ripple" onclick="checkLog();" type="submit">登录</button> 
		</form>  
	</div>  
</body>
</html>
