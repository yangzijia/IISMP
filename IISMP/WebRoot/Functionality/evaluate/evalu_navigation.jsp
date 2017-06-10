<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="col-md-3 column" >
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
		<div class="p16">
			<ul>
				<a href="findallassesschartinfo" style="text-decoration: none;"><li class="bg"><img src="img/table.png" style="width:16px;height:17px;margin-top:-2px;">&nbsp;&nbsp;考评表</li></a>
				<a href="findallexportassessinfo" style="text-decoration: none;"><li class="bg"><img src="img/red.png" style="width:18px;height:18px;margin-top:-2px;">&nbsp;&nbsp;导出记录</li></a>
			</ul><br>
		</div>
	</div>
</div>
