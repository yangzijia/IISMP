package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MembershipInfo {
	private int m_id;
	private String m_username;
	private String m_sex;
	private String m_password;
	private String m_classname;//班级
	private String m_utpitp;   //以前参加的项目
	private String m_phone;	
	private String m_entermiictime;//加入科研室时间
	private String m_email;
	private String m_qqchat;
	private String m_truename;
	private String m_role;
	private String m_sectionname;
	private int role_num;
	private String m_state;
	private String m_userpicture;
	@Id
	@GeneratedValue
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_userpicture() {
		return m_userpicture;
	}
	public void setM_userpicture(String m_userpicture) {
		this.m_userpicture = m_userpicture;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public String getM_sex() {
		return m_sex;
	}
	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_classname() {
		return m_classname;
	}
	public void setM_classname(String m_classname) {
		this.m_classname = m_classname;
	}
	public String getM_utpitp() {
		return m_utpitp;
	}
	public void setM_utpitp(String m_utpitp) {
		this.m_utpitp = m_utpitp;
	}
	public String getM_phone() {
		return m_phone;
	}
	public int getRole_num() {
		return role_num;
	}
	public void setRole_num(int role_num) {
		this.role_num = role_num;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_entermiictime() {
		return m_entermiictime;
	}
	public void setM_entermiictime(String m_entermiictime) {
		this.m_entermiictime = m_entermiictime;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_qqchat() {
		return m_qqchat;
	}
	public void setM_qqchat(String m_qqchat) {
		this.m_qqchat = m_qqchat;
	}
	public String getM_truename() {
		return m_truename;
	}
	public void setM_truename(String m_truename) {
		this.m_truename = m_truename;
	}
	public String getM_role() {
		return m_role;
	}
	public void setM_role(String m_role) {
		this.m_role = m_role;
	}
	public String getM_sectionname() {
		return m_sectionname;
	}
	public void setM_sectionname(String m_sectionname) {
		this.m_sectionname = m_sectionname;
	}
	public String getM_state() {
		return m_state;
	}
	public void setM_state(String m_state) {
		this.m_state = m_state;
	}
	
	
}
