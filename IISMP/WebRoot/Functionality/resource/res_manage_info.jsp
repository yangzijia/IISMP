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
	         $("a[lang=3]").addClass("pre");//设置选中的
	         $("a[lang=3]").css("color","#fff");
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
  
<body style="background-color: #EDEFF0;overflow:hidden;">
 
<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
	   <div class="row clearfix">
			
				<jsp:include page="res_navigation.jsp"></jsp:include>
				
				<!-- 全部资源 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>资源库 >>文档一</span>
						<span style="float:right;">		
				  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:history.back(1);">&nbsp;返回&nbsp;</button>
						 	<button type="button" class="btn btn-info btn-xs"   data-toggle="modal" data-target="#modal-container-184700"">&nbsp;上传&nbsp;</button>
						 	<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal-container-184701" >&nbsp;新建文件夹&nbsp;</button>
						</span> 	
					</h4>
					<!-- 上传资源开始 -->
					<div class="modal fade" id="modal-container-184700" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										上传资料
									</h4>
								</div>
								<div class="modal-body">							
								    <form enctype="multipart/form-data">
								        <div class="form-group">
								          <label for="inputfile">文件输入</label>
						                  <input id="file-0a" class="file" multiple="" data-min-file-count="1" type="file">
						                  <div  style="width:100%;">
							              </div> 
							            </div>
							             <div class="form-group">
										    <label for="name">文件说明</label>
										    <textarea class="form-control" rows="3"></textarea>
										 </div>
										  <button type="submit" class="btn btn-primary" style="margin-left:80%;">上传</button>
						                  <button type="reset" class="btn btn-default">重置</button>
							         </form>								
								 </div>
							</div>
						</div>
					</div>
				 	<!-- 新建文件夹开始 -->
					<div class="modal fade" id="modal-container-184701" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										新建文件夹
									</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;">							
								    <form class="form-horizontal" role="form">
							    	<div class="form-group">
									   <label for="firstname" class="col-sm-2 control-label">新文件名：</label>
									   <div class="col-sm-9">
									      <input type="text" class="form-control input-sm" id="sectionname" placeholder="请输入文件名">
									   </div>
									 </div>
									 <div class="form-group">
									   <label for="firstname" class="col-sm-2 control-label">内容说明：</label>
									   <div class="col-sm-9">
									    <textarea class="form-control" id="remark" rows="3"></textarea>
									   </div>
									 </div>
						         </form>									
								 </div>
								 <div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									  <button type="button" class="btn btn-primary">保存</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 新建文件夹结束 -->
					
					<hr style="margin-top:10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table class="table table-hover" style="font-size: 13px;">
						<thead>
							<tr>	   
								<th>名称</th>					
								<th>上传人</th>
								<th>更新时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<span>
										谷歌.ppt
									</span>	
								</td>
								<td>
									<span>
										<a href="javascript:void(0);" style="text-decoration: none;">查看属性</a>
									</span>	
								</td>
								<td class="p13-999">某某某</td>
								<td class="p13-999">2016-10-7 21:06</td>
								<td>
									<a style="text-decoration: none;"  href="javascript:void(0);" role="button" class="btn btn-xs" >
										<img src="img/down.png"  data-toggle="tooltip" data-placement="bottom" title="下载"/>
									</a>
									<a style="text-decoration: none;"  href="javascript:void(0);" class="btn btn-xs">
										<img src="img/edit.png" data-toggle="tooltip" data-placement="bottom"  title="编辑"/>
									</a>
								</td>
							</tr>
							<tr>
								<td>
									<span>
										谷歌文件
									</span>	
								</td>
								<td>
									<span>
										<a href="javascript:void(0);" style="text-decoration: none;">查看属性</a>
									</span>	
								</td>
								<td class="p13-999">某某某</td>
								<td class="p13-999">2016-10-7 21:06</td>
								<td>
									<!-- <img src="img/down.png"  data-toggle="tooltip" data-placement="bottom" title="下载" />&nbsp;&nbsp;
									<img src="img/edit.png" data-toggle="tooltip" data-placement="bottom"  title="修改"/> -->
								    <a style="text-decoration: none;"  href="javascript:void(0);" role="button" class="btn btn-xs" >
										下载
									</a>
									<a style="text-decoration: none;"  href="javascript:void(0);" class="btn btn-xs">
										删除
									</a>
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

<script>
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>

  </body>
</html>