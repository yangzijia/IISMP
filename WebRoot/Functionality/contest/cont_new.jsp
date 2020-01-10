 <%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
List<Contest> contest=(List<Contest>)session.getAttribute("contest");
List<Section> section=(List<Section>)session.getAttribute("sections");
List<Project> project=(List<Project>)session.getAttribute("project");
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
	         $("a[lang=6]").addClass("pre");//设置选中的
	         $("a[lang=6]").css("color","#fff");
	         $(".pre").hover(
		      function () {
		        $(this).css({"background-color":"#080808"});
		      }  
		     );
	      }); 
	     </script>
	<style>
	  .ba {padding:1px 6px;}
	  .col {margin-top:6px;}
	  .color {color:#4C9ED9;}
	  .list-group-item {border-top: 1px solid #ddd;border-radius:4px;}
	  .list-group-item0 {border: 1px solid #ddd;border-radius:4px;}
	  .do {height:350px;overflow:auto;float:left;margin-left:-16px;}
	  .list-group-item:hover{background-color:#F0F0F0;}
	  .del {font-weight:normal;}
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
			
				<!-- 左边栏导航 -->
				<jsp:include page="cont_navigation.jsp"></jsp:include>
						
				<!-- 增添比赛开始 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						<span>增添比赛</span>
						<span class="navbar-right" style="margin-right: 5px;">
						  <button type="button" class="btn btn-info btn-xs" onclick="window.location.replace('Functionality/contest/cont_index.jsp');">返回</button>
						</span>							 
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted;">
					<div style="overflow-x:hidden; height:498px; ">
					  
					  <div class="modal-body" style="font-size: 13px;">	
					  <!-- 增添比赛开始 --> 
					  <form class="form-horizontal" role="form">
					      <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">比赛名称：</label>
						     <div class="col-sm-9">
						       <input type="text" class="form-control input-sm" id="cname" placeholder="请输入赛名......" style="width:49%;">
						     </div>
						  </div>
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">参赛项目：</label>
						     <div class="col-sm-5"> 
							    <select class="form-control input-sm" id="pname" style="width:91.55%;">
							     	<%
									if(project!=null  && project.size()> 0){
										for(int i=0;i<project.size();i++){
											Project con = project.get(i);										
									%>			  	
								    <option onclick="javascript:void(0);"  value="<%=con.getProject_name()%>"><%=con.getProject_name()%></option>
								 <%
							    	  }
							      }
								%>
							    </select>								   
						     </div>
						  </div>
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">参赛人员：</label>
						     <div class="col-sm-4">
					           <input type="text" name="res" class="form-control input-sm" id="pmember" placeholder="请输入或选择参赛人员..." style="width:95%;" onclick="showtree()"> 
					         </div> 
					         <div class="col-sm-1" style="margin-left:-30px;margin-top:4px;">
              	               <button type="reset" onclick="tijiao()" class="btn btn-info btn-xs" style="background-color:#F1F1F1;color:#7D7D7D;border-color:#CCC;">重置</button>    
						     </div>
						  </div>
						  <script>  			  
                            $("#pmember").get(0).reset();  /*清空表单 */
		                  </script>
						  <div class="form-group">
						  	<label  for="name" class="col-sm-2 control-label">参赛时间：</label>
						    <div class="col-sm-9 form-inline">
						    <input type="text" class="form-control input-sm" id="ctime" placeholder="****-**-**">
						    </div>
						    <script type="text/javascript">
							    var picker = new Pikaday(
							    {
							        field: document.getElementById('ctime'),
							        firstDay: 1,
							        minDate: new Date('2010-01-01'),
							        maxDate: new Date('2020-12-31'),
							        yearRange: [2000,2020]
							    });
							</script>
						  </div>  
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">参赛地点：</label>
						     <div class="col-sm-9">
						       <input type="text" class="form-control input-sm" id="cplace" placeholder="请输入参赛地址......" style="width:49%;">
						     </div>
						  </div> 
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">大赛网址：</label>
						     <div class="col-sm-9">
						       <input type="text" class="form-control input-sm" id="curl" placeholder="请输入大赛网址......" style="width:49%;">
						     </div>
						  </div> 
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">项目介绍：</label>
						     <div class="col-sm-9">
						       <textarea class="form-control" rows="3" id="projectInfo"></textarea>
						     </div>
						  </div>
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">取得成绩：</label>
						     <div class="col-sm-9">
						       <textarea class="form-control" rows="3" id="p_awads"></textarea>
						     </div>
						  </div>
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">经验心得：</label>
						     <div class="col-sm-9">
						       <textarea class="form-control" rows="3" id="cjingyan"></textarea>
						     </div>
						  </div>						  
						</form>
						      <br />
							  <div class="col-sm-2"></div> 
							  <div class="col-sm-6">
							    <button type="button" class="btn btn-default btn-info"  onclick="addContest()">确定</button>
							    &nbsp; &nbsp;   
					            <button type="button" class="btn btn-default"  onclick="quxiao()" >取消</button> 	  
		                      </div> 
		                      <div class="col-sm-3"></div> 		
		                      <br />
				           <br />			
							</div>
				           </div>	
				           								
						  <!-- 上传文件结束 -->
		     	      </div> 
					</div>	
					
	         		<!-- 树形列表弹框开始 -->
				    <div id="tree" class="tree">
					<div class="col-sm-8">&nbsp;</div>
			        <div class="col-sm-3" style="margin-top:-505px;">
			          <button type="button" class="close" style="color:#000;margin-right:30%;" onclick="Hide()">×</button>
			          <script>
			            function Hide() {
				            var a = document.getElementById("tree");    //login是ID
				            a.style.display = "none";
				        }
			          </script> 			          
                      <div class="pnav-cnt do">
		             	<% 
		             	if(section!=null&&section.size()>0){
		             		for(int i=0;i<section.size();i++){
		             			Section s=section.get(i);		             			
		             	%>
						<div class="pnav-box">
							<div class="box-title list-group-item0" id="let" style="border-buttom: 1px solid #ddd;">
							  <input type="checkbox"/>
							  <label class="pnav-letter">&nbsp;&nbsp;<%=s.getSection_name() %></label>
							</div>
							<%
							if(mm!=null&&mm.size()>0){
		             			for(int j=0;j<mm.size();j++){
		             				MembershipInfo m=mm.get(j);
		             			if(m.getM_sectionname().equals(s.getSection_name())){
							%>
						
							<ul class="box-list" id="letto" style="margin-bottom:0;">
							  <li class="list-group-item" >
							     <label class="del" style="margin-top:7px;">
							       <input type="checkbox" name="kkk" id="p_member" value="<%=m.getM_truename()%>" onclick="test1('<%=m.getM_truename()%>')"/>
							       <%=m.getM_truename()%>
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
				  </div>	
				  </div>
				  <script type="text/javascript">
				            /* $('.list-group-item').click(function(){ 
							   var $input = $(this).find('input'); 
							   $("#kkkk").val($input.val());
							   console.log($input.val())}) */
					   $(function(){
					    $('.list-group-item').click(function(){ 	    
					       text = $("input:checkbox[name='kkk']:checked").map(function(index,elem) {
					            return $(elem).val();           // 将所有选中的复选框通过函数返回值生成新的jQuery 对象
					        }).get().join(' , ');
					       $("#pmember").val(text);					  			 
					    });
					   }); 
				   </script> 						 
				  <script type="text/javascript">
				     $("#tree").hide();
				     function showtree(){
				       $("#tree").show();
				     }
				  </script>	
				  <script type="text/javascript">
				    //滑动
				     $(".box-title").click(function() { 
					   $(this).parent().find(".box-list").slideToggle();
				     }); 				    
				  </script>
				 
				  <!-- 树形列表弹框结束 -->
					
				</div>
				<!-- 增添计划结束 -->
			</div>
</body>
</html>
