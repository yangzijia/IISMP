package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.Equipment_Info;
import com.rms.service.BaseService;
import com.rms.service.EquipmentService;
@Component("equipmentService")
public class EquipmentServiceImpl extends BaseService implements EquipmentService{

	/*查看设备信息
	 * */
	public List<Equipment_Info> findAll(int pageNow) {
		
		return this.equipmentDao.findAll(pageNow);
	}

	/*查看设备信息数量
	 * */
	public int findAllCount() {
		
		return this.equipmentDao.finAllCount();
	}
	//根据id查看设备信息
	public List<Equipment_Info> findEbyid(int e_id) {
		return this.equipmentDao.findEbyid(e_id);
	}

	//保存修改信息
	public void update(Equipment_Info e) {
		
		this.equipmentDao.update(e);
	}

	//查询所有设备（用于导航栏显示名称）
	public List<Equipment_Info> findAllname() {
	
		return this.equipmentDao.findAllname();
	}

	//添加设备
	public void addequip(Equipment_Info ement) {
		 this.equipmentDao.addequip(ement);
	}

	//删除设备
	public void deleteEbyid(Equipment_Info ement) {
		 this.equipmentDao.deleteEbyid(ement);
		
	}

	

}
