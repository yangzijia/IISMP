package com.rms.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.rms.model.Learning_Log;
import com.rms.model.Learning_plan;
import com.rms.model.Log_type;
import com.rms.model.MembershipInfo;
import com.rms.service.BaseService;
import com.rms.service.StudyService;

@Component("studyService")
public class StudyServiceImpl extends BaseService implements StudyService{

	/**
	 * 增加学习计划的方法
	 * @param lp
	 * @author yangzijia
	 */
	public void addlearningplan(Learning_plan lp) {
		this.studyDao.addlearningplan(lp);
	}

	/**
	 * 分页查询出该用户的学习计划
	 * @param pageNow
	 * @return List<Learning_plan>
	 */
	public List<Learning_plan> findalllearnplan(int pageNow, String lstarttime, String lendtime) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		return this.studyDao.findalllearnplan(pageNow,me.getM_id(),lstarttime,lendtime);
	}

	/**
	 * 查询出该用户的学习计划de 个数
	 * @return num
	 * @author yangzijia
	 */
	public long findalllearnplannum(String lstarttime, String lendtime) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		return this.studyDao.findalllearnplannum(me.getM_id(),lstarttime,lendtime);
	}

	/**
	 * 根据id查询出计划信息
	 * @param id
	 * @return List<Learning_plan>
	 * @author yangzijia
	 */
	public List<Learning_plan> findthislearningplaninfobyid(int id) {
		return this.studyDao.findthislearningplaninfobyid(id);
	}

	/**
	 * 将修改后的计划信息保存到数据库中
	 * @param lp
	 */
	public void updatelearnplan(Learning_plan lp) {
		this.studyDao.updatelearnplan(lp);
	}

	/**
	 * 根据id删除这条计划的方法
	 * @param lp
	 */
	public void deletethisplanbyid(Learning_plan lp) {
		this.studyDao.deletethisplanByid(lp);
	}

	/**
	 * 查询出所有成员的计划的方法
	 * @param lstarttime
	 * @param lendtime
	 * @param pageNow
	 * @return List<Learning_plan>
	 */
	public List<Learning_plan> findalluserplan(String lstarttime,
			String lendtime, int pageNow, String sectionname) {
		return this.studyDao.findalluserplan(lstarttime,lendtime,pageNow,sectionname);
	}

	/**
	 * 查询出所有成员的计划de 数量的方法
	 * @param lstarttime
	 * @param lendtime
	 * @param sectionname
	 * @return num
	 */
	public long findalluserplannum(String lstarttime, String lendtime,
			String sectionname) {
		return this.studyDao.findalluserplannum(lstarttime,lendtime,sectionname);
	}

	/**
	 * 首页查看学习计划的方法
	 * @return List<Learning_plan>
	 */
	public List<Learning_plan> findalllearningplanindex(int m_id, String lstarttime, String lendtime) {
		return this.studyDao.findalllearningplanindex(m_id,lstarttime,lendtime);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findLog(int)
	 */
	public List<Learning_Log> findLog(int pageNow,String memname) {
		// TODO Auto-generated method stub
		return this.studyDao.findLog(pageNow,memname);
	}

	

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findLogs(int, java.lang.String)
	 */
	@Override
	public List<Learning_Log> findLogs(int pageNow, int lt_id) {
		// TODO Auto-generated method stub
		return this.studyDao.findLogs(pageNow,lt_id);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findlogs_num(java.lang.String)
	 */
	@Override
	public int findlogs_num(int lt_id) {
		// TODO Auto-generated method stub
		return this.studyDao.findlogs_num(lt_id);
	}

	

	
	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#addlog(com.rms.model.Learning_Log)
	 */
	@Override
	public void addlog(Learning_Log ll) {
		 this.studyDao.addlog(ll);
		
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findltype()
	 */
	@Override
	public List<Log_type> findltype() {
		// TODO Auto-generated method stub
		return this.studyDao.findltype();
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findLTbyid(int)
	 */
	@Override
	public List<Log_type> findLTbyid(int lt_id) {
		// TODO Auto-generated method stub
		return this.studyDao.findLTbyid(lt_id);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#update(com.rms.model.Log_type)
	 */
	@Override
	public void update(Log_type lltype) {
		// TODO Auto-generated method stub
	 this.studyDao.update(lltype);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#addLogtype(com.rms.model.Log_type)
	 */
	@Override
	public void addLogtype(Log_type lp) {
		// TODO Auto-generated method stub
		this.studyDao.addLogtype(lp);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#deleteltype(com.rms.model.Log_type)
	 */
	@Override
	public void deleteltype(Log_type logt) {
		this.studyDao.deleteltype(logt);
		
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#addDraft(com.rms.model.Learning_Log)
	 */
	@Override
	public void addDraft(Learning_Log ll) {
		// TODO Auto-generated method stub
		this.studyDao.addDraft(ll);
	}

	

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findlogByid(int)
	 */
	@Override
	public List<Learning_Log> findlogByid(int l_id) {
		// TODO Auto-generated method stub
		return this.studyDao.findlogByid(l_id);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findmylog(java.lang.String)
	 */
	@Override
	public List<Learning_Log> findmylog(String memname) {
		// TODO Auto-generated method stub
		return this.studyDao.findmylog(memname);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#deletelogByid(com.rms.model.Learning_Log)
	 */
	@Override
	public void deletelogByid(Learning_Log log2) {
		// TODO Auto-generated method stub
		this.studyDao.deletelogByid(log2);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#editlog(com.rms.model.Learning_Log)
	 */
	@Override
	public void editlog(Learning_Log log2) {
		// TODO Auto-generated method stub
		this.studyDao.editlog(log2);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.StudyService#findmydraft(int, java.lang.String)
	 */
	@Override
	public List<Learning_Log> findmydraft(int pageNow, String memname) {
		// TODO Auto-generated method stub
		return this.studyDao.findmydraft(pageNow,memname);
	}


	
}
