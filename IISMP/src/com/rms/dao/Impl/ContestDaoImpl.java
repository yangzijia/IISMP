package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rms.dao.BaseDao;
import com.rms.dao.ContestDao;
import com.rms.model.Contest;
import com.rms.model.Project;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-28 下午6:51:28
 * @parameter  
 */
@Component("contestDao")
public class ContestDaoImpl extends BaseDao implements	ContestDao{

	//查看所有比赛
	public List<Contest> findAll() {
		@SuppressWarnings("unchecked")
		List<Contest> an = hibernateTemplate.find(" from Contest ");
		return an;
	}

	//根据id查看比赛详情
	public List<Contest> findCbyid(int contest_id) {
		@SuppressWarnings("unchecked")
		List<Contest> an = hibernateTemplate.find(" from Contest where contest_id='"+contest_id+"'");
		return an;
	}

	//查看项目
	public List<Project> findAllP(int pageNow) {
		String sql="";
		sql="from Project  order by project_id desc ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		
		@SuppressWarnings("unchecked")
		List<Project> an = query.list();
		session.close();
		return an;
	}

	//查看项目数量
	public int findAllCount() {
		@SuppressWarnings("unchecked")
		List<Project> an = hibernateTemplate.find(" from Project ");
			int row = an.size();
			return row;
	}

	//更新比赛信息
	public void updateContest(Contest cc) {
		hibernateTemplate.update(cc);
		
	}

	//增加比赛信息
	public void addcon(Contest con) {
	hibernateTemplate.save(con);
		
	}

	//根据id查看项目详情
	public List<Project> findPbyid(int project_id) {
		@SuppressWarnings("unchecked")
		List<Project> an = hibernateTemplate.find(" from Project where project_id='"+project_id+"'");
		return an;
	}

	//增加项目
	public void addproject(Project pr) {
		hibernateTemplate.save(pr);
		
	}

	//修改项目
	public void upproject(Project p) {
		hibernateTemplate.update(p);
		
	}

	//查看所有项目
	public List<Project> findAllP1() {
		@SuppressWarnings("unchecked")
		List<Project> an = hibernateTemplate.find(" from Project ");
		return an;
	}

}
