<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 通讯录 -->
<div id="memberinfosid">
<div class="col-md-6 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
	<h4 style="margin-top:10px;">
		通讯录
	</h4>
	<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
	<div class="col-md-12 column" style="overflow-x:hidden; height:498px;">
		
		<table class="table" style="font-size: 13px;color: #494b4d">
			<caption>所有成员</caption>
		  <tbody id="memberinfostbodyid">
		   
		    
		  </tbody>
		</table>
</div>		
		
	
	
	</div>	
</div>