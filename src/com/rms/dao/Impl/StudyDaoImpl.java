package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.rms.dao.BaseDao;
import com.rms.dao.StudyDao;
import com.rms.model.Learning_Log;
import com.rms.model.Learning_plan;
import com.rms.model.Log_type;

@Component("studyDao")
public class StudyDaoImpl extends BaseDao implements StudyDao{

	/**
	 * 增加学习计划的方法
	 * @param lp
	 * @author yangzijia
	 */
	public void addlearningplan(Learning_plan lp) {
		hibernateTemplate.save(lp);
	}

	/**
	 * 分页查询出该用户的学习计划
	 * @param pageNow
	 * @return List<Learning_plan>
	 */
	public List<Learning_plan> findalllearnplan(int pageNow,int m_id, String lstarttime, String lendtime) {
		String sql = null;
		

if(lstarttime==""){
	System.out.println("lstarttime=="+lstarttime+"sdfs");
}
if(lendtime==""){
	System.out.println("lendtime=="+lendtime+"sdfs");
}
		
		if(lstarttime==null && lendtime==null){
			
			sql = "from Learning_plan where m_id="+m_id+" order by id desc";
		}else if(lstarttime.length()==0 && lendtime.length()!=0){
			
			sql = "from Learning_plan where m_id="+m_id+" and lendtime<='"+lendtime+"' order by id desc";
		}else if(lstarttime.length()!=0 && lendtime.length()==0){
			
			sql = "from Learning_plan where m_id="+m_id+" and lstarttime>='"+lstarttime+"' order by id desc";
		}else if(lstarttime.length()!=0 && lendtime.length()!=0){
			
			sql = "from Learning_plan where m_id="+m_id+" and lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by id desc";
		}else if(lstarttime.length()==0 && lendtime.length()==0){
			sql = "from Learning_plan where m_id="+m_id+" order by id desc";
		}
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Learning_plan> msi =  query.list();
		session.close();
		return msi;
	}

	/**
	 * 查询出该用户的学习计划de 个数
	 * @return num
	 * @author yangzijia
	 */
	public long findalllearnplannum(int m_id, String lstarttime, String lendtime) {
		String sql = "";
System.out.println("lstarttime=="+lstarttime);
System.out.println("lendtime=="+lendtime);
		if(lstarttime==null && lendtime==null){
			
			sql = "from Learning_plan where m_id="+m_id+" order by id desc";
		}else if(lstarttime.length()==0 && lendtime.length()!=0){
			
			sql = "from Learning_plan where m_id="+m_id+" and lendtime<='"+lendtime+"' order by id desc";
		}else if(lstarttime.length()!=0 && lendtime.length()==0){
			
			sql = "from Learning_plan where m_id="+m_id+" and lstarttime>='"+lstarttime+"' order by id desc";
		}else if(lstarttime.length()!=0 && lendtime.length()!=0){
			
			sql = "from Learning_plan where m_id="+m_id+" and lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by id desc";
		}else if(lstarttime.length()==0 && lendtime.length()==0){
			sql = "from Learning_plan where m_id="+m_id+" order by id desc";
		}
		@SuppressWarnings("unchecked")
		List<Learning_plan> msi = hibernateTemplate.find(sql);
		if(msi !=null && msi.size()>0){
			return msi.size();
		}
		return 0;
	}

	@Override
	public List<Learning_plan> findthislearningplaninfobyid(int id) {
		@SuppressWarnings("unchecked")
		List<Learning_plan> msi = hibernateTemplate.find("from Learning_plan where id="+id+"");
		if(msi !=null && msi.size()>0){
			return msi;
		}
		return null;
	}

	/**
	 * 将修改后的计划信息保存到数据库中
	 * @param lp
	 */
	public void updatelearnplan(Learning_plan lp) {
		hibernateTemplate.update(lp);
	}

	/**
	 * 根据id删除这条计划的方法
	 * @param lp
	 */
	public void deletethisplanByid(Learning_plan lp) {
		hibernateTemplate.delete(lp);
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
		String sql = "";
		if(sectionname!=null&&sectionname.length()!=0){
			if(lstarttime==null && lendtime==null){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()==0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' and lstarttime>='"+lstarttime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' and lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()==0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' order by updatetime,id desc";
			}
		}else{
			if(lstarttime==null && lendtime==null){
				
				sql = "from Learning_plan order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where slendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()==0){
				
				sql = "from Learning_plan where lstarttime>='"+lstarttime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()==0){
				
				sql = "from Learning_plan order by updatetime,id desc";
			}
		}
		

		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Learning_plan> msi =  query.list();
		session.close();
		return msi;
	}

	/**
	 * 查询出所有成员的计划数量的方法
	 * @param lstarttime
	 * @param lendtime
	 * @param sectionname
	 * @return num
	 */
	public long findalluserplannum(String lstarttime, String lendtime,
			String sectionname) {
		String sql = "";
		if(sectionname!=null&&sectionname.length()!=0){
			if(lstarttime==null && lendtime==null){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()==0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' and lstarttime>='"+lstarttime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' and lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()==0){
				
				sql = "from Learning_plan where sectionname='"+sectionname+"' order by updatetime,id desc";
			}
		}else{
			if(lstarttime==null && lendtime==null){
				
				sql = "from Learning_plan order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where slendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()==0){
				
				sql = "from Learning_plan where lstarttime>='"+lstarttime+"' order by updatetime,id desc";
			}else if(lstarttime.length()!=0 && lendtime.length()!=0){
				
				sql = "from Learning_plan where lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
			}else if(lstarttime.length()==0 && lendtime.length()==0){
				
				sql = "from Learning_plan order by updatetime,id desc";
			}
		}
		

		@SuppressWarnings("unchecked")
		List<Learning_plan> msi = hibernateTemplate.find(sql);
		return msi.size();
	}

	/**
	 * 首页查看学习计划的方法
	 * @return List<Learning_plan>
	 */
	public List<Learning_plan> findalllearningplanindex(int m_id, String lstarttime, String lendtime) {
		String sql = "";
		if(lstarttime.length()!=0&&lendtime.length()!=0){
			sql = "from Learning_plan where m_id="+m_id+" and lstarttime>='"+lstarttime+"' and lendtime<='"+lendtime+"' order by updatetime,id desc";
		}else if(lstarttime.length()==0 && lendtime.length()!=0){
			sql = "from Learning_plan where m_id="+m_id+" and lendtime<='"+lendtime+"' order by updatetime,id desc";
		}else if(lstarttime.length()!=0 && lendtime.length()==0){
			sql = "from Learning_plan where m_id="+m_id+" and lstarttime>='"+lstarttime+"' order by updatetime,id desc";
		}else if(lstarttime.length()==0 && lendtime.length()==0){
			sql = "from Learning_plan where m_id="+m_id+" order by updatetime,id desc";
		}
		@SuppressWarnings("unchecked")
		List<Learning_plan> lp = hibernateTemplate.find(sql);
		return lp;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findLog(int)
	 * 查看发布的日志
	 */
	@Override
	public List<Learning_Log> findLog(int pageNow,String memname) {
		String sql="";
		sql="from Learning_Log where l_state='fabu' and l_member<>'"+memname+"' order by l_id desc ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Learning_Log> an = query.list();
		session.close();
		return an;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findltype()
	 */
	@Override
	public List<Log_type> findltype() {
		@SuppressWarnings("unchecked")
		List<Log_type> lt= hibernateTemplate.find("from Log_type ");
		return lt;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findLogs(int, java.lang.String)
	 */
	@Override
	public List<Learning_Log> findLogs(int pageNow, int lt_id) {
		String sql="";
		sql="from Learning_Log where lt_id='"+lt_id+"' order by l_id desc ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Learning_Log> an = query.list();
		session.close();
		return an;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findlogs_num(java.lang.String)
	 */
	@Override
	public int findlogs_num(int lt_id) {
		@SuppressWarnings("unchecked")
		List<Learning_Log> lt= hibernateTemplate.find("from Learning_Log where lt_id='"+lt_id+"'");
		int sum=lt.size();
		return sum;
	}

	

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#addlog(com.rms.model.Learning_Log)
	 */
	@Override
	public void addlog(Learning_Log ll) {
		hibernateTemplate.save(ll);
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findLTbyid(int)
	 */
	@Override
	public List<Log_type> findLTbyid(int lt_id) {
		@SuppressWarnings("unchecked")
		List<Log_type> lt= hibernateTemplate.find("from Log_type where lt_id='"+lt_id+"'");
		return lt;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#update(com.rms.model.Log_type)
	 */
	@Override
	public void update(Log_type lltype) {
		hibernateTemplate.update(lltype);
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#addLogtype(com.rms.model.Log_type)
	 */
	@Override
	public void addLogtype(Log_type lp) {
		hibernateTemplate.save(lp);
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#deleteltype(com.rms.model.Log_type)
	 */
	@Override
	public void deleteltype(Log_type logt) {
		hibernateTemplate.delete(logt);
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#addDraft(com.rms.model.Learning_Log)
	 */
	@Override
	public void addDraft(Learning_Log ll) {
		hibernateTemplate.save(ll);
	}

	

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findlogByid(int)
	 */
	@Override
	public List<Learning_Log> findlogByid(int l_id) {
		@SuppressWarnings("unchecked")
		List<Learning_Log> lt= hibernateTemplate.find("from Learning_Log where l_id='"+l_id+"'");
		return lt;
		
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findmylog(java.lang.String)
	 */
	@Override
	public List<Learning_Log> findmylog(String memname) {
		@SuppressWarnings("unchecked")
		List<Learning_Log> log=hibernateTemplate.find("from Learning_Log where l_member='"+memname+"'");
		return log;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#deletelogByid(com.rms.model.Learning_Log)
	 */
	@Override
	public void deletelogByid(Learning_Log log2) {
		this.hibernateTemplate.delete(log2);
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#editlog(com.rms.model.Learning_Log)
	 */
	@Override
	public void editlog(Learning_Log log2) {
		this.hibernateTemplate.update(log2);
		
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.StudyDao#findmydraft(int, java.lang.String)
	 */
	@Override
	public List<Learning_Log> findmydraft(int pageNow, String memname) {
		String sql="";
		sql="from Learning_Log where l_state='caogao' and l_member='"+memname+"' order by l_id desc ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Learning_Log> an = query.list();
		session.close();
		return an;
	}

	
}
