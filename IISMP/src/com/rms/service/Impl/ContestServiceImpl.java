package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.Contest;
import com.rms.model.Project;
import com.rms.service.BaseService;
import com.rms.service.ContestService;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-27 下午10:00:41
 * @parameter  
 */
@Component("contestService")
public class ContestServiceImpl extends BaseService implements ContestService{

	//查看所有比赛
	public List<Contest> findAll() {
		// TODO Auto-generated method stub
		return this.contestDao.findAll();
	}

	//根据id查看比赛详情
	public List<Contest> findCbyid(int contest_id) {
		// TODO Auto-generated method stub
		return this.contestDao.findCbyid(contest_id);
	}

//查看项目
	public List<Project> findAllP(int pageNow) {
		// TODO Auto-generated method stub
		return this.contestDao.findAllP(pageNow);
	}

	//查看项目数量
	public long findAllCount() {
		// TODO Auto-generated method stub
		return this.contestDao.findAllCount();
	}

	@Override
	public void updateContest(Contest cc) {
		// TODO Auto-generated method stub
		 this.contestDao.updateContest(cc);
	}

	//增加比赛
	public void addcon(Contest con) {
		this.contestDao.addcon(con);
		
	}

	//根据id 查看项目
	public List<Project> findPbyid(int project_id) {
		// TODO Auto-generated method stub
		return this.contestDao.findPbyid(project_id) ;
	}

	//增加项目
	public void addproject(Project pr) {
		this.contestDao.addproject(pr);
	}

	//修改项目
	public void upproject(Project p) {
		this.contestDao.upproject(p);
		
	}

	//查看所有项目
	public List<Project> findAllP1() {
		return this.contestDao.findAllP1();
	}

}
