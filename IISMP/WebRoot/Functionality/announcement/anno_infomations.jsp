<%@page import="org.apache.struts2.interceptor.CookiesAware"%>
<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Announcement> announcement= (List<Announcement>)request.getAttribute("announcementinfo");
Integer Count =  (Integer)application.getAttribute("views");
if( Count ==null || Count == 0 ){  
    
    Count = 1;  
 }else{  
  
    Count += 1;  
 } 
application.setAttribute("views", Count);
Announcement ann=announcement.get(0);

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
    <script src="js/dzjs.js" type="text/javascript"></script>
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
	         $("a[lang=1]").addClass("pre");//设置选中的
	         $("a[lang=1]").css("color","#fff");
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
			
				<!-- 公告栏导航 -->
				<jsp:include page="anno_navigation.jsp"></jsp:include>
				
				<!-- 全部公告 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<button type="button"  class="btn btn-info btn-xs"  onclick="back1()">&nbsp;返回&nbsp;</button>
						<button type="button" class="btn btn-info btn-xs"  onclick="deleteAbyid()">&nbsp;删除&nbsp;</button>
						<span class="navbar-right" style="margin-right: 4px;">
							
							<span  style="display: none;" id="announcement_id11" ><%=ann.getAnnouncement_id()%></span>
							<button type="button" class="btn btn-info btn-xs "  onclick="last()"  >&nbsp;上一条&nbsp;</button>						
							<button type="button" class="btn btn-info btn-xs"  onclick="next()"  >&nbsp;下一条&nbsp;</button>
						
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div style="overflow-x:hidden; height:487px; ">
						<h3 id="announcement_title">
							标题：<%=ann.getAnnouncement_title() %>
						</h3>
						<br>
						<div style="color:#666666;">
							<div>
								<div class="col-md-4 column">
									<div class="col-md-4 column"  >
										<p class="navbar-right">发布人：</p>
									</div>
									<div class="col-md-8 column">
										<p  id="an_man"><%=ann.getM_username() %></p>
									</div>
								</div>
								<div class="col-md-4 column">
									<div class="col-md-4 column" >
										<p class="navbar-right">发布时间：</p>
									</div>
									<div class="col-md-8 column" >
										<p id="an_time"><%=ann.getAnnouncement_time() %></p>
									</div>
								</div>
								<div class="col-md-4 column">
									<div class="col-md-4 column">
										<p class="navbar-right">接收人：</p>
										
									</div>
									<div class="col-md-8 column">
											
									</div>
								</div>
							</div>
							<div>
								<div class="col-md-4 column">
									<div class="col-md-4 column"  >
										<p class="navbar-right">所属栏目：</p>
									</div>
									<div class="col-md-8 column" >
										<p id="an_section"><%=ann.getAs_name()%></p>
									</div>
								</div>
								<div class="col-md-4 column" >
									<div class="col-md-4 column">
										<p class="navbar-right">浏览次数：</p>
									</div>
									<div class="col-md-8 column"  >
										<p id="views"><%=Count/* ann.getAnnouncement_views() */%></p>
									</div>
								</div>
								<div class="col-md-4 column">
									&nbsp;
								</div>
							</div>
						</div>
						<br><br><hr>
						公告内容:
						<p id="announcement_info"><%=ann.getAnnouncement_info() %></p>
					</div>	
				</div>
				<!-- 全部公告 -->
			</div>
		</div>
</div>
  </body>
</html>
