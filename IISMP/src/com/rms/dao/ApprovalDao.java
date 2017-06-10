package com.rms.dao;

import java.util.List;

import com.rms.model.Apply;
import com.rms.model.Approval;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-11 下午6:55:43
 * @parameter  
 */
public interface ApprovalDao {
	//查看全部审批
	public  abstract List<Approval> findAllapproval();
	//查看全部审批数量
	public abstract int findAllappCount();
	//查看我的申请
	public abstract List<Apply> findAllapply(String m_username);
	//查看我的申请的数量
	public abstract int findAllapplyCount(String m_username);
	//查看我的审批（管理员）
	public abstract List<Approval> findApprovalBymyname(String m_username);
	//查看我的审批（管理员）
	public abstract long findmyAppCount(String m_username);
	//根据审批进度查看全部审批
	public abstract List<Approval> findAllshenpi(int pageNow,
			String approval_schedule);
	//根据审批进度查看全部审批
	public abstract int findAllshenpi(String approval_schedule);
	//根据审批进度查看我的申请
	public abstract int findMyapply(String approval_schedule);
	public abstract List<Apply> findMyapply(int pageNow,
			String approval_schedule);
	//根据id查看我的申请
	public abstract List<Apply> findapplyByid(int apply_id);
	//根据审批进度查看我的审批
	public abstract List<Approval> findMyshenpi(int pageNow,
			String approval_schedule, String username);
	//根据审批进度查看我的审批
	public abstract long findmyshenpi(String approval_schedule, String username);
	//根据id查看我的审批
	public abstract List<Approval> findmyshenpiByid(int approval_id);
	//进行审批
	public abstract void update(Approval app);
	//新建申请
	public abstract void addMyapply(Apply app);
	//新建申请
	public abstract void addappro(Approval apr);

}
