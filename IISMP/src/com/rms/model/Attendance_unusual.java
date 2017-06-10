package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Attendance_unusual {
	private int id;
	private int applyuser_id;
	private int operator_id;
	private String remark;
	private String beforestate;
	private String afterstate;
	private String datetime;
	private String dtime;
	private String time;
	private String now_week;
	private String atten_week;
	private String check_in_out_time;
	private int state;      //处理状态   1表示未处理      2表示已处理
	private String timeinfo;
	private String attendanceshift;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplyuser_id() {
		return applyuser_id;
	}
	public void setApplyuser_id(int applyuser_id) {
		this.applyuser_id = applyuser_id;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNow_week() {
		return now_week;
	}
	public void setNow_week(String now_week) {
		this.now_week = now_week;
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
	public String getAttendanceshift() {
		return attendanceshift;
	}
	public void setAttendanceshift(String attendanceshift) {
		this.attendanceshift = attendanceshift;
	}
	
}
