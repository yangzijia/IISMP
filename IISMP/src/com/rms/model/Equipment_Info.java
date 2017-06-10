package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipment_Info {
	private int e_id;
	private String e_name;
	private String e_location;
	private String e_principal;
	private String e_checktime;
	private String e_pattern;//型号
	private String e_buytime;
	private int e_price;
	private String e_purchaser;//购买人
	private String e_precautions;//注意事项
	private String e_image;
	@Id
	@GeneratedValue
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_location() {
		return e_location;
	}
	public void setE_location(String e_location) {
		this.e_location = e_location;
	}
	public String getE_principal() {
		return e_principal;
	}
	public void setE_principal(String e_principal) {
		this.e_principal = e_principal;
	}
	public String getE_checktime() {
		return e_checktime;
	}
	public void setE_checktime(String e_checktime) {
		this.e_checktime = e_checktime;
	}
	public String getE_pattern() {
		return e_pattern;
	}
	public void setE_pattern(String e_pattern) {
		this.e_pattern = e_pattern;
	}
	public String getE_buytime() {
		return e_buytime;
	}
	public void setE_buytime(String e_buytime) {
		this.e_buytime = e_buytime;
	}
	public int getE_price() {
		return e_price;
	}
	public void setE_price(int e_price) {
		this.e_price = e_price;
	}
	public String getE_purchaser() {
		return e_purchaser;
	}
	public void setE_purchaser(String e_purchaser) {
		this.e_purchaser = e_purchaser;
	}
	public String getE_precautions() {
		return e_precautions;
	}
	public void setE_precautions(String e_precautions) {
		this.e_precautions = e_precautions;
	}
	public String getE_image() {
		return e_image;
	}
	public void setE_image(String e_image) {
		this.e_image = e_image;
	}

}
