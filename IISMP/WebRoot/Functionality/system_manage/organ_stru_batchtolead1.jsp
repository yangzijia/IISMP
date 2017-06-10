<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}

ArrayList<UploadMember> alum = (ArrayList<UploadMember>)request.getAttribute("alum");
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
				
				<!-- 批量导入 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>批量导入</span>
						<span class="navbar-right" style="margin-right: 5px;">
							 <button type="button" onclick="openallmemberinfo();" class="btn btn-info btn-xs">返回</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:498px; ">
						<br><br>
						<%
						if(alum.size() > 0 && alum != null){
						%>
							<table class="table table-hover" style="font-size: 13px;">
							<caption>以下名单出现问题，请修改后重新上传&nbsp;&nbsp;&nbsp;
							<a href="openbatchtoleadjsp" style="text-decoration: none;">返回重新上传</a>
							</caption>
						  <thead>
						    <tr>
						      <th>行数</th>
						      <th>姓名</th>
						      <th>性别</th>
						      <td>登录账号</td>
						      <td>所属分组</td>
						      <td>职务</td>
						      <td>手机</td>
						      <td>邮箱</td>
						    </tr>
						  </thead>
						  <tbody>
						  <%
						  for(int i=0;i<alum.size();i++){
							  UploadMember um = alum.get(i);
						  %>
						    <tr>
						      <td><%=um.getRow() %></td>
						      <td><%=um.getTruename() %></td>
						      <td><%=um.getSex() %></td>
						      <td><%=um.getUsername() %></td>
						      <td><%=um.getSectionname() %></td>
						      <td><%=um.getDuty() %></td>
						      <td><%=um.getPhone() %></td>
						      <td><%=um.getEmail() %></td>
						    </tr>
						    <%
						  }
						    %>
						  </tbody>
						</table>
						<%
						}else{
						%>
						<h4>恭喜您，操作成功！！</h4>
						
						<%
						}
						%>
					</div>	
				</div>
				<!-- 全部职务 -->
			</div>
		</div>
</div>
  </body>
</html>
