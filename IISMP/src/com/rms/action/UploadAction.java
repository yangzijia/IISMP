/**
 * 
 */
package com.rms.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Component("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport {
	// username属性用来封装用户名
	private String typename;
	
	
	// myFile属性用来封装上传的文件
	private File myFile;
	
	// myFileContentType属性用来封装上传文件的类型
	private String myFileContentType;

	// myFileFileName属性用来封装上传文件的文件名
	private String myFileFileName;

	private String applyinfo;
	

	/**dong
	 * @return the typename
	 */
	public String getTypename() {
		return typename;
	}

	/**
	 * @param typename the typename to set
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}

	/**dong
	 * @return the applyinfo
	 */
	public String getApplyinfo() {
		return applyinfo;
	}

	/**
	 * @param applyinfo the applyinfo to set
	 */
	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}

	//获得myFile值
	public File getMyFile() {
		return myFile;
	}

	//设置myFile值
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	//获得myFileContentType值
	public String getMyFileContentType() {
		return myFileContentType;
	}

	//设置myFileContentType值
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	//获得myFileFileName值
	public String getMyFileFileName() {
		return myFileFileName;
	}

	//设置myFileFileName值
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String upload() throws Exception {
		
		//基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		
		// 设置上传文件目录
		String uploadPath = "d:\\IISMP\\test";
		
		// 设置目标文件
		File toFile = new File(uploadPath, this.getMyFileFileName());
		
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);

		//设置缓存
		byte[] buffer = new byte[1024];

		int length = 0;

		//读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		System.out.println("上传申报类型"+typename);
		System.out.println("上传申报内容"+applyinfo);
		System.out.println("上传文件名"+myFileFileName);
		System.out.println("上传文件类型"+myFileContentType);
		//关闭输入流
		is.close();
		
		//关闭输出流
		os.close();
		
		return "success"; 
	}

}