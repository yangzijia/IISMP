<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
@SuppressWarnings("unchecked")
List<Section> sections = (List<Section>)session.getAttribute("sectioninfo");
%>
<!-- 个人资料 -->
<div class="col-md-3 column" style="font-size: 16px;">
	
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
	      <ul>
	        <a href="findororganizationinfo" style="text-decoration: none;"><li class="bg"><img src="img/allpeople.png" style="width:20px;height:18px;margin-top:-2px;">&nbsp;&nbsp;全部人员</li></a>
	        <ul>
	       <%
	       if(sections != null){
	    	   for(int i=0;i<sections.size();i++){
	    		   Section ss = sections.get(i);
	       %>
	          <a href="findororganizationinfo?section_names=<%=ss.getSection_name() %>" style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;margin-top:-2px;">&nbsp;&nbsp;<%=ss.getSection_name() %></li></a>
	      <%
	    	   }
	       }
	      %>
	        </ul>
	        <a href="findsectionsAction" style="text-decoration: none;">
	        	<li class="bg"><img src="img/atg.png" style="width:19px;height:19px;margin-top:-2px;">&nbsp;&nbsp;分组管理</li>
	        </a>
	        <!-- <a href="Functionality/systemmanage/organization_structure/organ_stru_dutymanage.jsp" style="text-decoration: none;">
	        	<li class="bg">&nbsp;&nbsp;职务管理</li>
	        </a> -->
	      </ul>
	</div>
</div>