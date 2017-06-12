package com.rms.service.Impl;


import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.Attendance;
import com.rms.model.AttendanceChart;
import com.rms.model.Attendance_unusual;
import com.rms.model.DefaultIP;
import com.rms.model.MembershipInfo;
import com.rms.model.Shift;
import com.rms.service.AttendanceService;
import com.rms.service.BaseService;
@Component("attendanceService")
public class AttendanceServiceImpl extends BaseService implements AttendanceService{

	/**
	 * 根据成员id查询该成员签到信息
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public List<Attendance> findAttendanceinfos(int m_id, String datetime) {
		List<Attendance> atten = attendanceDao.findAttendanceinfos(m_id,datetime);
		if(atten != null){
			return atten;
		}
		return null;
	}

	/**
	 * 添加签到信息
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public void addcheckininfos(Attendance ad) {
		attendanceDao.addcheckininfos(ad);
	}

	/**
	 * 签退的方法  &&  更新考勤信息的方法
	 * @author yangzijia
	 * @param at
	 * @data 2016-10-27
	 */
	public void updateAttendance(Attendance at) {
		System.out.println("3455%");
		attendanceDao.updateAttendance(at);
	}

	/**
	 * 根据成员id查询该成员所有的签到信息
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public List<Attendance> findAllattendanceinfosBym_id(int m_id) {
		List<Attendance> atten = attendanceDao.findAllattendanceinfosBym_id(m_id);
		if(atten != null && atten.size() > 0){
			return atten;
		}
		return null;
	}

	/**
	 * 根据日期查找用户的考勤信息
	 * @param datepicker
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public List<Attendance> finduseratteninfo(int m_id,String datepicker) {
		List<Attendance> atten = attendanceDao.finduseratteninfo(m_id,datepicker);
		if(atten != null && atten.size() > 0){
			return atten;
		}
		return null;
	}

	/**
	 * 加入到考勤异常数据库
	 * @param au
	 * @author yangzijia
	 * @date 2016-10-28
	 */
	public void addatten_unusual(Attendance_unusual au) {
		attendanceDao.addatten_unusual(au);
	}

	/**
	 * 查询成员申诉记录的方法
	 * @param state
	 * @param m_id
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findmyappealmethod(int state, int m_id) {
		List<Attendance_unusual> atten = attendanceDao.findmyappealmethod(state,m_id);
		if(atten != null && atten.size() > 0){
			return atten;
		}
		return null;
	}

	/**
	 * 根据进科研室的时间查询出所有的用户
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public List<MembershipInfo> findallmemberinfo() {
		List<MembershipInfo> msi = attendanceDao.findallmemberinfo();
		if(msi != null && msi.size() > 0){
			return msi;
		}
		return null;
	}

	/**
	 * 根据当前时间查询出今天签到的人的信息
	 * @param datetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findAttendanceinfo(String datetime) {
		List<Attendance> atten = attendanceDao.findcheckinNumBydatetime(datetime);
		if(atten != null && atten.size() > 0){
			return atten;
		}
		return null;
	}

	/**
	 * 查询出待处理申诉信息的数量
	 * @return nums
	 * @author yangzijia
	 */
	public int findpendingappealNum() {
		List<Attendance_unusual> au = attendanceDao.findpendingappeal();
		if(au != null && au.size() > 0){
			return au.size();
		}
		return 0;
	}

	/**
	 * 查询出当月申请的所有的异常考勤
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findallatten_unusualinfo() {
		List<Attendance_unusual> au = attendanceDao.findAllpendingappeal();
		if(au != null && au.size() > 0){
			return au;
		}
		return null;
	}

	/**
	 * 根据infos查询出所有的异常考勤
	 * @param infos
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findallatten_unusualByinfos(String infos, String state) {
		List<Attendance_unusual> au = attendanceDao.findallatten_unusualByinfos(infos,state);
		if(au != null && au.size() > 0){
			return au;
		}
		return null;
	}

	/**
	 * 根据id查找出该条异常的考勤信息
	 * @param a_id
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findattenunusualByid(int a_id) {
		List<Attendance_unusual> au = attendanceDao.findattenunusualByid(a_id);
		if(au != null && au.size() > 0){
			return au;
		}
		return null;
	}

	/**
	 * 更新保存Attendance_unusual
	 * @param aa
	 * @author yangzijia
	 */
	public void updateAttendance_unusual(Attendance_unusual aa) {
		attendanceDao.updateAttendance_unusual(aa);
	}

	/**
	 * 查询出带出里的申诉信息
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findattendanceunusual1() {
		List<Attendance_unusual> au = attendanceDao.findpendingappeal();
		if(au != null && au.size() > 0){
			return au;
		}
		return null;
	}

	/**
	 * 保存到Attendance
	 * @param a3
	 * @author yangzijia
	 */
	public void addAttendance(Attendance a3) {
		attendanceDao.addAttendance(a3);
	}

	/**
	 * 查询出当前月的考勤情况并封装到AttenStaticPage类中
	 * @param nianyuetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findatteninfoBynianyuetime(String nianyuetime) {
		List<Attendance> atten = attendanceDao.findatteninfoBynianyuetime(nianyuetime);
		if(atten != null && atten.size() >0){
			return atten;
		}
		return null;
	}

	/**
	 * 根据当前日期和成员id查询出当月考勤信息
	 * @param m_id
	 * @param nianyuetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findatteninfoBym_idnianyuetime(int m_id,
			String nianyuetime) {
		List<Attendance> atten = attendanceDao.findatteninfoBym_idnianyuetime(m_id,nianyuetime);
		if(atten != null && atten.size() >0){
			return atten;
		}
		return null;
	}

	/**
	 * 根据datetime查找考勤信息
	 * @param datetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findAttendanceinfosbydatetime(String datetime) {
		List<Attendance> atten = attendanceDao.findAttendanceinfosbydatetime(datetime);
		if(atten != null && atten.size() >0){
			return atten;
		}
		return null;
	}

	/**
	 * 查询出所有的考勤统计导出表
	 * @throws Exception
	 * @author yangzijia
	 */
	public List<AttendanceChart> findallattenexport() {
		return this.attendanceDao.findallattenexport();
	}

	/**
	 * 根据成员id查询出time1到time2的考勤信息
	 * @param time1
	 * @param time2
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findatteninfoByt1Tot2AndM_id(String time1,
			String time2, int m_id) {
		return this.attendanceDao.findatteninfoByt1Tot2AndM_id(time1,time2,m_id);
	}

	/**
	 * 查询出time1到time2的考勤信息
	 * @param time1
	 * @param time2
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findAllattendance(String time1, String time2) {
		return this.attendanceDao.findAllattendance(time1,time2);
	}

	/**
	 * 查询出time1 到time2 的考勤信息
	 * @param time1
	 * @param time2
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findAllatten_unusualt1Tot2(String time1,
			String time2) {
		return this.attendanceDao.findAllatten_unusualt1Tot2(time1,time2);
	}

	/**
	 * add到数据库中AttendanceChart
	 * @param adc
	 * @author yangzijia
	 */
	public void addAttendanceChart(AttendanceChart adc) {
		this.attendanceDao.addAttendanceChart(adc);
	}

	/**
	 * 检验以前是否导出过
	 * 根据filename查询导出表
	 * @param string
	 * @return List<AttendanceChart>
	 * @author yangzijia
	 */
	public List<AttendanceChart> findallattenexportByfilename(String filename) {
		return this.attendanceDao.findallattenexportByfilename(filename);
	}

	/**
	 * 删除export表的数据
	 * @param ac
	 * @author yangzijia
	 */
	public void deletethisexportchart(AttendanceChart ac) {
		this.attendanceDao.deletethisexportchart(ac);
	}

	/**
	 * 根据id查找该条导出表数据
	 * @param a_id
	 * @return List<AttendanceChart>
	 * @author yangzijia
	 */
	public List<AttendanceChart> findattendancechartByid(int a_id) {
		return this.attendanceDao.findattendancechartByid(a_id);
	}

	/**
	 * 查询班次的信息
	 * @throws Exception
	 * @author yangzijia
	 */
	public List<Shift> findshiftInfo() {
		
		return this.attendanceDao.findshiftInfo();
	}

	/**
	 * 更改班次信息
	 * @author yangzijia
	 */
	public void updateShiftInfo(Shift ss) {
		attendanceDao.updateShiftInfo(ss);
	}

	/**
	 * 根据a_datetime查询申诉列表里是否存在当前信息（防止重复提交）
	 * @param a_datetime
	 * @return
	 */
	public boolean isExistDate(String a_datetime,int m_id) {
		if(attendanceDao.isExistDate(a_datetime,m_id)){
			return true;
		}
		return false;
	}

	/**
	 * 查询出所有的默认IP的方法
	 */
	public List<DefaultIP> findAllIp() {
		return attendanceDao.findAllIp();
	}

	/**
	 * 保存默认ip并返回id
	 * @param dip
	 * @return
	 */
	public int saveDefaultIPAndreturnId(DefaultIP dip) {
		attendanceDao.saveDefaultIP(dip);
		int id = attendanceDao.getDefaultIpBydesc();
		return id;
	}

	/**
	 * 根据id删除ip并返回删除后的数据库大小
	 * @param dip
	 * @return
	 */
	public String deletethisDefaultIPByidAndreturnsizeNum(DefaultIP dip) {
		attendanceDao.deleteDefaultIPbyId(dip);
		List<DefaultIP> d = attendanceDao.findAllIp();
		if(d!=null && d.size()>0){
			return "yes";
		}
		return "no";
	}

}
