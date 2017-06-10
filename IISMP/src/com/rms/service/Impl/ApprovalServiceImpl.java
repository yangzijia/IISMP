package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.Apply;
import com.rms.model.Approval;
import com.rms.service.ApprovalService;
import com.rms.service.BaseService;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-11 下午6:54:41
 * @parameter  
 */
@Component("approvalService")
public class ApprovalServiceImpl extends BaseService implements ApprovalService{

	//查看全部审批
	public  List<Approval> findAllapproval() {
		// TODO Auto-generated method stub
		return this.approvalDao.findAllapproval();
	}

	//查看全部审批数量
	public int findAllappCount() {
		// TODO Auto-generated method stub
		return this.approvalDao.findAllappCount();
	}

	//查看我的申请
	public List<Apply> findAllapply(String m_username) {
		// TODO Auto-generated method stub
		return this.approvalDao.findAllapply(m_username);
	}

	//查看我的申请的数量
	public long findAllapplyCount(String m_username) {
		// TODO Auto-generated method stub
		return this.approvalDao.findAllapplyCount(m_username);
	}

	//查看我的审批（管理员）
	public List<Approval> findApprovalBymyname(String m_username) {
		// TODO Auto-generated method stub
		return this.approvalDao.findApprovalBymyname(m_username);
	}

	//查看我的审批（管理员）
	public long findmyAppCount(String m_username) {
		// TODO Auto-generated method stub
 return this.approvalDao.findmyAppCount(m_username);
	}

	//根据审批进度查看全部审批
	public List<Approval> findAllshenpi(int pageNow, String approval_schedule) {
		// TODO Auto-generated method stub
		return this.approvalDao.findAllshenpi(pageNow,approval_schedule);
	}

	//根据审批进度查看全部审批
	public int findallshenpin(String approval_schedule) {
		// TODO Auto-generated method stub
		return this.approvalDao.findAllshenpi(approval_schedule);
	}

	//根据审批进度查看我的申请
	public List<Apply> findMyapply(int pageNow, String approval_schedule) {
		// TODO Auto-generated method stub
		return this.approvalDao.findMyapply(pageNow,approval_schedule);
	}

	//根据审批进度查看我的申请
	public int findmshenqing(String approval_schedule) {
		// TODO Auto-generated method stub
		return this.approvalDao.findMyapply(approval_schedule);
	}

	//根据id查看我的申请
	public List<Apply> findapplyByid(int apply_id) {
		// TODO Auto-generated method stub
		return this.approvalDao.findapplyByid(apply_id);
	}

	//根据审批进度查看我的审批
	public List<Approval> findMyshenpi(int pageNow, String approval_schedule,
			String username) {
		// TODO Auto-generated method stub
		return this.approvalDao.findMyshenpi(pageNow,approval_schedule,username);
	}

	//根据审批进度查看我的审批
	public long findmyshenpi(String approval_schedule, String username) {
		// TODO Auto-generated method stub
		return this.approvalDao.findmyshenpi(approval_schedule,username);
	}

	//根据id查看我的审批
	public List<Approval> findmyshenpiByid(int approval_id) {
		// TODO Auto-generated method stub
		return this.approvalDao.findmyshenpiByid(approval_id);
	}

	//进行审批
	public void update(Approval app) {
		this.approvalDao.update(app);
	}

	//新建申请
	public void addMyapply(Apply app) {
		this.approvalDao.addMyapply(app);
		
	}

	@Override
	public void addappro(Approval apr) {
		this.approvalDao.addappro(apr);
	}

}
