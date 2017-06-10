package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-27 下午9:10:50
 * @parameter  
 */
@Entity
public class Project {
private int project_id;
private String project_name;
private String project_principal;
private String section_name;
private String project_info;
private String project_uptime;
private String project_member;
private String project_awads;
private String contest_experience;
private String project_file;

@Id
@GeneratedValue

public int getProject_id() {
	return project_id;
}
public void setProject_id(int project_id) {
	this.project_id = project_id;
}
public String getProject_name() {
	return project_name;
}
public void setProject_name(String project_name) {
	this.project_name = project_name;
}
public String getProject_principal() {
	return project_principal;
}
public void setProject_principal(String project_principal) {
	this.project_principal = project_principal;
}
public String getSection_name() {
	return section_name;
}
public void setSection_name(String section_name) {
	this.section_name = section_name;
}
public String getProject_info() {
	return project_info;
}
public void setProject_info(String project_info) {
	this.project_info = project_info;
}
public String getProject_uptime() {
	return project_uptime;
}
public void setProject_uptime(String project_uptime) {
	this.project_uptime = project_uptime;
}
public String getProject_member() {
	return project_member;
}
public void setProject_member(String project_member) {
	this.project_member = project_member;
}
public String getProject_awads() {
	return project_awads;
}
public void setProject_awads(String project_awads) {
	this.project_awads = project_awads;
}
public String getContest_experience() {
	return contest_experience;
}
public void setContest_experience(String contest_experience) {
	this.contest_experience = contest_experience;
}
public String getProject_file() {
	return project_file;
}
public void setProject_file(String project_file) {
	this.project_file = project_file;
}

}
