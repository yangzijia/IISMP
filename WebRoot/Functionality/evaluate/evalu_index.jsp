<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<AssessChart> acc = (List<AssessChart>)request.getAttribute("acinfo");
Page p = (Page)request.getAttribute("pinfo");
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
  	<!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <link rel="Shortcut icon" href="img/favicon.ico">   
  
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    
     <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
	
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
			
				<jsp:include page="evalu_navigation.jsp"></jsp:include>
				
				<!-- 全部资源 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>评估表</span>
						<span class="navbar-right" style="margin-right: 5px;">
						    <button type="button" onclick="flushassesschart();" class="btn btn-info btn-default btn-xs"> 刷&nbsp;新 </button>
						    <%
							if(memberinfo.getRole_num()==1||memberinfo.getRole_num()==2){
							%>
						    <button type="button" onclick="clearthismodelinfo();" class="btn btn-info btn-default btn-xs" data-toggle="modal" data-target="#modal-container-184701">新建考评表</button>
							<%
							}else{
							%>
							<button type="button"  disabled="disabled" class="btn btn-info btn-default btn-xs">新建考评表</button>
							<%
							}
							%>
						</span>    
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					
					<!-- 评价开始 -->
					<div  class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table  class="table table-hover" style="font-size: 13px;">
								<thead>
									<tr>	   
										<th>考评表名称</th>
										<th></th>
										<th>考评区间</th>
										<th>操作人</th>
										<th>更新日期</th>
										<th>操作</th>
									</tr>
								</thead>
						<tbody id="evalutbody">
						<%
						if(acc!= null && acc.size()>0){
							for(int i=0;i<acc.size();i++){
								AssessChart ac = acc.get(i);								
						%>
							<tr >
							    <td><%=ac.getAssessname() %></td>
								<td>
								<%
								if(memberinfo.getRole_num()==1||memberinfo.getRole_num()==2){
								%>
									<a href="openassessinfopage?id=<%=ac.getId() %>" style="text-decoration: none;">考评</a>&nbsp;&nbsp;
								<%
								}
								%>
									<a href="findfinalassessgrade?ac_id=<%=ac.getId() %>" style="text-decoration: none;">查看结果</a>
								</td>
								<td class="p13-999"><%=ac.getAs_starttime() %>~<%=ac.getAs_endtime() %></td>
								<td style="align:center;" class="p13-999"><%=ac.getOperatorname() %></td>
								<td class="p13-999"><%=ac.getUpdatetime() %></td>
								<td>
								<%
								if(memberinfo.getRole_num()==1||memberinfo.getRole_num()==2){
								%>
									<a href="javascript:void(0);" onclick="deletethisassess(<%=ac.getId() %>)" style="text-decoration: none;">
									  <img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/>
									</a>
								<%
								}else{
								%>
									<a href="javascript:void(0);" class="p13-999" style="text-decoration: none;">删除</a>
								<%
								}
								%>	
								</td>
							</tr>
							<%
							}
						}else{
							%>
							<tr >
							    <td>无信息...</td>
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
                 	
                    <div align="center">
					<table align="center"  style="font-size: 13px;">
					    <tr id="evalu_trid">
							<th>第<span id="pageNows"><%=p.getPageNow() %></span>/<%=p.getpageCount(p.getTotalItemNumber()) %>页&nbsp;&nbsp;</th>
							<th>
								<ul class="pagination">
								<%
								if(p.getPageNow()!=1&&p.getPageNow()!=0){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushassesschartinfo(1);">首页</a>
									</li>
									<%
								}
								if(p.isHasPrev()){
									%>
									<li>
										 <a href="javascript:void(0);" onclick="flushassesschartinfo(<%=p.getPrevPage() %>);">上页</a>
									</li>
									<%
								}
								if(p.isHasNext()){
									%>
									<li>
										 <a href="javascript:void(0);" onclick="flushassesschartinfo(<%=p.getNextPage() %>);">下页</a>
									</li>
									<%
								}
								if(p.getPageNow()!=p.getpageCount(p.getTotalItemNumber())){
									%>
									<li>
										 <a href="javascript:void(0);" onclick="flushassesschartinfo(<%=p.getpageCount(p.getTotalItemNumber()) %>);">尾页</a>
									</li>
									<%
								}
									%>
								</ul>
							</th>
							<%
							if(p.getpageCount(p.getTotalItemNumber())>2){
							%>
							<th>&nbsp;&nbsp;</th>
							<th>
								<div class="col-lg-6">
					                <div class="input-group">
					                    <input type="text" class="form-control" style="height: 30px;width: 45">
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
                 	
                 	
                 	<!-- 创建评估表 -->
						<div class="modal fade" id="modal-container-184701" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">
											创建考评表
										</h4>
									</div>
									<div class="modal-body"><br>
										<form class="form-inline" role="form">
										  <div class="form-group">
										    <label class=" control-label">考评表名：</label>
										   <!--  <div class="col-sm-6"> -->
										      <input type="text" class="form-control input-sm" style="width: 280px;" id="add_assessname" placeholder="请输入考评表名">
										    <!-- </div> -->
										  </div><br><br>
										
										<div>
										  <div class="form-group">
										  	<label  class=" control-label">考评区间：</label>
										    <input type="text" class="form-control input-sm" id="add_time1" placeholder="****-**-**">
										    <script type="text/javascript">
											    var picker = new Pikaday(
											    {
											        field: document.getElementById('add_time1'),
											        firstDay: 1,
											        minDate: new Date('2010-01-01'),
											        maxDate: new Date('2020-12-31'),
											        yearRange: [2000,2020]
											    });
											</script>
											~
											<input type="text" class="form-control input-sm" onchange="checktime1and2();" id="add_time2" placeholder="****-**-**">
										    <script type="text/javascript">
											    var picker = new Pikaday(
											    {
											        field: document.getElementById('add_time2'),
											        firstDay: 1,
											        minDate: new Date('2010-01-01'),
											        maxDate: new Date('2020-12-31'),
											        yearRange: [2000,2020]
											    });
											</script>
										  </div>
										  </div>
										  </form><br>
										  
									</div>
									<div class="modal-footer">
										 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										 <button type="button" onclick="saveassesschartinfo();" class="btn btn-primary">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 创建评估表-->
                 
				</div>
				<!-- 全部资源结束 -->
	     </div>
	</div>
</div>
  </body>
</html>
