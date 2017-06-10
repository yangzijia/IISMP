package com.rms.dao;

import java.util.List;

import com.rms.model.Equipment_Info;


public interface EquipmentDao {
	/*查看设备信息
	 * */
	public abstract List<Equipment_Info> findAll(int pageNow);
	/*查看设备信息数量
	 * */
	public abstract int finAllCount();
	
	//查看设备信息
	public abstract List<Equipment_Info> findEbyid(int e_id);
	//保存修改信息
	public abstract void update(Equipment_Info e);
	//查询所有设备
	public abstract List<Equipment_Info> findAllname();
	//增加设备
	public abstract void addequip(Equipment_Info ement);
	//删除设备
	public abstract void deleteEbyid(Equipment_Info ement);

}
