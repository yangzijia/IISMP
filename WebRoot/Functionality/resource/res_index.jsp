<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
List<ResourceInfo> reinfo=(List<ResourceInfo>)request.getAttribute("reinfo");
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
Page p = (Page)request.getAttribute("pageinfo");
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
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
    
     <link rel="Shortcut icon" href="img/favicon.ico">   
    
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/dzjs.js" type="text/javascript"></script>
     
    <!--导航选中效果 -->
    <script type="text/javascript">
      $(function(){
         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
         $("a[lang=3]").addClass("pre");//设置选中的
         $("a[lang=3]").css("color","#fff");
         $(".pre").hover(function () {
	        $(this).css({"background-color":"#080808"});
	      }  
	     );
      });
    </script>
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
				
				<!-- 全部资源 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span id="rttype">全部资源</span>
						<span id="rtid" style="display: none">0</span> 
						<!-- <span style="float:right;">		
						 	<button type="button"   onclick="fun()" class="btn btn-info btn-xs"  data-toggle="modal" data-target="#modal-container-184700">&nbsp;上传&nbsp;</button>
						</span>  -->	
					</h4>
					<!-- 上传资源开始 -->
					<div class="modal fade" id="modal-container-184700" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close"  data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
										上传资料
									</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;">							
								    <form	name="dataForm"   role="form"  method="post" action="" enctype="multipart/form-data" class="form-horizontal">
								        <div class="form-group">
								          <label for="firstname" class="col-sm-2 control-label">文件输入：</label>
						                  <div class="col-sm-9">
						                    <input type="file" name="myFile" id="uploadfile" onchange="fileChange(this);"  data-min-file-count="1" >
						                    <div style="width:100%;"></div>
							              </div> 
							            </div>
							             <div class="form-group" >
										    <label for="name" class="col-sm-2 control-label">文件说明：</label>
										    <div class="col-sm-9">
										      <textarea name="resource_remark" class="form-control" rows="3"></textarea>
										    </div>
										 </div>
										   <div class="form-group" style="display:none">
										     <input name="rt_id"   id="rttid"	value="" >
										 </div>
										  <button type="submit" onclick="Checkfiles();" class="btn btn-primary btn-sm">保存</button>
						                  <button type="reset" class="btn btn-default">重置</button>
							         </form>    								
								 </div>
							</div>
						</div>
					</div>
				 	
					
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table class="table table-hover" style="font-size: 13px;">
						<thead>
							<tr>	   
								<th>名称</th>
								<th>上传人</th>
								<th>更新时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="res_infosbody">
						<%
						if(reinfo!=null&&reinfo.size()>0){
							for(int i=0;i<reinfo.size();i++){
							ResourceInfo res=reinfo.get(i);
						%>
							<tr>
								<td>
									<span>
										<%=res.getResource_name()%>
									</span>	
								</td>
								<td class="p13-999"><%=res.getResource_issuer() %></td>
								<td class="p13-999"><%=res.getResource_time() %></td>
								<td>
									<a style="text-decoration: none;"  href="downloadFile2?filename=<%=res.getResource_name() %>" role="button" class="btn btn-xs" >
										<img src="img/down.png"  data-toggle="tooltip" data-placement="bottom" title="下载"/>
									</a>
									<a style="text-decoration: none;"  href="javascript:void(0);"  onclick="deleteRebyid(<%=res.getResource_id() %>)"  class="btn btn-xs">
										<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/>
									</a>
								</td>
							</tr>
							<%
							}
							}else{
								%>
								<tr>
									<td>暂无信息...</td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								
							<%
							}
						%>
						</tbody>	
					</table>
						<div align="center">
						 
							<table align="center"  style="font-size: 13px;" id="relist">
								<tr >
									<th>第<span id="m_pagenow"><%=p.getPageNow() %></span>/<span id="m_pagecount"><%=p.getpageCount(p.getTotalItemNumber()) %></span>页&nbsp;&nbsp;</th>
									<th>
										<ul class="pagination">
										<%
										if(p.getPageNow()<1){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyere(1);">首页</a>
											</li>
										<%
										}
										if(p.isHasPrev()){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyere(<%=p.getPrevPage() %>);">上页</a>
											</li>
								<%
										}
								if(p.isHasNext()){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyere(<%=p.getNextPage() %>);">下页</a>
											</li>
									<%
										}
									if(p.getPageNow()!=p.getpageCount(p.getTotalItemNumber())){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="fanyere(<%=p.getpageCount(p.getTotalItemNumber()) %>);">尾页</a>
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
							                    <input type="text" class="form-control input-sm" id="yeshu" maxlength="2" style="width: 45">
							                    <span class="input-group-btn">
							                        <button class="btn btn-default btn-sm" onclick="fanyere($('#yeshu').val())" type="button">跳转</button>
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
				<!-- 全部资源结束 -->
	     </div>
	</div>
</div>
  </body>
</html>