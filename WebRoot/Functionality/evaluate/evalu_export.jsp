<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<AssessChart> acinfo = (List<AssessChart>)request.getAttribute("acinfos");
List<AssessExportChart> aecinfo = (List<AssessExportChart>)request.getAttribute("aecinfos");

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
    <script src="js/index.js" type="text/javascript"></script>
    
    <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
	
	 <!-- 页面加载动画 -->
	<link href="css/jiazaidonghuacss/myspinner.css"  rel="stylesheet">
	
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
	         $("a[lang=4]").addClass("pre");//设置选中的
	         $("a[lang=4]").css("color","#fff");
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
			
				<jsp:include page="evalu_navigation.jsp"></jsp:include>
				
				<!-- pinggu -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>考评表导出</span>
						<span class="navbar-right" style="margin-right: 5px;">
						    <button type="button" onclick="flushexportassess();" class="btn btn-info btn-default btn-xs"> 刷&nbsp;新 </button>
						    <button type="button" onclick="openexportassess();" <%if(memberinfo.getRole_num()==4){ %>disabled="disabled"<%} %> class="btn btn-info btn-default btn-xs"   data-toggle="modal" data-target="#modalexportassess"> 导&nbsp;出 </button>
						<!-- 导出开始 -->
						<div class="modal fade" id="modalexportassess" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">
											导出文件
										</h4>
									</div>
									<div class="modal-body">
										<div class="form-inline" role="form">
										   <div class="form-group">
											    <label class="p14-999">选择列表：</label>
											    <select class="form-control input-sm" id="assesschartselectid">
											    <%
											    if(acinfo!=null){
											    	for(int i=0;i<acinfo.size();i++){
											    		AssessChart a = acinfo.get(i);
											    %>
											      <option><%=a.getAssessname() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
											    <%
											    	}
											    }else{
											    %>
											      <option></option>
											    <%
											    }
											    %>
											    </select>
											</div>
											<br>
											<!-- <div class="p14">
											<label class="p14-999">选择类型：</label>
											  <label class="checkbox-inline">
											    <input type="checkbox" id="tongji" name="tongjin">考勤统计表
											  </label>&nbsp;&nbsp;&nbsp;
											  <label class="checkbox-inline">
											    <input type="checkbox" id="jilu" name="jilun">考勤记录表
											  </label>&nbsp;&nbsp;&nbsp;
											  <label class="checkbox-inline">
											    <input type="checkbox" id="shenhe" name="shenhen">考勤审核表
											  </label>
											</div> -->
										</div>
									</div>
									<div class="modal-footer">
										 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
										 <button type="button" onclick="committhisassesschart();" class="btn btn-primary">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 导出结束 -->
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table class="table table-hover" style="font-size: 13px;">
						  <thead>
						    <tr>
						      <th>文件名称</th>
						      <th>导出人</th>
						      <th>导出时间</th>
						    </tr>
						  </thead>
						  <tbody id="assessexportbodyid">
						  <%
						  if(aecinfo!=null&&aecinfo.size()>0){
							  for(int i=0;i<aecinfo.size();i++){
								  AssessExportChart ae = aecinfo.get(i);
						  %>
						    <tr>
						      <td>
						      	<span><%=ae.getExportname() %></span>&nbsp;&nbsp;
						      	<a href="downloadassessFile?filename=<%=ae.getExportname() %>" onclick="javascript:void(0);" style="text-decoration: none;">下载</a>&nbsp;&nbsp;
						      	<a href="javascript:void(0);" onclick="deleteassessexportchart('<%=ae.getId() %>');" style="text-decoration: none;">删除</a>
						      </td>
						      <td><%=ae.getUsername() %></td>
						      <td><%=ae.getUpdatetime() %></td>
						    </tr>
						  <%
							  }
						  }else{
						    %>
						    <tr><td>无信息...</td><td></td><td></td></tr>
						    <%
						  }
						    %>
						  </tbody>
						</table>
					
					</div>	
				</div>
				<!-- 我的考勤 -->
			</div>
		</div>
</div>
  </body>
</html>
