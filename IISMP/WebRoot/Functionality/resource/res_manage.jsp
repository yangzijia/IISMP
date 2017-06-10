<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
Page p = (Page)request.getAttribute("pageinfo");
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
List<Resource_Type> rt=(List<Resource_Type>)request.getAttribute("rttype");
List<ResourceInfo> reinfo=(List<ResourceInfo>)session.getAttribute("reinfo");
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
	         $("a[lang=3]").addClass("pre");//设置选中的
	         $("a[lang=3]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }) 
	     </script>
    
    
	<style>
	  ul{margin-top:0px;list-style:none;}
	</style>    
    
  </head>
  
<body style="background-color: #EDEFF0;overflow:hidden;">

 
<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
		<div class="row clearfix">
			<jsp:include page="res_navigation.jsp"></jsp:include>	
				<!-- 功能设置开始  -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
					<span>资源库管理</span>
						<span class="navbar-right" style="margin-right: 5px;">
							<button type="button" class="btn btn-xs btn-info"  data-toggle="modal" data-target="#modal-container-184709">新建资源库</button>
							<button type="button" class="btn btn-xs btn-info" onclick="shuaxintype();">刷新</button>
							<!-- 新建资源库开始 -->
							<div class="modal fade" id="modal-container-184709" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												新建资源名
											</h4>
										</div>
										<div class="modal-body" style="font-size: 13px;">							
										    <form class="form-horizontal" role="form">
										    	<div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">资源库名：</label>
												   <div class="col-sm-9">
												      <input type="text" class="form-control input-sm" id="typename" placeholder="请输入组名">
												   </div>
												 </div>
												 <div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">说明：</label>
												   <div class="col-sm-9">
												    <textarea class="form-control" rows="3" id="typeinfo"></textarea>
												   </div>
												 </div>
									         </form>								
										 </div>
										 <div class="modal-footer">
											 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
											  <button type="button" class="btn btn-primary" onclick="addRtype()">保存</button>
										</div>
									</div>
								</div>
							</div>
						<!-- 新建资源库结束 -->
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div style="overflow-x:hidden; height:498px; ">
							
						<table class="table table-hover" style="font-size: 13px;">
							<thead>
								<tr>
									<th>资源库名称</th>
									<th>上传人</th>
									<th>更新时间</th>
									<th>资源数量</th>
									<th> &nbsp;操作</th>
								</tr>
							</thead>
							<tbody id="rtbody">
							<% 
						    if(rt != null && rt.size() >0){	
					            for(int i = 0;i<rt.size();i++){
					            	Resource_Type rest = rt.get(i);
								%>
								<tr>
									<td><a href="javascript:void(0)" <%-- onclick="findrt(<%=rest.getRt_id()%>);" data-toggle="modal" data-target="#modal-container-184710"  --%>style="text-decoration:none;"><%=rest.getRt_name()%></a></td>	
									<td class="p13-999"><%=rest.getRt_issuer() %></td>
									<td class="p13-999"><%=rest.getRt_updatime() %></td>
									<td class="p13-999"><%=rest.getRe_amount() %></td>
									<td>
										<a  href="javascript:void(0);" onclick="findrt(<%=rest.getRt_id()%>);" data-toggle="modal" data-target="#modal-container-184111"  style="text-decoration: none;">
							     		<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>
										<a style="text-decoration: none;"  href="javascript:void(0);" onclick="deleteRTbyid(<%=rest.getRt_id() %>)"  class="btn btn-xs">
										<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a>
									</td>
								</tr>
								
								<%
					  
								}
								}%>
						
								
							</tbody>
						</table>
						<!-- 编辑资源库开始 -->
							<div class="modal fade" id="modal-container-184111" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												编辑资源库
											</h4>
										</div>
										<div class="modal-body" style="font-size: 13px;">							
										    <form class="form-horizontal" role="form">
										    	<span id="typeid1" style="display: none;"></span>
										    	<div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">资源库名：</label>
												   <div class="col-sm-9">
												      <input type="text" class="form-control input-sm" id="typename1" placeholder="请输入组名">
												   </div>
												 </div>
												 <div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">说明：</label>
												   <div class="col-sm-9">
												    <textarea class="form-control" rows="3" id="typeinfo1"></textarea>
												   </div>
												 </div>
									         </form>								
										 </div>
										 <div class="modal-footer">
											 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
											  <button type="button" class="btn btn-primary" onclick="updateRestype()">保存</button>
										</div>
									</div>
								</div>
							</div>
						<!-- 编辑资源库结束 -->
						
			<%-- 		<div align="center">
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
						</div> --%>
				    </div>
				    <!-- 功能设置结束  -->
				
				
				</div>
			</div>
		</div>
</div>
  </body>
</html>
