<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo mm = (MembershipInfo)session.getAttribute("memberinfo"); 
List<Approval> app=(List<Approval>)request.getAttribute("myapproval");
Page p = (Page)request.getAttribute("pageinfo");
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
    <script src="js/dzjs.js" type="text/javascript"></script>
    <link href="css/wllcss.css" rel="stylesheet">
    
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
	         $("a[lang=7]").addClass("pre");//设置选中的
	         $("a[lang=7]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
	     </script>
    <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
    
    <style>
      td a:hover {text-decoration:none;color:#1C18EC;}
	  ul{margin-top:0px;list-style:none;}
	  .yellow {color:#E5DE14;}
	  .green {color:#52E633;}
	  .red {color:red;}
	</style>
	
  </head>
  
<body style="background-color: #EDEFF0;">

<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
	   <div class="row clearfix">
			
				<jsp:include page="appro_navigation.jsp"></jsp:include>
				
				<!-- 全部审批开始-->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						我的审批
						<span style="float:right;">
					    <button type="button" class="btn btn-info btn-xs" onclick="fanhuia()">&nbsp;返回&nbsp;</button>&nbsp;	
				      </span>   
      				</h4>
					<hr style="margin-top: 10px;height:1px;border:none;border-top:2px dotted;">
					<div class="form-group">
					     <div class="col-sm-2">
					    	<div class="form-group" style="width: 100px;">
							    <select class="form-control input-sm" id="memberrole">
							      <option onclick="javascript:void(0);">全部申请</option>
							     <option onclick="javascript:void(0);">审批中</option>
							      <option onclick="javascript:void(0);">已审批</option>
							      <option onclick="javascript:void(0);">未审批</option>
							    </select>
							 </div>
					    </div>
					    <div class="col-sm-6">
					    	<div class="col-lg-6">
				                <div class="input-group">
				                    <input type="text"  placeholder="请输入关键字" class="form-control input-sm" style="width: 200px;">
				                    <span class="input-group-btn">
				                        <button class="btn btn-default btn-sm" type="button">查找</button>
				                    </span>
				                </div>
				            </div>
					    </div>
					</div>
					<br /><br />
					<div  class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<!-- 审批表开始 -->
						<table  class="table table-hover" style="font-size: 13px;">
								<thead>
									<tr>	   
										<th>审批类型</th>
										<th>申请时间</th>
										<th>申请人</th>
										<th>状态</th>
										<th>审批时间</th>
										<th>审批人</th>
									</tr>
								</thead>
						<tbody >							 
							<%
							if(app!=null&&app.size()>0){
								for(int i=0;i<app.size();i++){
									Approval app1=app.get(i);
								%>
							<tr >
							    <td><a href="javascript:void(0);"  onclick="findmyshenpi(<%=app1.getApproval_id() %>)" data-toggle="modal" data-target="#modal-container-722553"><%=app1.getApproval_type()%></a></td>
								<td class="p13-999"><%=app1.getApply_time() %></td>
									<td class="p13-999"><%=app1.getApply_member() %></td>						
							<%if(app1.getApproval_schedule().equals("未审批")){
									
									%>
									<td style="color:red;"><%=app1.getApproval_schedule()%></td>
									<% }else if(app1.getApproval_schedule().equals("审批中")){								
									%>															
								<td style="color:yellow;"><%=app1.getApproval_schedule()%></td>
								<%
								}else {
								%>
								<td style="color:#52E633;"><%=app1.getApproval_schedule()%></td>
									<%}								
									%>
								<td class="p13-999"><%=app1.getApproval_time() %></td>
								<td><%=app1.getApproval_member() %></td>
							</tr>
							<%
							}}
							%>
						</tbody>
					</table>
					<!-- 审批表结束 -->
                 	
             	<!-- 弹框结束 -->		
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
			        
			           <!-- 弹框开始 -->
					<div class="modal fade" id="modal-container-722553" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
										详细信息
									</h4>
								</div>						  
								<div class="modal-body" style="font-size: 13px;height:328px;" >
									<h4 id="mya_type">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</h4>
									<div style="color:#666666;">
										<div>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">审批人：</p>
												</div>
												<div class="col-md-7 column" id="mya_name">
													<p></p>
												</div>
											</div>
											<div class="col-md-6 column">
												<div class="col-md-4 column">
													<p class="navbar-right" >审批进度：</p>
												</div>
												<div class="col-md-8 column"  id="mya_schedule">
													<p class="yellow"></p>
												</div>
											</div>
										</div>
										<div>
										   <div class="col-md-6 column">
												<div class="col-md-5 column">
													<p class="navbar-right" style="margin-right:5px;">申请人：</p>
												</div>
												<div class="col-md-7 column"	id="mya_aman">
													<p style="margin-left:-20px;"></p>
												</div>
											</div>
											<div class="col-md-6 column" style="margin-left:-47px;">
												<div class="col-md-4 column"	>
													<p class="navbar-right">申请时间：</p>
												</div>
												<div class="col-md-8 column"	 id="mya_time">
													<p></p>
												</div>
											</div>
										</div>	
										<div>
											<div class="col-md-6 column">
												<div class="col-md-4 column">
													<p class="navbar-right">申请部门：</p>
												</div>
												<div class="col-md-8 column" id="mya_section">
													<p></p>
												</div>
											</div>
											<div class="col-md-6 column" style="margin-left:-47px;">
												<div class="col-md-4 column">
													<p class="navbar-right">上传附件：</p>
												</div>
												<div class="col-md-8 column">
													<a href="downloadapply?filename=<%= %>">点击下载</a>
												</div>
											</div>
										</div>	
									
									<div>
										<div class="col-md-12 column" style="margin-left:-5px;">
											<div class="col-md-2 column"	id="mya_info">
												<p class="navbar-right">申请内容：</p>
											</div>
											<div class="col-md-10 column" id="mya_info">
											 									
											</div>
										</div>
									</div>
									<div>
										<div class="col-md-6 column">
										    <br />
											<div class="col-md-4 column">
												<p class="navbar-right">是否通过：</p>
											</div>
											<div class="col-md-8 column"	 id="mydeal">
											   <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 是</input>
											   &nbsp;&nbsp;
											   <input type="radio" name="optionsRadiosinline" id="optionsRadios4" value="option2"> 否</input>
											</div>
											<br />
										</div>
										<div class="col-md-6 column">&nbsp;</div>
									</div>
									<div>
									    <div class="col-md-12 column" style="margin-left:-5px;">
											<div class="col-md-2 column">
											    <p class="navbar-right">说明原因：</p>
											</div>	
											<div class="col-md-10 column">
											    <textarea   id="myshenpi_info" class="form-control p13-999" rows="3" style="width:100%;"></textarea>
											</div>
									    </div>
									</div>
								</div>
								</div>
								<div class="modal-footer">
								<span id="myshen_id" style="display:none"></span>
								  <button type="button" class="btn btn-default" data-dismiss="modal">取消</button> 
								  <button type="button" onclick="shenpi()" class="btn btn-primary">确定</button>
							    </div>
								</div>	
						       </div>   								
							 </div>
							</div>
							<!-- 弹窗结束 -->
			        
			        
				</div>
				
	     </div>
	</div>
</div>
  </body>
</html>
