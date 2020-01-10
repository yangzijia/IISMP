<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Announcement> announcement= (List<Announcement>)request.getAttribute("announcement");
List<Announce_section> ass = (List<Announce_section>)session.getAttribute("anno_section");
List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
int weifabunum = Integer.parseInt(request.getAttribute("weifabunum").toString());
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
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <link rel="Shortcut icon" href="img/favicon.ico">   
    
    <script src="js/myjs.js" type="text/javascript"></script>
	<script src="js/dzjs.js" type="text/javascript"></script>
	<script src="js/annojs.js" type="text/javascript"></script>
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
				
				<!-- 全部公告 -->
			<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
				<h4 style="margin-top:10px;">
					<span id="as_name_anno">全部公告</span>
					<span class="navbar-right" style="margin-right: 5px;">
					   <span style="display: none;" id="announcement_type">保存并发布</span>
					   <button type="button" class="btn btn-info btn-xs" onclick="yifabubuttonmethod();">已发布（<span id="yifabunum"><%=p.getTotalItemNumber() %></span>）</button>
				       <button type="button" class="btn btn-info btn-xs"  onclick="weifabubuttonmethod();">未发布（<span id="weifabunum"><%=weifabunum %></span>）</button>
				    </span>						 
				</h4>
				<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
				<div style="overflow-x:hidden; height:498px; ">
				  
					<table class="table table-hover" style="font-size: 13px;">
						<thead>
							<tr>
								<th>公告标题</th>
								<th>发布时间</th>
								<th>发布人</th>
								<th>浏览</th>
								<th style="width: 100px;">操作</th>
							</tr>
						</thead>
						<tbody id="annotbodyid">
						<%
						if(announcement != null && announcement.size() >0){
								   for(int i = 0;i<announcement.size();i++){
					             	Announcement an = announcement.get(i);
						%>
							<tr>
								<td><a href="javascript:void(0);" style="text-decoration:none" data-toggle="modal" onclick="findthisannouncementinfo(<%=an.getAnnouncement_id() %>);" data-target="#modal-container-722522"><%=an.getAnnouncement_title() %></a></td>
								<td class="p13-999"><%=an.getAnnouncement_time() %></td>
								<td class="p13-999"><%=an.getM_username() %></td>
								<td class="p13-999"><%=an.getAnnouncement_views() %></td>
								<td style="cursor:pointer;">
								
								  	<a  href="editAnnoByid?announcement_id=<%=an.getAnnouncement_id() %>" style="text-decoration: none;">
							     	<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>
							     	&nbsp;
							     	<a href="javascript:void(0);"  onclick="deletethisannounbyid(<%=an.getAnnouncement_id() %>);" style="text-decoration: none;">
							     	<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a>
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
								<td></td>
							</tr>
						<%
						}
						%>
						</tbody>
					</table>
					
					<!-- 分页 -->
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
							                    <input type="text" class="form-control input-sm" id="anno_yeshu" maxlength="2" style="width: 45">
							                    <span class="input-group-btn">
							                        <button class="btn btn-default btn-sm" onclick="fanyeanno($('#anno_yeshu').val())" type="button">跳转</button>
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
					<!-- 分页结束 -->
					
				<!-- 详细内容弹框开始 -->
				<div class="modal fade" id="modal-container-722522" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
									<span id="g_title"></span>
								</h4>
							</div>						  
							<div class="modal-body" style="font-size: 13px;height:468px;">
								<div style="color:#666666;">
									<div>
										<div class="col-md-6 column">
											<div class="col-md-5 column">
												<p class="navbar-right">发布时间：</p>
											</div>
											<div class="col-md-7 column">
												<p  class="p13-999"><span id="g_fabushijian"></span></p>
											</div>
										</div>
										<div class="col-md-6 column">
											<div class="col-md-6 column">
												<p class="navbar-right">浏览：</p>
											</div>
											<div class="col-md-6 column">
												<p style="color:#999" id="g_liulan"></p>
											</div>
										</div>
										<div class="col-md-6 column">
											<div class="col-md-5 column">
												<p class="navbar-right">发布人：</p>
											</div>
											<div class="col-md-7 column">
												<p class="yellow" style="color:#999" id="g_faburen"></p>
											</div>
										</div>
										<div class="col-md-6 column">
											<div class="col-md-6 column">
												<p class="navbar-right">类别：</p>
											</div>
											<div class="col-md-6 column">
												<p style="color:#999" id="g_leibie"></p>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12 column" style="border-top:1px solid #ccc">
									<br/>
									<div style="height: 200px;">
										<div class="col-md-12 column">
										<p  id="g_content"></p>
										</div>
									</div>
								</div>
							</div>	
						       </div>   								
							 </div>
						</div>
						<!-- 弹窗结束 -->
				</div>	
			</div>
			<!-- 全部公告结束 -->
				
			</div>
		</div>
     </div>
     </div>
  </body>
</html>
