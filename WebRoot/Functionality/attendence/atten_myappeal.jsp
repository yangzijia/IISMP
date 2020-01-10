<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}

List<Attendance_unusual> atten = (List<Attendance_unusual>)request.getAttribute("atten_unusualinfo");
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
    <!--导航选中效果 -->
    <script type="text/javascript">
      $(function(){
         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
         $("a[lang=0]").addClass("pre");//设置选中的
         $("a[lang=0]").css("color","#fff");
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
			
				<!-- 考勤导航 -->
				<jsp:include page="atten_navigation.jsp"></jsp:include>
				
				<!-- 我的考勤 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						我的考勤>>我的申诉
						<span class="navbar-right" style="margin-right: 4px;">
							<button type="button" class="btn btn-info btn-xs" onclick="findweichuliappealinfo();">未处理</button>
							<button type="button" class="btn btn-info btn-xs" onclick="findyichuliappealinfo();">已处理</button>
						 	<button type="button" class="btn btn-info btn-xs" onclick="flushthispage();">刷新</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="font-size: 13px;overflow-x:hidden; height:495px; ">
						<table class="table table-hover" style="font-size: 13px;">
						  <thead>
						    <tr>
						      <th>申诉时间</th>
						      <th>考勤信息</th>
						      <th>申诉内容</th>
						      <th>考勤时间</th>
						      <th>处理状态</th>
						    </tr>
						  </thead>
						  <tbody id="myappealbody">
						  <%
						  if(atten!=null && atten.size() > 0){
							  for(int i=0;i<atten.size();i++){
								  Attendance_unusual a1 = atten.get(i);
						  %>
						  	 <tr>
						      <td>
						      	<p><%=a1.getDtime() %></p> 
						      	<p class="p13-999"><%=a1.getTime() %></p>
						      </td>
						      <td>
						      	<!-- <span class="p13-999">签到</span>&nbsp;&nbsp;&nbsp;&nbsp; -->
						      	<span style="color: red"><%=a1.getBeforestate() %></span>
						      </td>
						      <td><%=a1.getRemark() %></td>
						      <td>
						      	<p>
						      		<span><%=a1.getDatetime() %></span>  
						      		<span><%=a1.getAtten_week() %></span>
						      	</p>
						      	<p class="p13-999"><%=a1.getAttendanceshift() %></p>
						      </td>
						      <td>
						      	<%if(a1.getState()==1){ %>
						      		<span style="color:red">未处理</span>
						      	<%
						      	}else if(a1.getState()==2){
						      	%>
						      		<span class="p13-999">已处理</span>
						      	<%
						      	}
						      	%>
						      </td>
						    </tr>
						    <%
							  }
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
