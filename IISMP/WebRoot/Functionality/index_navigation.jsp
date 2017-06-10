<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
System.out.println(memberinfo.getM_userpicture());
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<Section> sectionindex = (List<Section>)request.getAttribute("sectionindex");
int noStateannouncement = Integer.parseInt(request.getAttribute("noState").toString());
%>
<script type="text/javascript">
$(function(){
 	 	<%
 	 	if(!memberinfo.getM_userpicture().equals("-")){
 	 	%>
 	 		var path = '<%=memberinfo.getM_userpicture()%>';
 	 		//alert(path);
 	 		$("#imgId").attr('src',path); 
 	 	<%
 	 	}
 	 	%>
  	});
</script>
<!-- 个人资料 -->

<span style="display: none;" id="announcement_type">保存并发布</span>
	<span style="display: none;" id="as_name">全部公告</span>
<div class="col-md-3 column" >
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<div class="col-md-7 column" align="center">
			<img id="imgId" src="userpicture/default-user.png" class="img-responsive" onclick="location.href='Functionality/personaldata/personal_index.jsp';" style="cursor:pointer;border-radius: 50%;width: 110px;height: 110px;margin-top: 20px;margin-bottom: 20px;"/>
		</div>
		<div class="col-md-5 column" align="center" style="margin-top: 40px;margin-bottom: 20px;">
			<h4 onclick="location.href='Functionality/personaldata/personal_index.jsp';" style="cursor:pointer;"><%=memberinfo.getM_truename() %></h4>
			<span class="p14-999"><%=memberinfo.getM_sectionname() %></span><br />
			<span class="p14-999"><%=memberinfo.getM_role() %></span>
		</div>
	</div>
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<div style="margin-top: 30px;margin-bottom: 30px;font-size: 16px;">  
			<ul>
				<a	onclick="openmyannoinfomations(1);" href="javascript:void(0);"  style="text-decoration: none;">
					<li class="bg"><img src="img/anno.png" style="width:21px;height:20px;"/>&nbsp;&nbsp;公告栏
					<%if(noStateannouncement!=0){ %>
						<span class="badge badge-info" id="noStateAnnoNum"><%=noStateannouncement %></span>
						<%} %>
					</li>
				</a>
				<a onclick="openmyplaninfosindex();" href="javascript:void(0);" style="text-decoration: none;">
					<li class="bg"><img src="img/plan.png" style="width:21px;height:19px;"/>&nbsp;&nbsp;学习计划</li>
				</a>
				<a onclick="openmemberinfos('allinfos');" href="javascript:void(0);" style="text-decoration: none;">
					<li class="bg"><img src="img/telphone.png" style="width:19px;height:19px;">&nbsp;&nbsp;&nbsp;通讯录</li>
				</a>
				<ul>
				<%
					if(sectionindex!= null && sectionindex.size() > 0){
						for(int i=0;i<sectionindex.size();i++){
							Section s = sectionindex.get(i);							
				%>
					<a onclick="openmemberinfos('<%=s.getSection_name() %>');" href="javascript:void(0);" style="text-decoration: none;">
						<li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;<%=s.getSection_name() %></li>
					</a>
					<%
						}
					}
					%>
				</ul>
			</ul>
		</div>
	</div>
</div>
