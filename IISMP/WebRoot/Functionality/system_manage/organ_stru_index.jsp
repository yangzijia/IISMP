<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
@SuppressWarnings("unchecked")
List<MembershipInfo> membershipinfo = (List<MembershipInfo>)request.getAttribute("membershipinfo");
@SuppressWarnings("unchecked")
List<Section> sections = (List<Section>)session.getAttribute("sectioninfo");

Page p = (Page)request.getAttribute("pageinfo");
String section_names = (String)request.getAttribute("section_names");
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
    
            <!-- 下划线跟随效果  -->
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
	         $("a[lang=8]").addClass("pre");//设置选中的
	         $("a[lang=8]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
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
			
				<!-- 组织结构导航 -->
				<jsp:include page="sys_mana_navigation.jsp"></jsp:include>
				
				<!-- 新建人员开始 -->
		      	<div class="modal fade" id="modal-container-722543" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								 <h4 class="modal-title" id="myModalLabel">
									新建人员
								 </h4>
							</div>
							<div class="modal-body" style="font-size: 13px;">
								<form class="form-horizontal" role="form">
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">登陆账号：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="username" placeholder="请输入登陆账号">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">姓名：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="truename" placeholder="请输入姓名">
								    </div>
								    <div class="col-sm-4" id="wrap">
								    	<label class="checkbox-inline">
										    <input type="radio" name="sex" id="sex2" value="男" checked>男
										</label>
										<label class="checkbox-inline">
										    <input type="radio" name="sex" id="sex2" value="女">女
										</label>
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">密码：</label>
								    <div class="col-sm-6">
								      <input type="password" class="form-control input-sm" id="password" placeholder="请输入密码">
								    	
								    </div>
								    <div class="col-sm-4  control-label"><span class="p13-999">密码默认为：12345678&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">分组：</label>
								    <div class="col-sm-6">
									    <select class="form-control input-sm" id="an_section">
							      <%
							      if(sections != null && sections.size() > 0){
							    	  for(int i=0;i<sections.size();i++){
											Section s = sections.get(i);							    		  
							      %>
									      <option onclick="javascript:void(0);" value="<%=s.getSection_name() %>"><%=s.getSection_name() %></option>
								<%
							    	  }
							      }
								%>
									    </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">职务：</label>
								    <div class="col-sm-6">
									    <select class="form-control input-sm" id="duty">
									      <option onclick="javascript:void(0);">管理员</option>
									      <option onclick="javascript:void(0);">教师</option>
									      <option onclick="javascript:void(0);">组长</option>
									      <option onclick="javascript:void(0);">组员</option>
									    </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">手机号：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="phone" placeholder="请输入手机号">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">邮箱：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="email" placeholder="请输入邮箱">
								    </div>
								  </div>
								</form>
							</div>
							<div class="modal-footer">
								 <button type="button" class="btn btn-default  btn-sm" data-dismiss="modal">关闭</button> 
								 <button type="button" onclick="savememberinfos();" class="btn btn-primary  btn-sm">保存</button>
							</div>
						</div>
					</div>
				</div>
		      	<!-- 弹框结束 -->
						
				<!-- 全部人员 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<%
						if(section_names==""){
						%>
							<span>全部人员</span>
						<%
						}else{
						%>
							<span id="sectionss_names"><%=section_names %></span>
						<%
						}
						%>
						<span class="navbar-right" style="margin-right: 5px;">
							 <button type="button" onclick="clearthisaddmemebr();" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal-container-722543">新增人员</button>
							 <button type="button" onclick="openbatchtoleadjsp();" class="btn btn-info btn-xs">批量导入</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="form-group">
					    <div class="col-sm-2">
					    	<div class="form-group" style="width: 100px;">
							    <!-- <select class="form-control input-sm" id="state">
							      <option onclick="pageuporpagedown(1)">启用人员</option>
							      
							      <option onclick="openblockupmember(1)">停用人员</option>
							    </select> -->
							    <div class="dropdown">
					
									<button class="btn btn-default dropdown-toggle" style="width: 100px;" type="button" id="dropdownMenu1" data-toggle="dropdown">
										<span id="statespan">启用人员</span>
										<span class="caret"></span>
									</button>
									<input id="state" style="display: none;" type="text" value="启用人员">
									<ul class="dropdown-menu">
										<li ><a  tabindex="-1" href="javascript:void(0)" onclick="pageuporpagedown(1)">启用人员</a></li>
										<li ><a  tabindex="-1" href="javascript:void(0)" onclick="openblockupmember(1)">停用人员</a></li>
									</ul>
								</div> 
							 </div>
					    </div>
					   
					    <div class="col-sm-2">
					    	<div class="form-group" style="width: 100px;">
					    		<div class="dropdown">
									<button class="btn btn-default dropdown-toggle" style="width: 100px;" type="button" id="dropdownMenu1" data-toggle="dropdown">
										<span id="memberrolespan">全部职务</span>
										<span class="caret"></span>
									</button>
									<input id="memberrole" style="display: none;" type="text" value="全部职务">
									<ul class="dropdown-menu">
										<li><a tabindex="-1" href="javascript:void(0)" onclick="findthisrolemember('全部职务');">全部职务</a></li>
										<li><a tabindex="-1" href="javascript:void(0)" onclick="findthisrolemember('管理员');">管理员</a></li>
										<li><a tabindex="-1" href="javascript:void(0)" onclick="findthisrolemember('教师');">教师</a></li>
										<li><a tabindex="-1" href="javascript:void(0)" onclick="findthisrolemember('组长');">组长</a></li>
										<li><a tabindex="-1" href="javascript:void(0)" onclick="findthisrolemember('组员');">组员</a></li>
									</ul>
								</div> 
							    <!-- <select class="form-control input-sm" id="memberrole">
							      <option onclick="findthisrolemember();">全部职务</option>
							      <option onclick="findthisrolemember();">管理员</option>
							      <option onclick="findthisrolemember();">组长</option>
							      <option onclick="findthisrolemember();">组员</option>
							    </select> -->
							 </div>
					    </div>
					    <div class="col-sm-6">
					    	<div class="col-lg-6">
				                <div class="input-group">
				                    <input type="text" id="finduser" placeholder="姓名/手机/邮箱" class="form-control input-sm" style="width: 250px;">
				                    <span class="input-group-btn">
				                        <button class="btn btn-default btn-sm" onclick="findusermethod();" type="button">查找</button>
				                    </span>
				                </div>
				            </div>
					    </div>
						<div class="col-sm-2" >
					    	<div class="navbar-right" style="margin-right: 1px;" >
						      <div class="form-group" style="width: 150px;">
						      	<div class="dropdown">
									<button class="btn btn-default dropdown-toggle" style="width: 150px;" type="button" id="dropdownMenu1" data-toggle="dropdown">
										<span id="piliangxiugaispan">批量操作</span>
										<span class="caret"></span>
									</button>
									<!-- <input id="piliangxiugai" style="display: none;" type="text" value="批量操作"> -->
									<ul class="dropdown-menu">
										<li><a href="javascript:void(0)" tabindex="-1" onclick="batchmethod('批量操作')">批量操作</a></li>
										<li><a href="javascript:void(0)" tabindex="-1" onclick="batchqiyongmember('批量启用人员');">批量启用人员</a></li>
										<li><a href="javascript:void(0)" tabindex="-1" onclick="batchupdatemember('批量停用人员');">批量停用人员</a></li>
										<li><a href="javascript:void(0)" tabindex="-1" onclick="batchdeletemember('批量删除人员');">批量删除人员</a></li>
									</ul>
								</div> 
							    <!-- <select class="form-control input-sm" id="piliangxiugai">
							      <option>批量操作</option>
							      <option onclick="batchqiyongmember();">批量启用人员</option>
							      <option onclick="batchupdatemember();">批量停用人员</option>
							      <option onclick="batchdeletemember();">批量删除人员</option>
							    </select> -->
							 </div>
							</div>
							<!-- <div class="navbar-right" style="width: 170px;" id="piliangcaozuoanniu">
								<button type="button" onclick="batchupdatemember();" class="btn btn-default btn-sm">批量停用人员</button>
					   		</div> -->
					    </div>
					</div>
					<div class="col-md-12 column" style="overflow-x:hidden; height:453px; ">
						
						<table class="table table-hover" style="font-size: 13px;">
							<thead>
								<tr>	   
									<th width="7px;"><input id="allcheck" name="checkAll" type="checkbox"></th>
									<th>姓名</th>
									<th>性别</th>
									<th>分组</th>
									<th>职务</th>
									<th>登陆账号</th>
									<th>邮箱</th>
									<th>手机</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="membertbody">
							<%
							if(membershipinfo != null && membershipinfo.size() > 0){
								for(int i=0;i<membershipinfo.size();i++){
									MembershipInfo msi = membershipinfo.get(i);
							%>
								<tr>
									<td><input type="checkbox" name="chethis" id="<%=msi.getM_id() %>"></td>
									<td><%=msi.getM_truename() %></td>
									<td><%=msi.getM_sex() %></td>
									<td><%=msi.getM_sectionname() %></td>
									<td><%=msi.getM_role() %></td>
									<td><%=msi.getM_username() %></td>
									<td><%=msi.getM_email() %></td>
									<td><%=msi.getM_phone() %></td>
									<td>
									<%
									if(msi.getM_state().equals("启用")){
									%>
										<a id="modal-722544" onclick="findmembershipinfos(<%=msi.getM_id() %>);" href="#modal-container-722544" data-toggle="modal" style="text-decoration: none;">
										 <!--  <img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/> -->
										 编辑
										  </a>&nbsp;
										<a href="javascript:void(0);" onclick="blockupthismember(<%=msi.getM_id() %>)" style="text-decoration: none">
										    <!-- <img src="img/jin.png"  data-toggle="tooltip" data-placement="bottom" title="停用" style="width:18px;height:18px;"/> -->
										    停用
										    </a>
									<%
									}
									%>
									</td>
								</tr>
							<%
								}
							}else{
							%>
								<tr>
									<td></td>
									<td>无信息...</td>
									<td></td>
									<td></td>
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
						
						<!-- 编辑人员开始 -->
		      	<div class="modal fade" id="modal-container-722544" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h5 class="modal-title" id="myModalLabel">
									编辑人员
								</h5>
							</div>
							<div class="modal-body" style="font-size: 13px;">
								<form class="form-horizontal" role="form">
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">登陆账号：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="username1" placeholder="请输入登陆账号">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">姓名：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="truename1" placeholder="请输入姓名">
								    </div>
								    <div class="col-sm-4" id="wrap">
								    	<label class="checkbox-inline">
										    <input type="radio" name="sex1" id="optionsRadios3" value="男">男
										</label>
										<label class="checkbox-inline">
										    <input type="radio" name="sex1" id="optionsRadios4" value="女">女
										</label>
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">密码：</label>
								    <div class="col-sm-6">
								      <input type="password" class="form-control input-sm" id="password1" placeholder="请输入密码">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">分组：</label>
								    <div class="col-sm-6">
									    <select class="form-control input-sm" id="section1">
									      <option onclick="javascript:void(0);" value="实验室">实验室</option>
							      <%
							      if(sections != null && sections.size() > 0){
							    	  for(int i=0;i<sections.size();i++){
											Section s = sections.get(i);							    		  
							      %>
									      <option onclick="javascript:void(0);" value="<%=s.getSection_name() %>"><%=s.getSection_name() %></option>
								<%
							    	  }
							      }
								%>
									    </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">职务：</label>
								    <div class="col-sm-6">
									    <select class="form-control input-sm" id="duty1">
									      <option onclick="javascript:void(0);">管理员</option>
									      <option onclick="javascript:void(0);">教师</option>
									      <option onclick="javascript:void(0);">组长</option>
									      <option onclick="javascript:void(0);">组员</option>
									    </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">手机号：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="phone1" placeholder="请输入手机号">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">邮箱：</label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control input-sm" id="email1" placeholder="请输入邮箱">
								    </div>
								  </div>
								</form>

							</div>
							<div class="modal-footer">
								 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								 <span id="member_id"></span> 
								 <button type="button" onclick="saveeditmemberinfo();" class="btn btn-primary">保存</button>
							</div>
						</div>
					</div>
				</div>
		      	<!-- 弹框结束 -->		
						<div align="center">
							<table align="center"  style="font-size: 13px;">
								<tr id="member_tr">
									<th>第<span id="mm_pagenow"><%=p.getPageNow() %></span>/<span id="m_pagecount"><%=p.getpageCount(p.getTotalItemNumber()) %></span>页&nbsp;&nbsp;</th>
									<th>
										<ul class="pagination">
										<%
										if(p.getPageNow()!=1){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="pageuporpagedown(1);">首页</a>
											</li>
										<%
										}
										if(p.isHasPrev()){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="pageuporpagedown(<%=p.getPrevPage() %>);">上页</a>
											</li>
										<%
										}
										if(p.isHasNext()){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="pageuporpagedown(<%=p.getNextPage() %>);">下页</a>
											</li>
										<%
										}
										if(p.getPageNow()!=p.getpageCount(p.getTotalItemNumber())){
										%>
											<li>
												 <a href="javascript:void(0);" onclick="pageuporpagedown(<%=p.getpageCount(p.getTotalItemNumber()) %>);">尾页</a>
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
							                    <input type="text" id="tiaozhuanyeshu" class="form-control input-sm" maxlength="2" style="width: 45">
							                    <span class="input-group-btn">
							                        <button class="btn btn-default btn-sm" type="button" onclick="tiaozhuanfenye()">跳转</button>
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
				<!-- 全部公告 -->
			</div>
		</div>
</div>
<%session.removeAttribute("sectioninfo"); %>
  </body>
</html>
