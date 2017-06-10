package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-9 下午9:55:45
 * @parameter  审批
 */
@Entity
public class Approval {

	private int approval_id;
	private String approval_type;
	private String apply_time;
	private String apply_member;
	private String apply_info;
	private String approval_time;
	private String approval_member;
	private String approval_section;
	private String approval_schedule;//审批进度
	private String approval_info;
	private String apply_resource;
	@Id
	@GeneratedValue
	
	public int getApproval_id() {
		return approval_id;
	}
	public void setApproval_id(int approval_id) {
		this.approval_id = approval_id;
	}
	public String getApproval_type() {
		return approval_type;
	}
	public void setApproval_type(String approval_type) {
		this.approval_type = approval_type;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getApproval_time() {
		return approval_time;
	}
	public void setApproval_time(String approval_time) {
		this.approval_time = approval_time;
	}
	public String getApproval_member() {
		return approval_member;
	}
	public void setApproval_member(String approval_member) {
		this.approval_member = approval_member;
	}
	public String getApproval_section() {
		return approval_section;
	}
	public void setApproval_section(String approval_section) {
		this.approval_section = approval_section;
	}
	public String getApproval_schedule() {
		return approval_schedule;
	}
	public void setApproval_schedule(String approval_schedule) {
		this.approval_schedule = approval_schedule;
	}
	public String getApply_member() {
		return apply_member;
	}
	public void setApply_member(String apply_member) {
		this.apply_member = apply_member;
	}
	public String getApply_info() {
		return apply_info;
	}
	public void setApply_info(String apply_info) {
		this.apply_info = apply_info;
	}
	public String getApproval_info() {
		return approval_info;
	}
	public void setApproval_info(String approval_info) {
		this.approval_info = approval_info;
	}
	/**dong
	 * @return the apply_resource
	 */
	public String getApply_resource() {
		return apply_resource;
	}
	/**
	 * @param apply_resource the apply_resource to set
	 */
	public void setApply_resource(String apply_resource) {
		this.apply_resource = apply_resource;
	}
	
	
}
