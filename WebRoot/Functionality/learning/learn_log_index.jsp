<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Log_type> ltype = (List<Log_type>)session.getAttribute("logtype");
List<Learning_Log> log = (List<Learning_Log>)request.getAttribute("log");
List<Learning_Log> mylog = (List<Learning_Log>)request.getAttribute("mylog");
MembershipInfo mm = (MembershipInfo)session.getAttribute("memberinfo");
if(mm.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
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
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
     <link rel="Shortcut icon" href="img/favicon.ico">   
    
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/dzjs.js" type="text/javascript"></script>
	
		    <!-- 下划线跟随效果 -->
	    <link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="js/jquery.easing.min.js"></script>
	    <script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
	     <script src="js/dzjs.js" type="text/javascript"></script>
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
	    
	    <!-- 查看个人日志 -->
	    <script type="text/javascript">
	    
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
		 
		  <!-- 全部日志 -->
		  <div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
			<h4 style="margin-top:10px;" id="lt_name">全部日志</h4>
	
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
				<tbody id="log01">
				<% 
					if(log!=null&&log.size()>0){
						for(int i=0;i<log.size();i++){
							Learning_Log lg=log.get(i);
							
				%>
					<tr>
						<td>	
						<p><a href="javascript:void(0);" onclick="findlogByid(<%=lg.getL_id()%>)" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-18477"><%=lg.getL_subject() %></a></p>
						<p class="p13-999"><a href="#" >赞(<%=lg.getL_zan() %>)</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" >评论(3)</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#">转载</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>&nbsp;&nbsp;&nbsp;&nbsp;</p>
						</td>
						<td>
						</td>
						<td></td>
						<td class="p13-999"><%=lg.getL_time()%></td>
						<td >
							<%-- <a href="javascript:void(0);" onclick="findlogByid(<%=lg.getL_id()%>)" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-184222">编辑</a>
							<a href="javascript:void(0);" onclick="deletelogByid(<%=lg.getL_id()%>)"	style="text-decoration: none;">&nbsp;&nbsp;删除</a> --%>
						</td>
					</tr>
					<%
					}
					}
				%>
				</tbody>
				
				<tbody id="log02">
				<% 
					if(mylog!=null&&mylog.size()>0){
						for(int i=0;i<mylog.size();i++){
							Learning_Log lg=mylog.get(i);
							
				%>
					<tr>
						<td>	
						<p><a href="javascript:void(0);" onclick="findlogByid(<%=lg.getL_id()%>)" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-18477"><%=lg.getL_subject() %></a></p>
						<p class="p13-999"><a href="#" >赞(<%=lg.getL_zan() %>)</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" >评论(3)</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#">转载</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>&nbsp;&nbsp;&nbsp;&nbsp;</p>
						</td>
						<td>
						</td>
						<td></td>
						<td class="p13-999"><%=lg.getL_time()%></td>
						<td >
						<span id="l_id" style="display:none"></span>
							<a href="javascript:void(0);" onclick="findlogByid2(<%=lg.getL_id()%>)" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-184222">编辑</a>
							<a href="javascript:void(0);" onclick="deletelogByid(<%=lg.getL_id()%>)"	style="text-decoration: none;">&nbsp;&nbsp;删除</a>
						</td>
					</tr>
					<%
					}
					}
				%>
				</tbody>
			</table>
			
		    <!-- 编辑日志弹框开始 -->
			<div class="modal fade" id="modal-container-184222" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
						<span id="log_title1">日志一 </span>
					</h4>
				</div>						  
				<div class="modal-body" style="font-size: 13px;height:460px;">
					<div style="color:#666666;">
																			  			  
						   <form action="?" id="con" class="con" name="form1" method="post" style="width:100%;">
						     <textarea id="log_content1" class="cot" name="content" style="width:100%;height:380px;">
						             请输入内容.......
						     </textarea>
						   </form>
						    
							<div class="fg" >				  	
							  	<p>
								  	<label>分类：</label>
								  	<select id="log_type" style="width:150px;height:28px;padding:0;margin-right:10px;">
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
								  	
								</p>						
							    <p>
							      <label>权限：</label>
							      <select id="l_purview"style="width:150px;height:28px;padding:0;">
								    	<option onclick="javascript:void(0);" value="公开">公开</option>
								    	<option onclick="javascript:void(0);" value="仅自己可见">仅自己可见</option>
								    	<option onclick="javascript:void(0);" value="指定好友可见">指定好友可见</option>
								  	</select>
							    </p>				    
							</div>
						 </div>		     
						</div>
				        <div class="modal-footer">
		     			  <div class="col-sm-8" style="float:right;" >
					      	<button type="button" class="btn btn-default btn-info" onclick="publishlog()">保存并发表</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-default btn-info" onclick="publishlog2()">存为草稿</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button> 
					      </div>   
					    </div>	     				        						 
				     </div>	
			       </div>   								
				 </div>
			 </div>        
			 <!-- 编辑弹窗结束 -->
			
			<!-- 查看详细内容弹框开始 -->
		    <div class="modal fade" id="modal-container-18477" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
							<span id="log_title2">日志一 </span>
						</h4>
					</div>						  
					<div class="modal-body" style="font-size: 13px;height:468px;">
						<div style="color:#666666;">
						
							<div>
								<p class="p13-999" id="l_time2">2016-10-17 21:06 <!-- &nbsp;&nbsp;&nbsp;阅读(22) --></p>
								<p id="l_member">dongdong</p>						   
					            <hr >
					            <p id="l_con2">         
							                  日志内容..................
							     </p>
							     <br><br><br><br><br><br> <br><br><br><br><br><br>
							     
							</div>
					     </div>	
				       </div>   								
					 </div>
				</div>
				<!-- 详情弹窗结束 -->
			
			</div>	
		</div>
		<!-- 全部日志结束 -->
	     </div>
	</div>
</div>

  </body>
</html>