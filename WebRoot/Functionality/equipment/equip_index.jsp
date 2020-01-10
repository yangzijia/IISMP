<%@page import="com.hp.hpl.sparta.Document"%>
<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Equipment_Info> einfo=(List<Equipment_Info>)request.getAttribute("e_ment");
List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
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
    <!-- 日期显示 -->
    <link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
	<script type="text/javascript" src="js/pikaday.min.js"></script>
    <!-- 树形列表  -->
	<link rel="stylesheet" type="text/css" href="css/update8.css"/>
	
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
	         $("a[lang=5]").addClass("pre");//设置选中的
	         $("a[lang=5]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
	     </script>
		
    <style>
	  ul{margin-top:0px;list-style:none;}
	  .ba {padding:1px 6px;font-size:13px;}
	  .col {margin-top:6px;}
	  .color {color:#4C9ED9;}
	  .list-group-item {border-top: 1px solid #ddd;}
	  .do {height:60px;overflow:auto;}
	  .list-group-item:hover{background-color:#F0F0F0;}
	  .thumbnail a:hover img{
	    -webkit-transform:scale(1.2,1.2);
	    -moz-transform:scale(1.2,1.2);
	    -transform:scale(1.2,1.2);
	    }
	    .ren {float:right;margin-top:5px;}
	</style>
  </head>
  
<body style="background-color: #EDEFF0">

<!-- 导航栏开始 -->
<jsp:include page="../navigation.jsp"></jsp:include>
<!-- 导航栏结束 -->

<!-- 主界面   -->
<div class="container"  style="margin-top:60px;">
	<div class="row clearfix">
	   <div class="row clearfix">
			
				<jsp:include page="equip_navigation.jsp"></jsp:include>
				
				<!-- 全部设备开始-->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						全部设备	
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted;">
					
					<div  class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
				   
				    <div class="row">
				    <!-- 缩略图开始 -->
				   
				    <%
				    if(einfo!=null&&einfo.size()>0){
				    	int i=0;
				    	for(;i<einfo.size();i++){
				    		Equipment_Info e=einfo.get(i);
				    		
				  		  %>
				     
						<div class="col-md-4">
							<div class="thumbnail">
								<a href="javascript:void(0);"><img alt="300x200" src="<%=e.getE_image()%>" style="width:300px;height:160px;"></a>
								<div class="caption">
									<h4>
										<span class="p13-999 ren" ><%=e.getE_principal() %></span>
									</h4>
									<p>
										<%=e.getE_precautions() %>
									</p>
									<p>
										<a href="javascript:void(0);" onclick="findEinfobyid(<%=e.getE_id()%>)"	class="btn btn-primary ba" data-toggle="modal" data-target="#modal-container-72255">查看详情</a> 
									</p>
								</div>
							</div>
				        </div>
				<%
				if(i%3==0&&i>3*i){
				%>
				       
				         <div class="col-md-4">
							<div class="thumbnail">
								<a href="javascript:void(0);"><img alt="300x200" src="img/<%=e.getE_image() %>" style="width:300px;height:160px;"></a>
								<div class="caption">
									<h4>						
										<span class="p13-999 ren" ><%=e.getE_principal() %></span>
									</h4>
									<p>
										<%=e.getE_precautions() %>
									</p>
									<p>
										<a href="javascript:void(0);" onclick="findEinfobyid(<%=e.getE_id()%>)"	class="btn btn-primary ba" data-toggle="modal" data-target="#modal-container-72255">查看详情</a> 
									</p>
								</div>
							</div>
				          </div>
				     
				    
				  	  <%
				}
				    	}
				    }else{
							%>
						<tr>
							<td>暂无信息...</td>
							<td></td>
							<td></td>
							<td></td>	
						</tr>
						
					<%
					}
					%>
					<!-- 缩略图结束 -->
					
					<!-- 查看详情开始  -->
					<div class="modal fade" id="modal-container-72255" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
					   <div class="modal-content">
						 <div class="modal-header">
						   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						    <h4 class="modal-title" id="myModalLabel">
								TV电视
							</h4>
						 </div>
						<div class="modal-body" style="font-size: 13px;">
							<form class="form-horizontal" role="form">
							  <div class="form-group">
							    <div class="col-sm-1"></div>
							    <div class="col-sm-10">
							      <img alt="300x200" id="imgid" src="img/girl.jpg" style="width:470px;height:150px;"/>
							    </div>
							    <div class="col-sm-1"></div>
							  </div>
							  <div class="form-group"  >
							     <label for="firstname" class="col-sm-3 control-label"	>设备型号：</label>
							     <div class="col-sm-8 col" id="e_pattern">
							     </div>
							  </div>
							  <div class="form-group">
							  	<label  for="name" class="col-sm-3 control-label">购买时间：</label>
							    <div class="col-sm-8 col" 	id="e_buytime">
							     
							    </div>
							  </div>  
	                          <div class="form-group">
							    <label for="firstname" class="col-sm-3 control-label">设备价格：</label>
							    <div class="col-sm-8 col" 	id="e_price">
							      
							    </div>
							 </div>
							 <div class="form-group">
							    <label class="col-sm-3 control-label">购买人：</label>
							    <div class="col-sm-8 col"	 id="e_purchaser">
							                  
							    </div>
							 </div>
							 <div class="form-group">
							    <label class="col-sm-3 control-label">负责人：</label>
							    <div class="col-sm-4 col" id="e_principal">
							               
							    </div>										    
							 </div>
							 <div class="form-group">
							    <label class="col-sm-3 control-label">最近维修 ：</label>
							    <div class="col-sm-4 col"	 id="e_checktime">
							         
							    </div>										    
							 </div>
							 <div class="form-group">
							   <label for="firstname" class="col-sm-3 control-label">应用事项：</label>
							   <div class="col-sm-8 col"	 id="e_precautions">
							    
							   </div>
							 </div>
				         </form>	
						</div>
				   	  </div>
					 </div>	
					</div>				
					<!-- 查看详情结束  -->
	
					</div>
				</div>
			</div>
    		<!-- 弹框结束 -->
	
			</div>		
	     </div>
	</div>
</div>									
  </body>
</html>
