package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resource_Type {
	private int rt_id;
	private String rt_name;
	private String rt_remark;
	private String rt_issuer;
	private String rt_updatime;
	private int re_amount;
	
	
	@Id
	@GeneratedValue
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}
	
	public String getRt_name() {
		return rt_name;
	}
	public void setRt_name(String rt_name) {
		this.rt_name = rt_name;
	}
	public String getRt_remark() {
		return rt_remark;
	}
	public void setRt_remark(String rt_remark) {
		this.rt_remark = rt_remark;
	}
	public String getRt_issuer() {
		return rt_issuer;
	}
	public void setRt_issuer(String rt_issuer) {
		this.rt_issuer = rt_issuer;
	}
	public String getRt_updatime() {
		return rt_updatime;
	}
	public void setRt_updatime(String rt_updatime) {
		this.rt_updatime = rt_updatime;
	}
	public int getRe_amount() {
		return re_amount;
	}
	public void setRe_amount(int re_amount) {
		this.re_amount = re_amount;
	}
	
	
}
