<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Log_type> ltype = (List<Log_type>)session.getAttribute("logtype");
List<Learning_Log> log_draft = (List<Learning_Log>)request.getAttribute("log_draft");
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
      <!-- 修改的内容 -->
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
		  #cot hr {height:1px;color:#333;}
	 	</style>
    <!-- 修改内容结束 -->

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
			<h4 style="margin-top:10px;">
			草稿箱			
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
						<th>保存时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<% 
				if(log_draft!=null&&log_draft.size()>0){
					for(int i=0;i<log_draft.size();i++){
						Learning_Log lg=log_draft.get(i);
						
				%>
					<tr>
						<td>
						    <p><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-123456"><%=lg.getL_subject() %></a></p>
							
						</td>
						<td>
						</td>
						<td></td>
						<td class="p13-999"><%=lg.getL_time()%></td>
						<td>
						<a href="javascript:void(0);"  style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-123457">
						<img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="编辑"></a>
						&nbsp;
						<a href="javascript:void(0);"  style="text-decoration: none;"><img src="img/del.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="删除"></a>
						</td>
					</tr>
					<!-- <tr>
						<td>
							<p><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-123456">日志一</a></p>
							
						</td>
						<td>
						</td>
						<td></td>
						<td class="p13-999">2016-10-7 21:06</td>
						<td>
						修改的东西
						<img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="编辑">
						&nbsp;
						<img src="img/del.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="删除">
						
						</td>
					</tr> -->
					<%
					}
					}
				%>
				</tbody>
			</table>
		       <!-- 修改的东西 -->
		  		    <!-- 编辑日志弹框开始 -->
			<div class="modal fade" id="modal-container-123457" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
						<span id="g_title">日志一 </span>
					</h4>
				</div>						  
				<div class="modal-body" style="font-size: 13px;height:460px;">
					<div style="color:#666666;">
																			  			  
						   <form action="?" id="con" class="con" name="form1" method="post" style="width:100%;">
						     <textarea id="cot" class="cot" name="content" style="width:100%;height:380px;">
						             请输入内容.......
						     </textarea>
						   </form>
						    
							<div class="fg" >				  	
							  	<p>
								  	<label>分类：</label>
								  	<select id="" style="width:150px;height:28px;padding:0;margin-right:10px;">
								    	<%
									if(ltype!=null&&ltype.size()>0){
										for(int i=1;i<ltype.size();i++){
											Log_type lt=ltype.get(i);	
														
										%>
								    	<option onclick="javascript:void(0);" value="<%=lt.getLt_name() %>"><%=lt.getLt_name() %></option>
														    		
										<% 
										}
										}
										%>
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
						 </div>		     
						</div>
				        <div class="modal-footer">
		     			  <div class="col-sm-8" style="float:right;" >
					      	<button type="button" class="btn btn-default btn-info">保存并发表</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-default btn-info">存为草稿</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-default"  data-dismiss="modal">取消</button> 
							
					      </div>   
					    </div>	     				        						 
				     </div>	
			       </div>   								
				 </div>
			 </div>        
			 <!-- 编辑弹窗结束 -->

		   				<!-- 详细内容弹框开始 -->
					<div class="modal fade" id="modal-container-123456" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
										日志日志日志
									</h4>
								</div>						  
								<div class="modal-body" style="font-size: 13px;height:468px;">
									<div style="color:#666666;">
										<div>
											<div class="col-md-5 column">											
													<p class="p13-999">2016-10-17 21:06 </p>
											</div>		
										</div>
									</div>
									<div class="col-md-12 column" style="border-top:1px solid #ccc">
										<br/>
										<div style="height:380px;">
											<span>内容：</span><br><br>
											<div class="col-md-12 column">
											<p  id="x_content"></p>
											</div>
										</div>
										
									</div>
								</div>	
							       </div>   								
								 </div>
							</div>
							<!-- 弹窗结束 -->
							
						<!-- 修改的东西 -->
			</div>	
		</div>
		<!-- 全部资源结束 -->
	     </div>
	</div>
</div>

  </body>
</html>