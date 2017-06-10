package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.Assess;
import com.rms.model.AssessChart;
import com.rms.model.AssessExportChart;
import com.rms.model.AssessOperator;
import com.rms.model.MembershipInfo;
import com.rms.service.AssessService;
import com.rms.service.BaseService;
@Component("assessService")
public class AssessServiceImpl extends BaseService implements AssessService{

	/**
	 * 查询出评估表信息
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findallassesschartinfo(int pageNow) {
		return this.assessDao.findallassesschartinfo(pageNow);
	}

	/**
	 * 查询出评估表的总数量
	 * @return num
	 */
	public long findassesstotalItemNumber() {
		return this.assessDao.findassesstotalItemNumber();
	}

	/**
	 * 添加新的评估表的方法
	 */
	public void saveassesschartinfo(AssessChart ac) {
		this.assessDao.saveassesschartinfo(ac);
	}

	/**
	 * 根据ID查询出评估表的具体信息
	 * @param id
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findthisassessinfobyid(int id) {
		List<AssessChart> ac = this.assessDao.findthisassessinfobyid(id);
		if(ac!= null && ac.size()>0){
			return ac;
		}
		return null;
	}

	/**
	 * 删除这条评估表的具体信息
	 */
	public void deletethisassess(AssessChart a) {
		this.assessDao.deletethisassess(a);
	}

	/**
	 * 查询出最新添加的表的信息
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassessinfo() {
		List<AssessChart> ac = this.assessDao.findassessinfo();
		if(ac!= null && ac.size()>0){
			return ac;
		}
		return null;
	}

	/**
	 * 增加到assess数据表中
	 * @param as
	 */
	public void addassessinfo(Assess as) {
		this.assessDao.addassessinfo(as);
	}

	/**
	 * 根据ac_id查询出评估具体信息
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoByid(int id) {
		List<Assess> ass = assessDao.findassessinfobyid(id);
		if(ass!=null && ass.size()>0){
			return ass;
		}
		return null;
	}

	/**
	 * 根据ac_id和sectionname查询出评估具体信息
	 * @param sectionname
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoBysectionnameAndid(String sectionname,
			int id,int operator_id) {
		List<Assess> ass = assessDao.findassessinfoBysectionnameAndid(sectionname,id,operator_id);
		if(ass!=null && ass.size()>0){
			return ass;
		}
		return null;
	}

	/**
	 * 根据id查询出评估的具体信息
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassesspingguxinxibyid(int id) {
		List<Assess> ass = assessDao.findassesspingguxinxibyid(id);
		if(ass!=null && ass.size()>0){
			return ass;
		}
		return null;
	}

	/**
	 * 更新assess表
	 * @param as
	 */
	public void updateassessinfo(Assess as) {
		this.assessDao.updateAssessinfo(as);
	}

	/**
	 * 新增assessoperator表，即添加操作人姓名
	 * @param ao
	 */
	public void addassessoperatorinfo(AssessOperator ao) {
		this.assessDao.addassessoperatorinfo(ao);
	}

	/**
	 * 根据AC_id查询出有谁参与评估
	 * @param ac_id
	 * @return List<AssessOperator>
	 */
	public List<AssessOperator> findallassessoperator(int ac_id) {
		return this.assessDao.findallassessoperator(ac_id);
	}

	/**
	 * 根据ac_id和userid查询出评估人对该成员评估的所有列表信息
	 * @param ac_id
	 * @param id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoByac_idandid(int ac_id, int id) {
		return this.assessDao.findassessinfoByac_idandid(ac_id,id);
	}

	/**
	 * 根据ac_id查询出评估表的具体信息
	 * @param id
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassesschartbyac_id(int id) {
		return this.assessDao.findassesschartbyac_id(id);
	}

	/**
	 * 根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
	 * @param id
	 * @param m_id
	 * @return List<Assess>
	 */
	public List<Assess> findassessinfoByac_idandoperator_id(int id, int m_id) {
		return this.assessDao.findassessinfoByac_idandoperator_id(id,m_id);
	}

	/**
	 * 根据成员的ID和operator_id和ac_id查询出信息进行判断是否存在
	 * @param ac_id
	 * @param operator_id
	 * @param user_id
	 * @return boolean
	 */
	public boolean isnotExitforAssess(int ac_id, int operator_id, int user_id) {
		
		return this.assessDao.isnotExitforAssess(ac_id,operator_id,user_id);
	}

	/**
	 * 根据AC_id和operator_id来判断该登录成员时候参与评估
	 * @param ac_id
	 * @param operator_id
	 * @return boolean
	 */
	public boolean isexitassessoperatorbyac_idandturename(int ac_id,
			int operator_id) {
		return this.assessDao.isexitassessoperatorbyac_idandturename(ac_id, operator_id);
	}

	/**
	 * 根据ac_id和userid和 sectionname查询出评估人对该成员评估的所有列表信息
	 * @param ac_id
	 * @param m_id
	 * @param sectionname
	 * @return List<Assess>
	 */
	public List<Assess> findassessByac_idandidandsectionname(int ac_id,
			int user_id, String sectionname) {
		return this.assessDao.findassessByac_idandidandsectionname(ac_id,user_id,sectionname);
	}

	/**
	 * 根据sectionname查询出所有成员信息的方法
	 * @param sectionname
	 * @return List<MembershipInfo>
	 */
	public List<MembershipInfo> findmembershipBysectionname(String sectionname) {
		return this.assessDao.findmembershipBysectionname(sectionname);
	}

	/**
	 * 查看所有导出的评估表的方法
	 * @return List<AssessExportChart>
	 */
	public List<AssessExportChart> findallAssessExportchart() {
		return this.assessDao.findallAssessExportChart();
	}

	/**
	 * 查询出所有的评估表
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassesschart() {
		return this.assessDao.findallassesschart();
	}

	/**
	 * 根据评估表的名称查询出该评估表的所有信息
	 * @param assessname
	 * @return List<AssessChart>
	 */
	public List<AssessChart> findassesschartByassessname(String assessname) {
		return this.assessDao.findassesschartByassessname(assessname);
	}

	/**
	 * add到数据库中AssessExportChart
	 * @param abc
	 */
	public void saveassessExportChart(AssessExportChart abc) {
		this.assessDao.saveassessExportChart(abc);
	}

	/**
	 * 删除导出的评估表的方法
	 * @param aec
	 */
	public void deleteassessexportchartByid(AssessExportChart aec) {
		this.assessDao.deleteassessexportchartByid(aec);
	}

	/**
	 * 根据id查询出导出评估表的方法
	 * @param id
	 * @return List<AssessExportChart>
	 */
	public List<AssessExportChart> findassessexportchartByid(int id) {
		return this.assessDao.findassessexportchartByid(id);
	}

	/**
	 * 根据exportname判断导出表名是否重复
	 * @param filename
	 * @return boolean
	 */
	public boolean isnotexitassessexportchart(String filename) {
		return this.assessDao.isnotexitassessexportchart(filename);
	}



}
