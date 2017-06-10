<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}

List<Attendance> atten = (List<Attendance>)request.getAttribute("atteninfoss");
List<MembershipInfo> member = (List<MembershipInfo>)request.getAttribute("memberinfo");
AttenallrecordPage arp = (AttenallrecordPage)request.getAttribute("arpinfo");


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
   
    <link rel="Shortcut icon" href="img/favicon.ico">   
   	<!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
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
							    <button type="button" onclick="open_seerecord();" class="btn btn-info btn-default"> 记录查看 </button>
							    <button type="button" onclick="open_unusual();" class="btn btn-default"> 异常考勤 </button>
							    <button type="button" onclick="open_pendingappeal();" class="btn btn-default">
							     	待处理申诉（<font color="red" style="font-weight:bold;"><%=arp.getPendingappealNum() %></font>） 
							    </button>
							</div>
						</span>
					</h4>
					<hr style="margin-top: 0px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-6 column">
						<div class="col-md-4 column">
							<span style="font-size:25px;font-weight:bold;" id="yiqiandao"><%=arp.getCheckinNum() %> </span>&nbsp;
							<span class="p13"> 已签到</span>
						</div>
						<div class="col-md-4 column">
							<span style="font-size:25px;font-weight:bold;color:#999999" id="yiqiantui"><%=arp.getCheckoutNum() %> </span>&nbsp;
							<span class="p13"> 已签退</span>
						</div>
						<div class="col-md-4 column">
							<span style="font-size:25px;font-weight:bold;color: #ED6264" id="weidaka"><%=arp.getNocheckinNum() %> </span>&nbsp;
							<span class="p13"> 未打卡</span>
						</div>
					</div>
					<div class="col-md-6 column">
						<form class="form-inline" role="form">
						  <div class="form-group">
						  	<label  for="name">根据日期查找：</label>
						    <input type="text" value="<%=arp.getDatetime() %>" class="form-control input-sm" id="datepicker" placeholder="****-**-**">
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
						  <button type="button" onclick="findseerecordinfo();" class="btn btn-default btn-sm">查找</button>
						</form>
					</div>
					<div class="col-md-12 column" style="overflow-x:hidden; height:453px; ">
						<table class="table table-hover" style="font-size: 13px;">
						  <thead>
						    <tr>
						      <th>人员</th>
						      <th>签到时间</th>
						      <th>签退时间</th>
						      <th>时长（小时）</th>
						      <th>IP信息</th>
						      <th style="width: 90px;">
						     	   考勤信息
								    <!-- <select>
								      <option onclick="findatteninfo();">考勤信息</option>
								      <option onclick="findatteninfozc();">正常</option>
								      <option onclick="findatteninfozt();">早退</option>
								      <option onclick="findatteninfocd();">迟到</option>
								      <option onclick="findatteninfocdzt();">迟到，早退</option>
								      <option onclick="findatteninfoqq();">缺勤</option>
								    </select> -->
						      </th>
						    </tr>
						  </thead>
						  <tbody id="checkrecord_seetbody">
				  <%
				if(member!=null && member.size() > 0){
					for(int i=0;i<member.size();i++){
						MembershipInfo msi = member.get(i);
						if(atten != null && atten.size() > 0){
							boolean checkthis = false;
							for(int j=0;j<atten.size();j++){
								Attendance aa = atten.get(j);
								if(msi.getM_id()==aa.getM_id()){
									checkthis = true;
				  %>
								    <tr>
								      <td><%=msi.getM_truename() %></td>
								      <td><%if(aa.getA_check_in_time()!=null){ %><%=aa.getA_check_in_time() %><%}else{ %>-<%} %></td>
								      <td><%if(aa.getA_check_out_time()!=null){ %><%=aa.getA_check_out_time() %><%}else{ %>-<%} %></td>
								      <td><%if(aa.getTime_difference()!=null){ %><%=aa.getTime_difference() %>&nbsp;h<%}else{ %>-<%} %></td>
								      <td><%if(aa.getIpinfo_in()!=null){ %><%=aa.getIpinfo_in() %><%}else{ %>-<%} %></td>
								      <td><%if(aa.getA_state().equals("正常")){ %><%=aa.getA_state() %><%}else{ %><font color="red"><%=aa.getA_state() %></font><%} %></td>
								    </tr>
				  <%
								}
							}
							if(!checkthis){
								%>
								<tr>
						      <td><%=msi.getM_truename() %></td>
						      <td>-</td>
						      <td>-</td>
						      <td>-</td>
						      <td>-</td>
						      <td>
						      	<font color="red">缺勤</font>
						      </td>
						    </tr>
								
								<%
							}
						}else{
							%>
							<tr>
						      <td><%=msi.getM_truename() %></td>
						      <td>-</td>
						      <td>-</td>
						      <td>-</td>
						      <td>-</td>
						      <td>
						      	<font color="red">缺勤</font>
						      </td>
						    </tr>
				<%
						}
					}
				}
				  %>
						  </tbody>
						</table>
					</div>	
				</div>
				<!-- 考勤记录 -->
			</div>
		</div>
</div>
  </body>
</html>
