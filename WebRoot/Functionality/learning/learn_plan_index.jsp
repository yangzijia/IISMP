<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<Learning_plan> lpinfo = (List<Learning_plan>)request.getAttribute("lpinfo");
Page p = (Page)request.getAttribute("pinfo");
long lpnums = Integer.parseInt(request.getAttribute("lpnums").toString());
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
    <script src="js/index.js" type="text/javascript"></script>
    
    <!-- 页面加载动画 -->
	<link href="css/jiazaidonghuacss/myspinner.css"  rel="stylesheet">
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
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
	         $("a[lang=2]").addClass("pre");//设置选中的
	         $("a[lang=2]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }) 
	     </script>
    <style>
       td a:hover {text-decoration:none;color:#1C18EC;}
	    .ys{color:#52E633;}
	    .ys0{color:#E5DE14;}
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
		
			<!-- 计划栏导航 -->
			<jsp:include page="learn_plan_navigation.jsp"></jsp:include>
					
			<!-- 全部计划 -->
			<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
				<h4 style="margin-top:10px;">
					<span>我的计划</span>
					<span class="navbar-right" style="margin-right: 5px;">
					</span>							 
				</h4>
				<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
				<div style="overflow-x:hidden; height:498px; ">
				  
				  <!-- 计划时间开始 -->
				  <form class="form-inline" role="form">
					  <div class="form-group">
					  	<label  for="name">按计划时间查询：</label>
					    <input type="text" onchange="findthistimelearnplaninfo();" class="form-control input-sm" id="time1" placeholder="****-**-**">
					    ~
					    <input type="text" onchange="findthistimelearnplaninfo();" class="form-control input-sm" id="datepicker0" placeholder="****-**-**">
					    <script type="text/javascript">
						    var picker = new Pikaday(
						    {
						        field: document.getElementById('time1'),
						        firstDay: 1,
						        minDate: new Date('2010-01-01'),
						        maxDate: new Date('2020-12-31'),
						        yearRange: [2000,2020]
						    });
						    var picker = new Pikaday(
						    {
						        field: document.getElementById('datepicker0'),
						        firstDay: 1,
						        minDate: new Date('2010-01-01'),
						        maxDate: new Date('2020-12-31'),
						        yearRange: [2000,2020]
						    });
						    
						</script>
					  </div>
					  
					</form>
					<!-- 计划时间结束 -->
					
					<table class="table table-hover" style="font-size: 13px;">
						<thead>
							<tr>
								<th>计划标题</th>
								<th>计划时间</th>
								<th>时长</th>
								<th>更新时间</th>
								<th style="width: 100px;">操作</th>
							</tr>
						</thead>
						<tbody id="learnplantbodyid">
						<%
						if(lpinfo != null && lpinfo.size()>0){
							for(int i=0;i<lpinfo.size();i++){
								Learning_plan l = lpinfo.get(i);
						%>
							<tr>
								<td><a href="javascript:void(0);" data-toggle="modal" onclick="findthisplaninfo(<%=l.getId() %>);" data-target="#modal-container-722522"><%=l.getLtitle() %></a></td>
								<td class="p13-999"><%=l.getLstarttime() %>~<%=l.getLendtime() %></td>
								<td class="p13-999"><%=l.getLdaylong() %>天</td>
								<td class="p13-999"><%=l.getUpdatetime() %></td>
								<td style="cursor:pointer;">
								
								  <a type="button" onclick="findthisplaninfoandshow(<%=l.getId() %>);" data-toggle="modal" data-target="#modal-container-722544" href="javascript:void(0);" style="text-decoration: none;">
								     <!-- <img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/> -->
								     	编辑
								     </a>
								      &nbsp;
								  <a href="javascript:void(0);"  onclick="deletethisplanbyid(<%=l.getId() %>);" style="text-decoration: none;">
								     <!-- <img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/> -->
								     删除
								     </a>
								</td>
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
							</tr>
						<%
						}
						%>
						</tbody>
					</table>
					
					<!-- 分页 -->
					<div align="center">
					<table align="center"  style="font-size: 13px;">
					    <tr id="learnplantrfenyeid">
							<th>第<span id="pageNows"><%=p.getPageNow() %></span>/<%=p.getpageCount(lpnums) %>页&nbsp;&nbsp;</th>
							<th>
								<ul class="pagination">
								<%
								if(p.getPageNow()!=1){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushlearnplaninfo('1');">首页</a>
									</li>
								<%
								}
								if(p.isHasPrev()){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushlearnplaninfo('<%=p.getPrevPage() %>');">上页</a>
									</li>
								<%
								}
								if(p.isHasNext()){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushlearnplaninfo('<%=p.getNextPage() %>');">下页</a>
									</li>
								<%
								}
								if(p.getPageNow()!=p.getpageCount(lpnums)){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushlearnplaninfo('<%=p.getpageCount(lpnums)%>');">尾页</a>
									</li>
								<%
								}
								%>
								</ul>
							</th>
							<%
							if(p.getPageNow()!=1&&p.getPageNow()!=0){
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
							<%} %>
						</tr>
					</table>
			        </div>
					<!-- 分页结束 -->
					
					<!-- 详细内容弹框开始 -->
					<div class="modal fade" id="modal-container-722522" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
										详细信息
									</h4>
								</div>						  
								<div class="modal-body" style="font-size: 13px;height:468px;">
									<h4>
										<span id="x_title"></span>
									</h4>
									<div style="color:#666666;">
										<div>
										<br>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">计划时间：</p>
												</div>
												<div class="col-md-7 column">
													<p  class="p13-999"><span id="x_starttime"></span>~<span id="x_lendtime" ></span></p>
												</div>
											</div>
											<div class="col-md-5 column">
												<div class="col-md-6 column">
													<p class="navbar-right">时长：</p>
												</div>
												<div class="col-md-6 column">
													<p style="color:#999" id="x_ldaylong"></p>
												</div>
											</div>
											<div class="col-md-1 column"></div>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">更新时间：</p>
												</div>
												<div class="col-md-7 column">
													<p class="yellow" style="color:#999" id="x_updatetime"></p>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-12 column" style="border-top:1px solid #ccc">
										<br/>
										<div style="height: 200px;">
											<span>计划内容：</span><br><br>
											<div class="col-md-12 column">
											<p  id="x_content"></p>
											</div>
										</div>
										<div style="height: 50px;">
											<span>计划总结：</span><br><br>
											<div class="col-md-12 column">
											<p id="x_summarize"></p>
											</div>
										</div>
									</div>
								</div>	
							       </div>   								
								 </div>
							</div>
							<!-- 弹窗结束 -->
							
						    <!-- 编辑弹框开始 -->
					      	<div class="modal fade" id="modal-container-722544" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											 <h4 class="modal-title" id="myModalLabel">
												编辑计划
											 </h4>
										</div>
										<div class="modal-body" style="font-size: 13px;">
											<div class="form-horizontal" role="form">
											<span style="display: none" id="planid"></span>
											  <div class="form-group">
											  	<label  for="name" class="col-sm-2 control-label">计划时间：</label>
											    <div class="col-sm-9 form-inline">
											    <input type="text" class="form-control input-sm" id="time11" placeholder="****-**-**">
											    ~
											    <input type="text" class="form-control input-sm" id="time22" placeholder="****-**-**">
											    </div>
											    <script type="text/javascript">
												    var picker = new Pikaday(
												    {
												        field: document.getElementById('time11'),
												        firstDay: 1,
												        minDate: new Date('2010-01-01'),
												        maxDate: new Date('2020-12-31'),
												        yearRange: [2000,2020]
												    });
												    var picker = new Pikaday(
												    {
												        field: document.getElementById('time22'),
												        firstDay: 1,
												        minDate: new Date('2010-01-01'),
												        maxDate: new Date('2020-12-31'),
												        yearRange: [2000,2020]
												    }); 
												</script>
											  </div>  
											<!-- 计划时间结束 -->
											
											<!-- 计划标题、内容、总结开始 -->						
										    	<div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">计划标题：</label>
												   <div class="col-sm-9">
												      <input type="text" class="form-control input-sm" id="e_title" placeholder="请填写计划标题..." style="width:49%;">
												   </div>
												 </div>
												 <div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">计划内容：</label>
												   <div class="col-sm-9">
												    <textarea class="form-control" rows="3" placeholder="请填写计划内容..." id="e_content"></textarea>
												   </div>
												 </div>
												 <div class="form-group">
												   <label for="firstname" class="col-sm-2 control-label">计划总结：</label>
												   <div class="col-sm-9">
												    <textarea class="form-control" rows="3" placeholder="请填写计划总结..." id="e_summarize"></textarea>
												   </div>
												 </div>
									         </div>	
										</div>
										<div class="modal-footer">
											 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button> 
											 <button type="button" onclick="updatelearnplan();" class="btn btn-primary btn-sm">保存</button>
										</div>
									</div>
								</div>
							</div>
		      				<!-- 弹框结束 -->	
				</div>	
			</div>
			<!-- 全部计划结束 -->
		</div>
	</div>
</div>
  </body>
</html>
