<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<Assess> assess = (List<Assess>)request.getAttribute("assinfo");
List<Section> section = (List<Section>)request.getAttribute("assesssection");
String typeinfo = (String)request.getAttribute("typeinfo");
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
								<a href="javascript:void(0);" onclick="findassessinfoBysection('全部成员');"  style="text-decoration: none;"><li class="bg">&nbsp;&nbsp;所有成员</li></a>
									<ul>
										<%
										if(section!= null){
											for(int i=0;i<section.size();i++){
												Section s = section.get(i);
										%>
											<a href="javascript:void(0);" onclick="findassessinfoBysection('<%=s.getSection_name() %>');" style="text-decoration: none;">
												<li class="bg">&nbsp;&nbsp;<%=s.getSection_name() %></li>
											</a>
										<%
											}
										}
										%>
									</ul>
								
							</ul><br>
						</div>
					</div>
				</div>

				<span style="display: none;" id="typeinfoid"><%=typeinfo %></span>
				<!-- 全部资源 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span id="pingjiachengyuanxinxi">全部成员</span>	
						<span class="navbar-right" style="margin-right: 5px;">
						    <button type="button" onclick="backevalu_index();" class="btn btn-info btn-default btn-xs">返回</button>
						</span> 
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					
					<!-- 评价开始 -->
					<div  class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table  class="table table-hover" style="font-size: 13px;">
								<thead>
									<tr>	   
										<th>姓名</th>
										<th></th>
										<th>考勤</th>
										<th>平时表现</th>
										<th>项目进度</th>
										<th>心得</th>
										<th>合计</th>
										<th>评价时间</th>
										<%
										if(typeinfo.equals("pinggu")){
										%>
										<th>操作</th>
										<%
										}
										%>
										
									</tr>
								</thead>
						<tbody id="assesstbodyids">
						<%
						if(assess!=null){
							for(int i=0;i<assess.size();i++){
								Assess as = assess.get(i);
						%>
						<tr style="display: none;"><td id="displayac_id"><%=as.getAc_id() %></td></tr>
							<tr >
							    <td><%=as.getUsername() %></td>
								<td class="p13-999"><%=as.getSectionname() %></td>
								<td style="align:center;"><%=as.getKaoqin() %></td>
								<td><%=as.getBiaoxian() %></td>
								<td><%=as.getXiangmu() %></td>
								<td><%=as.getXinde() %></td>
								<td><%=as.getHeji() %></td>
								<td class="p13-999"><%=as.getUpdatetime() %></td>
								<%
								if(typeinfo.equals("pinggu")){
								%>
								<td><p style="color:red;cursor:pointer;" onclick="findassessinfobyidmotai(<%=as.getId() %>);" data-toggle="modal" data-target="#modal184705">评分</p></td>
								<%
								}
								%>
							</tr>
							
							<%
							}
						}
							%>
						</tbody>
					</table>
                 	
                 	
                 	<!-- 评分开始 -->
                 	<div class="modal fade" id="modal184705" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">评分</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;">
								   <div class="form-group">
								      <div class="col-sm-7 control-label" style="font-size:20px;">
								          <span id="usernamepingfen"></span>&nbsp;&nbsp;----<span style="font-size:14px;" id="sectionnamepingfen"></span>
								      </div>
								      <div class="col-sm-2 control-label"></div>
								   </div>	
								   <br /><br />					
								  <form class="form-horizontal" role="form">
								  <span style="display: none;" id="assessgerenid"></span>
								  <div class="form-group">
								      <label class="col-sm-4 control-label">考勤情况（30%）：</label>
								      <div class="col-sm-4">
								        <input type="text" id="d1" onchange="sum();" class="form-control input-sm" placeholder="请输入分数" autocomplete="off" >
								       </div>
								       <div class="col-sm-1"></div>
								  </div>
								  <div class="form-group">
								       <label class="col-sm-4 control-label">平时表现（30%）：</label>
								       <div class="col-sm-4">
								          <input type="text" id="d2" onchange="sum();" class="form-control input-sm" placeholder="请输入分数" autocomplete="off" >
								       </div>
								       <div class="col-sm-1"></div>
								  </div>
								  <div class="form-group">
								       <label class="col-sm-4 control-label">项目进度（30%）：</label>
								       <div class="col-sm-4">
								         <input type="text" id="d3" onchange="sum();" class="form-control input-sm" placeholder="请输入分数" autocomplete="off" >
								       </div>
								       <div class="col-sm-1"></div>
								  </div>
								   <div class="form-group">
								       <label class="col-sm-4 control-label">心得分享（10%）：</label>
								       <div class="col-sm-4">
								         <input type="text" id="d4" onchange="sum();" class="form-control input-sm" placeholder="请输入分数" autocomplete="off" >
								       </div>
								       <div class="col-sm-1"></div>
								  </div>
								  <div class="form-group">
								       <label class="col-sm-4 control-label">合计：</label>
								       <div class="col-sm-4">
								          <input type="text" id="d5" class="form-control input-sm" placeholder="请输入最后得分" onclick="sum()" autocomplete="off"  readonly="true" >
								       </div>
								       <div class="col-sm-1"></div>
								  </div>
								  <script>
								    function sum(){
								      	var a=document.getElementById("d1");
								      	var b=document.getElementById("d2");
								      	var d=document.getElementById("d3");
								      	var c=document.getElementById("d4");
								      	var e=document.getElementById("d5");
								      	e.value=parseInt(a.value)+parseInt(b.value)+parseInt(c.value)+parseInt(d.value);   
								    }
								  </script>
								  <div class="form-group">
									   <label for="firstname" class="col-sm-4 control-label">给予评语：</label>
									   <div class="col-sm-7">
									    <textarea class="form-control" id="remark" rows="3"></textarea>
									   </div>
								  </div>
								</form>
								</div>
								 <div class="modal-footer">
								    <button type="button" data-dismiss="modal" aria-hidden="true" class="btn btn-default">关闭</button>
								    <button type="button" onclick="saveAssessgerengrade();" class="btn btn-primary">提交</button>
								</div>
							</div>
						</div>
					</div>
					</div>
					<!-- 评分开始 -->
                 	
                 
				</div>
				<!-- 全部资源结束 -->
	     </div>
	</div>
</div>
  </body>
</html>
