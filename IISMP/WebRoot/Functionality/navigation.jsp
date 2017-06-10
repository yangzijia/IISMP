<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
%>
<div id="tempid" class="tempstyle" style="display:none;"></div>
<div class="spinner" id="spinnerid" style="z-index:99999;display: none;">
  <div class="cube1"></div>
  <div class="cube2"></div>
</div>
<nav class="navbar navbar-inverse navbar-fixed-top"  role="navigation">
	<div class="container-fluid"> 
	<div class="navbar-header">
		<a class="navbar-brand" href="findindexinfo" >创新实验室自学管理平台&nbsp;&nbsp;</a>
		<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#example-navbar-collapse">
			<span class="sr-only">切换导航</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	
	<div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav line" id="line">
			<li>
				<a href="Functionality/attendence/atten_index.jsp"  lang="0">考勤</a>
			</li>
			<%
			if(memberinfo.getM_role().equals("管理员") || memberinfo.getM_role().equals("组长")){
			%>
			<li>
				<a href="showAnnounceAction" lang="1">公告</a>
			</li>
			<%} %>
			<li class="dropdown">
				<a href="findlearnplaninfo" lang="2">学习</a>
				<!-- <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" lang="2">
					学习
				</a>
				<ul class="dropdown-menu">
					<li><a href="findlearnplaninfo">学习计划</a></li>
					<li class="divider"></li>
					<li><a href="findloginfo">学习日志</a></li>
				</ul> -->
			</li>
			<li>
				<a href="showRAction" lang="3">资源</a>
			</li>	
			<li>
				<a href="findallassesschartinfo" lang="4">考评</a>
			</li>
			<li>
				<a href="ViewequipAction" lang="5">设备</a>
			</li>
			<li>
				<a href="ShowContestAction" lang="6">比赛</a>
			</li>
			<!-- <li>
				<a href="ViewApply" lang="7">审批</a>
			</li> -->
			<%
			if(memberinfo.getM_role().equals("管理员") || memberinfo.getM_role().equals("组长")){
			%>
			<li class="dropdown">
				<a href="findororganizationinfo" lang="8">系统管理</a>
				<!-- <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" lang="8">
					系统管理
				</a>
				<ul class="dropdown-menu">
					<li><a href="findororganizationinfo">组织结构</a></li>
				</ul> -->
			</li>
			<%} %>
			<div id="marker"></div>
		</ul>
		
		<ul class="nav navbar-nav navbar-right"> 
	        <li>
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					 <%=memberinfo.getM_truename() %>  
					 <span class="glyphicon glyphicon-user"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="Functionality/personaldata/personal_index.jsp">个人资料</a></li>
					<li class="divider"></li>
					<li>
						<a href="javascript:void(0);" onclick="logoutmethod()">退出</a>
					</li>
				</ul>
			</li>
    	</ul> 
	</div>
	</div>
</nav>
