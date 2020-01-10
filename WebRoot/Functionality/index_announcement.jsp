<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<AnnouncementQuery> announcement= (List<AnnouncementQuery>)session.getAttribute("announcementQuery");
%>
<!-- 公告栏 -->

<div id="announcementid">
	<div class="col-md-6 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		<h4 style="margin-top:10px;">
			公告栏
		</h4>
		<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted;">
		<div class="col-md-12 column" style="overflow-x:hidden;height:498px;">
			<table class="table table-hover" style="font-size: 13px;">
				<thead>
					<tr>
						<th>公告标题</th>
						<th>发布时间</th>
						<th>发布人</th>
						<th>浏览</th>
					</tr>
				</thead>
				<tbody id="annotbodyid">
				<%
				if(announcement != null && announcement.size() >0){
						   for(int i = 0;i<announcement.size();i++){
			             	AnnouncementQuery an = announcement.get(i);
				%>
					<tr>
						<td >
						<a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" onclick="findthisannouncementinfo(<%=an.getId() %>);" data-target="#modal-container-722522" >
						<%if(an.getState()==2){ %>(<span style="color:red">新</span>)<%} %> <span><%=an.getTitle() %></span></a></td>
						<td class="p13-999"><%=an.getTime() %></td>
						<td class="p13-999"><%=an.getM_username() %></td>
						<td class="p13-999"><%=an.getViews() %></td>
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
		</div>
	</div>
</div>
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
									<div class="col-md-4 column">
										<p class="navbar-right">发布时间：</p>
									</div>
									<div class="col-md-8 column">
										<p  class="p13-999"><span id="g_fabushijian"></span></p>
									</div>
								</div>
								<div class="col-md-6 column">
									<div class="col-md-4 column">
										<p class="navbar-right">浏览：</p>
									</div>
									<div class="col-md-8 column">
										<p style="color:#999" id="g_liulan"></p>
									</div>
								</div>
								<div class="col-md-6 column">
									<div class="col-md-4 column">
										<p class="navbar-right">发布人：</p>
									</div>
									<div class="col-md-8 column">
										<p class="yellow" style="color:#999" id="g_faburen"></p>
									</div>
								</div>
								<div class="col-md-6 column">
									<div class="col-md-4 column">
										<p class="navbar-right">类别：</p>
									</div>
									<div class="col-md-8 column">
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
	<!-- 全部公告结束 -->