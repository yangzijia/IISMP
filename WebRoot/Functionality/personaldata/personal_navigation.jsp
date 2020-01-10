<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 个人资料 -->
<div class="col-md-3 column" style="font-size: 16px;">
	
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
	      <ul>
	        <a href="Functionality/personaldata/personal_index.jsp" style="text-decoration: none;"><li class="bg">
	        <img src="img/my.png" style="width:18px;height:18px;">&nbsp;&nbsp;个人设置</li></a>
	      	<a href="Functionality/personaldata/personal_userpicture.jsp" style="text-decoration: none;"><li class="bg">
	      	<img src="img/editpicture.png" style="width:18px;height:18px;">&nbsp;&nbsp;头像修改</li></a>
	      </ul>
	      <br>
	</div>
</div>