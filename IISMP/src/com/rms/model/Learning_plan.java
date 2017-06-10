package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Learning_plan {
	private int id;
	private String ltitle;
	private String lcontent;
	private String lsummarize;
	private String lstarttime;
	private String lendtime;
	private String ldaylong;
	private int m_id;
	private String username;
	private String sectionname;
	private String lfilename;
	private String updatetime;
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
	public String getLdaylong() {
		return ldaylong;
	}
	public void setLdaylong(String ldaylong) {
		this.ldaylong = ldaylong;
	}
	public String getLtitle() {
		return ltitle;
	}
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
	public String getLcontent() {
		return lcontent;
	}
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}
	public String getLsummarize() {
		return lsummarize;
	}
	public void setLsummarize(String lsummarize) {
		this.lsummarize = lsummarize;
	}
	public String getLstarttime() {
		return lstarttime;
	}
	public void setLstarttime(String lstarttime) {
		this.lstarttime = lstarttime;
	}
	public String getLendtime() {
		return lendtime;
	}
	public void setLendtime(String lendtime) {
		this.lendtime = lendtime;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getLfilename() {
		return lfilename;
	}
	public void setLfilename(String lfilename) {
		this.lfilename = lfilename;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	
}
