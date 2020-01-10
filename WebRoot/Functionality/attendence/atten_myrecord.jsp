<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}

List<Attendance> atten = (List<Attendance>)request.getAttribute("attendanceinfo");
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
    
    <!-- 全日历 -->
    <link rel='stylesheet' href='../lib/cupertino/jquery-ui.min.css' />
	<link href='css/calendar/fullcalendar.css' rel='stylesheet' />
	<link href='css/calendar/fullcalendar.print.css' rel='stylesheet' media='print' />
	<script src='js/calendar/moment.min.js'></script>
	<script src='js/calendar/jquery.min.js'></script>
	<script src='js/calendar/jquery-ui.custom.min.js'></script>
	<script src='js/calendar/fullcalendar.js'></script>
	<script src='js/calendar/lang-all.js'></script>
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
	
	
	<!-- <script src='js/calendarjs.js'></script> -->
	<script type="text/javascript">
	$(document).ready(function() {
		var currentLangCode = 'zh-cn';
		
		// rerender the calendar when the selected option changes
		$('#lang-selector').on('change', function() {
			if (this.value) {
				currentLangCode = this.value;
				$('#calendar').fullCalendar('destroy');
				renderCalendar();
			}
		});
		
		function renderCalendar() {
			$('#calendar').fullCalendar({
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,agendaWeek,agendaDay'
				},
				//defaultDate: '2016-11-11',
				lang: currentLangCode,
				buttonIcons: false, // show the prev/next text
				weekNumbers: false,
				editable: false,
				
				
				events: [
			         <%
			         if(atten != null && atten.size() > 0){
			        	 for(int i=0;i<atten.size();i++){
			        		 Attendance aa = atten.get(i);
			         %>
				         	{
								title: "<%=aa.getA_yueritime() %>\n<%=aa.getA_check_in_time() %>~<%if(aa.getA_check_out_time() != null){%><%=aa.getA_check_out_time() %><%}else{%>-<%}%>\n 班次：<%=aa.getShiftsection() %> \nIP：<%=aa.getIpaddr_in() %>\n<%=aa.getIpstate() %>，<%=aa.getA_state() %>",
								start: "<%=aa.getA_datetime() %>"
							}
				         	<%
				         	if(i!=atten.size()){
				         	%>
			         			,
			         <%
				         	}
			         	}
			         }
			         %>
				         ]
				
			});
		}
		
		renderCalendar();
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
				
				<!-- 新建小组开始 -->
		      	
				<div class="modal fade" id="mymodal111" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">
									异常申诉
								</h4>
							</div>
							<div class="modal-body" style="font-size: 13px;">							
							   <div class="form-horizontal" role="form">
							 
							   
							    	<div class="form-group">
									   <label for="firstname" class="col-sm-3 control-label">根据日期查找：</label>
									   <div class="col-sm-6">
									       <input type="text" class="form-control input-sm" id="datepicker" placeholder="****-**-**">
										    <script type="text/javascript">
											    var picker = new Pikaday(
											    {
											        field: document.getElementById('datepicker'),
											        firstDay: 1,
											        minDate: new Date('2010-01-01'),
											        maxDate: new Date('2020-12-31'),
											        yearRange: [2000,2020]
											    });
											</script>
									   </div>
									   <div class="col-sm-3">
											 <button type="submit" onclick="finduseratteninfo();" class="btn btn-default btn-sm">查找</button>
									   </div>
									 </div>
									 <div class="form-group">
									   <label for="firstname" class="col-sm-3 control-label">考勤情况：</label>
									   <div class="col-sm-6" id="atteninfos">
									    -
									   </div>
									 </div>
									 <div class="form-group">
									   <label for="firstname" class="col-sm-3 control-label">说明：</label>
									   <div class="col-sm-6">
									    <textarea class="form-control" id="remark" rows="3"></textarea>
									   </div>
									 </div>
						         </div>								
							 </div>
							 <div class="modal-footer">
								 <button type="button" class="btn btn-default btn-sm"  data-dismiss="modal">关闭</button>
								 <button type="button" onclick="attenapplyinfo();" class="btn btn-primary btn-sm">申诉</button>
							</div>
						</div>
					</div>
				</div>
		      	<!-- 新建小组结束 -->
				
				<!-- 我的考勤 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						我的考勤>>考勤打卡
						<span class="navbar-right" style="margin-right: 4px;">
							<button type="button" onclick="clearneirong();" class="btn btn-info btn-xs"  data-toggle="modal" data-target="#mymodal111">异常申诉</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
					
						<div id='calendar'></div>
					
					</div>	
				</div>
				<!-- 我的考勤 -->
			</div>
		</div>
</div>
  </body>
</html>
