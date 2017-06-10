package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shift {
	private int id;
	private String check_in_time_hour;
	private String check_in_time_minute;
	private String check_out_time_hour;
	private String check_out_time_minute;
	private String elas_time;    //弹性时间
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheck_in_time_hour() {
		return check_in_time_hour;
	}
	public void setCheck_in_time_hour(String check_in_time_hour) {
		this.check_in_time_hour = check_in_time_hour;
	}
	public String getCheck_in_time_minute() {
		return check_in_time_minute;
	}
	public void setCheck_in_time_minute(String check_in_time_minute) {
		this.check_in_time_minute = check_in_time_minute;
	}
	public String getCheck_out_time_hour() {
		return check_out_time_hour;
	}
	public void setCheck_out_time_hour(String check_out_time_hour) {
		this.check_out_time_hour = check_out_time_hour;
	}
	public String getCheck_out_time_minute() {
		return check_out_time_minute;
	}
	public void setCheck_out_time_minute(String check_out_time_minute) {
		this.check_out_time_minute = check_out_time_minute;
	}
	public String getElas_time() {
		return elas_time;
	}
	public void setElas_time(String elas_time) {
		this.elas_time = elas_time;
	}
	

}
