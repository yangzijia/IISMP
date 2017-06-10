package com.rms.service;

import java.util.List;

import com.rms.model.Equipment_Info;


public interface EquipmentService {

	/*查看设备信息
	 * */
	public abstract List<Equipment_Info> findAll(int pageNow);
	/*查看设备信息数量
	 * */
	public abstract int findAllCount();

	public abstract List<Equipment_Info> findEbyid(int e_id);
	//查询所有设备名称
	public abstract List<Equipment_Info> findAllname();
	//添加设备
	public abstract void addequip(Equipment_Info ement);
	//删除设备
	public abstract void deleteEbyid(Equipment_Info ement);
	//保存编辑过后的信息
	public abstract void update(Equipment_Info e);

}
