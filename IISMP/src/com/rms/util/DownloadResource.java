package com.rms.util;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-9 下午8:33:48
 * @parameter  
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rms.service.ResourceService;

@Component("downloadResource")
@Scope("prototype")
public class DownloadResource {

	private String filename;// 接收参数
	private String contentType; // 文件类型
	protected  ResourceService resourceService;
	private int resource_id;
	
	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public String getFilename() {
		String aa = DateUtil.getLongDate();
		int c = filename.lastIndexOf(".");
		filename =  aa + filename.substring(c);// 解决火狐下载问题
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String downloadFile() throws Exception {
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		ServletContext servletContext = ServletActionContext.getServletContext();
		contentType = servletContext.getMimeType(filename);
		return "success";
	}

	public InputStream getTargetFile() throws IOException {
		File file = new File("d:\\IISMP\\System_source\\", filename);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		return in;
	}
}
