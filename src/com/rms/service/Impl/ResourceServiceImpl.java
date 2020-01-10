package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;


import com.rms.model.ResourceInfo;
import com.rms.model.Resource_Type;
import com.rms.service.BaseService;
import com.rms.service.ResourceService;
@Component("resourceService")
public class ResourceServiceImpl extends BaseService implements ResourceService{

	

	//查看资料类型
	public List<Resource_Type> findtype() {
		// TODO Auto-generated method stub
		return this.resourceDao.findtype();
	}

	

	@Override
	public boolean upload(ResourceInfo re) {
		
		return this.resourceDao.upload(re);
	}

	//增加文件库
	public void addRtype(Resource_Type rt) {
	this.resourceDao.addRtype(rt);
	}

	//根据id查找资源库
	public List<Resource_Type> findtypeByid(int rt_id) {
		
		return this.resourceDao.findtypeByid(rt_id);
	}


	//根据id删除资源库
	public void deleteRTbyid(Resource_Type ret) {
		this.resourceDao.deleteRTbyid(ret);
		
	}

	//查看不在文件夹下的资源
	public List<ResourceInfo> findreinfo(int pageNow) {
		// TODO Auto-generated method stub
		return this.resourceDao.findreinfo(pageNow);
	}

	
	//根据资料id进行查找
	public List<ResourceInfo> findrinfo(int resource_id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findrinfo(resource_id);
	}

	//根据资料id进行删除
	public void deleterebyid(ResourceInfo re) {
		this.resourceDao.deleterebyid(re);
		
	}

	//根据资源库id查看资料
	public List<ResourceInfo> findrinfoByrt(int pageNow,int rt_id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findrinfoByrt(pageNow,rt_id);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findreamount(int)
	 */
	@Override
	public int findreamount(int id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findreamount(id);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#edittype(com.rms.model.Resource_Type)
	 */
	@Override
	public void edittype(Resource_Type tt) {
		// TODO Auto-generated method stub
		this.resourceDao.edittype(tt);
	}

	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findreinfo2()
	 */
	@Override
	public List<ResourceInfo> findreinfo2() {
		// TODO Auto-generated method stub
		return this.resourceDao.findreinfo2();
	}

	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findtyByid(int)
	 */
	@Override
	public List<Resource_Type> findtyByid(int id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findtyByid(id);
	}



	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findAllres()
	 */
	@Override
	public int findAllres() {
		// TODO Auto-generated method stub
		return this.resourceDao.findAllres();
	}



	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findallresByrt(int)
	 */
	@Override
	public int findallresByrt(int rt_id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findallresByrt(rt_id);
	}



	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findrtbyid(int)
	 */
	@Override
	public List<Resource_Type> findrtbyid(int rt_id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findrtbyid(rt_id);
	}



	/* (non-Javadoc)
	 * @see com.rms.service.ResourceService#findallres(int)
	 */
	@Override
	public List<ResourceInfo> findallres(int rt_id) {
		// TODO Auto-generated method stub
		return this.resourceDao.findall(rt_id);
	}

	/**
	 * 更新资源库的方法
	 * @throws Exception
	 */
	public void updateRestype(Resource_Type rt) {
		resourceDao.updateRestype(rt);
	}
	
	
}
