var url = 'http://'+window.location.host+'/IISMP';

function spinnerstart(){
	$("#spinnerid").css('display', 'block');
	$("#tempid").css('display','block');
}
function spinnerend(){
	$("#spinnerid").css('display', 'none');
	$("#tempid").css('display','none');
}

/**
 * 首页查询出通讯录的方法
 * @param obj
 */
function openmemberinfos(obj){
	spinnerstart();
	var sectionname = obj;

	$("#announcementid").hide();
	$("#stydyplanid").hide();
	$("#memberinfosid").show();
	var url22 = url + '/openmemberinfosmethod';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"html",       
        data:{
        	"m_sectionname":sectionname
        	},
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	//alert(str.infos);
        	var thisstr = '';
        	if(str.isempty){
	        	$.each(str.jsona, function() {
	        	   var t1 = '<tr><td style="width: 55px;">';
	        	   var t2 = '';
	        	   if(this.m_userpicture != "-"){
	        		   t2 = '<img id="imgId" src="'+this.m_userpicture+'" class="img-responsive" style="border-radius: 50%;width: 48px;height: 50px;"/></td>';
	        	   }else{
	        		   t2 = '<img id="imgId" src="userpicture/default-user.png" class="img-responsive" style="border-radius: 50%;width: 48px;height: 50px;"/></td>';
	        	   }
	        	   var t3 = '<td><p><a style="text-decoration: none;">'+this.m_truename+'</a>&nbsp;&nbsp;';
			       var t4 = '';
			       if(this.m_sex=="男"){
			    	   t4 = '<img src="img/man.png" style="width:13px;height:15px;margin-top:-2px;">';
			       }else{
			    	   t4 = '<img src="img/woman.png" style="width:11px;height:15px;margin-top:-2px;">';
			       }
			       var t5 = '</p><p>'+this.m_email+'</p></td>';
			       var t6 = '<td><p>'+this.m_sectionname+'&nbsp;&nbsp;|&nbsp;&nbsp;'+this.m_role+'</p><p>'+this.m_phone+'</p></td></tr>';
			       thisstr = thisstr + t1+t2+t3+t4+t5+t6;
	        	});  
        	}else{
        		var t1 = '<tr><td style="width: 55px;">无信息...';
		        var t2 = '</td>';
		        var t3 = '<td></td>';
		        var t4 = '<td></td></tr>';
		        thisstr = thisstr + t1+t2+t3+t4;
        	}
        	$("#memberinfostbodyid").html(thisstr);
        	spinnerend();
        },
        error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 首界面显示学习计划的方法
 */
function openmyplaninfosindex(){
	spinnerstart(); 
	var lstarttime = $("#time1").val();
	var lendtime = $("#time2").val();
	$("#announcementid").hide();
	$("#stydyplanid").show();
	$("#memberinfosid").hide();
	var url22 = url + '/openmyplaninfosindex';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"html",       
        data:{
        	"lstarttime":lstarttime,
        	"lendtime":lendtime
        	},
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
					var t1 = '<tr><td><a style="text-decoration: none" href="javascript:void(0);" onclick="findthisplaninfo('+this.id+');" data-toggle="modal" data-target="#modal-container-7225200">'+this.ltitle+'</a></td>';
					var t2 = '<td class="p13-999">'+this.lstarttime+'~'+this.lendtime+'</td><td class="p13-999">'+this.ldaylong+'天</td>';
					var t3 = '<td class="p13-999">'+this.updatetime+'</td>';
					
					thisstr = thisstr + t1 + t2 + t3;
	        	});
	        }else{
	        	thisstr = '<tr><td>无信息...</td><td></td><td></td></tr>';
	        }
        	$("#indexlearnplantbodyid").html(thisstr);
        	spinnerend();
        },
        error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}
/**
 * 打开公告栏
 * @param obj
 */
function openmyannoinfomations(obj){
	//alert("公告");
	spinnerstart(); 
	var startpage = 1;
	var pageNow = obj;
	$("#announcementid").show();
	$("#stydyplanid").hide();
	$("#memberinfosid").hide();
	url1 = url + '/findIndexAnnoun';
	$.ajax({
		type:'post',
		datetype:'html',
		url:url1,
		cache:false,
		data:{
			"pageNow":pageNow
		},
		success:function(data) {
			var str = eval("("+data+")");
			if(str.isempty==false){
				//table表的显示
				var thisstr="";
				$.each(str.jsona, function() {
					var t1 = '';
					if(this.state==2){
						t1 = '<tr><td><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" onclick="findthisannouncementinfo(' + this.id + ');" data-target="#modal-container-722522">(<span style="color:red">新</span>) ' + this.title + '</a></td>';
					}else{
						t1 = '<tr><td><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" onclick="findthisannouncementinfo(' + this.id + ');" data-target="#modal-container-722522">' + this.title + '</a></td>';
					}
					var t2 = '<td class="p13-999">' + this.time + '</td><td class="p13-999">' + this.m_username + '</td>';
					var t3 = '<td class="p13-999">' + this.views + '</td></tr>';
					
					thisstr = thisstr+t1+t2+t3;
				});
				$("#annotbodyid").html(thisstr);
	        	
			}else{
				var t1 = '<tr><td>无信息...</td><td></td><td></td><td></td></tr>';
				thisstr = thisstr + t1;
				$("#annotbodyid").html(thisstr);
			}
			//重新查询的未读公告数量
			if(str.noState==0){
				 var obj = document.getElementById("noStateAnnoNum");
				 var parent00 = obj.parentNode;
				 parent00.removeChild(obj);
			}else{
				$("#noStateAnnoNum").html(str.noState);
			}
			spinnerend();
		},
		error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend(); 
		}
	});
	spinnerend();
}

///////////////////////////////////////////////////////////////////////////

//              学习计划

///////////////////////////////////////////////////////////////////////////


/**
 * 新建学习计划的检验
 */
function checkthistime1(){
	var time1 = $("#datepicker").val();
	if(time1==""){
		alert("时间段不能为空！！");
		return false;
	}
}
function checkthistime2(){
	var time1 = $("#datepicker").val();
	var time2 = $("#datepicker0").val();
	if(time2==""){
		alert("时间段不能为空！！");
		return false;
	}
	if(time1>=time2){
		alert("第一个时间不能大于或等于第二个时间！！");
		$("#datepicker0").val("");
		return false;
	}
}
$(document).ready(function(){
	function fillzero(v){
		if(v<10){
			v="0"+v;
		}
		return v;
	}
	var time = new Date(); //获取当前时间  
	var year = time.getFullYear(); //获取当前年份  
	var month = time.getMonth() + 1; //获取当前月份(getMonth()的取值范围为0~11)  
	var date = time.getDate(); //获取当前日期  
	var times = year +"-"+ fillzero(month) +"-"+ fillzero(date);
	$("#datepicker").val(times);
});

/**
 * 立即发布的方法
 */
function lijifabu(){
	var time1 = $("#datepicker").val();
	var time2 = $("#datepicker0").val();
	var ltitle = $("#ltitle").val();
	var lcontent = $("#lcontent").val();
	var lsummarize = $("#lsummarize").val();
	var url22 = url + '/lijifabumethod';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"html",       
        data:{
        	"lstarttime":time1,
        	"lendtime":time2,
        	"ltitle":ltitle,
        	"lcontent":lcontent,
        	"lsummarize":lsummarize
        	},
		cache:false,
        success:function(data) {
        	/*var str = eval("("+data+")");*/
        	alert("发布成功！！");
        	url1 = url +'/findlearnplaninfo';
        	window.location.href = url1;
        },
        error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}

/**
 * 刷新界面的方法
 */
function flushlearnplaninfo(obj){
	$("#spinnerid").css('display','block');
	var pageNow = obj;
	var lstarttime = $("#time1").val();
	var lendtime = $("#datepicker0").val();
	url22 = url + '/flushlearnplaninfo';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"pageNow":pageNow,
        	"lendtime":lendtime,
        	"lstarttime":lstarttime 
        	},
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
					var t1 = '<tr><td><a href="javascript:void(0);" onclick="findthisplaninfo('+this.id+');" data-toggle="modal" data-target="#modal-container-722522">'+this.ltitle+'</a></td>';
					var t2 = '<td class="p13-999">'+this.lstarttime+'~'+this.lendtime+'</td><td class="p13-999">'+this.ldaylong+'天</td>';
					var t3 = '<td class="p13-999">'+this.updatetime+'</td>';
					var t4 = '<td><a  type="button" style="cursor:pointer;" onclick="findthisplaninfoandshow('+this.id+');" data-toggle="modal" data-target="#modal-container-722544" href="javascript:void(0);" style="text-decoration: none;">编辑</a>&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="deletethisplanbyid('+this.id+');" style="text-decoration: none;">删除</a></td></tr>';
					
					thisstr = thisstr + t1 + t2 + t3 + t4;
	        	});
	        }else{
	        	thisstr = '<tr><td>无信息...</td><td></td><td></td><td></td></tr>';
	        }
        	$("#learnplantbodyid").html(thisstr);
        	
        	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
			if(str.pageNow!=1){
				tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo(1);">首页</a></li>';
			}
			if(str.isHasPrev){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.prevpage+');">上页</a></li>';
			}
			if(str.isHasNext){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.nextpage+');">下页</a></li>';
			}
			if(str.pageNow!=str.pageCount){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.pageCount+');">尾页</a></li>';
			}
			tt1 = tt1 + '</ul></th>';
			if(str.pageNow!=1){
				tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
			}
			$("#learnplantrfenyeid").html(tt1);	
			$("#spinnerid").css('display','none');
        },
        error:function(data) {
			alert("操作失败，请刷新后重新操作！！");
			$("#spinnerid").css('display','none');
		}
	});
}

/**
 * 按计划时间查询
 */
function findthistimelearnplaninfo(){
	var pageNows = $("#pageNows").html();
	//alert("anshijianchaxun");
	flushlearnplaninfo(pageNows);
}

/**
 * 根据id查询出该条信息，并显示到模态框上
 */
function findthisplaninfo(obj){
	$("#spinnerid").css('display','block');
	var id = obj;
	//alert(id);
	url22 = url + '/findthisplaninfobyid';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"id":id
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	$("#x_title").html(str.ltitle);
        	$("#x_starttime").html(str.lstarttime);
        	$("#x_lendtime").html(str.lendtime);
        	$("#x_updatetime").html(str.updatetime);
        	$("#x_content").html(str.lcontent);
        	$("#x_summarize").html(str.lsummarize);
        	$("#x_ldaylong").html(str.ldaylong+"天");
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 查询出这条计划的详细信息并显示到编辑的模态框中
 */
function findthisplaninfoandshow(obj){
	$("#spinnerid").css('display','block');
	var id = obj;
	//alert(id);
	url22 = url + '/findthisplaninfoandshow';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"id":id
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	$("#e_title").val(str.ltitle);
        	$("#time11").val(str.lstarttime);
        	$("#time22").val(str.lendtime);
        	$("#e_content").html(str.lcontent);
        	$("#e_summarize").html(str.lsummarize);
        	$("#planid").html(str.id);
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 保存修改后的计划信息
 */
function updatelearnplan(){
	$("#spinnerid").css('display','block');
	var ltitle = $("#e_title").val();
	var time11 = $("#time11").val();
	var time22 = $("#time22").val();
	var lstarttime = $("#time1").val();
	var lendtime = $("#datepicker0").val();
	var lcontent = $("#e_content").val();
	var lsummarize = $("#e_summarize").val();
	var id = $("#planid").html();
	var pageNow = $("#pageNows").html();
	
	url22 = url + '/updatelearnplan';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"ltitle":ltitle,
        	"id":id,
        	"lstarttime":lstarttime,
        	"lendtime":lendtime,
        	"lcontent":lcontent,
        	"lsummarize":lsummarize,
        	"pageNow":pageNow,
        	"time11":time11,
        	"time22":time22
        },
		cache:false,
        success:function(data) {
        	//var str = eval("("+data+")");
        	alert("操作成功！！");
        	
			var str = eval("("+data+")");
        	//alert("sdf"+str.pageNow);
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
					var t1 = '<tr><td><a href="javascript:void(0);" onclick="findthisplaninfo('+this.id+');" data-toggle="modal" data-target="#modal-container-722522">'+this.ltitle+'</a></td>';
					var t2 = '<td class="p13-999">'+this.lstarttime+'~'+this.lendtime+'</td><td class="p13-999">'+this.ldaylong+'天</td>';
					var t3 = '<td class="p13-999">'+this.updatetime+'</td>';
					var t4 = '<td><a  type="button" style="cursor:pointer;" onclick="findthisplaninfoandshow('+this.id+');" data-toggle="modal" data-target="#modal-container-722544" href="javascript:void(0);" style="text-decoration: none;">编辑</a>&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="deletethisplanbyid('+this.id+');" style="text-decoration: none;">删除</a></td></tr>';
					
					thisstr = thisstr + t1 + t2 + t3 + t4;
	        	});
	        }else{
	        	thisstr = '<tr><td>无信息...</td><td></td><td></td><td></td></tr>';
	        }
        	$("#learnplantbodyid").html(thisstr);
        	
        	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
			if(str.pageNow!=1){
				tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo(1);">首页</a></li>';
			}
			if(str.isHasPrev){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.prevpage+');">上页</a></li>';
			}
			if(str.isHasNext){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.nextpage+');">下页</a></li>';
			}
			if(str.pageNow!=str.pageCount){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.pageCount+');">尾页</a></li>';
			}
			tt1 = tt1 + '</ul></th>';
			if(str.pageNow!=1){
				tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
			}
			$("#learnplantrfenyeid").html(tt1);	
			//关闭模态框
			$("#modal-container-722544").modal("hide");
			$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 删除这条计划的方法
 */
function deletethisplanbyid(obj){
	$("#spinnerid").css('display','block');
	var id = obj;
	var pageNow = $("#pageNows").html();
	var lstarttime = $("#time1").val();
	var lendtime = $("#datepicker0").val();
	url22 = url + '/deletethisplanbyid';
	if(confirm("是否确定删除这条计划？")){
		$.ajax({   
	    	type:'POST', //用POST方式传输   
	        url:url22,      //目标地址 
	        datatype:"json",       
	        data:{
	        	"id":id,
	        	"lstarttime":lstarttime,
	        	"lendtime":lendtime,
	        	"pageNow":pageNow,
	        },
			cache:false,
	        success:function(data) {
	        	alert("操作成功！！");
	        	
				var str = eval("("+data+")");
	        	var thisstr = "";
	        	if(str.isempty){
		        	$.each(str.jsona, function() {
						var t1 = '<tr><td><a href="javascript:void(0);" onclick="findthisplaninfo('+this.id+');" data-toggle="modal" data-target="#modal-container-722522">'+this.ltitle+'</a></td>';
						var t2 = '<td class="p13-999">'+this.lstarttime+'~'+this.lendtime+'</td><td class="p13-999">'+this.ldaylong+'天</td>';
						var t3 = '<td class="p13-999">'+this.updatetime+'</td>';
						var t4 = '<td><a href="javascript:void(0);" style="text-decoration: none;"  type="button" style="cursor:pointer;" onclick="findthisplaninfoandshow('+this.id+');" data-toggle="modal" data-target="#modal-container-722544">编辑</a>&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="deletethisplanbyid('+this.id+');" style="text-decoration: none;">删除</a></td></tr>';
						
						thisstr = thisstr + t1 + t2 + t3 + t4;
		        	});
		        }else{
		        	thisstr = '<tr><td>无信息...</td><td></td><td></td><td></td></tr>';
		        }
	        	$("#learnplantbodyid").html(thisstr);
	        	
	        	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
				if(str.pageNow!=1){
					tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo(1);">首页</a></li>';
				}
				if(str.isHasPrev){
					tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.prevpage+');">上页</a></li>';
				}
				if(str.isHasNext){
					tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.nextpage+');">下页</a></li>';
				}
				if(str.pageNow!=str.pageCount){
					tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushlearnplaninfo('+str.pageCount+');">尾页</a></li>';
				}
				tt1 = tt1 + '</ul></th>';
				if(str.pageNow!=1){
					tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
				}
				$("#learnplantrfenyeid").html(tt1);	
				$("#spinnerid").css('display','none');
	        },
	        error:function(data) {
	  			alert("操作失败，请刷新后重新操作！！");
	  			$("#spinnerid").css('display','none');
	  		}
	    });
	}
	$("#spinnerid").css('display','none');
}

/**
 * 返回到查看评估表界面
 */
function backevalu_index(){
	window.location.href = url +"/findallassesschartinfo";
}

/**
 * 清空模态框内容
 */
function clearthismodelinfo(){
	$("#add_assessname").val("");
	$("#add_time1").val("");
	$("#add_time2").val("");
}

/**
 * 检查时间
 */
function checktime1and2(){
	var time1 = $("#add_time1").val();
	var time2 = $("#add_time2").val();
	if(time1>time2){
		alert("第一个时间不能大于第二个时间！！");
		$("#add_time2").val("");
		return false;
	}
}

/**
 * 提交创建的评估表信息
 */
function saveassesschartinfo(){
	$("#spinnerid").css('display','block');
	var pageNowss = $("#pageNows").html();
	//alert(pageNowss);
	var assessname = $("#add_assessname").val();
	var time1 = $("#add_time1").val();
	var time2 = $("#add_time2").val();
	if(assessname==""){
		alert("评估表名称不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(time1==""){
		alert("评估区间不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(time2==""){
		alert("评估区间不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	url22 = url + '/saveassesschartinfo';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"pageNow":pageNowss,
        	"assessname":assessname,
        	"as_starttime":time1,
        	"as_endtime":time2
        },
		cache:false,
        success:function(data) {
        	alert("操作成功！！");
        	var str = eval("("+data+")");
        	if(!str.isexitchart){
        		var thisstr = "";
            	if(str.isempty){
    	        	$.each(str.jsona, function() {
    	        		var t1 = '<tr><td>'+this.assessname+'</td>';
    					var t2 = '<td><a href="openassessinfopage?id='+this.id+'" style="text-decoration: none;">评估</a>&nbsp;&nbsp;<a href="findfinalassessgrade?ac_id='+this.id+'" style="text-decoration: none;">查看结果</a></td>';
    					var t3 = '<td class="p13-999">'+this.as_starttime+'~'+this.as_endtime+'</td><td style="align:center;" class="p13-999">'+this.operatorname+'</td>';
    					var t4 = '<td class="p13-999">'+this.updatetime+'</td><td><a href="javascript:void(0);" onclick="deletethisassess('+this.id+')" style="text-decoration: none;">删除</a></td></tr>';
    					
    					thisstr = thisstr+ t1 + t2 + t3 + t4;
    	        	});
            	}
            	$("#evalutbody").html(thisstr);
            	
            	
            	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
    			if(str.pageNow!=1){
    				tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushassesschartinfo(1);">首页</a></li>';
    			}
    			if(str.isHasPrev){
    				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.prevpage+');">上页</a></li>';
    			}
    			if(str.isHasNext){
    				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.nextpage+');">下页</a></li>';
    			}
    			if(str.pageNow!=str.pageCount){
    				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.pageCount+');">尾页</a></li>';
    			}
    			tt1 = tt1 + '</ul></th>';
    			if(str.pageCount>2){
    				tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
    			}
    			$("#evalu_trid").html(tt1);	
        	}else{
        		alert("该表名已经存在！！");
        	}
        	
			//关闭模态框
			$("#modal-container-184701").modal("hide");
			$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 分页显示评估表的方法
 */
function flushassesschartinfo(obj){
	$("#spinnerid").css('display','block');
	//var pageNow = $("#pageNows").html();
	var pageNow = obj;
	var url22 = url +'/flushassesschartinfo';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"pageNow":pageNow
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	var role_num = str.role_num;
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
	        		var t1 = '<tr><td>'+this.assessname+'</td>';
	        		var t2 = '';
	        		if(role_num==1||role_num==2){
	        			t2 = '<td><a href="openassessinfopage?id='+this.id+'" style="text-decoration: none;">评估</a>&nbsp;&nbsp;<a href="findfinalassessgrade?ac_id='+this.id+'" style="text-decoration: none;">查看结果</a></td>';
	        		}else{
	        			t2 = '<td><a href="findfinalassessgrade?ac_id='+this.id+'" style="text-decoration: none;">查看结果</a></td>';
	        		}
					var t3 = '<td class="p13-999">'+this.as_starttime+'~'+this.as_endtime+'</td><td style="align:center;" class="p13-999">'+this.operatorname+'</td>';
					var t4 = '';
					if(role_num==1||role_num==2){
						t4 = '<td class="p13-999">'+this.updatetime+'</td><td><a href="javascript:void(0);" onclick="deletethisassess('+this.id+')" style="text-decoration: none;">删除</a></td></tr>';
					}else{
						t4 = '<td class="p13-999">'+this.updatetime+'</td><td><a href="javascript:void(0);" class="p13-999" style="text-decoration: none;">删除</a></td></tr>';
					}
					
					thisstr = thisstr+ t1 + t2 + t3 + t4;
	        	});
        	}
        	$("#evalutbody").html(thisstr);
        	
        	
        	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
			if(str.pageNow!=1){
				tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushassesschartinfo(1);">首页</a></li>';
			}
			if(str.isHasPrev){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.prevpage+');">上页</a></li>';
			}
			if(str.isHasNext){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.nextpage+');">下页</a></li>';
			}
			if(str.pageNow!=str.pageCount){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.pageCount+');">尾页</a></li>';
			}
			tt1 = tt1 + '</ul></th>';
			if(str.pageCount>2){
				tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
			}
			$("#evalu_trid").html(tt1);	
        	
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 刷新的方法
 */
function flushassesschart(){
	var pageNowss = $("#pageNows").html();
	flushassesschartinfo(pageNowss);
}

/**
 * 删除评估表的方法
 */
function deletethisassess(obj){
	var pageNowss = $("#pageNows").html();
	var id = obj;
	var url22 = url + '/deletethisassess';
	if(confirm("是否确定删除这张评估表？")){
		$("#spinnerid").css('display','block');
		$.ajax({   
	    	type:'POST', //用POST方式传输   
	        url:url22,      //目标地址 
	        datatype:"json",       
	        data:{
	        	"id":id,
	        	"pageNow":pageNowss
	        },
			cache:false,
	        success:function(data) {
	        	var str = eval("("+data+")");
	        	var thisstr = "";
	        	if(str.isempty){
		        	$.each(str.jsona, function() {
		        		var t1 = '<tr><td>'+this.assessname+'</td>';
						var t2 = '<td><a href="openassessinfopage?id='+this.id+'" style="text-decoration: none;">评估</a>&nbsp;&nbsp;<a href="findfinalassessgrade?ac_id='+this.id+'" style="text-decoration: none;">查看结果</a></td>';
						var t3 = '<td class="p13-999">'+this.as_starttime+'~'+this.as_endtime+'</td><td style="align:center;" class="p13-999">'+this.operatorname+'</td>';
						var t4 = '<td class="p13-999">'+this.updatetime+'</td><td><a href="javascript:void(0);" onclick="deletethisassess('+this.id+')" style="text-decoration: none;">删除</a></td></tr>';
						
						thisstr = thisstr+ t1 + t2 + t3 + t4;
		        	});
	        	}else{
	        		thisstr = '<tr ><td>无信息...</td><td></td><td></td><td></td><td></td><td></td></tr>';
	        	}
	        	$("#evalutbody").html(thisstr);
	        	
	        	
	        	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
				if(str.pageNow!=1){
					tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushassesschartinfo(1);">首页</a></li>';
				}
				if(str.isHasPrev){
					tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.prevpage+');">上页</a></li>';
				}
				if(str.isHasNext){
					tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.nextpage+');">下页</a></li>';
				}
				if(str.pageNow!=str.pageCount){
					tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushassesschartinfo('+str.pageCount+');">尾页</a></li>';
				}
				tt1 = tt1 + '</ul></th>';
				if(str.pageCount>2){
					tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
				}
				$("#evalu_trid").html(tt1);	
	        	
	        	$("#spinnerid").css('display','none');
	        },
	        error:function(data) {
	  			alert("操作失败，请刷新后重新操作！！");
	  			$("#spinnerid").css('display','none');
	  		}
	    });
	}
}

/**
 * 打开评估模态框，查询出所显示的信息的方法
 */
function findassessinfoBysection(obj){
	$("#spinnerid").css('display','block');
	var sectionname = obj;
	var typeinfo = $("#typeinfoid").html();
	var ac_id=$("#displayac_id").html();
	//alert(sectionname);
	var url22 = url + '/findassessinfoBysection';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"ac_id":ac_id,
        	"sectionname":sectionname,
        	"typeinfo":typeinfo
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	var typeinfo = str.typeinfo;
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
	        		var t1 = '<tr style="display: none;"><td id="displayac_id">'+this.ac_id+'</td></tr>';
	        		var t2 = '<tr ><td>'+this.username+'</td><td class="p13-999">'+this.sectionname+'</td>';
					var t3 = '<td style="align:center;">'+this.kaoqin+'</td><td>'+this.biaoxian+'</td>';
					var t4 = '<td>'+this.xiangmu+'</td><td>'+this.xinde+'</td><td>'+this.heji+'</td>';
					var t5 = '<td class="p13-999">'+this.updatetime+'</td>';
					if(typeinfo=="pinggu"){
						var t6 = '<td><p style="color:red;cursor:pointer;" onclick="findassessinfobyidmotai('+this.id+');" data-toggle="modal" data-target="#modal184705">评分</p></td></tr>';
						thisstr = thisstr+ t1 + t2 + t3 + t4 + t5 + t6;
					}
					else{
						thisstr = thisstr+ t1 + t2 + t3 + t4 + t5;
					}
	        	});
        	}else{
        		thisstr = '<tr ><td>无信息...</td><td></td><td></td><td></td><td></td><td></td></tr>';
        	}
        	$("#assesstbodyids").html(thisstr);
        	$("#pingjiachengyuanxinxi").html(sectionname);
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 打开并查询模态框信息
 */
function findassessinfobyidmotai(obj){
	$("#spinnerid").css('display','block');
	var id = obj;
	//alert(id);
	var url22 = url + '/findassessinfobyidmotai';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"id":id
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	$("#d1").val(str.kaoqin);
        	if(str.biaoxian!="0"){
        		$("#d2").val(str.biaoxian);
        	}else{
        		$("#d2").val("");
        	}
        	if(str.xiangmu!="0"){
        		$("#d3").val(str.xiangmu);
        	}else{
        		$("#d3").val("");
        	}
        	if(str.xinde!="0"){
        		$("#d4").val(str.xinde);
        	}else{
        		$("#d4").val("");
        	}
        	if(str.heji!="0"){
        		$("#d5").val(str.heji);
        	}else{
        		$("#d5").val("");
        	}
        	if(str.remarks!=""){
        		$("#remark").val(str.remarks);
        	}else{
        		$("#remark").val("");
        	}
        	$("#usernamepingfen").html(str.username);
        	$("#sectionnamepingfen").html(str.sectionname);
        	$("#assessgerenid").html(id);
        	
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 保存评估后的信息
 */
function saveAssessgerengrade(){
	var sectionname = $("#pingjiachengyuanxinxi").html();
	var ac_id=$("#displayac_id").html();
	var kaoqin = $("#d1").val();
	var biaoxian = $("#d2").val();
	var xiangmu = $("#d3").val();
	var xinde = $("#d4").val();
	var heji = $("#d5").val();
	var remark = $("#remark").val();
	var id= $("#assessgerenid").html();
	var reg1 = /^([12][0-9]|30|[0-9])$/;
	if(kaoqin==""){
		alert("考勤评分不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(!reg1.test(kaoqin)){
		alert("考勤评分必须是30以内的正整数！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(biaoxian==""){
		alert("平时表现评分不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(!reg1.test(biaoxian)){
		alert("平时表现评分必须是30以内的正整数！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(xiangmu==""){
		alert("项目进度评分不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(!reg1.test(xiangmu)){
		alert("项目进度评分必须是30以内的正整数！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	var reg2 = /^(?:0|[0-9]?|10)$/;
	if(xinde==""){
		alert("心得体会评分不能为空！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	if(!reg2.test(xinde)){
		alert("心得体会评分必须是10以内的正整数！！");
		$("#spinnerid").css('display','none');
		return false;
	}
	var reg3 = /^(?:0|[1-9][0-9]?|100)$/;
	if(!reg3.test(heji)){
		alert("最终合计必须为100以内的正整数");
		return false;
	}
	var url22 = url + '/saveAssessgerengrade';
	spinnerstart();
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"id":id,
        	"kaoqin":kaoqin,
        	"biaoxian":biaoxian,
        	"xiangmu":xiangmu,
        	"xinde":xinde,
        	"heji":heji,
        	"remark":remark,
        	"sectionname":sectionname,
        	"ac_id":ac_id
        },
		cache:false,
        success:function(data) {
        	alert("评估成功！！");
        	var str = eval("("+data+")");
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
	        		var t1 = '<tr style="display: none;"><td id="displayac_id">'+this.ac_id+'</td></tr>';
	        		var t2 = '<tr ><td>'+this.username+'</td><td class="p13-999">'+this.sectionname+'</td>';
					var t3 = '<td style="align:center;">'+this.kaoqin+'</td><td>'+this.biaoxian+'</td>';
					var t4 = '<td>'+this.xiangmu+'</td><td>'+this.xinde+'</td><td>'+this.heji+'</td>';
					var t5 = '<td class="p13-999">'+this.updatetime+'</td>';
					var t6 = '<td><p style="color:red;cursor:pointer;" onclick="findassessinfobyidmotai('+this.id+');" data-toggle="modal" data-target="#modal184705">评分</p></td></tr>';
					
					thisstr = thisstr+ t1 + t2 + t3 + t4 + t5 + t6;
	        	});
        	}else{
        		thisstr = '<tr ><td>无信息...</td><td></td><td></td><td></td><td></td><td></td></tr>';
        	}
        	$("#assesstbodyids").html(thisstr);
        	$("#pingjiachengyuanxinxi").html(sectionname);
        	//关闭模态框
			$("#modal184705").modal("hide");
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
 * 分组查询出每个人的最终成绩
 */
function findfinalinfoBysection(obj){
	$("#spinnerid").css('display','block');
	var sectionname = obj;
	//alert(sectionname);
	var ac_id=$("#ac_iddisplay").html();
	//alert(ac_id);
	var url22 = url +'/findfinalBysectionAndac_id';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"sectionname":sectionname,
        	"ac_id":ac_id
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	var thisstr = '<tr style="display: none"><td id="ac_iddisplay">'+str.ac_idinfo+'</td></tr>';
        	if(str.isempty){
	        	$.each(str.jsona, function() {
	        		
	        		var t1 = '<tr><td>'+this.paiming+'</td><td><a href="javascript:void(0);" style="text-decoration: none;">'+this.username+'</a></td>';
	        		var t2 = '<td class="p13-999">'+this.sectionname+'</td><td style="align:center;">'+this.kaoqin+'</td>';
	        		var t3 = '<td>'+this.biaoxian+'</td><td>'+this.xiangmu+'</td><td>'+this.xinde+'</td>';
	        		var t4 = '<td>'+this.heji+'</td></tr>';
					
					thisstr = thisstr+ t1 + t2 + t3 + t4;
	        	});
        	}else{
        		thisstr = '<tr><td>无信息...</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
        	}
        	$("#finalassesschartid").html(thisstr);
        	$("#finalassesssectionid").html(sectionname);
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 刷新评估导出表的记录
 */
function flushexportassess(){
	$("#spinnerid").css('display','block');
	var url22 = url + '/flushexportassessaction';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{},
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	if(str.isexit){
        		alert("已经存在此表了！！");
        	}else{
	        	var thisstr = "";
	        	if(str.isempty){
		        	$.each(str.jsona, function() {
		        		
		        		var t1 = '<tr><td><span>'+this.exportname+'</span>&nbsp;&nbsp;';
		        		var t2 = '<a href="downloadassessFile?filename='+this.exportname+'" onclick="javascript:void(0);" style="text-decoration: none;">下载</a>&nbsp;&nbsp;';
		        		var t3 = '<a href="javascript:void(0);" onclick="deleteassessexportchart('+this.id+');" style="text-decoration: none;">删除</a>';
		        		var t4 = '</td><td>'+this.username+'</td><td>'+this.updatetime+'</td></tr>';
		        		
						thisstr = thisstr+ t1 + t2 + t3 + t4;
		        	});
	        	}else{
	        		thisstr = '<tr><td>无信息...</td><td></td><td></td></tr>';
	        	}
	        	$("#assessexportbodyid").html(thisstr);
        	}
        	
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 导出评估表的方法
 */
function committhisassesschart(){
	$("#spinnerid").css('display','block');
	var assessname = $("#assesschartselectid").val();
	var url22 = url +'/committhisassesschart';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"assessname":assessname
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	if(str.isexit){
        		alert("已经存在此表了！！");
        	}else{
	        	var thisstr = "";
	        	if(str.isempty){
		        	$.each(str.jsona, function() {
		        		
		        		var t1 = '<tr><td><span>'+this.exportname+'</span>&nbsp;&nbsp;';
		        		var t2 = '<a href="downloadassessFile?filename='+this.exportname+'" onclick="javascript:void(0);" style="text-decoration: none;">下载</a>&nbsp;&nbsp;';
		        		var t3 = '<a href="javascript:void(0);" onclick="deleteassessexportchart('+this.id+');" style="text-decoration: none;">删除</a>';
		        		var t4 = '</td><td>'+this.username+'</td><td>'+this.updatetime+'</td></tr>';
		        		
						thisstr = thisstr+ t1 + t2 + t3 + t4;
		        	});
	        	}else{
	        		thisstr = '<tr><td>无信息...</td><td></td><td></td></tr>';
	        	}
	        	alert("导出成功！！");
	        	
	        	$("#assessexportbodyid").html(thisstr);
        	}
        	//关闭模态框
			$("#modalexportassess").modal("hide");
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 导出评估表的删除的方法
 */
function deleteassessexportchart(obj){
	var id = obj;
	var url22 = url +'/deleteassessexportchart';
	
	if(confirm("是否确定删除这张评估表？")){
		$("#spinnerid").css('display','block');
		$.ajax({   
			type:'POST', //用POST方式传输   
	        url:url22,      //目标地址 
	        datatype:"json",       
	        data:{
	        	"id":id
	        },
			cache:false,
	        success:function(data) {
	        	var str = eval("("+data+")");
	        	if(str.isexit){
	        		alert("已经存在此表了！！");
	        	}else{
		        	var thisstr = "";
		        	if(str.isempty){
			        	$.each(str.jsona, function() {
			        		
			        		var t1 = '<tr><td><span>'+this.exportname+'</span>&nbsp;&nbsp;';
			        		var t2 = '<a href="downloadassessFile?filename='+this.exportname+'" onclick="javascript:void(0);" style="text-decoration: none;">下载</a>&nbsp;&nbsp;';
			        		var t3 = '<a href="javascript:void(0);" onclick="deleteassessexportchart('+this.id+');" style="text-decoration: none;">删除</a>';
			        		var t4 = '</td><td>'+this.username+'</td><td>'+this.updatetime+'</td></tr>';
			        		
							thisstr = thisstr+ t1 + t2 + t3 + t4;
			        	});
		        	}else{
		        		thisstr = '<tr><td>无信息...</td><td></td><td></td></tr>';
		        	}
		        	$("#assessexportbodyid").html(thisstr);
		        	alert("操作成功！！");
	        	}
	        	
	        	$("#spinnerid").css('display','none');
	        },
	        error:function(data) {
	  			alert("操作失败，请刷新后重新操作！！");
	  			$("#spinnerid").css('display','none');
	  		}
	    });
	}
}

/**
 * 查看所有的计划的分页的方法
 */
function flushallplaninfo(obj){
	$("#spinnerid").css('display','block');
	var pageNow = obj;
	var sectionname = $("#studysectionid").val();
	var time1 = $("#time1").val();
	var time2 = $("#time2").val();
	var url22 = url + '/flushallplaninfo';
	$.ajax({   
		type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"pageNow":pageNow,
        	"sectionname":sectionname,
        	"time11":time1,
        	"time22":time2
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	var thisstr = "";
        	if(str.isempty){
	        	$.each(str.jsona, function() {
	        		
	        		var t1 = '<tr><td><a href="javascript:void(0);" style="text-decoration: none;" data-toggle="modal" onclick="findallplaninfobyid('+this.id+');" data-target="#modal-container-722522">'+this.ltitle+'</a></td>';
	        		var t2 = '<td>'+this.username+'</td><td>'+this.sectionname+'</td>';
	        		var t3 = '<td class="p13-999">'+this.lstarttime+'~'+this.lendtime+'</td>';
	        		var t4 = '<td class="p13-999">'+this.ldaylong+'天</td>';
	        		var t5 = '<td class="p13-999">'+this.updatetime+'</td></tr>';
	        		
					thisstr = thisstr+ t1 + t2 + t3 + t4 +t5;
	        	});
        	}else{
        		thisstr = '<tr><td>无信息...</td><td></td><td></td><td></td><td></td><td></td></tr>';
        	}
        	$("#allplantbodyid").html(thisstr);
        	
        	var tt1 = '<th>第<span id="pageNows">'+str.pageNow+'</span>/'+str.pageCount+'页&nbsp;&nbsp;</th><th><ul class="pagination">';
			if(str.pageNow!=1){
				tt1 = tt1+ '<li><a href="javascript:void(0);" onclick="flushallplaninfo(1);">首页</a></li>';
			}
			if(str.isHasPrev){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushallplaninfo('+str.prevpage+');">上页</a></li>';
			}
			if(str.isHasNext){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushallplaninfo('+str.nextpage+');">下页</a></li>';
			}
			if(str.pageNow!=str.pageCount){
				tt1 = tt1 + '<li><a href="javascript:void(0);" onclick="flushallplaninfo('+str.pageCount+');">尾页</a></li>';
			}
			tt1 = tt1 + '</ul></th>';
			if(str.pageCount>3){
				tt1 = tt1 + '<th>&nbsp;&nbsp;</th><th><div class="col-lg-6"><div class="input-group"><input type="text" class="form-control" style="height: 30px;width: 45"><span class="input-group-btn"><button class="btn btn-default btn-sm" type="button">跳转</button></span></div></div></th>';
			}
			$("#allplantrfenyeid").html(tt1);	
        	
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}

/**
 * 根据具体条件查询的方法
 */
function findalllearnplaninfo(){
	var pageNow=1;
	flushallplaninfo(pageNow);
}

/**
 * 根据id查询出计划的详细内容
 */
function findallplaninfobyid(obj){
	$("#spinnerid").css('display','block');
	var id = obj;
	//alert(id);
	url22 = url + '/findallplaninfobyid';
	$.ajax({   
    	type:'POST', //用POST方式传输   
        url:url22,      //目标地址 
        datatype:"json",       
        data:{
        	"id":id
        },
		cache:false,
        success:function(data) {
        	var str = eval("("+data+")");
        	$("#ax_title").html(str.ltitle);
        	$("#ax_starttime").html(str.lstarttime);
        	$("#ax_lendtime").html(str.lendtime);
        	$("#ax_updatetime").html(str.updatetime);
        	$("#ax_content").html(str.lcontent);
        	$("#ax_summarize").html(str.lsummarize);
        	$("#ax_ldaylong").html(str.ldaylong+"天");
        	$("#ax_username").html(str.username);
        	$("#spinnerid").css('display','none');
        },
        error:function(data) {
  			alert("操作失败，请刷新后重新操作！！");
  			$("#spinnerid").css('display','none');
  		}
    });
}






/**
 * 上传文件的方法
 */
/*function uploadfile(){
	url22 = url + '/fileuploadlearnfile';
	 $.ajaxFileUpload({
	        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
	        url:url22,
	        secureuri:false,                       //是否启用安全提交,默认为false
	        fileElementId:'lfilename',           //文件选择框的id属性
	        dataType:'text',                       //服务器返回的格式,可以是json或xml等
	        success:function(data, status){        //服务器响应成功时的处理函数
	            data = data.replace("<PRE>", '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre>text</pre>前后缀
	            data = data.replace("</PRE>", '');
	            data = data.replace("<pre>", '');
	            data = data.replace("</pre>", ''); //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]
	            if(data.substring(0, 1) == 0){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
	                $("img[id='uploadImage']").attr("src", data.substring(2));
	                $('#result').html("图片上传成功<br/>");
	            }else{
	                $('#result').html('图片上传失败，请重试！！');
	            }
	            $('#result').html('修改头像成功' + data);
	        },
	        error:function(data, status, e){ //服务器响应失败时的处理函数
	            $('#result').html('图片上传失败，请重试！！');
	        }
	    });
}


*/




