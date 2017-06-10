<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
%>
<div class="col-md-3 column">
<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
	<br>
	<div class="p16">
      <ul>
        <a href="javascript:void(0)" style="text-decoration: none;"><li class="bg"><img src="img/aten.png" style="width:18px;height:18px;">&nbsp;&nbsp;我的考勤</li></a>
        <ul>
          <a href="Functionality/attendence/atten_index.jsp" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;考勤打卡</li></a>
          <a href="findattenrecordAction" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;我的记录</li></a>
          <a href="findmyappealAction" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;我的申诉</li></a>
        </ul> 
      </ul>
      <%
      if(memberinfo.getRole_num()==1||memberinfo.getRole_num()==2){
      %>
      <ul>
      	<a href="javascript:void(0)" style="text-decoration: none;"><li class="bg"><img src="img/atg.png" style="width:19px;height:19px;">&nbsp;&nbsp;考勤管理</li></a>
      	<ul>
      	  <a href="findcheckrecordinfo" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;考勤记录</li></a>
          <a href="findcheckstatistics" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;考勤统计</li></a>
          <a href="findallattenexport" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;考勤导出</li></a>
          <a href="findshiftinfo" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;班次设置</li></a>
          <a href="finddefaultIP" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;默认IP</li></a>
      	</ul>
      </ul>
      <%
      }
      %>
     <!--  <ul>
      	<a href="javascript:void(0)" style="text-decoration: none;"><li class="bg">&nbsp;&nbsp;排班管理</li></a>
      	<ul>
      	  <a href="Functionality/attendence/atten_setshift.jsp" style="text-decoration: none;"><li class="bg">&nbsp;&nbsp;班次设置</li></a>
      	</ul>
      </ul> -->
	   </div>
	</div>
</div>