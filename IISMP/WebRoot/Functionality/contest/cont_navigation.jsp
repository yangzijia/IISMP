<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 比赛左边导航-->
<div class="col-md-3 column" style="font-size: 16px;">
	
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
	 	<button type="button" class="btn btn-default btn-block btn-info" onclick="location.href='Functionality/contest/cont_new.jsp'">+&nbsp;&nbsp;增添比赛</button>
		<hr>
	      <ul>
	         <a href="ShowContestAction" style="text-decoration: none;"><li class="bg"><img src="img/bei.png" style="width:16px;height:17px;margin-top:-2px;">&nbsp;&nbsp;所有比赛</li></a>  	
	      	  <a href="ShowProjectAction" style="text-decoration: none;"><li class="bg"><img src="img/case.png" style="width:16px;height:17px;margin-top:-2px;">&nbsp;&nbsp;参赛项目</li></a>
	      	
	      </ul>
	</div>
</div>