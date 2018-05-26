<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
List<Project> project=(List<Project>)session.getAttribute("project");
List<Contest> contest=(List<Contest>)session.getAttribute("contest");
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
	<link href="css/wllcss.css" rel="stylesheet">
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
	         $("a[lang=6]").addClass("pre");//设置选中的
	         $("a[lang=6]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
	     </script>
    <style>
      .caption h4 {font-size:16px;}
      .ba {padding:1px 6px;font-size:13px;}
      .ren {float:right;margin-top:5px;}
      .col {margin-top:6px;}
      .thumbnail a:hover img{
	    -webkit-transform:scale(1.1,1.1);
	    -moz-transform:scale(1.1,1.1);
	    -transform:scale(1.1,1.1);
	   }
    </style>
  </head>  
<body style="background-color: #EDEFF0">

<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
		<div class="row clearfix">
			
			<!-- 左边栏导航 -->
			<jsp:include page="cont_navigation.jsp"></jsp:include>
					
			<!-- 全部比赛 -->
			<div class="col-md-9 column" style="-webkit-box-shadow:inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color:#FFFFFF;">
				<h4 style="margin-top:10px;">全部比赛</h4>
				<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
				<div class="col-md-12 column" style="overflow-x:hidden; height:495px;">
				<div class="row">	
				
				<!-- 缩略图开始 -->
				<%
				if(contest!=null&&contest.size()>0){
					int i=0;
			    	for(;i<contest.size();i++){
					Contest c=contest.get(i);	
				%>	
				
					<div class="col-md-6">
						<div class="thumbnail">
							<a href="<%=c.getContets_url() %>" target="_blank"><img  src="
							<%
							if(c.getC_image()==null){
							%>
							contestimage/kong.jpg
							<%
							}else{
							%>
							<%=c.getC_image() %>
							<%} %>
							" style="height: 220px;width: 400px;"></a>
							<div class="caption">
								<h4>
									<%=c.getContest_title()%>
									<span class="p13-999 ren"><%=c.getProject_member()%></span>
								</h4>
								<p>
									<h5 class="p13-999">
									<%=c.getProject_info() %>
								    </h5>
								</p>
								<p>
									<a class="btn btn-primary ba" href="findCByid?contest_id=<%=c.getContest_id()%>">编辑</a>
									<a class="btn" href="javascript:void(0);" 	 onclick="findCbyid(<%=c.getContest_id() %>)"	data-toggle="modal" data-target="#modal-container-72256">查看详情</a> 
								</p>
							</div>
						</div>
					</div>
						<%
					}
				}else{
					%>
					&nbsp;&nbsp;&nbsp;无信息...
					
				<%} %>
			
				<!-- 缩略图结束 -->
				
				
				<!-- 查看详情开始  -->
				<div class="modal fade" id="modal-container-72256" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				   <div class="modal-content">
					 <div class="modal-header">
					   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					    <h4 class="modal-title" id="myModalLabel">
							查看详情
						</h4>
					 </div>
					 <div class="modal-body" style="font-size: 13px;">
						<form class="form-horizontal" role="form">
						  <div class="form-group">
						     <div class="col-sm-1"></div>
							 <div class="col-sm-10">
							   <img id="cimage" src="contestimage/kong.jpg" style="max-width: 170px; max-height: 100px;"/>
							 </div>
							 <div class="col-sm-1"></div>
						  </div>
						  <br />
						  <div class="form-group">
						       <label class="col-sm-3 control-label">参赛项目：</label>
						       <div class="col-sm-8 col"	id="project_name">
						                       
						       </div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">参赛人员：</label>
						       <div class="col-sm-8 col" 	id="project_member">
						                        
						       </div>
						  </div>
						  <div class="form-group">
						      <label class="col-sm-3 control-label">参赛文件：</label>
						      <div class="col-sm-8 col">
						         <a href="javascript:void(0)" style="font-size:15px;"><em>想要查看，点我下载！！！</em></a>
						      </div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">参赛时间：</label>
						       <div class="col-sm-8 col" 	id="contest_time">
						        
						       </div>
						  </div>  
						  <div class="form-group">
						       <label class="col-sm-3 control-label">参赛地点：</label>
						       <div class="col-sm-8 col" id="contest_place">
						                         
						       </div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">项目介绍：</label>
						       <div class="col-sm-8 col"	id="project_info">
						                         
						       </div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">取得成绩：</label>
						       <div class="col-sm-8 col"	id="project_awads">
						                        
						       </div>
						  </div>
						  <div class="form-group">
							   <label for="firstname" class="col-sm-3 control-label">经验心得：</label>
							   <div class="col-sm-8 col"	id="contest_experience">
							   
							   </div>
						  </div>
						</form>
						<br />
					</div>
			   	  </div>
				 </div>	
				</div>				
				<!-- 查看详情结束  -->
				
				</div>	
			</div>
			<!-- 全部比赛结束 -->
		</div>
	</div>
</div>
</div>
</body>
</html>
