package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AssessChart {
	private int id;
	private String assessname;
	private String as_starttime;
	private String as_endtime;
	private int m_id;
	private String operatorname;
	private String updatetime;
	private String updatetimeinfo;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAssessname() {
		return assessname;
	}
	public void setAssessname(String assessname) {
		this.assessname = assessname;
	}
	public String getAs_starttime() {
		return as_starttime;
	}
	public void setAs_starttime(String as_starttime) {
		this.as_starttime = as_starttime;
	}
	public String getAs_endtime() {
		return as_endtime;
	}
	public void setAs_endtime(String as_endtime) {
		this.as_endtime = as_endtime;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getUpdatetimeinfo() {
		return updatetimeinfo;
	}
	public void setUpdatetimeinfo(String updatetimeinfo) {
		this.updatetimeinfo = updatetimeinfo;
	}
	

}
