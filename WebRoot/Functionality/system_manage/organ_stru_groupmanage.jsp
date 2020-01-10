<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
@SuppressWarnings("unchecked")
List<Section> section = (List<Section>)session.getAttribute("sectioninfo");
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
	         $("a[lang=8]").addClass("pre");//设置选中的
	         $("a[lang=8]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
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
			
				<!-- 组织结构导航 -->
				<jsp:include page="sys_mana_navigation.jsp"></jsp:include>
				
				<!-- 新建小组开始 -->
		      	
				<div class="modal fade" id="modal-container-184705" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">
									新建小组
								</h4>
							</div>
							<div class="modal-body" style="font-size: 13px;">							
							   <form class="form-horizontal" role="form">
							    	<div class="form-group">
									   <label for="firstname" class="col-sm-2 control-label">新建组名：</label>
									   <div class="col-sm-9">
									      <input type="text" class="form-control input-sm" id="sectionname" placeholder="请输入组名">
									   </div>
									 </div>
									 <div class="form-group">
									   <label for="firstname" class="col-sm-2 control-label">说明：</label>
									   <div class="col-sm-9">
									    <textarea class="form-control" id="remark" rows="3"></textarea>
									   </div>
									 </div>
						         </form>								
							 </div>
							 <div class="modal-footer">
								 <button type="button" class="btn btn-default"  data-dismiss="modal">关闭</button>
								  <button type="button" onclick="newgroup();" class="btn btn-primary">保存</button>
							</div>
						</div>
					</div>
				</div>
		      	<!-- 新建小组结束 -->
						
				<!-- 全部分组 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>全部分组</span>
						<span class="navbar-right" style="margin-right: 5px;">
							 <button type="button" onclick="clearinputfunction();" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal-container-184705">新建小组</button>
							 <button type="button" onclick="refreshsection();" class="btn btn-info btn-xs">刷新</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:498px; ">
						<table class="table table-hover" style="font-size: 13px;">
							<thead>
								<tr>	   
									<th>组名</th>
									<th>更新时间</th>
									<th>说明</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="thistbody">
							<%
							if(section!=null  && section.size() > 0){
								for(int i=0;i<section.size();i++){
									Section s = section.get(i);
							%>
								<tr>
									<td><%=s.getSection_name() %></td>
									<td><%=s.getTime() %></td>
									<td><%=s.getRemark() %></td>
									<td>
										<a id="modal-722544" onclick="findsectioninfobyid(<%=s.getId() %>)" href="#modal-container-722544" data-toggle="modal" style="text-decoration: none;">
										  <img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>
										<a href="javascript:void(0);" onclick="deletethidsection(<%=s.getId() %>)" style="text-decoration: none">
										    <img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a>
									</td>	
								</tr>
							<%
								}
							}else{
							%>
								<tr>
									<td>暂无信息...</td>
									<td></td>
									<td></td>
									<td></td>	
								</tr>
								
							<%
							}
							%>
							</tbody>
						</table>	
					</div>	
				</div>
				<!-- 全部公告 -->
				
				<!-- 编辑小组开始 -->
				<div class="modal fade" id="modal-container-722544" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">
									编辑组名
								</h4>
							</div>
							<div class="modal-body" style="font-size: 13px;">
									 <form class="form-horizontal" role="form">
							    	<div class="form-group">
									   <label for="firstname" class="col-sm-2 control-label">编辑组名：</label>
									   <div class="col-sm-9">
									      <input type="text" class="form-control input-sm" id="i_sectionname" placeholder="请输入组名">
									   </div>
									 </div>
									 <div class="form-group">
									   <label for="firstname" class="col-sm-2 control-label">说明：</label>
									   <div class="col-sm-9">
									    <textarea class="form-control" rows="3" id="i_remark"></textarea>
									   </div>
									 </div>
								</form>
							</div>
							<div class="modal-footer">
								 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
								 <span style="display: none;" id="section_id"></span>
								 <button type="button" onclick="section_saveeditinfo();" class="btn btn-primary">保存</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 编辑小组结束 -->
			</div>
		</div>
</div>
<%session.removeAttribute("sectioninfo"); %>
  </body>
</html>
