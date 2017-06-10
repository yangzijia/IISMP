package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Learning_Log {
	private int l_id;
	private String l_subject;//题目
	private String l_content;//内容
	private String l_time;
	private String l_state;//状态
	private String lt_name;
	private int lt_id;
	private int l_zan;//点赞
	private String l_comment;//评论
	private String l_member;
	private String l_purview;//权限
	@Id
	@GeneratedValue
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public String getL_subject() {
		return l_subject;
	}
	public void setL_subject(String l_subject) {
		this.l_subject = l_subject;
	}
	public String getL_content() {
		return l_content;
	}
	public void setL_content(String l_content) {
		this.l_content = l_content;
	}
	public String getL_time() {
		return l_time;
	}
	public void setL_time(String l_time) {
		this.l_time = l_time;
	}
	
	/**dong
	 * @return the l_state
	 */
	public String getL_state() {
		return l_state;
	}
	/**
	 * @param l_state the l_state to set
	 */
	public void setL_state(String l_state) {
		this.l_state = l_state;
	}
	/**dong
	 * @return the lt_type
	 */
	/**dong
	 * @return the lt_name
	 */
	public String getLt_name() {
		return lt_name;
	}
	/**
	 * @param lt_name the lt_name to set
	 */
	public void setLt_name(String lt_name) {
		this.lt_name = lt_name;
	}
	/**dong
	 * @return the lt_id
	 */
	public int getLt_id() {
		return lt_id;
	}
	/**
	 * @param lt_id the lt_id to set
	 */
	public void setLt_id(int lt_id) {
		this.lt_id = lt_id;
	}
	/**dong
	 * @return the l_zan
	 */
	public int getL_zan() {
		return l_zan;
	}
	/**
	 * @param l_zan the l_zan to set
	 */
	public void setL_zan(int l_zan) {
		this.l_zan = l_zan;
	}
	/**dong
	 * @return the l_comment
	 */
	public String getL_comment() {
		return l_comment;
	}
	/**
	 * @param l_comment the l_comment to set
	 */
	public void setL_comment(String l_comment) {
		this.l_comment = l_comment;
	}
	/**dong
	 * @return the l_member
	 */
	public String getL_member() {
		return l_member;
	}
	/**
	 * @param l_member the l_member to set
	 */
	public void setL_member(String l_member) {
		this.l_member = l_member;
	}
	/**dong
	 * @return the l_purview
	 */
	public String getL_purview() {
		return l_purview;
	}
	/**
	 * @param l_purview the l_purview to set
	 */
	public void setL_purview(String l_purview) {
		this.l_purview = l_purview;
	}
	
		
	

}
