<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Announce_section> ass = (List<Announce_section>)session.getAttribute("anno_section"); 
//List<Announcement> announcement=(List<Announcement>)request.getAttribute("an");
//List<MembershipInfo> mm=(List<MembershipInfo>)session.getAttribute("membershipInfo");
List<Section> sectioninfo = (List<Section>)request.getAttribute("sectioninfo");
List<MembershipInfo> msiinfo = (List<MembershipInfo>)request.getAttribute("msiinfo");
%>
<!-- 测试 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>创新实验室自学管理平台</title>
	 <!-- 编辑器 -->
    <link rel="stylesheet" href="qingeditor/qingstyle.css" />
	<script charset="utf-8" src="qingeditor/qingeditor-min.js"></script>
	<script>var textarea_name='content';</script>
	<script charset="utf-8" src="qingeditor/qingeditor-set.js"></script>
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
	         $("a[lang=1]").addClass("pre");//设置选中的
	         $("a[lang=1]").css("color","#fff");
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
/* 	  .list-group-item0 {border-radius:4px;}   */
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
			
				<!-- 公告栏导航 -->
				<jsp:include page="anno_navigation.jsp"></jsp:include>
				
				<!-- 新建公告开始 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						新建公告
					</h4>
					<!-- <span style="display: none;" id="announcement_type">保存并发布</span> -->
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div style="overflow-x:hidden; height:498px; ">
						<form class="form-horizontal" role="form" >
							
							<div class="form-group">
								<label class="col-sm-2 control-label">标题：</label>
							    <div class="col-sm-4">
							      <input class="form-control"  id="announcement_title"  type="text" onKeyDown="LimitTextArea36(this)" placeholder="请不要超过36个字...">
							    </div>
							</div>	
							<div class="form-group">
							  	<label class="col-sm-2 control-label">栏目：</label>
							  	
							  	<div class="col-sm-10" style="width: 300px;">
							  	<select class="form-control"  id="as_name">
									  	<%
									if(ass!=null){
										for(Announce_section as : ass){
									%>
								 	<option onclick="javascript:void(0);"  value="<%=as.getAs_name()%>"><%=as.getAs_name()%></option>
									 <%
								    	  }
								      }
									%>
								  	</select>
								  		
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label">接收人：</label>
							  	
							  	<div class="col-sm-4">
							      <input type="text" name="getanno_member" id="getanno_member" class="form-control uname " placeholder="请选择接收人" data-toggle="modal" data-target="#modal-container-722555"/>
							    	<span id="memberids" style="display: none"></span>
							    </div>
							
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
                               <div id="memberinfosid" class="pnav-cnt do" style="width:100%;border:none;margin-top:6px;">
						       	<%
						       	if(sectioninfo!=null){
						       		for(Section s : sectioninfo){
						       	 %>
						       	<div class="pnav-box">
									<div class="box-title list-group-item" id="let" >
									   	<input type="checkbox" onclick="checkthisbox('<%=s.getSection_name() %>')" id="<%=s.getSection_name() %>" name="parentcheckbox"/>
									  	<label class="pnav-letter">&nbsp;&nbsp;<%=s.getSection_name() %></label>
									</div>
									<ul class="box-list" id="letto">
									<%
								if(msiinfo!=null){
									for(MembershipInfo m : msiinfo){
										if(m.getM_sectionname().equals(s.getSection_name())){
									 %>									  
									  <li class="list-group-item">
									      <label class="del">
									          <input type="checkbox" name="checkbox" value="<%=m.getM_id() %>"/>
									          &nbsp;&nbsp;<span id="<%=m.getM_id() %>"><%=m.getM_truename() %></span>
									      </label>  							     
									  </li> 
									 <%
									 }
									 }
									 }
									  %>
									</ul>
								</div>
								<%
								}
								}
								 %>
							 </div>
			 			<script type="text/javascript">
							
						    //滑动
						    $(".box-list").hide();
							$(".pnav-letter").click(function(){ 
			                   $(this).parent().parent().find('.box-list').slideToggle()})
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
					   <span>已选接收人</span>
					   <span class="clear" style="float:right;cursor:pointer;">清空</span>
					</div>
					<div class="panel-body" style="height:395px; overflow: auto;"  id="nm"  value="">
					</div>
					
				  </div>
			  </div>
			</div>				
               <script>
                var text_memebrid;
                var text_memebrname;
				var arr=new Array();  
				function checkthisbox(parentid){
					
					var d = $("input[type=checkbox][name=parentcheckbox]:checked").parent().siblings().find('input');
					text_memebrname = d.map(function(index,elem) {
						//maps[$(elem).val()] = d.parent().find('#'+$(elem).val()).html();
						return $(elem).val();  
					}).get().join(",");
					
					text_memebrid = d.map(function(index,elem) {
						return d.parent().find('#'+$(elem).val()).html();
					}).get().join("<br>");
					 
					$(".panel-body").html(text_memebrid);  //显示人名
					$("#memberids").html(text_memebrname);
					
					
					//alert($("input[type=checkbox][name=parentcheckbox]").is(":checked"));
					if($("input[type=checkbox][name=parentcheckbox][id=" + parentid + "]").is(":checked")){
						arr=text_memebrname.split(',');//注split可以用字符或字符串分割  
						//根据逗号分隔字符串
						if(arr.length>1){
							for(var i=0;i<arr.length;i++){
								//alert(arr[i]);
								$("#"+arr[i]).parent().find('input').prop("checked", true);
							}
						}
					}else{
						var arr1 = new Array();
						var d1 = $("input[type=checkbox][name=parentcheckbox][id=" + parentid + "]:checked").parent().siblings().find('input');
						text_d1 = d.map(function(index,elem) {
							return $(elem).val();  
						}).get().join(",");
						arr1 = text_d1.split(',');//注split可以用字符或字符串分割  
						
						for(var i=0;i<arr1.length;i++){
							for(var j=0;j<arr.length;j++){
								if(arr1[i] == arr[j]){
									arr.splice(j,1);
									break;
								}
							}
						}
						for(var i=0;i<arr.length;i++){
							$("#"+arr[i]).parent().find('input').prop("checked", false);
						}
						arr1.RemoveAll();
						arr.RemoveAll();
					}
				
					
					
					
					 
				}               
               function liclick(){
               		$("li").click(function(){   // 将所有选中的复选框通过函数返回值生成新的jQuery 对象,显示出的是input中value的内容
               		
               		
               		  var e = $("input:checkbox[name='checkbox']:checked");
               		  e.parent().parent().parent().siblings().find('input').prop("checked", true);
					  text_memebrname = e.map(function(index,elem) {
					      return $(elem).val();  
					  }).get().join(",");
					  
					  text_memebrid = e.map(function(index,elem) {
					  	return e.parent().find('#'+$(elem).val()).html();
					  }).get().join("<br>");
					  
					  $(".panel-body").html(text_memebrid);  //显示人名
					  $("#memberids").html(text_memebrname);
					});
               }
               
                //获取人名
                $(document).ready(function(){
                
					liclick();
					
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
                 var reg = new RegExp("<br>","g");
                 //替换“<br>”的方法
                // if($(':checkbox:checked').length>0 && $(':checkbox:checked').length<2 ){    //判断是否有选中的人名
                   $("#getanno_member").val(con.replace(reg,","));          //将选中的人名传到input中
		           $("#modal-container-722555").modal("hide");      //隐藏模态框
                /*  }else{
                   alert('请选择一位审批人！');
                 }   */ 
	         });
          });
        </script>
     </div>
  </div>			
							
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">公告内容：</label>
							    <div class="col-sm-8">
							 
							    	<!-- 编辑器开始 -->
							    	<form action="?" id="con" class="con" name="form1" method="post" style="width:100%;">
								      <textarea id="cot" class="cot" name="content" style="width:100%;height:285px;">
								                
								      </textarea>
								    </form>
							    	<!-- 编辑器结束 -->
							    	
							    </div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
							    <div class="col-sm-8" >	
							    <span style="display: none" id="anno_id"></span>
							    <span style="display: none" id="anno_editnote">add</span> 	    	 
							      	<button type="button" class="btn btn-default btn-info"  onclick="addannocement()">保存并发布</button>&nbsp;&nbsp;
									<button type="button" class="btn btn-default btn-info"  onclick="baocun11()">保存</button>&nbsp;&nbsp;
									<button type="button" class="btn btn-default" onclick="back()">取消</button>
							    </div>
							</div>
						</form>
					</div>	
				</div>
				<!-- 新建公告结束 -->
			</div>
		</div>
</div>
  </body>
</html>
