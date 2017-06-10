/**
 * 
 */
package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author dong
 *2017-3-27
 * 
 */
@Entity
public class Log_type {
	private int lt_id;
	private String lt_name;
	private String lt_remark;
	private String lt_time;
	
	
	@Id
	@GeneratedValue
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
	 * @return the lt_remark
	 */
	public String getLt_remark() {
		return lt_remark;
	}
	/**
	 * @param lt_remark the lt_remark to set
	 */
	public void setLt_remark(String lt_remark) {
		this.lt_remark = lt_remark;
	}
	/**dong
	 * @return the lt_time
	 */
	public String getLt_time() {
		return lt_time;
	}
	/**
	 * @param lt_time the lt_time to set
	 */
	public void setLt_time(String lt_time) {
		this.lt_time = lt_time;
	}
	
	

}
