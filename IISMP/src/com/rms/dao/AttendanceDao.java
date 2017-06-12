package com.rms.dao;

import java.util.List;

import com.rms.model.Attendance;
import com.rms.model.AttendanceChart;
import com.rms.model.Attendance_unusual;
import com.rms.model.DefaultIP;
import com.rms.model.MembershipInfo;
import com.rms.model.Shift;

public interface AttendanceDao {
	
	/**
	 * 根据成员id查询该成员签到信息
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 * @param datetime 
	 * @data 2016-10-26
	 */
	public abstract List<Attendance> findAttendanceinfos(int m_id, String datetime);
	
	/**
	 * 添加签到信息
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public abstract void addcheckininfos(Attendance ad);

	/**
	 * 签退的方法  &&  更新考勤信息的方法
	 * @author yangzijia
	 * @param at
	 * @data 2016-10-27
	 */
	public abstract void updateAttendance(Attendance at);

	/**
	 * 根据成员id查询该成员所有的签到信息
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public abstract List<Attendance> findAllattendanceinfosBym_id(int m_id);

	/**
	 * 根据日期查找用户的考勤信息
	 * @param datepicker
	 * @return List<Attendance>
	 * @author yangzijia
	 * @param m_id 
	 * @data 2016-10-28
	 */
	public abstract List<Attendance> finduseratteninfo(int m_id, String datepicker);

	/**
	 * 加入到考勤异常数据库
	 * @param au
	 * @author yangzijia
	 * @date 2016-10-28
	 */
	public abstract void addatten_unusual(Attendance_unusual au);

	/**
	 * 查询成员申诉记录的方法
	 * @param state
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance_unusual> findmyappealmethod(int state, int m_id);

	/**
	 * 根据进科研室的时间查询出所有的用户
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public abstract List<MembershipInfo> findallmemberinfo();

	/**
	 * 根据当前时间查询出签到的人数
	 * @param datetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance> findcheckinNumBydatetime(String datetime);

	/**
	 * 查询出待处理申诉de信息
	 * @return  List<Attendance_unusual>
	 * @author yangzijia
	 */
	public abstract List<Attendance_unusual> findpendingappeal();

	/**
	 * 根据infos查询出所有的异常考勤
	 * @param infos
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 * @param state 
	 */
	public abstract List<Attendance_unusual> findallatten_unusualByinfos(
			String infos, String state);

	/**
	 * 根据id查找出该条异常的考勤信息
	 * @param a_id
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public abstract List<Attendance_unusual> findattenunusualByid(int a_id);

	/**
	 * 更新保存Attendance_unusual
	 * @param aa
	 * @author yangzijia
	 */
	public abstract void updateAttendance_unusual(Attendance_unusual aa);

	/**
	 * 查询出所有的异常考勤
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public abstract List<Attendance_unusual> findAllpendingappeal();

	/**
	 * 保存到Attendance
	 * @param a3
	 * @author yangzijia
	 */
	public abstract void addAttendance(Attendance a3);

	/**
	 * 查询出当前月的考勤情况并封装到AttenStaticPage类中
	 * @param nianyuetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance> findatteninfoBynianyuetime(
			String nianyuetime);

	/**
	 * 根据当前日期和成员id查询出当月考勤信息
	 * @param m_id
	 * @param nianyuetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance> findatteninfoBym_idnianyuetime(int m_id,
			String nianyuetime);

	/**
	 * 根据datetime查找考勤信息
	 * @param datetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance> findAttendanceinfosbydatetime(
			String datetime);

	/**
	 * 查询出所有的考勤统计导出表
	 * @throws Exception
	 * @author yangzijia
	 */
	public abstract List<AttendanceChart> findallattenexport();

	/**
	 * 根据成员id查询出time1到time2的考勤信息
	 * @param time1
	 * @param time2
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance> findatteninfoByt1Tot2AndM_id(String time1,
			String time2, int m_id);

	/**
	 * 查询出time1到time2的考勤信息
	 * @param time1
	 * @param time2
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public abstract List<Attendance> findAllattendance(String time1,
			String time2);

	/**
	 * 查询出time1 到time2 的考勤信息
	 * @param time1
	 * @param time2
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public abstract List<Attendance_unusual> findAllatten_unusualt1Tot2(
			String time1, String time2);

	/**
	 * add到数据库中AttendanceChart
	 * @param adc
	 * @author yangzijia
	 */
	public abstract void addAttendanceChart(AttendanceChart adc);

	/**
	 * 检验以前是否导出过
	 * 根据filename查询导出表
	 * @param string
	 * @return List<AttendanceChart>
	 * @author yangzijia
	 */
	public abstract List<AttendanceChart> findallattenexportByfilename(
			String filename);

	/**
	 * 删除export表的数据
	 * @param ac
	 * @author yangzijia
	 */
	public abstract void deletethisexportchart(AttendanceChart ac);

	/**
	 * 根据id查找该条导出表数据
	 * @param a_id
	 * @return List<AttendanceChart>
	 * @author yangzijia
	 */
	public abstract List<AttendanceChart> findattendancechartByid(int a_id);

	/**
	 * 查询班次的信息
	 * @throws Exception
	 * @author yangzijia
	 */
	public abstract List<Shift> findshiftInfo();

	/**
	 * 更改班次信息
	 * @author yangzijia
	 */
	public abstract void updateShiftInfo(Shift ss);

	/**
	 * 根据a_datetime查询申诉列表里是否存在当前信息（防止重复提交）
	 * @param a_datetime
	 * @param m_id 
	 * @return
	 */
	public abstract boolean isExistDate(String a_datetime, int m_id);

	/**
	 * 查询出所有的默认IP的方法
	 */
	public abstract List<DefaultIP> findAllIp();

	/**
	 * 保存ip到数据库的方法
	 * @param dip
	 */
	public abstract void saveDefaultIP(DefaultIP dip);

	/**
	 * 获取最后一次保存的ip的id
	 * @return
	 */
	public abstract int getDefaultIpBydesc();

	/**
	 * 删除ip的方法
	 * @param dip
	 */
	public abstract void deleteDefaultIPbyId(DefaultIP dip);
}