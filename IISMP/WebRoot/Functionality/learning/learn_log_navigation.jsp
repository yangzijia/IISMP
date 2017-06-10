<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Log_type> ltype = (List<Log_type>)session.getAttribute("logtype");
%>
<!-- 写日志左边栏 -->
<div class="col-md-3 column" >
	<div class="col-md-12 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
		
		<!-- 搜索框开始 -->
		<form class="bs-example bs-example-form" role="form"  style="margin-bottom:0;">
		<div class="row">
			<div class="input-group" style="margin:20px 15px 0px;">
				<input type="text" class="form-control input-sm"  placeholder="搜索日志">
				<span class="input-group-btn">
					<button class="btn btn-default input-sm" type="button" style="background-color:#F1F1F1;">
						Go!
					</button>
				</span>
			</div>
		</div>
	    </form>
		<!-- 搜索框结束 -->
		
		<br>
	 	<button type="button" class="btn btn-default btn-block btn-info"  onclick="location.href='Functionality/learning/learn_newlog.jsp'">+&nbsp;&nbsp;写日志</button>
	 	
		<hr>
		<div class="p16">
			<ul>
				<a href="findloginfo" style="text-decoration: none;"><li class="bg"><img src="img/log.png" style="width:20px;height:20px;">&nbsp;&nbsp;全部日志</li></a>
				<ul>
				<%
				if(ltype!=null&&ltype.size()>0){
					for(int i=1;i<ltype.size();i++){
						Log_type lt=ltype.get(i);	
									
				%>
				<a href="javascript:void(0);" onclick="ViewlogBytype(1)"  style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;个人日志</li></a>
				<a href="javascript:void(0);" onclick="ViewlogBytype(<%=lt.getLt_id()%>)"  style="text-decoration: none;"><li class="bg"><img src="img/dd.png" style="width:13px;height:13px;">&nbsp;&nbsp;<%=lt.getLt_name() %></li></a>
					
				<% 
				}
				}
				%>
				</ul>
                <a style="text-decoration: none;" href="ViewLogtype"><li class="bg"><img src="img/atg.png" style="width:18px;height:18px;">&nbsp;&nbsp;分类管理</li></a>
			    <a style="text-decoration: none;" href="Viewdraft"><li class="bg"><img src="img/cg.png" style="width:16px;height:16px;margin-top:-2px;">&nbsp;&nbsp;草稿箱</li></a>
			</ul>
		</div>
	</div>
</div>