package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rms.dao.AssessDao;
import com.rms.dao.BaseDao;
import com.rms.model.Assess;
import com.rms.model.AssessChart;
import com.rms.model.AssessExportChart;
import com.rms.model.AssessOperator;
import com.rms.model.MembershipInfo;

@Component("assessDao")
public class AssessDaoImpl extends BaseDao implements AssessDao{

	/**
	 * 查询出评估表信息
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findallassesschartinfo(int pageNow) {
		String sql = "from AssessChart order by updatetimeinfo desc";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<AssessChart> ac =  query.list();
		session.close();
		return ac;
	}

	/**
	 * 查询出评估表的总数量
	 * @return num
	 */
	public long findassesstotalItemNumber() {
		@SuppressWarnings("unchecked")
		List<AssessChart> ac = hibernateTemplate.find("from AssessChart order by updatetimeinfo desc");
		if(ac!= null && ac.size()>0){
			return ac.size();
		}
		return 0;
	}

	/**
	 * 添加新的评估表的方法
	 */
	public void saveassesschartinfo(AssessChart ac) {
		hibernateTemplate.save(ac);
	}

	/**
	 * 根据ID查询出评估表的具体信息
	 * @param id
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findthisassessinfobyid(int id) {
		@SuppressWarnings("unchecked")
		List<AssessChart> ac = hibernateTemplate.find("from AssessChart where id="+id+"");
		return ac;
	}

	/**
	 * 删除这条评估表的具体信息
	 */
	public void deletethisassess(AssessChart a) {
		hibernateTemplate.delete(a);
		//删除assess表中的信息
		String sql = "delete from Assess where ac_id="+a.getId()+"";
		Session session = sessionFactory.openSession();
		session.createQuery(sql).executeUpdate();
		//session.getTransaction().commit();
		session.close();
	}

	/**
	 * 查询出最新添加的表的信息
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassessinfo() {
		@SuppressWarnings("unchecked")
		List<AssessChart> ac = hibernateTemplate.find("from AssessChart order by id desc");
		return ac;
	}

	/**
	 * 增加到assess数据表中
	 * @param as
	 */
	public void addassessinfo(Assess as) {
		hibernateTemplate.save(as);
	}

	/**
	 * 根据ac_id查询出评估具体信息
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfobyid(int id) {
		@SuppressWarnings("unchecked")
		List<Assess> ass = hibernateTemplate.find("from Assess where ac_id="+id+"");
		return ass;
	}

	/**
	 * 根据ac_id和sectionname查询出评估具体信息
	 * @param sectionname
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoBysectionnameAndid(String sectionname,
			int id,int operator_id) {
		String sql= "";
System.out.println("sdfsdfsd==="+sectionname);
		if(sectionname.equals("全部成员")){
			sql="from Assess where ac_id="+id+" and operator_id="+operator_id+"";
		}else{
			sql = "from Assess where ac_id="+id+" and operator_id="+operator_id+" and sectionname='"+sectionname+"'";
		}
		@SuppressWarnings("unchecked")
		List<Assess> ass = hibernateTemplate.find(sql);
		return ass;
	}

	/**
	 * 根据id查询出评估的具体信息
	 * @param id
	 * @return List<Assess>
	 */

	public List<Assess> findassesspingguxinxibyid(int id) {
		@SuppressWarnings("unchecked")
		List<Assess> ass = hibernateTemplate.find("from Assess where id="+id+"");
		return ass;
	}

	/**
	 * 更新assess表
	 * @param as
	 */
	public void updateAssessinfo(Assess as) {
		hibernateTemplate.update(as);
	}

	/**
	 * 新增assessoperator表，即添加操作人姓名
	 * @param ao
	 */
	public void addassessoperatorinfo(AssessOperator ao) {
		hibernateTemplate.save(ao);
	}

	/**
	 * 根据AC_id查询出有谁参与评估
	 * @param ac_id
	 * @return List<AssessOperator>
	 */
	public List<AssessOperator> findallassessoperator(int ac_id) {
		@SuppressWarnings("unchecked")
		List<AssessOperator> ao = hibernateTemplate.find("from AssessOperator where ac_id="+ac_id+"");
		return ao;
	}

	/**
	 * 根据ac_id和userid查询出评估人对该成员评估的所有列表信息
	 * @param ac_id
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoByac_idandid(int ac_id, int userid) {
		@SuppressWarnings("unchecked")
		List<Assess> ass = hibernateTemplate.find("from Assess where ac_id="+ac_id+" and user_id="+userid+"");
		return ass;
	}

	/**
	 * 根据ac_id查询出评估表的具体信息
	 * @param id
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassesschartbyac_id(int id) {
		@SuppressWarnings("unchecked")
		List<AssessChart> ac = hibernateTemplate.find("from AssessChart where id="+id+"");
		return ac;
	}

	/**
	 * 根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
	 * @param id
	 * @param m_id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoByac_idandoperator_id(int id, int m_id) {
		@SuppressWarnings("unchecked")
		List<Assess> ass = hibernateTemplate.find("from Assess where ac_id="+id+" and operator_id="+m_id+"");
		return ass;
	}

	/**
	 * 根据成员的ID和operator_id和ac_id查询出信息进行判断是否存在
	 * @param ac_id
	 * @param operator_id
	 * @param user_id
	 * @return boolean
	 */
	public boolean isnotExitforAssess(int ac_id, int operator_id, int user_id) {
		@SuppressWarnings("unchecked")
		List<Assess> assess = hibernateTemplate
					.find("from Assess where ac_id="+ac_id+" and operator_id="+operator_id+" and user_id="+user_id+"");
		if(assess!=null && assess.size()>0){
			return false;
		}
		return true;
	}

	/**
	 * 根据AC_id和m.getM_turename来判断该登录成员时候参与评估
	 * @param ac_id
	 * @param m_truename
	 * @return boolean
	 */
	public boolean isexitassessoperatorbyac_idandturename(int ac_id,
			int operator_id) {
		@SuppressWarnings("unchecked")
		List<AssessOperator> ao = hibernateTemplate.find("from AssessOperator where ac_id="+ac_id+" and operator_id="+operator_id+"");
		if(ao!=null && ao.size()>0){
			return false;
		}
		return true;
	}

	/**
	 * 根据ac_id和userid和 sectionname查询出评估人对该成员评估的所有列表信息
	 * @param ac_id
	 * @param user_id
	 * @param sectionname
	 * @return List<Assess>
	 */
	public List<Assess> findassessByac_idandidandsectionname(int ac_id,
			int user_id, String sectionname) {
		String sql = "";
		if(sectionname.equals("全部成员")){
			sql = "from Assess where ac_id="+ac_id+" and user_id="+user_id+"";
		}else{
			sql = "from Assess where ac_id="+ac_id+" and sectionname='"+sectionname+"' and user_id="+user_id+"";
		}
		
		@SuppressWarnings("unchecked")
		List<Assess> assess = hibernateTemplate.find(sql);
		return assess;
	}

	/**
	 * 根据sectionname查询出所有成员信息的方法
	 * @param sectionname
	 * @return List<MembershipInfo>
	 */
	public List<MembershipInfo> findmembershipBysectionname(String sectionname) {
		String sql = "";
		if(sectionname.equals("全部成员")){
			sql = "from MembershipInfo where m_state='启用' order by role_num,m_entermiictime desc";
		}else{
			sql = "from MembershipInfo where m_state='启用' and m_sectionname='"+sectionname+"' order by role_num,m_entermiictime desc";
		}
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate.find(sql);
		return msi;
	}

	/**
	 * 查看所有导出的评估表的方法
	 * @return List<AssessExportChart>
	 */
	public List<AssessExportChart> findallAssessExportChart() {
		@SuppressWarnings("unchecked")
		List<AssessExportChart> aec = hibernateTemplate.find("from AssessExportChart order by id desc");
		return aec;
	}

	/**
	 * 查询出所有的评估表
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findallassesschart() {
		@SuppressWarnings("unchecked")
		List<AssessChart> ac = hibernateTemplate.find("from AssessChart order by updatetime desc");
		return ac;
	}

	/**
	 * 根据评估表的名称查询出该评估表的所有信息
	 * @param assessname
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassesschartByassessname(String assessname) {
		@SuppressWarnings("unchecked")
		List<AssessChart> ac = hibernateTemplate.find("from AssessChart where assessname='"+assessname+"'");
		return ac;
	}

	/**
	 * add到数据库中AssessExportChart
	 * @param abc
	 */
	public void saveassessExportChart(AssessExportChart abc) {
		hibernateTemplate.save(abc);
	}

	/**
	 * 删除导出的评估表的方法
	 * @param aec
	 */
	public void deleteassessexportchartByid(AssessExportChart aec) {
		hibernateTemplate.delete(aec);
	}

	/**
	 * 根据id查询出导出评估表的方法
	 * @param id
	 * @return List<AssessExportChart>
	 */
	public List<AssessExportChart> findassessexportchartByid(int id) {
		@SuppressWarnings("unchecked")
		List<AssessExportChart> aec = hibernateTemplate.find("from AssessExportChart where id="+id+"");
		return aec;
	}

	/**
	 * 根据exportname判断导出表名是否重复
	 * @param filename
	 * @return boolean
	 */
	public boolean isnotexitassessexportchart(String filename) {
		@SuppressWarnings("unchecked")
		List<AssessExportChart> aec = hibernateTemplate.find("from AssessExportChart where exportname='"+filename+"'");
		if(aec!=null && aec.size()>0){
			return false;
		}
		return true;
	}


}
