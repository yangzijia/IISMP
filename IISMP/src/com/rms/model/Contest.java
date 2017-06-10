package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-27 下午9:03:34
 * @parameter  
 */
@Entity
public class Contest {

	private int contest_id;
	private String contest_title;
	private String contest_time;
	private String contest_place;
	private String project_name;
	private String project_member;
	private String project_info;
	private String project_awads;
	private String contest_experience;
	private String project_section;
	private String contest_info;
	private String contets_url;
	private String project_file;
	private String c_image;
	@Id
	@GeneratedValue
	public int getContest_id() {
		return contest_id;
	}
	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}
	public String getContest_title() {
		return contest_title;
	}
	public void setContest_title(String contest_title) {
		this.contest_title = contest_title;
	}
	public String getContest_time() {
		return contest_time;
	}
	public void setContest_time(String contest_time) {
		this.contest_time = contest_time;
	}
	public String getContest_place() {
		return contest_place;
	}
	public void setContest_place(String contest_place) {
		this.contest_place = contest_place;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_member() {
		return project_member;
	}
	public void setProject_member(String project_member) {
		this.project_member = project_member;
	}
	public String getProject_info() {
		return project_info;
	}
	public void setProject_info(String project_info) {
		this.project_info = project_info;
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
	public String getProject_section() {
		return project_section;
	}
	public void setProject_section(String project_section) {
		this.project_section = project_section;
	}
	public String getContest_info() {
		return contest_info;
	}
	public void setContest_info(String contest_info) {
		this.contest_info = contest_info;
	}
	public String getContets_url() {
		return contets_url;
	}
	public void setContets_url(String contets_url) {
		this.contets_url = contets_url;
	}
	
	public String getProject_file() {
		return project_file;
	}
	public void setProject_file(String project_file) {
		this.project_file = project_file;
	}
	public String getC_image() {
		return c_image;
	}
	public void setC_image(String c_image) {
		this.c_image = c_image;
	}
	
}
