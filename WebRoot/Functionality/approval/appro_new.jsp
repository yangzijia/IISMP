<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo mm = (MembershipInfo)session.getAttribute("memberinfo");
List<Section> section=(List<Section>)session.getAttribute("sectioninfo");
List<MembershipInfo> allmem=(List<MembershipInfo>)session.getAttribute("allmember");
List<Approval> approval=(List<Approval>)session.getAttribute("approval");
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
   
    <link rel="Shortcut icon" href="img/favicon.ico">   
   <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/dzjs.js" type="text/javascript"></script>
    <link href="css/wllcss.css" rel="stylesheet">
    
    <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
	<!-- 树形列表  -->
	<link rel="stylesheet" type="text/css" href="css/update8.css"/>
    
    <!-- 下划线跟随效果 -->
    <link href="css/nav-animation.css" rel="stylesheet" type="text/css" />  
	    
	    <!-- 导航选中效果 -->
	    <script type="text/javascript">
	      $(function(){
	         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
	         $("a[lang=7]").addClass("pre");//设置选中的
	         $("a[lang=7]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
	     </script>
    <style>
      td a:hover {text-decoration:none;color:#1C18EC;}
	  ul{margin-top:0px;list-style:none;}
	  .yellow {color:#E5DE14;}
	  .green {color:#52E633;}
	  .red {color:red;}
	  .top {margin-top:5px;}
	  #tree .treeview {width:60%;height:80%;align:center;}
	  .del {font-weight:normal;}
      .do {height:351px;overflow:auto;border:none;}
	  .list-group-item {border-radius:4px;}
	  .list-group-item0 {border-radius:4px;}  
	  .list-group-item:hover{background-color:#F0F0F0;}
	</style>
	
  </head>
  
<body style="background-color: #EDEFF0;">

<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
	   <div class="row clearfix">
			
				<jsp:include page="appro_navigation.jsp"></jsp:include>
				
				<!-- 新建申请开始-->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						新建申请
					  <span style="float:right;">
					    <button type="button" class="btn btn-info btn-xs" onclick="gopage('Functionality/approval/appro_index.jsp')" value="跳转">&nbsp;返回&nbsp;</button>&nbsp;	
				      </span>
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted;">
                	<div style="overflow-x:hidden; height:498px; "> 
	
						<!-- form表 开始 -->    
						  <form class="form-horizontal" action="addApply" method="post" enctype="multipart/form-data" role="form"> 
					    	  <div class="form-group" >
					    	    <label for="firstname" class="col-sm-2 control-label" name="tyepname" >申请类型：</label>
							    <div class="col-sm-2 top">
						 			<input name="approval_type" class="form-control"   id="types"></input>
							    </div>
							  </div>
							  <div class="form-group">
							   <label for="firstname"  class="col-sm-2 control-label">申请人：</label>
						    		<div class="col-sm-2 top">
							 	 <input class="form-control" name="apply_member"  value="<%=mm.getM_truename()%>"></input> 
							 </div>
							 </div>
							 <div class="form-group">
							   <label for="firstname" class="col-sm-2 control-label">申请部门：</label>
							   <div class="col-sm-2 top">
							   <input class="form-control"  name="member_section" value="<%=mm.getM_sectionname()%>"></input> 
							   </div>
							 </div>
							 <div class="form-group">
							   <label for="firstname"  class="col-sm-2 control-label"><span class="red">*&nbsp;</span>申请内容：</label>
							   <div class="col-sm-6">
							    <textarea  id="okinfo"  name="apply_info" class="form-control" rows="3" 	></textarea>
							   </div>
							 </div>
						     <div class="form-group">
							   <label for="firstname"  class="col-sm-2 control-label">上传附件：</label>
							     <span style="float:left;margin:0px;">
							   <input type="file" data-min-file-count="1"  name="myFile">
							   </span>
							 
							   <div class="col-sm-7" id="upload">
								  <div class="form-group" style="margin:0;"> 
						           <span style="float:left;margin:0px;">
						             <input id="file-0a" class="file"  data-min-file-count="1" type="file"> 
						           </span>
								   <span style="float:left;margin-top:3px;">
								     &nbsp;&nbsp;&nbsp;&nbsp;
						            <button type="reset" class="btn btn-info btn-xs" style="background-color:#F1F1F1;color:#7D7D7D;border-color:#CCC;">重置</button>
	                         	   </span>			     
  							      </div>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="firstname" class="col-sm-2 control-label"><span class="red">&nbsp;</span>审批人：</label>
							    <div class="col-sm-3"	>
							       <input type="text" name="approval_member" id="apman" class="form-control uname " placeholder="请选择审批人" data-toggle="modal" data-target="#modal-container-722555"/>
							    </div>
							  </div>
							  <tr>
				  		 <div class="col-sm-6">	<td><input  class="btn btn-default btn-info" type="submit" value="上传"></td>
				  			<div class="col-sm-2"></div>  <td><input class="btn btn-default" type="reset"></td></div>
				  			</tr>
						    </form>	    	  
						  <br />
						
			           </div>									 
	     	      </div>	              	                 	
				 </div>
				<!-- 新建申请结束 -->
	
				<!-- 弹框开始 -->
				<div class="modal fade" id="modal-container-722555" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				   <div class="modal-content">
					 <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
							详细信息
						</h4>
					  </div>						  
					 <div class="modal-body" style="font-size: 13px;height:468px;">
					    <div class="col-md-7">
					      
					      <div class="col-md-12">
					        <div style="height:100%;">
					         <!-- 搜索框开始 -->
					         <div class="input-group"  style="box-shadow: 0 1px 1px rgba(0, 0, 0, .05);border-radius: 4px;">
			                    <input type="text"  placeholder="请输入审批人姓名" class="form-control input-sm" style="width: 100%;">
			                    <span class="input-group-btn">
			                       <button class="btn btn-default btn-sm" type="button">查找</button>
			                    </span>
			                 </div>
					         <!-- 搜索框结束 -->
				      
							<!-- 选择框开始 -->
							<div class="tab" style="height:400px;width:100%;border:1px solid #ccc;margin-top:5px;box-shadow: 0 1px 1px rgba(0, 0, 0, .05);border-radius: 4px;">
							  <div id="tree" style="width:100%;">
							    <ul class="nav nav-tabs">
								  <li class="active">
								    <a href="#" style="color:#31B0D5;font-weight:700;border-top:2px solid #31B0D5;">人员</a>
								  </li>
							    </ul>
							   </div> 
							    <!-- 树列表开始 -->  
                                <div class="pnav-cnt do" style="width:100%;border:none;margin-top:6px;">
							       <% 
			             	if(section!=null&&section.size()>0){
			             		for(int i=0;i<section.size();i++){
			             			Section s=section.get(i);
			             			%>	
							      <div class="pnav-box">
							    
									<div class="box-title list-group-item0" id="let" >
									  <input type="checkbox" value="javaweb组"/>
									  <label class="pnav-letter">&nbsp;&nbsp;<%=s.getSection_name() %></label>
									</div>
									<%
								if(mm!=null&&allmem.size()>0){
			             			for(int j=0;j<allmem.size();j++){
			             				MembershipInfo m=allmem.get(j);
			             			if(m.getM_sectionname().equals(s.getSection_name())){
								%>
									<ul class="box-list" id="letto">									  
									  <li class="list-group-item">
									      <label class="del"  >
									          <input type="checkbox" name="checkbox"  value="<%=m.getM_truename()%>"/>
									          &nbsp;&nbsp;<%=m.getM_truename() %>
									      </label>  							     
									  </li> 
									</ul>
									<%
			             			}
								}
								}
								%>
								  </div>
								<%
						       	}
						             	}
									   %>
								    
								 </div>
								 <script type="text/javascript">
								    //滑动

								    $(".box-list").hide();
									$(".box-title").click(function(){ 
					                   $(this).parent().find('.box-list').slideToggle()})

								 </script>
					        </div>
					      
						    <!-- 树列表结束 -->	
						</div>			
				     </div>
				  </div>
								 
				<!-- 选择框结束 -->
				  
				<div class="col-md-5" >
				  <!-- 已选框 -->
				  <div class="col-md-12" >
				      <div class="panel panel-default"  style="width:130%;height:99.3%;margin-left:-50px;">
						<div class="panel-heading">
						   <span>已选审批人</span>
						   <span class="lot"  style="color:red;display:none;">已超出（<span class="shu"> </span>人）</span>
						   <span class="clear" style="float:right;cursor:pointer;">清空</span>
						</div>
						<div class="panel-body"  id="nm"  value="">
						   
						</div>
					  </div>
				  </div>
				</div>				
                <script>
                 //获取人名

                 $(document).ready(function(){
					$("li").click(function(){   // 将所有选中的复选框通过函数返回值生成新的jQuery 对象,显示出的是input中value的内容
					  text = $("input:checkbox[name='checkbox']:checked").map(function(index,elem) {
					      return $(elem).val();  
					  }).get().join(" <br /> ");
					  $(".panel-body").html(text);  //显示人名
					  
					  if($(':checkbox:checked').length-1<1){    //判断超出人数
					     $(".lot").hide();  
                      }else{
                         $(".lot").show();
                         $(".shu").html($(':checkbox:checked').length-1);  //显示超出人数
                      }                     
					});
					
				    $(".clear").click(function(){    //清空人名
				       $(".panel-body").empty();
				    });
				 }); 				

                </script>
	       </div>
	       <div class="modal-footer">
		      <button type="button" class="btn btn-default" data-dismiss="modal">取消</button> 
		      <button type="button" id="btn" class="btn btn-primary btn">确定</button>
	       </div>
	       </div>
	       <script>
	          $(document).ready(function(){
	             //点击确定，input显示选中人名
                 $("#btn").click(function(){
	                 con = $("#nm").html();    //获取选中的人名
	                 if($(':checkbox:checked').length>0 && $(':checkbox:checked').length<2 ){    //判断是否有选中的人名
	                   $("#apman").val(con);          //将选中的人名传到input中
			           $("#modal-container-722555").modal("hide");      //隐藏模态框
	                 }else{
	                   alert('请选择一位审批人！');
	                 }   
		         });
	          });
	        </script>
	     </div>
	  </div>
   </div>
</div>

<script>
function gopage(url) {
if (confirm('您确定要放弃此次申请吗？')) {
location.href = url;
}
}
</script>
<script type="text/javascript">
	document.getElementById('upload').style.display = "none";
	document.getElementById('checkbox').style.display = "";
	function show(){
	  document.getElementById('upload').style.display = "";
	  document.getElementById('checkbox').style.display = "none";
	}
</script>
  </body>
</html>
