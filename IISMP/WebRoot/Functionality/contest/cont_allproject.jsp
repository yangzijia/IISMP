<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
Page p = (Page)request.getAttribute("pageinfo");
List<Project> project=(List<Project>)request.getAttribute("project");
List<Section> section=(List<Section>)session.getAttribute("section");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <base href="<%=basePath%>">

    <title>创新实验室自学管理平台</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap_3.3.4.js" type="text/javascript"></script>
	<link href="css/bootstrap_3.3.4.css" rel="stylesheet">
	<link href="css/mycss.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet">
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
     <link rel="Shortcut icon" href="img/favicon.ico">   
    
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/dzjs.js" type="text/javascript"></script>
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
	         $("a[lang=6]").addClass("pre");//设置选中的
	         $("a[lang=6]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
	     </script>
    <style>
      .title {color: #666666;text-decoration: none;}
       a:hover {color:#1D7089;text-decoration: none;}
       .col {margin-top:6px;}
    </style>
    
  </head>  
<body style="background-color: #EDEFF0">

<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
			<div class="row clearfix">
			
				<!-- 左边栏导航 -->
				<jsp:include page="cont_navigation.jsp"></jsp:include>
						
				<div class="col-md-9 column" style="-webkit-box-shadow:inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color:#FFFFFF;">
					<!-- 全部文件开始 -->
					<h4 style="margin-top:10px;">
					       参赛项目
					  <span style="float:right;">
					     <button type="button" class="btn btn-info btn-xs" onclick="location.href='Functionality/contest/cont_index.jsp'">返回</button>
					     <button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal-container-184707">添加项目</button>
					  </span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px;">
				      
					  <table  class="table table-hover" style="font-size: 13px;">
						 <thead>
							<tr>
							    <th>项目名</th>	   			
								<th>添加者</th>
								<th>组名</th>
								<th>项目资源</th>
								<th>更新时间</th>
								<th>操作</th>
							</tr>
						 </thead>
						 <tbody id="probody">
						 <%
						 if(project!=null&&project.size()>0){
							 for(int i=0;i<project.size();i++){
								Project pr=project.get(i);
						 
						 %>
							<tr>
								<td><a href="javascript:void(0);"  onclick="findpByid(<%=pr.getProject_id()%>)"data-toggle="modal" data-target="#modal-container-72251" ><%=pr.getProject_name() %></td>
								<td class="p13-999"><%=pr.getProject_principal() %></td>
								<td><%=pr.getSection_name() %></td>	
								<td><a href="javascript:void(0)"  style="text-decoration:none;" >下载</a></td>
								<!-- downloadpro?filename=<%=pr.getProject_file()%> -->
								<td class="p13-999"><%=pr.getProject_uptime() %></td>
								<td><a href="javascript:void(0);"  onclick="findpro(<%=pr.getProject_id()%>)" data-toggle="modal" data-target="#modal-container-723"  style="text-decoration:none;">
								    <img src="img/edit.png"  data-toggle="tooltip"  data-placement="bottom" title="编辑"/></a>
								<a href="javascript:void(0);" onclick="deleteProject(<%=pr.getProject_id() %>)">
                             <img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a>    
								
								</td>	
								    
								    
							</tr>
							<%-- <span style="display:none;" id="proid"><%=pr.getProject_id()%></span> --%>
							<%
							}
						 }else{
							%>
								<tr>
									<td></td>
									<td>无信息...</td>
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
                      <!-- 全部文件结束 -->
						
						<!-- 尾页开始 -->
						<div align="center">
						 
							<table align="center"  style="font-size: 13px;" id="qwert">
								<tr >
									<th>第<span id="m_pagenow"><%=p.getPageNow() %></span>/<span id="m_pagecount"><%=p.getpageCount(p.getTotalItemNumber()) %></span>页&nbsp;&nbsp;</th>
									<th>
										<ul class="pagination">
										<%
										if(p.getPageNow()!=1){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyeanno(1);">首页</a>
											</li>
										<%
										}
										if(p.isHasPrev()){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyeanno(<%=p.getPrevPage() %>);">上页</a>
											</li>
										<%
										}
										if(p.isHasNext()){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyeanno(<%=p.getNextPage() %>);">下页</a>
											</li>
										<%
										}
										if(p.getPageNow()!=p.getpageCount(p.getTotalItemNumber())){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyeanno(<%=p.getpageCount(p.getTotalItemNumber()) %>);">尾页</a>
											</li>
										<%
										}
										%>
										</ul>
									</th>
									<%
									if(p.getpageCount(p.getTotalItemNumber())!=1){
									%>
									<th>&nbsp;&nbsp;</th>
									<th>
										<div class="col-lg-6">
							                <div class="input-group">
							                    <input type="text" class="form-control input-sm" maxlength="2" style="width: 45">
							                    <span class="input-group-btn">
							                        <button class="btn btn-default btn-sm" type="button">跳转</button>
							                    </span>
							                </div>
							            </div>
									</th>
									<%
									}
									%>
								</tr>
							</table>
						</div>
						<!-- 尾页结束 -->
						
						<!-- 增添项目弹框开始 -->
		               	<div class="modal fade"  id="modal-container-184707" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width:500px;">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										添加项目
									</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;">				
								  <form class="form-horizontal" role="form">
								  <div class="form-group">
								      <label class="col-sm-3 control-label">项目名称：</label>
								      <div class="col-sm-5">
								        <input type="text" class="form-control input-sm" placeholder="请输入项目名称"  id="project_name">
								       </div>
								       <div class="col-sm-1"></div>
								  </div>
								  <div class="form-group">
								       <label class="col-sm-3 control-label">项目组：</label>
								       <div class="col-sm-6">
								         <select class="form-control input-sm" id="project_section" style="width:81.55%;">
									     	<%
											if(section!=null  && section.size()> 0){
												for(int i=0;i<section.size();i++){
													Section ss = section.get(i);
												
											%>
								  	
								    	     <option onclick="javascript:void(0);"  value="<%=ss.getSection_name()%>"><%=ss.getSection_name()%></option>
											 <%
										    	  }
										      }
											%>
									       </select>
									   </div>			
								       <div class="col-sm-1"></div>
								  </div>
								  <div class="form-group">
									   <label for="firstname" class="col-sm-3 control-label">项目介绍：</label>
									   <div class="col-sm-8">
									    <textarea class="form-control" id="project_info" rows="3"></textarea>
									   </div>
								  </div>
								</form>
								</div>
								 <div class="modal-footer">
								    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								    <button type="button" class="btn btn-primary"  onclick="addProject()">保存</button>
								</div>
						      </div>	
				          </div>
			           </div> 
			           <!-- 添加项目结束 -->
			           
			           <!-- 项目详情开始  -->
						<div class="modal fade" id="modal-container-72251" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
						   <div class="modal-content">
							 <div class="modal-header">
							   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							    <h4 class="modal-title" id="myModalLabel">
									详细信息
								</h4>
							 </div>
							 <div class="modal-body" style="font-size: 13px;">
								<form class="form-horizontal" role="form">
								  <div class="form-group" >
								      <h2 class="col-sm-3 control-label" id="Pname">
								                                       
								      </h2>
								      <div class="col-sm-8" style="font-size:16px;margin-left:-26px;margin-top:39px;" id="Sname"><br /><br />----</div>
								  </div>
								  <br />
								 
								  <div class="form-group">
								       <label class="col-sm-3 control-label">项目介绍：</label>
								       <div class="col-sm-8 col" id="Pinfo">
								                       
								       </div> 
								  </div> 								  
								  <div class="form-group">
								       <label class="col-sm-3 control-label">参加比赛&nbsp;&nbsp;<p>及成绩：</p></label>
								       <div class="col-sm-8 col"	id="Pawards">
								         
								       </div>
								  </div>
								  <div class="form-group">
									   <label for="firstname" class="col-sm-3 control-label"  >经验心得：</label>
									   <div class="col-sm-8 col" id="Pexperience">
								
									   </div>
								  </div>
								</form>
								<br />
								<br />
							</div>
					   	  </div>
						 </div>	
						</div>				
						<!-- 项目详情结束  -->
			            
			            <!-- 项目介绍弹框开始 -->
			            <div class="modal fade"  id="modal-container-721" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width:500px;">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										
									</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;" id="Pinfo">				
								          
								</div>
								<br />
							</div>
						   </div>
						  </div>
						</div>
						<!-- 项目介绍弹框结束 -->
			            
			            <!-- 编辑弹框 开始-->
			            <div class="modal fade"  id="modal-container-723" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width:500px;">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										编辑
									</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;">				
								    
								    <form class="form-horizontal" role="form">
									  <div class="form-group">
									     <label for="firstname" class="col-sm-3 control-label">项目名：</label>
									     <div class="col-sm-8">
									       <input type="text" class="form-control input-sm" id="proname" style="width:49%;">
									     </div>
									  </div>
									  <div class="form-group">
									     <label for="firstname" class="col-sm-3 control-label">项目组：</label>
									     <div class="col-sm-7">
									       <select class="form-control input-sm" id="prosection" style="width:56.8%;">
									     	<%
											if(section!=null  && section.size()> 0){
												for(int i=0;i<section.size();i++){
													Section ss = section.get(i);
												
											%>
										  	
								    	      <option onclick="javascript:void(0);"  value="<%=ss.getSection_name()%>"><%=ss.getSection_name()%></option>
											 <%
										    	  }
										      }
											%>
										   </select>		
									    </div>
									  </div>
									  <div class="form-group">
									     <label for="firstname" class="col-sm-3 control-label">项目介绍：</label>
									     <div class="col-sm-8">
									       <textarea class="form-control p13-999" rows="3" id="proinfo"></textarea>
									     </div>
									  </div>  
									</form>
									<!-- 增添比赛结束 -->
									
							         <!-- 上传文件开始 -->							
									 <!-- <div class="form-horizontal" role="form">
									     <div class="form-group">
										   <label for="firstname" class="col-sm-2 control-label">上传文件：</label>
										   <div class="col-sm-9" id="checkbox">
											   <label class="checkbox-inline">
												 <input type="radio" name="optionsRadiosinline" id="optionsRadios3" onclick="show()" value="option1"> 是
											   </label>
											   <label class="checkbox-inline">
												 <input type="radio" name="optionsRadiosinline" id="optionsRadios4" value="option2" checked> 否
											   </label>
										   </div>
										  <div class="col-sm-9" id="upload">
										   <form enctype="multipart/form-data">
											  <div class="form-group" style="margin-left:0;"> 
									           <span style="float:left;">
									             <input id="file-0a" class="file"  data-min-file-count="1" type="file"> 
									           </span>
											   <span style="float:left;margin-top:3px;">
											     &nbsp;&nbsp;&nbsp;&nbsp;
									            <button type="reset" class="btn btn-info btn-xs" style="background-color:#F1F1F1;color:#7D7D7D;border-color:#CCC;">重置</button>
				                         	   </span>			     
			  							      </div>
										   </form> 
										  </div>  -->
								      </div>
								      <div class="modal-footer">
								      
									    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									    <button type="button" class="btn btn-primary" onclick="savepro()">保存</button>
									  </div>
							    </div>
						      </div>
						    </div>
						</div>
			            <!-- 编辑弹框 结束-->
			            
					</div>	
				</div>
				
			</div>
		</div>

  </body>
</html>
