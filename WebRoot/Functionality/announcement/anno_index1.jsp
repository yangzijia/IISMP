<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Announcement> announcement1= (List<Announcement>)request.getAttribute("announce");
List<Announce_section> ass = (List<Announce_section>)session.getAttribute("anno_section");
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
Announcement ann=announcement1.get(0);

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
			
				<!-- 公告栏导航 -->
				<jsp:include page="anno_navigation.jsp"></jsp:include>
						
				<!-- 全部公告 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>全部公告</span>
						<span class="navbar-right" style="margin-right: 5px;">
							 <button type="button" class="btn btn-info btn-xs">已发布（<%=announcement1.size() %>）</button>
							 <button type="button" class="btn btn-info btn-xs" onclick="findasid2(<%=ann.getAnnouncement_id() %>)">未发布</button>
						</span>							 
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
							<%
					            if(announcement1 != null && announcement1.size() >0){
								   for(int i = 0;i<announcement1.size();i++){
					             	Announcement an = announcement1.get(i);
					             %>
					             
							<a href="findAinfobyid?announcement_id=<%=an.getAnnouncement_id() %>" style="text-decoration: none;">	
							<div class="a">
								<h4 style="color: #666666;margin-left: 10px;margin-right: 10px;">
										<%=an.getAnnouncement_title() %>
							    </h4>
								<p style="color: #adadad;margin-left: 20px;margin-right: 20px;">
									<%=an.getAnnouncement_info() %>
								</p>
								<p style="color: #adadad;margin-left: 20px;margin-right: 20px;">
						 			<%=an.getM_username() %>&nbsp; 发布与 <%=an.getAnnouncement_time() %>&nbsp;/&nbsp;2次浏览
								</p>
								</a>
								<br>
							</div>
							<br>
				 			<%
	             			   }
	            			   } 
               				%> 
               				<br>	
						<div align="center">
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
									<th>&nbsp;&nbsp;</th>
									<th>
										<div class="col-lg-6">
							                <div class="input-group">
							                    <input type="text" class="form-control" style="height: 30px;width: 45">
							                    <span class="input-group-btn">
							                        <button class="btn btn-default btn-sm" type="button">跳转</button>
							                    </span>
							                </div>
							            </div>
									</th>
								</tr>
							</table>
						</div>
					</div>	
				</div>
				<!-- 全部公告 -->
			</div>
		</div>
</div>
  </body>
</html>
