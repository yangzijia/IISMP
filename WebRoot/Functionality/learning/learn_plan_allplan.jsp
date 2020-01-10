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
List<Section> section = (List<Section>)request.getAttribute("sectioninfo");
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
    <script src="js/index.js" type="text/javascript"></script>
    
    <!-- 页面加载动画 -->
	<link href="css/jiazaidonghuacss/myspinner.css"  rel="stylesheet">
    
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
					<span>查看计划</span>
					<span class="navbar-right" style="margin-right: 5px;">
					</span>							 
				</h4>
				
				<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
				  
				<div style="overflow-x:hidden; height:498px; ">
				
				<!-- 计划时间开始 -->
				  <div class="form-inline" role="form">
				  	<div class="col-md-7 column">
					  <div class="form-group">
					  	<label  for="name">按计划时间查询：</label>
					    <input type="text" onchange="findalllearnplaninfo();" class="form-control input-sm" id="time1" placeholder="****-**-**">
					    ~
					    <input type="text" onchange="findalllearnplaninfo();" class="form-control input-sm" id="time2" placeholder="****-**-**">
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
						        field: document.getElementById('time2'),
						        firstDay: 1,
						        minDate: new Date('2010-01-01'),
						        maxDate: new Date('2020-12-31'),
						        yearRange: [2000,2020]
						    });
						    
						</script>
					  </div>
					  </div>
					  <div class="col-md-5 column">
					   <div class="form-group">
						    <label>选择分组：</label>
						    <select class="form-control input-sm" onchange="findalllearnplaninfo();" id="studysectionid">
						    <option></option>
						    <%
						    if(section!=null&&section.size()>0){
						    	for(int i=0;i<section.size();i++){
						    		Section s = section.get(i);
						    %>
						      <option><%=s.getSection_name() %></option>
						      <%
						    	}
						    }
						      %>
						    </select>
						</div>
						</div>
					</div>
					<!-- 计划时间结束 -->
				<br><br>
					<table class="table table-hover" style="font-size: 13px;">
						<thead>
							<tr>
								<th>计划标题</th>
								<th>姓名</th>
								<th>组别</th>
								<th>计划时间</th>
								<th>时长</th>
								<th>更新时间</th>
							</tr>
						</thead>
						<tbody id="allplantbodyid">
						<%
						if(lpinfo!=null&&lpinfo.size()>0){
							for(int i=0;i<lpinfo.size();i++){
								Learning_plan l = lpinfo.get(i);
						%>
							<tr>
								<td><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" onclick="findallplaninfobyid(<%=l.getId() %>);" data-target="#modal-container-722522"><%=l.getLtitle() %></a></td>
								<td><%=l.getUsername() %></td>
								<td><%=l.getSectionname() %></td>
								<td class="p13-999"><%=l.getLstarttime() %>~<%=l.getLendtime() %></td>
								<td class="p13-999"><%=l.getLdaylong() %>天</td>
								<td class="p13-999"><%=l.getUpdatetime() %></td>
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
							</tr>
						<%
						}
						%>
						</tbody>
					</table>
					
					<!-- 分页 -->
					<div align="center">
					<table align="center"  style="font-size: 13px;">
					    <tr id="allplantrfenyeid">
							<th>第<span id="pageNows"><%=p.getPageNow() %></span>/<%=p.getpageCount(p.getTotalItemNumber()) %>页&nbsp;&nbsp;</th>
							<th>
								<ul class="pagination">
								<%
								if(p.getPageNow()!=1&&p.getPageNow()!=0){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushallplaninfo('1');">首页</a>
									</li>
								<%
								}
								if(p.isHasPrev()){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushallplaninfo('<%=p.getPrevPage() %>');">上页</a>
									</li>
								<%
								}
								if(p.isHasNext()){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushallplaninfo('<%=p.getNextPage() %>');">下页</a>
									</li>
								<%
								}
								if(p.getPageNow()!=p.getpageCount(p.getTotalItemNumber())){
								%>
									<li>
										 <a href="javascript:void(0);" onclick="flushallplaninfo('<%=p.getpageCount(p.getTotalItemNumber())%>');">尾页</a>
									</li>
								<%
								}
								%>
								</ul>
							</th>
							<%
							if(p.getpageCount(p.getTotalItemNumber())>3){
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
										<span id="ax_title"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p13-999">----</span>&nbsp;&nbsp;<span class="p13-999" id="ax_username"></span>
									</h4>
									<div style="color:#666666;">
										<div>
										<br>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">计划时间：</p>
												</div>
												<div class="col-md-7 column">
													<p  class="p13-999"><span id="ax_starttime"></span>~<span id="ax_lendtime" ></span></p>
												</div>
											</div>
											<div class="col-md-5 column">
												<div class="col-md-6 column">
													<p class="navbar-right">时长：</p>
												</div>
												<div class="col-md-6 column">
													<p style="color:#999" id="ax_ldaylong"></p>
												</div>
											</div>
											<div class="col-md-1 column"></div>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">更新时间：</p>
												</div>
												<div class="col-md-7 column">
													<p class="yellow" style="color:#999" id="ax_updatetime"></p>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-12 column" style="border-top:1px solid #ccc">
										<br/>
										<div style="height: 200px;">
											<span>计划内容：</span><br><br>
											<div class="col-md-12 column">
											<p  id="ax_content"></p>
											</div>
										</div>
										<div style="height: 50px;">
											<span>计划总结：</span><br><br>
											<div class="col-md-12 column">
											<p id="ax_summarize"></p>
											</div>
										</div>
									</div>
								</div>	
								<br />
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
