package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rms.dao.AttendanceDao;
import com.rms.dao.BaseDao;
import com.rms.model.Attendance;
import com.rms.model.AttendanceChart;
import com.rms.model.Attendance_unusual;
import com.rms.model.DefaultIP;
import com.rms.model.MembershipInfo;
import com.rms.model.Shift;
import com.rms.util.DateUtil;


@Component("attendanceDao")
public class AttendanceDaoImpl extends BaseDao implements  AttendanceDao{
	
    public Session getSession() {    
        return sessionFactory.getCurrentSession();    
    }    

	/**
	 * 根据成员id查询该成员签到信息
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public List<Attendance> findAttendanceinfos(int m_id, String datetime) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate
				.find("from Attendance where m_id="+m_id+" and a_datetime='"+datetime+"'");
		return atten;
	}

	/**
	 * 添加签到信息
	 * @author yangzijia
	 * @data 2016-10-26
	 */
	public void addcheckininfos(Attendance ad) {
		hibernateTemplate.save(ad);
		
	}

	/**
	 * 签退的方法  &&  更新考勤信息的方法
	 * @author yangzijia
	 * @param at
	 * @data 2016-10-27
	 */
	public void updateAttendance(Attendance at) {
		hibernateTemplate.update(at);
	}

	/**
	 * 根据成员id查询该成员所有的签到信息
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public List<Attendance> findAllattendanceinfosBym_id(int m_id) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate.find("from Attendance where m_id='"+m_id+"'");
		return atten;
	}

	/**
	 * 根据日期查找用户的考勤信息
	 * @param datepicker
	 * @return List<Attendance>
	 * @author yangzijia
	 * @data 2016-10-28
	 */
	public List<Attendance> finduseratteninfo(int m_id,String datepicker) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate
				.find("from Attendance where m_id="+m_id+" and a_datetime='"+datepicker+"'");
		return atten;
	}

	/**
	 * 加入到考勤异常数据库
	 * @param au
	 * @author yangzijia
	 * @date 2016-10-28
	 */
	public void addatten_unusual(Attendance_unusual au) {
		hibernateTemplate.save(au);
	}

	/**
	 * 查询成员申诉记录的方法
	 * @param state
	 * @param m_id
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findmyappealmethod(int state, int m_id) {
		String nowtime = DateUtil.getStrDateyyyy_MM();
		String sql = "";
		if(state!=0){
			sql = "from Attendance_unusual where dtime LIKE '%"+ nowtime +"%' and applyuser_id="+m_id+" and state="+state+" order by timeinfo desc";
		} else{
			sql = "from Attendance_unusual where dtime LIKE '%"+ nowtime +"%' and applyuser_id="+m_id+" order by timeinfo desc";
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> atten =  query.list();
		session.close();
		return atten;
	}

	/**
	 * 根据进科研室的时间查询出所有的用户
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public List<MembershipInfo> findallmemberinfo() {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate.find("from MembershipInfo where m_state='启用'  order by role_num,m_entermiictime desc");
		return msi;
	}

	/**
	 * 根据当前时间查询出签到的人数
	 * @param datetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findcheckinNumBydatetime(String datetime) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate.find("from Attendance where a_datetime='"+datetime+"'");
		return atten;
	}

	/**
	 * 查询出待处理申诉de信息
	 * @return  List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findpendingappeal() {
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> au = hibernateTemplate.find("from Attendance_unusual where state=1 order by timeinfo desc");
		return au;
	}

	/**
	 * 根据infos查询出所有的异常考勤
	 * @param infos
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findallatten_unusualByinfos(String infos, String state) {
		String sql = "";
		if(state.equals("处理状态")){
			if(infos.equals("考勤信息")){
				sql = "from Attendance_unusual order by timeinfo desc";
			}else if(infos.equals("正常")){
				sql = "from Attendance_unusual where afterstate='正常' order by timeinfo desc";
			}else {
				sql = "from Attendance_unusual where beforestate='"+infos+"' order by timeinfo desc";
			}
		}else if(state.equals("未处理")){
			if(infos.equals("考勤信息")){
				sql = "from Attendance_unusual where state=1 order by timeinfo desc";
			}else if(infos.equals("正常")){
				sql = "from Attendance_unusual where state=1 and afterstate='正常' order by timeinfo desc";
			}else {
				sql = "from Attendance_unusual where state=1 and beforestate='"+infos+"' order by timeinfo desc";
			}
		}else if(state.equals("已处理")){
			if(infos.equals("考勤信息")){
				sql = "from Attendance_unusual where state=2 order by timeinfo desc";
			}else if(infos.equals("正常")){
				sql = "from Attendance_unusual where state=2 and afterstate='正常' order by timeinfo desc";
			}else {
				sql = "from Attendance_unusual where state=2 and beforestate='"+infos+"' order by timeinfo desc";
			}
		}
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> atten = hibernateTemplate.find(sql);
		return atten;
	}

	/**
	 * 根据id查找出该条异常的考勤信息
	 * @param a_id
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findattenunusualByid(int a_id) {
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> atten = hibernateTemplate.find("from Attendance_unusual where id="+a_id+"");
		return atten;
	}

	/**
	 * 更新保存Attendance_unusual
	 * @param aa
	 * @author yangzijia
	 */
	public void updateAttendance_unusual(Attendance_unusual aa) {
		hibernateTemplate.update(aa);
	}

	/**
	 * 查询出当月申请的所有的异常考勤
	 * @return List<Attendance_unusual>
	 * @author yangzijia
	 */
	public List<Attendance_unusual> findAllpendingappeal() {
		String nowtime = DateUtil.getStrDateyyyy_MM();
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> au = hibernateTemplate.find("from Attendance_unusual where dtime LIKE '%"+ nowtime +"%' order by timeinfo desc");
		return au;
	}

	/**
	 * 保存到Attendance
	 * @param a3
	 * @author yangzijia
	 */
	public void addAttendance(Attendance a3) {
		hibernateTemplate.save(a3);
	}

	/**
	 * 查询出当前月的考勤情况并封装到AttenStaticPage类中
	 * @param nianyuetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findatteninfoBynianyuetime(String nianyuetime) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate.
						find("from Attendance where a_nianyuetime='"+nianyuetime+"' order by a_id desc");
		return atten;
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
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate.
						find("from Attendance where a_nianyuetime='"+nianyuetime+"' and m_id="+m_id+" order by a_id desc");
		return atten;
	}

	/**
	 * 根据datetime查找考勤信息
	 * @param datetime
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findAttendanceinfosbydatetime(String datetime) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate.
						find("from Attendance where a_datetime='"+datetime+"'");
		return atten;
	}

	/**
	 * 查询出所有的考勤统计导出表
	 * @throws Exception
	 * @author yangzijia
	 */
	public List<AttendanceChart> findallattenexport() {
		@SuppressWarnings("unchecked")
		List<AttendanceChart> adc = hibernateTemplate.find("from AttendanceChart order by id desc");
		return adc;
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
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate
				.find("FROM Attendance WHERE a_datetime >= '"+time1+"' AND a_datetime <= '"+time2+"' AND m_id="+m_id+"");
		return atten;
	}

	/**
	 * 查询出time1到time2的考勤信息
	 * @param time1
	 * @param time2
	 * @return List<Attendance>
	 * @author yangzijia
	 */
	public List<Attendance> findAllattendance(String time1, String time2) {
		@SuppressWarnings("unchecked")
		List<Attendance> atten = hibernateTemplate
				.find("FROM Attendance WHERE a_datetime >= '"+time1+"' AND a_datetime <= '"+time2+"' order by a_id desc");
		return atten;
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
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> atten = hibernateTemplate
				.find("FROM Attendance_unusual WHERE datetime >= '"+time1+"' AND datetime <= '"+time2+"' order by id desc");
		return atten;
	}

	/**
	 * add到数据库中AttendanceChart
	 * @param adc
	 * @author yangzijia
	 */
	public void addAttendanceChart(AttendanceChart adc) {
		hibernateTemplate.save(adc);
	}

	/**
	 * 检验以前是否导出过
	 * 根据filename查询导出表
	 * @param string
	 * @return List<AttendanceChart>
	 * @author yangzijia
	 */
	public List<AttendanceChart> findallattenexportByfilename(String filename) {
		@SuppressWarnings("unchecked")
		List<AttendanceChart> adc = hibernateTemplate.find("from AttendanceChart where filename='"+filename+"'");
		return adc;
	}

	/**
	 * 删除export表的数据
	 * @param ac
	 * @author yangzijia
	 */
	public void deletethisexportchart(AttendanceChart ac) {
		hibernateTemplate.delete(ac);
	}

	/**
	 * 根据id查找该条导出表数据
	 * @param a_id
	 * @return List<AttendanceChart>
	 * @author yangzijia
	 */
	public List<AttendanceChart> findattendancechartByid(int a_id) {
		@SuppressWarnings("unchecked")
		List<AttendanceChart> adc = hibernateTemplate.find("from AttendanceChart where id='"+a_id+"'");
		return adc;
	}

	/**
	 * 查询班次的信息
	 * @throws Exception
	 * @author yangzijia
	 */
	public List<Shift> findshiftInfo() {
		@SuppressWarnings("unchecked")
		List<Shift> shift = hibernateTemplate.find("from Shift");
		return shift;
	}

	/**
	 * 更改班次信息
	 * @author yangzijia
	 */
	public void updateShiftInfo(Shift ss) {
		hibernateTemplate.update(ss);
	}

	
	/**
	 * 根据a_datetime查询申诉列表里是否存在当前信息（防止重复提交）
	 * @param a_datetime
	 * @return
	 */
	public boolean isExistDate(String a_datetime,int m_id) {
		@SuppressWarnings("unchecked")
		List<Attendance_unusual> list = hibernateTemplate.find("from Attendance_unusual where datetime='"+ a_datetime +"' and applyuser_id="+ m_id +"");
		if(list.size() > 0){
			return true;
		}
		return false;
	}

	/**
	 * 查询出所有的默认IP的方法
	 */
	public List<DefaultIP> findAllIp() {
		@SuppressWarnings("unchecked")
		List<DefaultIP> list = hibernateTemplate.find("from DefaultIP order by id desc");
		return list;
	}

	/**
	 * 保存ip到数据库的方法
	 * @param dip
	 */
	public void saveDefaultIP(DefaultIP dip) {
		hibernateTemplate.save(dip);
	}

	/**
	 * 获取最后一次保存的ip的id
	 * @return
	 */
	public int getDefaultIpBydesc() {
		@SuppressWarnings("unchecked")
		List<DefaultIP> dip = hibernateTemplate.find("from DefaultIP order by id desc");
		return dip.get(0).getId();
	}

	/**
	 * 删除ip的方法
	 * @param dip
	 */
	public void deleteDefaultIPbyId(DefaultIP dip) {
		hibernateTemplate.delete(dip);
	}

}
