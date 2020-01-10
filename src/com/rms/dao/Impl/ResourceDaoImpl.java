package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.rms.dao.BaseDao;
import com.rms.dao.ResourceDao;
import com.rms.model.ResourceInfo;
import com.rms.model.Resource_Type;
@Component("resourceDao")
public class ResourceDaoImpl extends BaseDao implements ResourceDao{

	//查看资源类型
	public List<Resource_Type> findtype() {
		@SuppressWarnings("unchecked")
		List<Resource_Type> r = hibernateTemplate.find("from Resource_Type ");
		return r;
	}

	//增加文件库
	public void addRtype(Resource_Type rt) {
		hibernateTemplate.save(rt);
		
	}


	//根据id查找资源库
	public List<Resource_Type> findtypeByid(int rt_id) {
		@SuppressWarnings("unchecked")
		List<Resource_Type> r = hibernateTemplate.find("from Resource_Type  where rt_id = '"+rt_id+"'");
		return r;
	}


	//根据id删除资源库
	public void deleteRTbyid(Resource_Type ret) {
	hibernateTemplate.delete(ret);
		
	}


	//查看全部资源
	public List<ResourceInfo> findreinfo(int pageNow) {
		String sql = "from ResourceInfo";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<ResourceInfo> an = query.list();
		session.close();
		return an;
	}



	//根据资料id进行查找
	public List<ResourceInfo> findrinfo(int resource_id) {
		@SuppressWarnings("unchecked")
		List<ResourceInfo> r = hibernateTemplate
				.find("from ResourceInfo where resource_id='"+resource_id+"'");
		return r;
	
	}


	//根据资料id进行删除
	public void deleterebyid(ResourceInfo re) {
		hibernateTemplate.delete(re);
		
	}


	//上传资源
	public boolean upload(ResourceInfo re) {
			hibernateTemplate.save(re);
			return true;
	}


	//根据资源库id查看资源
	@Override
	public List<ResourceInfo> findrinfoByrt(int pageNow,int rt_id) {
System.out.println(rt_id);
		String sql="";
		if(rt_id==0){
			sql = "from ResourceInfo";
		}else{
			sql="from ResourceInfo where rt_id='"+rt_id+"'";
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<ResourceInfo> an = query.list();
		session.close();
		return an;
	}



	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findreamount(int)
	 */
	@Override
	public int findreamount(int id) {
		@SuppressWarnings("unchecked")
		List<ResourceInfo> r = hibernateTemplate
				.find("from ResourceInfo where rt_id='"+id+"'");
		int m=r.size();
		return m;
	}

	
	@Override
	public void edittype(Resource_Type tt) {
		hibernateTemplate.update(tt);
	}



	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findreinfo2()
	 */
	@Override
	public List<ResourceInfo> findreinfo2() {
		@SuppressWarnings("unchecked")
		List<ResourceInfo> r = hibernateTemplate.find("from ResourceInfo ");
	
		return r;
	}



	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findtyByid(int)
	 */
	@Override
	public List<Resource_Type> findtyByid(int id) {
		@SuppressWarnings("unchecked")
		List<Resource_Type> r = hibernateTemplate.find("from Resource_Type  where rt_id = '"+id+"'");
		return r;
	}



	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findAllres()
	 */
	@Override
	public int findAllres() {
		@SuppressWarnings("unchecked")
		List<ResourceInfo> r = hibernateTemplate.find("from ResourceInfo ");
		int sum=r.size();
		return sum;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findallresByrt(int)
	 */
	@Override
	public int findallresByrt(int rt_id) {
		String sql = "";
		if(rt_id==0){
			sql = "from ResourceInfo";
		}else{
			sql = "from ResourceInfo where rt_id='"+rt_id+"'";
		}
		@SuppressWarnings("unchecked")
		List<ResourceInfo> r = hibernateTemplate.find(sql);
		int sum=r.size();
		return sum;
		
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findrtbyid(int)
	 */
	@Override
	public List<Resource_Type> findrtbyid(int rt_id) {
		@SuppressWarnings("unchecked")
		List<Resource_Type> r = hibernateTemplate.find("from Resource_Type  where rt_id = '"+rt_id+"'");
		return r;
	}

	/* (non-Javadoc)
	 * @see com.rms.dao.ResourceDao#findall(int)
	 */
	@Override
	public List<ResourceInfo> findall(int rt_id) {
		@SuppressWarnings("unchecked")
		List<ResourceInfo> r = hibernateTemplate
				.find("from ResourceInfo where rt_id='"+rt_id+"'");
		return r;
	}

	/**
	 * 更新资源库的方法
	 * @throws Exception
	 */
	public void updateRestype(Resource_Type rt) {
		hibernateTemplate.update(rt);
	}



	

}
