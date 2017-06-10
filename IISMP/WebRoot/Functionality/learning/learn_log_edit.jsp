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
	     
        <!-- 编辑器 -->
	    <link rel="stylesheet" href="qingeditor/qingstyle.css" />
		<script charset="utf-8" src="qingeditor/qingeditor-min.js"></script>
		<script>var textarea_name='content';</script>
		<script charset="utf-8" src="qingeditor/qingeditor-set.js"></script>  
	     
    <style>
	  ul{margin-top:0px;list-style:none;}
	  .fg {float:left;}
	  .fg p {float:left;}
	  .fg label {font-weight:normal;}
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
		 
		  <!-- 编辑日志开始 -->
		  <div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
			<h4 style="margin-top:10px;">
			              编辑日志
				<span class="navbar-right" style="margin-right: 4px;">
				    <button type="button" onclick="javascript:history.back(1);" class="btn btn-info btn-xs" >&nbsp;返回日志列表&nbsp;</button>&nbsp;&nbsp;&nbsp;
				</span>
			</h4>
			<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
			<div style="overflow-x:hidden; height:487px; ">
			  			  
			   <form action="?" id="con" class="con" name="form1" method="post" style="width:100%;">
			     <textarea id="cot" class="cot" name="content" style="width:100%;height:380px;">
			             请输入内容.......
			     </textarea>
			   </form>
			    
				<div class="fg" >				  	
				  	<p>
					  	<label>分类：</label>
					  	<select style="width:150px;height:28px;padding:0;margin-right:10px;">
					    	<option>个人日志</option>
					    	<option>情感天地</option>
					    	<option>休闲娱乐</option>
					  	</select>
					  	<a href="#" data-toggle="modal" data-target="#modal-container-1847" style="text-decoration:none;margin-right:10px;">添加分类</a>
					</p>						
				    <p>
				      <label>权限：</label>
				      <select style="width:150px;height:28px;padding:0;">
					    	<option>公开</option>
					    	<option>仅自己可见</option>
					    	<option>指定好友可见</option>
					  	</select>
				    </p>				    
				</div>
				
		        <div class="form-group">
     			  <div class="col-sm-8" >
			      	<button type="button" class="btn btn-default btn-info">保存并发表</button>&nbsp;&nbsp;
					<button type="button" class="btn btn-default btn-info">存为草稿</button>&nbsp;&nbsp;
					<button type="button" class="btn btn-default">取消</button>
			      </div>   
			    </div>	     				 
	        </div>
		  </div>	  
		<!-- 编辑日志结束 -->
		
		<!-- 增添分类弹框开始 -->
		<div class="modal fade" id="modal-container-1847" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
							添加日志分类
						</h4>
					</div>
					<div class="modal-body" style="font-size: 13px;">							
					    <form class="form-horizontal">
					        <div class="form-group">
					          <label for="firstname" class="col-sm-2 control-label">新添分类：</label>
			                  <div class="col-sm-9">
			                    <input type="text" class="form-control input-sm" id="sectionname" placeholder="请输入日志分类名">
				              </div> 
				            </div>   		  
				         </form>    								
					 </div>
					 <div class="modal-footer">
					    <button type="submit" class="btn btn-primary">确定</button>
			            <button type="reset" class="btn btn-default">取消</button>
					 </div>
				</div>
			</div>
		</div>
		<!-- 增添分类弹框结束 -->
		
	     </div>
	</div>
</div>

  </body>
</html>

