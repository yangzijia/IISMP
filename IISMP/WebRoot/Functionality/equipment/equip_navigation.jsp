<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 写设备左边栏 -->
<div class="col-md-3 column" >
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
		
		<div class="p16">
		  <ul>
			
		   <a href="ViewequipAction" style="text-decoration: none;"><li class="bg"><img src="img/eqiup.png" style="width:18px;height:16px;margin-top:-2px;">&nbsp;&nbsp;全部设备</li></a>
		   <a href="ShowequipAction" style="text-decoration: none;"><li class="bg"><img src="img/atg.png" style="width:18px;height:17px;margin-top:-2px;">&nbsp;&nbsp;设备管理</li></a>

		  </ul>
		   <br>
		</div>
	</div>
</div>