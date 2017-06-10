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
		 
		  <!-- 全部日志 -->
		  <div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
			<h4 style="margin-top:10px;">全部日志>>个人日志
			
			<span style="float:right;">
	           <button type="button" class="btn btn-info btn-xs" onclick="location.href='Functionality/learning/learn_log_index.jsp'">&nbsp;返回&nbsp;</button>
	        </span>
	        
	        </h4>
			<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
			<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
				<table class="table table-hover" style="font-size: 13px;">
				<thead>
					<tr>	   
						<th>日志名称</th>
						<th></th>
						<th></th>
						<th>发表时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
						    <p><a href="Functionality/learning/learn_log_infomation.jsp" style="text-decoration: none;">日志一</a></p>
							<p class="p13-999">赞(12)&nbsp;&nbsp;&nbsp;&nbsp;评论(3)&nbsp;&nbsp;&nbsp;&nbsp;转载</p>
						</td>
						<td>
						</td>
						<td></td>
						<td class="p13-999">2016-10-7 21:06</td>
						<td>
							编辑&nbsp;&nbsp;删除
						</td>
					</tr>
					<tr>
						<td>
							<p><a href="Functionality/learning/learn_log_infomation.jsp" style="text-decoration: none;">日志一</a></p>
							<p class="p13-999">赞(12)&nbsp;&nbsp;&nbsp;&nbsp;评论(3)&nbsp;&nbsp;&nbsp;&nbsp;转载</p>
						</td>
						<td>
						</td>
						<td></td>
						<td class="p13-999">2016-10-7 21:06</td>
						<td>
							编辑&nbsp;&nbsp;删除
						</td>
					</tr>
				</tbody>
			</table>
			
			</div>	
		</div>
		<!-- 全部资源结束 -->
	     </div>
	</div>
</div>

  </body>
</html>