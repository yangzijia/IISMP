<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="UTF-8"%>
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
			<h4 style="margin-top:10px;">分类管理
	
	        <!-- 新建类别开始 -->
	        <span style="float:right;">
	           <button type="button" class="btn btn-info btn-xs" onclick="location.href='Functionality/learning/learn_log_index.jsp'">&nbsp;返回&nbsp;</button>
	           <button type="button"  class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal-container-184703">
	             &nbsp;新建类别&nbsp;
	           </button>
	        </span>
	        </h4>
			<div class="modal fade" id="modal-container-184703" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
								新建类别
							</h4>
						</div>
						<div class="modal-body" style="font-size: 13px;">							
						    <form class="form-horizontal">
						        <div class="form-group">
							      <label for="name" class="col-sm-2 control-label" >类名：</label>
							      <div class="col-sm-9" >
							        <input type="text" class="form-control"  placeholder="请输入名称" id="lt_name">
							      </div>
							    </div>
							    <div class="form-group">
								    <label for="name" class="col-sm-2 control-label">类别描述：</label>
								    <div class="col-sm-9" >
								      <textarea class="form-control" rows="3" id="lt_remark"></textarea>
								    </div> 
								 </div>
					         </form>								
						 </div>
						 <div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							  <button type="button" class="btn btn-primary" onclick="addLogtype()">保存</button>
						 </div>
					</div>
				</div>
			</div>
			<!-- 新建类别结束 -->
	
			<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
			<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
				<table class="table table-hover" style="font-size: 13px;">
				<thead>
					<tr>	   
						<th>类名</th>
						<th></th>
						<th></th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="ltbody">
					<%
				if(ltype!=null&&ltype.size()>0){
					for(int i=0;i<ltype.size();i++){
						Log_type lt=ltype.get(i);	
									
				%>
					<tr>
						<td><%=lt.getLt_name() %></td>
						<td></td>
						<td></td>
						<td class="p13-999"><%=lt.getLt_time()%></td>
						<td>
                           <a href="javascript:void(0);"  onclick="findtypebyid(<%=lt.getLt_id() %>)" data-toggle="modal" data-target="#modal-container-18471" style="text-decoration:none;"> 
                              <img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>
                           &nbsp;
                            <span style=display:none id="lt_id"></span>		
                           <a href="javascript:void(0);" onclick="dellogtype(<%=lt.getLt_id() %>)">
                             <img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a>						
						</td>
					</tr>
				<% 
				}
				}
				%>
				</tbody>
			</table>
			
			<!-- 编辑分类弹框开始 -->
			<div class="modal fade" id="modal-container-18471" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
								编辑
							</h4>
						</div>
						<div class="modal-body" style="font-size: 13px;">							
						    <form class="form-horizontal">
						        <div class="form-group">
						          <label for="firstname" class="col-sm-2 control-label">类名：</label>
				                  <div class="col-sm-9" >
				                    <input type="text" class="form-control input-sm" id="ltname" >
					              </div> 
					            </div>   		  
					         </form>    								
						 </div>
						 <div class="modal-footer">
						    <button type="submit" class="btn btn-primary" onclick="savelogtype()">确定</button>
				            <button type="reset" class="btn btn-default">取消</button>
						 </div>
					</div>
				</div>
			</div>
			<!-- 增添分类弹框结束 -->
			
			</div>	
		</div>
		<!-- 全部类别结束 -->
	     </div>
	</div>
</div>

  </body>
</html>