
<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");

if(mi.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
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
	<script type="text/javascript">
	 $(function(){
		// alert("asddasda");
 	 	$("#tijiaoneirong").hide(); 
 	 	$("#beizhuneirong").hide(); 
 	 	$("#tijiaoQQhao").hide();
 	 	$("#youxiang2").hide(); 
 	 	$("#tijiaobanji").hide();
 	 	$("#editQQinfo").hide();
 	 	$("#editphoneinfo").hide();
 	 	$("#editclassnameinfo").hide();
 	 	$("#editremarkinfo").hide();
 	 	$("#editemailinfo").hide();
 	 	$("#password").val("");
		$("#newpassword").val("");
		$("#lastpassword").val("");
 	 	<%
 	 	if(!mi.getM_userpicture().equals("-")){
 	 	%>
 	 		var path = '<%=mi.getM_userpicture()%>';
 	 		//alert(path);
 	 		$("#imgId").attr('src',path); 
 	 	<%
 	 	}
 	 	%>
  	});
	</script>
	
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
				<jsp:include page="personal_navigation.jsp"></jsp:include>
						
				<!-- 全部公告 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>个人设置</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
						<div class="col-md-7 column">
							<span class="p13-999" style="margin-left: -20px;">基本信息</span>
							<span class="p13-999">
								--------- ---------- --------- -------- ------- ------ ----- ---- --- -- - - - - - 
							</span>
							<br><br>
							<div class="form-horizontal" style="font-size: 13px;">
								<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999" >姓名：</span></label>
							    	<div class="col-sm-9">
							      		<span><%=mi.getM_truename() %></span>
							    	</div>
							  	</div>
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">姓别：</span></label>
							    	<div class="col-sm-9">
							      		<%=mi.getM_sex() %>
							    	</div>
							  	</div>
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">分组：</span></label>
							    	<div class="col-sm-9">
							      		<%=mi.getM_sectionname() %>
							    	</div>
							  	</div>
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">职务：</span></label>
							    	<div class="col-sm-9">
							      		<%=mi.getM_role() %>
							    	</div>
							  	</div>
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">QQ号：</span></label>
							    <%
							    if(mi.getM_qqchat().equals("-")){
							    %>
							    	<!-- 如果qq号为空 -->
								    	<div id="tianjiaqq">
								    		<div class="col-sm-9">
							      				 <button type="button" onclick="hidethis11();" class="btn btn-link btn-xs">
							      				 	<span style="margin-left: -5px;">添加QQ号</span>
							      				 </button>
								    		</div>
								    	</div>
								    	<div id="tijiaoQQhao">
									    	<div class="col-sm-6">
									      		<input type="text" id="newqqid" class="form-control input-sm" placeholder="请输入QQ号">
									    	</div>
									    	<div class="col-sm-4">
									    		<button onclick="addqqmethod();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
									    		<button onclick="hidequxiao11();" class="btn btn-default btn-sm" type="button">取消</button>
									    	</div>
								    	</div>
								    	<script type="text/javascript">
								    	 function hidethis11(){
								    		 $("#tijiaoQQhao").show(); 
								    		 $("#tianjiaqq").hide(); 
								    	 }
								    	 function hidequxiao11(){
								    		 $("#tijiaoQQhao").hide(); 
								    		 $("#tianjiaqq").show();
								    	 }
								    	</script>
								    <!-- 如果qq号为空 -->
								    <%
							    }else{
								    %>
								    <div id="editQQ">
									    <div class="col-sm-6">
								      		<span id="qqchatid"><%=mi.getM_qqchat() %></span>
								    	</div>
								    	<div class="col-sm-2">
									    	<a href="javascript:void(0);" onclick="editqqmethod();" style="text-decoration: none;"><img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改"></a>
								    	</div>
							    	</div>
							    	<div id="editQQinfo">
							    		<div class="col-sm-6">
								      		<input type="text" id="editqqid" class="form-control input-sm" placeholder="请输入QQ号">
								    	</div>
								    	<div class="col-sm-4">
								    		<button onclick="updateqqchat();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
								    		<button onclick="quxiaoeditqq();" class="btn btn-default btn-sm" type="button">取消</button>
								    	</div>
							    	</div>
							    	<script type="text/javascript">
							    	function editqqmethod(){
							    		var qqinfo = $("#qqchatid").html();
							    		
							    		$("#editqqid").val(qqinfo);
							    		$("#editQQinfo").show();
							    		$("#editQQ").hide();
							    	}
							    	function quxiaoeditqq(){
							    		$("#editQQinfo").hide();
							    		$("#editQQ").show();
							    	}
							    	</script>
							    	<%
							    }
							    	%>
							  	</div>
								<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">手机：</span></label>
							    <%
							    if(mi.getM_phone().equals("-")){
							    %>
							    	
							    	<!-- 如果手机号为空 -->
								    	<div id="lianjie">
								    		<div class="col-sm-9">
							      				 <button type="button" onclick="hidethis();" class="btn btn-link btn-xs">
							      				 	<span style="margin-left: -5px;">添加手机号码</span>
							      				 </button>
								    		</div>
								    	</div>
								    	<div id="tijiaoneirong">
									    	<div class="col-sm-6">
									      		<input type="text" id="newphoneid" class="form-control input-sm" placeholder="请输入手机号">
									    	</div>
									    	<div class="col-sm-4">
									    		<button onclick="addphonemethod();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
									    		<button onclick="hidequxiao();" class="btn btn-default btn-sm" type="button">取消</button>
									    	</div>
								    	</div>
								    	<script type="text/javascript">
								    	 function hidethis(){
								    		 $("#tijiaoneirong").show(); 
								    		 $("#lianjie").hide(); 
								    	 }
								    	 function hidequxiao(){
								    		 $("#tijiaoneirong").hide(); 
								    		 $("#lianjie").show();
								    	 }
								    	</script>
								    <!-- 如果手机号为空 -->
								    <%
							    }else{
								    %>
							    	<div id="editphone">
									    <div class="col-sm-6">
								      		<span id="phonechatid"><%=mi.getM_phone() %></span>
								    	</div>
								    	<div class="col-sm-2">
									    	<a href="javascript:void(0);" onclick="editphonemethod();" style="text-decoration: none;"><img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改"></a>
								    	</div>
							    	</div>
							    	<div id="editphoneinfo">
							    		<div class="col-sm-6">
								      		<input type="text" id="editphoneid" class="form-control input-sm" placeholder="请输入手机号">
								    	</div>
								    	<div class="col-sm-4">
								    		<button onclick="updatephonechat();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
								    		<button onclick="quxiaoeditphone();" class="btn btn-default btn-sm" type="button">取消</button>
								    	</div>
							    	</div>
							    	<script type="text/javascript">
							    	function editphonemethod(){
							    		var phoneinfo = $("#phonechatid").html();
							    		$("#editphoneid").val(phoneinfo);
							    		$("#editphoneinfo").show();
							    		$("#editphone").hide();
							    	}
							    	function quxiaoeditphone(){
							    		$("#editphoneinfo").hide();
							    		$("#editphone").show();
							    	}
							    	</script>
								    <%
							    }
								    %>
							  	</div>
							  	
							  	
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">班级：</span></label>
							    <%
							    if(mi.getM_classname().equals("-")){
							    %>
							  	<!-- 如果所在班级为空 -->
								    	<div id="lianjiebanji">
								    		<div class="col-sm-9">
							      				 <button type="button" onclick="hidethisbanji();" class="btn btn-link btn-xs">
							      				 	<span style="margin-left: -5px;">添加所在班级</span>
							      				 </button>
								    		</div>
								    	</div>
								    	<div id="tijiaobanji">
									    	<div class="col-sm-6">
									      		<input type="text" id="newclassnameid" class="form-control input-sm" placeholder="请输入班级名称">
									    	</div>
									    	<div class="col-sm-4">
									    		<button onclick="addclassnamemethod();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
									    		<button onclick="hidequxiaobanji();" class="btn btn-default btn-sm" type="button">取消</button>
									    	</div>
								    	</div>
								    	<script type="text/javascript">
								    	
								    	 function hidethisbanji(){
								    		 $("#tijiaobanji").show(); 
								    		 $("#lianjiebanji").hide(); 
								    	 }
								    	 function hidequxiaobanji(){
								    		 $("#tijiaobanji").hide(); 
								    		 $("#lianjiebanji").show();
								    	 }
								    	</script>
								    <!-- 如果如果所在班级为空 -->
								    <%
							    }else{
								    %>
							    	<div id="editclassname">
									    <div class="col-sm-6">
								      		<span id="classnameid"><%=mi.getM_classname() %></span>
								    	</div>
								    	<div class="col-sm-2">
									    	<a href="javascript:void(0);" onclick="editclassnamemethod();" style="text-decoration: none;"><img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改"></a>
								    	</div>
							    	</div>
							    	<div id="editclassnameinfo">
							    		<div class="col-sm-6">
								      		<input type="text" id="editclassnameid" class="form-control input-sm" placeholder="请输入QQ号">
								    	</div>
								    	<div class="col-sm-4">
								    		<button onclick="updateclassname();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
								    		<button onclick="quxiaoeditclassname();" class="btn btn-default btn-sm" type="button">取消</button>
								    	</div>
							    	</div>
							    	<script type="text/javascript">
							    	function editclassnamemethod(){
							    		var classnameinfo = $("#classnameid").html();
							    		$("#editclassnameid").val(classnameinfo);
							    		$("#editclassnameinfo").show();
							    		$("#editclassname").hide();
							    	}
							    	function quxiaoeditclassname(){
							    		$("#editclassnameinfo").hide();
							    		$("#editclassname").show();
							    	}
							    	</script>
							    	<%
							    }
							    	%>
							  	</div>
							  	
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999">备注：</span></label>
							    <%
							    if(mi.getM_utpitp().equals("-")){
							    %>
							    	<!-- 如果备注为空 -->
							    	<div id="beizhuwenzi">
							    		<div class="col-sm-9">
						      				 <button type="button" onclick="hidezhu();" class="btn btn-link btn-xs">
						      				 	<span style="margin-left: -5px;">添加备注信息</span>
						      				 </button>
							    		</div>
							    	</div>
							    	<div id="beizhuneirong">
								    	<div class="col-sm-6">
								      		<textarea class="form-control" id="newremark" rows="3"></textarea>
								    	</div>
								    	<div class="col-sm-4">
								    		<br><br><br>
								    		<button onclick="addnewremark();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
								    		<button onclick="hidebei();" class="btn btn-default btn-sm" type="button">取消</button>
								    	</div>
								    </div>
								    <script type="text/javascript">
							    	 	
							    	 function hidezhu(){
							    		 $("#beizhuneirong").show(); 
							    		 $("#beizhuwenzi").hide(); 
							    	 }
							    	 function hidebei(){
							    		 $("#beizhuneirong").hide(); 
							    		 $("#beizhuwenzi").show();
							    	 }
								    </script>
								    <!-- 如果备注为空 -->
								<%
							    }else{
								%>
							    	<div id="editremark">
									    <div class="col-sm-6">
								      		<span id="remarkid"><%=mi.getM_utpitp() %></span>
								    	</div>
								    	<div class="col-sm-2">
									    	<a href="javascript:void(0);" onclick="editremarkmethod();" style="text-decoration: none;"><img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改"></a>
								    	</div>
							    	</div>
							    	<div id="editremarkinfo">
							    		<div class="col-sm-6">
								      		<!-- <input type="text" id="editremarkid" class="form-control input-sm" placeholder="请输入QQ号"> -->
								    		<textarea class="form-control" id="editremarkid" rows="3"></textarea>
								    	</div>
								    	<div class="col-sm-4">
								    	<br><br><br>
								    		<button onclick="updateremark();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
								    		<button onclick="quxiaoeditremark();" class="btn btn-default btn-sm" type="button">取消</button>
								    	</div>
							    	</div>
							    	<script type="text/javascript">
							    	function editremarkmethod(){
							    		var remarkinfo = $("#remarkid").html();
							    		$("#editremarkid").val(remarkinfo);
							    		$("#editremarkinfo").show();
							    		$("#editremark").hide();
							    	}
							    	function quxiaoeditremark(){
							    		$("#editremarkinfo").hide();
							    		$("#editremark").show();
							    	}
							    	</script>
								<%
							    }
								%>
							  	</div>
							 </div>
							 <span class="p13-999" style="margin-left: -20px;">账号信息</span>
								<span class="p13-999">
									--------- ---------- --------- -------- ------- ------ ----- ---- --- -- - - - - - 
								</span>
							<br><br>
							<div class="form-horizontal" style="font-size: 13px;">
								<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999" >账号：</span></label>
							    	<div class="col-sm-9">
							      		<span><%=mi.getM_username() %></span>
							    	</div>
							  	</div>
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999" >邮箱：</span></label>
							    <%
							    if(mi.getM_email().equals("-")){
							    %>
							    	<!-- 如果邮箱为空 -->
								    	<div id="youxiang1">
								    		<div class="col-sm-9">
							      				 <button type="button" onclick="youxiang3();" class="btn btn-link btn-xs">
							      				 	<span style="margin-left: -5px;">添加邮箱</span>
							      				 </button>
								    		</div>
								    	</div>
								    	<div id="youxiang2">
									    	<div class="col-sm-6">
									      		<input type="text" id="newemailid" class="form-control input-sm" placeholder="请输入email">
									    	</div>
									    	<div class="col-sm-4">
									    		<button onclick="addnewemail();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
									    		<button onclick="youxiang4();" class="btn btn-default btn-sm" type="button">取消</button>
									    	</div>
								    	</div>
								    	<script type="text/javascript">
								    	 function youxiang3(){
								    		 $("#youxiang2").show(); 
								    		 $("#youxiang1").hide(); 
								    	 }
								    	 function youxiang4(){
								    		 $("#youxiang2").hide(); 
								    		 $("#youxiang1").show();
								    	 }
								    	</script>
								    <!-- 如果邮箱为空 -->
								<%
							    }else{
								%>
							    	<div id="editemail">
									    <div class="col-sm-6">
								      		<span id="emailid"><%=mi.getM_email() %></span>
								    	</div>
								    	<div class="col-sm-2">
									    	<a href="javascript:void(0);" onclick="editemailmethod();" style="text-decoration: none;"><img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改"></a>
								    	</div>
							    	</div>
							    	<div id="editemailinfo">
							    		<div class="col-sm-6">
								      		<input type="text" id="editemailid" class="form-control input-sm" placeholder="请输入QQ号">
								    	</div>
								    	<div class="col-sm-4">
								    		<button onclick="updateemail();" class="btn btn-default btn-info btn-sm" type="button">提交</button>
								    		<button onclick="quxiaoeditemail();" class="btn btn-default btn-sm" type="button">取消</button>
								    	</div>
							    	</div>
							    	<script type="text/javascript">
							    	function editemailmethod(){
							    		var emailinfo = $("#emailid").html();
							    		$("#editemailid").val(emailinfo);
							    		$("#editemailinfo").show();
							    		$("#editemail").hide();
							    	}
							    	function quxiaoeditemail(){
							    		$("#editemailinfo").hide();
							    		$("#editemail").show();
							    	}
							    	</script>
								<%
							    }
								%>
							  	</div>
							    <div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999" >密码：</span></label>
							    	<div class="col-sm-6">
							      		********
							    	</div>
							    	<div class="col-sm-2">
								    	<a id="modal-722544" onclick="clearpasswordpage();" href="#modal-container-712543" data-toggle="modal" style="text-decoration: none;"><img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改"></a>
							    	</div>
							  	</div>
							  	<div class="form-group">
							    	<label class="col-sm-2"><span class="p13-999" >时间：</span></label>
							    	<div class="col-sm-9">
							      		<span><%=mi.getM_entermiictime() %></span>
							    	</div>
							  	</div>
				<!-- 弹框开始 -->
		      	<div class="modal fade" id="modal-container-712543" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">
									修改密码
								</h4>
							</div>
							<script type="text/javascript">
							function clearpasswordpage(){
								$("#password").val("");
								$("#newpassword").val("");
								$("#lastpassword").val("");
							}
							function checknowpasswd(){
								var nowpasswd = <%=mi.getM_password()%>;
								//alert(nowpasswd);
								var passwd = $("#password").val();
								if(passwd!=nowpasswd){
									alert("当前密码输入错误！！");
									$("#password").val("");
									return false;
								}
							}
							function checknewpasswd(){
								var passwd = $("#password").val();
								var newpasswd = $("#newpassword").val();
								if(newpasswd==passwd){
									alert("输入新密码不能和当前密码相同！！");
									$("#newpassword").val("");
									return false;
								}
							}
							
							</script>
							<div class="modal-body" style="font-size: 13px;">
								<form class="form-horizontal" role="form">
								  <div class="form-group">
								    <label for="firstname" class="col-sm-2 control-label">当前密码：</label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control input-sm" id="password" onchange="checknowpasswd();" placeholder="请输入当前密码">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">新密码：</label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control input-sm" id="newpassword" onchange="checknewpasswd();" placeholder="请输入新密码">
								    </div>
								  </div>
								  <div class="form-group">
								    <label for="lastname" class="col-sm-2 control-label">确认密码：</label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control input-sm" onchange="checklastpw();" id="lastpassword" placeholder="请确认密码">
								    </div>
								  </div>
								</form>
							</div>
							<div class="modal-footer">
								 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button> 
								 <button type="button" onclick="checklastpw();" class="btn btn-primary btn-sm">保存</button>
							</div>
						</div>
					</div>
				</div>
		      	<!-- 弹框结束 -->
							</div>
						</div>
						<!--  -->
						<div class="col-md-3 column">
							<div align="center">
							<br>
							<img id="imgId" src="userpicture/default-user.png" class="img-responsive" style="border-radius: 50%;width: 150px;height: 150px;margin-top: 20px;margin-bottom: 20px;"/>
								<a href="Functionality/personaldata/personal_userpicture.jsp" style="text-decoration: none;">
									修改头像
								   <!-- <a id="modal-722544" href="#modal-container-7" data-toggle="modal" style="text-decoration: none;" data-original-title="修改">
								   		<img src="img/edit.png" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="修改">
								   		修改头像
								   	</a> -->
								</a>
							</div>
							<!-- 弹框开始 -->
					      	<div class="modal fade" id="modal-container-7" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
													<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												修改头像
											</h4>
										</div>
										<form name="dataForm" class="form-horizontal" role="form"  method="post" action="" enctype="multipart/form-data">
											<div class="modal-body" style="font-size: 13px;">
												<input type="file" name="myFile" id="uploadfile" onchange="fileChange(this);" value="选择头像"/>
											</div>
											<div class="modal-footer">
												 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button> 
												 <button type="submit" onclick="Checkfiles();" class="btn btn-primary btn-sm">保存</button>
											</div>
										</form>
									</div>
								</div>
							</div>
					      	<!-- 弹框结束 -->
						</div>
						<div class="col-md-1 column"></div>
					</div>	
				</div>
				<!-- 全部公告 -->
			</div>
		</div>
</div>
  </body>
</html>

