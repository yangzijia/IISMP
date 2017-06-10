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

import com.rms.service.ContestService;


@Component("downloadProject")
@Scope("prototype")
public class DownloadProject {

	private String filename;// 接收参数
	private String contentType; // 文件类型
	protected  ContestService contestService;
	private int project_id;
	
	

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}



	public ContestService getContestService() {
		return contestService;
	}

	public void setContestService(ContestService contestService) {
		this.contestService = contestService;
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

	public String downloadpro() throws Exception {
		
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		ServletContext servletContext = ServletActionContext.getServletContext();
		contentType = servletContext.getMimeType(filename);
		
		return "success";
	}

	public InputStream getTargetFile() throws IOException {
		
		File file = new File("d:\\IISMP\\Project_resource\\", filename);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		System.err.println(in);
		return in;
	}
}

