<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
List<Section> section=(List<Section>)session.getAttribute("sections");
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
List<Contest> contest=(List<Contest>)session.getAttribute("contest");
Contest c=contest.get(0);
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
	<link href="css/wllcss.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet">
  	<!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <link rel="Shortcut icon" href="img/favicon.ico">   
  
    <script src="js/myjs.js" type="text/javascript"></script>
    <script src="js/dzjs.js" type="text/javascript"></script>
    
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
      .caption h4 {font-size:16px;}
      .ba {padding:1px 6px;font-size:13px;}
      .ren {float:right;margin-top:5px;}
      .del {font-weight:normal;}
      .do {height:350px;overflow:auto;float:right;}
	  .list-group-item {border-top: 1px solid #ddd;border-radius:4px;}
	  .list-group-item0 {border: 1px solid #ddd;border-radius:4px;}  
	  .list-group-item:hover{background-color:#F0F0F0;}
      .thumbnail a:hover img{
	    -webkit-transform:scale(1.1,1.1);
	    -moz-transform:scale(1.1,1.1);
	    -transform:scale(1.1,1.1);
	   }
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
			
			<!-- 比赛 编辑-->
			<div class="col-md-9 column" style="-webkit-box-shadow:inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color:#FFFFFF;">
				<h4 style="margin-top:10px;">编辑</h4>
				<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
				<div class="col-md-12 column" style="overflow-x:hidden; height:495px;">				
				
				<div class="modal-body" style="font-size: 13px;">
				<!-- 编辑开始  -->			
				<form class="form-horizontal" role="form">
				
				  <div class="form-group">
				     <div class="col-sm-1"></div>
					 <div class="col-sm-10">
					   <a href="javascript:void(0);" style="text-decoration: none;"><a id="modal-722544" href="#modal-container-7" data-toggle="modal" style="text-decoration: none;"><img alt="300x200" src="
					   <%
							if(c.getC_image()==null){
							%>
							contestimage/kong.jpg
							<%
							}else{
							%>
							<%=c.getC_image() %>
							<%} %>
					   " style="width:600px;height:150px;"/></a></a>
					 </div>
					 <div class="col-sm-1"></div>
				  </div>
				  <br />		
				  <div class="form-group">
				       <label class="col-sm-3 control-label">比赛名称：</label>
				       <div class="col-sm-8"		>
				         <input type="text" class="form-control input-sm" id="cname"  style="width:49%;" value="<%=c.getContest_title() %>">
				       </div>
				  </div>		  
				  <div class="form-group">
				       <label class="col-sm-3 control-label">参赛项目：</label>
				       <div class="col-sm-8"		>
				         <input type="text" class="form-control input-sm" id="p_name"  style="width:49%;" value="<%=c.getProject_name() %>">
				       </div>
				  </div>			 
				  <div class="form-group">
				       <label class="col-sm-3 control-label">参赛人员：</label>
				       <div class="col-sm-8"	>
				         <input type="text" onclick="showtree()" class="form-control input-sm" id="person" style="width:49%;"value="<%=c.getProject_member() %>">
				       </div>
				  </div>	  
				  <div class="form-group">
				       <label class="col-sm-3 control-label">参赛时间：</label>
				       <div class="col-sm-8">
				         <input type="text" class="form-control input-sm" id="c_time" style="width:49%;"value="<%=c.getContest_time()%>">
				       </div>
				  </div>  
				  <div class="form-group">
				       <label class="col-sm-3 control-label">参赛地点：</label>
				       <div class="col-sm-8">
				          <input type="text" class="form-control input-sm" id="c_place" style="width:49%;" value="<%=c.getContest_place()%>">
				       </div>
				  </div>
				  <div class="form-group">
				       <label class="col-sm-3 control-label">大赛网址：</label>
				       <div class="col-sm-8">
				          <input type="text" class="form-control input-sm" id="curl" style="width:49%;" value="<%=c.getContets_url()%>">
				       </div>
				  </div>
				  <div class="form-group">
				      <label class="col-sm-3 control-label">参赛文件：</label>
				      <div class="col-sm-8">
				        <button type="button"   class="btn btn-info btn-xs"  data-toggle="modal" data-target="#modal-container-184711">&nbsp;上传&nbsp;</button>
				      </div>
				  </div>
				  <div class="form-group">
				       <label class="col-sm-3 control-label">项目介绍：</label>
				       <div class="col-sm-7">
				         <textarea class="form-control  p13-999" rows="3"	id="p_info"><%=c.getProject_info() %></textarea>
				       </div>
				  </div>
				  <div class="form-group">
				       <label class="col-sm-3 control-label">取得成绩：</label>
				       <div class="col-sm-7">
				         <textarea class="form-control  p13-999" rows="3"	id="p_awads"><%=c.getProject_awads() %></textarea>
				       </div>
				  </div>
				  <div class="form-group">
					   <label for="firstname" class="col-sm-3 control-label">经验心得：</label>
					   <div class="col-sm-7">
					     <textarea class="form-control p13-999" rows="3" id="c_experience"><%=c.getContest_experience()%></textarea>
					   </div>
				  </div>
				</form>				
				<!-- 编辑结束  -->
			    <br />
			    <div class="modal fade" id="modal-container-184711" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close"  data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
										上传资料
									</h4>
								</div>
								<div class="modal-body" style="font-size: 13px;">							
								    <form	name="dataForm"   role="form"  method="post" action="" enctype="multipart/form-data" class="form-horizontal">
								        <div class="form-group">
								          <label for="firstname" class="col-sm-2 control-label">文件输入：</label>
						                  <div class="col-sm-9">
						                    <input type="file" name="myFile" id="uploadfile" onchange="fileChange(this);"  data-min-file-count="1" >
						                    <div style="width:100%;"></div>
							              </div> 
							            </div>
							           
										   
										  <button type="submit" onclick="Checkprofiles();" class="btn btn-primary btn-sm">保存</button>
						                  <button type="reset" class="btn btn-default">重置</button>
							         </form>    								
								 </div>
							</div>
						</div>
					</div>
			  
			    <div class="col-sm-3"></div> 
			    <div class="col-sm-6">
			      <button type="button" class="btn btn-default btn-info" onclick="changeCon(<%=c.getContest_id() %>)">保存</button>
			      &nbsp; &nbsp;   
	              <button type="button" class="btn btn-default"  onclick="quxiao()">取消</button> 	  
                </div> 
                <div class="col-sm-3"></div> 									
				
				<!-- 树形列表弹框开始 -->
			    <div id="tree" class="tree">
				   <div class="col-sm-6"></div>
			       <div class="col-sm-4" style="margin-top:-600px;margin-left:20px;">
			         <button type="button" class="close" style="color:#000;" onclick="Hide()">×</button>
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
							  <li class="list-group-item"	>
							    <label class="del" style="margin-top:7px;">
							        <input type="checkbox" name="kkk" 	id="p_member" value="<%=m.getM_truename()%>"	onclick="test1('<%=m.getM_truename()%>')"/>
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
					 <div class="modal fade" id="modal-container-7" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
									<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								修改图片
							</h4>
						</div>
						<form name="dataForm1" class="form-horizontal" role="form"  method="post" action="" enctype="multipart/form-data">
							<div class="modal-body" style="font-size: 13px;">
								<input type="file" name="myFile" id="uploadfile1" onchange="conChange(this);" value="选择图片"/>
							</div>
							<div class="modal-footer">
								 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button> 
								 <button type="submit" onclick="Checkcontest();" class="btn btn-primary btn-sm">保存</button>
							</div>
						</form>
					</div>
				</div>
			</div>	 
				  <script type="text/javascript">
				   $(function(){
				     $('.list-group-item').click(function(){ 	    
				       text = $("input:checkbox[name='kkk']:checked").map(function(index,elem) {
				            return $(elem).val();           // 将所有选中的复选框通过函数返回值生成新的jQuery 对象
				        }).get().join(' , ');
				       $("#person").val(text);					  			 
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
					 $(".box-title").click(function(){ 
					   $(this).parent().find('.box-list').slideToggle()})
				   </script>	
				  <!-- 树形列表弹框结束 -->
				
				</div>
				<br /><br /><br />
		      </div>	
		     		      
		      </div>
			</div>
			<!-- 比赛编辑结束 -->
		</div>
	</div>
</div>
</body>
</html>
