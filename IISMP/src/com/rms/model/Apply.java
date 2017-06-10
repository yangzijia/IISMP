package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-11 下午9:18:14
 * @parameter  
 */
@Entity
public class Apply {
	private int apply_id;
	private String apply_member;
	private String apply_time;
	private String apply_info;
	private String member_section;	
	
	private String approval_type;
	private String approval_schedule;
	private String approval_member;
	private String approval_time;
	@Id
	@GeneratedValue
	public int getApply_id() {
		return apply_id;
	}
	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
	}
	public String getApply_member() {
		return apply_member;
	}
	public void setApply_member(String apply_member) {
		this.apply_member = apply_member;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getApproval_type() {
		return approval_type;
	}
	public void setApproval_type(String approval_type) {
		this.approval_type = approval_type;
	}
	public String getApproval_schedule() {
		return approval_schedule;
	}
	public void setApproval_schedule(String approval_schedule) {
		this.approval_schedule = approval_schedule;
	}
	public String getApproval_member() {
		return approval_member;
	}
	public void setApproval_member(String approval_member) {
		this.approval_member = approval_member;
	}
	public String getApproval_time() {
		return approval_time;
	}
	public void setApproval_time(String approval_time) {
		this.approval_time = approval_time;
	}
	public String getApply_info() {
		return apply_info;
	}
	public void setApply_info(String apply_info) {
		this.apply_info = apply_info;
	}
	public String getMember_section() {
		return member_section;
	}
	public void setMember_section(String member_section) {
		this.member_section = member_section;
	}

	
	
	
}
