<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<FinalAssess> assess = (List<FinalAssess>)request.getAttribute("assinfo");
List<Section> section = (List<Section>)request.getAttribute("assesssection");
List<AssessOperator> aoinfo = (List<AssessOperator>)request.getAttribute("aoinfo");
int ac_id = Integer.parseInt(request.getAttribute("ac_idinfo").toString());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>创新实验室自学管理平台</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap_3.3.4.js" type="text/javascript"></script>
	<link href="css/bootstrap_3.3.4.css" rel="stylesheet">
	<link href="css/mycss.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet">
   
    <link rel="Shortcut icon" href="img/favicon.ico">   
   	<!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    
     <!-- 页面加载动画 -->
	<link href="css/jiazaidonghuacss/myspinner.css"  rel="stylesheet">
	
	    <!-- 下划线跟随效果 -->
	    <link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="js/jquery.easing.min.js"></script>
	    <script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
	    <script type="text/javascript">
	        $(function() {
	            $("#line").lavaLamp({
	                fx: "backout", 
	                speed: 600,
	                click: function(event, menuItem) {
	                    return false;
	                }
	            });
	        });
	    </script>
	    
	    <!-- 导航选中效果 -->
	    <script type="text/javascript">
	      $(function(){
	         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
	         $("a[lang=4]").addClass("pre");//设置选中的
	         $("a[lang=4]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }) 
	     </script>
  </head>
  
<body style="background-color: #EDEFF0;">

<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
	   <div class="row clearfix">
			
				<div class="col-md-3 column" >
					<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
						<br>
						<div class="p16">
							<ul>
								<a href="javascript:void(0);" onclick="findfinalinfoBysection('全部成员');" style="text-decoration: none;"><li class="bg">&nbsp;&nbsp;所有成员</li></a>
									<ul>
										
										<%
										if(section!= null){
											for(int i=0;i<section.size();i++){
												Section s = section.get(i);
										%>
											<a href="javascript:void(0);" onclick="findfinalinfoBysection('<%=s.getSection_name() %>');" style="text-decoration: none;">
												<li class="bg">&nbsp;&nbsp;<%=s.getSection_name() %></li>
											</a>
										<%
											}
										}
										%>
									</ul>
										
									</ul>
								
							</ul><br>
						</div>
					</div>
				</div>

				
				<!-- 全部资源 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span id="finalassesssectionid">全部成员</span>
						<span class="navbar-right" style="margin-right: 5px;">
						    <button type="button" onclick="backevalu_index();" class="btn btn-info btn-default btn-xs">返回</button>
						</span> 
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					
					<div style="margin-left: 30px;">
						<span>评估人：</span> 
						<%
						if(aoinfo!=null){
							for(int i=0;i<aoinfo.size();i++){
								AssessOperator a = aoinfo.get(i);
						%>
						<span><a href="openfindassessoperatorinfobyid?operator_id=<%=a.getOperator_id() %>&ac_id=<%=a.getAc_id() %>" style="text-decoration: none;"><%=a.getUsername() %></a></span>
						<%
								if(i!=(aoinfo.size()-1)){
						%>
						、
						<%
								}
							}
						}else{
						%>
						空
						<%} %>
					</div><br>
					<!-- 评价开始 -->
					<div  class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table  class="table table-hover" style="font-size: 13px;">
								<thead>
									<tr>	   
										<th>排名</th>
										<th>姓名</th>
										<th></th>
										<th>考勤</th>
										<th>平时表现</th>
										<th>项目进度</th>
										<th>心得</th>
										<th>合计</th>
									</tr>
								</thead>
						<tbody id="finalassesschartid">
						<tr style="display: none"><td id="ac_iddisplay"><%=ac_id %></td></tr>
						<%
						if(assess!=null){
							for(int i=0;i<assess.size();i++){
								FinalAssess as = assess.get(i);
								//System.out.println("sdfsdfsdfjkslddddddddjjllllllllll");
						%>
							<tr>
								<td><%=i+1 %></td>
							    <td><a href="javascript:void(0);" style="text-decoration: none;"><%=as.getUsername() %></a></td>
								<td class="p13-999"><%=as.getSectionname() %></td>
								<td style="align:center;"><%=as.getKaoqin() %></td>
								<td><%=as.getBiaoxian() %></td>
								<td><%=as.getXiangmu() %></td>
								<td><%=as.getXinde() %></td>
								<td><%=as.getHeji() %></td>
							</tr>
						<%
							}
						}else{
						%>
							<tr>
								<td>无信息...</td>
							    <td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						<%
						}
						%>
						</tbody>
					</table>
                 	
                 	
				</div>
				<!-- 全部资源结束 -->
				</div>
	     </div>
	</div>
</div>
  </body>
</html>
