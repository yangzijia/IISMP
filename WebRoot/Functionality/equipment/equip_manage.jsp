<%@ page language="java" import="java.util.*,com.rms.model.*,com.rms.page.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Equipment_Info> einfo=(List<Equipment_Info>)session.getAttribute("e_ment");
List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
List<Section> section=(List<Section>)request.getAttribute("sections");
MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo"); 
if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");	
}
Page p = (Page)request.getAttribute("pageinfo");
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
	
	<!-- 上传图片  -->	
	<script type="text/javascript">
	//下面用于图片上传预览功能
	function setImagePreview(avalue) {
	var docObj=document.getElementById("btn_file");
	 
	var imgObjPreview=document.getElementById("preview");
	if(docObj.files &&docObj.files[0])
	{
	//火狐下，直接设img属性
	imgObjPreview.style.display = 'block';
	imgObjPreview.style.width = '560px';
	imgObjPreview.style.height = '160px';
	//imgObjPreview.src = docObj.files[0].getAsDataURL();
	 
	//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	}
	else
	{
	//IE下，使用滤镜
	docObj.select();
	var imgSrc = document.selection.createRange().text;
	var localImagId = document.getElementById("localImag");
	//必须设置初始大小
	localImagId.style.width = "600px";
	localImagId.style.height = "300px";
	//图片异常的捕捉，防止用户修改后缀来伪造图片
	try{
	localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	}
	catch(e)
	{
	alert("您上传的图片格式不正确，请重新选择!");
	return false;
	}
	imgObjPreview.style.display = 'none';
	document.selection.empty();
	}
	return true;
	};						 
	</script>
	
	   <!-- 下划线跟随效果 -->
	   <link href="css/nav-animation.css" rel="stylesheet" type="text/css" />
	    
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
      td a:hover {text-decoration:none;color:#1C18EC;}
	  ul{margin-top:0px;list-style:none;}
	  .ba {padding:1px 6px;}
	  .col {margin-top:6px;}
	  .del {font-weight:normal;}
	  .list-group-item {border-top: 1px solid #ddd;border-radius:4px;}
	  .list-group-item0 {border: 1px solid #ddd;border-radius:4px;}
	  .list-group-item:hover{background-color:#F0F0F0;}
	  .do {height:350px;overflow:auto;}
	  .look {color:red;}
	  .p13-999 a:hover {color:red;}
	  #picture a:hover img{
	    -webkit-transform:scale(1.2,1.2);
	    -moz-transform:scale(1.2,1.2);
	    -transform:scale(1.2,1.2);
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
			
		<jsp:include page="equip_navigation.jsp"></jsp:include>
		
		<!-- 设备管理开始-->
		<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
			<h4 style="margin-top:10px;">
				设备管理	
				<span style="float:right;">
				  <button type="button" <%if(memberinfo.getRole_num()==4){ %>disabled="disabled"<%} %> class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal-container-184706">增添设备</button>
				</span>
			</h4>
			<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted;">
			
			<div  class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
			<!-- 设备表开始 -->
			<table  class="table table-hover" style="font-size: 13px;">
				<thead>
					<tr>
						<th>设备名称</th>
						<th>购买时间</th>
						<th>设备价格</th>
						<th>购买人</th>
						<th>负责人</th>
						<th>最新检查时间</th>
						<%if(memberinfo.getRole_num()!=4){ %><th></th><%} %>
						
					</tr>
				</thead>
			    <tbody id="eqbody">
			        <%
				    if(einfo!=null&&einfo.size()>0){
				    	int i=0;
				    	for(;i<einfo.size();i++){
				    	Equipment_Info e=einfo.get(i);
				  		  %>
					<tr>
					<%-- 
					  	<td>
					  		<a href="javascript:void(0);" style="text-decoration: none;">
					      	<a id="modal-722544" href="javascript:void(0);" onclick="chuanid(<%=e.getE_id()%>);"data-toggle="modal" style="text-decoration: none;">
					        <img id="eimg" src="<%=e.getE_image()%>" class="photo" data-toggle="tooltip" data-placement="bottom" title="上传和修改图片" style="width:80px;;height:50px;border-radius:10%;border:3px dotted #ccc;"></a></a>
					    </td> --%>
					    
					 <%--    <td>
					  		<a href="javascript:void(0);" style="text-decoration: none;" id="modal-722544" onclick="chuanid(<%=e.getE_id()%>);" data-toggle="modal">
					        	<img id="eimg" src="<%=e.getE_image()%>" title="上传和修改图片" >
					        </a>
					    </td> --%>
					    <td>
					      <a href="javascript:void(0);"><%=e.getE_name() %></a>      
					    </td>
						<td class="p13-999">
						  <%=e.getE_buytime() %>
						   <!-- <p><a href="javascript:void(0);" class="look" data-toggle="modal" data-target="#modal-container-722">应用事项</a></p> -->
						</td>
						<td class="p13-999"><%=e.getE_price() %>￥</td>
						<td class="p13-999"><%=e.getE_purchaser() %></td>
						<td><%=e.getE_principal() %></td>
						<td class="p13-999">
						<%
						if(e.getE_checktime()==null){
						%>
							~
						<%
						}else{
						%>
							<%=e.getE_checktime() %>
						<%} %>
						</td>
						<%if(memberinfo.getRole_num()!=4){ %>
						<td>
						   <a href="javascript:void(0);" onclick="editEquips(<%=e.getE_id() %>)" data-toggle="modal" data-target="#modal-container-722545">
						     <img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>
						    
						    &nbsp;
						   <a href="javascript:void(0);" onclick="deleteEquipment(<%=e.getE_id() %>)">
                             <img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a>
						</td>
						<%} %>
						
					</tr>
					
					<%
					
					}
					}else{
   							%>
							<tr>
								<td>暂无信息...</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<%if(memberinfo.getRole_num()!=4){ %><td></td><%} %>
							</tr>
							
						<%
						}
						%>
			    </tbody>
		   </table>
		   <!-- 设备表开始 -->
               	                 	
               	<!-- 增添设备弹框开始 -->
               	<div class="modal fade"  id="modal-container-184706" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width:500px;">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								增添设备
							</h4>
						</div>
						<div class="modal-body" style="font-size: 13px;">				
						  <form class="form-horizontal" role="form">
						  <div class="form-group">
						      <label class="col-sm-3 control-label" >设备名称：</label>
						      <div class="col-sm-5">
						        <input type="text" class="form-control input-sm" placeholder="请输入设备名称" id="Ename">
						       </div>
						       <div class="col-sm-1"></div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">购买时间：</label>
						       <div class="col-sm-5">
						          <input type="text" class="form-control input-sm" id="Ebuytime" placeholder="****-**-**">
								    <script type="text/javascript">
									    var picker = new Pikaday(
									    {
									        field: document.getElementById('Ebuytime'),
									        firstDay: 1,
									        minDate: new Date('2010-01-01'),
									        maxDate: new Date('2020-12-31'),
									        yearRange: [2000,2020]
									    });
									</script>
						       </div>
						       <div class="col-sm-1"></div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">设备价格：</label>
						       <div class="col-sm-5">
						         <input type="text" class="form-control input-sm" placeholder="请输入购买价格"	id="Eprice">
						       </div>
						       <div class="col-sm-1"></div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">购买人：</label>
						       <div class="col-sm-5">
						         <input type="text" class="form-control input-sm" placeholder="请输入购买人姓名"	id="Epurchaser">
						       </div>
						       <div class="col-sm-1"></div>
						  </div>
						  <div class="form-group">
						       <label class="col-sm-3 control-label">负责人：</label>
						       <div class="col-sm-5">
						          <input type="text" class="form-control input-sm" placeholder="输入或点击选择负责人" onclick="showtree()" id="hahha">
						       </div>
						       <div class="col-sm-1"></div>
						  </div>
						  <div class="form-group">
							   <label for="firstname" class="col-sm-3 control-label">应用事项：</label>
							   <div class="col-sm-8">
							    <textarea class="form-control"  rows="3" id="Eprecaution"></textarea>
							   </div>
						  </div>
						</form>
						</div>
						 <div class="modal-footer">
						    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						    <button type="button" class="btn btn-primary"	onclick="addEquip()">保存</button>
						</div>
						
						<!-- 树形列表弹框开始 -->
					    <div id="tree" class="tree">
						<div class="col-sm-6"></div>
				        <div class="col-sm-5" style="margin-top:-425px;">
				          <button type="button" class="close" style="float:right;color:#000;margin-right:-15px;" onclick="Hide()">×</button>
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
								
									<ul class="box-list" id="letto"  style="margin-bottom:0;">
									  <li class="list-group-item">
									    <label class="del" style="margin-top:7px;">  
									      <input type="checkbox" name="kkk" id="Eprincipal" value="<%=m.getM_truename()%>"	onclick="test1('<%=m.getM_truename()%>')"/>
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
				   $('.list-group-item').click(function(){
					 var $input = $(this).find('input');
					 $("#hahha").val($input.val());
					 console.log($input.val())
				    });
					  //隐藏树	  
				     $("#tree").hide();
				     function showtree(){
				       $("#tree").show();
				     }
				 </script>	
					</div>
				</div>
			</div>
			</div>
			<!-- 增添设备弹框结束 -->
			
			<!-- 应用事项弹框开始 -->
            <div class="modal fade"  id="modal-container-722" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:500px;">
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">
							TV应用事项
						</h4>
					</div>
					<div class="modal-body" style="font-size: 13px;">				
					            应用事项。。。。。。。
					            应用事项。。。。。。。应用事项。。。。。。。应用事项。。。。。。。应用事项。。。。。。。应用事项。。。。。。。应用事项。。。。。。。应用事项。。。。。。。
					</div>
					 <br />
				</div>
			   </div>
			  </div>
			</div>
			<!-- 应用事项弹框结束 -->
			
								
		    <!-- 编辑弹框开始 -->
	     	<div class="modal fade" id="modal-container-7" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								修改图片
							</h4>
						</div>
						<form name="dataForm" class="form-horizontal" role="form"  method="post" action="" enctype="multipart/form-data">
							<div class="modal-body" style="font-size: 13px;">
								<input type="file" name="myFile" id="uploadfile" onchange="imageChange(this);" value="选择图片"/>
							</div>
							<div class="modal-footer">
								 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button> 
								 <button type="submit" onclick="Checkepicture();" class="btn btn-primary btn-sm">保存</button>
							</div>
						</form>
					</div>
				</div>
			</div>
      	    <div class="modal fade" id="modal-container-722545" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						 <h4 class="modal-title" id="ename">
						         编辑
						 </h4>
					</div>
					<div class="modal-body" style="font-size: 13px;">				  
				  
					   <form class="form-horizontal" role="form"> 
						  <div class="form-group">
						     <label for="firstname" class="col-sm-2 control-label">设备名称：</label>
						     <div class="col-sm-8"	>
						       <input type="text" class="form-control input-sm" id="edit_name" style="width:49%;">
						     </div>
						  </div>
						  <div class="form-group">
						  	<label  for="name" class="col-sm-2 control-label">购买时间：</label>
						    <div class="col-sm-8 form-inline">
						      <input type="text" class="form-control input-sm" 	style="width:49%;" id="einfobuytime" >
						    </div>
						    <script type="text/javascript">
							    var picker = new Pikaday(
							    {
							        field: document.getElementById('einfobuytime'),
							        firstDay: 1,
							        minDate: new Date('2010-01-01'),
							        maxDate: new Date('2020-12-31'),
							        yearRange: [2000,2020]
							    }); 
							</script>
						  </div>  
                             <div class="form-group">
							   <label for="firstname" class="col-sm-2 control-label">设备价格：</label>
							   <div class="col-sm-8">
							      <input type="text" class="form-control input-sm" 	style="width:49%;" 	id="eprice" ></textarea>
							   </div>
							 </div>
							 <div class="form-group">
							    <label class="col-sm-2 control-label">购买人：</label>
							    <div class="col-sm-8">
							       <input type="text" class="form-control input-sm" style="width:49%;"	id="editPurchaser"  >
							    </div>
							 </div>
							 <div class="form-group">
							    <label class="col-sm-2 control-label">负责人：</label>
							    <div class="col-sm-4">
							       <input type="text" class="form-control input-sm" style="width:106%;"	id="eHeadPerson">
							    </div>										    
							    <div class="col-sm-1">
							       <button type="button" class="btn btn-info btn-xs" id="aa" onclick="showtreeview()" style="margin-top:4px;">更换</button>
							    </div>
							 </div>
							 <div class="form-group">
							   <label for="firstname" class="col-sm-2 control-label">应用事项：</label>
							   <div class="col-sm-8">
							    <textarea class="form-control p13-999" rows="3" id="eprecautions"></textarea>
							   </div>
							 </div>
				         </form>	
					</div>
					<div class="modal-footer">	
					 <span style=display:none id="eeid"></span>				     
						 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
						 <button type="button" class="btn btn-primary"	onclick="save_equipinfo()">保存</button>
					</div>
					
					<!-- 树形列表弹框开始 -->
				    <div id="treeview" class="tree">
					<div class="col-sm-7"></div>
			        <div class="col-sm-4" style="margin-top:-425px;">
			          <button type="button" class="close" style="float:right;color:#000;margin-right:-25px;" onclick="Hidden()">×</button>
			          <script>
			            function Hidden() {
				            var a = document.getElementById("treeview");    //login是ID
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
								  <li class="list-group-item">
								    <label class="del" style="margin-top:7px;">
								      <input type="checkbox" name="chethis" id="eprincipal"	value="<%=m.getM_truename()%>"	onclick="test2('<%=m.getM_truename() %>')"/>
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
					  </div>							  
				    </div>
					  <script type="text/javascript">
						 $('.list-group-item').click(function(){ 
						   var $input = $(this).find('input'); 
						   $("#kkkk").val($input.val());
						   console.log($input.val())
						 })
					  </script> 
					  <script type="text/javascript">
					     $("#treeview").hide();
					     function showtreeview(){
					       $("#treeview").show();
					     }
					  </script>	
				      <script type="text/javascript">
				         //滑动
					    $(".box-title").click(function(){ 
						  $(this).parent().find('.box-list').slideToggle()})
				      </script>
			          <!-- 树形列表弹框结束 -->
				
			        </div>
			      </div>
			      </div>
		        <!-- 编辑弹框结束 -->
			</div>	
	     </div>
	</div>
</body>
</html>
