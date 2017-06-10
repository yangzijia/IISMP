package com.rms.util;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;


@Component("downapplyFile")
@Scope("prototype")
public class DownapplyFile {

	private String filename;// 接收参数
	private String contentType; // 文件类型

	public String getFilename() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String aa = df.format(date);
		int c = filename.lastIndexOf(".");
	      
		filename = "apply" + aa + filename.substring(c);// 解决火狐下载问题
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
		//HttpServletResponse response = ServletActionContext.getResponse();
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		//response.setHeader("Content-disposition","attachment;filename=\"" + filename + "\"");
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		contentType = servletContext.getMimeType(filename);
		return "success";
	}

	public InputStream getTargetFile() throws IOException {
		File file = new File("d:\\IISMP\\Apply_file\\", filename);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		return in;
	}
}
