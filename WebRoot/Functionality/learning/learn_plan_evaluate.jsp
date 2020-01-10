<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<Assess> assessinfo = (List<Assess>)request.getAttribute("assessinfo");
Page pinfo = (Page)request.getAttribute("pinfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>创新实验室自学管理平台</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap_3.3.4.js" type="text/javascript"></script>
	<link href="css/bootstrap_3.3.4.css" rel="stylesheet">
	<link href="css/mycss.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet">
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
     <link rel="Shortcut icon" href="img/favicon.ico">   
    
    <script src="js/myjs.js" type="text/javascript"></script>
    
    <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
    
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
  </head>
  
<body style="background-color: #EDEFF0;">

 
<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
			<div class="row clearfix">
			
				<!-- 计划栏导航 -->
				<jsp:include page="learn_plan_navigation.jsp"></jsp:include>
						
				<!-- 全部计划 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						我的评分						 
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
			    
			    <div class="col-md-12 column" style="overflow-x:hidden; height:498px;">
					<h3><%=memberinfo.getM_truename() %>&nbsp;&nbsp;<span style="font-size:16px;">----<%=memberinfo.getM_sectionname() %></span></h3><br />  
					 <table  class="table table-hover" style="font-size: 13px;">
						<thead>
							<tr>
							    <th>排名</th>	   			
								<th>考勤</th>
								<th>平时表现</th>
								<th>计划进度</th>
								<th>心得分享</th>
								<th>合计</th>
								<th>评价时间</th>
							</tr>
						</thead>
						<tbody >
							<tr>
							    <td style="color:red;">10</td>
								<td style="align:center;">15</td>
								<td>30</td>
								<td>30</td>
								<td>9</td>
								<td>84</td>
								<td class="p13-999">2016-10-7 21:06</td>	
							</tr>
						</tbody>
					</table>
			    </div>
		    </div>
  </div>
</div>
</body>
</html>
