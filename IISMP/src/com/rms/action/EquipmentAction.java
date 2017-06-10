package com.rms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rms.model.Equipment_Info;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.Page;
import com.rms.util.DateUtil;

@SuppressWarnings("serial")
@Component("equipmentAction")
@Scope("prototype")
public class EquipmentAction extends BaseAction{
	private int rowCount;
	private int pageCount;
	private int pageNow;
	HttpServletRequest request;
	private int e_id;
	private String e_name;
	private String e_location;
	private String e_principal;
	private String e_precautions;
	private int e_price;
	private String e_purchaser;
	private String e_buytime;
	private String e_pattern;
	private String e_checktime;
	private File myFile;
	private String myFileFileName;
	private String e_picture;
	private String newfilename;
	
	
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	public String getE_picture() {
		return e_picture;
	}
	public void setE_picture(String e_picture) {
		this.e_picture = e_picture;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
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
	public String getE_precautions() {
		return e_precautions;
	}
	public void setE_precautions(String e_precautions) {
		this.e_precautions = e_precautions;
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
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
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
	
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	/**
	 * 查看设备列表的信息的方法
	 * @throws Exception
	 * @author dzz
	 * @data 2016-11-14
	 */	
	public String ViewequipAction() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		if(pageNow<1){
			pageNow = 1;
		}
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Equipment_Info> equipment =equipmentService.findAll(pageNow);//查询一页
		List<Equipment_Info> e_ment=equipmentService.findAllname();//查询所有名称
	
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(10);
		p.setTotalItemNumber(equipmentService.findAllCount());
		request.setAttribute("pageinfo", p);
		request.setAttribute("equipment", equipment);
		request.setAttribute("e_ment", e_ment);
		session.setAttribute("membershipInfo", membershipInfo);
		return "success";
		
	}
	
	/**
	 * 查看设备列表的信息的方法
	 */	
	public String ShowequipAction() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Equipment_Info> equipment =equipmentService.findAll(pageNow);//查询一页
		List<Equipment_Info> e_ment=equipmentService.findAllname();//查询所有名称
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(10);
		List<Section>sections=systemsetService.findsectioninfo();
		p.setTotalItemNumber(equipmentService.findAllCount());

	
		request.setAttribute("pageinfo", p);
		session.setAttribute("equipment", equipment);
		session.setAttribute("e_ment", e_ment);
		session.setAttribute("membershipInfo", membershipInfo);
		request.setAttribute("sections", sections);
		return "success";
		
	}

		/**
		 * 根据id查看设备的详细信息
		 * @throws Exception
		 * @author dzz
		 * @data 2016-11-14
		 */
	public void findEbyid()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();	
		JSONObject json = new JSONObject();
		List<Equipment_Info> einfo=equipmentService.findEbyid(e_id);
		if(einfo!=null&&einfo.size()>0){
		Equipment_Info e=einfo.get(0);	
		json.put("e_buytime", e.getE_buytime());
		json.put("e_checktime", e.getE_checktime());
		json.put("e_name", e.getE_name());
		json.put("e_pattern", e.getE_pattern());
		json.put("e_precautions", e.getE_precautions());
		json.put("e_price", e.getE_price());
		json.put("e_principal", e.getE_principal());
		json.put("e_purchaser", e.getE_purchaser());
		json.put("e_id", e.getE_id());
		json.put("e_image", e.getE_image());
		out.print(json);
		out.flush();
		out.close();
		}
	}
	/**
	 * 添加设备
	 * @throws Exception
	 * @author dzz
	 * @data 2016-11-14
	 */
	public void addEquipment()throws Exception{
		request = ServletActionContext.getRequest();
		Equipment_Info ement=new Equipment_Info();
		ement.setE_id(e_id);
		ement.setE_name(e_name);
		ement.setE_precautions(e_precautions);
		ement.setE_price(e_price);
		ement.setE_principal(e_principal);
		ement.setE_purchaser(e_purchaser);
		ement.setE_buytime(e_buytime);
		equipmentService.addequip(ement);
	}
	
	/**
	 * //删除设备
	 * @throws Exception
	 * @author dzz
	 * @data 2016-11-14
	 */
	public void  deleteEquip()throws Exception{
		Equipment_Info ement=new Equipment_Info();
		ement.setE_id(e_id);
		equipmentService.deleteEbyid(ement);
		this.ViewequipAction();	
	}
	/**
	 * //编辑设备（根据id找到要编辑的信息）
	 * @throws Exception
	 * @author dzz
	 * @data 2016-11-14
	 */
	@SuppressWarnings("unused")
	public void  editEquip()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Equipment_Info> ement=equipmentService.findEbyid(e_id);
		if(ement!=null&&ement.size()>0){
		String e_name=ement.get(0).getE_name();
		String e_pattern=ement.get(0).getE_pattern();
		int e_price=ement.get(0).getE_price();
		String e_purchaser=ement.get(0).getE_purchaser();
		String e_precautions=ement.get(0).getE_precautions();
		}
		JSONObject json = new JSONObject();
		json.put("e_name", e_name);
		json.put("e_pattern", e_pattern);
		json.put("e_price", e_price);
		json.put("e_purchaser", e_purchaser);
		json.put("e_precautions", e_precautions);
		
		out.print(json);
		out.flush();
		out.close();	
	}
	
	/**
	 *保存编辑后的设备信息
	 * @throws Exception
	 * @author dzz
	 * @data 2016-10-21
	 */
	public void save_equipinfo() throws Exception {
		/*HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();	*/
		String time=DateUtil.getNowStrDate();
		System.out.println(time);
		List<Equipment_Info> ement=equipmentService.findEbyid(e_id);
		if(ement!=null&&ement.size()>0){
		Equipment_Info e=ement.get(0);	
		e.setE_pattern(e_pattern);
		e.setE_purchaser(e_purchaser);
		e.setE_checktime(e_checktime);
		e.setE_buytime(e_buytime);
		e.setE_principal(e_principal);
		e.setE_precautions(e_precautions);
		e.setE_checktime(time);
		equipmentService.update(e);	
			}
		}
	
	public static int id;
	public void chuanID() throws IOException{
		/*HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();	*/	
		 id=e_id;
		
	}
	
	/**
	 * 设备图片上传
	 * @return
	 * @throws Exception
	 */
	public String Commitepicture() throws Exception {
		request = ServletActionContext.getRequest();
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置日期格式
		String aa = DateUtil.getLongDate();
		
		myFileFileName = new String(myFileFileName);
		
		newfilename = "equipmentpicture_" + aa + myFileFileName;
		 //定义上传路径  
	    String path = System.getProperty("user.dir").replace("bin", "webapps");
	    path = path.replaceAll("\\\\", "/")+"/IISMP//equipmentpicture/";
		//String path = "D:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps";
		//String path="D:/Tomcat 7.0/webapps/IISMP/userpicture/";
		System.out.println("11111111111==="+path);
		// 设置目标文件
		File toFile = new File(path, newfilename);
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);
		// 设置缓存
		byte[] buffer = new byte[1024*2];
		int length = 0;
		// 读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		// 关闭输入流
		is.close();
		// 关闭输出流
		os.close();		
		List<Equipment_Info> eInfos=equipmentService.findEbyid(id);
		Equipment_Info ee=eInfos.get(0);
		ee.setE_image("equipmentpicture/"+newfilename);
		//修改touxiang的方法
		equipmentService.update(ee);
		this.ShowequipAction();
		return "success";
	}
	//刷新设备
	public void refreshequip()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		//int pagNow=1;
		List<Equipment_Info> re=equipmentService.findAll(pageNow);
		JSONArray jsona = new JSONArray();
		for(int i=0;i<re.size();i++){
		jsona.add(i, re.get(i));		
		}	
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
	}
	
	}