package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.rms.dao.ApprovalDao;
import com.rms.dao.BaseDao;
import com.rms.model.Apply;
import com.rms.model.Approval;


/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-11 下午6:57:31
 * @parameter  
 */
@Repository
@Component("approvalDao")
public class ApprovalDaoImpl extends BaseDao implements ApprovalDao{

	//查看全部审批
	public List<Approval> findAllapproval() {
		@SuppressWarnings("unchecked")
		List<Approval> app= hibernateTemplate.find("from Approval order by approval_id asc");
		return app;	
	}

	//查看全部审批数量
	public int findAllappCount() {
		@SuppressWarnings("unchecked")
		List<Approval> app= hibernateTemplate.find("from Approval ");
		int count=app.size();
		return count;
	}

	//查看我的申请
	public List<Apply> findAllapply(String m_username) {
		@SuppressWarnings("unchecked")
		List<Apply> app= hibernateTemplate.find
				("from Apply where apply_member='"+m_username+"'	order by apply_id asc");
		return app;	
	}

	//查看我的申请的数量
	public int findAllapplyCount(String m_username) {
		@SuppressWarnings("unchecked")
		List<Apply> app= hibernateTemplate.find
				("from Apply where apply_member='"+m_username+"'	order by apply_id asc");
		int count =app.size();
		return count;
	}

	//查看我的审批（管理员）
	public List<Approval> findApprovalBymyname(String m_username) {
		@SuppressWarnings("unchecked")
		List<Approval> app= hibernateTemplate.find
				("from Approval where approval_member='"+m_username+"'	order by approval_id asc");
		return app;	
	}

	//查看我的审批（管理员）
	public long findmyAppCount(String m_username) {
		@SuppressWarnings("unchecked")
		List<Approval> app= hibernateTemplate.find
				("from Approval where approval_member='"+m_username+"'	");
		int count =app.size();
		return count;
	}

	//根据审批进度查看全部审批
	public List<Approval> findAllshenpi(int pageNow, String approval_schedule) {
		String sql="";
		if(approval_schedule.equals("未审批")){
			sql= "from Approval where   approval_schedule='未审批' order by approval_id desc";
		}else if(approval_schedule.equals("已审批")){
			sql= "from Approval where   approval_schedule='已审批' order by approval_id desc";
		}else if(approval_schedule.equals("审批中")){
			sql= "from Approval where   approval_schedule='审批中' order by approval_id desc";
		}else{
			sql= "from Approval  order by approval_id desc";	
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Approval> app =  query.list();		
		session.close();
		return app;
	}

	//根据审批进度查看全部审批
	public int findAllshenpi(String approval_schedule) {
		String sql="";
		if(approval_schedule.equals("未审批")){
			sql= "from Approval where   approval_schedule='未审批' order by approval_id desc";
		}else if(approval_schedule.equals("已审批")){
			sql= "from Approval where   approval_schedule='已审批' order by approval_id desc";
		}else if(approval_schedule.equals("审批中")){
			sql= "from Approval where   approval_schedule='审批中' order by approval_id desc";
		}else{
			sql= "from Approval  order by approval_id desc";	
		}
		@SuppressWarnings("unchecked")
		List<Approval> msi = hibernateTemplate.find(sql);
		int count=msi.size();
		return count;
	}

	//根据审批进度查看我的申请
	public int findMyapply(String approval_schedule) {
		String sql="";
		if(approval_schedule.equals("未审批")){
			sql= "from Apply where   approval_schedule='未审批' order by apply_id desc";
		}else if(approval_schedule.equals("已审批")){
			sql= "from Apply where   approval_schedule='已审批' order by apply_id desc";
		}else if(approval_schedule.equals("审批中")){
			sql= "from Apply where   approval_schedule='审批中' order by apply_id desc";
		}else{
			sql= "from Apply  order by apply_id desc";	
		}
		
		@SuppressWarnings("unchecked")
		List<Apply> app =  hibernateTemplate.find(sql);
		int count=app.size();
		return count;
	}

	//根据审批进度查看我的申请
	public List<Apply> findMyapply(int pageNow, String approval_schedule) {
		String sql="";
		if(approval_schedule.equals("未审批")){
			sql= "from Apply where   approval_schedule='未审批' order by apply_id desc";
		}else if(approval_schedule.equals("已审批")){
			sql= "from Apply where   approval_schedule='已审批' order by apply_id desc";
		}else if(approval_schedule.equals("审批中")){
			sql= "from Apply where   approval_schedule='审批中' order by apply_id desc";
		}else{
			sql= "from Apply  order by apply_id desc";	
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Apply> app =  query.list();		
		session.close();
		return app;
	}

	//根据id查看我的申请
	public List<Apply> findapplyByid(int apply_id) {
		@SuppressWarnings("unchecked")
		List<Apply> myapply=hibernateTemplate.find("from Apply where apply_id='"+apply_id+"'");
		return myapply;
	}

	//根据审批进度查看我的审批
	public List<Approval> findMyshenpi(int pageNow, String approval_schedule,
			String username) {
		String sql="";
		if(approval_schedule.equals("未审批")){
			sql= "from Approval where   approval_schedule='未审批' and aaproval_member='"+username+"' order by approval_id desc";
		}else if(approval_schedule.equals("已审批")){
			sql= "from Approval where   approval_schedule='已审批'  and aaproval_member='"+username+"' order by approval_id desc";
		}else if(approval_schedule.equals("审批中")){
			sql= "from Approval where   approval_schedule='审批中'  and aaproval_member='"+username+"' order by approval_id desc";
		}else{
			sql= "from Approval where aaproval_member='"+username+"' order by approval_id desc";	
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Approval> app =  query.list();		
		session.close();
		return app;
	}

	//根据审批进度查看我的审批
	public long findmyshenpi(String approval_schedule, String username) {
		String sql="";
		if(approval_schedule.equals("未审批")){
			sql= "from Approval where   approval_schedule='未审批' and aaproval_member='"+username+"' order by approval_id desc";
		}else if(approval_schedule.equals("已审批")){
			sql= "from Approval where   approval_schedule='已审批'  and aaproval_member='"+username+"' order by approval_id desc";
		}else if(approval_schedule.equals("审批中")){
			sql= "from Approval where   approval_schedule='审批中'  and aaproval_member='"+username+"' order by approval_id desc";
		}else{
			sql= "from Approval where aaproval_member='"+username+"' order by approval_id desc";	
		}
		@SuppressWarnings("unchecked")
		List<Approval> app =  hibernateTemplate.find(sql);
		int count=app.size();
		return count;
	}

	//根据id查看我的审批
	public List<Approval> findmyshenpiByid(int approval_id) {
		@SuppressWarnings("unchecked")
		List<Approval> app=hibernateTemplate.find("from Approval where approval_id='"+approval_id+"' order by approval_id asc");
		return app;
	}

	//进行审批
	public void update(Approval app) {
	
		hibernateTemplate.update(app);
	}

	//新建申请
	public void addMyapply(Apply app) {
		hibernateTemplate.save(app);
	}

	//新建审批
	public void addappro(Approval apr) {
		hibernateTemplate.save(apr);
	}

}
