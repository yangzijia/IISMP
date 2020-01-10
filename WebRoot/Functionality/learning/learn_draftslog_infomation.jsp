<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <base href="<%=basePath%>">
    <title>创新实验室自学管理平台</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap_3.3.4.js" type="text/javascript"></script>
	<link href="css/bootstrap_3.3.4.css" rel="stylesheet">
	<link href="css/mycss.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet">
   
    <link rel="Shortcut icon" href="img/favicon.ico">   
   	<!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <script src="js/myjs.js" type="text/javascript"></script>
    
    	    <!-- 下划线跟随效果 -->
	    <link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="js/jquery.easing.min.js"></script>
	    <script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
	    <script type="text/javascript">
	        $(function() {
	            $("#line").lavaLamp({
	                fx: "backout", 
	                speed: 600,
	                click: function(event, menuItem) {
	                    return false;
	                }
	            });
	        });
	    </script>
	    
	    <!-- 导航选中效果 -->
	    <script type="text/javascript">
	      $(function(){
	         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
	         $("a[lang=2]").addClass("pre");//设置选中的
	         $("a[lang=2]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }) 
	     </script>
    <style>
	  ul{margin-top:0px;list-style:none;}
	</style>

  </head>
  
<body style="background-color: #EDEFF0;">

 
<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
	   <div class="row clearfix">
			
		<jsp:include page="learn_log_navigation.jsp"></jsp:include>
		 
		  <!-- 草稿箱开始 -->
		  <div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
			<h4 style="margin-top:10px;">
			        草稿箱>>日志日志日志
				<span class="navbar-right" style="margin-right: 4px;">
				    <button type="button" onclick="javascript:history.back(1);" class="btn btn-info btn-xs" >&nbsp;返回&nbsp;</button>&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-info btn-xs">&nbsp;上一篇&nbsp;</button>&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-info btn-xs">&nbsp;下一篇&nbsp;</button>
				</span>
			</h4>
			<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
			<div style="overflow-x:hidden; height:487px; ">
			  
				<strong style="font-size:22px;">[草稿]日志日志日志</strong>
				<p class="p13-999">2016-10-17 21:06</p>
	            <hr>
	            <p style="height:340px;">
			             日志内容..................
			     <br><br><br><br><br><br>
			    </p>
			     <span style="float:left;margin-bottom:0px;">
				   <button type="button" class="btn btn-default btn-info">&nbsp;删除&nbsp;</button>&nbsp;&nbsp;&nbsp;
				   <button type="button" class="btn btn-default btn-info" onclick="location.href='Functionality/learning/editdraftlog.jsp'">&nbsp;编辑&nbsp;</button>&nbsp;&nbsp;&nbsp;
				   <button type="button" class="btn btn-default btn-info">&nbsp;保存并发表&nbsp;</button>&nbsp;&nbsp;&nbsp;
				   <button type="button" class="btn btn-default btn-info">&nbsp;保存&nbsp;</button>&nbsp;&nbsp;&nbsp;
		         </span>
	        </div>
		  </div>	  
		<!-- 草稿箱结束 -->
	     </div>
	</div>
</div>

  </body>
</html>

