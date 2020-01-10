var url = 'http://' + window.location.host + '/IISMP';

function spinnerstart(){
	$("#spinnerid").css('display', 'block');
	$("#tempid").css('display','block');
}
function spinnerend(){
	$("#spinnerid").css('display', 'none');
	$("#tempid").css('display','none');
}



/**
 * textarea限制<36
 * 
 * @param field
 */
function LimitTextArea36(field) {
	maxlimit = 36;
	if (field.value.length > maxlimit)
		field.value = field.value.substring(0, maxlimit);
}

/**
 * textarea限制<64
 * 
 * @param field
 */
function LimitTextArea64(field) {
	maxlimit = 64;
	if (field.value.length > maxlimit)
		field.value = field.value.substring(0, maxlimit);
}

/**
 * textarea限制<200
 * 
 * @param field
 */
function LimitTextArea200(field) {
	maxlimit = 200;
	if (field.value.length > maxlimit)
		field.value = field.value.substring(0, maxlimit);
}

/**
 * 打开新建公告界面
 */
function opennewannocement() {
	var url0 = url + '/openanno_newpage';
	window.location.href = url0;
	/*var url11 = url + '/findsectioninfo'
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url11, // 目标地址
		dataType : 'html',
		data : {
		},
		cache : false,
		success : function(data) {
			
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
		
	});*/
	
}

/**
 * 公告信息返回按钮
 */
function backpage() {
	var url1 = url + '/Functionality/announcement/anno_index.jsp';
	window.location.href = url1;
}

/**
 * 打开异常考勤
 */
function open_seerecord() {
	var url1 = url + '/findcheckrecordinfo';
	window.location.href = url1;
}

/**
 * 打开异常考勤
 */
function open_unusual() {

	url1 = url + '/open_unusualpage';
	// alert(url1);
	window.location.href = url1;
}

/**
 * 打开待处理申诉
 */
function open_pendingappeal() {
	// var url1 = url
	// +'/Functionality/attendence/atten_checkrecord_pending.jsp';
	var url2 = url + '/open_pendingappeal';
	// alert(url2);
	window.location.href = url2;
}

/**
 * li展开收起
 */
$(document).ready(function() {
	$("#mymenu ul li").next("ul").hide();
	$("#mymenu ul li").click(function() {
		$(this).next("ul").toggle();
	});
});

/**
 * 退出登录的方法
 */
function logoutmethod() {
	if (confirm("是否确定退出平台？")) {
		var url1 = url + '/logoutAction';
		window.location.href = url1;
	} else {
		return false;
	}
}

/**
 * 清空新建分组的input和textarea
 */
function clearinputfunction() {
	$("#sectionname").val("");
	$("#remark").val("");
}

// //////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////////////////////
// //
// 系统管理js文件 //
// //
// //////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * 添加分组信息的方法
 */
function newgroup() {
	spinnerstart();
	var sectionname1 = $("#sectionname").val();
	var remark1 = $("#remark").val();
	if (sectionname1 == "") {
		alert("新建的组名不能为空哦！！");
		return false;
	}
	var url11 = url + '/createnewgroup';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url11, // 目标地址
		dataType : 'html',
		data : {
			"sectionname" : sectionname1,
			"remark" : remark1
		},
		cache : false,
		success : function(data) {
			alert("添加分组成功！！");
			// 关闭模态框
			$("#modal-container-184705").modal("hide");
			var str = eval("(" + data + ")");
			var thisstr = "";
			$.each(str,function() {
				thisstr = thisstr+ "<tr><td>"
						+ this.section_name
						+ "</td><td>"
						+ this.time
						+ "</td><td>"
						+ this.remark
						+ "</td><td><a id='modal-722544' onclick='findsectioninfobyid("
						+ this.id
						+ ")' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deletethidsection("
						+ this.id
						+ ")' style='text-decoration: none'>删除</a></td></tr>";
			});
			document.getElementById('thistbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 根据id查询出section的信息并且动态显示到organ_structure_groupmanage.jsp界面
 */
function findsectioninfobyid(obj) {
	spinnerstart();
	var section_id = obj;
	var url1 = url + '/findsectioninfobyid';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"id" : section_id
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			$("#i_sectionname").val(str.sectionname);
			$("#i_remark").val(str.remark);
			$("#section_id").val(str.id);
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 保存编辑后的分组信息
 */
function section_saveeditinfo() {
	spinnerstart();
	var sectionname = $("#i_sectionname").val();
	var remark = $("#i_remark").val();
	var id = $("#section_id").val();
	var url1 = url + '/section_saveeditinfo';
	$.ajax({
		type : 'post',
		url : url1,
		datatype : 'html',
		data : {
			'sectionname' : sectionname,
			'remark' : remark,
			'id' : id
		},
		cache : false,
		success : function(data) {
			alert("编辑分组成功！！");
			// 关闭模态框
			$("#modal-container-722544").modal("hide");
			var str = eval("(" + data + ")");
			var thisstr = "";
			$.each(str,function() {
				thisstr = thisstr
						+ "<tr><td>"
						+ this.section_name
						+ "</td><td>"
						+ this.time
						+ "</td><td>"
						+ this.remark
						+ "</td><td><a id='modal-722544' onclick='findsectioninfobyid("
						+ this.id
						+ ")' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deletethidsection("
						+ this.id
						+ ")' style='text-decoration: none'>删除</a></td></tr>";
			});
			document.getElementById('thistbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}

	});
}

/**
 * 删除分组的方法
 * 
 * @param obj
 */
function deletethidsection(obj) {
	spinnerstart();
	var id = obj;
	url1 = url + '/deletesectionbyid';
	if (confirm("是否确定删除这条数据？")) {
		$.ajax({
			type : 'post',
			datetype : 'html',
			url : url1,
			cache : false,
			data : {
				'id' : id
			},
			success : function(data) {
				alert("删除分组成功！！");
				// 关闭模态框
				$("#modal-container-722544").modal("hide");
				var str = eval("(" + data + ")");
				var thisstr = "";
				$.each(str,function() {
					thisstr = thisstr
							+ "<tr><td>"
							+ this.section_name
							+ "</td><td>"
							+ this.time
							+ "</td><td>"
							+ this.remark
							+ "</td><td><a id='modal-722544' onclick='findsectioninfobyid("
							+ this.id
							+ ")' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deletethidsection("
							+ this.id
							+ ")' style='text-decoration: none'>删除</a></td></tr>";
				});
				document.getElementById('thistbody').innerHTML = thisstr;
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	} else {
		return false;
	}
}

/**
 * 刷新分组的方法
 */
function refreshsection() {
	spinnerstart();
	url1 = url + '/refreshsectionAciton';
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {},
		success : function(data) {
			var str = eval("(" + data + ")");
			var thisstr = "";
			$.each(str,function() {
				thisstr = thisstr
						+ "<tr><td>"
						+ this.section_name
						+ "</td><td>"
						+ this.time
						+ "</td><td>"
						+ this.remark
						+ "</td><td><a id='modal-722544' onclick='findsectioninfobyid("
						+ this.id
						+ ")' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deletethidsection("
						+ this.id
						+ ")' style='text-decoration: none'>删除</a></td></tr>";
			});
			document.getElementById('thistbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 清空添加新成员的界面
 */
function clearthisaddmemebr() {
	$("#username").val("");
	$("#truename").val("");
	$("#password").val("12345678");
	$("#an_section").val("实验室");
	$("#duty").val("组员");
	$("#phone").val("");
	$("#email").val("");
}

/**
 * 添加新成员的方法
 */
function savememberinfos() {
	spinnerstart();
	var section_names = $("#sectionss_names").html();
	var pageNow = $("#m_pagenow").val();
	var m_duty = $("#memberrole").val();
	var startpage = 1;
	var m_username = $("#username").val();
	var m_truename = $("#truename").val();
	var m_sex = $('#wrap input[name="sex"]:checked ').val();
	var m_password = $("#password").val();
	var m_section = $("#an_section").val();
	var member_duty = $("#duty").val();
	var m_phone = $("#phone").val();
	var m_email = $("#email").val();
	if (m_username == "") {
		alert("用户名不能为空！！");
		spinnerend();
		return false;
	}
	if (m_truename == "") {
		alert("真是姓名不能为空！！");
		spinnerend();
		return false;
	}
	if (m_password == "") {
		alert("密码不能为空！！");
		spinnerend();
		return false;
	}
	var ree = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9|1])\d{8}$)/;
	if(m_phone != null && m_phone != ""){
		if (!ree.exec(m_phone)) {
			alert("请输入正确的电话号码，\n\n如：0591-6487256，15005059587");
			spinnerend();
			return false;
		}
	}
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(m_email != null && m_email != ""){
		if (!filter.exec(m_email)) {
			alert("您的电子邮件格式不正确！！");
			spinnerend();
			return false;
		}
	}
	url1 = url + '/savememberinfos';
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {
			"m_username" : m_username,
			"m_truename" : m_truename,
			"m_sex" : m_sex,
			"m_password" : m_password,
			"m_section" : m_section,
			"m_duty" : m_duty,
			"m_phone" : m_phone,
			"m_email" : m_email,
			"pageNow" : pageNow,
			"member_duty" : member_duty,
			"section_names" : section_names
		},
		success : function(data) {
			// alert(data);
			alert("添加成员成功！！");
			// 关闭模态框
			$("#modal-container-722543").modal("hide");
			var str = eval("(" + data + ")");
			var listring = "<th>第<span id='m_pagenow'> "
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
			if (str.pageNow != 1) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ startpage + ");'>首页</a></li>";
			}
			if (str.isHasPrev) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.getPervPage + ");'>上页</a></li>";
			}
			if (str.isHasNext) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.getNextPage + ");'>下页</a></li>";
			}
			if (str.pageCount != str.pageNow) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.pageCount + ");'>尾页</a></li>";
			}
			listring = listring + "</ul></th>";
			if (str.pageCount != 1) {
				listring = listring
						+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
			}
			document.getElementById('member_tr').innerHTML = listring;

			var thisstr = "";
			$.each(str.jsona,function() {

				var tr1 = "<td><input type='checkbox' name='chethis' id='"
						+ this.m_id + "'></td>";
				var tr2 = "<td>" + this.m_truename
						+ "</td>";
				var tr3 = "<td>" + this.m_sex + "</td>";
				var tr4 = "<td>" + this.m_sectionname
						+ "</td>";
				var tr5 = "<td>" + this.m_role
						+ "</td>";
				var tr6 = "<td>" + this.m_username
						+ "</td>";
				var tr7 = "<td>" + this.m_email
						+ "</td>";
				var tr8 = "<td>" + this.m_phone
						+ "</td>";
				var tr9 = "<td><a id='modal-722544' onclick='findmembershipinfos("
						+ this.m_id
						+ ");' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='blockupthismember("
						+ this.m_id
						+ ")' style='text-decoration: none'>停用</a></td>";

				thisstr = thisstr + "<tr>" + tr1 + tr2
						+ tr3 + tr4 + tr5 + tr6 + tr7
						+ tr8 + tr9 + "</tr>";
			});
			document.getElementById('membertbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

$(function() {
	//$("#piliangxiugai").attr("disabled", "disabled");
	$('#allcheck').click(function() {
		if (this.checked) {
			$(":checkbox").prop("checked", true);
		} else {
			$(":checkbox").prop("checked", false);
		}
	});
	/*$(":checkbox").click(function() {
		if (this.checked) {
			$("#piliangxiugai").removeAttr("disabled");
		} else {
			$("#piliangxiugai").attr("disabled", "disabled");
		}
	});*/
});

/**
 * 停用成员的方法
 * 
 * @param obj
 */
function blockupthismember(obj) {
	spinnerstart();
	var section_names = $("#sectionss_names").html();
	var pageNow = $("#m_pagenow").val();
	var m_duty = $("#memberrole").val();
	var startpage = 1;
	var id = obj;
	if (confirm("是否确定停用此用户？")) {
		url1 = url + '/blockupthismember';
		$.ajax({
			type : 'post',
			datetype : 'html',
			url : url1,
			cache : false,
			data : {
				"id" : id,
				"pageNow" : pageNow,
				"m_duty" : m_duty,
				"section_names" : section_names
			},
			success : function(data) {
				// alert(data);
				alert("操作成功！！");
				var str = eval("(" + data + ")");
				// 分页按钮的显示
				var listring = "<th>第<span id='m_pagenow'>"
						+ str.pageNow
						+ "</span>/<span id='m_pagecount'>"
						+ str.pageCount
						+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if (str.pageNow != 1) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ startpage + ");'>首页</a></li>";
				}
				if (str.isHasPrev) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ str.getPervPage + ");'>上页</a></li>";
				}
				if (str.isHasNext) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ str.getNextPage + ");'>下页</a></li>";
				}
				if (str.pageCount != str.pageNow) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if (str.pageCount != 1) {
					listring = listring
							+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
				}
				document.getElementById('member_tr').innerHTML = listring;
				if (str.isempty == false) {
					// table表的显示
					var thisstr = "";
					$.each(str.jsona,function() {

						var tr1 = "<td><input type='checkbox' name='chethis' id='"
								+ this.m_id + "'></td>";
						var tr2 = "<td>"
								+ this.m_truename
								+ "</td>";
						var tr3 = "<td>" + this.m_sex
								+ "</td>";
						var tr4 = "<td>"
								+ this.m_sectionname
								+ "</td>";
						var tr5 = "<td>" + this.m_role
								+ "</td>";
						var tr6 = "<td>"
								+ this.m_username
								+ "</td>";
						var tr7 = "<td>" + this.m_email
								+ "</td>";
						var tr8 = "<td>" + this.m_phone
								+ "</td>";
						var tr9 = "<td><a id='modal-722544' onclick='findmembershipinfos("
								+ this.m_id
								+ ");' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='blockupthismember("
								+ this.m_id
								+ ")' style='text-decoration: none'>停用</a></td>";

						thisstr = thisstr + "<tr>"
								+ tr1 + tr2 + tr3 + tr4
								+ tr5 + tr6 + tr7 + tr8
								+ tr9 + "</tr>";
					});
					document.getElementById('membertbody').innerHTML = thisstr;
				} else {
					var thisstr = "";
					var tr1 = "<td></td>";
					var tr2 = "<td>暂无信息...</td>";
					var tr3 = "<td></td>";
					var tr4 = "<td></td>";
					var tr5 = "<td></td>";
					var tr6 = "<td></td>";
					var tr7 = "<td></td>";
					var tr8 = "<td></td>";
					var tr9 = "<td></td>";

					thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
							+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
					document.getElementById('membertbody').innerHTML = thisstr;
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}
	spinnerend();
}

/**
 * 根据id查找用户信息
 */
function findmembershipinfos(obj) {
	spinnerstart();
	// $("#wrap input[name='sex1']").attr('checked','false');
	// $("input:radio[name='sex1']").attr("checked",false);
	var id = obj;
	url1 = url + '/findmemberinfoByid';
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {
			"id" : id
		},
		success : function(data) {
			// alert(data);
			var str = eval("(" + data + ")");
			$("#username1").val(str.username);
			$("#truename1").val(str.truename);
			$("#password1").val(str.password);
			$("input[name='sex1'][value=" + str.sex + "]")
					.attr("checked", true);
			$("#section1").val(str.sectionname);
			$("#duty1").val(str.role);
			$("#phone1").val(str.phone);
			$("#email1").val(str.email);
			$("#member_id").val(str.id);
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 保存修改后的用户信息
 */
function saveeditmemberinfo() {
	spinnerstart();
	var section_names = $("#sectionss_names").html();
	var m_duty = $("#memberrole").val();
	var pageNow = $("#m_pagenow").val();
	var startpage = 1;
	var m_username = $("#username1").val();
	var m_truename = $("#truename1").val();
	var m_sex = $('#wrap input[name="sex1"]:checked').val();
	var m_password = $("#password1").val();
	var m_section = $("#section1").val();
	var member_duty = $("#duty1").val();
	var m_phone = $("#phone1").val();
	var m_email = $("#email1").val();
	var id = $("#member_id").val();
	if (m_username == "") {
		alert("用户名不能为空！！");
		spinnerend();
		return ;
	}
	if (m_truename == "") {
		alert("真是姓名不能为空！！");
		spinnerend();
		return ;
	}
	if (m_password == "") {
		alert("密码不能为空！！");
		spinnerend();
		return ;
	}
	var ree = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9|1])\d{8}$)/;
	if(m_phone != null && m_phone != ""){
		if (!ree.exec(m_phone)) {
			alert("请输入正确的电话号码，\n\n如：0591-6487256，15005059587");
			spinnerend();
			return ;
		}
	}
	
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(m_email != null && m_email != ""){
		if (!filter.exec(m_email)) {
			alert("您的电子邮件格式不正确！！");
			spinnerend();
			return ;
		}
	}
	url1 = url + '/saveeditmemberinfo';
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {
			"m_username" : m_username,
			"m_truename" : m_truename,
			"m_sex" : m_sex,
			"m_password" : m_password,
			"m_section" : m_section,
			"m_duty" : m_duty,
			"m_phone" : m_phone,
			"m_email" : m_email,
			"pageNow" : pageNow,
			"id" : id,
			"member_duty" : member_duty,
			"section_names" : section_names
		},
		success : function(data) {
			alert("操作成功！！");
			// 关闭模态框
			$("#modal-container-722544").modal("hide");
			var str = eval("(" + data + ")");
			// 分页按钮的显示
			var listring = "<th>第<span id='m_pagenow'>"
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
			if (str.pageNow != 1) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ startpage + ");'>首页</a></li>";
			}
			if (str.isHasPrev) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.getPervPage + ");'>上页</a></li>";
			}
			if (str.isHasNext) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.getNextPage + ");'>下页</a></li>";
			}
			if (str.pageCount != str.pageNow) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.pageCount + ");'>尾页</a></li>";
			}
			listring = listring + "</ul></th>";
			if (str.pageCount != 1) {
				listring = listring
						+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
			}
			document.getElementById('member_tr').innerHTML = listring;
			if (str.isempty == false) {
				// table表的显示
				var thisstr = "";
				$.each(str.jsona,function() {

					var tr1 = "<td><input type='checkbox' name='chethis' id='"
							+ this.m_id + "'></td>";
					var tr2 = "<td>" + this.m_truename
							+ "</td>";
					var tr3 = "<td>" + this.m_sex
							+ "</td>";
					var tr4 = "<td>"
							+ this.m_sectionname
							+ "</td>";
					var tr5 = "<td>" + this.m_role
							+ "</td>";
					var tr6 = "<td>" + this.m_username
							+ "</td>";
					var tr7 = "<td>" + this.m_email
							+ "</td>";
					var tr8 = "<td>" + this.m_phone
							+ "</td>";
					var tr9 = "<td><a id='modal-722544' onclick='findmembershipinfos("
							+ this.m_id
							+ ");' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='blockupthismember("
							+ this.m_id
							+ ")' style='text-decoration: none'>停用</a></td>";

					thisstr = thisstr + "<tr>" + tr1
							+ tr2 + tr3 + tr4 + tr5
							+ tr6 + tr7 + tr8 + tr9
							+ "</tr>";
				});
				document.getElementById('membertbody').innerHTML = thisstr;
			} else if (str.isempty == true) {
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息...</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				var tr6 = "<td></td>";
				var tr7 = "<td></td>";
				var tr8 = "<td></td>";
				var tr9 = "<td></td>";

				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
				document.getElementById('membertbody').innerHTML = thisstr;
			}
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 翻页按钮的点击事件
 * 
 * @param obj
 */
function pageuporpagedown(obj) {
	spinnerstart();
	$("#statespan").html("启用人员");
	$("#state").val("启用人员");
	var startpage = 1;
	var section_names = $("#sectionss_names").html();
	// alert(section_names);
	var m_duty = $("#memberrole").val();
	var pageNow = obj;
	url1 = url + '/pageuporpagedown';
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {
			"pageNow" : pageNow,
			"m_duty" : m_duty,
			"section_names" : section_names
		},
		success : function(data) {
			var str = eval("(" + data + ")");
			// 分页按钮的显示
			var listring = "<th>第<span id='m_pagenow'>"
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
			if (str.pageNow != 1) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ startpage + ");'>首页</a></li>";
			}
			if (str.isHasPrev) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.getPervPage + ");'>上页</a></li>";
			}
			if (str.isHasNext) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.getNextPage + ");'>下页</a></li>";
			}
			if (str.pageCount != str.pageNow) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
						+ str.pageCount + ");'>尾页</a></li>";
			}
			listring = listring + "</ul></th>";
			if (str.pageCount != 1) {
				listring = listring
						+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
			}
			document.getElementById('member_tr').innerHTML = listring;
			if (str.isempty == false) {
				// table表的显示
				var thisstr = "";
				$.each(str.jsona,function() {

					var tr1 = "<td><input type='checkbox' name='chethis' id='"
							+ this.m_id + "'></td>";
					var tr2 = "<td>" + this.m_truename
							+ "</td>";
					var tr3 = "<td>" + this.m_sex
							+ "</td>";
					var tr4 = "<td>"
							+ this.m_sectionname
							+ "</td>";
					var tr5 = "<td>" + this.m_role
							+ "</td>";
					var tr6 = "<td>" + this.m_username
							+ "</td>";
					var tr7 = "<td>" + this.m_email
							+ "</td>";
					var tr8 = "<td>" + this.m_phone
							+ "</td>";
					var tr9 = "<td><a id='modal-722544' onclick='findmembershipinfos("
							+ this.m_id
							+ ");' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='blockupthismember("
							+ this.m_id
							+ ")' style='text-decoration: none'>停用</a></td>";

					thisstr = thisstr + "<tr>" + tr1
							+ tr2 + tr3 + tr4 + tr5
							+ tr6 + tr7 + tr8 + tr9
							+ "</tr>";
				});
				document.getElementById('membertbody').innerHTML = thisstr;
			} else {
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息...</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				var tr6 = "<td></td>";
				var tr7 = "<td></td>";
				var tr8 = "<td></td>";
				var tr9 = "<td></td>";

				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
				document.getElementById('membertbody').innerHTML = thisstr;
			}
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 打开停用成员的信息
 */

function openblockupmember(obj) {
	spinnerstart();
	$("#statespan").html("停用人员");
	$("#state").val("停用人员");
	var pageNow = obj;
	var m_duty = $("#memberrole").val();
	var section_names = $("#sectionss_names").html();
	var startpage = 1;
	url1 = url + '/openblockupmember';
	
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {
			"pageNow" : pageNow,
			"m_duty" : m_duty,
			"section_names" : section_names
		},
		success : function(data) {
			
			var str = eval("(" + data + ")");
			var listring = "<th>第<span id='m_pagenow'>"
				+ str.pageNow
				+ "</span>/<span id='m_pagecount'>"
				+ str.pageCount
				+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
			if (str.pageNow != 1) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
						+ startpage + ");'>首页</a></li>";
			}
			if (str.isHasPrev) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
						+ str.getPervPage + ");'>上页</a></li>";
			}
			if (str.isHasNext) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
						+ str.getNextPage + ");'>下页</a></li>";
			}
			if (str.pageCount != str.pageNow) {
				listring = listring
						+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
						+ str.pageCount + ");'>尾页</a></li>";
			}
			listring = listring + "</ul></th>";
			if (str.pageCount != 1) {
				listring = listring
						+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
			}
			document.getElementById('member_tr').innerHTML = listring;
			if (str.isempty == false) {
				var thisstr = "";
				$.each(str.jsona,function() {
						var tr1 = "<td><input type='checkbox' name='chethis' id='"+ this.m_id + "'></td>";
						var tr2 = "<td>" + this.m_truename+ "</td>";
						var tr3 = "<td>" + this.m_sex+ "</td>";
						var tr4 = "<td>"+ this.m_sectionname+ "</td>";
						var tr5 = "<td>" + this.m_role+ "</td>";
						var tr6 = "<td>" + this.m_username+ "</td>";
						var tr7 = "<td>" + this.m_email+ "</td>";
						var tr8 = "<td>" + this.m_phone+ "</td>";
						var tr9 = "<td><a href='javascript:void(0);' onclick='deletethismember("+ this.m_id
								+ ")' style='text-decoration: none'>删除</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='startusingthismember("
								+ this.m_id+ ")' style='text-decoration: none'>启用</a></td>";

						thisstr = thisstr + "<tr>" + tr1
								+ tr2 + tr3 + tr4 + tr5
								+ tr6 + tr7 + tr8 + tr9
								+ "</tr>";
					});
				document.getElementById('membertbody').innerHTML = thisstr;

			} else {
				var thisstr = "";
				var tr1 = "<td></td>";
				var tr2 = "<td>暂无信息...</td>";
				var tr3 = "<td></td>";
				var tr4 = "<td></td>";
				var tr5 = "<td></td>";
				var tr6 = "<td></td>";
				var tr7 = "<td></td>";
				var tr8 = "<td></td>";
				var tr9 = "<td></td>";

				thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
						+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
				document.getElementById('membertbody').innerHTML = thisstr;
			}
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 删除这个成员的方法
 */
function deletethismember(obj) {
	spinnerstart();
	var id = obj;
	var m_duty = $("#memberrole").val();
	var section_names = $("#sectionss_names").html();
	var startpage = 1;
	url1 = url + '/deletethismember';
	if (confirm("是否确定删除此用户？")) {
		$.ajax({
			type : 'post',
			datetype : 'html',
			url : url1,
			cache : false,
			data : {
				"id" : id,
				"m_duty" : m_duty,
				"section_names" : section_names
			},
			success : function(data) {
				alert("操作成功！！");
				var str = eval("(" + data + ")");
				var listring = "<th>第<span id='m_pagenow'>"
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if (str.pageNow != 1) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ startpage + ");'>首页</a></li>";
				}
				if (str.isHasPrev) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getPervPage + ");'>上页</a></li>";
				}
				if (str.isHasNext) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getNextPage + ");'>下页</a></li>";
				}
				if (str.pageCount != str.pageNow) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if (str.pageCount != 1) {
					listring = listring
							+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
				}
				document.getElementById('member_tr').innerHTML = listring;
				if (str.isempty == false) {
					var thisstr = "";
					$.each(str.jsona,function() {

						var tr1 = "<td><input type='checkbox' name='chethis' id='"
								+ this.m_id + "'></td>";
						var tr2 = "<td>"
								+ this.m_truename
								+ "</td>";
						var tr3 = "<td>" + this.m_sex
								+ "</td>";
						var tr4 = "<td>"
								+ this.m_sectionname
								+ "</td>";
						var tr5 = "<td>" + this.m_role
								+ "</td>";
						var tr6 = "<td>"
								+ this.m_username
								+ "</td>";
						var tr7 = "<td>" + this.m_email
								+ "</td>";
						var tr8 = "<td>" + this.m_phone
								+ "</td>";
						var tr9 = "<td><a href='javascript:void(0);' onclick='deletethismember("
								+ this.m_id
								+ ")' style='text-decoration: none'>删除</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='startusingthismember("
								+ this.m_id
								+ ")' style='text-decoration: none'>启用</a></td>";

						thisstr = thisstr + "<tr>"
								+ tr1 + tr2 + tr3 + tr4
								+ tr5 + tr6 + tr7 + tr8
								+ tr9 + "</tr>";
					});
					document.getElementById('membertbody').innerHTML = thisstr;

				} else {
					var thisstr = "";
					var tr1 = "<td></td>";
					var tr2 = "<td>暂无信息...</td>";
					var tr3 = "<td></td>";
					var tr4 = "<td></td>";
					var tr5 = "<td></td>";
					var tr6 = "<td></td>";
					var tr7 = "<td></td>";
					var tr8 = "<td></td>";
					var tr9 = "<td></td>";

					thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
							+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
					document.getElementById('membertbody').innerHTML = thisstr;
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}
	spinnerend();
}

/**
 * 重新启用该用户的方法
 */
function startusingthismember(obj) {
	spinnerstart();
	var id = obj;
	var m_duty = $("#memberrole").val();
	var section_names = $("#sectionss_names").html();
	var startpage = 1;
	url1 = url + '/startusingthismember';
	if (confirm("是否确定重新启用此用户？")) {
		$.ajax({
			type : 'post',
			datetype : 'html',
			url : url1,
			cache : false,
			data : {
				"id" : id,
				"m_duty" : m_duty,
				"section_names" : section_names
			},
			success : function(data) {
				alert("操作成功！！");
				var str = eval("(" + data + ")");
				var listring = "<th>第<span id='m_pagenow'>"
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if (str.pageNow != 1) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ startpage + ");'>首页</a></li>";
				}
				if (str.isHasPrev) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getPervPage + ");'>上页</a></li>";
				}
				if (str.isHasNext) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getNextPage + ");'>下页</a></li>";
				}
				if (str.pageCount != str.pageNow) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if (str.pageCount != 1) {
					listring = listring
							+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
				}
				document.getElementById('member_tr').innerHTML = listring;

				if (str.isempty == false) {
					var thisstr = "";
					$.each(str.jsona,function() {

						var tr1 = "<td><input type='checkbox' name='chethis' id='"
								+ this.m_id + "'></td>";
						var tr2 = "<td>"
								+ this.m_truename
								+ "</td>";
						var tr3 = "<td>" + this.m_sex
								+ "</td>";
						var tr4 = "<td>"
								+ this.m_sectionname
								+ "</td>";
						var tr5 = "<td>" + this.m_role
								+ "</td>";
						var tr6 = "<td>"
								+ this.m_username
								+ "</td>";
						var tr7 = "<td>" + this.m_email
								+ "</td>";
						var tr8 = "<td>" + this.m_phone
								+ "</td>";
						var tr9 = "<td><a href='javascript:void(0);' onclick='deletethismember("
								+ this.m_id
								+ ")' style='text-decoration: none'>删除</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='startusingthismember("
								+ this.m_id
								+ ")' style='text-decoration: none'>启用</a></td>";

						thisstr = thisstr + "<tr>"
								+ tr1 + tr2 + tr3 + tr4
								+ tr5 + tr6 + tr7 + tr8
								+ tr9 + "</tr>";
					});
					document.getElementById('membertbody').innerHTML = thisstr;

				} else {
					var thisstr = "";
					var tr1 = "<td></td>";
					var tr2 = "<td>暂无信息...</td>";
					var tr3 = "<td></td>";
					var tr4 = "<td></td>";
					var tr5 = "<td></td>";
					var tr6 = "<td></td>";
					var tr7 = "<td></td>";
					var tr8 = "<td></td>";
					var tr9 = "<td></td>";

					thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
							+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
					document.getElementById('membertbody').innerHTML = thisstr;
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}
	spinnerend();
}

/**
 * 角色查询
 */
function findthisrolemember(obj) {
	//alert(obj);
	$("#memberrolespan").html(obj);
	$("#memberrole").val(obj);
	var index_state = $("#state").val();
	if (index_state == "启用人员") {
		this.pageuporpagedown(1);
	} else if (index_state == "停用人员") {
		this.openblockupmember(1);
	}
}

/**
 * 根据具体条件查询用户
 */
function findusermethod() {
	spinnerstart();
	var finduser = $("#finduser").val();
	var state = $("#state").val();
	url1 = url + '/finduserByCondition';
	$.ajax({
		type : 'post',
		datetype : 'html',
		url : url1,
		cache : false,
		data : {
			"finduser" : finduser,
			"m_state" : state
		},
		success : function(data) {
			// alert(data);
			var str = eval("(" + data + ")");
			var thisstr = "";
			$.each(str,function() {
				// alert(this.m_truename);
				var tr1 = "<td><input type='checkbox' name='chethis' id='"
						+ this.m_id + "'></td>";
				var tr2 = "<td>" + this.m_truename
						+ "</td>";
				var tr3 = "<td>" + this.m_sex + "</td>";
				var tr4 = "<td>" + this.m_sectionname
						+ "</td>";
				var tr5 = "<td>" + this.m_role
						+ "</td>";
				var tr6 = "<td>" + this.m_username
						+ "</td>";
				var tr7 = "<td>" + this.m_email
						+ "</td>";
				var tr8 = "<td>" + this.m_phone
						+ "</td>";
				var tr9 = "<td>";
				if (this.m_state == "启用") {
					// alert("sdf");
					tr9 = tr9
							+ "<a id='modal-722544' onclick='findmembershipinfos("
							+ this.m_id
							+ ");' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;";
				} else {
					// alert("123");
					tr9 = tr9
							+ "<a href='javascript:void(0);' onclick='deletethismember("
							+ this.m_id
							+ ")' style='text-decoration: none'>删除</a>&nbsp;&nbsp;";
				}
				if (this.m_state == "启用") {
					tr9 = tr9
							+ "<a href='javascript:void(0);' onclick='blockupthismember("
							+ this.m_id
							+ ")' style='text-decoration: none'>停用</a>";
				} else {
					tr9 = tr9
							+ "<a href='javascript:void(0);' onclick='startusingthismember("
							+ this.m_id
							+ ")' style='text-decoration: none'>启用</a>";
				}
				tr9 = tr9 + "</td>";

				thisstr = thisstr + "<tr>" + tr1 + tr2
						+ tr3 + tr4 + tr5 + tr6 + tr7
						+ tr8 + tr9 + "</tr>";
			});
			document.getElementById('membertbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("查询失败，或许没有这个用户吧（OoO）！！");
			spinnerend();
		}
	});
}

/**
 * 批量启用人员的方法
 */
function batchqiyongmember(obj){
	$("#piliangxiugaispan").html(obj);

	var state = $("#state").val();
	if(state=="启用人员"){
		alert("在启用界面不能批量启用人员！！\n\n请转到停用人员界面进行操作");
		return false;
	}
	var pageNow = $("#mm_pagenow").html();
	//alert(pageNow);
	var m_duty = $("#memberrole").val();
	var section_names = $("#sectionss_names").html();
	var startpage = 1;
	
	var trueAfalse = false;
	var checkedList = new Array();
	var checks = $("input[name=chethis]:checked");
	for ( var i in checks) {
		if (checks[i].checked) {
			checkedList[i] = checks[i].id;
			trueAfalse = true;
		}
	}
	if (!trueAfalse) {
		return alert('请选择需要启用的人员!');
	}
	if (confirm("您确定要启用这些人员吗?")) {
		var url4 = url + '/batchqiyongmember';
		spinnerstart();
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url4, // 目标地址
			datatype : "html",
			data : {
				"delitems" : checkedList.toString(),
				"pageNow" : pageNow,
				"m_duty" : m_duty,
				"section_names" : section_names
			},
			cache : false,
			success : function(data) {
				alert("操作成功！！\n\n您可以在启用人员界面进行查找！！");
				var str = eval("(" + data + ")");
				var listring = "<th>第<span id='m_pagenow'>"
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if (str.pageNow != 1) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ startpage + ");'>首页</a></li>";
				}
				if (str.isHasPrev) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getPervPage + ");'>上页</a></li>";
				}
				if (str.isHasNext) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getNextPage + ");'>下页</a></li>";
				}
				if (str.pageCount != str.pageNow) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if (str.pageCount != 1) {
					listring = listring
							+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
				}
				document.getElementById('member_tr').innerHTML = listring;
				if (str.isempty == false) {
					var thisstr = "";
					$.each(str.jsona,function() {
							var tr1 = "<td><input type='checkbox' name='chethis' id='"+ this.m_id + "'></td>";
							var tr2 = "<td>" + this.m_truename+ "</td>";
							var tr3 = "<td>" + this.m_sex+ "</td>";
							var tr4 = "<td>"+ this.m_sectionname+ "</td>";
							var tr5 = "<td>" + this.m_role+ "</td>";
							var tr6 = "<td>" + this.m_username+ "</td>";
							var tr7 = "<td>" + this.m_email+ "</td>";
							var tr8 = "<td>" + this.m_phone+ "</td>";
							var tr9 = "<td><a href='javascript:void(0);' onclick='deletethismember("+ this.m_id
									+ ")' style='text-decoration: none'>删除</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='startusingthismember("
									+ this.m_id+ ")' style='text-decoration: none'>启用</a></td>";

							thisstr = thisstr + "<tr>" + tr1
									+ tr2 + tr3 + tr4 + tr5
									+ tr6 + tr7 + tr8 + tr9
									+ "</tr>";
						});
					document.getElementById('membertbody').innerHTML = thisstr;
				} else {
					var thisstr = "";
					var tr1 = "<td></td>";
					var tr2 = "<td>暂无信息...</td>";
					var tr3 = "<td></td>";
					var tr4 = "<td></td>";
					var tr5 = "<td></td>";
					var tr6 = "<td></td>";
					var tr7 = "<td></td>";
					var tr8 = "<td></td>";
					var tr9 = "<td></td>";

					thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
							+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
					document.getElementById('membertbody').innerHTML = thisstr;
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
		spinnerend();
	}
}

/**
 * 批量操作更换span内容
 */
function batchmethod(obj){
	$("#piliangxiugaispan").html(obj);
}

/**
 * 批量删除成员
 */
function batchdeletemember(obj){
	$("#piliangxiugaispan").html(obj);
	var state = $("#state").val();
	//alert(state);
	if(state=="启用人员"){
		alert("在启用界面不能批量删除人员！！\n\n请转到停用人员界面进行操作");
		return false;
	}
	var pageNow = $("#mm_pagenow").html();
	//alert(pageNow);
	var m_duty = $("#memberrole").val();
	var section_names = $("#sectionss_names").html();
	var startpage = 1;
	
	var trueAfalse = false;
	var checkedList = new Array();
	var checks = $("input[name=chethis]:checked");
	for ( var i in checks) {
		if (checks[i].checked) {
			checkedList[i] = checks[i].id;
			trueAfalse = true;
		}
	}
	if (!trueAfalse) {
		return alert('请选择需要删除的人员!');
	}
	if (confirm("您确定要删除这些人员吗?")) {
		var url4 = url + '/batchdeletemember';
		spinnerstart();
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url4, // 目标地址
			datatype : "html",
			data : {
				"delitems" : checkedList.toString(),
				"pageNow" : pageNow,
				"m_duty" : m_duty,
				"section_names" : section_names
			},
			cache : false,
			success : function(data) {
				alert("操作成功！！");
				var str = eval("(" + data + ")");
				var listring = "<th>第<span id='m_pagenow'>"
					+ str.pageNow
					+ "</span>/<span id='m_pagecount'>"
					+ str.pageCount
					+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if (str.pageNow != 1) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ startpage + ");'>首页</a></li>";
				}
				if (str.isHasPrev) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getPervPage + ");'>上页</a></li>";
				}
				if (str.isHasNext) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.getNextPage + ");'>下页</a></li>";
				}
				if (str.pageCount != str.pageNow) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='openblockupmember("
							+ str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if (str.pageCount != 1) {
					listring = listring
							+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
				}
				document.getElementById('member_tr').innerHTML = listring;
				if (str.isempty == false) {
					var thisstr = "";
					$.each(str.jsona,function() {
							var tr1 = "<td><input type='checkbox' name='chethis' id='"+ this.m_id + "'></td>";
							var tr2 = "<td>" + this.m_truename+ "</td>";
							var tr3 = "<td>" + this.m_sex+ "</td>";
							var tr4 = "<td>"+ this.m_sectionname+ "</td>";
							var tr5 = "<td>" + this.m_role+ "</td>";
							var tr6 = "<td>" + this.m_username+ "</td>";
							var tr7 = "<td>" + this.m_email+ "</td>";
							var tr8 = "<td>" + this.m_phone+ "</td>";
							var tr9 = "<td><a href='javascript:void(0);' onclick='deletethismember("+ this.m_id
									+ ")' style='text-decoration: none'>删除</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='startusingthismember("
									+ this.m_id+ ")' style='text-decoration: none'>启用</a></td>";

							thisstr = thisstr + "<tr>" + tr1
									+ tr2 + tr3 + tr4 + tr5
									+ tr6 + tr7 + tr8 + tr9
									+ "</tr>";
						});
					document.getElementById('membertbody').innerHTML = thisstr;

				} else {
					var thisstr = "";
					var tr1 = "<td></td>";
					var tr2 = "<td>暂无信息...</td>";
					var tr3 = "<td></td>";
					var tr4 = "<td></td>";
					var tr5 = "<td></td>";
					var tr6 = "<td></td>";
					var tr7 = "<td></td>";
					var tr8 = "<td></td>";
					var tr9 = "<td></td>";

					thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
							+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
					document.getElementById('membertbody').innerHTML = thisstr;
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
		spinnerend();
	}
}

/**
 * 批量停用成员
 */
function batchupdatemember(obj) {
	
	$("#piliangxiugaispan").html(obj);
	var startpage = 1;
	var section_names = $("#sectionss_names").html();
	var m_duty = $("#memberrole").val();
	var pageNow = 1;
	var trueAfalse = false;
	var checkedList = new Array();
	var checks = $("input[name=chethis]:checked");
	for ( var i in checks) {
		if (checks[i].checked) {
			checkedList[i] = checks[i].id;
			trueAfalse = true;
		}
	}
	if (!trueAfalse) {
		alert('请选择停用人员!');
		return ;
	}
	if (confirm("您确定要停用这些人员吗?")) {
		var url4 = url + '/batchupdatemember';
		spinnerstart();
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url4, // 目标地址
			datatype : "html",
			data : {
				"delitems" : checkedList.toString(),
				"pageNow" : pageNow,
				"m_duty" : m_duty,
				"section_names" : section_names
			},
			cache : false,
			success : function(data) {
				alert("操作成功！！\n\n您可以在停用人员界面进行查找！！");
				var str = eval("(" + data + ")");
				// 分页按钮的显示
				var listring = "<th>第<span id='m_pagenow'>"
						+ str.pageNow
						+ "</span>/<span id='m_pagecount'>"
						+ str.pageCount
						+ "</span>页&nbsp;&nbsp;</th><th><ul class='pagination'>";
				if (str.pageNow != 1) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ startpage + ");'>首页</a></li>";
				}
				if (str.isHasPrev) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ str.getPervPage + ");'>上页</a></li>";
				}
				if (str.isHasNext) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ str.getNextPage + ");'>下页</a></li>";
				}
				if (str.pageCount != str.pageNow) {
					listring = listring
							+ "<li><a href='javascript:void(0);' onclick='pageuporpagedown("
							+ str.pageCount + ");'>尾页</a></li>";
				}
				listring = listring + "</ul></th>";
				if (str.pageCount != 1) {
					listring = listring
							+ "<th>&nbsp;&nbsp;</th><th><div class='col-lg-6'><div class='input-group'><input type='text' class='form-control input-sm' maxlength='2' style='width: 45'><span class='input-group-btn'><button class='btn btn-default btn-sm' type='button'>跳转</button></span></div></div></th>";
				}
				document.getElementById('member_tr').innerHTML = listring;
				if (str.isempty == false) {
					// table表的显示
					var thisstr = "";
					$.each(str.jsona,function() {
						var tr1 = "<td><input type='checkbox' name='chethis' id='"
								+ this.m_id + "'></td>";
						var tr2 = "<td>" + this.m_truename
								+ "</td>";
						var tr3 = "<td>" + this.m_sex
								+ "</td>";
						var tr4 = "<td>"
								+ this.m_sectionname
								+ "</td>";
						var tr5 = "<td>" + this.m_role
								+ "</td>";
						var tr6 = "<td>" + this.m_username
								+ "</td>";
						var tr7 = "<td>" + this.m_email
								+ "</td>";
						var tr8 = "<td>" + this.m_phone
								+ "</td>";
						var tr9 = "<td><a id='modal-722544' onclick='findmembershipinfos("
								+ this.m_id
								+ ");' href='#modal-container-722544' data-toggle='modal' style='text-decoration: none;'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0);' onclick='blockupthismember("
								+ this.m_id
								+ ")' style='text-decoration: none'>停用</a></td>";

						thisstr = thisstr + "<tr>" + tr1
								+ tr2 + tr3 + tr4 + tr5
								+ tr6 + tr7 + tr8 + tr9
								+ "</tr>";
					});
					document.getElementById('membertbody').innerHTML = thisstr;
				} else {
					var thisstr = "";
					var tr1 = "<td></td>";
					var tr2 = "<td>暂无信息...</td>";
					var tr3 = "<td></td>";
					var tr4 = "<td></td>";
					var tr5 = "<td></td>";
					var tr6 = "<td></td>";
					var tr7 = "<td></td>";
					var tr8 = "<td></td>";
					var tr9 = "<td></td>";

					thisstr = thisstr + "<tr>" + tr1 + tr2 + tr3 + tr4
							+ tr5 + tr6 + tr7 + tr8 + tr9 + "</tr>";
					document.getElementById('membertbody').innerHTML = thisstr;
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
		spinnerend();
	}
}

/**
 * 打开批量导入人员的界面
 */
function openbatchtoleadjsp() {
	var url1 = url + '/openbatchtoleadjsp';
	window.location.href = url1;
}

/**
 * 返回到查看所有人员界面
 */
function openallmemberinfo() {
	var url1 = url + '/findororganizationinfo';
	window.location.href = url1;
}

/**
 * 跳转分页界面的方法
 */
function tiaozhuanfenye(){
	var pageNow = $("#tiaozhuanyeshu").val();
	var state = $("#state").val();
	if(state=="启用人员"){
		this.pageuporpagedown(pageNow);
	}else if(state=="停用人员"){
		this.openblockupmember(pageNow);
	}
}

// //////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////////////////////
// //
// 考勤js文件 //
// //
// //////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * 时间补0
 */
function fillzero1(v){
	if(v<10){
		v="0"+v;
	}
	return v;
}
/**
 * 首页签到的方法
 */
function index_checkinmethod(){
	spinnerstart();
	url1 = url + '/checkinAction';
	//获取当前时间
	var n = new Date();
	var time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"nowtime":time,
			"atten_ipaddr":atten_ipaddr
		},
		cache : false,
		success : function(data) {
			var checkin = "&nbsp;";
			var checkout = "&nbsp;";
			var kaoqinanniu = "";
			var str = eval("(" + data + ")");
			if(!str.ischeck){
				//第一次签到反馈
				if (str.isCheckin) {
					if (str.instate) {
						checkin = "<h4 style='color: red'>"
							+ str.check_in_time + "</h4><span  align='center'>"+str.ipinfo_in+"</span>";
					} else {
						checkin = "<h4 style='color: #999'>"
							+ str.check_in_time + "</h4><span  align='center'>"+str.ipinfo_in+"</span>";
					}
					kaoqinanniu = "<button type='button' onclick='qiantuimethod();' class='btn btn-default btn-block btn-info' style='margin-bottom: 20px;'>签退</button>";
					checkout = '<h3 id="shangban"></h3>';
				} else {
					kaoqinanniu = "<button type='button' onclick='qiandaomethod();' class='btn btn-default btn-block btn-info' style='margin-bottom: 20px;'>签到</button>";
					checkin = '<h3 id="shangban"></h3>';
					checkout = "<h3>00:00:00</h3>";
				}
				if (str.isCheckout) {
					if (str.outstate) {
						checkout = "<h4 style='color: red'>"
							+ str.check_out_time + "</h4><span  align='center'>"+str.ipinfo_out+"</span>";
					} else {
						checkout = "<h4 style='color: #999'>"
							+ str.check_out_time + "</h4><span  align='center'>"+str.ipinfo_out+"</span>";
					}
					kaoqinanniu = "<button type='button' class='btn btn-default btn-block btn-info disabled' style='margin-bottom: 20px;'>签退</button>";
				}
				document.getElementById('checkindate').innerHTML = checkin;
				$("#checkoutdate").html(checkout);
				$("#kaoqinanniu").html(kaoqinanniu);
				alert("签到成功！！");
			}else{
				alert("您已经签过到了");
				return ;
			}
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
	spinnerend();
}

/**
 * 首页签到验证的方法
 */
function qiandaomethod() {
	spinnerstart();
	url1 = url + '/checkinAction';
	//获取当前时间
	var n = new Date();
	time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	//alert(atten_ipaddr);
	//获取签到的班次
	var result = "true";
	var banciurl = url + '/checkBanciInfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : banciurl, // 目标地址
		datatype : "html",
		data : {
			"nowtime":time,
			"methodType":"checkin"
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			//alert(atten_ipaddr);
			if(!str.isNice){
				if(confirm("哥们，现在签到时间太早，是否继续？")){
					index_checkinmethod();
				}
			}else{
				index_checkinmethod();
			}
		}
	})
	spinnerend();
}

/**
 * 考勤界面签到验证的方法
 */
function checkinmethod() {
	spinnerstart();
	url1 = url + '/checkinAction';
	//获取当前时间
	var n = new Date();
	time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	//alert(atten_ipaddr);
	//获取签到的班次
	var result = "true";
	var banciurl = url + '/checkBanciInfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : banciurl, // 目标地址
		datatype : "html",
		data : {
			"nowtime":time,
			"methodType":"checkin"
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			//alert(atten_ipaddr);
			if(!str.isNice){
				if(confirm("哥们，现在签到时间太早，是否继续？")){
					atten_checkinmethod();
				}
			}else{
				atten_checkinmethod();
			}
		}
	})
	spinnerend();
}

/**
 * 考勤界面签到的方法
 */
function atten_checkinmethod() {
	var m_id = $("#memberinfo_id").html();
	//获取当前时间
	var n = new Date();
	var time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	url1 = url + '/checkinAction';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"m_id" : m_id,
			"nowtime" : time,
			"atten_ipaddr" : atten_ipaddr
		},
		cache : false,
		success : function(data) {
			// alert(data);
			var checkin = "&nbsp;";
			var checkout = "&nbsp;";
			var str = eval("(" + data + ")");
			if (str.isCheckin) {
				checkin = "<span style='color: #999'>已签到 &nbsp;&nbsp;<font style='font-weight:bold;'>"
					+ str.check_in_time + "</font>&nbsp;&nbsp;（"+str.ipinfo_in+"）</span>";
			} else {
				checkin = "<a style='text-decoration: none;' onclick='checkinmethod();' href='javascript:void(0);'>[&nbsp;&nbsp;签&nbsp;到&nbsp;&nbsp;]</a>";
			}
			if (str.isCheckout) {
				checkout = "<span style='color: #999'>已签退 &nbsp;&nbsp;<font style='font-weight:bold;'>"
					+ str.check_out_time + "</font>&nbsp;&nbsp;（"+str.ipinfo_out+"）</span>";
			} else {
				checkout = "<a style='text-decoration: none;' onclick='checkoutmethod();' href='javascript:void(0);'>[&nbsp;&nbsp;签&nbsp;退&nbsp;&nbsp;]</a>";
			}
			document.getElementById('checkindate').innerHTML = checkin;
			document.getElementById('checkoutdate').innerHTML = checkout;
			alert("签到成功！！");
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
	spinnerend();
}

/**
 * 首页签退的方法
 */
function index_checkoutmethod() {
	spinnerstart();
	url1 = url + '/checkoutAction';
	//获取当前时间
	var n = new Date();
	var time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"nowtime":time,
			"atten_ipaddr" : atten_ipaddr
			},
		cache : false,
		success : function(data) {
			var checkin = "&nbsp;";
			var checkout = "&nbsp;";
			var kaoqinanniu = "";
			var str = eval("(" + data + ")");
			if (str.isCheckin) {
				if (str.instate) {
					checkin = "<h4 style='color: red'>"
							+ str.check_in_time + "</h4><span  align='center'>"+str.ipinfo_in+"</span>";
				} else {
					checkin = "<h4 style='color: #999'>"
							+ str.check_in_time + "</h4><span  align='center'>"+str.ipinfo_in+"</span>";
				}
				kaoqinanniu = "<button type='button' onclick='qiantuimethod();' class='btn btn-default btn-block btn-info' style='margin-bottom: 20px;'>签退</button>";
				checkout = '<h3 id="shangban"></h3>';
			} else {
				kaoqinanniu = "<button type='button' onclick='qiandaomethod();' class='btn btn-default btn-block btn-info' style='margin-bottom: 20px;'>签到</button>";
				checkin = '<h3 id="shangban"></h3>';
				checkout = "<h3>00:00:00</h3>";
			}
			if (str.isCheckout) {
				if (str.outstate) {
					checkout = "<h4 style='color: red'>"
							+ str.check_out_time + "</h4><span  align='center'>"+str.ipinfo_out+"</span>";
				} else {
					checkout = "<h4 style='color: #999'>"
							+ str.check_out_time + "</h4><span  align='center'>"+str.ipinfo_out+"</span>";
				}
				kaoqinanniu = "<button type='button' class='btn btn-default btn-block btn-info disabled' style='margin-bottom: 20px;'>签退</button>";
			}
			document.getElementById('checkindate').innerHTML = checkin;
			$("#checkoutdate").html(checkout);
			$("#kaoqinanniu").html(kaoqinanniu);
			alert("签退成功！！");
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 首页签退验证的方法
 */
function qiantuimethod() {
	spinnerstart();
	url1 = url + '/checkinAction';
	//获取当前时间
	var n = new Date();
	time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	//alert(atten_ipaddr);
	//获取签到的班次
	var result = "true";
	var banciurl = url + '/checkBanciInfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : banciurl, // 目标地址
		datatype : "html",
		data : {
			"nowtime":time,
			"methodType":"checkout"
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			//alert(atten_ipaddr);
			if(!str.isNice){
				if(confirm("哥们，现在签退时间太早，是否继续？")){
					index_checkoutmethod();
				}
			}else{
				index_checkoutmethod();
			}
		}
	})
	spinnerend();
}

/**
 * 考勤界面签退验证的方法
 */
function checkoutmethod() {
	spinnerstart();
	url1 = url + '/checkinAction';
	//获取当前时间
	var n = new Date();
	time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	//alert(atten_ipaddr);
	//获取签到的班次
	var result = "true";
	var banciurl = url + '/checkBanciInfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : banciurl, // 目标地址
		datatype : "html",
		data : {
			"nowtime":time,
			"methodType":"checkout"
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			//alert(atten_ipaddr);
			if(!str.isNice){
				if(confirm("哥们，现在签退时间太早，是否继续？")){
					atten_checkoutmethod();
				}
			}else{
				atten_checkoutmethod();
			}
		}
	})
	spinnerend();
}

/**
 * 考勤界面签退的实际方法方法
 */
function atten_checkoutmethod() {
	spinnerstart();
	var m_id = $("#memberinfo_id").html();
	url1 = url + '/checkoutAction';
	//获取当前时间
	var n = new Date();
	var time = fillzero1(n.getHours())+":"+fillzero1(n.getMinutes());
	var atten_ipaddr = $("#atten_ipaddr").val();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"m_id" : m_id,
			"nowtime":time,
			"atten_ipaddr":atten_ipaddr
		},
		cache : false,
		success : function(data) {
			// alert(data);
			var checkin = "&nbsp;";
			var checkout = "&nbsp;";
			var str = eval("(" + data + ")");
			if (str.isCheckin) {
				checkin = "<span style='color: #999'>已签到 &nbsp;&nbsp;<font style='font-weight:bold;'>"
					+ str.check_in_time + "</font>&nbsp;&nbsp;（"+str.ipinfo_in+"）</span>";
			} else {
				checkin = "<a style='text-decoration: none;' onclick='checkinmethod();' href='javascript:void(0);'>[&nbsp;&nbsp;签&nbsp;到&nbsp;&nbsp;]</a>";
			}
			if (str.isCheckout) {
				checkout = "<span style='color: #999'>已签退 &nbsp;&nbsp;<font style='font-weight:bold;'>"
					+ str.check_out_time + "</font>&nbsp;&nbsp;（"+str.ipinfo_out+"）</span>";
			} else {
				checkout = "<a style='text-decoration: none;' onclick='checkoutmethod();' href='javascript:void(0);'>[&nbsp;&nbsp;签&nbsp;退&nbsp;&nbsp;]</a>";
			}
			document.getElementById('checkindate').innerHTML = checkin;
			document.getElementById('checkoutdate').innerHTML = checkout;
			alert("签退成功！！");
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 清空考勤异常申请界面的信息
 */
function clearneirong() {
	$("#datepicker").val("");
	$("#remark").val("");
	// window.showModalDialog('b.html', 'newwindow', 'height=500, width=400,
	// top=0, left=0, toolbar=no, menubar=yes,
	// scrollbars=yes,resizable=yes,location=no, status=no');
	// window.location.reload();
}

/**
 * 根据日期查找用户考勤信息
 */
function finduseratteninfo() {
	var datepicker = $("#datepicker").val();
	url1 = url + '/finduseratteninfo';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"datepicker" : datepicker
		},
		cache : false,
		success : function(data) {
			// alert(data);
			var str = eval("(" + data + ")");
			if (str.isempty) {
				var thisstr = "<span >日期：" + str.yueritime
						+ "</span><br><span>考勤情况：" + str.checkintime + "~";
				if (str.checkouttime != null) {
					thisstr = thisstr + str.checkouttime
							+ "</span><br>";
				} else {
					thisstr = thisstr + "</span><br>";
				}
				if (str.state != "正常") {
					thisstr = thisstr
							+ "<span  id='statenormal' style='color:red'>"
							+ str.state + "</span>";
				} else {
					thisstr = thisstr + "<span id='statenormal'>"
							+ str.state + "</span>";
				}
				thisstr = thisstr + "<br>默认班次：<span id='dufaultshift'>"+ str.shiftsection +"</span>";
				document.getElementById('atteninfos').innerHTML = thisstr;
			} else {
				var thisstr = "<span>" + datepicker + "</span><br>-<br>";
				thisstr = thisstr
						+ "<span  id='statenormal' style='color:red'>缺勤</span>";
				thisstr = thisstr + "<br>默认班次：<span  id='dufaultshift'>"+ str.shiftsection +"</span>";
				document.getElementById('atteninfos').innerHTML = thisstr;
			}
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 异常考勤申诉
 */
function attenapplyinfo() {
	
	var statenormal = $("#statenormal").html();
	var yueritimeinfo = $("#datepicker").val();
	var remark = $("#remark").val();
	var dufaultshift = $("#dufaultshift").html();
	if (statenormal == "正常") {
		alert("正常考勤无法申诉！！");
		return false;
	}
	if (remark == "") {
		alert("说明不能为空！！");
		return false;
	}
	if (statenormal != "正常" && remark != "") {
		url1 = url + '/attenapplyinfo';
		spinnerstart();
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url1, // 目标地址
			datatype : "html",
			data : {
				"a_datetime" : yueritimeinfo,
				"remark" : remark,
				"dufaultshift":dufaultshift
			},
			cache : false,
			success : function(data) {
				var str = eval("(" + data + ")");
				alert(str.infos);
				spinnerend();
				// 关闭模态框
				$("#mymodal111").modal("hide");
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
		spinnerend();
	}
}

/**
 * 查询出未处理的我的申诉
 */
function findweichuliappealinfo() {
	spinnerstart();
	url1 = url + '/findweichuliappealinfo';
	// alert(url1);
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"state" : 1
		},
		cache : false,
		success : function(data) {
			// alert(data);
			var str = eval("(" + data + ")");
			var thisstr = "";
			if (str.isempty) {
				$.each(str.jsona,function() {
					thisstr = thisstr
							+ "<tr><td><p>"
							+ this.dtime
							+ "</p><p class='p13-999'>"
							+ this.time
							+ "</p></td><td>"
							+ "<span style='color: red'>"
							+ this.beforestate
							+ "</span></td><td>"
							+ this.remark
							+ "</td>"
							+ "<td><p><span>"
							+ this.datetime
							+ "</span><span>"
							+ this.atten_week
							+ "</span>"
							+ "</p><p class='p13-999'>19:00~22:00</p></td><td>"
							+ "<span style='color:red'>未处理</span></td></tr>";
				});
			} else {
				thisstr = "<tr><td>无信息...</td><td></td><td></td><td></td><td></td></tr>";
			}
			document.getElementById('myappealbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 查询出已处理的我的申诉
 */
function findyichuliappealinfo() {
	spinnerstart();
	url1 = url + '/findyichuliappealinfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"state" : 2
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			// alert(str.isempty);
			var thisstr = "";
			if (str.isempty) {
				$.each(str.jsona,function() {
					thisstr = thisstr
							+ "<tr><td><p>"
							+ this.dtime
							+ "</p><p class='p13-999'>"
							+ this.time
							+ "</p></td><td>"
							+ "<span style='color: red'>"
							+ this.beforestate
							+ "</span></td><td>"
							+ this.remark
							+ "</td>"
							+ "<td><p><span>"
							+ this.datetime
							+ "</span><span>"
							+ this.atten_week
							+ "</span>"
							+ "</p><p class='p13-999'>19:00~22:00</p></td><td>"
							+ "<span class='p13-999'>已处理</span></td></tr>";
				});
			} else {
				thisstr = "<tr><td>无信息...</td><td></td><td></td><td></td><td></td></tr>";
			}
			document.getElementById('myappealbody').innerHTML = thisstr;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 刷新按钮
 */
function flushthispage() {
	window.location.reload();
}

/**
 * 根据日期查看考勤记录
 */
function findseerecordinfo() {
	var datepicker = $("#datepicker").val();
	url2 = url + '/findseerecordinfoqq?datepicker=' + datepicker;
	window.location.href = url2;
}

/**
 * 查看所有考勤信息
 */
function findatteninfo() {
	alert("infos");
}

/**
 * 查看正常考勤的信息
 */
function findatteninfozc() {
	alert("infos");
}

/**
 * 查看早退的考勤信息
 */
function findatteninfozt() {

}

/**
 * 查看迟到的考勤信息
 */
function findatteninfocd() {

}

/**
 * 查看迟到，早退的考勤信息
 */
function findatteninfocdzt() {

}

/**
 * 查看缺勤的考勤信息
 */
function findatteninfoqq() {

}

/**
 * 根据条件查看异常考勤信息
 */
function findBYtunusualrecord() {
	spinnerstart();
	var infos = $("#kaoqinxinxi11").val();
	var state = $("#chulistate").val();
	url1 = url + '/findBYtunusualrecord';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url1, // 目标地址
		datatype : "html",
		data : {
			"infos" : infos,
			"states" : state
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			var thisstr = "";
			if (str.isempty) {
				$.each(str.jsona,function() {
					var t1 = this.username;
					var t2 = "<span>"
							+ this.datetime
							+ "</span> &nbsp;<span>"
							+ this.week
							+ "</span><br><span class='p13-999'>" + this.shiftsection + "</span>";
					var t3 = "";
					if (this.state == "正常") {
						t3 = "<font>"
								+ this.state
								+ "</font><font class='p13-red'>（"
								+ this.afterstate
								+ "）</font><br><font>"
								+ this.check_in_out_info
								+ "</font>";
					} else {
						t3 = "<font class='p13-red'>"
								+ this.state
								+ "</font><br><font>"
								+ this.check_in_out_info
								+ "</font>";
					}
					var t4 = "";
					if (this.statenum == 1) {
						t4 = "<span class='p13-red'>未处理</span>";
					} else {
						t4 = "<span class='p13-999'>已处理</span>";
					}
					var t5 = this.operatorname;
					var t6 = "";
					if (this.statenum == 1) {
						t6 = '<a id="modal-722544" onclick="findthisatten_unusualinfo(\''
								+ this.state
								+ '\',\''
								+ this.id
								+ '\',\''
								+this.m_id
								+ '\')" href="#modal-container-722544" data-toggle="modal" href="javascript:void();" style="text-decoration: none;">处理</a>';
					} else {
						t6 = '<a id="modal-722544" onclick="findthisatten_unusualinfo(\''
								+ this.state
								+ '\',\''
								+ this.id
								+ '\',\''
								+this.m_id
								+ '\')" href="#modal-container-722544" data-toggle="modal" style="text-decoration: none;">重新处理</a>';
					}
					thisstr = thisstr + "<tr><td>" + t1
							+ "</td><td>" + t2
							+ "</td><td>" + t3
							+ "</td><td>" + t4
							+ "</td><td>" + t5
							+ "</td><td>" + t6
							+ "</td></tr>";
				});
			} else {
				thisstr = "<tr><td>无信息...</td><td></td><td></td><td></td><td></td><td></td></tr>";
			}
			document.getElementById('checkrecord_unusualtbody').innerHTML = thisstr;
			document.getElementById('daichulishensu').innerText = str.pendingappealNum;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 根据状态查找
 */
function findunusualrecordBystate() {
	this.findBYtunusualrecord();
}

/**
 * 查询出该条异常考勤的状态显示到模态框中
 */
function findthisatten_unusualinfo(obj, obj1, obj2) {
	var stateinfo = obj;
	var id = obj1;
	$("#selectstateinfo").val(stateinfo);
	$("#atten_unusualid").val(id);
	$("#qingqiurendeid").html(obj2);
}

/**
 * 保存处理的异常考勤信息
 */
function savecheckrecordunusualinfo() {
	spinnerstart();
	var remark = $("#selectstateinfo").val();
	var state = $("#chulistate").val();
	var infos = $("#kaoqinxinxi11").val();
	var id = $("#atten_unusualid").val();
	var m_id = $("#qingqiurendeid").html();
	url22 = url + '/savecheckrecordunusualinfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"states" : state,
			"a_id" : id,
			"infos" : infos,
			"remark" : remark,
			"m_id": m_id
		},
		cache : false,
		success : function(data) {
			alert("操作成功！！");
			// 关闭模态框
			$("#modal-container-722544").modal("hide");
			var str = eval("(" + data + ")");
			var thisstr = "";
			if (str.isempty) {
				$.each(str.jsona,function() {
					var t1 = this.username;
					var t2 = "<span>"
							+ this.datetime
							+ "</span> &nbsp;<span>"
							+ this.week
							+ "</span><br><span class='p13-999'>19:00~22:00</span>";
					var t3 = "";
					if (this.state == "正常") {
						t3 = "<font>"
								+ this.state
								+ "</font><font class='p13-red'>（"
								+ this.afterstate
								+ "）</font><br><font>"
								+ this.check_in_out_info
								+ "</font>";
					} else {
						t3 = "<font class='p13-red'>"
								+ this.state
								+ "</font><br><font>"
								+ this.check_in_out_info
								+ "</font>";
					}
					var t4 = "";
					if (this.statenum == 1) {
						t4 = "<span class='p13-red'>未处理</span>";
					} else {
						t4 = "<span class='p13-999'>已处理</span>";
					}
					var t5 = this.operatorname;
					var t6 = "";
					if (this.statenum == 1) {
						t6 = '<a id="modal-722544" onclick="findthisatten_unusualinfo(\''
								+ this.state
								+ '\',\''
								+ this.id
								+ '\',\''
								+this.m_id
								+'\')" href="#modal-container-722544" data-toggle="modal" href="javascript:void();" style="text-decoration: none;">处理</a>';
					} else {
						t6 = '<a id="modal-722544" onclick="findthisatten_unusualinfo(\''
								+ this.state
								+ '\',\''
								+ this.id
								+ '\',\''
								+this.m_id
								+ '\')" href="#modal-container-722544" data-toggle="modal" style="text-decoration: none;">重新处理</a>';
					}
					thisstr = thisstr + "<tr><td>" + t1
							+ "</td><td>" + t2
							+ "</td><td>" + t3
							+ "</td><td>" + t4
							+ "</td><td>" + t5
							+ "</td><td>" + t6
							+ "</td></tr>";
				});
			} else {
				thisstr = "<tr><td>无信息...</td><td></td><td></td><td></td><td></td><td></td></tr>";
			}
			document.getElementById('checkrecord_unusualtbody').innerHTML = thisstr;
			document.getElementById('daichulishensu').innerText = str.pendingappealNum;
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 将考勤信息显示到模态框中
 * 
 * @param obj1
 * @param obj2
 */
function findthisrecord(obj1, obj2, obj3) {
	$("#selectstatepending").val(obj1);
	$("#atten_pendingid").val(obj2);
	$("#shenqingrenid_pending").html(obj3);
}

/**
 * 将修改后的考勤信息保存到数据库
 */
function savecheckrecordunusualpending() {
	var remark = $("#selectstatepending").val();
	var id = $("#atten_pendingid").val();
	var m_id = $("#shenqingrenid_pending").html();
	var url22 = url + '/savecheckrecordunusualpending';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"a_id" : id,
			"remark" : remark,
			"m_id" : m_id
		},
		cache : false,
		success : function(data) {
			alert("操作成功！！");
			// 关闭模态框
			$("#modal-container-722547").modal("hide");
			var url2 = url + '/open_pendingappeal';
			window.location.href = url2;
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
		}
	});
}

/**
 * 根据条件查询考勤统计
 */
function findthisstatsticsbyinfo(obj) {
	if(obj.indexOf("年")>0){
		//alert("年");
		$("#nian_idspan").html(obj);
		$("#nian_id").val(obj);
	}else if(obj.indexOf("月")>0){
		//alert("月");
		$("#yue_idspan").html(obj);
		$("#yue_id").val(obj);
	}else{
		//alert("all");
		$("#section_idspan").html(obj);
		$("#section_id").val(obj);
	}
	
	//document.getElementById("section_id").value=obj;
	var sectionname = $("#section_id").val();
	var yuename = $("#yue_id").val();
	var yearname = $("#nian_id").val();
	//alert(sectionname+yuename+yearname);
	var url22 = url + '/findthisstatsticsbyinfo';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"sectionname" : sectionname,
			"monthname" : yuename,
			"yearname" : yearname
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			$.each(str.jsonap, function() {
				$("#allchidao").html(this.allchidaon);
				$("#allzaotui").html(this.allzaotuin);
				$("#allweiqiantui").html(this.allweiqiantuin);
				$("#allchitui").html(this.allchituin);
				$("#allchiweitui").html(this.allchiweituin);
				$("#allqueqin").html(this.allqueqinn);
				$("#allipinfo").html(this.allipinfo);
			});
			var sectionstr = '<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo(\'全部\');">全部</a></li>';
			$.each(str.jsonsection,function() {
				sectionstr = sectionstr
						+ '<li ><a  tabindex="-1" href="javascript:void(0)" onclick="findthisstatsticsbyinfo(\''+ this.section_name +'\');">'+ this.section_name +'</a></li>'
			});
			$("#sectionulinfo").html(sectionstr);
			$("#section_id").val(str.sectionname);
			var thisstr = "";
			$.each(str.jsonattenstatic, function() {
				thisstr = thisstr + '<tr><td>' + this.username
						+ '</td><td>' + this.sectionname + '</td><td>'
						+ this.shijichuqin + '</td><td>' + this.chidaon
						+ '</td><td>' + this.zaotuin + '</td><td>'
						+ this.weiqiantuin + '</td><td>' + this.chituin
						+ '</td><td>' + this.chiweituin + '</td><td>'
						+ this.ipinfo + '</td><td>'
						+ this.queqinn + '</td></tr>';
			});
			$("#xiangxikaoqintbody").html(thisstr);
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 清空模态框信息
 */
function openexportmodaldialog() {
	$("#datepicker").val("");
	$("#datepicker1").val("");
	$("#sectionexport_select").val("全部");
	$("#tongji").attr("checked", false);
	$("#jilu").attr("checked", false);
	$("#shenhe").attr("checked", false);
}

/**
 * 提交导出的信息
 */
function tijiaodaochuxinxi() {
	var time1 = $("#datepicker").val();
	var time2 = $("#datepicker1").val();
	var sectionname = $("#sectionexport_select").val();
	var tongji = $("#tongji").is(":checked");
	var jilu = $("#jilu").is(":checked");
	var shenhe = $("#shenhe").is(":checked");
	if (time1 == "") {
		alert("时间段不能为空！！");
		return false;
	}
	if (time2 == "") {
		alert("时间段不能为空！！");
		return false;
	}
	if (time1 >= time2) {
		alert("第一个时间不能大于等于第二个时间");
		return false;
	}
	if (tongji + jilu + shenhe == 0) {
		alert("选择类型不能为空！！");
		return false;
	}
	var url22 = url + '/tijiaodaochuxinxi';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"sectionname" : sectionname,
			"time1" : time1,
			"time2" : time2,
			"tongji" : tongji,
			"jilu" : jilu,
			"shenhe" : shenhe
		},
		cache : false,
		success : function(data) {
			// alert("操作成功！！");
			var str = eval("(" + data + ")");
			if (str.beforeisExist) {
				alert("以前有人导出这个时间段的表了...");
				spinnerend();
				return false;
			} else {
				if (str.isexport) {
					alert("操作成功！！");
					// 关闭模态框
					$("#modal-container-184701").modal("hide");
					// var url0 =
					// url+'/Functionality/announcement/anno_new.jsp';
					// window.location.href=url0;
					window.location.reload();// 刷新当前页面.
					/*
					 * var utls = utl + "/findallattenexport";
					 * window.location.href = utls;
					 */
				}
			}
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 刷新当前界面的方法
 */
function shuaxindangqianjiemain() {
	window.location.reload();// 刷新当前页面.
}

/**
 * 删除这条导出记录的方法
 */
function deletethisexportchart(obj) {
	spinnerstart();
	var id = obj;
	var url22 = url + '/deletethisexportchart';
	if (confirm("是否确定删除这个表格？")) {
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url22, // 目标地址
			datatype : "html",
			data : {
				"a_id" : id
			},
			cache : false,
			success : function(data) {
				alert("操作成功！！");
				// var str = eval("("+data+")");
				// $("#").remove();//删除秒杀时间td
				document.getElementById(obj).remove();
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}
	spinnerend();
}

/**
 * 更新班次信息
 */
function updateShiftInfo(){
	spinnerstart();
	var check_in_hour = $("#id_check_in_time_hour").val()+"";
	var check_in_minute = $("#id_check_in_time_minute").val()+"";
	var check_out_hour = $("#id_check_out_time_hour").val()+"";
	var check_out_minute = $("#id_check_out_time_minute").val()+"";
	var elas_time = $("#elas_time").val()+"";
	if(elas_time==""){
		elas_time="0";
	}
	var url22 = url + '/updateShiftInfo';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"check_in_hour" : check_in_hour,
			"check_in_minute" : check_in_minute,
			"check_out_hour" : check_out_hour,
			"check_out_minute" : check_out_minute,
			"elas_time" : elas_time
		},
		cache : false,
		success : function(data) {
			alert("操作成功！！");
			$("#check_in").html(check_in_hour+":"+check_in_minute);
			$("#check_out").html(check_out_hour+":"+check_out_minute);
			$("#tanxing").html(elas_time);
			// 关闭模态框
			$("#modal-container-184701").modal("hide");
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/*function saveDefaultIP(){
	var ipname = $("#atten_ipname").val();
	var ipaddr = $("#atten_ipaddr").val();
	//alert(ipname+ipaddr);
	var url22 = url + '/saveDefaultIP';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"ipname" : ipname,
			"ipaddr" : ipaddr
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert("操作成功！！");
			if($("#noinfos").html()==""){
				$("#strnoinfos").remove();
			}
			var t1 = '<tr id="' + str.id + '"><td>'+str.ipname+'</td><td>'+str.ipaddr+'</td>';
		    var t2 = '<td>'+str.time+'</td><td>'+str.operator+'</td>';
		    var t3 = '<td><a href="javascript:void(0)" style="text-decoration: none;" onclick="deletethisipByid(\''+str.id+'\')">删除</a></td></tr>';
			var t = t1 + t2 + t3;
		    $("#atten_IPbody").append(t);
			$("#modal-container-184755").modal("hide");
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
	spinnerend();
}*/

/**
 * 根据id删除ip内容
 */
/*function deletethisipByid(id){
	var url22 = url + '/deletethisipByid';
	spinnerstart();
	if (confirm("您确定要删除这条信息吗?")) {
		$.ajax({
			type : 'POST', // 用POST方式传输
			url : url22, // 目标地址
			datatype : "html",
			data : {
				"id" : id
			},
			cache : false,
			success : function(data) {
				var str = eval("(" + data + ")");
				alert("操作成功！！");
				if($("#noinfos").html()==""){
					$("#strnoinfos").remove();
				}
				$("#"+id).remove();
				if(str.sizenum=="no"){
					var t = '<tr id="strnoinfos"><td>无内容...</td><td id="noinfos"></td><td></td><td></td><td></td></tr>';
					 $("#atten_IPbody").html(t);
				}
				spinnerend();
			},
			error : function(data) {
				alert("操作失败，请刷新后重新操作！！");
				spinnerend();
			}
		});
	}
	spinnerend();
}*/

////////////////////////////////////////////////////////////////////
///////////个人信息
////////////////////////////////////////////////////////////////////

/**
 * 修改提交qq号
 */
function updateqqchat() {
	var qqinfo = $("#editqqid").val();
	if (qqinfo == "") {
		alert("提交内容不能为空！！");
		return false;
	}
	// alert(qqinfo);
	var url22 = url + '/updateqqchat';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"qqinfo" : qqinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			// alert(qqinfo);
			$("#qqchatid").html(str.newqq);
			$("#editQQinfo").hide();
			$("#editQQ").show();
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 修改提交手机号
 */
function updatephonechat() {
	var phoneinfo = $("#editphoneid").val();
	var ree = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9|1])\d{8}$)/;
	if (!ree.exec(phoneinfo)) {
		alert("请输入正确的电话号码，\n\n如：0591-6487256，15005059587");
		return false;
	}
	if (phoneinfo == "") {
		alert("手机号不能为空！！");
		return false;
	}
	// alert(qqinfo);
	var url22 = url + '/updatephonechat';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_phone" : phoneinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			// alert(qqinfo);
			$("#phonechatid").html(str.newphone);
			$("#editphoneinfo").hide();
			$("#editphone").show();
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 修改提交班级名称
 */
function updateclassname() {
	spinnerstart();
	var classnameinfo = $("#editclassnameid").val();
	var url22 = url + '/updateclassname';
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_classname" : classnameinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			$("#classnameid").html(str.newclassname);
			$("#editclassnameinfo").hide();
			$("#editclassname").show();
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 修改备注的方法
 */
function updateremark() {
	var remarkinfo = $("#editremarkid").val();
	if (remarkinfo == "") {
		alert("备注内容不能为空！！");
		return false;
	}
	// alert(qqinfo);
	var url22 = url + '/updateremark';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"remark" : remarkinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			// alert(qqinfo);
			$("#remarkid").html(str.newremark);
			$("#editremarkinfo").hide();
			$("#editremark").show();
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 修改邮箱的方法
 */
function updateemail() {
	var emailinfo = $("#editemailid").val();

	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.exec(emailinfo)) {
		alert("您的电子邮件格式不正确！！");
		return false;
	}
	if (emailinfo == "") {
		alert("您所填内容不能为空！！");
		return false;
	}
	// alert(qqinfo);
	var url22 = url + '/updateemail';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_email" : emailinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			// alert(qqinfo);
			$("#emailid").html(str.newemail);
			$("#editemailinfo").hide();
			$("#editemail").show();
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 新增youxiang的方法
 */
function addnewemail() {
	var emailinfo = $("#newemailid").val();
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.exec(emailinfo)) {
		alert("您的电子邮件格式不正确！！");
		return false;
	}
	if (emailinfo == "") {
		alert("您所填内容不能为空！！");
		return false;
	}
	var url22 = url + '/updateemail';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_email" : emailinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			var url1 = url + '/Functionality/personaldata/personal_index.jsp';
			window.location.href = url1;
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 新增备注的方法
 */
function addnewremark() {
	var remark = $("#newremark").val();
	if (remark == "") {
		alert("您所填内容不能为空！！");
		return false;
	}
	var url22 = url + '/updateremark';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"remark" : remark
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			var url1 = url + '/Functionality/personaldata/personal_index.jsp';
			window.location.href = url1;
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 新增班级的方法
 */
function addclassnamemethod() {
	var classnameinfo = $("#newclassnameid").val();
	if (classnameinfo == "") {
		alert("您所填内容不能为空！！");
		return false;
	}
	var url22 = url + '/updateclassname';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_classname" : classnameinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			var url1 = url + '/Functionality/personaldata/personal_index.jsp';
			window.location.href = url1;
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 增加qq的方法
 */
function addqqmethod() {
	//webtools(qqinfo);
	var qqinfo = $("#newqqid").val();
	if (qqinfo == "") {
		alert("您所填内容不能为空！！");
		return false;
	}
	var url22 = url + '/updateqqchat';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"qqinfo" : qqinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			var url1 = url + '/Functionality/personaldata/personal_index.jsp';
			window.location.href = url1;
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 添加手机号
 */
function addphonemethod() {
	var phoneinfo = $("#newphoneid").val();
	var ree = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9|1])\d{8}$)/;
	if (!ree.exec(phoneinfo)) {
		alert("请输入正确的电话号码，\n\n如：0591-6487256，15005059587");
		return false;
	}
	if (phoneinfo == "") {
		alert("您所填内容不能为空！！");
		return false;
	}
	var url22 = url + '/updatephonechat';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_phone" : phoneinfo
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			var url1 = url + '/Functionality/personaldata/personal_index.jsp';
			window.location.href = url1;
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 修改密码的方法
 */
function checklastpw() {
	var passwd = $("#password").val();
	if (passwd == "") {
		alert("当前密码不能为空！！");
		return false;
	}
	var newpasswd = $("#newpassword").val();
	if (newpasswd == "") {
		alert("新密码不能为空！！");
		return false;
	}
	var lastpasswd = $("#lastpassword").val();
	if (lastpasswd == "") {
		alert("确认密码不能为空！！");
		return false;
	}
	if (newpasswd != lastpasswd) {
		alert("确认密码和新密码不一致！！");
		$("#lastpassword").val("");
		return false;
	}
	var url22 = url + '/updatepassword';
	spinnerstart();
	$.ajax({
		type : 'POST', // 用POST方式传输
		url : url22, // 目标地址
		datatype : "html",
		data : {
			"m_password" : lastpasswd
		},
		cache : false,
		success : function(data) {
			var str = eval("(" + data + ")");
			alert(str.infos);
			$("#modal-container-712543").modal("hide");
			spinnerend();
		},
		error : function(data) {
			alert("操作失败，请刷新后重新操作！！");
			spinnerend();
		}
	});
}

/**
 * 检验上传的文件
 */
function fileChange(target, id) {
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

/**
 * 保存头像src内容到数据库
 */
/*function savePictureSrcinfo(){
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
}*/

function Checkfiles() {
	var files = $("#uploadfile").val();
	if (files == "") {
		alert("嘿！您老还没选择要上传的文件呢（O_*）");
		return false;
	} else {
		document.dataForm.action = "commituserpicturefile";
		$('#crop_form').submit();
	}
}

/** 拖拽模态框*/  
var mouseStartPoint = {"left":0,"top":  0};  
var mouseEndPoint = {"left":0,"top":  0};  
var mouseDragDown = false;  
var oldP = {"left":0,"top":  0};  
var moveTartet ;  
$(document).ready(function(){  
    $(document).on("mousedown",".modal-header",function(e){  
        if($(e.target).hasClass("close"))//点关闭按钮不能移动对话框  
            return;  
        mouseDragDown = true;  
        moveTartet = $(this).parent();  
        mouseStartPoint = {"left":e.clientX,"top":  e.clientY};  
        oldP = moveTartet.offset();  
    });  
    $(document).on("mouseup",function(e){  
        mouseDragDown = false;  
        moveTartet = undefined;  
        mouseStartPoint = {"left":0,"top":  0};  
        oldP = {"left":0,"top":  0};  
    });  
    $(document).on("mousemove",function(e){  
        if(!mouseDragDown || moveTartet == undefined)return;  
        var mousX = e.clientX;  
        var mousY = e.clientY;  
        if(mousX < 0)mousX = 0;  
        if(mousY < 0)mousY = 25;  
        mouseEndPoint = {"left":mousX,"top": mousY};  
        var width = moveTartet.width();  
        var height = moveTartet.height();  
        mouseEndPoint.left = mouseEndPoint.left - (mouseStartPoint.left - oldP.left);//移动修正，更平滑  
        mouseEndPoint.top = mouseEndPoint.top - (mouseStartPoint.top - oldP.top);  
        moveTartet.offset(mouseEndPoint);  
    });  
});  


/*
 * 提示工具*/
$(function () { $("[data-toggle='tooltip']").tooltip(); });

