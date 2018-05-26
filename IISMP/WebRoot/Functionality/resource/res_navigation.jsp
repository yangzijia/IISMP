<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Resource_Type> rt=(List<Resource_Type>)session.getAttribute("type");
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
%>
<!-- 资源栏 -->
<div class="col-md-3 column" >
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
		<div class="p16">
			<ul>
				<a style="text-decoration: none;" href="showRAction">
				  <li class="bg">
				    <img src="img/ku.png" style="width:16px;height:15px;margin-top:-2px;">&nbsp;&nbsp;资源库</li></a>
					<ul>	
						
			<%
	            if(rt != null && rt.size() >0){	
	            for(int i = 0;i<rt.size();i++){
	            	Resource_Type rest = rt.get(i);
	             %>
	            <!--  <span style="display:none;" id="rtid">1</span> -->
	             
	         	<a href="findRbytype?rt_id=<%=rest.getRt_id()%>"  style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;<%=rest.getRt_name()%></li></a>
			  <%
                }
                } 
			
              %>  	
					
				
			</ul>
			<%if(memberinfo.getRole_num()!=4){ %>
				<a style="text-decoration: none;" href="showRTaction" >
					<li class="bg">
						<img src="img/atg.png" style="width:18px;height:18px;">&nbsp;&nbsp;资源库管理
					</li>
			    </a>
				<%} %>
			</ul>
		</div>
	</div>
</div>