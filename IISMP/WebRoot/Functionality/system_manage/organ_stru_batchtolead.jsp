<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
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
    
    <script type="text/javascript">
	    function fileChange(target,id) { 
	    	var strFileName = $("#uploadfile").val();
	    	$("#filenames").html(strFileName);
			var fileSize = 0; 
			var filetypes =[".xls",".xlsx"]; 
			var filepath = target.value; 
			var filemaxsize = 1024*2;//100M 
			if(filepath){ 
				var isnext = false; 
				var fileend = filepath.substring(filepath.indexOf(".")); 
				if(filetypes && filetypes.length>0){ 
					for(var i =0; i<filetypes.length;i++){ 
						if(filetypes[i]==fileend){ 
							isnext = true; 
							break; 
						} 
					} 
				} 
				if(!isnext){ 
					alert("文件格式不符合上传要求！\n请上传格式为.xls .xlsx的信息文件"); 
					target.value =""; 
					$("#filenames").html("");
					return false; 
				} 
			}else{ 
				return false; 
			} 
			
			if (isIE && !target.files) { 
				var filePath = target.value; 
				var fileSystem = new ActiveXObject("Scripting.FileSystemObject"); 
				if(!fileSystem.FileExists(filePath)){ 
					alert("文件不存在，请重新输入！"); 
					return false; 
				} 
				var file = fileSystem.GetFile (filePath); 
				fileSize = file.Size; 
			} else { 
				fileSize = target.files[0].size; 
			} 
			
			var size = fileSize / 1024; 
			if(size>filemaxsize){ 
				alert("文件大小不能大于"+filemaxsize/1024+"M！"); 
				target.value =""; 
				$("#filenames").html("");
				return false; 
			} 
			if(size<=0){ 
				alert("文件大小不能为0M！"); 
				target.value =""; 
				$("#filenames").html("");
				return false; 
			} 
		} 
	    
	    function Checkfile(){
	    	var files = $("#uploadfile").val();
	    	var passwd = $("#passwd").val();
	    	if(files==""){
	    		alert("嘿！您老还没选择要上传的文件呢（O_*）");
	    		return false;
	    	}else
	    	if(passwd==""){
	    		alert("嘿！您老还没填写初始密码呢...");
	    		return false;
	    	}else{
	    		document.dataForm.action="commitmemberfile"; 
	    	}
	    }
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
	    
	    <!-- 导航选中效果 -->
	    <script type="text/javascript">
	      $(function(){
	         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
	         $("a[lang=8]").addClass("pre");//设置选中的
	         $("a[lang=8]").css("color","#fff");
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
			
				<!-- 组织结构导航 -->
				<jsp:include page="sys_mana_navigation.jsp"></jsp:include>
				
				<!-- 批量导入 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>批量导入</span>
						<span class="navbar-right" style="margin-right: 5px;">
							 <button type="button" onclick="openallmemberinfo();" class="btn btn-info btn-xs">返回</button>
						</span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:498px; ">
						<br><br>
						<p>1、填写导入员工的信息</p>
						<a href="downloadFile1?filename=uploadmemberdemo.xls" style="text-decoration: none;"><span>下载模板</span></a>
						<br><br>
						<p>2、上传填好的员工信息表 ( 仅支持.xls格式,且文件大小不能超过2M )</p>
						<form name="dataForm" method="post" action="" enctype="multipart/form-data">
						
							<input name="myFile" type="file" onchange="fileChange(this);" id="uploadfile" style="display:none;">
							
	      					<a href="javascript:void(sDialog());" style="text-decoration: none;">上传文件</a>
	      					 &nbsp;&nbsp;<span id="filenames" class="p13-999"></span>
	      					<script language="javascript">
						      function sDialog() {
						    	  //alert("fd");
						           var dataForm = document.forms['dataForm'];
						           dataForm.myFile.click();
						      }
							</script>
							<br><br>
							<p>3、员工初始密码（8-20位字符，不允许输入空格）</p>
							<span>
								<input type="password" name="m_password" style="width: 200px;" class="form-control input-sm" id="passwd" placeholder="请输入初始登陆密码">
							</span>
							<br><br>
							 <button type="submit" onclick="Checkfile();" class="btn btn-primary btn-sm">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下一步&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
						</form>
					</div>	
				</div>
				<!-- 全部职务 -->
			</div>
		</div>
</div>
  </body>
</html>
