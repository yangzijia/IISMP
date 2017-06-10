package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Assess {
	
	private int id;
	private String sectionname;
	private int kaoqin;
	private int biaoxian;
	private int xiangmu;
	private int xinde;
	private int heji;
	private String remark;
	private String updatetime;
	private int ac_id;
	private String username;   //被评估人姓名
	private int user_id;       //被评估人id
	private int operator_id;   //操作人的id   assessoperator
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public int getKaoqin() {
		return kaoqin;
	}
	public void setKaoqin(int kaoqin) {
		this.kaoqin = kaoqin;
	}
	public int getBiaoxian() {
		return biaoxian;
	}
	public void setBiaoxian(int biaoxian) {
		this.biaoxian = biaoxian;
	}
	public int getXiangmu() {
		return xiangmu;
	}
	public void setXiangmu(int xiangmu) {
		this.xiangmu = xiangmu;
	}
	public int getXinde() {
		return xinde;
	}
	public void setXinde(int xinde) {
		this.xinde = xinde;
	}
	public int getHeji() {
		return heji;
	}
	public void setHeji(int heji) {
		this.heji = heji;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
}
