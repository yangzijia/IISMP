<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Log_type> ltype = (List<Log_type>)session.getAttribute("logtype");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <base href="<%=basePath%>">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

	 <!-- 编辑器 -->
    <link rel="stylesheet" href="qingeditor/qingstyle.css" />
	<script charset="utf-8" src="qingeditor/qingeditor-min.js"></script>
	<script>var textarea_name='content';</script>
	<script charset="utf-8" src="qingeditor/qingeditor-set.js"></script>
    
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
	
		<!-- 日志导航 -->
		<jsp:include page="learn_log_navigation.jsp"></jsp:include>
		
		<!-- 新建日志开始 -->
		<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
			<h4 style="margin-top:10px;">
				写日志
			</h4>
			<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
			<div style="overflow-x:hidden; height:498px; ">
				<form class="form-horizontal" role="form">
					<div class="form-group">
					  	<label class="col-sm-2 control-label">分类：</label>
					  	<div class="col-sm-10" style="width: 300px;">
						  	<select class="form-control" id="ltype_name">
						  	  	<%
								if(ltype!=null  && ltype.size()> 0){
									for(int i=0;i<ltype.size();i++){
										Log_type s = ltype.get(i);
										
									%>
						    	<option onclick="javascript:void(0);"  value="<%=s.getLt_name()%>"><%=s.getLt_name()%></option>
						    	
						    	<%
							    }
							     }
								%>
						  	</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">标题：</label>
					    <div class="col-sm-8">
					      <input class="form-control" type="text" id="log_sub" onKeyDown="LimitTextArea36(this)" placeholder="请不要超过36个字...">
					    </div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">日志内容：</label>
					    <div class="col-sm-8">
					    	
					    	<!-- 编辑器开始 -->
					    	<form action="?" id="con" class="con" name="form1" method="post" style="width:100%;">
						      <textarea id="log_con" class="cot" name="content" style="width:100%;height:340px;">
						                请输入内容.......
						      </textarea>
						    </form>
						    
					    </div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
					    <div class="col-sm-8" >
					      	<button type="button" class="btn btn-default btn-info" onclick="addlog()">保存并发表</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-default btn-info" onclick="adddrafts()">存为草稿</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-default" onclick="">取消</button>
					    </div>
					</div>
				</form>
			</div>	
		</div>
		<!-- 新建日志结束 -->
			</div>
		</div>
</div>
 </body>
</html>

