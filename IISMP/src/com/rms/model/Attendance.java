package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Attendance {
	private int a_id;
	private String a_datetime;
	private String a_check_in_time;
	private String a_check_out_time;
	private String time_difference;
	private String a_yueritime;
	private String a_nianyuetime;
	private int m_id;
	private String a_state;
	private String ipinfo_in;
	private String ipinfo_out;
	private String ipaddr_in;
	private String ipaddr_out;
	private String Shiftsection;
	private String ipstate;
	@Id
	@GeneratedValue
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_nianyuetime() {
		return a_nianyuetime;
	}
	public void setA_nianyuetime(String a_nianyuetime) {
		this.a_nianyuetime = a_nianyuetime;
	}
	public String getA_yueritime() {
		return a_yueritime;
	}
	public void setA_yueritime(String a_yueritime) {
		this.a_yueritime = a_yueritime;
	}
	public String getA_datetime() {
		return a_datetime;
	}
	public void setA_datetime(String a_datetime) {
		this.a_datetime = a_datetime;
	}
	public String getA_state() {
		return a_state;
	}
	public void setA_state(String a_state) {
		this.a_state = a_state;
	}
	public String getA_check_in_time() {
		return a_check_in_time;
	}
	public void setA_check_in_time(String a_check_in_time) {
		this.a_check_in_time = a_check_in_time;
	}
	public String getA_check_out_time() {
		return a_check_out_time;
	}
	public void setA_check_out_time(String a_check_out_time) {
		this.a_check_out_time = a_check_out_time;
	}
	public String getTime_difference() {
		return time_difference;
	}
	public void setTime_difference(String time_difference) {
		this.time_difference = time_difference;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getIpinfo_in() {
		return ipinfo_in;
	}
	public void setIpinfo_in(String ipinfo_in) {
		this.ipinfo_in = ipinfo_in;
	}
	public String getIpinfo_out() {
		return ipinfo_out;
	}
	public void setIpinfo_out(String ipinfo_out) {
		this.ipinfo_out = ipinfo_out;
	}
	public String getIpaddr_in() {
		return ipaddr_in;
	}
	public void setIpaddr_in(String ipaddr_in) {
		this.ipaddr_in = ipaddr_in;
	}
	public String getIpaddr_out() {
		return ipaddr_out;
	}
	public void setIpaddr_out(String ipaddr_out) {
		this.ipaddr_out = ipaddr_out;
	}
	public String getShiftsection() {
		return Shiftsection;
	}
	public void setShiftsection(String shiftsection) {
		Shiftsection = shiftsection;
	}
	public String getIpstate() {
		return ipstate;
	}
	public void setIpstate(String ipstate) {
		this.ipstate = ipstate;
	}
	
	
}
