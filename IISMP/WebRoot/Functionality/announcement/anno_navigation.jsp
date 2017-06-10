<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Announce_section> section=(List<Announce_section>)session.getAttribute("anno_section");

%>

<!-- 个人资料 -->
<div class="col-md-3 column" style="font-size: 16px;">
	<span style="display: none;" id="announcement_type">保存并发布</span>

	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<br>
	 	<button type="button" class="btn btn-default btn-block btn-info" onclick="opennewannocement()">+&nbsp;&nbsp;新建公告</button>
		<hr>
	      <ul>
	        <a href="showAnnounceAction"  style="text-decoration: none;"><li class="bg"><img src="img/anno.png" style="width:21px;height:20px;"/>&nbsp;&nbsp;全部公告</li></a>
	        <ul>
	         <%
	            if(section != null && section.size() >0){	
	            for(int i = 0;i<section.size();i++){
	             Announce_section asn = section.get(i);
	             %>
	         <%--  <a href="javascript:void(0);" onclick="findanno1('<%=asn.getAs_name()%>')"  style="text-decoration: none;"> --%>
	         <a href="javascript:void(0);" onclick="findanno1('<%=asn.getAs_name()%>')"  style="text-decoration: none;">
	            <li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;<%=asn.getAs_name()%></li>
	          </a>
			  <%
                }
                } 
				
              %>  	
	        </ul>
	      	<a href="showSection" onclick="divxianshi()"  style="text-decoration: none;"><li class="bg"><img src="img/atg.png" style="width:19px;height:19px;">&nbsp;&nbsp;功能设置</li></a>
	      </ul>
	</div>
</div>