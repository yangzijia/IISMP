<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 写日志左边栏 -->
<div class="col-md-3 column" >
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
	 	<button type="button" class="btn btn-default btn-block btn-info"  onclick="location.href='Functionality/learning/learn_newplan.jsp'">+&nbsp;&nbsp;新建计划</button>
		<hr>
		<div class="p16">
		  <ul>
			
		  <a href="findlearnplaninfo" style="text-decoration: none;"><li class="bg"><img src="img/my.png" style="width:18px;height:18px;">&nbsp;&nbsp;我的计划</li></a>
		   <a href="findallplaninfo" style="text-decoration: none;"><li class="bg"><img src="img/our.png" style="width:20px;height:18px;">&nbsp;&nbsp;成员计划</li></a>
		    
		  </ul>
		   <br>
		</div>
	</div>
</div>