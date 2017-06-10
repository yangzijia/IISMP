package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Announce_section {
	private int as_id;
	private String as_name;
	private String as_updatetime;
	private int as_amount;
	private String as_description;

	@Id
	@GeneratedValue
	public int getAs_id() {
		return as_id;
	}
	public void setAs_id(int as_id) {
		this.as_id = as_id;
	}
	public String getAs_name() {
		return as_name;
	}
	public void setAs_name(String as_name) {
		this.as_name = as_name;
	}
	public String getAs_updatetime() {
		return as_updatetime;
	}
	public void setAs_updatetime(String as_updatetime) {
		this.as_updatetime = as_updatetime;
	}
	public int getAs_amount() {
		return as_amount;
	}
	public void setAs_amount(int as_amount) {
		this.as_amount = as_amount;
	}
	public String getAs_description() {
		return as_description;
	}
	public void setAs_description(String as_descrption) {
		this.as_description = as_descrption;
	}
	
}
