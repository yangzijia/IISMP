package com.rms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="anno_Sendee")
public class Anno_Sendee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer m_id;    //接收人id
	private int state;   //接收人是否查看   没有为1,   看了为2
	
	private int an_id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getAn_id() {
		return an_id;
	}
	public void setAn_id(int an_id) {
		this.an_id = an_id;
	}
	
}
