<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}

ArrayList<AttenpendingPage> al=(ArrayList<AttenpendingPage>)request.getAttribute("alinfo");
int pendingappealNum = Integer.parseInt(request.getAttribute("pendingappealNum").toString());
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
    <!--导航选中效果 -->
    <script type="text/javascript">
      $(function(){
         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
         $("a[lang=0]").addClass("pre");//设置选中的
         $("a[lang=0]").css("color","#fff");
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
			
				<!-- 考勤导航 -->
				<jsp:include page="atten_navigation.jsp"></jsp:include>
				
				<!-- 考勤记录 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>考勤管理>>考勤记录</span>
						<span class="navbar-right" style="margin-right: 5px;">
							<div class="btn-group btn-group-xs" >
							    <button type="button" onclick="open_seerecord();" class="btn btn-default"> 记录查看 </button>
							    <button type="button" onclick="open_unusual();" class="btn btn-info btn-default"> 异常考勤 </button>
							    <button type="button" onclick="open_pendingappeal();" class="btn btn-default">
							     	待处理申诉（<font id="daichulishensu" color="red" style="font-weight:bold;"><%=pendingappealNum %></font>） 
							    </button>
							</div>
						</span>
					</h4>
					<hr style="margin-top: 0px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table class="table table-hover" style="font-size: 13px;">
						  <thead>
						    <tr>
						      <th>人员</th>
						      <th>考勤时间</th>
						      <th>
							    <select id="kaoqinxinxi11">
							      <option name="kaoqinxinxi" onclick="findBYtunusualrecord();">考勤信息</option>
							      <option onclick="findBYtunusualrecord();">正常</option>
							      <option onclick="findBYtunusualrecord();">早退</option>
							      <option onclick="findBYtunusualrecord();">迟到</option>
							      <option onclick="findBYtunusualrecord();">迟到，早退</option>
							      <option onclick="findBYtunusualrecord();">未签退</option>
							      <option onclick="findBYtunusualrecord();">迟到，未签退</option>
							      <option onclick="findBYtunusualrecord();">缺勤</option>
							    </select>
						      </th>
						      <th>
							    <select id="chulistate">
							      <option onclick="findunusualrecordBystate('处理状态');">处理状态</option>
							      <option onclick="findunusualrecordBystate('已处理');">已处理</option>
							      <option onclick="findunusualrecordBystate('未处理');">未处理</option>
							    </select>
						      </th>
						      <th>操作人</th>
						      <th style="width: 60px;">操作</th>
						    </tr>
						  </thead>
						  <tbody id="checkrecord_unusualtbody">
						  <%
						  if(al != null && al.size() > 0){
							  for(int j=0;j<al.size();j++){
								  AttenpendingPage ap1 = (AttenpendingPage)al.get(j);
						  %>
						    <tr>
						      <td><%=ap1.getUsername() %></td>
						      <td>
						      	<span><%=ap1.getDatetime() %></span> &nbsp;<span><%=ap1.getWeek() %></span>
						      	<br>
						      	<span class="p13-999"><%=ap1.getShiftsection() %></span>
						      </td>
						      <td>
						      	<!-- <font>签退</font>&nbsp; -->
						      	<%
						      	if(ap1.getState().equals("正常")){
						      	%>
						      	<font id="trueastateinfo"><%=ap1.getState() %></font><font class="p13-red">（<%=ap1.getAfterstate() %>）</font><br>
						      	<font><%=ap1.getCheck_in_out_info() %></font>
						      	<%
						      	}else{
						      	%>
						      	<font id="trueastateinfo" class="p13-red"><%=ap1.getState() %></font><br>
						      	<font><%=ap1.getCheck_in_out_info() %></font>
						      	<%} %>
						      	<!-- <font>（21:35）</font> -->
						      </td>
						      <td>
						      <%
						      if(ap1.getStatenum()==1){
						      %>
						      	<span class="p13-red">未处理</span>
						      <%
						      }else{
						      %>
						      	<span class="p13-999">已处理</span>
						      	<%
						      }
						      %>
						      </td>
						      <td>
						      	<%=ap1.getOperatorname() %>
						      </td>
						      <td>
						      <%
						      if(ap1.getStatenum()==1){
						      %>
						      	<a id="modal-722544" onclick="findthisatten_unusualinfo('<%=ap1.getState() %>','<%=ap1.getId() %>','<%=ap1.getM_id() %>');" href="#modal-container-722544" data-toggle="modal" href="javascript:void();" style="text-decoration: none;">处理</a>
						      <%
						      }else{
						      %>
						      	<a id="modal-722544" onclick="findthisatten_unusualinfo('<%=ap1.getState() %>','<%=ap1.getId() %>','<%=ap1.getM_id() %>');" href="#modal-container-722544" data-toggle="modal" style="text-decoration: none;">重新处理</a>
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
						    </tr>
						    <%
						  }
						    %>
						  </tbody>
						</table>
						<!-- 弹框开始处理 -->
						      	<div class="modal fade" id="modal-container-722544" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
												<h4 class="modal-title" id="myModalLabel">
													处理结果
												</h4>
											</div>
											<div class="modal-body" style="font-size:14px;">
												<form class="form-horizontal" role="form">
											    	<div class="form-group">
													   <label for="firstname" class="col-sm-3 control-label">考勤信息：</label>
													   <div class="col-sm-6">
													<span style="display: none;" id="atten_unusualid"></span>
													<span style="display: none;" id="qingqiurendeid"></span>
													   		<select class="form-control input-sm" id="selectstateinfo">
														      <option>正常</option>
														      <option>早退</option>
														      <option>迟到</option>
														      <option>迟到，早退</option>
														      <option>未签退</option>
														      <option>迟到，未签退</option>
														      <option>缺勤</option>
														    </select>
													   </div>
													 </div>
										         </form>	
											</div>
											<div class="modal-footer">
												 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button> 
												 <button type="button" onclick="savecheckrecordunusualinfo();" class="btn btn-primary btn-sm">保存</button>
											</div>
										</div>
									</div>
								</div>
						      	<!-- 弹框结束 -->
					</div>	
				</div>
				<!-- 考勤记录 -->
			</div>
		</div>
</div>
  </body>
</html>
