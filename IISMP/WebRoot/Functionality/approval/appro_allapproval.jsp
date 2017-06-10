<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo mm = (MembershipInfo)session.getAttribute("memberinfo"); 
List<Approval> app=(List<Approval>)session.getAttribute("approval");
Page p = (Page)request.getAttribute("pageinfo");
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
    <link href="css/wllcss.css" rel="stylesheet">
    
    <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
    
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
    <style>
      td a:hover {text-decoration:none;color:#1C18EC;}
	  ul{margin-top:0px;list-style:none;}
	  .yellow {color:#E5DE14;}
	  .green {color:#52E633;}
	  .red {color:red;}
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
			
				<jsp:include page="appro_navigation.jsp"></jsp:include>
				
				<!-- 全部审批开始-->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						全部审批
				      <span style="float:right;">
					    <button type="button" class="btn btn-info btn-xs" onclick="fanhuia()">&nbsp;返回&nbsp;</button>&nbsp;	
				      </span>                                                        
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted;">
										
						<div class="form-group">
					     <div class="col-sm-2">
					    	<div class="form-group" style="width: 100px;">
							    <select class="form-control input-sm"  onclick="findallapproval(1)" id="allapproval">
							      <option onclick="javascript:void(0);">全部审批</option>
							      
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
										<th>状态</th>
										<th>审批时间</th>
										<th>指定审批人</th>
									</tr>
								</thead>
						<tbody id="body2">
							<%
					
							if(app!=null&&app.size()>0){
								for(int i=0;i<app.size();i++){
									Approval app1=app.get(i);
								%>
							<tr >
							    <td><a href="javascript:void(0);"  data-toggle="modal" data-target="#modal-container-722523"><%=app1.getApproval_type()%></a></td>
								<td class="p13-999"><%=app1.getApply_time() %></td>
															
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
				</div>
				</div>
	     </div>
	</div>
</div>
  </body>
</html>
