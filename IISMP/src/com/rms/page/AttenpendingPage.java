package com.rms.page;

public class AttenpendingPage {

	private int id;
	private String username;
	private String operatorname;
	private String datetime;
	private String week;
	private String state;
	private String afterstate;
	private int statenum;
	private String check_in_out_info;
	private int m_id;
	private String shiftsection;
	
	
	public String getShiftsection() {
		return shiftsection;
	}
	public void setShiftsection(String shiftsection) {
		this.shiftsection = shiftsection;
	}
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
	public String getAfterstate() {
		return afterstate;
	}
	public void setAfterstate(String afterstate) {
		this.afterstate = afterstate;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getCheck_in_out_info() {
		return check_in_out_info;
	}
	public void setCheck_in_out_info(String check_in_out_info) {
		this.check_in_out_info = check_in_out_info;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getStatenum() {
		return statenum;
	}
	public void setStatenum(int statenum) {
		this.statenum = statenum;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
}
