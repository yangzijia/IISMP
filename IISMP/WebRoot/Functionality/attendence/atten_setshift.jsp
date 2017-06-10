<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
Shift ss = (Shift)request.getAttribute("shiftinfo");
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
            
            //js设置签到，签退的时间
            var check_in_hour = <%=ss.getCheck_in_time_hour() %>;
            var check_in_minute = <%=ss.getCheck_in_time_minute() %>;
            var check_out_hour = <%=ss.getCheck_out_time_hour() %>;
            var check_out_minute = <%=ss.getCheck_out_time_minute() %>;
            var inhour = "";
            var inminute = "";
            var outhour = "";
            var outminute = "";
            if(check_in_hour==00){
            	inhour = "00";
            }else{
            	inhour = check_in_hour+"";
            }
            if(check_in_minute==00){
            	inminute = "00";
            }else{
            	inminute = check_in_minute+"";
            }
            if(check_out_hour==00){
            	outhour = "00";
            }else{
            	outhour = check_out_hour+"";
            }
            if(check_out_minute==00){
            	outminute = "00";
            }else{
            	outminute = check_out_minute+"";
            }
            $("#id_check_in_time_hour").val(inhour);
            $("#id_check_in_time_minute").val(inminute);
            $("#id_check_out_time_hour").val(outhour);
            $("#id_check_out_time_minute").val(outminute);
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
				
				<!-- 我的考勤 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>考勤管理>>班次设置</span>
						
						<span class="navbar-right" style="margin-right: 5px;">
						    <button type="button" onclick="updateShift()" class="btn btn-info btn-default btn-xs" data-toggle="modal" data-target="#modal-container-184701"> 修&nbsp;改 </button>
						</span>
						<!-- 导出开始 -->
						<div class="modal fade" id="modal-container-184701" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">
											编辑班次
										</h4>
									</div>
									<div class="modal-body">
										<div class="form-inline" role="form">
										<div>
										  <div class="DivSelect">
										  	<label  class="p14-999">签到：</label>
										     <select id="id_check_in_time_hour">
											      <option value="00">00</option>
											      <option value="01">01</option>
											      <option value="02">02</option>
											      <option value="03">03</option>
											      <option value="04">04</option>
											      <option value="05">05</option>
											      <option value="06">06</option>
											      <option value="07">07</option>
											      <option value="08">08</option>
											      <option value="09">09</option>
											      <option value="10">10</option>
											      <option value="11">11</option>
											      <option value="12">12</option>
											      <option value="13">13</option>
											      <option value="14">14</option>
											      <option value="15">15</option>
											      <option value="16">16</option>
											      <option value="17">17</option>
											      <option value="18">18</option>
											      <option value="19">19</option>
											      <option value="20">20</option>
											      <option value="21">21</option>
											      <option value="22">22</option>
											      <option value="23">23</option>
											 </select>
											 :
											 <select id="id_check_in_time_minute">
											      <option value="00">00</option>
											      <option value="05">05</option>
											      <option value="10">10</option>
											      <option value="15">15</option>
											      <option value="20">20</option>
											      <option value="25">25</option>
											      <option value="30">30</option>
											      <option value="35">35</option>
											      <option value="40">40</option>
											      <option value="45">45</option>
											      <option value="50">50</option>
											      <option value="55">55</option>
											 </select>
											~&nbsp;&nbsp;<label  class="p14-999">签退：</label>
											 <select id="id_check_out_time_hour">
											      <option value="00">00</option>
											      <option value="01">01</option>
											      <option value="02">02</option>
											      <option value="03">03</option>
											      <option value="04">04</option>
											      <option value="05">05</option>
											      <option value="06">06</option>
											      <option value="07">07</option>
											      <option value="08">08</option>
											      <option value="09">09</option>
											      <option value="10">10</option>
											      <option value="11">11</option>
											      <option value="12">12</option>
											      <option value="13">13</option>
											      <option value="14">14</option>
											      <option value="15">15</option>
											      <option value="16">16</option>
											      <option value="17">17</option>
											      <option value="18">18</option>
											      <option value="19">19</option>
											      <option value="20">20</option>
											      <option value="21">21</option>
											      <option value="22">22</option>
											      <option value="23">23</option>
											 </select>
											 :
											 <select id="id_check_out_time_minute">
											      <option value="00">00</option>
											      <option value="05">05</option>
											      <option value="10">10</option>
											      <option value="15">15</option>
											      <option value="20">20</option>
											      <option value="25">25</option>
											      <option value="30">30</option>
											      <option value="35">35</option>
											      <option value="40">40</option>
											      <option value="45">45</option>
											      <option value="50">50</option>
											      <option value="55">55</option>
											 </select>
										  </div>
										  </div><br>
										  <div>
										   <div class="form-group">
											    <label class="p14-999">弹性时间：</label>
											    <input type="text" id="elas_time" class="form-control input-sm" value="<%=ss.getElas_time() %>" maxlength="2" style="width: 45">
												<label class="p14-999">分钟</label>
											</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
										 <button type="button" onclick="updateShiftInfo()" class="btn btn-primary">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 导出结束 -->
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<br><br>
						<div class="col-md-12 column">
							<div class="form-horizontal" style="font-size: 14px;">
								<div class="form-group">
								<div class="col-sm-1">
							      		&nbsp;
							    	</div>
							    	<label class="col-sm-1"><span class="p13-999" >签到：</span></label>
								    <div class="col-sm-1">
							      		<span style="font-weight: bold;" id="check_in"><%=ss.getCheck_in_time_hour() %>:<%=ss.getCheck_in_time_minute() %></span>
							    	</div>
							    	<div class="col-sm-1">
							      		<span style="font-weight: bold;">~</span>
							    	</div>
							    	<label class="col-sm-1"><span class="p13-999" >签退：</span></label>
								    <div class="col-sm-1">
							      		<span style="font-weight: bold;" id="check_out"><%=ss.getCheck_out_time_hour() %>:<%=ss.getCheck_out_time_minute() %></span>
							    	</div>
							    	<div class="col-sm-2">
							      		&nbsp;
							    	</div>
							    	<label class="col-sm-2"><span class="p13-999" >弹性时间：</span></label>
								    <div class="col-sm-2">
							      		<span style="font-weight: bold;" id="tanxing"><%=ss.getElas_time() %></span>分钟
							    	</div>
							  	</div>
							</div>
						</div>	
					</div>	
				</div>
				<!-- 我的考勤 -->
			</div>
		</div>
</div>
  </body>
</html>
