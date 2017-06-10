package com.rms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rms.model.Attendance;
import com.rms.model.AttendanceChart;
import com.rms.model.Attendance_unusual;
import com.rms.model.DefaultIP;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.model.Shift;
import com.rms.page.AllstatePage;
import com.rms.page.AttenStaticPage;
import com.rms.page.AttenallrecordPage;
import com.rms.page.AttenpendingPage;
import com.rms.page.AttenrecordPage;
import com.rms.page.Kaoqinjilubiao;
import com.rms.page.Kaoqinshenhebiao;
import com.rms.util.DateUtil;
import com.rms.util.PmnUtils;

@SuppressWarnings({ "serial", "deprecation" })
@Component("AttendanceAction")
@Scope("prototype")
public class AttendanceAction extends BaseAction{
	private HttpServletRequest request;
	private int a_id;
	private String a_ip;
	private String a_datetime;
	private String a_check_in_time;
	private String a_check_out_time;
	private int m_id;
	private String datepicker;
	private String statenormal;
	private String remark;
	private int state;
	private String infos;
	private String states;
	private String sectionname;
	private String yearname;
	private String monthname;
	private String time1;
	private String time2;
	private boolean tongji;
	private boolean jilu;
	private boolean shenhe;
	private String filename;
	private String check_in_hour;
	private String check_in_minute;
	private String check_out_hour;
	private String check_out_minute;
	private String elas_time;
	private String nowtime;
	private String methodType;
	private String ipname;
	private String ipaddr;
	private int id;
	private String atten_ipaddr;
	private String dufaultshift;
	
	public String getDufaultshift() {
		return dufaultshift;
	}
	public void setDufaultshift(String dufaultshift) {
		this.dufaultshift = dufaultshift;
	}
	public String getAtten_ipaddr() {
		return atten_ipaddr;
	}
	public void setAtten_ipaddr(String atten_ipaddr) {
		this.atten_ipaddr = atten_ipaddr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIpname() {
		return ipname;
	}
	public void setIpname(String ipname) {
		this.ipname = ipname;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	public String getCheck_in_hour() {
		return check_in_hour;
	}
	public void setCheck_in_hour(String check_in_hour) {
		this.check_in_hour = check_in_hour;
	}
	public String getCheck_in_minute() {
		return check_in_minute;
	}
	public void setCheck_in_minute(String check_in_minute) {
		this.check_in_minute = check_in_minute;
	}
	public String getCheck_out_hour() {
		return check_out_hour;
	}
	public void setCheck_out_hour(String check_out_hour) {
		this.check_out_hour = check_out_hour;
	}
	public String getCheck_out_minute() {
		return check_out_minute;
	}
	public void setCheck_out_minute(String check_out_minute) {
		this.check_out_minute = check_out_minute;
	}
	public String getElas_time() {
		return elas_time;
	}
	public void setElas_time(String elas_time) {
		this.elas_time = elas_time;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public boolean isTongji() {
		return tongji;
	}
	public void setTongji(boolean tongji) {
		this.tongji = tongji;
	}
	public boolean isJilu() {
		return jilu;
	}
	public void setJilu(boolean jilu) {
		this.jilu = jilu;
	}
	public boolean isShenhe() {
		return shenhe;
	}
	public void setShenhe(boolean shenhe) {
		this.shenhe = shenhe;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getYearname() {
		return yearname;
	}
	public void setYearname(String yearname) {
		this.yearname = yearname;
	}
	public String getMonthname() {
		return monthname;
	}
	public void setMonthname(String monthname) {
		this.monthname = monthname;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatenormal() {
		return statenormal;
	}
	public void setStatenormal(String statenormal) {
		this.statenormal = statenormal;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_ip() {
		return a_ip;
	}
	public void setA_ip(String a_ip) {
		this.a_ip = a_ip;
	}
	public String getA_datetime() {
		return a_datetime;
	}
	public void setA_datetime(String a_datetime) {
		this.a_datetime = a_datetime;
	}
	public String getA_check_in_time() {
		return a_check_in_time;
	}
	public void setA_check_in_time(String a_check_in_time) {
		this.a_check_in_time = a_check_in_time;
	}
	public String getA_check_out_time() {
		return a_check_out_time;
	}
	public void setA_check_out_time(String a_check_out_time) {
		this.a_check_out_time = a_check_out_time;
	}
	public String getDatepicker() {
		return datepicker;
	}
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * 判断该成员是否签到
	 * @return
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public void judgememberatten() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		m_id=memberinfo.getM_id();
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		String tanxing_time = ss.getElas_time();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isCheckin = false;
		boolean isCheckout = false; 
		String check_in_time = null;
		String check_out_time = null;
		boolean instate = false;
		boolean outstate = false;
		String ipinfo_in = "";
		String ipinfo_out="";
		String ipaddr_in = "";
		String ipaddr_out="";
		//获取当前日期
		String datetime = DateUtil.getNowStrDate();
		//根据成员id查询该成员签到信息
		List<Attendance> atten = attendanceService.findAttendanceinfos(m_id,datetime);
		if(atten != null && atten.size() > 0){
			Attendance a = atten.get(0);
			ipinfo_in = a.getIpinfo_in();
			ipaddr_in = a.getIpaddr_in();
			ipinfo_out = a.getIpinfo_out();
			ipaddr_out = a.getIpaddr_out();
			//该成员已签到
			isCheckin = true;
			check_in_time = a.getA_check_in_time();
			if(Double.parseDouble(DateUtil.getTwoHour(check_in_time,DateUtil.getPreTimehhmm(check_in,tanxing_time))) > 0){
				instate = true;
			}
			//判断该成员时候签退
			if(a.getA_check_out_time() != null){
				//该成员已签退
				isCheckout = true;
				check_out_time = a.getA_check_out_time();
				if(Double.parseDouble(DateUtil.getTwoHour(DateUtil.getNextTimehhmm(check_out,tanxing_time),check_out_time)) > 0){
					outstate = true;
				}
			}
		}
		JSONObject json = new JSONObject();
		json.put("isCheckin", isCheckin);
		json.put("isCheckout", isCheckout);
		json.put("check_in_time", check_in_time);
		json.put("check_out_time", check_out_time);
		json.put("outstate", outstate);
		json.put("instate", instate);
		json.put("check_in", check_in);
		json.put("check_out", check_out);
		json.put("ipinfo_in", ipinfo_in);
		json.put("ipinfo_out", ipinfo_out);
		json.put("ipaddr_in", ipaddr_in);
		json.put("ipaddr_out", ipaddr_out);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 检验签到签退时间是否合适
	 * 这里按规定时间的1个小时来算
	 * 即19:00签到，在18:00以前算不合适，18:00到19:00为合适时间
	 * 签退也是如此
	 */
	public void checkBanciInfo() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isNice = true;
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		if(null==nowtime || "".equals(nowtime)){
			nowtime = "00:00";
		}
		if("checkin".equals(methodType)){
			//判断签到时间是否合适
			double size = Double.parseDouble(DateUtil.getTwoHour(check_in, nowtime));
			if(size>1){
				isNice = false;
			}
		}else{
			double size = Double.parseDouble(DateUtil.getTwoHour(check_out,nowtime));
			if(size>0){
				isNice = false;
			}
		}
		JSONObject json = new JSONObject();
		json.put("isNice", isNice);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 签到的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public void checkinAction() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		//获取默认班次
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		String tanxing_time = ss.getElas_time();
		//获取当前日期    yyyy-MM-dd
		String datetime = DateUtil.getNowStrDate();
		//获取当前时间    HH:mm
		String checkintime = nowtime;
		String yueritime = DateUtil.getMonth()+"月"+DateUtil.getMonthtoToday()+"日";
		String nianyuetime = DateUtil.getYear()+"年"+DateUtil.getMonth()+"月";
		
		//获取正常ip
		String ipinfo = "<font size='2' color=red>IP异常："+atten_ipaddr+"</font>";
		boolean ipbolean = true;
		List<DefaultIP> dip = attendanceService.findAllIp();
		if(dip!=null && dip.size()>0){
			for (DefaultIP d : dip) {
				String ip = d.getIpaddr();
				if(atten_ipaddr.equals(ip)){
					ipinfo = "<font size='2' color='#999'>IP："+atten_ipaddr+"</font>";
					ipbolean = false;
					break;
				}
			}
		}
		
		Attendance ad = new Attendance();
		ad.setA_check_in_time(checkintime);
		ad.setA_datetime(datetime);
		ad.setA_yueritime(yueritime);
		ad.setA_nianyuetime(nianyuetime);
		ad.setM_id(memberinfo.getM_id());
		ad.setIpinfo_in(ipinfo);
		ad.setIpaddr_in(atten_ipaddr);
		ad.setShiftsection(check_in+"~"+check_out);
		if(ipbolean){
			ad.setIpstate("IP异常");
		}else{
			ad.setIpstate("IP正常");
		}
		//比较当前时间与默认班次的签到时间
		if(Double.parseDouble(DateUtil.getTwoHour(checkintime,DateUtil.getPreTimehhmm(check_in,tanxing_time))) > 0){
			ad.setA_state("迟到，未签退");
		}else {
			ad.setA_state("未签退");
		}
		//Thread.sleep(3000);
		//添加签到信息
		attendanceService.addcheckininfos(ad);
		//刷新界面信息
		this.judgememberatten();
	
	}
	
	/**
	 * 签退的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 216-10-27
	 */
	public void checkoutAction() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		m_id=memberinfo.getM_id();
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		String tanxing_time = ss.getElas_time();
		//获取正常ip
		String ipinfo = "<font size='2' color=red>IP异常："+atten_ipaddr+"</font>";
		boolean ipbolean = true;
		List<DefaultIP> dip = attendanceService.findAllIp();
		if(dip!=null && dip.size()>0){
			for (DefaultIP d : dip) {
				String ip = d.getIpaddr();
				if(atten_ipaddr.equals(ip)){
					ipinfo = "<font size='2' color='#999'>IP："+atten_ipaddr+"</font>";
					ipbolean = false;
					break;
				}
			}
		}
		String states = "";
		//获取当前日期    yyyy-MM-dd
		String datetime = DateUtil.getNowStrDate();
		//获取当前时间    HH:mm
		//String checkouttime = DateUtil.getTimeHHmm();        
		String checkouttime = nowtime;
		//查询出考勤信息
		List<Attendance> atten = attendanceService.findAttendanceinfos(m_id,datetime);
		Attendance at = atten.get(0);
		at.setA_check_out_time(checkouttime);
		if(at.getA_state().equals("未签退")){
			//比较当前时间与默认班次的签退时间
			if(Double.parseDouble(DateUtil.getTwoHour(DateUtil.getNextTimehhmm(check_out,tanxing_time),checkouttime)) > 0){
				states="早退";
			}else {
				states="正常";
			}
		}else{
			//比较当前时间与默认班次的签退时间
			if(Double.parseDouble(DateUtil.getTwoHour(DateUtil.getNextTimehhmm(check_out,tanxing_time),checkouttime)) > 0){
				states="迟到，早退";
			}else {
				states="迟到";
			}
		}
		double timediffer = Double.parseDouble(DateUtil.getTwoHour(checkouttime,at.getA_check_in_time()));
		at.setTime_difference(PmnUtils.pmn(timediffer));
		at.setA_state(states);
		at.setIpinfo_out(ipinfo);
		at.setIpaddr_out(atten_ipaddr);
		if(ipbolean){
			at.setIpstate("IP异常");
		}else{
			at.setIpstate("IP正常");
		}
		//签退的方法
		attendanceService.updateAttendance(at);
		//刷新界面信息
		this.judgememberatten();
	}
	
	/**
	 * 根据成员id查询该成员所有的签到信息
	 */
	public String findattenrecordAction() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		//根据成员id查询该成员所有的签到信息
		List<Attendance> atten = attendanceService.findAllattendanceinfosBym_id(memberinfo.getM_id());
		request.setAttribute("attendanceinfo", atten);
		return "success";
	}
	
	/**
	 * 根据日期查找用户的考勤信息
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public void finduseratteninfo() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		boolean isempty=false;
		//根据日期查找用户的考勤信息
		List<Attendance> atten = attendanceService.finduseratteninfo(memberinfo.getM_id(),datepicker);
		if(atten != null){
			isempty = true;
			Attendance aa = atten.get(0);
			json.put("checkintime", aa.getA_check_in_time());
			json.put("checkouttime", aa.getA_check_out_time());
			json.put("state", aa.getA_state());
			json.put("yueritime", datepicker);
			json.put("shiftsection", aa.getShiftsection());
		}
		json.put("isempty", isempty);
		//获取默认班次
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		json.put("shiftsection", check_in+"~"+check_out);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 考勤异常的申请
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public void attenapplyinfo() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		//根据申诉日期查找是否申诉过
		if(!attendanceService.isExistDate(a_datetime)){
			//根据日期查找用户的考勤信息
			List<Attendance> atten = attendanceService.finduseratteninfo(memberinfo.getM_id(),a_datetime);
			Attendance_unusual au = new Attendance_unusual();
			if(atten != null && atten.size() > 0){
				Attendance aa = atten.get(0);
				au.setBeforestate(aa.getA_state());
				String outtime = "";
				if(aa.getA_check_out_time()==null){
					outtime = "-";
				}else{
					outtime = aa.getA_check_out_time();
				}	  
				au.setCheck_in_out_time(aa.getA_check_in_time()+"~"+outtime);
			}else {
				au.setBeforestate("缺勤");
				au.setCheck_in_out_time("-");
			}
			au.setDatetime(a_datetime);
			au.setRemark(remark);
			au.setApplyuser_id(memberinfo.getM_id());
			au.setTime(DateUtil.getTimeHHmm());
			au.setDtime(DateUtil.getNowStrDate());
			au.setNow_week(DateUtil.getWeek(DateUtil.getNowStrDate()));
			au.setAtten_week(DateUtil.getWeek(a_datetime));
			au.setTimeinfo(DateUtil.getLongDateS());
			au.setState(1);
			au.setAfterstate("-");
			//保存当前考勤时段
			/*List<Shift> ssinfo = attendanceService.findshiftInfo();
			Shift ss = ssinfo.get(0);
			String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
			String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();*/
			au.setAttendanceshift(dufaultshift);
			//加入到考勤异常数据库
			attendanceService.addatten_unusual(au);
			json.put("infos", "申请成功，请等待结果！！");
		}else{
			json.put("infos", "禁止重复提交申请，请耐心等待结果！！");
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 查看成员的申诉记录的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-30
	 */
	public String findmyappealAction() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		//查询成员申诉记录的方法
		List<Attendance_unusual> atten = attendanceService.findmyappealmethod(state,memberinfo.getM_id());
		
		request.setAttribute("atten_unusualinfo", atten);
		return "success";
	}
	
	/**
	 * 查看我的未处理的申诉
	 * @throws Exception
	 * @author yangzijia
	 */
	public void findweichuliappealinfo() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		//查询成员申诉记录的方法
		List<Attendance_unusual> atten = attendanceService.findmyappealmethod(state,memberinfo.getM_id());
		
		JSONArray jsona = new JSONArray();
		if(atten!= null && atten.size() > 0){
			isempty = true;
			for(int i=0;i<atten.size();i++){
				jsona.add(i,atten.get(i));
			}
		}
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 查看所有的考勤记录
	 * @return
	 * @throws Exception
	 */
	public String findcheckrecordinfo() throws Exception {
		request = ServletActionContext.getRequest();
		//根据当前时间查询出签到的人数
		int checkinNum = 0;
		//查询出签退的人数
		int checkoutNum = 0;
		int NocheckinNum = 0;
		//获取当前日期    yyyy-MM-dd
		String datetime = DateUtil.getNowStrDate();
		//根据当前时间查询出今天签到的人的信息
		List<Attendance> attens = attendanceService.findAttendanceinfo(datetime);
		//根据进科研室的时间查询出所有的用户
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		if(msi != null && msi.size() > 0){
			NocheckinNum = msi.size();
			if(attens != null && attens.size() > 0){
				checkinNum = attens.size();
				//未打卡的人数为
				NocheckinNum = NocheckinNum-checkinNum;
				//查询签退的人数的方法
				for(int i=0;i<attens.size();i++){
					Attendance aa = attens.get(i);
					if(aa.getA_check_out_time() != null){
						//已签退
						checkoutNum++;
					}
				}
			}
		}
		//查询出待处理申诉信息的数量
		int pendingappealNum = attendanceService.findpendingappealNum();
		AttenallrecordPage arp = new AttenallrecordPage();
		arp.setCheckinNum(checkinNum);
		arp.setCheckoutNum(checkoutNum);
		arp.setNocheckinNum(NocheckinNum);
		arp.setPendingappealNum(pendingappealNum);
		arp.setDatetime(datetime);
		request.setAttribute("arpinfo", arp);
		request.setAttribute("memberinfo", msi);
		request.setAttribute("atteninfoss", attens);
		return "success";
	}
	
	/**
	 * 根据日期查看考勤记录
	 * @throws Exception
	 * @author yangzijia
	 */
	public String findseerecordinfoqq() throws Exception {
		request = ServletActionContext.getRequest();
		//根据当前时间查询出签到的人数
		int checkinNum = 0;
		//查询出签退的人数
		int checkoutNum = 0;
		int NocheckinNum = 0;
		//根据当前时间查询出今天签到的人的信息
		List<Attendance> attens = attendanceService.findAttendanceinfo(datepicker);
		//根据进科研室的时间查询出所有的用户
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		if(msi != null && msi.size() > 0){
			NocheckinNum=msi.size();
			if(attens != null && attens.size() > 0){
				checkinNum = attens.size();
				//未打卡的人数为
				NocheckinNum = NocheckinNum-checkinNum;
				//查询签退的人数的方法
				for(int i=0;i<attens.size();i++){
					Attendance aa = attens.get(i);
					if(aa.getA_check_out_time() != null){
						//已签退
						checkoutNum++;
					}
				}
			}
		}
		//查询出待处理申诉信息的数量
		int pendingappealNum = attendanceService.findpendingappealNum();
		AttenallrecordPage arp = new AttenallrecordPage();
		arp.setCheckinNum(checkinNum);
		arp.setCheckoutNum(checkoutNum);
		arp.setNocheckinNum(NocheckinNum);
		arp.setPendingappealNum(pendingappealNum);
		arp.setDatetime(datepicker);
		request.setAttribute("arpinfo", arp);
		request.setAttribute("memberinfo", msi);
		request.setAttribute("atteninfoss", attens);
		return "success";
	}
	
	/**
	 * 查看所有成员的异常考勤
	 * @return
	 * @throws Exception
	 */
	public String open_unusualpage() throws Exception {
		request = ServletActionContext.getRequest();
		//查询出待处理申诉信息的数量
		int pendingappealNum = attendanceService.findpendingappealNum();
		//查询出当月申请的所有的异常考勤
		List<Attendance_unusual> au = attendanceService.findallatten_unusualinfo();
		//泛型
		ArrayList<AttenpendingPage> al=new ArrayList<AttenpendingPage>();
		if(au != null && au.size() > 0){
			for(int i=0;i<au.size();i++){
				Attendance_unusual a = au.get(i);
				AttenpendingPage app = new AttenpendingPage();
				app.setId(a.getId());
				app.setDatetime(a.getDatetime());
				if(a.getOperator_id()!=0){
					//根据用户id查询出用户信息
					MembershipInfo msi = systemsetService.findmemberinfoByid(a.getOperator_id());
					app.setOperatorname(msi.getM_truename());
				}else{
					app.setOperatorname("-");
				}
				if(a.getAfterstate()!=null){
					app.setState(a.getAfterstate());
					app.setAfterstate(a.getBeforestate());
				}else{
					app.setState(a.getBeforestate());
				}
				//1为已处理，，，2为未处理
				app.setStatenum(a.getState());
				//根据用户id查询出用户信息
				MembershipInfo msi = systemsetService.findmemberinfoByid(a.getApplyuser_id());
				app.setUsername(msi.getM_truename());
				app.setWeek(a.getAtten_week());
				app.setCheck_in_out_info(a.getCheck_in_out_time());
				app.setM_id(a.getApplyuser_id());
				app.setShiftsection(a.getAttendanceshift());
				al.add(app);
			}
		}
		request.setAttribute("alinfo", al);
		request.setAttribute("pendingappealNum", pendingappealNum);
		return "success";
	}
	
	/**
	 * 根据具体条件查看考勤异常信息
	 * @throws Exception
	 * @author yangzijia
	 */
	public void findBYtunusualrecord() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		//根据infos查询出所有的异常考勤
		List<Attendance_unusual> au = attendanceService.findallatten_unusualByinfos(infos,states);
		//jsonarray
		JSONArray jsona = new JSONArray();
		if(au != null && au.size() > 0){
			isempty = true;
			for(int i=0;i<au.size();i++){
				Attendance_unusual a = au.get(i);
				AttenpendingPage app = new AttenpendingPage();
				app.setId(a.getId());
				app.setDatetime(a.getDatetime());
				app.setM_id(a.getApplyuser_id());
				if(a.getOperator_id()!=0){
					//根据用户id查询出用户信息
					MembershipInfo msi = systemsetService.findmemberinfoByid(a.getOperator_id());
					app.setOperatorname(msi.getM_truename());
				}else{
					app.setOperatorname("-");
				}
				if(a.getAfterstate()!=null){
					app.setState(a.getAfterstate());
					app.setAfterstate(a.getBeforestate());
				}else{
					app.setState(a.getBeforestate());
				}
				//1为已处理，，，2为未处理
				app.setStatenum(a.getState());
				//根据用户id查询出用户信息
				MembershipInfo msi = systemsetService.findmemberinfoByid(a.getApplyuser_id());
				app.setUsername(msi.getM_truename());
				app.setWeek(a.getAtten_week());
				app.setCheck_in_out_info(a.getCheck_in_out_time());
				app.setShiftsection(a.getAttendanceshift());
				jsona.add(i, app);
			}
		}
		//查询出待处理申诉信息的数量
		int pendingappealNum = attendanceService.findpendingappealNum();
		JSONObject json = new JSONObject();
		json.put("isempty", isempty);
		json.put("jsona", jsona);
		json.put("pendingappealNum", pendingappealNum);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 保存处理hou的异常考勤信息
	 * @throws Exception
	 * @author yangzijia
	 */
	public void savecheckrecordunusualinfo() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		/*List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();*/
		//根据id查找出该条异常的考勤信息
		List<Attendance_unusual> auu = attendanceService.findattenunusualByid(a_id);
		Attendance_unusual aa = auu.get(0);
		//根据前台传来的数据进行修改
		aa.setAfterstate(remark);
		aa.setOperator_id(memberinfo.getM_id());
		aa.setState(2);
		//更新保存Attendance_unusual
		attendanceService.updateAttendance_unusual(aa);
		String[] ds = aa.getAttendanceshift().split("~");
		
		//修改考勤表的异常Attendance
		List<Attendance> ad = attendanceService.findAttendanceinfosbydatetime(aa.getDatetime());
		if(ad!=null && ad.size() >0){
			Attendance a = ad.get(0);
			a.setA_check_in_time(ds[0].toString());
			a.setA_check_out_time(ds[1].toString());
			a.setA_state("正常");
			a.setIpaddr_out(a.getIpaddr_in());
			a.setIpinfo_out(a.getIpinfo_in());
			a.setTime_difference(DateUtil.getTwoHour(ds[1].toString(),ds[0].toString()));
			//更新保存表Attendance
			attendanceService.updateAttendance(a);
		}else{
			String yueritime = DateUtil.getMonth()+"月"+DateUtil.getMonthtoToday()+"日";
			String nianyuetime = DateUtil.getYear()+"年"+DateUtil.getMonth()+"月";
			Attendance a3 = new Attendance();
			a3.setA_check_in_time(ds[0].toString());
			a3.setA_check_out_time(ds[1].toString());
			a3.setA_state("正常");
			a3.setTime_difference(DateUtil.getTwoHour(ds[1].toString(),ds[0].toString()));
			a3.setA_datetime(aa.getDatetime());
			a3.setA_yueritime(yueritime);
			a3.setM_id(m_id);
			a3.setShiftsection(aa.getAttendanceshift());
			a3.setIpaddr_out("-");
			a3.setIpinfo_out("-");
			a3.setIpaddr_in("-");
			a3.setIpinfo_in("-");
			a3.setA_nianyuetime(nianyuetime);
			//保存到Attendance
			attendanceService.addAttendance(a3);
		}
		
		//查询出界面信息进行刷新
		this.findBYtunusualrecord();
	}
	
	/**
	 * 打开待处理申诉界面
	 * @throws Exception
	 * @author yangzijia
	 */
	public String open_pendingappeal() throws Exception{
		request = ServletActionContext.getRequest();
		//查询出带出里的申诉信息
		List<Attendance_unusual> auu = attendanceService.findattendanceunusual1();
		ArrayList<AttenrecordPage> al=new ArrayList<AttenrecordPage>();
		if(auu!=null &&auu.size()>0){
			for(int i=0;i<auu.size();i++){
				Attendance_unusual a = auu.get(i);
				AttenrecordPage ap = new AttenrecordPage();
				ap.setAfterstate(a.getAfterstate());
				//根据用户id查询出用户信息
				MembershipInfo msi = systemsetService.findmemberinfoByid(a.getApplyuser_id());
				ap.setM_id(a.getApplyuser_id());
				ap.setApplyusername(msi.getM_truename());
				ap.setAtten_week(a.getAtten_week());
				ap.setBeforestate(a.getBeforestate());
				ap.setCheck_in_out_time(a.getCheck_in_out_time());
				ap.setDatetime(a.getDatetime());
				ap.setDtime(a.getDtime());
				ap.setId(a.getId());
				ap.setRemark(a.getRemark());
				ap.setState(a.getState());
				ap.setTime(a.getTime());
				ap.setTimeinfo(a.getTimeinfo());
				ap.setShiftsection(a.getAttendanceshift());
				al.add(ap);
			}
		}
		//查询出待处理申诉信息的数量
		int pendingappealNum = attendanceService.findpendingappealNum();
		request.setAttribute("auuinfo", al);
		request.setAttribute("pendingappealNum", pendingappealNum);
		return "success";
	}
	
	/**
	 * 将修改后的考勤信息保存到数据库
	 * @throws Exception
	 */
	public void savecheckrecordunusualpending() throws Exception {
		
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		
		//根据id查找出该条异常的考勤信息
		List<Attendance_unusual> auu = attendanceService.findattenunusualByid(a_id);
		Attendance_unusual aa = auu.get(0);
		//根据前台传来的数据进行修改
		aa.setAfterstate(remark);
		aa.setOperator_id(memberinfo.getM_id());
		aa.setState(2);
		//更新保存Attendance_unusual
		attendanceService.updateAttendance_unusual(aa);
		String[] ds = aa.getAttendanceshift().split("~");
		
		//修改考勤表的异常Attendance
		List<Attendance> ad = attendanceService.findAttendanceinfos(m_id, aa.getDatetime());
		if(ad!=null && ad.size() >0){
			Attendance a = ad.get(0);
			a.setA_check_in_time(ds[0].toString());
			a.setA_check_out_time(ds[1].toString());
			a.setA_state("正常");
			a.setIpaddr_out(a.getIpaddr_in());
			a.setIpinfo_out(a.getIpinfo_in());
			a.setTime_difference(DateUtil.getTwoHour(ds[1].toString(),ds[0].toString()));
			//更新保存表Attendance
			attendanceService.updateAttendance(a);
		}else{
			String yueritime = DateUtil.getMonth()+"月"+DateUtil.getMonthtoToday()+"日";
			String nianyuetime = DateUtil.getYear()+"年"+DateUtil.getMonth()+"月";
			Attendance a3 = new Attendance();
			a3.setA_check_in_time(ds[0].toString());
			a3.setA_check_out_time(ds[1].toString());
			a3.setA_state("正常");
			a3.setIpaddr_out("-");
			a3.setIpinfo_out("-");
			a3.setIpaddr_in("-");
			a3.setIpinfo_in("-");
			a3.setShiftsection(aa.getAttendanceshift());
			a3.setTime_difference(DateUtil.getTwoHour(ds[1].toString(),ds[0].toString()));
			a3.setA_datetime(aa.getDatetime());
			a3.setA_yueritime(yueritime);
			a3.setM_id(m_id);
			a3.setA_nianyuetime(nianyuetime);
			//保存到Attendance
			attendanceService.addAttendance(a3);
		}
	}
	
	int chidaon = 0;
	int zaotuin = 0;
	int weiqiantuin = 0;
	int chituin = 0;
	int chiweituin = 0;
	int queqinn = 0;
	int allchidaon = 0;
	int allzaotuin = 0;
	int allweiqiantuin = 0;
	int allchituin = 0;
	int allchiweituin = 0;
	int allqueqinn = 0;
	int Nokaoqin = 0;
	int allmonthnum = 0;
	int ipinfo = 0;
	int allipinfo = 0;
	
	/**
	 * 查询出考勤统计界面的所有信息
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-11-2
	 */
	public String findcheckstatistics() throws Exception {
		request = ServletActionContext.getRequest();
		ArrayList<AttenStaticPage> al = new ArrayList<AttenStaticPage>();
		//查询出所有分组
		List<Section> section = systemsetService.findsectioninfo();
		//获取当前年月 ,日期
		String nianyuetime = DateUtil.getYear()+"年"+DateUtil.getMonth()+"月";
		//计算当月到今天有几天
		allmonthnum = DateUtil.getMonthtoToday();
		//计算当月有几天不用考勤
		Nokaoqin = DateUtil.getweeknum(nianyuetime, "星期六", allmonthnum);
		//查询出所有启用人员信息
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		AllstatePage ap = new AllstatePage();
		//ap.setMonth(DateUtil.getMonth()+"");
		//ap.setYear(DateUtil.getYear()+"");
		if(msi != null && msi.size() > 0){
			for(int i=0;i<msi.size();i++){
				MembershipInfo m = msi.get(i);
				//根据当前日期和成员id查询出当月考勤信息
				List<Attendance> at1 = attendanceService.findatteninfoBym_idnianyuetime(m.getM_id(),nianyuetime);
				AttenStaticPage asp = new AttenStaticPage();
				asp.setUsername(m.getM_truename());
				asp.setSectionname(m.getM_sectionname());
				if(at1 != null && at1.size() > 0){
					for(int j=0;j<at1.size();j++){
						Attendance a1 = at1.get(j);
						if(("迟到").equals(a1.getA_state())){
							allchidaon++;
							chidaon++;
						}else if(("早退").equals(a1.getA_state())){
							allzaotuin++;
							zaotuin++;
						}else if(("未签退").equals(a1.getA_state())){
							allweiqiantuin++;
							weiqiantuin++;
						}else if(("迟到，早退").equals(a1.getA_state())){
							allchituin++;
							chituin++;
						}else if(("迟到，未签退").equals(a1.getA_state())){
							allchiweituin++;
							chiweituin++;
						}
						if(("IP异常").equals(a1.getIpstate())){
							allipinfo++;
							ipinfo++;
						}
					}
					//计算当月缺勤数
					queqinn = allmonthnum - Nokaoqin - at1.size();
					allqueqinn = allqueqinn + queqinn;
					if(chidaon==0){
						asp.setChidaon("-");
					}else{
						asp.setChidaon(chidaon+"");
					}
					if(queqinn==0){
						asp.setQueqinn("-");
					}else{
						asp.setQueqinn(queqinn+"");
					}
					if(chituin==0){
						asp.setChituin("-");
					}else{
						asp.setChituin(chituin+"");
					}
					if(chiweituin==0){
						asp.setChiweituin("-");
					}else{
						asp.setChiweituin(chiweituin+"");
					}
					if(weiqiantuin==0){
						asp.setWeiqiantuin("-");
					}else{
						asp.setWeiqiantuin(weiqiantuin+"");
					}
					if(zaotuin==0){
						asp.setZaotuin("-");
					}else{
						asp.setZaotuin(zaotuin+"");
					}
					if(ipinfo==0){
						asp.setIpinfo("-");
					}else{
						asp.setIpinfo(ipinfo+"");
					}
					asp.setShijichuqin(at1.size()+"");
				}else{
					//计算当月缺勤数
					queqinn = allmonthnum - Nokaoqin;
					allqueqinn = allqueqinn + queqinn;
					asp.setChidaon("-");
					asp.setChituin("-");
					asp.setChiweituin("-");
					asp.setWeiqiantuin("-");
					asp.setQueqinn(queqinn+"");
					asp.setZaotuin("-");
					asp.setShijichuqin("-");
					asp.setIpinfo("-");
				}
				al.add(asp);
				chidaon = 0;
				zaotuin = 0;
				weiqiantuin = 0;
				chituin = 0;
				chiweituin = 0;
				queqinn = 0;
				ipinfo = 0;
			}
			
			if(allchidaon==0){
				ap.setAllchidaon("-");
			}else{
				ap.setAllchidaon(allchidaon+"");
			}
			if(allchituin==0){
				ap.setAllchituin("-");
			}else{
				ap.setAllchituin(allchituin+"");
			}
			if(allchiweituin==0){
				ap.setAllchiweituin("-");
			}else{
				ap.setAllchiweituin(allchiweituin+"");
			}
			if(allweiqiantuin==0){
				ap.setAllweiqiantuin("-");
			}else{
				ap.setAllweiqiantuin(allweiqiantuin+"");
			}
			if(allzaotuin==0){
				ap.setAllzaotuin("-");
			}else{
				ap.setAllzaotuin(allzaotuin+"");
			}
			if(allqueqinn==0){
				ap.setAllqueqinn("-");
			}else{
				ap.setAllqueqinn(allqueqinn+"");
			}
			if(allipinfo==0){
				ap.setAllipinfo("-");
			}else{
				ap.setAllipinfo(allipinfo+"");
			}
		}else{
			ap.setAllqueqinn("-");
			ap.setAllzaotuin("-");
			ap.setAllweiqiantuin("-");
			ap.setAllchiweituin("-");
			ap.setAllchidaon("-");
			ap.setAllchituin("-");
			ap.setAllipinfo("-");
		}
		request.setAttribute("alinfostatic", al);
		request.setAttribute("sectioninfo", section);
		request.setAttribute("apinfos", ap);
		return "success";
	}
	
	/**
	 * 通过条件查询出考勤统计的信息
	 * @throws Exception
	 */
	public void findthisstatsticsbyinfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONArray jsonattenstatic = new JSONArray();
		ArrayList<AttenStaticPage> astp = new ArrayList<AttenStaticPage>();
		//查询出所有分组
		List<Section> section = systemsetService.findsectioninfo();
		JSONArray jsonsection = new JSONArray();
		if(section != null && section.size()>0){
			for(int i = 0;i<section.size();i++){
				jsonsection.add(i, section.get(i));
			}
		}
		//获取当前年月 ,日期
		String nownianyuetime = DateUtil.getYear()+"年"+DateUtil.getMonth()+"月";
		//获取需查询的年月
		String nianyuetime = yearname+monthname;
		if((nownianyuetime).equals(nianyuetime)){
			//查询的是当前时间
			//计算当月到今天有几天
			allmonthnum = DateUtil.getMonthtoToday();
			//计算当月有几天不用考勤
			Nokaoqin = DateUtil.getweeknum(nianyuetime, "星期六", allmonthnum);
		}else{
			//查询的不是目前当月时间
			//需要先查询出  nianyuetime 该月有多少上班的天数
			//计算当月有多少天
			allmonthnum = Integer.parseInt(DateUtil.getMonthNum(nianyuetime));
			//计算当月有几天不用考勤
			Nokaoqin = DateUtil.getweeknum(nianyuetime, "星期六",allmonthnum);
		}
		
		//查询出所有启用人员信息
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		AllstatePage ap = new AllstatePage();
		if(msi != null && msi.size() > 0){
			for(int i=0;i<msi.size();i++){
				MembershipInfo m = msi.get(i);
				
				AttenStaticPage asp = new AttenStaticPage();
				//根据当前日期和成员id查询出当月考勤信息
				List<Attendance> at1 = attendanceService.findatteninfoBym_idnianyuetime(m.getM_id(),nianyuetime);
				if(sectionname.equals("全部")){				
					asp.setUsername(m.getM_truename());
					asp.setSectionname(m.getM_sectionname());
					if(at1 != null && at1.size() > 0){
						for(int j=0;j<at1.size();j++){
							Attendance a1 = at1.get(j);
							if(("迟到").equals(a1.getA_state())){
								allchidaon++;
								chidaon++;
							}else if(("早退").equals(a1.getA_state())){
								allzaotuin++;
								zaotuin++;
							}else if(("未签退").equals(a1.getA_state())){
								allweiqiantuin++;
								weiqiantuin++;
							}else if(("迟到，早退").equals(a1.getA_state())){
								allchituin++;
								chituin++;
							}else if(("迟到，未签退").equals(a1.getA_state())){
								allchiweituin++;
								chiweituin++;
							}
							if(("IP异常").equals(a1.getIpstate())){
								allipinfo++;
								ipinfo++;
							}
						}
						//计算当月缺勤数
						queqinn = allmonthnum - Nokaoqin - at1.size();
						allqueqinn = allqueqinn + queqinn;
						if(chidaon==0){
							asp.setChidaon("-");
						}else{
							asp.setChidaon(chidaon+"");
						}
						if(queqinn==0){
							asp.setQueqinn("-");
						}else{
							asp.setQueqinn(queqinn+"");
						}
						if(chituin==0){
							asp.setChituin("-");
						}else{
							asp.setChituin(chituin+"");
						}
						if(chiweituin==0){
							asp.setChiweituin("-");
						}else{
							asp.setChiweituin(chiweituin+"");
						}
						if(weiqiantuin==0){
							asp.setWeiqiantuin("-");
						}else{
							asp.setWeiqiantuin(weiqiantuin+"");
						}
						if(zaotuin==0){
							asp.setZaotuin("-");
						}else{
							asp.setZaotuin(zaotuin+"");
						}
						if(ipinfo==0){
							asp.setIpinfo("-");
						}else{
							asp.setIpinfo(ipinfo+"");
						}
						asp.setShijichuqin(at1.size()+"");
					}else{
						//计算当月缺勤数
						queqinn = allmonthnum - Nokaoqin;
						allqueqinn = allqueqinn + queqinn;
						asp.setChidaon("-");
						asp.setChituin("-");
						asp.setChiweituin("-");
						asp.setWeiqiantuin("-");
						asp.setQueqinn(queqinn+"");
						asp.setZaotuin("-");
						asp.setShijichuqin("-");
						asp.setIpinfo("-");
					}
					astp.add(asp);
				}else if(m.getM_sectionname().equals(sectionname)){
					asp.setUsername(m.getM_truename());
					asp.setSectionname(m.getM_sectionname());
					if(at1 != null && at1.size() > 0){
						for(int j=0;j<at1.size();j++){
							Attendance a1 = at1.get(j);
							if(("迟到").equals(a1.getA_state())){
								allchidaon++;
								chidaon++;
							}else if(("早退").equals(a1.getA_state())){
								allzaotuin++;
								zaotuin++;
							}else if(("未签退").equals(a1.getA_state())){
								allweiqiantuin++;
								weiqiantuin++;
							}else if(("迟到，早退").equals(a1.getA_state())){
								allchituin++;
								chituin++;
							}else if(("迟到，未签退").equals(a1.getA_state())){
								allchiweituin++;
								chiweituin++;
							}
							if(("IP异常").equals(a1.getIpstate())){
								allipinfo++;
								ipinfo++;
							}
						}
						//计算当月缺勤数
						queqinn = allmonthnum - Nokaoqin - at1.size();
						allqueqinn = allqueqinn + queqinn;
						if(chidaon==0){
							asp.setChidaon("-");
						}else{
							asp.setChidaon(chidaon+"");
						}
						if(queqinn==0){
							asp.setQueqinn("-");
						}else{
							asp.setQueqinn(queqinn+"");
						}
						if(chituin==0){
							asp.setChituin("-");
						}else{
							asp.setChituin(chituin+"");
						}
						if(chiweituin==0){
							asp.setChiweituin("-");
						}else{
							asp.setChiweituin(chiweituin+"");
						}
						if(weiqiantuin==0){
							asp.setWeiqiantuin("-");
						}else{
							asp.setWeiqiantuin(weiqiantuin+"");
						}
						if(zaotuin==0){
							asp.setZaotuin("-");
						}else{
							asp.setZaotuin(zaotuin+"");
						}
						if(ipinfo==0){
							asp.setIpinfo("-");
						}else{
							asp.setIpinfo(ipinfo+"");
						}
						asp.setShijichuqin(at1.size()+"");
					}else{
						//计算当月缺勤数
						queqinn = allmonthnum - Nokaoqin;
						allqueqinn = allqueqinn + queqinn;
						asp.setChidaon("-");
						asp.setChituin("-");
						asp.setChiweituin("-");
						asp.setWeiqiantuin("-");
						asp.setQueqinn(queqinn+"");
						asp.setZaotuin("-");
						asp.setShijichuqin("-");
						asp.setIpinfo("-");
					}
					astp.add(asp);
				}
				chidaon = 0;
				zaotuin = 0;
				weiqiantuin = 0;
				chituin = 0;
				chiweituin = 0;
				queqinn = 0;
				ipinfo = 0;
			}
			for(int k = 0;k<astp.size();k++){
				AttenStaticPage aaa = astp.get(k);
				jsonattenstatic.add(k,aaa);
			}
			if(allchidaon==0){
				ap.setAllchidaon("-");
			}else{
				ap.setAllchidaon(allchidaon+"");
			}
			if(allchituin==0){
				ap.setAllchituin("-");
			}else{
				ap.setAllchituin(allchituin+"");
			}
			if(allchiweituin==0){
				ap.setAllchiweituin("-");
			}else{
				ap.setAllchiweituin(allchiweituin+"");
			}
			if(allweiqiantuin==0){
				ap.setAllweiqiantuin("-");
			}else{
				ap.setAllweiqiantuin(allweiqiantuin+"");
			}
			if(allzaotuin==0){
				ap.setAllzaotuin("-");
			}else{
				ap.setAllzaotuin(allzaotuin+"");
			}
			if(allqueqinn==0){
				ap.setAllqueqinn("-");
			}else{
				ap.setAllqueqinn(allqueqinn+"");
			}
			if(allipinfo==0){
				ap.setAllipinfo("-");
			}else{
				ap.setAllipinfo(allipinfo+"");
			}
		}else{
			ap.setAllqueqinn("-");
			ap.setAllzaotuin("-");
			ap.setAllweiqiantuin("-");
			ap.setAllchiweituin("-");
			ap.setAllchidaon("-");
			ap.setAllchituin("-");
			ap.setAllipinfo("-");
		}
		JSONArray jsonap = new JSONArray();
		jsonap.add(0,ap);
		JSONObject json = new JSONObject();
		json.put("jsonattenstatic", jsonattenstatic);
		json.put("jsonap", jsonap);
		json.put("jsonsection", jsonsection);
		json.put("sectionname", sectionname);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询出所有的考勤统计导出表
	 * @throws Exception
	 * @author yangzijia
	 */
	public String findallattenexport() throws Exception {
		request = ServletActionContext.getRequest();
		List<AttendanceChart> adc = attendanceService.findallattenexport();
		List<Section> sectionname = systemsetService.findsectioninfo();
		request.setAttribute("attendanceChart", adc);
		request.setAttribute("sectionname", sectionname);
		return "success";
	}
	
	/**
	 * 从ArrayList表中导入到Excel表的方法
	 * @param <T>
	 */
	public boolean exportexcelmethod(){
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		String execlname = "创新实验室自学管理平台";
		if(!sectionname.equals("全部")){
			execlname = execlname +"_"+sectionname;
		}
		try {
			//声明一个工作薄
			HSSFWorkbook workBook = new HSSFWorkbook(); // 创建 一个excel文档对象
			
			//*********************************
			//样式的设定
			//*********************************
			//表头的样式
			HSSFCellStyle style = workBook.createCellStyle(); // 创建样式对象
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //center
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			HSSFFont font = workBook.createFont();// 创建字体对象
			font.setFontHeightInPoints((short) 12);
			font.setFontName("黑体");// 设置字体
			style.setFont(font);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			
			//标题的样式
			HSSFCellStyle titleStyle = workBook.createCellStyle();// 创建表头样式对象
			titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
			titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			HSSFFont titleFont = workBook.createFont();// 创建表头字体对象
			titleFont.setFontHeightInPoints((short) 25);
			titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
			titleFont.setFontName("黑体");// 设置字体
			titleStyle.setFont(titleFont);
			
			// 设置表单中字体样式
			HSSFCellStyle tableStyle = workBook.createCellStyle();
			tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
			tableStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			HSSFFont tableFont = workBook.createFont();// 创建表格字体对象
			tableFont.setFontHeightInPoints((short) 11);
			tableFont.setFontName("宋体");// 设置字体
			tableStyle.setFont(tableFont);
			tableStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			tableStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			tableStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			tableStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			
			// 设置时间样式
			HSSFCellStyle timeStyle = workBook.createCellStyle();
			timeStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
			timeStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			timeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			timeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
			timeStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			HSSFFont timeFont = workBook.createFont();// 创建表格字体对象
			timeFont.setFontHeightInPoints((short) 9);
			timeFont.setFontName("SansSerif");// 设置字体
			timeStyle.setFont(timeFont);
			
			//判断这个工作缚里有几个表
			//考勤统计表
			if(tongji){
				execlname = execlname+"_考勤统计表";
				ArrayList<AttenStaticPage> altongji1 = findAndreturnkaoqintongjibiao();
				//声明考勤统计表
				HSSFSheet sheet1 = workBook.createSheet("考勤统计表");
				HSSFCell cell1 = null; // 声明单元格对象 
				//设置列宽    2列
				sheet1.setColumnWidth(0, 3000);
				sheet1.setColumnWidth(1, 3000);
				sheet1.setColumnWidth(2, 3000);
				sheet1.setColumnWidth(3, 3000);
				sheet1.setColumnWidth(4, 5000);
				sheet1.setColumnWidth(5, 3000);
				sheet1.setColumnWidth(6, 3000);
				sheet1.setColumnWidth(7, 3000);
				sheet1.setColumnWidth(8, 3000);
				sheet1.setColumnWidth(9, 5000);
				sheet1.setColumnWidth(10, 5000);
				sheet1.setColumnWidth(11, 4000);
				sheet1.setColumnWidth(12, 3000);
				
				//合并单元格
				sheet1.addMergedRegion(new Region((short)0,(short)0,(short)0,(short)11));
				sheet1.addMergedRegion(new Region((short)1,(short)0,(short)1,(short)11));
				//标题的设定
				HSSFRow row1 = sheet1.createRow(0);
				row1.setHeightInPoints(35);
				cell1 = row1.createCell(0);
				cell1.setCellStyle(titleStyle);
				cell1.setCellValue("考勤统计表");
				
				HSSFRow row = sheet1.createRow(1);
				row.setHeightInPoints(20);
				cell1 = row.createCell(0);
				cell1.setCellStyle(timeStyle);
				cell1.setCellValue(time1+"~"+time2);
				
				// 生成表头
				String[] bt = new String[] { "序号", "姓名", "分组", "应出勤/天", "实际出勤/天", "正常/天", "迟到/天", "早退/天", "未签退/天", "迟到，早退/天", "迟到，未签退/天", "IP异常/天", "缺勤/天"};
				HSSFRow tableRow = sheet1.createRow(2); // 创建一个行对象
				tableRow.setHeightInPoints(25);
				for (int i = 0; i < bt.length; i++) {
					cell1 = tableRow.createCell(i);
					cell1.setCellStyle(style);
					cell1.setCellValue(new HSSFRichTextString(bt[i]));
				}
				
				// 写入表格内容
				for (int i = 0; i < altongji1.size(); i++) {
					tableRow = sheet1.createRow(i + 3); // 创建一个行对象
					tableRow.setHeightInPoints(20);
					AttenStaticPage a1 = altongji1.get(i);
					
					cell1 = tableRow.createCell(0);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getId().toString()));
					
					cell1 = tableRow.createCell(1);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getUsername().toString()));
					
					cell1 = tableRow.createCell(2);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getSectionname().toString()));
					
					cell1 = tableRow.createCell(3);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getYingchuqin().toString()));
					
					cell1 = tableRow.createCell(4);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getShijichuqin().toString()));
					
					cell1 = tableRow.createCell(5);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getZhengchangn().toString()));
					
					cell1 = tableRow.createCell(6);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getChidaon().toString()));
					
					cell1 = tableRow.createCell(7);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getZaotuin().toString()));
					
					cell1 = tableRow.createCell(8);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getWeiqiantuin().toString()));
					
					cell1 = tableRow.createCell(9);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getChituin().toString()));
					
					cell1 = tableRow.createCell(10);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getChiweituin().toString()));
					
					cell1 = tableRow.createCell(11);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getIpinfo().toString()));
					
					cell1 = tableRow.createCell(12);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getQueqinn().toString()));
				}
			}
			//考勤记录表
			if(jilu){
				execlname = execlname+"_考勤记录表";
				ArrayList<Kaoqinjilubiao> jilu1 = findAndreturnkaoqinjilubiao();
				//声明考勤统计表
				HSSFSheet sheet1 = workBook.createSheet("考勤记录表");
				HSSFCell cell1 = null; // 声明单元格对象 
				//设置列宽    2列
				sheet1.setColumnWidth(0, 4000);
				sheet1.setColumnWidth(1, 4000);
				sheet1.setColumnWidth(2, 4000);
				sheet1.setColumnWidth(3, 4000);
				sheet1.setColumnWidth(4, 5000);
				sheet1.setColumnWidth(5, 4000);
				sheet1.setColumnWidth(6, 4000);
				sheet1.setColumnWidth(7, 4000);
				sheet1.setColumnWidth(8, 8000);
				
				sheet1.setColumnWidth(9, 4000);
				sheet1.setColumnWidth(10, 5000);
				
				//合并单元格
				sheet1.addMergedRegion(new Region((short)0,(short)0,(short)0,(short)9));
				sheet1.addMergedRegion(new Region((short)1,(short)0,(short)1,(short)9));
				//标题的设定
				HSSFRow row1 = sheet1.createRow(0);
				row1.setHeightInPoints(35);
				cell1 = row1.createCell(0);
				cell1.setCellStyle(titleStyle);
				cell1.setCellValue("考勤记录表");
				
				HSSFRow row = sheet1.createRow(1);
				row.setHeightInPoints(20);
				cell1 = row.createCell(0);
				cell1.setCellStyle(timeStyle);
				cell1.setCellValue(time1+"~"+time2);
				
				// 生成表头
				String[] bt = new String[] { "序号", "分组", "姓名", "日期", "默认班次", "星期", "签到时间", "签退时间" , "IP状态", "状态", "学习时长"};
				HSSFRow tableRow = sheet1.createRow(2); // 创建一个行对象
				tableRow.setHeightInPoints(25);
				for (int i = 0; i < bt.length; i++) {
					cell1 = tableRow.createCell(i);
					cell1.setCellStyle(style);
					cell1.setCellValue(new HSSFRichTextString(bt[i]));
				}
				
				// 写入表格内容
				for (int i = 0; i < jilu1.size(); i++) {
					tableRow = sheet1.createRow(i + 3); // 创建一个行对象
					tableRow.setHeightInPoints(20);
					Kaoqinjilubiao a1 = jilu1.get(i);
					
					cell1 = tableRow.createCell(0);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getId().toString()));
					
					cell1 = tableRow.createCell(1);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getSectionname().toString()));
					
					cell1 = tableRow.createCell(2);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getUsername().toString()));
					
					cell1 = tableRow.createCell(3);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getDatetime().toString()));
					
					cell1 = tableRow.createCell(4);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getMorenbanci().toString()));
					
					cell1 = tableRow.createCell(5);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getWeek().toString()));
					
					cell1 = tableRow.createCell(6);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getCheckintime().toString()));
					
					cell1 = tableRow.createCell(7);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getCheckoutime().toString()));
					
					cell1 = tableRow.createCell(8);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getIpinfo().toString()));
					
					cell1 = tableRow.createCell(9);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getState().toString()));
					
					cell1 = tableRow.createCell(10);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getShichang().toString()));
				}
			}
			//考勤审核表
			if(shenhe){
				execlname = execlname+"_考勤审核表";
				ArrayList<Kaoqinshenhebiao> shenhe1 = findAndreturnkaoqinshenhebiao();
				//声明考勤统计表
				HSSFSheet sheet1 = workBook.createSheet("考勤审核表");
				HSSFCell cell1 = null; // 声明单元格对象 
				//设置列宽    2列
				sheet1.setColumnWidth(0, 4000);
				sheet1.setColumnWidth(1, 4000);
				sheet1.setColumnWidth(2, 4000);
				sheet1.setColumnWidth(3, 4000);
				sheet1.setColumnWidth(4, 4000);
				sheet1.setColumnWidth(5, 5000);
				sheet1.setColumnWidth(6, 4000);
				sheet1.setColumnWidth(7, 4000);
				sheet1.setColumnWidth(8, 4000);
				sheet1.setColumnWidth(9, 4000);
				
				//合并单元格
				sheet1.addMergedRegion(new Region((short)0,(short)0,(short)0,(short)9));
				sheet1.addMergedRegion(new Region((short)1,(short)0,(short)1,(short)9));
				//标题的设定
				HSSFRow row1 = sheet1.createRow(0);
				row1.setHeightInPoints(35);
				cell1 = row1.createCell(0);
				cell1.setCellStyle(titleStyle);
				cell1.setCellValue("考勤审核表");
				
				HSSFRow row = sheet1.createRow(1);
				row.setHeightInPoints(20);
				cell1 = row.createCell(0);
				cell1.setCellStyle(timeStyle);
				cell1.setCellValue(time1+"~"+time2);
				
				// 生成表头
				String[] bt = new String[] { "序号", "姓名", "分组", "日期", "星期", "默认班次", "实际签到/签退时间", "申诉理由", "处理结果", "处理人"};
				HSSFRow tableRow = sheet1.createRow(2); // 创建一个行对象
				tableRow.setHeightInPoints(25);
				for (int i = 0; i < bt.length; i++) {
					cell1 = tableRow.createCell(i);
					cell1.setCellStyle(style);
					cell1.setCellValue(new HSSFRichTextString(bt[i]));
				}
				
				// 写入表格内容
				for (int i = 0; i < shenhe1.size(); i++) {
					tableRow = sheet1.createRow(i + 3); // 创建一个行对象
					tableRow.setHeightInPoints(20);
					Kaoqinshenhebiao a1 = shenhe1.get(i);
					
					cell1 = tableRow.createCell(0);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getId().toString()));
					
					cell1 = tableRow.createCell(1);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getUsername().toString()));
					
					cell1 = tableRow.createCell(2);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getSectionname().toString()));
					
					cell1 = tableRow.createCell(3);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getDatetime().toString()));
					
					cell1 = tableRow.createCell(4);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getWeek().toString()));
					
					cell1 = tableRow.createCell(5);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getMorenbanci().toString()));
					
					cell1 = tableRow.createCell(6);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getCheckinoutime().toString()));
					
					cell1 = tableRow.createCell(7);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getRemark().toString()));
					
					cell1 = tableRow.createCell(8);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getState().toString()));
					
					cell1 = tableRow.createCell(9);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getChuliren().toString()));
				}
			}
			//将导出的excel表信息存入数据库中
			AttendanceChart adc = new AttendanceChart();
			adc.setFilename(execlname+time1+"~"+time2+".xls");
			adc.setTime(DateUtil.getNowStrDate());
			adc.setExportman(memberinfo.getM_truename());
			//add到数据库中AttendanceChart
			attendanceService.addAttendanceChart(adc);
			//保存excel表到 D:/IISMP/AttendanceChart/**.xls 下
			FileOutputStream fileOut = new FileOutputStream("D:/IISMP/AttendanceChart/"+execlname+time1+"~"+time2+".xls");
			workBook.write(fileOut);
			fileOut.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 提交并导出考勤统计的表格
	 * 导出到 D:/IISMP/AttendanceChart/**.xls
	 * @author yangzijia
	 */
	public void tijiaodaochuxinxi() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean beforeisExist = false;
		boolean isexport = false;
		String excelname = "创新实验室自学管理平台";
		//检验以前是否导出过
		if(!sectionname.equals("全部")){
			excelname = excelname +"_"+sectionname;
		}
		if(tongji){
			excelname = excelname+"_考勤统计表";
		}
		if(jilu){
			excelname = excelname+"_考勤记录表";
		}
		if(shenhe){
			excelname = excelname+"_考勤审核表";
		}
		excelname = excelname+time1+"~"+time2+".xls";
		//根据time1+"~"+time2查询导出表
		List<AttendanceChart> adc1 = attendanceService.findallattenexportByfilename(excelname);
		if(adc1!=null && adc1.size()>0){
			beforeisExist = true;
		}else{
			if(exportexcelmethod()){
				isexport = true;
			}
		}
		JSONObject json = new JSONObject();
		json.put("beforeisExist", beforeisExist);
		json.put("isexport", isexport);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询出考勤审核表并封装到ArrayList中
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Kaoqinshenhebiao> findAndreturnkaoqinshenhebiao() throws Exception{
		ArrayList<Kaoqinshenhebiao> al = new ArrayList<Kaoqinshenhebiao>();
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		//查询出time1 到time2 的考勤信息
		List<Attendance_unusual> attu = attendanceService.findAllatten_unusualt1Tot2(time1,time2);
		if(attu != null && attu.size() > 0){
			for(int i=0;i<attu.size();i++){
				Attendance_unusual au = attu.get(i);
				//根据m_id查找出该用户信息
				MembershipInfo ms = systemsetService.findmemberinfoByid(au.getApplyuser_id());
				if(ms.getM_sectionname().equals(sectionname)){
					Kaoqinshenhebiao ks = new Kaoqinshenhebiao();
					ks.setId((i+1)+"");
					ks.setCheckinoutime(au.getCheck_in_out_time());
					String chuliren = "未处理";
					if(au.getOperator_id()!=0){
						//根据用户id查询出用户信息
						MembershipInfo msi = systemsetService.findmemberinfoByid(au.getOperator_id());
						chuliren = msi.getM_truename();
					}
					ks.setChuliren(chuliren);
					ks.setDatetime(au.getDatetime());
					ks.setMorenbanci(check_in+"~"+check_out);
					ks.setRemark(au.getRemark());
					ks.setState(au.getAfterstate());
					MembershipInfo msi1 = systemsetService.findmemberinfoByid(au.getApplyuser_id());
					ks.setSectionname(msi1.getM_sectionname());
					ks.setUsername(msi1.getM_truename());
					ks.setWeek(au.getAtten_week());
					al.add(ks);
				}else if(sectionname.equals("全部")){
					Kaoqinshenhebiao ks = new Kaoqinshenhebiao();
					ks.setId((i+1)+"");
					ks.setCheckinoutime(au.getCheck_in_out_time());
					//ks.setChuliremark(chuliremark)
					String chuliren = "未处理";
					if(au.getOperator_id()!=0){
						//根据用户id查询出用户信息
						MembershipInfo msi = systemsetService.findmemberinfoByid(au.getOperator_id());
						chuliren = msi.getM_truename();
					}
					ks.setChuliren(chuliren);
					ks.setDatetime(au.getDatetime());
					ks.setMorenbanci(au.getAttendanceshift());
					ks.setRemark(au.getRemark());
					ks.setState(au.getAfterstate());
					MembershipInfo msi1 = systemsetService.findmemberinfoByid(au.getApplyuser_id());
					ks.setUsername(msi1.getM_truename());
					ks.setSectionname(msi1.getM_sectionname());
					ks.setWeek(au.getAtten_week());
					al.add(ks);
				}
				
			}
		}
		return al;
	}
	
	/**
	 * 查询出考勤记录表并封装到ArrayList中
	 * @throws ParseException 
	 */
	public ArrayList<Kaoqinjilubiao> findAndreturnkaoqinjilubiao() throws ParseException{
		List<Shift> ssinfo = attendanceService.findshiftInfo();
		Shift ss = ssinfo.get(0);
		String check_in = ss.getCheck_in_time_hour()+":"+ss.getCheck_in_time_minute();
		String check_out = ss.getCheck_out_time_hour()+":"+ss.getCheck_out_time_minute();
		ArrayList<Kaoqinjilubiao> al = new ArrayList<Kaoqinjilubiao>();
		//查询出time1到time2的考勤信息
		List<Attendance> atten = attendanceService.findAllattendance(time1,time2);
		if(atten != null && atten.size() > 0){
			for(int i=0;i<atten.size();i++){
				Attendance a = atten.get(i);
				//根据m_id查找出该用户信息
				MembershipInfo msi = systemsetService.findmemberinfoByid(a.getM_id());
				if(msi.getM_sectionname().equals(sectionname)){
					Kaoqinjilubiao kq = new Kaoqinjilubiao();
					kq.setId((i+1)+"");
					//根据用户id查询出用户信息
					kq.setUsername(msi.getM_truename());
					kq.setSectionname(msi.getM_sectionname());
					kq.setCheckintime(a.getA_check_in_time());
					if(a.getA_check_out_time()==null){
						kq.setCheckoutime("-");
					}else{
						kq.setCheckoutime(a.getA_check_out_time());
					}
					kq.setIpinfo(a.getIpstate()+"："+a.getIpaddr_in());
					kq.setDatetime(a.getA_datetime());
					if(a.getShiftsection()!=null && a.getShiftsection().length()>0){
						kq.setMorenbanci(a.getShiftsection());
					}else{
						kq.setMorenbanci(check_in+"~"+check_out);
					}
					if(a.getA_state().equals("正常")){
						kq.setShichang(a.getTime_difference()+"小时");
					}else{
						kq.setShichang("-");
					}
					kq.setState(a.getA_state());
					kq.setWeek(DateUtil.getWeekDay(a.getA_datetime()));
					al.add(kq);
				}else if(sectionname.equals("全部")){
					Kaoqinjilubiao kq = new Kaoqinjilubiao();
					kq.setId((i+1)+"");
					//根据用户id查询出用户信息
					kq.setUsername(msi.getM_truename());
					kq.setSectionname(msi.getM_sectionname());
					kq.setCheckintime(a.getA_check_in_time());
					if(a.getA_check_out_time()==null){
						kq.setCheckoutime("-");
					}else{
						kq.setCheckoutime(a.getA_check_out_time());
					}
					kq.setDatetime(a.getA_datetime());
					if(a.getShiftsection()!=null && a.getShiftsection().length()>0){
						kq.setMorenbanci(a.getShiftsection());
					}else{
						kq.setMorenbanci(check_in+"~"+check_out);
					}
					if(a.getA_state().equals("正常")){
						kq.setShichang(a.getTime_difference()+"小时");
					}else{
						kq.setShichang("-");
					}
					if(a.getIpstate() !=null && a.getIpstate() != "" && a.getIpaddr_in() != null && a.getIpinfo_in() != ""){
						kq.setIpinfo(a.getIpstate()+"："+a.getIpaddr_in());
					}else{
						kq.setIpinfo("-");
					}
					kq.setState(a.getA_state());
					kq.setWeek(DateUtil.getWeekDay(a.getA_datetime()));
					al.add(kq);
				}
			}
		}
		return al;
	}
	
	/**
	 * 查询出考勤统计表里的信息并封装到ArrayList中
	 * @return
	 */
	public ArrayList<AttenStaticPage> findAndreturnkaoqintongjibiao(){
		int zhengchang = 0;
		int yingchuqin = 0;
		ArrayList<AttenStaticPage> al = new ArrayList<AttenStaticPage>();
		//time1到time2的天数计算
		int differ = (int)DateUtil.getDays(time2,time1)+1;
		//计算time1到time2有几天不用考勤
		Nokaoqin = DateUtil.getTowNumweeknum(time1,time2, "星期六");
		//应出勤天数
		yingchuqin = differ-Nokaoqin;
		//查询出所有启用人员信息
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		if(msi != null && msi.size() > 0){
			for(int i=0;i<msi.size();i++){
				MembershipInfo m = msi.get(i);
				if(sectionname.equals("全部")){
					//根据成员id查询出time1到time2的考勤信息
					List<Attendance> at1 = attendanceService.findatteninfoByt1Tot2AndM_id(time1,time2,m.getM_id());
					AttenStaticPage asp = new AttenStaticPage();
					asp.setId((i+1)+"");
					asp.setUsername(m.getM_truename());
					asp.setSectionname(m.getM_sectionname());
					asp.setYingchuqin(yingchuqin+"");
					if(at1 != null && at1.size() > 0){
						for(int j=0;j<at1.size();j++){
							Attendance a1 = at1.get(j);
							if(("迟到").equals(a1.getA_state())){
								chidaon++;
							}else if(("早退").equals(a1.getA_state())){
								zaotuin++;
							}else if(("未签退").equals(a1.getA_state())){
								weiqiantuin++;
							}else if(("迟到，早退").equals(a1.getA_state())){
								chituin++;
							}else if(("迟到，未签退").equals(a1.getA_state())){
								chiweituin++;
							}else if(("正常").equals(a1.getA_state())){
								zhengchang++;
							}
							if(("IP异常").equals(a1.getIpstate())){
								ipinfo++;
							}
						}
						//计算time1到time2的缺勤数
						queqinn = yingchuqin - at1.size();
						if(zhengchang==0){
							asp.setZhengchangn("-");
						}else{
							asp.setZhengchangn(zhengchang+"");
						}
						if(chidaon==0){
							asp.setChidaon("-");
						}else{
							asp.setChidaon(chidaon+"");
						}
						if(queqinn==0){
							asp.setQueqinn("-");
						}else{
							asp.setQueqinn(queqinn+"");
						}
						if(chituin==0){
							asp.setChituin("-");
						}else{
							asp.setChituin(chituin+"");
						}
						if(chiweituin==0){
							asp.setChiweituin("-");
						}else{
							asp.setChiweituin(chiweituin+"");
						}
						if(weiqiantuin==0){
							asp.setWeiqiantuin("-");
						}else{
							asp.setWeiqiantuin(weiqiantuin+"");
						}
						if(zaotuin==0){
							asp.setZaotuin("-");
						}else{
							asp.setZaotuin(zaotuin+"");
						}
						if(ipinfo==0){
							asp.setIpinfo("-");
						}else{
							asp.setIpinfo(ipinfo+"");
						}
						asp.setShijichuqin(at1.size()+"");
					}else{
						//计算当月缺勤数
						queqinn = yingchuqin - Nokaoqin;
						asp.setZhengchangn("-");
						asp.setChidaon("-");
						asp.setChituin("-");
						asp.setChiweituin("-");
						asp.setWeiqiantuin("-");
						asp.setQueqinn(queqinn+"");
						asp.setZaotuin("-");
						asp.setShijichuqin("-");
						asp.setIpinfo("-");
					}
					al.add(asp);
				}else if(m.getM_sectionname().equals(sectionname)){
					//根据成员id查询出time1到time2的考勤信息
					List<Attendance> at1 = attendanceService.findatteninfoByt1Tot2AndM_id(time1,time2,m.getM_id());
					AttenStaticPage asp = new AttenStaticPage();
					asp.setId((i+1)+"");
					asp.setUsername(m.getM_truename());
					asp.setSectionname(m.getM_sectionname());
					asp.setYingchuqin(yingchuqin+"");
					if(at1 != null && at1.size() > 0){
						for(int j=0;j<at1.size();j++){
							Attendance a1 = at1.get(j);
							if(("迟到").equals(a1.getA_state())){
								chidaon++;
							}else if(("早退").equals(a1.getA_state())){
								zaotuin++;
							}else if(("未签退").equals(a1.getA_state())){
								weiqiantuin++;
							}else if(("迟到，早退").equals(a1.getA_state())){
								chituin++;
							}else if(("迟到，未签退").equals(a1.getA_state())){
								chiweituin++;
							}else if(("正常").equals(a1.getA_state())){
								zhengchang++;
							}
							if(("IP异常").equals(a1.getIpstate())){
								ipinfo++;
							}
						}
						//计算time1到time2的缺勤数
						queqinn = yingchuqin - at1.size();
						if(zhengchang==0){
							asp.setZhengchangn("-");
						}else{
							asp.setZhengchangn(zhengchang+"");
						}
						if(chidaon==0){
							asp.setChidaon("-");
						}else{
							asp.setChidaon(chidaon+"");
						}
						if(queqinn==0){
							asp.setQueqinn("-");
						}else{
							asp.setQueqinn(queqinn+"");
						}
						if(chituin==0){
							asp.setChituin("-");
						}else{
							asp.setChituin(chituin+"");
						}
						if(chiweituin==0){
							asp.setChiweituin("-");
						}else{
							asp.setChiweituin(chiweituin+"");
						}
						if(weiqiantuin==0){
							asp.setWeiqiantuin("-");
						}else{
							asp.setWeiqiantuin(weiqiantuin+"");
						}
						if(zaotuin==0){
							asp.setZaotuin("-");
						}else{
							asp.setZaotuin(zaotuin+"");
						}
						if(ipinfo==0){
							asp.setIpinfo("-");
						}else{
							asp.setIpinfo(ipinfo+"");
						}
						asp.setShijichuqin(at1.size()+"");
					}else{
						//计算当月缺勤数
						queqinn = yingchuqin - Nokaoqin;
						asp.setZhengchangn("-");
						asp.setChidaon("-");
						asp.setChituin("-");
						asp.setChiweituin("-");
						asp.setWeiqiantuin("-");
						asp.setQueqinn(queqinn+"");
						asp.setZaotuin("-");
						asp.setShijichuqin("-");
						asp.setIpinfo("-");
					}
					al.add(asp);
				}
				chidaon = 0;
				zaotuin = 0;
				weiqiantuin = 0;
				chituin = 0;
				chiweituin = 0;
				queqinn = 0;
				ipinfo = 0;
				zhengchang = 0;
 			}
		}
		return al;
	}
	
	/**
	 * 删除D:/IISMP/AttendanceChart/**.xls路径下的excel文件
	 * @param sPath
	 * @return
	 */
	public void deleteAttendanceChartFile(String sPath) {  
		//处理文件路径,将"/"替换成计算机识别的"\\"  
		//sPath =sPath.replace("/",File.separator);  
		File file = new File(sPath);  
		// 路径为文件且不为空则进行删除  
		if (file.isFile() && file.exists()) { 
			file.delete();  
		}  
	} 
	
	/**
	 * 根据id删除export中的数据
	 * @throws Exception
	 */
	public void deletethisexportchart() throws Exception {
		//根据id查找该条导出表数据
		List<AttendanceChart> acc = attendanceService.findattendancechartByid(a_id);
		AttendanceChart ac = acc.get(0);
		ac.setId(a_id);
		attendanceService.deletethisexportchart(ac);
		String sPath = "D:\\IISMP\\AttendanceChart\\"+ac.getFilename();
		deleteAttendanceChartFile(sPath);
	}
	
	/**
	 * AttendanceChart路径下的文件下载
	 * @throws Exception
	 */
	public void attendancefiledownload() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		 //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载  
		String sPath = "D:\\IISMP\\AttendanceChart\\"+filename;
  
        /*//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
        response.setContentType("multipart/form-data");  
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
        response.setHeader("Content-Disposition", "attachment;fileName="+"a.pdf");  
        ServletOutputStream out;  */
		ServletOutputStream out;
        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
        File file = new File(sPath);  
        try {  
            FileInputStream in = new FileInputStream(file);  
  
            //3.通过response获取ServletOutputStream对象(out)  
            out = response.getOutputStream();  
  
          /*  int b;  
            while((b=in.read())!= -1)  
            {  
                out.write(b);  
            } */
            
            int b = 0;  
            byte[] buffer = new byte[100*1024];  
            while (b != -1){  
                b = in.read(buffer);  
                //4.写到输出流(out)中  
                out.write(buffer,0,b);  
            }  
            in.close();  
            out.close();  
            out.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
	
	/**
	 * 查询班次的信息
	 * @throws Exception
	 * @author yangzijia
	 */
	public String findshiftinfo() throws Exception {
		request = ServletActionContext.getRequest();
		List<Shift> shiftinfo = attendanceService.findshiftInfo();
		if(shiftinfo!=null){
			Shift shift = shiftinfo.get(0);
			request.setAttribute("shiftinfo", shift);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 更改班次信息
	 * @author yangzijia
	 */
	public void updateShiftInfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Shift ss = new Shift();
		ss.setId(1);
		ss.setCheck_in_time_hour(check_in_hour);
		ss.setCheck_in_time_minute(check_in_minute);
		ss.setCheck_out_time_hour(check_out_hour);
		ss.setCheck_out_time_minute(check_out_minute);
		ss.setElas_time(elas_time);
		attendanceService.updateShiftInfo(ss);
		
		out.flush();
		out.close();
	}
	
	/**
	 * 查询出所有的默认IP的方法
	 */
	public String finddefaultIP() throws Exception {
		request = ServletActionContext.getRequest();
		List<DefaultIP> dip = attendanceService.findAllIp();
		request.setAttribute("dip", dip);
		return "success";
	}
	
	/**
	 * 添加IP的方法
	 */
	public void saveDefaultIP() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		DefaultIP dip = new DefaultIP();
		dip.setIpaddr(ipaddr);
		dip.setIpname(ipname);
		dip.setOperator(memberinfo.getM_truename());
		dip.setTime(DateUtil.getNowStrDate()+" "+DateUtil.getTimeHHmm());
		int id = attendanceService.saveDefaultIPAndreturnId(dip);
		JSONObject json = new JSONObject();
		json.put("ipaddr", ipaddr);
		json.put("ipname", ipname);
		json.put("operator", memberinfo.getM_truename());
		json.put("time", DateUtil.getNowStrDate()+" "+DateUtil.getTimeHHmm());
		json.put("id", id);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据id删除ip的方法
	 */
	public void deletethisipByid() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		DefaultIP dip = new DefaultIP();
		dip.setId(id);
		String sizenum = attendanceService.deletethisDefaultIPByidAndreturnsizeNum(dip);
		JSONObject json = new JSONObject();
		json.put("sizenum", sizenum);
		out.print(json);
		out.flush();
		out.close();
	}
}
