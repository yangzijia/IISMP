package com.rms.service;

import java.util.List;

import com.rms.model.Contest;
import com.rms.model.Project;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-27 下午9:52:19
 * @parameter  
 */
public interface ContestService {
	//查看所有比赛
	public abstract List<Contest> findAll();
	//根据id查看比赛详情
	public abstract List<Contest> findCbyid(int contest_id);
	//查看所有项目
	public abstract List<Project> findAllP(int pageNow);
	//查看项目数量
	public abstract long findAllCount();
	//更新比赛信息
	public abstract void updateContest(Contest cc);
	//增加比赛信息
	public abstract void addcon(Contest con);
	//根据id查看项目
	public abstract List<Project> findPbyid(int project_id);
	//增加项目
	public abstract void addproject(Project pr);
	//修改项目
	public abstract void upproject(Project p);
	//查看所有项目
	public abstract List<Project> findAllP1();

}
