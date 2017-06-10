package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-6 下午8:47:11
 * @parameter  
 */
@Entity
public class Learning_project {
	private int project_id;
	private String project_title;
	private String project_type;
	private String project_starttime;
	private String project_endtime;
	private String project_updatetime;
	private String m_username;
	@Id
	@GeneratedValue
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}

	public String getProject_starttime() {
		return project_starttime;
	}
	public void setProject_starttime(String project_starttime) {
		this.project_starttime = project_starttime;
	}
	public String getProject_endtime() {
		return project_endtime;
	}
	public void setProject_endtime(String project_endtime) {
		this.project_endtime = project_endtime;
	}
	public String getProject_updatetime() {
		return project_updatetime;
	}
	public void setProject_updatetime(String project_updatetime) {
		this.project_updatetime = project_updatetime;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	
}
