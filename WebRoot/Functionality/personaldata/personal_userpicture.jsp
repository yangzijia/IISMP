<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
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
	<link rel="stylesheet" href="css/css/style.css" type="text/css" />
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
						<span>头像修改</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
					<script type="text/javascript" src="js/cropbox.js"></script>
						<div >
						  <div class="imageBox">
						    <div class="thumbBox"></div>
						    <div class="spinner" style="display: none">Loading...</div>
						  </div>
						  <div class="action"> 
						    <!-- <input type="file" id="file" style=" width: 200px">-->
						    <div class="new-contentarea tc"> <a href="javascript:void(0)" class="upload-img">
						      <label for="upload-file">上传图像</label>
						      </a>
						      <input type="file" class="" name="upload-file" id="upload-file" />
						    </div>
						    <input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+"  >
						    <input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-" >
						    <input type="button" id="btnCrop"  class="Btnsty_peyton" value="裁切">
						    <input type="button"  class="Btnsty_peyton" onclick="savePictureSrcinfo()" value="确定" >
						  </div>
						  <div class="cropped"></div>
						</div>
						<script type="text/javascript">
						var url = 'http://' + window.location.host + '/IISMP';
function savePictureSrcinfo(){
	var pictureSrcInfo = $("#picturename")[0].src; 
	var url22 = url + '/savePictureSrcinfo';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"pictureSrcInfo" : pictureSrcInfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			window.location.href=url + '/Functionality/personaldata/personal_index.jsp';
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}
						$(window).load(function() {
							var options =
							{
								thumbBox: '.thumbBox',
								spinner: '.spinner',
								imgSrc: 'images/avatar.png'
							}
							var cropper = $('.imageBox').cropbox(options);
							$('#upload-file').on('change', function(){
								var reader = new FileReader();
								reader.onload = function(e) {
									options.imgSrc = e.target.result;
									cropper = $('.imageBox').cropbox(options);
								}
								reader.readAsDataURL(this.files[0]);
								this.files = [];
							})
							$('#btnCrop').on('click', function(){
								var img = cropper.getDataURL();
								$('.cropped').html('');
								$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
								$('.cropped').append('<img src="'+img+'" id="picturename" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
								$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
							})
							$('#btnZoomIn').on('click', function(){
								cropper.zoomIn();
							})
							$('#btnZoomOut').on('click', function(){
								cropper.zoomOut();
							})
						});
						</script>
						
						
					</div>	
				</div>
				<!-- 全部公告 -->
			</div>
		</div>
</div>
  </body>
</html>
