<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
@SuppressWarnings("unchecked")
List<Announce_section> ass = (List<Announce_section>)request.getAttribute("an_section");
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
	<!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
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
    	  $("#anno111").hide();
    		$("#annoset").show();
         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
         $("a[lang=1]").addClass("pre");//设置选中的
         $("a[lang=1]").css("color","#fff");
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
			
				<!-- 公告栏导航 -->
				<jsp:include page="anno_navigation.jsp"></jsp:include>
				
				 <div id="anno111" 	><jsp:include page="anno_an.jsp"></jsp:include></div> 
		         <span style="display: none;" id="announcement_type">保存并发布</span>
				<!-- 全部公告 -->
				<div id="annoset" >
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						功能设置
						<span class="navbar-right" style="margin-right: 5px;">
						<button type="button" class="btn btn-xs btn-info"   onclick="refreshAsection();">刷新</button>
						<button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#modal-container-184700" >新建栏目</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div style="overflow-x:hidden; height:498px; ">
					  <div style="width: 250px">
						
						<!-- 新建栏目开始 -->
						<div class="modal fade" id="modal-container-184700" role="dialog" aria-labelledby="myModalLabel"  aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">
											新建栏目
										</h4>
									</div>
									<div class="modal-body">
										<form class="form-horizontal" role="form">
											<div class="form-group" style="font-size: 13px;">
									    	   <label for="name" class="col-sm-2 control-label">栏目名称</label>
									    	   <div class="col-sm-6">
							    			      <input type="text" class="form-control"  id="asname" onKeyDown="LimitTextArea64(this)" placeholder="请不要超过64个字...">
							  				   </div>
									  		</div>
										  	<div class="form-group" style="font-size: 13px;">
										    	<label for="name" class="col-sm-2 control-label">栏目描述</label>
										    		  <div class="col-sm-6">
										    		<textarea class="form-control"  id="as_description" title="该文本框最大能输入200字" onKeyDown="LimitTextArea200(this)" placeholder="请输入描述内容..."></textarea>
										 	 </div>
										  	</div>
										</form>
									</div>
									<div class="modal-footer">
										 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
										 <button type="button" class="btn btn-primary"  onclick="newSection()">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 新建栏目结束 -->
						</div>
						<table class="table table-hover" style="font-size: 13px;">
							<thead>
								<tr>
									<th>栏目名称</th>
									<th>更新时间</th>
									<th>公告数量</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="thistbody">
							
							<%
							if(ass!=null  && ass.size() > 0){
								for(int i=0;i<ass.size();i++){
									Announce_section s = ass.get(i);
							%>
								<tr>
									<td><%=s.getAs_name()%></td>
									<td><%=s.getAs_updatetime()%></td>
									<td><%=s.getAs_amount()%></td>
									<td>
									<a id="bianji01" style="text-decoration:none;" href="#modal-container-184701" onclick="changeSectionByid(<%=s.getAs_id() %>)" data-toggle="modal" data-target="#modal-container-184701">
									  <img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/> </a>
									&nbsp;
									<a href="javascript:void(0);"   style="text-decoration:none;" onclick="deleteAsection(<%=s.getAs_id()%>)">
									  <img src="img/del.png" data-toggle="tooltip" data-placement="bottom" title="删除"/></a>
									</td>
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
							%></tbody>
							</table>
							<!-- 公告编辑开始 -->
							<div class="modal fade"  id="modal-container-184701" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">
											编辑栏目
										</h4>
									</div>		
									<div class="modal-body">
									  <form class="form-horizontal" role="form">
										 <div class="form-group" style="font-size: 13px;">
					    					<label for="name" class="col-sm-2 control-label">栏目名称</label> 
					    					<div class="col-sm-5">	
					    					  <input type="text" class="form-control" id="a_name" onKeyDown="LimitTextArea64(this)" placeholder="请不要超过64个字...">
					  				        </div>
					  				     </div>
							  		     <div class="form-group"  style="font-size: 13px;">
							    		    <label for="name" class="col-sm-2 control-label">栏目描述</label>
							    		  	<div class="col-sm-8">			
							    		     <textarea class="form-control" id="a_description" title="该文本框最大能输入200字" onKeyDown="LimitTextArea200(this)" placeholder="请输入描述内容..."></textarea>
							 	            </div>
										 </div>
									   </form>
									</div>
									<div class="modal-footer">
									  <span style="display: none;" id="as_id"></span>
									   
									   <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
									   <button type="button" class="btn btn-primary" onclick="save_Aseditinfo()">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 公告编辑结束 -->							
				</div>	
			</div>
				<!-- 全部公告 -->
			</div>	
		   </div>
	      </div>
  </body>
</html>