<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo mm = (MembershipInfo)session.getAttribute("memberinfo"); 
%>
<!-- 审批左边导航-->
<div class="col-md-3 column" style="font-size: 16px;">
	
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
	 	<button type="button" class="btn btn-default btn-block btn-info" onclick="location.href='Functionality/approval/appro_new.jsp'">+&nbsp;&nbsp;新建申请</button>
		<hr>
	      <ul><%if(mm.getRole_num()==1){
	    	  %>	      
	        <a href="ViewAllapproval" style="text-decoration: none;"><li class="bg"><img src="img/apr.png" style="width:18px;height:18px;margin-top:-2px;">&nbsp;&nbsp;全部审批</li></a>
	        <% 
	        }
	        %>
	      	<a href="findMyapproval" style="text-decoration: none;"><li class="bg"><img src="img/appral.png" style="width:18px;height:18px;margin-top:-2px;">&nbsp;&nbsp;我的审批</li></a>
	      </ul>
	</div>
</div>