package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-6 下午3:51:42
 * @parameter  
 */
@Entity
public class ResourceInfo {
	
		 private int  resource_id;
		 private String resource_name;
		 private String resource_issuer;
		 private String resource_time;
		 private int rt_id;
		 private String resource_remark;
		@Id
		@GeneratedValue
		public int getResource_id() {
			return resource_id;
		}
		public void setResource_id(int resource_id) {
			this.resource_id = resource_id;
		}
		public String getResource_name() {
			return resource_name;
		}
		public void setResource_name(String resource_name) {
			this.resource_name = resource_name;
		}
		public String getResource_issuer() {
			return resource_issuer;
		}
		public void setResource_issuer(String resource_issuer) {
			this.resource_issuer = resource_issuer;
		}
		public String getResource_time() {
			return resource_time;
		}
		public void setResource_time(String resource_time) {
			this.resource_time = resource_time;
		}
		
		public int getRt_id() {
			return rt_id;
		}
		public void setRt_id(int rt_id) {
			this.rt_id = rt_id;
		}
		public String getResource_remark() {
			return resource_remark;
		}
		public void setResource_remark(String resource_remark) {
			this.resource_remark = resource_remark;
		}
 
}
