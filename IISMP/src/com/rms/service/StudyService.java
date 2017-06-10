package com.rms.service;

import java.util.List;

import com.rms.model.Learning_Log;
import com.rms.model.Learning_plan;
import com.rms.model.Log_type;

public interface StudyService {

	/**
	 * 增加学习计划的方法
	 * @param lp
	 * @author yangzijia
	 */
	public abstract void addlearningplan(Learning_plan lp);

	/**
	 * 分页查询出该用户的学习计划
	 * @param pageNow
	 * @param lendtime 
	 * @param lstarttime 
	 * @param user_id 
	 * @return List<Learning_plan>
	 */
	public abstract List<Learning_plan> findalllearnplan(int pageNow, String lstarttime, String lendtime);

	/**
	 * 查询出该用户的学习计划de 个数
	 * @return num
	 * @author yangzijia
	 * @param lendtime 
	 * @param lstarttime 
	 */
	public abstract long findalllearnplannum(String lstarttime, String lendtime);

	/**
	 * 根据id查询出计划信息
	 * @param id
	 * @return List<Learning_plan>
	 * @author yangzijia
	 */
	public abstract List<Learning_plan> findthislearningplaninfobyid(int id);

	/**
	 * 将修改后的计划信息保存到数据库中
	 * @param lp
	 */
	public abstract void updatelearnplan(Learning_plan lp);

	/**
	 * 根据id删除这条计划的方法
	 * @param lp
	 */
	public abstract void deletethisplanbyid(Learning_plan lp);

	/**
	 * 查询出所有成员的计划的方法
	 * @param lstarttime
	 * @param lendtime
	 * @param pageNow
	 * @param sectionname 
	 * @return List<Learning_plan>
	 */
	public abstract List<Learning_plan> findalluserplan(String lstarttime,
			String lendtime, int pageNow, String sectionname);

	/**
	 * 查询出所有成员的计划de 数量的方法
	 * @param lstarttime
	 * @param lendtime
	 * @param sectionname
	 * @return num
	 */
	public abstract long findalluserplannum(String lstarttime, String lendtime,
			String sectionname);

	/**
	 * 首页查看学习计划的方法
	 * @param m_id 
	 * @param lendtime 
	 * @param lstarttime 
	 * @return List<Learning_plan>
	 */
	public abstract List<Learning_plan> findalllearningplanindex(int m_id, String lstarttime, String lendtime);

	
	
	/**List<Learning_Log>
	 * @param pageNow
	 * @param lt_id
	 * @return
	 * 根据日志类型查看日志
	 */
	public abstract List<Learning_Log> findLogs(int pageNow, int lt_id);

	/**int
	 * @param lt_id
	 * @return
	 * 根据日志类型查找日志数目
	 */
	public abstract int findlogs_num(int lt_id);

	
	/**List<Learning_Log>
	 * @param pageNow
	 * @param memname 
	 * @return
	 */
	public abstract List<Learning_Log> findLog(int pageNow, String memname);

	/**List<Log_type>
	 * @return
	 */
	public abstract List<Log_type> findltype();

	/**void
	 * @param ll
	 */
	public abstract void addlog(Learning_Log ll);

	/**List<Log_type>
	 * @param lt_id
	 * @return
	 */
	public abstract List<Log_type> findLTbyid(int lt_id);

	/**void
	 * @param lltype
	 */
	public abstract void update(Log_type lltype);

	/**void
	 * @param lp
	 */
	public abstract void addLogtype(Log_type lp);

	/**void
	 * @param logt
	 */
	public abstract void deleteltype(Log_type logt);

	/**void
	 * @param ll
	 */
	public abstract void addDraft(Learning_Log ll);

	
	/**List<Learning_Log>
	 * @param l_id
	 * @return
	 */
	public abstract List<Learning_Log> findlogByid(int l_id);

	/**List<Learning_Log>
	 * @param memname
	 * @return
	 */
	public abstract List<Learning_Log> findmylog(String memname);

	/**void
	 * @param log1
	 */
	public  void deletelogByid(Learning_Log log2);

	/**void
	 * @param log2
	 */
	public abstract void editlog(Learning_Log log2);

	/**List<Learning_Log>
	 * @param pageNow
	 * @param memname
	 * @return
	 */
	public abstract List<Learning_Log> findmydraft(int pageNow, String memname);
	
}
