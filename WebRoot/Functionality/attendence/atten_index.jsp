<%@ page language="java" import="java.util.*,com.rms.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");

if(memberinfo.getM_username()==null){
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
%>
<%
//获取本地IP
String ip = request.getHeader("x-forwarded-for");
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
  {
    ip = request.getHeader("Proxy-Client-IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
  {
    ip = request.getHeader("WL-Proxy-Client-IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
  {
    ip = request.getRemoteAddr();
  }
    System.out.println(ip);
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
    
     <link rel="Shortcut icon" href="img/favicon.ico">   
    <!-- 加载动画效果 -->
    <link href="css/jiazaidonghuacss/myspinner.css" rel="stylesheet" type="text/css" />
    <script src="js/myjs.js" type="text/javascript"></script>
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
    <!--导航选中效果 -->
    <script type="text/javascript">
      $(function(){
         $("a").siblings("li").removeClass("pre");//这个是将页面的上的所有不选中
         $("a[lang=0]").addClass("pre");//设置选中的
         $("a[lang=0]").css("color","#fff");
         $(".pre").hover(
	      function () {
	        $(this).css({"background-color":"#080808"});
	      }  
	     );
      });
      </script>
    
    
    <style> 
	a{ text-decoration:none} 
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
			
				<!-- 考勤导航 -->
				<jsp:include page="atten_navigation.jsp"></jsp:include>
				
				<!-- 全部公告 -->
				<div class="col-md-9 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
					<h4 style="margin-top:10px;">
						我的考勤>>考勤打卡
					</h4>
					<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
					<div class="col-md-12 column" style="overflow-x:hidden; height:495px; ">
<script type="text/javascript">
	today=new Date();  
	function initArray(){  
	   this.length=initArray.arguments.length;  
	   for(var i=0;i<this.length;i++)  
	   this[i+1]=initArray.arguments[i] ;
	}  
	var d=new initArray(  
	 "星期日",  
	 "星期一",  
	 "星期二",  
	 "星期三",  
	 "星期四",  
	 "星期五",  
	 "星期六");  
	
	/*农历部分*/  
	var CalendarData=new Array(100);  
	var madd=new Array(12);  
	var tgString="甲乙丙丁戊己庚辛壬癸";  
	var dzString="子丑寅卯辰巳午未申酉戌亥";  
	var numString="一二三四五六七八九十";  
	var monString="正二三四五六七八九十冬腊";  
	var weekString="日一二三四五六";  
	var sx="鼠牛虎兔龙蛇马羊猴鸡狗猪";  
	var cYear,cMonth,cDay,TheDate;  
	CalendarData = new Array(0xA4B,0x5164B,0x6A5,0x6D4,0x415B5,0x2B6,0x957,0x2092F,0x497,0x60C96,0xD4A,0xEA5,0x50DA9,0x5AD,0x2B6,0x3126E, 0x92E,0x7192D,0xC95,0xD4A,0x61B4A,0xB55,0x56A,0x4155B, 0x25D,0x92D,0x2192B,0xA95,0x71695,0x6CA,0xB55,0x50AB5,0x4DA,0xA5B,0x30A57,0x52B,0x8152A,0xE95,0x6AA,0x615AA,0xAB5,0x4B6,0x414AE,0xA57,0x526,0x31D26,0xD95,0x70B55,0x56A,0x96D,0x5095D,0x4AD,0xA4D,0x41A4D,0xD25,0x81AA5,0xB54,0xB6A,0x612DA,0x95B,0x49B,0x41497,0xA4B,0xA164B, 0x6A5,0x6D4,0x615B4,0xAB6,0x957,0x5092F,0x497,0x64B, 0x30D4A,0xEA5,0x80D65,0x5AC,0xAB6,0x5126D,0x92E,0xC96,0x41A95,0xD4A,0xDA5,0x20B55,0x56A,0x7155B,0x25D,0x92D,0x5192B,0xA95,0xB4A,0x416AA,0xAD5,0x90AB5,0x4BA,0xA5B, 0x60A57,0x52B,0xA93,0x40E95);  
	madd[0]=0;  
	madd[1]=31;  
	madd[2]=59;  
	madd[3]=90;  
	madd[4]=120;  
	madd[5]=151;  
	madd[6]=181;  
	madd[7]=212;  
	madd[8]=243;  
	madd[9]=273;  
	madd[10]=304;  
	madd[11]=334;  

	function GetBit(m,n){  
		return (m>>n)&1;  
	}  
	function e2c(){  
		TheDate= (arguments.length!=3) ? new Date() : new Date(arguments[0],arguments[1],arguments[2]);  
		var total,m,n,k;  
		var isEnd=false;  
		var tmp=TheDate.getYear();  
		if(tmp<1900){  
			tmp+=1900;  
		} 
		total=(tmp-1921)*365+Math.floor((tmp-1921)/4)+madd[TheDate.getMonth()]+TheDate.getDate()-38;  
		  
		if(TheDate.getYear()%4==0&&TheDate.getMonth()>1) {  
			total++;  
		}  
		for(m=0;;m++){  
			k=(CalendarData[m]<0xfff)?11:12;  
			for(n=k;n>=0;n--){  
				if(total<=29+GetBit(CalendarData[m],n)){  
				 isEnd=true; 
				 break;  
				}  
				total=total-29-GetBit(CalendarData[m],n);  
			}  
			if(isEnd) 
			break;  
		}  
		cYear=1921 + m;  
		cMonth=k-n+1;  
		cDay=total;  
		if(k==12){  
			if(cMonth==Math.floor(CalendarData[m]/0x10000)+1){  
				cMonth=1-cMonth;  
			}     
			if(cMonth>Math.floor(CalendarData[m]/0x10000)+1){  
				cMonth--;  
			}    
		}  
	}  
	  
	function GetcDateString(){  
		var tmp="";  
		tmp+=tgString.charAt((cYear-4)%10);  
		tmp+=dzString.charAt((cYear-4)%12);  
		tmp+="(";  
		tmp+=sx.charAt((cYear-4)%12);  
		tmp+=")年 ";  
		if(cMonth<1){  
			tmp+="(闰)";  
			tmp+=monString.charAt(-cMonth-1);  
		}else{  
			tmp+=monString.charAt(cMonth-1);  
		}  
		tmp+="月";  
		tmp+=(cDay<11)?"初":((cDay<20)?"十":((cDay<30)?"廿":"三十"));  
		if (cDay%10!=0||cDay==10){  
			tmp+=numString.charAt((cDay-1)%10);  
		}  
		return tmp;  
	}  
	  
	function GetLunarDay(solarYear,solarMonth,solarDay){  
		//solarYear = solarYear<1900?(1900+solarYear):solarYear;  
		if(solarYear<1921 || solarYear>2020){  
			return "";  
		}else{  
			solarMonth = (parseInt(solarMonth)>0) ? (solarMonth-1) : 11;  
			e2c(solarYear,solarMonth,solarDay);  
			return GetcDateString();  
		}  
	}  
	  
	var D=new Date();  
	var yy=D.getFullYear();  
	var mm=D.getMonth()+1;  
	var dd=D.getDate();  
	var ww=D.getDay();  
	var ss=parseInt(D.getTime() / 1000);  

	if (yy<100) yy="19"+yy;  
	function showCal(){  
		//document.write(GetLunarDay(yy,mm,dd)); 
		window.document.getElementById ("date_nongli_id").innerHTML = GetLunarDay(yy,mm,dd);
	}   
	  
	 
	//var innnss = today.getFullYear()+"年"+(today.getMonth()+1)+"月"+today.getDate()+"日 "+d[today.getDay()+1]+" ";
	$(document).ready(function () {
		//var ele=window.document.getElementById ("a");
		//ele.innerHTML = innnss;
		showCal(); 
		var date_top = today.getFullYear()+"-"+(today.getMonth()+1);
		var date_day = today.getDate();
		var date_week = d[today.getDay()+1];
		window.document.getElementById ("date_top_id").innerHTML = date_top;
		window.document.getElementById ("date_day_id").innerHTML = date_day;
		window.document.getElementById ("date_week_id").innerHTML = date_week;
	    //window.document.getElementById ("shijian").innerHTML = today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
		var t=new Date().valueOf();
		showTime();
		function fillzero(v){
			if(v<10){
				v="0"+v;
			}
			return v;
		}
		function getLocalTime(Sj) {
			document.getElementById("shijian").innerHTML=fillzero(new Date(parseInt(Sj)).getHours())+":"+fillzero(new Date(parseInt(Sj)).getMinutes())+":"+fillzero(new Date(parseInt(Sj)).getSeconds());
		}
		function showTime() {
			t+=1000;
			getLocalTime(t);
			window.setTimeout(showTime,1000);
		}
		
		//根据成员id查询是否签到
		var m_id = $("#memberinfo_id").html();
		//alert(m_id);
		url1 = url + '/judgememberatten';
		$.ajax({   
	    	type:'POST', //用POST方式传输   
	        url:url1,      //目标地址 
	        datatype:"html",       
	        data:{"m_id":m_id},
			cache:false,
	        success:function(data) {
	        	//alert(data);
	        	var checkin = "&nbsp;";
	        	var checkout = "&nbsp;";
	        	var str = eval("("+data+")");
	        	if(str.isCheckin){
	        		checkin = "<span style='color: #999'>已签到 &nbsp;&nbsp;<font style='font-weight:bold;'>" + str.check_in_time + "</font>&nbsp;&nbsp;（"+str.ipinfo_in+"）</span>";
	        		checkout = "<a style='text-decoration: none;' onclick='checkoutmethod();' href='javascript:void(0);'>[&nbsp;&nbsp;签&nbsp;退&nbsp;&nbsp;]</a>";
	        	}else {
	        		checkin = "<a style='text-decoration: none;' onclick='checkinmethod();' href='javascript:void(0);'>[&nbsp;&nbsp;签&nbsp;到&nbsp;&nbsp;]</a>";
	        	}
	        	if(str.isCheckout){
	        		checkout = "<span style='color: #999'>已签退 &nbsp;&nbsp;<font style='font-weight:bold;'>" + str.check_out_time + "</font>&nbsp;&nbsp;（"+str.ipinfo_out+"）</span>";
	        	}else {
	        	}
        		document.getElementById('checkindate').innerHTML = checkin;
        		document.getElementById('checkoutdate').innerHTML = checkout;
	         	//alert(checkout);
	        },
	        error:function(data) {
				alert("操作失败，请刷新后重新操作！！");
			}
	    }); 
	});
</script>
				<!-- 隐藏内容，查询出成员id -->
				<span id="memberinfo_id" style="display: none;"><%=memberinfo.getM_id() %></span>
				<!-- 隐藏内容，查询出成员id -->	
				
						<div class="col-md-3 column">
							<div class="date-wrap" style="margin: 0 auto;">
								<div class="date-top" id="date_top_id"></div>
								<div class="date-body">
									<div class="date-day" id="date_day_id"></div>
									<div class="p14" id="date_week_id"></div>
									<div class="muted" id="date_nongli_id"></div>
								</div>
							</div>
						</div>
						<div class="col-md-9 column">
						<input type="text" value="<%=ip %>" style="display: none;" id="atten_ipaddr"/>
							<table class="table table-bordered" style="background-color: #f9f9f9;">
							 <caption>默认班次</caption>
							  <tbody>
							    <tr>
							      <td rowspan="2" style="text-align: center; width: 150px;">
							      	<span class="p15" id="shijian">15:40:58</span>
							      	<span class="muted">19:00~22:00</span>
							      </td>
							      
							      <td style="text-align: center;" id="checkindate">
							      	&nbsp;
							      </td>
							    </tr>
							    <tr>
							      <td style="text-align: center;" id="checkoutdate">
							      	&nbsp;
							      </td>
							    </tr>
							  </tbody>
							</table>
							
						</div>
					</div>	
				</div>
				<!-- 全部公告 -->
			</div>
		</div>
</div>
  </body>
</html>
