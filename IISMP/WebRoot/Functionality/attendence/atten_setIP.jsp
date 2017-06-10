<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
List<DefaultIP> dip = (List<DefaultIP>)request.getAttribute("dip");

%>
<%
//获取本地IP
String ip = request.getHeader("x-forwarded-for");
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
  {
    ip = request.getHeader("Proxy-Client-IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
  {
    ip = request.getHeader("WL-Proxy-Client-IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
  {
    ip = request.getRemoteAddr();
  }
    System.out.println(ip);
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
      
      
      function saveDefaultIP(){
			var ipname = $("#atten_ipname").val();
			var ipaddr = $("#atten_ipaddr").val();
			//alert(ipname+ipaddr);
			var url22 = url + '/saveDefaultIP';
			spinnerstart();
			$.ajax({
				type : 'POST', // 用POST方式传输
				url : url22, // 目标地址
				datatype : "html",
				data : {
					"ipname" : ipname,
					"ipaddr" : ipaddr
				},
				cache : false,
				success : function(data) {
					var str = eval("(" + data + ")");
					alert("操作成功！！");
					if($("#noinfos").html()==""){
						$("#strnoinfos").remove();
					}
					var t1 = '<tr id="' + str.id + '"><td>'+str.ipname+'</td><td>'+str.ipaddr+'</td>';
				    var t2 = '<td>'+str.time+'</td><td>'+str.operator+'</td>';
				    var t3 = '<td><a href="javascript:void(0)" style="text-decoration: none;" onclick="deletethisipByid(\''+str.id+'\')">删除</a></td></tr>';
					var t = t1 + t2 + t3;
				    $("#atten_IPbody").append(t);
					$("#modal-container-184755").modal("hide");
					spinnerend();
				},
				error : function(data) {
					alert("操作失败，请刷新后重新操作！！");
					spinnerend();
				}
			});
			spinnerend();
		}
		function deletethisipByid(id){
	var url22 = url + '/deletethisipByid';
	spinnerstart();
	if (confirm("您确定要删除这条信息吗?")) {
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url22, // 目标地址
			datatype : "html",
			data : {
				"id" : id
			},
			cache : false,
			success : function(data) {
				var str = eval("(" + data + ")");
				alert("操作成功！！");
				if($("#noinfos").html()==""){
					$("#strnoinfos").remove();
				}
				$("#"+id).remove();
				if(str.sizenum=="no"){
					var t = '<tr id="strnoinfos"><td>无内容...</td><td id="noinfos"></td><td></td><td></td><td></td></tr>';
					 $("#atten_IPbody").html(t);
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}
	spinnerend();
}
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
						<span>考勤管理>>IP设置</span>
						
						<span class="navbar-right" style="margin-right: 5px;">
						    <button type="button" class="btn btn-info btn-default btn-xs" data-toggle="modal" data-target="#modal-container-184755"> 添&nbsp;加 </button>
						</span>
						<!-- 导出开始 -->
						<div class="modal fade" id="modal-container-184755" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">
											添加默认IP
										</h4>
									</div>
									<div class="modal-body">
										<div class="form-horizontal" role="form" >
							
											<div class="form-group">
												<label style="font-size: 14px;" class="col-sm-3 control-label">IP名称：</label>
											    <div class="col-sm-6">
											      <input class="form-control" id="atten_ipname"  type="text" onKeyDown="LimitTextArea36(this)" placeholder="请输入IP名称">
											    </div>
											</div>	
											<div class="form-group">
												<label style="font-size: 14px;" class="col-sm-3 control-label">IP地址：</label>
											    <div class="col-sm-6">
											      <input class="form-control" value="<%=ip %>" id="atten_ipaddr"  type="text" onKeyDown="LimitTextArea36(this)" placeholder="xxx.xxx.xxx.xxx">
											    </div>
											</div>
										</div>	
									</div>
									<div class="modal-footer">
										 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
										 <button type="button" onclick="saveDefaultIP()" class="btn btn-primary">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 导出结束 -->
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<table class="table table-hover" style="font-size: 13px;">
						  <thead>
						    <tr>
						      <th>IP名称</th>
						      <th>IP地址</th>
						      <th>更新时间</th>
						      <th>操作人</th>
						      <th>操作</th>
						    </tr>
						  </thead>
						  <tbody id="atten_IPbody">
						  <%
						  if(dip!=null &&dip.size()>0){
						   System.out.println("ssssdfs");
						  	for(DefaultIP d : dip){
						   %>
						    <tr id="<%=d.getId() %>">
						      <td><%=d.getIpname() %></td>
						      <td><%=d.getIpaddr() %></td>
						      <td><%=d.getTime() %></td>
						      <td><%=d.getOperator() %></td>
						      <td><a href="javascript:void(0)" style="text-decoration: none;" onclick="deletethisipByid('<%=d.getId() %>')">删除</a></td>
						    </tr>
						    <%
						    }
						  }else{
						  System.out.println("ssss");
						     %>
						     <tr id="strnoinfos">
						      <td>无内容...</td>
						      <td id="noinfos"></td>
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
				<!-- 我的考勤 -->
			</div>
		</div>
</div>
  </body>
</html>
