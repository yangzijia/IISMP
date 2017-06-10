 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

    <link rel="Shortcut icon" href="img/favicon.ico">   

    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
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
						<span>新建计划</span>
						<span class="navbar-right" style="margin-right: 5px;">
							 <button type="button" class="btn btn-info btn-xs" onclick="javascript:history.back(1);">返回</button>
						</span>							 
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div style="overflow-x:hidden; height:498px; ">
					  
					  <div class="modal-body" style="font-size: 13px;">	
					  <!-- 计划时间开始 --> 
					  <form class="form-horizontal" role="form">
						  <div class="form-group">
						  	<label  for="name" class="col-sm-2 control-label">计划时间：</label>
						    <div class="col-sm-9 form-inline">
						    <input type="text" class="form-control input-sm" onchange="checkthistime1();" id="datepicker" placeholder="****-**-**">
						    ~
						    <input type="text" class="form-control input-sm" onchange="checkthistime2();" id="datepicker0" placeholder="****-**-**">
						   <script type="text/javascript">
						   var picker = new Pikaday(
							{
							    field: document.getElementById('datepicker'),
							    firstDay: 1,
							    minDate: new Date('2010-01-01'),
							    maxDate: new Date('2020-12-31'),
							    yearRange: [2000,2020]
							});
							var picker = new Pikaday(
							{
							    field: document.getElementById('datepicker0'),
							    firstDay: 1,
							    minDate: new Date('2010-01-01'),
							    maxDate: new Date('2020-12-31'),
							    yearRange: [2000,2020]
							});
						   </script>
						    </div>
						  </div>  
						</form>
						<!-- 计划时间结束 -->
						
						<!-- 计划标题、内容、总结开始 -->						
					     <div class="form-horizontal">
					    	<div class="form-group">
							   <label for="firstname" class="col-sm-2 control-label">计划标题：</label>
							   <div class="col-sm-9">
							      <input type="text" class="form-control input-sm" id="ltitle" placeholder="请输入标题......" style="width:49%;">
							   </div>
							 </div>
							 <div class="form-group">
							   <label for="firstname" class="col-sm-2 control-label">计划内容：</label>
							   <div class="col-sm-9">
							    <textarea class="form-control" rows="3" id="lcontent" placeholder="......"></textarea>
							   </div>
							 </div>
							 <div class="form-group">
							   <label for="firstname" class="col-sm-2 control-label" >计划总结：</label>
							   <div class="col-sm-9">
							    <textarea class="form-control" rows="3" id="lsummarize" placeholder="......"></textarea>
							   </div>
							 </div>
				         
				         <!-- 计划标题、内容、总结结束 -->
				         
				         <!-- 上传附件开始 -->							
						    <div class="form-group">
							  <br><br>
							  <div class="col-sm-2"></div> 
							  <div class="col-sm-6">
							    <button type="button" id="lijifabu" onclick="lijifabu();" class="btn btn-default btn-info">立即发布</button>
					            &nbsp; &nbsp;
					            <button type="button" class="btn btn-default" >取消</button> 	  
		                      </div> 
		                      <div class="col-sm-3"></div> 					
							</div>
						  <!-- 上传附件结束 -->
					        </div>	
		     	      </div>
					  
					</div>	
				</div>
				<!-- 全部计划结束 -->
			</div>
		</div>
</div>
  </body>
</html>
