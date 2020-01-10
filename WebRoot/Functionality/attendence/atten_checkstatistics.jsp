<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}

List<AttenStaticPage> aspinfo = (List<AttenStaticPage>)request.getAttribute("alinfostatic");
List<Section> section = (List<Section>)request.getAttribute("sectioninfo");
AllstatePage ap = (AllstatePage)request.getAttribute("apinfos");

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
            var n = new Date();
            var nowyear = n.getFullYear()+"年";
            var nowmonth = n.getMonth()+1;
            
            $("#nian_idspan").html(nowyear);
            $("#nian_id").val(nowyear);
            $("#yue_idspan").html(nowmonth+"月");
            $("#yue_id").val(nowmonth+"月");
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
						<span>考勤管理>>考勤统计</span>
					</h4>
					<hr style="margin-top: 0px; height:1px;border:none;border-top:2px dotted ;">
					<div class="form-inline" role="form">
							<div class="col-md-3 column">
							  <div class="form-group" >
							    <label class="p14">查看：</label>
							    
							    <span class="dropdown">
					
									<button class="btn btn-default dropdown-toggle" style="width: 100px;" type="button" id="dropdownMenu1" data-toggle="dropdown">
										<span id="section_idspan">全部</span>
										<span class="caret"></span>
									</button>
									<input id="section_id" style="display: none;" type="text" value="全部">
									<ul class="dropdown-menu" id="sectionulinfo">
										<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('全部');">全部</a></li>
									<%
					       if(section != null && section.size() >0){
					    	   for(int i=0;i<section.size();i++){
					    		   Section s = section.get(i);
					       %>
										<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('<%=s.getSection_name() %>');"><%=s.getSection_name() %></a></li>
								<%
					    	   }
					       }
							%>
									</ul>
								</span> 
							    
							   <%--  <select class="form-control input-sm" id="section_id" style="padding: 5xp 8px;">
							       <option onclick="findthisstatsticsbyinfo();">全部</option>
					       <%
					       if(section != null && section.size() >0){
					    	   for(int i=0;i<section.size();i++){
					    		   Section s = section.get(i);
					       %>
								   <option onclick="findthisstatsticsbyinfo();"><%=s.getSection_name() %></option>
							<%
					    	   }
					       }
							%>
							    </select> --%>
							  </div>
							</div>
							<div class="col-md-8 column">
								<div class="form-group" >
								    <span class="dropdown">
					
										<button class="btn btn-default dropdown-toggle" style="width: 100px;" type="button" id="dropdownMenu1" data-toggle="dropdown">
											<span id="nian_idspan"></span>
											<span class="caret"></span>
										</button>
										<input id="nian_id" style="display: none;" type="text" value="">
										<ul class="dropdown-menu">
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2022年');">2022年</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2021年');">2021年</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2020年');">2020年</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2019年');">2019年</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2018年');">2018年</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2017年');">2017年</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2016年');">2016年</a></li>
										</ul>
									</span>
								    
								   <!--  <select class="form-control input-sm" id="nian_id" style="padding: 5xp 8px;">
								       <option onclick="findthisstatsticsbyinfo();">2019年</option>
								       <option onclick="findthisstatsticsbyinfo();">2018年</option>
								       <option onclick="findthisstatsticsbyinfo();">2017年</option>
								       <option onclick="findthisstatsticsbyinfo();">2016年</option>
								       <option onclick="findthisstatsticsbyinfo();">2015年</option>
								       <option onclick="findthisstatsticsbyinfo();">2014年</option>
								       <option onclick="findthisstatsticsbyinfo();">2013年</option>
								    </select> -->
								  </div>
								  <div class="form-group" >
								    <span class="dropdown">
										<button class="btn btn-default dropdown-toggle" style="width: 100px;" type="button" id="dropdownMenu1" data-toggle="dropdown">
											<span id="yue_idspan"></span>
											<span class="caret"></span>
										</button>
										<input id="yue_id" style="display: none;" type="text" value="">
										<ul class="dropdown-menu">
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('12月');">12月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('11月');">11月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('10月');">10月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('9月');">9月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('8月');">8月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('7月');">7月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('6月');">6月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('5月');">5月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('4月');">4月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('3月');">3月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('2月');">2月</a></li>
											<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo('1月');">1月</a></li>
										</ul>
									</span>
								   <!--  <select class="form-control input-sm" id="yue_id" style="padding: 5xp 8px;">
								       <option onclick="findthisstatsticsbyinfo();">12月</option>
								       <option onclick="findthisstatsticsbyinfo();">11月</option>
								       <option onclick="findthisstatsticsbyinfo();">10月</option>
								       <option onclick="findthisstatsticsbyinfo();">9月</option>
								       <option onclick="findthisstatsticsbyinfo();">8月</option>
								       <option onclick="findthisstatsticsbyinfo();">7月</option>
								       <option onclick="findthisstatsticsbyinfo();">6月</option>
								       <option onclick="findthisstatsticsbyinfo();">5月</option>
								       <option onclick="findthisstatsticsbyinfo();">4月</option>
								       <option onclick="findthisstatsticsbyinfo();">3月</option>
								       <option onclick="findthisstatsticsbyinfo();">2月</option>
								       <option onclick="findthisstatsticsbyinfo();">1月</option>
								    </select> -->
								   </div>
							</div>
						</div>
					<div class="col-md-12 column" style="overflow-x:hidden; height:468px; ">
						<table class="table table-bordered"  style="font-size: 13px;">
						<caption>考勤汇览：（/天）</caption>
						  <thead>
						    <tr>
						      <th style="text-align:center;">迟到</th>
						      <th style="text-align:center;">早退</th>
						      <th style="text-align:center;">未签退</th>
						      <th style="text-align:center;">迟到，早退</th>
						      <th style="text-align:center;">迟到，未签退</th>
						      <th style="text-align:center;">IP异常</th>
						      <th style="text-align:center;">缺勤</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr style="text-align:center;color:red; font-weight:bold;">
						      <td id="allchidao"><%=ap.getAllchidaon() %></td>
						      <td id="allzaotui"><%=ap.getAllzaotuin() %></td>
						      <td id="allweiqiantui"><%=ap.getAllweiqiantuin() %></td>
						      <td id="allchitui"><%=ap.getAllchituin() %></td>
						      <td id="allchiweitui"><%=ap.getAllchiweituin() %></td>
						      <td id="allipinfo"><%=ap.getAllipinfo() %></td>
						      <td id="allqueqin"><%=ap.getAllqueqinn() %></td>
						    </tr>
						  </tbody>
						</table>
						<div>
							<table class="table table-hover" style="font-size: 13px;">
							  <thead>
							    <tr>
							      <th>人员</th>
							      <th>组别</th>
							      <th>实际出勤</th>
							      <th>迟到</th>
							      <th>早退</th>
							      <th>未签退</th>
							      <th>迟到，早退</th>
							      <th>迟到，未签退</th>
							      <th>IP异常</th>
							      <th>缺勤</th>
							    </tr>
							  </thead>
							  <tbody id="xiangxikaoqintbody">
							  <%
							  if(aspinfo != null && aspinfo.size() > 0){
								  for(int i=0;i<aspinfo.size();i++){
									  AttenStaticPage al = aspinfo.get(i);
							  %>
							    <tr>
							      <td><%=al.getUsername() %></td>
							      <td><%=al.getSectionname() %></td>
							      <td><%=al.getShijichuqin() %></td>
							      <td><%=al.getChidaon() %></td>
							      <td><%=al.getZaotuin() %></td>
							      <td><%=al.getWeiqiantuin() %></td>
							      <td><%=al.getChituin() %></td>
							      <td><%=al.getChiweituin() %></td>
							      <td><%=al.getIpinfo() %></td>
							      <td><%=al.getQueqinn() %></td>
							    </tr>
							    <%
								  }
							  }
							    %>
							  </tbody>
							</table>
							<!-- <div align="center">
								<table align="center"  style="font-size: 13px;">
									<tr>
										<th>第1/3页&nbsp;&nbsp;</th>
										<th>
											<ul class="pagination">
												<li>
													 <a href="javascript:void(0);">首页</a>
												</li>
												<li>
													 <a href="javascript:void(0);">上页</a>
												</li>
												<li>
													 <a href="javascript:void(0);">下页</a>
												</li>
												<li>
													 <a href="javascript:void(0);">尾页</a>
												</li>
											</ul>
										</th>
									</tr>
								</table>
								</div> -->
						</div>
					</div>	
				</div>
				<!-- 考勤记录 -->
			</div>
		</div>
</div>
  </body>
  <script type="text/javascript">
	$(document).ready(function () {
		var today=new Date();
		//alert(today.getFullYear());
		//alert(today.getMonth()+1);
		var nianinfo = today.getFullYear()+"年";
		var yueinfo = today.getMonth()+1+"月";
		$("#nian_id").val(nianinfo);
		$("#yue_id").val(yueinfo);
		//window.document.getElementById ("nian_id").innerHTML = nianinfo;
	});
	</script>
</html>
