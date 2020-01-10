package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rms.dao.BaseDao;
import com.rms.dao.EquipmentDao;
import com.rms.model.Equipment_Info;

@Component("equipmentDao")
public class EquipmentDaoImpl extends BaseDao implements EquipmentDao{
	/*查看全部设备信息
	 * 
	 * */
	public List<Equipment_Info> findAll(int pageNow) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Equipment_Info order by e_id desc");
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Equipment_Info> an = query.list();
		session.close();
		return an;
	}

	/*查看设备信息数量
	 * */
	public int finAllCount() {
		@SuppressWarnings("unchecked")
		List<Equipment_Info> an = hibernateTemplate.find(" from Equipment_Info  ");
		
		if(an != null && an.size() >0){
			int row = an.size();
			return row;
		}
		return 0;
	}
	
	
	
	public List<Equipment_Info> findEbyid(int e_id) {
		@SuppressWarnings("unchecked")
		List<Equipment_Info> ef = hibernateTemplate
				.find("from Equipment_Info as e where e.e_id = '"+e_id+"'");
		if(ef != null && ef.size() >0){
			return ef;
		}
		return null;
	}
	//保存修改信息
	public void update(Equipment_Info e) {
	
			hibernateTemplate.update(e);
	
	}

	@Override
	public List<Equipment_Info> findAllname() {
		@SuppressWarnings("unchecked")
		List<Equipment_Info> ef = hibernateTemplate
				.find("from Equipment_Info");
		if(ef != null && ef.size() >0){
			return ef;
		}
		return null;
	}

	//增加设备
	public void addequip(Equipment_Info ement) {
		hibernateTemplate.save(ement);
		
	}

	//删除设备
	public void deleteEbyid(Equipment_Info ement) {
		hibernateTemplate.delete(ement);
		
	}




}
