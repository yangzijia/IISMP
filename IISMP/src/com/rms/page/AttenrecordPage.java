package com.rms.page;

public class AttenrecordPage {

	private int id;
	private String applyusername;
	private String remark;
	private String beforestate;
	private String afterstate;
	private String datetime;
	private String dtime;
	private String time;
	private String atten_week;
	private String check_in_out_time;
	private int state;      //处理状态   1表示未处理      2表示已处理
	private String timeinfo;
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
	public String getApplyusername() {
		return applyusername;
	}
	public void setApplyusername(String applyusername) {
		this.applyusername = applyusername;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBeforestate() {
		return beforestate;
	}
	public void setBeforestate(String beforestate) {
		this.beforestate = beforestate;
	}
	public String getAfterstate() {
		return afterstate;
	}
	public void setAfterstate(String afterstate) {
		this.afterstate = afterstate;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAtten_week() {
		return atten_week;
	}
	public void setAtten_week(String atten_week) {
		this.atten_week = atten_week;
	}
	public String getCheck_in_out_time() {
		return check_in_out_time;
	}
	public void setCheck_in_out_time(String check_in_out_time) {
		this.check_in_out_time = check_in_out_time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getTimeinfo() {
		return timeinfo;
	}
	public void setTimeinfo(String timeinfo) {
		this.timeinfo = timeinfo;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
}
