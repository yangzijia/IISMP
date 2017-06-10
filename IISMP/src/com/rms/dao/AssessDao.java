package com.rms.dao;

import java.util.List;

import com.rms.model.Assess;
import com.rms.model.AssessChart;
import com.rms.model.AssessExportChart;
import com.rms.model.AssessOperator;
import com.rms.model.MembershipInfo;


public interface AssessDao {

	/**
	 * 查询出评估表信息
	 * @param pageNow 
	 * @return List<AssessChart>
	 */
	public abstract List<AssessChart> findallassesschartinfo(int pageNow);

	/**
	 * 查询出评估表的总数量
	 * @return num
	 */
	public abstract long findassesstotalItemNumber();

	/**
	 * 添加新的评估表的方法
	 */
	public abstract void saveassesschartinfo(AssessChart ac);

	/**
	 * 根据ID查询出评估表的具体信息
	 * @param id
	 * @return List<AssessChart>
	 */
	public abstract List<AssessChart> findthisassessinfobyid(int id);

	/**
	 * 删除这条评估表的具体信息
	 */
	public abstract void deletethisassess(AssessChart a);

	/**
	 * 查询出最新添加的表的信息
	 * @return List<AssessChart>
	 */
	public abstract List<AssessChart> findassessinfo();

	/**
	 * 增加到assess数据表中
	 * @param as
	 */
	public abstract void addassessinfo(Assess as);

	/**
	 * 根据ac_id查询出评估具体信息
	 * @param id
	 * @return List<Assess>
	 */
	public abstract List<Assess> findassessinfobyid(int id);

	/**
	 * 根据ac_id和sectionname查询出评估具体信息
	 * @param sectionname
	 * @param id
	 * @param operator_id 
	 * @return List<Assess>
	 */
	public abstract List<Assess> findassessinfoBysectionnameAndid(
			String sectionname, int id, int operator_id);

	/**
	 * 根据id查询出评估的具体信息
	 * @param id
	 * @return List<Assess>
	 */

	public abstract List<Assess> findassesspingguxinxibyid(int id);

	/**
	 * 更新assess表
	 * @param as
	 */
	public abstract void updateAssessinfo(Assess as);

	/**
	 * 新增assessoperator表，即添加操作人姓名
	 * @param ao
	 */
	public abstract void addassessoperatorinfo(AssessOperator ao);

	/**
	 * 根据AC_id查询出有谁参与评估
	 * @param ac_id
	 * @return List<AssessOperator>
	 */
	public abstract List<AssessOperator> findallassessoperator(int ac_id);

	/**
	 * 根据ac_id和userid查询出评估人对该成员评估的所有列表信息
	 * @param ac_id
	 * @param id
	 * @return List<Assess>
	 */
	public abstract List<Assess> findassessinfoByac_idandid(int ac_id, int id);

	/**
	 * 根据ac_id查询出评估表的具体信息
	 * @param id
	 * @return List<AssessChart>
	 */
	public abstract List<AssessChart> findassesschartbyac_id(int id);

	/**
	 * 根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
	 * @param id
	 * @param m_id
	 * @return List<Assess>
	 */
	public abstract List<Assess> findassessinfoByac_idandoperator_id(int id,
			int m_id);

	/**
	 * 根据成员的ID和operator_id和ac_id查询出信息进行判断是否存在
	 * @param ac_id
	 * @param operator_id
	 * @param user_id
	 * @return boolean
	 */
	public abstract boolean isnotExitforAssess(int ac_id, int operator_id,
			int user_id);

	/**
	 * 根据AC_id和operator_id来判断该登录成员时候参与评估
	 * @param ac_id
	 * @param operator_id
	 * @return boolean
	 */
	public abstract boolean isexitassessoperatorbyac_idandturename(int ac_id,
			int operator_id);

	/**
	 * 根据ac_id和userid和 sectionname查询出评估人对该成员评估的所有列表信息
	 * @param ac_id
	 * @param user_id
	 * @param sectionname
	 * @return List<Assess>
	 */
	public abstract List<Assess> findassessByac_idandidandsectionname(
			int ac_id, int user_id, String sectionname);

	/**
	 * 根据sectionname查询出所有成员信息的方法
	 * @param sectionname
	 * @return List<MembershipInfo>
	 */
	public abstract List<MembershipInfo> findmembershipBysectionname(
			String sectionname);

	/**
	 * 查看所有导出的评估表的方法
	 * @return List<AssessExportChart>
	 */
	public abstract List<AssessExportChart> findallAssessExportChart();

	/**
	 * 查询出所有的评估表
	 * @return List<AssessChart>
	 */
	public abstract List<AssessChart> findallassesschart();

	/**
	 * 根据评估表的名称查询出该评估表的所有信息
	 * @param assessname
	 * @return List<AssessChart>
	 */
	public abstract List<AssessChart> findassesschartByassessname(
			String assessname);

	/**
	 * add到数据库中AssessExportChart
	 * @param abc
	 */
	public abstract void saveassessExportChart(AssessExportChart abc);

	/**
	 * 删除导出的评估表的方法
	 * @param aec
	 */
	public abstract void deleteassessexportchartByid(AssessExportChart aec);

	/**
	 * 根据id查询出导出评估表的方法
	 * @param id
	 * @return List<AssessExportChart>
	 */
	public abstract List<AssessExportChart> findassessexportchartByid(int id);

	/**
	 * 根据exportname判断导出表名是否重复
	 * @param filename
	 * @return boolean
	 */
	public abstract boolean isnotexitassessexportchart(String filename);


}
