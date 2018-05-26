var url = 'http://'+window.location.host+'/IISMP';

function spinnerstart(){
	$("#spinnerid").css('display', 'block');
	$("#tempid").css('display','block');
}
function spinnerend(){
	$("#spinnerid").css('display', 'none');
	$("#tempid").css('display','none');
}

var bianji = "<img src='img/edit.png'  data-toggle='tooltip' data-placement='bottom' title='编辑'/>";
var shanchu = "<img src='img/del.png' data-toggle='tooltip' data-placement='bottom' title='删除'/>";

/**
 *添加栏目的方法
 */
function newSection(){
	var as_name1=$("#asname").val();
	var as_description1=$("#as_description").val();
	var url11 = url+'/addSection';
	spinnerstart();
	$.ajax({   
		type:'POST', //用POST方式传输   
		url:url11,      //目标地址 
		dataType:'html',       
		data:{
			 "as_name":as_name1,
			 "as_description":as_description1
		},
		cache:false,
		success:function(data) {
			alert("添加栏目成功！！");
			$("#modal-container-184700").modal("hide");
			var str = eval("("+data+")");
			var thisstr="";
			$.each(str, function() {
				thisstr = thisstr + "<tr><td>" + this.as_name + "</td><td>" + this.as_updatetime + "</td><td>" + this.as_amount + "</td> <td><a id='bianji01' onclick='changeSectionByid("+this.as_id+")' href='#modal-container-184701' data-toggle='modal' style='text-decoration: none;'>"+bianji+"</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteAsection(" + this.as_id + ")' style='text-decoration: none'>"+shanchu+"</a></td></tr>";
			});
			document.getElementById('thistbody').innerHTML=thisstr;
			spinnerend();
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
    });
	this.refreshAsection();
	spinnerend();
}	
/**
 * 根据id查询出anno_section的信息并且动态显示到organ_structure_groupmanage.jsp界面
 */
function changeSectionByid(obj){
	var as_id = obj;
	$("#as_id").val(obj);	
	
	var url1 = url+'/changeSectionByid';
	spinnerstart();
	$.ajax({   
        type: 'POST', //用POST方式传输   
        url:url1,      //目标地址 
        datatype:"html",
        data:{
         	  "as_id":as_id
         	  },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	$("#a_name").val(str.as_name);
        	$("#a_description").val(str.as_description);
        	spinnerend();
        } ,
        error:function(data) {
        	alert("操作失败，请刷新后重新操作！！");
        	spinnerend();
        }
    });
}

/**
 * 保存编辑后的栏目信息
 */
function save_Aseditinfo(){
	var as_name = $("#a_name").val();
	var as_description = $("#a_description").val();
	var time=$("#as_updatetime").val();
	var as_id=$("#as_id").val();

	var url1 = url + '/save_Aseditinfo';
	spinnerstart();
	$.ajax({
		type:'post',
		url:url1,
		datatype:'html',
		data:{
			'as_updatetime':time,
			'as_name':as_name,
			'as_description':as_description,
			'as_id':as_id
		},
		cache:false,
		success:function(data) {
			alert("编辑栏目成功！！");
			//关闭模态框
			$("#modal-container-184701").modal("hide");
			var str = eval("("+data+")");
			var thisstr="";
			$.each(str, function() {
				thisstr = thisstr + "<tr><td>" + this.as_name + "</td><td>" + this.as_updatetime + "</td><td>" + this.as_amount + "</td><td><a id='bianji01' onclick='changeSectionByid("+this.as_id+")' href='#modal-container-184701' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteAsection(" + this.as_id + ")' style='text-decoration: none'>删除</a></td></tr>";
			});
			document.getElementById('thistbody').innerHTML=thisstr;
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 删除分组的方法
 * @param obj
 */
function deleteAsection(obj) {
	var as_id = obj;
	url1 = url + '/deleteAsectionbyid';
	if(confirm("是否确定删除这条数据？")){
		spinnerstart();
		$.ajax({
			type:'post',
			datetype:'html',
			url:url1,
			cache:false,
			data:{
				'as_id':as_id
			},
			success:function(data) {
				alert("删除成功！！");
				//关闭模态框
				var str = eval("("+data+")");
				var thisstr="";
				$.each(str, function() {
					thisstr = thisstr + "<tr><td>" + this.as_name + "</td><td>" + this.as_updatetime + "</td><td>" + this.as_amount + "</td> <td><a id='bianji01' onclick='changeSectionByid("+this.as_id+")' href='#modal-container-184701' data-toggle='modal' style='text-decoration: none;'>"+bianji+"</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteAsection(" + this.as_id + ")' style='text-decoration: none'>"+shanchu+"</a></td></tr>";
				});
				document.getElementById('thistbody').innerHTML=thisstr;
				spinnerend();
			},
			error:function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
		spinnerend();
	}else {
		return false;
	}
}

/**
 * 刷新栏目的方法
 */
function refreshAsection(){
	url1 = url + '/refreshAsectionAciton';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{},
		success:function(data) {
			var str = eval("("+data+")");
			var thisstr="";
			$.each(str, function() {
				thisstr = thisstr + "<tr><td>" + this.as_name + "</td><td>" + this.as_updatetime + "</td><td>" + this.as_amount + "</td> <td><a id='bianji01' onclick='changeSectionByid("+this.as_id+")' href='#modal-container-184701' data-toggle='modal' style='text-decoration: none;'>"+bianji+"</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteAsection(" + this.as_id + ")' style='text-decoration: none'>"+shanchu+"</a></td></tr>";
			});
			document.getElementById('thistbody').innerHTML=thisstr;
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
	spinnerend();
}


/**
 *保存并发布公告的方法
 */
function addannocement(){
	var url1 = url+'/publish1Action';
	var url11 = url+'/showAnnounceAction';
	
	var an_title1=$("#announcement_title").val();
	var an_info1=$(document.getElementsByTagName('iframe')[0].contentWindow.document.body).html();
	var an_jieshouren = $("#memberids").html();
	var an_section1=$("#as_name").val();
	var getanno_member = $("#getanno_member").val();
	
	//获取保存类型
	var an_type = $("#anno_editnote").html();
	//获取anno_id
	var anno_id = $("#anno_id").html();
	
	if("" == an_title1){
		alert("公告标题不能为空哦！！");
		return ;
	}
	if("" == an_jieshouren){
		alert("接收人不能为空哦！！");
		return ;
	}
	if("" == an_info1){
		alert("内容不能为空哦！！");
		return ;
	}
	spinnerstart();
	$.ajax({   
		type:'POST', //用POST方式传输   
		url:url1,      //目标地址 
		dataType:'html',       
		data:{
			 "announcement_title":an_title1,
			 "announcement_info":an_info1,
			 "as_name":an_section1,
			 "an_jieshouren":an_jieshouren,
			 "getanno_member":getanno_member,
			 "an_type":an_type,
			 "announcement_id":anno_id
		},
		cache:false,
		success:function(data) {
			alert("保存公告成功！！");
			window.location.href=url11;
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
    });
}

/*
 * 保存公告
 */
function baocun11(){
	spinnerstart();
	var url1 = url+'/publish2Action';
	var url11 = url+'/showAnnounceAction';
	var an_title1=$("#announcement_title").val();
	var an_info1=$(document.getElementsByTagName('iframe')[0].contentWindow.document.body).html();
	var an_jieshouren = $("#memberids").html();
	var an_section1=$("#as_name").val();
	var getanno_member = $("#getanno_member").val();
	if("" == an_title1){
		alert("公告标题不能为空哦！！");
		return ;
	}
	if("" == an_jieshouren){
		alert("接收人不能为空哦！！");
		return ;
	}
	if("" == an_info1){
		alert("内容不能为空哦！！");
		return ;
	}
	var startpage = 1;
	$.ajax({   
		type:'POST', //用POST方式传输   
		url:url1,      //目标地址 
		dataType:'html',       
		data:{
			 "announcement_title":an_title1,
			 "announcement_info":an_info1,
			 "as_name":an_section1,
			 "an_jieshouren":an_jieshouren,
			 "getanno_member":getanno_member
		},
		cache:false,
		success:function(data) {
			alert("保存公告成功！！");
			window.location.href=url11;	
			spinnerend();
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
		}
    });
}



/*
 * 删除公告的方法
 */
function deleteAbyid(){
	var url11 = url+'/showAnnounceAction';
	var announcement_id =  $("#announcement_id11").html();
	url1 = url + '/deleteAbyid';
	spinnerstart();
	if(confirm("是否确定删除这条数据？")){
		$.ajax({
			type:'post',
			datetype:'html',
			url:url1,
			cache:false,
			data:{
				'announcement_id':announcement_id
			},
			success:function(data) {
				
				alert("删除公告成功！！");
				window.location.href=url11;
				spinnerend();
			},
			error:function(data){
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}else {
		return false;
	}
}

//根据栏目id查看保存未发布的公告
function findasid2(obj){
	var url11 = url+'/findbyAsid2';
	var as_id=obj;
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"as_id":as_id
		},
		
		success:function(data) {
			window.location.href=url11;
			spinnerend();
        	
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}
//根据栏目id查看已发布公告
function findasid1(){
	var url11 = url+'/findbyAsid';
	window.location.href=url11;
}


/**
 * 
 * 新建公告取消
 * 
 */
function back(){	
	if(confirm("是否要取消吗？")){
		var url11 = url+'/showAnnounceAction';
		window.location.href=url11;
	}else {
		return false;
	}
}	

/**
 * 返回查看公告
 */
function back1(){	
	var url11 = url+'/showAnnounceAction';
	window.location.href=url11;
}	

/**
 * 根据栏目查看公告
 */
function findanno1(obj){
	var as_name = obj;
	var announcement_type=$("#announcement_type").html();
	$("#as_name_anno").html(obj);
	var url11 = 'http://'+window.location.host+'/IISMP/findasanno?as_name='+encodeURIComponent(as_name)+'&announcement_type='+encodeURIComponent(announcement_type);
	window.location.href=url11;
}

/**
 * 保存编辑
 */
function  editAnno(){
	var as_name=$("#aname").val();
	var announcement_title=$("#anno_title").val();
	var m_role=$("#mrole").val();
	var announcement_info=$("#anno_info").val();
	var announcement_id=$("#anno_id").html();
	var url2=url+'/editanno';
	var url1=url+'/showAnnounceAction';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url2,
		cache:false,
		data:{
			"announcement_info":announcement_info,
			"announcement_title":announcement_title,
			"as_name":as_name,
			"m_role":m_role,
			"announcement_id":announcement_id
		}, 
		success:function(data) {
			
        	alert("发布成功！");
        	window.location.href=url1;
        	spinnerend();
        } 
    });
}

///////////		
//设备////////
/////////////////

//新增设备
function addEquip(){
	var e_name=$("#Ename").val();
	var e_buytime=$("#Ebuytime").val();
	var e_price=$("#Eprice").val();
	var e_purchaser=$("#Epurchaser").val();//购买人
	var e_precautions=$("#Eprecaution").val();//注意事项
	var e_principal=$("#Eprincipal").val();
	var url1=url+'/addEquipment';
	var url2=url+'/ShowequipAction';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"e_name":e_name,
			"e_buytime":e_buytime,
			"e_price":e_price,
			"e_purchaser":e_purchaser,
			"e_principal":e_principal,
			"e_precautions":e_precautions,
		}, 
		success:function(data) {
	    	alert("增加成功！");
	    	window.location.href=url2;
	    	$("#modal-container-184706").modal("hide");
	    	spinnerend();
        } 
    });
}

//删除设备

function deleteEquipment(obj){
	var e_id=obj;	
	var url1=url+'/deleteEquip';
	var url2=url+'/ShowequipAction';
	if(confirm("是否确定删除？")){
		spinnerstart();
		$.ajax({
			type:'post',
			datetype:'html',
			url:url1,
			cache:false,
			data:{
				"e_id":e_id,
			}, 
			success:function(data) {
				alert("删除成功！");
				window.location.href=url2;	
				spinnerend();
		    } 
	    });
	}
}

//编辑设备信息
function editEquips(obj){
	var e_id=obj;
	var url1=url+'/findEbyid';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"e_id":e_id,
		}, 
		success:function(data) {		
	    	var str = eval("("+data+")");
	    	$("#echecktime").val(str.e_checktime);
			$("#edit_name").val(str.e_name);
			$("#eprecautions").val(str.e_precautions);
			$("#eprice").val(str.e_price);
			$("#eHeadPerson").val(str.e_principal);
			$("#editPurchaser").val(str.e_purchaser);
			$("#einfobuytime").val(str.e_buytime);
//			$("#ename").val(str.e_name);
			document.getElementById("eeid").innerHTML=obj;
			spinnerend();
        } 
    });
}

/**
 * 保存编辑后的设备信息
 */
function save_equipinfo(){
	var e_id=$("#eeid").html();
//	var e_checktime=$("#echecktime").val();
	
	var e_principal=$("#eHeadPerson").val();	
	var e_precautions=$("#eprecautions").val();
	var e_purchaser=$("#editPurchaser").val();
	var e_price=$("#eprice").val();
	var e_buytime=$("#einfobuytime").val();
	var e_name=$("#edit_name").val()
	var url1 = url + '/save_equipinfo';
	var url2=url+'/ShowequipAction';
	spinnerstart();
	$.ajax({
		type:'post',
		url:url1,
		datatype:'html',
		data:{
			"e_id":e_id,
			"e_principal":e_principal,
			"e_precautions":e_precautions,
			"e_buytime":e_buytime,
//			"e_checktime":e_checktime,
//			"e_pattern":e_pattern,
			"e_price":e_price,			
			"e_purchaser":e_purchaser,
			"e_name":e_name
		},
		cache:false,
		success:function(data) {
			alert("编辑成功！！");			
			//关闭模态框
			$("#modal-container-722545").modal("hide");
			window.location.href=url2;	
			spinnerend();
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
		
	});
}

//根据Id查看设备详情
function findEinfobyid(obj){
	var e_id=obj;
	var url1=url+'/findEbyid';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"e_id":e_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			$("#e_checktime").html(str.e_checktime);
			$("#e_pattern").html(str.e_pattern);
			$("#e_precautions").html(str.e_precautions);
			$("#e_price").html(str.e_price);
			$("#e_principal").html(str.e_principal);
			$("#e_purchaser").html(str.e_purchaser);
			$("#e_buytime").html(str.e_buytime);
			$("#e_name").html(str.e_name);
			document.getElementById("imgid").src=str.e_image;
			spinnerend();
        } 
    });
}
//设备的刷新
function shuaxinequip(){
	var url1=url+'/refreshequip';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
		}, 
		success:function(data) {
			
			var str = eval("("+data+")");
			if(str.isempty==false){
				var thisstr="";
//			style="width:80px;height:50px;border-radius:10%;border:3px dotted #ccc;"      data-toggle="tooltip" data-placement="bottom"
			$.each(str.jsona, function() {
//				var tr1='<td><a href="javascript:void(0);" onclick="chuanid('+this.e_id+');"data-toggle="modal" style="text-decoration: none;"id="modal-722544">'
//		        var tr11='<img id="eimg" src="('+this.e_picture+')" title="上传和修改图片" ></a></td>'	        										
				var tr2='<td>'+this.e_name+'</td>';
				var tr3='<td>'+this.e_buytime+'</td>';
				var tr4='<td>'+this.e_price+'</td>';
				var tr5='<td>'+this.e_purchaser+'</td>';
				var tr6='<td>'+this.e_principal+'</td>';
				var tr7= '<td><a href="javascript:void(0);"  onclick="editEquips('+this.e_id+')" data-toggle="modal" data-target="#modal-container-722545">';
				var tr8= '<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>&nbsp;';
				var tr9 = '<a href="javascript:void(0);"  onclick="deleteEquipment('+this.e_id+')" style="text-decoration: none;">';
				var tr10 = '<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a></td></tr>';
				var tr12='<td></td>'
				thisstr = thisstr + tr1+tr11 + tr2 + tr3 + tr4
				  +tr5+ tr6+tr12+tr7+tr8+tr9+tr10;
				});
				document.getElementById('eqbody').innerHTML=thisstr;		
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息...</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				
				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						  + "</tr>";
				document.getElementById('eqbody').innerHTML=thisstr;
			}
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});	
}

function test1(obj){
	var d=obj;
	$("#Eprincipal").val(d);
}

function test2(obj){
	var d=obj;
	$("#eHeadPerson").val(d);
}



////////////////////
///////////////////
//比赛板块

//根据id查看比赛详情
function  findCbyid(obj){
	var contest_id=obj;
	var url1=url+'/findConByid';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"contest_id":contest_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			$("#project_name").html(str.project_name);
			$("#project_member").html(str.project_member);
			$("#contest_time").html(str.contest_time);
			$("#contest_place").html(str.contest_place);
			$("#project_info").html(str.project_info);
			$("#project_awads").html(str.project_awads);
			$("#contest_experience").html(str.contest_experience);
			if(str.c_image!=null || str.c_image!=undefined){
				document.getElementById("cimage").src=str.c_image;
			}
			spinnerend();
        } 
    });
	
}	
//保存比赛编辑信息
function changeCon(obj){
	spinnerstart();
	var url2=url+'/SaveCon';
	var url1=url+'/ShowContestAction';
	var contest_id=obj;
	var p_name=$("#p_name").val();
	var p_member=$("#person").val();
	var c_time=$("#c_time").val();
	var c_place=$("#c_place").val();
	var p_info=$("#p_info").val();
	var p_awads=$("#p_awads").val();
	var cname=$("#cname").val()
	var curl=$("#curl").val()
	var c_experience=$("#c_experience").val();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url2,
		cache:false,
		data:{
			"contest_id":contest_id,	
			"project_name":p_name,
			"project_member":p_member,
			"contest_time":c_time,
			"contest_place":c_place,
			"project_info":p_info,
			"project_awads":p_awads,
			"contest_experience":c_experience,
			"contets_url":curl,
			"contest_title":cname
		}, 
		success:function(data) {
			alert("编辑成功！！")
			window.location.href=url1;
			spinnerstart();
        } 
    });	
}
	
//取消编辑，增加，回到显示页面
function quxiao(){
	var url1=url+'/ShowContestAction';
	window.location.href=url1;
}
	
//增加比赛
function addContest(){
	var url2=url+'/addContest';
	var url1=url+'/ShowContestAction';
	var c_name=$("#cname").val();
	var p_name=$("#pname").val();
	var p_member=$("#pmember").val();
	var c_time=$("#ctime").val();
	var c_place=$("#cplace").val();
	var c_url=$("#curl").val();
	var c_info=$("#projectInfo").val()
	var c_awads=$("#p_awads").val()
	var c_experience=$("#cjingyan").val();
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url2,
		cache:false,
		data:{
			"contest_title":c_name,
			"project_name":p_name,
			"project_member":p_member,
			"contest_time":c_time,
			"contest_place":c_place,
			"contets_url":c_url,
			"contest_experience":c_experience,
			"project_info":c_info,
			"project_awads":c_awads
		}, 
		success:function(data) {
			alert("增加成功！！")
			window.location.href=url1;
			spinnerend();
        } 
    });	
}


//根据id查看项目详情
function findpByid(obj){
	var project_id=obj;
	var url1=url+'/findProByid';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"project_id":project_id,	
		}, 
		success:function(data) {
			
			var str = eval("("+data+")");
			$("#Pname").html(str.project_name);
			$("#Pinfo").html(str.project_info);
			$("#Pawards").html(str.project_awards);
			$("#Pexperience").html(str.contest_experience);
			$("#Sname").html(str.project_section);
			spinnerend();
        } 
    });
	
}	


//根据id进行项目编辑
function findpro(obj){
	var project_id=obj;
	
	var url1=url+'/findProByid';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"project_id":project_id,	
		}, 
		success:function(data) {
			spinnerend();
			var str = eval("("+data+")");
			$("#proname").val(str.project_name);
			$("#proinfo").html(str.project_info);
			$("#prosection").val(str.project_section);
			document.getElementById("proid").innerHTML=obj;
			
			
        } 
    });
	
}	

//保存项目编辑
function savepro(){
	var project_id=$("#proid").html();
	var url1=url+'/saveProject';
	var project_name=$("#proname").val();
	var project_info=$("#proinfo").val();
	var project_section=$("#prosection").val();
	
	
//	var url2=url+'/ShowProjectAction';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"project_id":project_id,
			"project_name":project_name,
			"project_info":project_info,
			"project_section":project_section
		}, 
		success:function(data) {
			alert("编辑成功！！！");
			$("#modal-container-723").modal("hide");
			shuaxinproject();	
			spinnerend();
        } 
    });
	
}	

//增加项目
function addProject(){
	var project_name=$("#project_name").val();
	var project_section=$("#project_section").val();
	var project_info=$("#project_info").val();
	/*var url2=url+'/ShowProjectAction';*/
	var url1=url+'/addProject';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"project_name":project_name,	
			"project_section":project_section,
			"project_info":project_info
	
		}, 
		success:function(data) {
			alert("增加成功！！！")
			/*window.location.href=url2;*/
			$("#modal-container-184707").modal("hide");
			shuaxinproject();
			spinnerend();
        } 
    });
}
////////////
///////////
//资源模块

//根据资源库 查找资源
/*function findRbytype(obj){
	spinnerstart();
	var rt_id=obj;
	var url1=url+'/findRbytype';
	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"rt_id":rt_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			var thisstr="";
			
			if(str.isempty==false){
				//table表的显示
				$.each(str.jsona, function(){
					var tr6 ="<td>"+this.resource_name+"</td>";						
					var tr7="<td>"+this.resource_issuer+"</td>";	
					var tr8="<td>"+this.resource_time+"</td>";
					var tr9="<td><a href='downloadFile2?filename="+this.resource_name+"'>下载</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteRebyid("+this.resource_id+")'>删除</a></td>";						
					thisstr = thisstr+"<tr>" +tr6+tr7+tr8+tr9+"<tr>" ;
					
				});
				document.getElementById("tr1").innerHTML=thisstr;
				document.getElementById('rtid').innerHTML=obj;	
				document.getElementById("rttype").innerHTML=str.rtname;
				
				var listring = "<tr><th>第<span id='m_pagenow'>" + str.pageNow + "</span>/<span id='m_pagecount'>"+ str.pageCount +"</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if(str.pageNow!=1){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" +startpage+ ");'>首页</a></li>";
				}
				if(str.isHasPrev){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" + str.getPervPage + ");'>上页</a></li>";
				}
				if(str.isHasNext){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" + str.getNextPage + ");'>下页</a></li>";
				}
				if(str.pageCount!=str.pageNow){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" + str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if(str.pageCount!=1){
					listring = listring + "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th></tr>";
				}
				
				$("#relist").html(listring);
				
			}else{
				var tr1 = '<td></td>';
				var tr2 = '<td>暂无信息...</td>';
				var tr3 = '<td></td>';
				var tr4 = '<td></td>';
				thisstr = thisstr + tr1 + tr2 + tr3 + tr4;
				document.getElementById("tr1").innerHTML=thisstr;
				document.getElementById("rttype").innerHTML=str.rtname;
				
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}*/

//翻页查看资源

function fanyere(obj){
	spinnerstart();
	var pageNow=obj;
	var url1=url+'/Fanyere';
	var rt_id=$("#rtid").html();
/*alert(rt_id);*/
	var startpage = 1;
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"pageNow":pageNow,	
			"rt_id":rt_id
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			var thisstr="";
			if(str.isempty){
				//table表的显示
				$.each(str.jsona, function(){
					var t1 = '<tr><td><span>' + this.resource_name + '</span>';	
					var t2 = '</td><td class="p13-999">' + this.resource_issuer + '</td>';
					var t3 = '<td class="p13-999">' + this.resource_time + '</td>';
					var t4 = '<td><a style="text-decoration: none;" href="downloadFile2?filename=' + this.resource_name + '" role="button" class="btn btn-xs" >';
					var t5 = '<img src="img/down.png"  data-toggle="tooltip" data-placement="bottom" title="下载"/></a>';
					var t6 = '<a style="text-decoration: none;"  href="javascript:void(0);"  onclick="deleteRebyid(' + this.resource_id + ')"  class="btn btn-xs">';
					var t7 = '<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a></td></tr>';
					thisstr = thisstr + t1 + t2 + t3 + t4 + t5 + t6 + t7;
				});
				//document.getElementById("res_infosbody").innerHTML=thisstr;
				//document.getElementById("rttype").innerHTML=str.rt_name;
			}else{
				var tr1 = '<td>暂无信息...</td>';
				var tr2 = '<td></td>';
				var tr3 = '<td></td>';
				var tr4 = '<td></td>';
				thisstr = tr1 + tr2 + tr3 + tr4;
			}
			$("#res_infosbody").html(thisstr);
			
			var listring = "<tr><th>第<span id='m_pagenow'>" + str.pageNow + "</span>/<span id='m_pagecount'>"+ str.pageCount +"</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
			if(str.pageNow>1){
				listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" +str.startpage+ ");'>首页</a></li>";
			}
			if(str.isHasPrev){
				listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" + str.getPervPage + ");'>上页</a></li>";
			}
			if(str.isHasNext){
				listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" + str.getNextPage + ");'>下页</a></li>";
			}
			if(str.pageCount!=str.pageNow){
				listring = listring + "<li><a href='javascript:void(0);' onclick='fanyere(" + str.pageCount + ");'>尾页</a></li>";
			}
			listring = listring + "</ul></th>";
			if(str.pageCount!=1){
				listring = listring + "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' id='yeshu' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm'  onclick='fanyere($(\"#yeshu\").val())' type='button'>跳转</button></span></div></div></th></tr>";
			}
			
			$("#relist").html(listring);
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
	
}

//根据Id删除资源库
function deleteRTbyid(obj){
	var rt_id=obj;
	var url1=url+'/deleteRTbyidAction';
	
	var url2=url+'/showRTaction';
	spinnerstart();
	if(confirm("是否确定删除")){
		$.ajax({
			type:'post',
			datetype:'html',
			url:url1,
			cache:false,
			data:{
				"rt_id":rt_id,	
			}, 
			success:function(data) {
				alert("删除成功！");
				shuaxintype();
				spinnerend();
			}
		});
	}
}


//根据id对资源进行删除操作
function deleteRebyid(obj){
	var resource_id=obj;
	var url1=url+'/deleteRebyidAction';
	var rt_name=$("#rttype").html();
	spinnerstart();
	if(confirm("是否确定删除？")){
		$.ajax({
			type:'post',
			datetype:'html',
			url:url1,
			cache:false,
			data:{
				"resource_id":resource_id,	
			}, 
			success:function(data) {
				alert("删除成功！");
				window.location.reload();
				document.getElementById("rttype").innerHTML=rt_name;
				spinnerend();
			}
		});
	}
}

/**
 * 编辑保存资源库的方法
 */
function updateRestype(){
	var typename=$("#typename1").val();
	var typeinfo=$("#typeinfo1").val();
	var rt_id = $("#typeid1").html();
	var url1 = url + "/updateRestype";
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"rt_name":typename,	
			"rt_remark":typeinfo,
			"rt_id":rt_id
		}, 
		success:function(data) {
			alert("操作成功！！");
			$("#modal-container-184111").modal("hide");
			shuaxintype();
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

//新建资源库
function  addRtype(){
	spinnerstart();
	var typename=$("#typename").val();
	var typeinfo=$("#typeinfo").val();
	var url1=url+'/addRtype';
	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"rt_name":typename,	
			"rt_remark":typeinfo
		}, 
		success:function(data) {
			alert("增加成功！");
			$("#modal-container-184709").modal("hide");
			shuaxintype();
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}
//查看资源库详细
function findrt(obj){
	//alert(obj);
	var rt_id=obj;
	var url1=url+'/findrtbyid';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"rt_id":rt_id,
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			$("#typename1").val(str.rt_name);
			$("#typeinfo1").html(str.rt_remark);
			$("#typeid1").html(rt_id);
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

//对资源库类型进行刷新
function shuaxintype(){
	var url1=url+'/refreshtype';
	spinnerstart();
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
		}, 
		success:function(data) {	
			var str = eval("("+data+")");
			if(str.isempty==false){
			var thisstr="";
			$.each(str.jsona, function() {
				var tr1 = '<td><a href="javascript:void(0)" onclick="findrt('+this.rt_id+');" data-toggle="modal" data-target="#modal-container-184710" style="text-decoration:none;">'+this.rt_name+'</a></td>';							
				var tr2='<td>'+this.rt_issuer+'</td>';
				var tr3='<td>'+this.rt_updatime+'</th>';
				var tr4='<td>'+this.re_amount+'</th>';						
				var tr6 = '<td><a href="javascript:void(0);"  onclick="deleteRTbyid('+this.rt_id+')" style="text-decoration: none;">';
				var tr7 = '<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a></td></tr>';
				thisstr = thisstr + tr1 + tr2 + tr3 + tr4
				  + tr6+tr7;
				});
				document.getElementById('rtbody').innerHTML=thisstr;		
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息...</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				
				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						  + "</tr>";
				document.getElementById('rtbody').innerHTML=thisstr;
				
			}
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

//上传资源
function fileChange(target, id) {
	// var strFileName = $("#uploadfile").val();
	var fileSize = 0;
	var filetypes = [ ".zip", ".rar",".txt",".ppt",".pptx",".pdf",".java",".doc",".xls",".xlsx",".docx"];
	var filepath = target.value;
	var filemaxsize = 1024 * 2;// 100M
	if (filepath) {
		var isnext = false;
		var fileend = filepath.substring(filepath.indexOf("."));
		if (filetypes && filetypes.length > 0) {
			for ( var i = 0; i < filetypes.length; i++) {
				if (filetypes[i] == fileend) {
					isnext = true;
					break;
				}
			}
		}
		if (!isnext) {
			alert("文件格式不符合上传要求！\n请上传格式为.zip .rar .txt .ppt, .pptx, .pdf .java .doc .xls .xlsx .docx的信息文件");
			target.value = "";
			return false;
		}
	} else {
		return false;
	}

	if (isIE && !target.files) {
		var filePath = target.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		if (!fileSystem.FileExists(filePath)) {
			alert("文件不存在，请重新输入！");
			return false;
		}
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = target.files[0].size;
	}

	var size = fileSize / 1024;
	if (size > filemaxsize) {
		alert("文件大小不能大于" + filemaxsize / 1024 + "M！");
		target.value = "";
		return false;
	}
	if (size <= 0) {
		alert("文件大小不能为0M！");
		target.value = "";
		return false;
	}
}
function Checkfiles() {
	
	var files = $("#uploadfile").val();
	if (files == "") {
		alert("嘿！您老还没选择要上传的文件呢（O_*）");
		return false;
	} else {
		document.dataForm.action = "commitresource";
		spinnerstart();
	}
	
}



//上传图片

function imageChange(target, id) {
	// var strFileName = $("#uploadfile").val();	
	var fileSize = 0;
	var filetypes = [ ".jpg", ".png" ];
	
	var filepath = target.value;
	var filemaxsize = 1024 * 2;// 100M
	if (filepath) {
		var isnext = false;
		var fileend = filepath.substring(filepath.indexOf("."));
		if (filetypes && filetypes.length > 0) {
			for ( var i = 0; i < filetypes.length; i++) {
				if (filetypes[i] == fileend) {
					isnext = true;
					break;
				}
			}
		}
		if (!isnext) {
			alert("文件格式不符合上传要求！\n请上传格式为.jpg .png的信息文件");
			target.value = "";
			return false;
		}
	} else {
		return false;
	}

	if (isIE && !target.files) {
		var filePath = target.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		if (!fileSystem.FileExists(filePath)) {
			alert("文件不存在，请重新输入！");
			return false;
		}
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = target.files[0].size;
	}

	var size = fileSize / 1024;
	if (size > filemaxsize) {
		alert("文件大小不能大于" + filemaxsize / 1024 + "M！");
		target.value = "";
		return false;
	}
	if (size <= 0) {
		alert("文件大小不能为0M！");
		target.value = "";
		return false;
	}
	
	
}
function Checkepicture() {
	
	var files = $("#uploadfile").val();
	
	if (files == "") {
		alert("嘿！您老还没选择要上传的文件呢（O_*）");
		return false;
	} else {
		
		document.dataForm.action = "Commitepicture";
		
	}
	
	
		
}

function chuanid(obj){
	url1=url+'/chuanID';
	var e_id=obj;
	
	$.ajax({
		type:'post',
		url:url1,
		datatype:'html',
		data:{
			"e_id":e_id,		
		},
		cache:false,
		success:function(data) {			
			$("#modal-container-7").modal("show");
		},
			
	});
}

function fun()
{
var rtxid=document.getElementById('rtid').innerHTML;

document.getElementById('rttid').value=rtxid;
}



////////////////
/////审批模块
//////////////


//根据审批进度查看我的申请
function findmyapplyBys(obj){
	var pageNow=obj;
	var approval_schedule=$("#myschedule").val();
	var url1=url+'/findmyapplyBys';	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"approval_schedule":approval_schedule,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			if(str.isempty==false){
				//table表的显示
				var thisstr="";			
				$.each(str.jsona, function() {
					var tr1 = "<td><a href='javascript:void(0);' onclick='findapplyByid("+this.apply_id+")'>"+this.approval_type+"</a></td>";			
					var tr2="<td>"+this.apply_time+"</td>";
					var tr3="<td>"+this.approval_schedule+"</td>";
					var tr4="<td>"+this.approval_time+"</th>";
					var tr5="<td>"+this.approval_member+"</td>";						
					thisstr = thisstr + "<tr>"+tr1+tr2+tr3+tr4+tr5+"</tr>";							
				});								
				document.getElementById('body1').innerHTML=thisstr;
			
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息....</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						  +tr5+ "</tr>";
				document.getElementById('body1').innerHTML=thisstr;
						
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}

//根据id查看我的申请的详细信息
function findapplyByid(obj){
	var apply_id=obj;	
	var url1=url+'/findapplyByid';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"apply_id":apply_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			$("#approval_schedule").html(str.approval_schedule);
			$("#apply_info").html(str.apply_info);
			$("#apply_member").html(str.apply_member);
			$("#apply_section").html(str.apply_section);
			$("#apply_type").html(str.apply_type);
			$("#apply_time").html(str.apply_time);
			$("#approval_member").html(str.approval_member);
			$("#modal-container-722523").modal("show");
			
		}
	});
}

//根据审批进度查看全部审批
function findallapproval(obj){
	var pageNow=obj;
	var approval_schedule=$("#allapproval").val();
	var url1=url+'/findAllshenpi';	
	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"approval_schedule":approval_schedule,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			if(str.isempty==false){
				//table表的显示
				var thisstr="";			
				$.each(str.jsona, function() {
					var tr1 = "<td><a href='javascript:void(0);' onclick='findapplyByid("+this.approval_id+")'>"+this.approval_type+"</a></td>";			
					var tr2="<td>"+this.apply_time+"</td>";
					var tr3="<td>"+this.approval_schedule+"</td>";
					var tr4="<td>"+this.approval_time+"</th>";
					var tr5="<td>"+this.approval_member+"</td>";						
					thisstr = thisstr + "<tr>"+tr1+tr2+tr3+tr4+tr5+"</tr>";							
				});								
				document.getElementById('body2').innerHTML=thisstr;
			
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息....</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						  +tr5+ "</tr>";
				document.getElementById('body2').innerHTML=thisstr;
						
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}

//根据审批进度查看我的审批

function findmyapproval(obj){
	var pageNow=obj;
	var approval_schedule=$("#allapproval").val();
	var url1=url+'/findMyshenpi';	
	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"approval_schedule":approval_schedule,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			if(str.isempty==false){
				//table表的显示
				var thisstr="";			
				$.each(str.jsona, function() {
					var tr1 = "<td><a href='javascript:void(0);' onclick='findapplyByid("+this.approval_id+")'>"+this.approval_type+"</a></td>";			
					var tr2="<td>"+this.apply_time+"</td>";
					var tr3="<td>"+this.approval_schedule+"</td>";
					var tr4="<td>"+this.approval_time+"</th>";
					var tr5="<td>"+this.approval_member+"</td>";						
					thisstr = thisstr + "<tr>"+tr1+tr2+tr3+tr4+tr5+"</tr>";							
				});								
				document.getElementById('body2').innerHTML=thisstr;
			
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息....</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						  +tr5+ "</tr>";
				document.getElementById('body2').innerHTML=thisstr;
						
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}

//根据id查看我的审批的详细信息
function findmyshenpi(obj){
	var approval_id=obj;	
	var url1=url+'/findmyshenpi';
	
	$("#myshen_id").val(obj);
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"approval_id":approval_id,	
		}, 
		success:function(data){
			var str = eval("("+data+")");
			
			var thisstr = "";
			document.getElementById("mya_schedule").innerHTML=str.approval_schedule;
			document.getElementById("mya_info").innerHTML=str.apply_info;
			document.getElementById("mya_aman").innerHTML=str.apply_member;
			document.getElementById("mya_section").innerHTML=str.apply_section;
			document.getElementById("mya_type").innerHTML=str.apply_type;
			document.getElementById("mya_time").innerHTML=str.apply_time;
			document.getElementById("mya_name").innerHTML=str.approval_member;
			
			var tr9="<td><a href='downloadapply?filename="+str.apply_resource+"'>点击下载</a></td>";							
			thisstr = thisstr + "<tr>" + tr9 +  "</tr>";
			document.getElementById("download").innerHTML=thisstr;
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}

//进行审批
function shenpi(){
	var approval_info=$("#myshenpi_info").val();
	var mydeal=$("input[type='radio']:checked").val();
	var approval_id=$("#myshen_id").val();
	var url1=url+'/shenpi';
	var url2=url+'/findMyapproval'
	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"approval_id":approval_id,
			"approval_info":approval_info,	
			"mydeal":mydeal
		}, 
		success:function(data) {
			alert("处理完成");
			$("#modal-container-722553").modal("hide");
			window.location.href=url2;
		}
	});
}

function fanhuia(){
	var url2=url+'/ViewApply';
	window.location.href=url2;
}

//新建申请
function Apply(){
	var apply_member=$("#applyperson").html();
	var approval_type=$("#types").val();
	var approval_member=$("#apman").val();
	var member_section=$("#sssection").html();
	var apply_info=$("#okinfo").val();
	
	var url1=url+'/addMyapply';
	var url2=url+'/ViewApply';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"apply_member":apply_member,
			"approval_type":approval_type,	
			"approval_member":approval_member,
			"member_section":member_section,
			"apply_info":apply_info
			
		}, 
		success:function(data) {
			alert("申请完成");
		window.location.href=url2;
		}
	});
}

//修改比赛图片
function conChange(target, id) {
	// var strFileName = $("#uploadfile").val();
	var fileSize = 0;
	var filetypes = [ ".jpg", ".png" ];
	
	var filepath = target.value;
	var filemaxsize = 1024 * 2;// 100M
	if (filepath) {
		var isnext = false;
		var fileend = filepath.substring(filepath.indexOf("."));
		if (filetypes && filetypes.length > 0) {
			for ( var i = 0; i < filetypes.length; i++) {
				if (filetypes[i] == fileend) {
					isnext = true;
					break;
				}
			}
		}
		if (!isnext) {
			alert("文件格式不符合上传要求！\n请上传格式为.jpg .png的信息文件");
			target.value = "";
			return false;
		}
	} else {
		return false;
	}

	if (isIE && !target.files) {
		var filePath = target.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		if (!fileSystem.FileExists(filePath)) {
			alert("文件不存在，请重新输入！");
			return false;
		}
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = target.files[0].size;
	}

	var size = fileSize / 1024;
	if (size > filemaxsize) {
		alert("文件大小不能大于" + filemaxsize / 1024 + "M！");
		target.value = "";
		return false;
	}
	if (size <= 0) {
		alert("文件大小不能为0M！");
		target.value = "";
		return false;
	}
}

function Checkcontest(){
	var files = $("#uploadfile1").val();
	
	if (files == "") {
		alert("嘿！您老还没选择要上传的文件呢（O_*）");
		return false;
	} else {
		
		document.dataForm1.action ="updateconimage";
	}
}

function Checkprofiles() {
	var files = $("#uploadfile").val();
	if (files == "") {
		alert("嘿！您老还没选择要上传的文件呢（O_*）");
		return false;
	} else {
		document.dataForm.action = "uploadProAction";
	}
}


//翻页查看项目

function fanyepro(obj){
	var pageNow=obj;
	var url1=url+'/Fanyepro';
	
	var startpage = 1;
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"pageNow":pageNow,	
			
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			var thisstr="";
			
			if(str.isempty==false){
				//table表的显示
				
				$.each(str.jsona, function(){
					var tr1='<td><a id="#modal-container-72251" href="javascript:void(0);" data-toggle="modal" style="text-decoration: none;">'+this.project_name+'</a></td>';      
					var tr2='<td>'+this.project_principal+'</td>';
					var tr3='<td>'+this.section_name+'</td>';
					var tr4='<td><a href="downloadpro?filename=('+this.project_file+')"  style="text-decoration:none;" >下载</a></td>';
					var tr5='<td>'+this.project_uptime+'</td>';			
					var tr7= '<td><a href="javascript:void(0);" onclick="findpro('+this.project_id+')" style="text-decoration: none;">';
					var tr8= '<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a></td></tr>';		
					thisstr = thisstr+tr1+tr2+tr3+tr4+tr5+tr7+tr8;
					document.getElementById('probody01').innerHTML=thisstr;		
					
				});
				
				var listring = "<tr><th>第<span id='m_pagenow'>" + str.pageNow + "</span>/<span id='m_pagecount'>"+ str.pageCount +"</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if(str.pageNow!=1){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyepro(" +startpage+ ");'>首页</a></li>";
				}
				if(str.isHasPrev){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyepro(" + str.getPervPage + ");'>上页</a></li>";
				}
				if(str.isHasNext){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyepro(" + str.getNextPage + ");'>下页</a></li>";
				}
				if(str.pageCount!=str.pageNow){
					listring = listring + "<li><a href='javascript:void(0);' onclick='fanyepro(" + str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if(str.pageCount!=1){
					listring = listring + "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th></tr>";
				}
				
				$("#relist").html(listring);
				
			}else{
				var tr1 = '<td></td>';
				var tr2 = '<td>暂无信息...</td>';
				var tr3 = '<td></td>';
				var tr4 = '<td></td>';
				thisstr = thisstr + tr1 + tr2 + tr3 + tr4;
				document.getElementById('probody01').innerHTML=thisstr;		
				
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
	
}

//刷新项目信息

function shuaxinproject(){
	var url1=url+'/refreshproject';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
		}, 
		success:function(data) {			
			var str = eval("("+data+")");
			if(str.isempty==false){
				var thisstr="";			
				$.each(str.jsona, function() {
					var tr1='<td><a id="#modal-container-72251" href="javascript:void(0);" data-toggle="modal" style="text-decoration: none;">'+this.project_name+'</a></td>';      
					var tr2='<td>'+this.project_principal+'</td>';
					var tr3='<td>'+this.section_name+'</td>';
					var tr4='<td><a href="javascript:void(0)"  style="text-decoration:none;" >下载</a></td>';
					var tr5='<td>'+this.project_uptime+'</td>';			
					var tr7= '<td><a href="javascript:void(0);" onclick="findpro('+this.project_id+')" style="text-decoration: none;" data-target="#modal-container-723" data-toggle="modal">';
					var tr8= '<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deleteProject('+this.project_id+')">'
                        +'<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a</td></tr>';		
					thisstr = thisstr+tr1+tr2+tr3+tr4+tr5+tr7+tr8;
					document.getElementById('probody').innerHTML=thisstr;		
					});
				
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息...</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";		
				thisstr = thisstr +  + tr1 + tr2 + tr3 + tr4 ;
				document.getElementById('probody').innerHTML=thisstr;			
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});	
}

//删除项目的方法
function deleteProject(id){
	url = url+'/deleteProject';
	if(confirm("是否确定删除？")){
		$.ajax({
			type:'post',
			datetype:'html',
			url:url,
			cache:false,
			data:{
				"project_id":id
			}, 
			success:function(data) {
				alert("操作成功！！")
				shuaxinproject()
			},
			error:function(data) {
				alert("操作失败，请刷新后重新操作！！");
			}
		});	
	}
}


//日志板块///////////////
//////////////////

//添加日志类型
function addLogtype(){
	var lt_name=$("#lt_name").val();
	var lt_remark=$("#lt_remark").val();
	url1=url+'/addLogtype';
	
	$.ajax({   
		type:'POST', //用POST方式传输   
		url:url1,      //目标地址 
		dataType:'html',       
		data:{
			 "lt_name":lt_name,
			 "lt_remark":lt_remark
			
		},
		cache:false,
		success:function(data) {
			alert("添加成功！！");
			$("#modal-container-184703").modal("hide");
			shuaxinLogtype();
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
		}
    });
	
}

//删除日志类型
function dellogtype(obj){
	var lt_id=obj;
	url1=url+'/deleteLtype';
	if(confirm("是否确定删除？"))$.ajax({   
		type:'POST', //用POST方式传输   
		url:url1,      //目标地址 
		dataType:'html',       
		data:{
			 "lt_id":lt_id		
		},
		cache:false,
		success:function(data) {
			alert("删除成功！！");
			shuaxinLogtype();
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
		}
    });	
}

//根据id查找logtype的信息
function findtypebyid(obj){
	var lt_id=obj;
	url1=url+'/findLTbyid';
$.ajax({   
		type:'POST', //用POST方式传输   
		url:url1,      //目标地址 
		dataType:'html',       
		data:{
			 "lt_id":lt_id		
		},
		cache:false,
		success:function(data) {
			var str = eval("("+data+")");
			$("#lt_name").html(str.lt_name);
			document.getElementById("lt_id").innerHTML=obj;
		},
		
    });	
}

//保存编辑信息（logtype）
function savelogtype(){
	var lt_id=$("#lt_id").html();
	
	var lt_name=$("#ltname").val();
	url1=url+'/save_logtype';
	url2=url+'/ViewLogtype';
	$.ajax({   
		type:'POST', //用POST方式传输   
		url:url1,      //目标地址 
		dataType:'html',       
		data:{
			 "lt_id":lt_id,
			 "lt_name":lt_name
			 
		},
		cache:false,
		success:function(data) {
			$("#modal-container-18471").modal("hide");
			window.location.href=url2;
		},
		error:function(data){
			alert("操作失败，请刷新后重新操作！！");
		}
    });	
}

//刷新日志类型信息

function shuaxinLogtype(){
	var url1=url+'/refreshLtype';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
		}, 
		success:function(data) {			
			var str = eval("("+data+")");
			if(str.isempty==false){
				var thisstr="";		
		$.each(str.jsona, function() {
			       				
			var tr1='<td>'+this.lt_name+'</td>';
			var tr7='<td></td>';
			var tr2='<td>'+this.lt_time+'</td>';
			var tr3= '<td><a href="javascript:void(0);" onclick="findtypebyid('+this.lt_id+')" style="text-decoration: none;">';
			var tr4='<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>&nbsp;';
			var tr5 = '<a href="javascript:void(0);"  onclick="dellogtype('+this.lt_id+')" style="text-decoration: none;">';
			var tr6 = '<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a></td></tr>';
			thisstr = thisstr + tr1+tr7+tr7+tr2+tr3+tr4+tr5+tr6;
			});
			document.getElementById('ltbody').innerHTML=thisstr;		
		}else{
			var thisstr = "";
			var tr1 = "<td></td>";
			var tr2 = "<td>暂无信息...</td>";
			var tr3 = "<td></td>";
			var tr4 = "<td></td>";
			
			thisstr = thisstr + "<tr>" + tr1  +tr7+tr7+tr2 + tr3 + tr4
					  + "</tr>";
			document.getElementById('ltbody').innerHTML=thisstr;
			
		}
},
	error:function(data) {
		alert("操作失败，请刷新后重新操作！！");
	}
});	
}


///日志模块////////////////
////////////////////////

//保存并发布日志
function  addlog(){
	var log_sub=$("#log_sub").val();
	var ltcontent=$("#log_con").val();
	var lt_name=$("#ltype_name").val();
	url1=url+'/addLog';
	url2=url+'/findloginfo';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
		"l_subject":log_sub,
		"l_content":ltcontent,
		"lt_name":lt_name,
		
		}, 
		success:function(data) {
    	alert("增加成功！");
    	window.location.href=url2;
        } 
    });
}

//添加日志到草稿箱
function adddrafts(){
	var log_sub=$("#log_sub").val();
	var ltcontent=$("#log_con").val();
	var lt_name=$("#ltype_name").val();
	url1=url+'/addDrafts';
	url2=url+'/findloginfo';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
		"l_subject":log_sub,
		"l_content":ltcontent,
		"lt_name":lt_name,		
		}, 
		success:function(data) {
    	alert("增加成功！");
    	window.location.href=url2;
        } 
    });
}

//返回到查看日志界面
function chakanlog(){
	url2=url+'/findloginfo';
	window.location.href=url2;
}

//根据日志类型(logtype) 查看日志 =====正在修改
function ViewlogBytype(obj){
	var lt_id=obj;
	
	var url1=url+'/ViewLogbyType';	
	
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"lt_id":lt_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			if(str.isempty==false){
				//table表的显示
				var thisstr="";			
				$.each(str.jsona, function() {
					var tr1='<td><p><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" data-target="#modal-container-18477">'+this.l_subject+'</a></p>';
					var tr2='<p class="p13-999">赞(<>)&nbsp;&nbsp;&nbsp;&nbsp;评论(<>)&nbsp;&nbsp;&nbsp;</p></td>';
					var tr8='<td>'+this.l_time+'</td>';
					var tr3= '<td><a href="javascript:void(0);" onclick="findlogByid('+this.l_id+')" style="text-decoration: none;">';
					var tr4='<img src="img/edit.png"  data-toggle="tooltip" data-placement="bottom" title="编辑"/></a>&nbsp;';
					var tr5 = '<a href="javascript:void(0);"  onclick="dellogtype('+this.lt_id+')" style="text-decoration: none;">';
					var tr6 = '<img src="img/del.png"  data-toggle="tooltip" data-placement="bottom" title="删除"/></a></td></tr>';
					var tr7='<td></td>';
					thisstr = thisstr + tr1+tr2+tr7+tr7+tr8+tr3+tr4+tr5+tr6;						
				});								
				document.getElementById('log01').innerHTML=thisstr;
				document.getElementById("lt_name").innerHTML=str.lt_name;
			
			}else{
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息....</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						  +tr5+ "</tr>";
				document.getElementById('log01').innerHTML=thisstr;
				document.getElementById("lt_name").innerHTML=str.lt_name;	
			}
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});	
}


//根据id查找日志 查看详细信息

function findlogByid(obj){
	var l_id=obj;
	var url1=url+'/findLogByid';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"l_id":l_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			$("#log_title2").html(str.l_subject);
			$("#l_con2").html(str.l_content);//内容
			$("#l_time2").html(str.l_time);
			$("#l_member").html(str.l_member);
			
			
        } 
    });
}

function findlogByid2(obj){
	var l_id=obj;
	var url1=url+'/findLogByid';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"l_id":l_id,	
		}, 
		success:function(data) {
			var str = eval("("+data+")");
			$("#log_title1").html(str.l_subject);
			$("#log_content1").html(str.l_content);//内容	
			$("#log_type").html(str.lt_name);
			/*$("#l_zan2").html(赞+str.l_zan);*/
			document.getElementById("l_id").innerHTML=obj;
			
        } 
    });
}

function deletelogByid(obj){
	var l_id=obj;	
	var url1=url+'/deletelogByid';
	
	if(confirm("是否确定删除？"))$.ajax({
	type:'post',
	datetype:'html',
	url:url1,
	cache:false,
	data:{
	"l_id":l_id,
		
	}, 
	success:function(data) {
	alert("删除成功！");
	window.location.href=url2;
    } 
    });
	
}

//日志进行编辑（保存发布）
function publishlog(){
	var l_id=$("#l_id").val();
	var l_content=$("#log_content1").val();
	var l_title=$("#log_title1").val();
	var lt_name=$("#log_type").val();
	var l_purview=$("#l_purview").val();
	var url1=url+'/EditLog';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"l_id":l_id,	
			"l_content":log_content,
			"l_title":l_title,
			"lt_name":lt_name,
			"l_purview":l_purview,
		}, 
		success:function(data) {
			alert("发表成功");
			
        } 
    });
	
}

//将编辑的日志存为草稿
function publishlog2(){
	var l_id=$("#l_id").val();
	var l_content=$("#log_content1").val();
	var l_title=$("#log_title1").val();
	var lt_name=$("#log_type").val();
	var l_purview=$("#l_purview").val();
	var url1=url+'/EditLog2';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"l_id":l_id,	
			"l_content":log_content,
			"l_title":l_title,
			"lt_name":lt_name,
			"l_purview":l_purview,
		}, 
		success:function(data) {
			alert("存入草稿箱！");
			
        } 
    });
	
}



