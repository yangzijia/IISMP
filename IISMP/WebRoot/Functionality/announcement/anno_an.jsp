<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
			<!-- 全部公告 -->
			<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
				<h4 style="margin-top:10px;">
					<span  id="as_name">全部公告</span>
					<span id="m_pageNow" style="display:none;">1</span>
					<span class="navbar-right" style="margin-right: 5px;">
					  <button type="button" class="btn btn-info btn-xs" 	onclick="back1()">已发布</button>
					  <button type="button" class="btn btn-info btn-xs "  onclick="findfas(1)">保存未发布</button>
					</span>
				</h4>
				<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
				<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
					<div class="b" id="ssbody">
             		   <br>
             		   	
	    			</div>
					<!-- 弹框结束 -->		
			     <div align="center">
					<table align="center" style="font-size: 13px;" id="qwert">

					</table>
			     </div>
				</div>	
			</div>