package com.rms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.Page;
import com.rms.page.UploadMember;
import com.rms.util.DateUtil;
import com.rms.util.Tools;
import com.rms.util.Webtools;

@SuppressWarnings("serial")
@Component("systemsetAction")
@Scope("prototype")
public class SystemSettingAction extends BaseAction {
	private HttpServletRequest request;
	private int pageNow;
	private String sectionname;
	private String section_names;
	private String remark;
	private String result;
	private int id;
	private String m_username;
	private String m_truename;
	private String m_password;
	private String m_sex;
	private String m_email;
	private String m_phone;
	private String m_duty;
	private String m_section;
	private String member_duty;
	private String finduser;
	private String m_state;
	private String filename;// 接收参数
	private String contentType; // 文件类型
	// myFile属性用来封装上传的文件
	private File myFile;
	// myFileContentType属性用来封装上传文件的类型
	private String myFileContentType;
	// myFileFileName属性用来封装上传文件的文件名
	private String myFileFileName;
	private String newfilename;
	private String qqinfo;
	private String m_classname;
	private String pictureSrcInfo;
	
	public String getPictureSrcInfo() {
		return pictureSrcInfo;
	}
	public void setPictureSrcInfo(String pictureSrcInfo) {
		this.pictureSrcInfo = pictureSrcInfo;
	}
	public String getM_classname() {
		return m_classname;
	}
	public void setM_classname(String m_classname) {
		this.m_classname = m_classname;
	}
	public String getQqinfo() {
		return qqinfo;
	}
	public void setQqinfo(String qqinfo) {
		this.qqinfo = qqinfo;
	}
	public String getFilename() {
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
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	public String getSection_names() {
		return section_names;
	}
	public void setSection_names(String section_names) {
		this.section_names = section_names;
	}
	public String getMember_duty() {
		return member_duty;
	}
	public void setMember_duty(String member_duty) {
		this.member_duty = member_duty;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public String getM_truename() {
		return m_truename;
	}
	public void setM_truename(String m_truename) {
		this.m_truename = m_truename;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_sex() {
		return m_sex;
	}
	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_duty() {
		return m_duty;
	}
	public void setM_duty(String m_duty) {
		this.m_duty = m_duty;
	}
	public String getM_section() {
		return m_section;
	}
	public void setM_section(String m_section) {
		this.m_section = m_section;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	public String getFinduser() {
		return finduser;
	}
	public void setFinduser(String finduser) {
		this.finduser = finduser;
	}
	public String getM_state() {
		return m_state;
	}
	public void setM_state(String m_state) {
		this.m_state = m_state;
	}
	/**
	 * 查询出所有的分组的方法
	 * @author yangzijia
	 * @date 2016-10-19
	 */
	public String findsectionsAction() throws Exception {
		request = ServletActionContext.getRequest();		
		HttpSession session = request.getSession();
		//查询出所有的分组的方法
		List<Section> section = systemsetService.findsectioninfo();
		session.setAttribute("sectioninfo", section);
		return "success";
	}
	
	/**
	 * 创建新的分组
	 * @author yangzijia
	 * @date 2016-10-19
	 */
	public void createnewgroup() throws Exception{
		Section s = new Section();
		s.setSection_name(Webtools.Change(sectionname));
		if("".equals(remark)||remark.equals(null)){
			remark="-";
		}
		s.setRemark(Webtools.Change(remark));
		s.setTime(DateUtil.getNowStrDate());
		
		//往section里增加数据
		systemsetService.addnewgroup(s);
		
		//刷新section的列表信息
		this.refreshsectionAciton();
	}
	
	/**
	 * 根据id查询出section的信息并且动态显示到organ_structure_groupmanage.jsp界面
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-21
	 */
	public void findsectioninfobyid() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据id查找出该组的信息
		Section section = systemsetService.findsectioninfoById(id);
		JSONObject json = new JSONObject();
		json.put("sectionname", section.getSection_name());
		json.put("remark", section.getRemark());
		json.put("id", section.getId());
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 保存编辑后的分组信息
	 * @throws Exception
	 */
	public void section_saveeditinfo() throws Exception {
		String time = DateUtil.getNowStrDate();
		Section s = new Section();
		s.setId(id);
		s.setSection_name(Tools.Change(sectionname));
		s.setRemark(Webtools.Change(remark));
		s.setTime(time);
		
		//刷新section数据表的数据
		systemsetService.updateSctioninfo(s);
		
		//刷新section的列表信息
		this.refreshsectionAciton();
	}
	
	/**
	 * 删除分组的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public void deletesectionbyid() throws Exception {
		Section s = new Section();
		s.setId(id);
		
		//删除分组的方法
		systemsetService.deletesectionById(s);
		
		//刷新section的列表信息
		this.refreshsectionAciton();
	}
	
	/**
	 * 刷新分组列表的信息的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public void refreshsectionAciton() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//查询出所有的分组的方法
		List<Section> section = systemsetService.findsectioninfo();
		
		//转化为json字符串，再次可以打印出查看一下
		JSONArray jsona = new JSONArray();
		for(int i=0;i<section.size();i++){
			jsona.add(i, section.get(i));
		}
		out.print(jsona);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询出打开组织结构界面的信息/Functionality/system_manage/organ_stru_index.jsp
	 * @return
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public String findororganizationinfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//接受查看的栏目
		String sectionnamess = "";
		if(section_names!=null){
			sectionnamess = new String(section_names.getBytes("ISO-8859-1"), "utf-8");
		}
		if(pageNow<1){
			pageNow = 1;
		}
		if(m_duty==null){
			m_duty="全部职务";
		}
		//查询出所有的分组的方法
		List<Section> section = systemsetService.findsectioninfo();
		//分页查询出用户的列表信息
		List<MembershipInfo> msi = systemsetService.findMembershipInfos(pageNow,m_duty,sectionnamess);
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(systemsetService.findMembershipnum(m_duty,sectionnamess));
		
		request.setAttribute("section_names", sectionnamess);
		request.setAttribute("pageinfo", p);
		session.setAttribute("sectioninfo", section);
		request.setAttribute("membershipinfo", msi);
		return "success";
	}
	
	/**
	 * 刷新成员列表的信息的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public void refreshmembershipAciton() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//接受查看的栏目
		String sectionnamess = "";
		/*if(section_names!=null){
			sectionnamess = new String(section_names.getBytes("ISO-8859-1"), "utf-8");
		}*/
		sectionnamess = section_names;
		if(pageNow<1){
			pageNow = 1;
		}
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		
		//分页查询出用户的列表信息
		List<MembershipInfo> msi = systemsetService.findMembershipInfos(pageNow,m_duty, sectionnamess);
		Page p = new Page();
		if(msi != null && msi.size() > 0){
			
			for(int i=0;i<msi.size();i++){
				jsona.add(i, msi.get(i));
			}
			p.setTotalItemNumber(systemsetService.findMembershipnum(m_duty,sectionnamess));
		}else {
			p.setTotalItemNumber(1);
			isempty = true;
		}
		
		p.setPageNow(pageNow);
		p.setPageSize(20);
		isHasNext = p.isHasNext();
		isHasPrev = p.isHasPrev();
		pageCount = p.getpageCount(p.getTotalItemNumber());
		//转化为json字符串，再次可以打印出查看一下
		
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("pageNow", pageNow);
		json.put("isHasNext", isHasNext);
		json.put("isHasPrev", isHasPrev);
		json.put("pageCount", pageCount);
		json.put("getNextPage", p.getNextPage());
		json.put("getPervPage", p.getPrevPage());
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 打开停用成员信息的界面
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void openblockupmember() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if(pageNow<1){
			pageNow = 1;
		}
		boolean isHasNext = false;
		boolean isHasPrev = false;
		boolean isempty = false;
		int pageCount = 0;
		JSONArray jsona = new JSONArray();
		//分页查询出停用成员的列表信息
		List<MembershipInfo> msi = systemsetService.findblockupMemberInfos(pageNow,m_duty);
		
		if(msi != null && msi.size() > 0){
			for(int i=0;i<msi.size();i++){
				jsona.add(i, msi.get(i));
			}
		}else{
			isempty = true;
		}
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(systemsetService.findblockupMembershipnum(m_duty));
		isHasNext = p.isHasNext();
		isHasPrev = p.isHasPrev();
		pageCount = p.getpageCount(p.getTotalItemNumber());
		if(pageCount==0){
			pageCount=1;
		}
		//转化为json字符串，再次可以打印出查看一下
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("pageNow", pageNow);
		json.put("isHasNext", isHasNext);
		json.put("isHasPrev", isHasPrev);
		json.put("pageCount", pageCount);
		json.put("getNextPage", p.getNextPage());
		json.put("getPervPage", p.getPrevPage());
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
		out.flush();
		out.close();
	}
	
	/**
	 * 添加新成员的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-22
	 */
	public void savememberinfos() throws Exception {
		MembershipInfo msi1 = new MembershipInfo();
		String m_entermiictime = DateUtil.getNowStrDate();
		if(m_email != null && m_email != ""){
			msi1.setM_email(Webtools.Change(m_email));
		}else {
			msi1.setM_email("-");
		}
		if(m_phone != null && m_phone != ""){
			msi1.setM_phone(m_phone);
		}else {
			msi1.setM_phone("-");
		}
		msi1.setM_entermiictime(m_entermiictime);
		msi1.setM_password(Webtools.Change(m_password));
		msi1.setM_role(member_duty);
		msi1.setM_sectionname(m_section);
		msi1.setM_sex(m_sex);
		msi1.setM_truename(Webtools.Change(m_truename));
		msi1.setM_username(Webtools.Change(m_username));
		msi1.setM_classname("-");
		msi1.setM_qqchat("-");
		msi1.setM_utpitp("-");
		msi1.setM_state("启用");
		int role_num = 4;
		if(member_duty.equals("管理员")){
			role_num=1;
		}else if(member_duty.equals("组长")){
			role_num = 3;
		}else if(member_duty.equals("教师")){
			role_num = 2;
		}else {
			role_num = 4;
		}
		msi1.setM_userpicture("-");
		msi1.setRole_num(role_num);
		//添加成员
		systemsetService.savememberinfos(msi1);
		this.refreshmembershipAciton();
	}
	
	/**
	 * 停用此用户的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void blockupthismember() throws Exception {
		//根据id停用用户的信息的方法
		if(systemsetService.blockupthismemberByid(id)){
			this.refreshmembershipAciton();
		}
	}
	
	/**
	 * 根据用户的id查找用户信息
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void findmemberinfoByid() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据用户的id查找用户信息
		MembershipInfo msi = systemsetService.findmemberinfoByid(id);
		JSONObject json = new JSONObject();
		json.put("username", msi.getM_username());
		json.put("truename", msi.getM_truename());
		json.put("password", msi.getM_password());
		json.put("sex", msi.getM_sex());
		json.put("phone", msi.getM_phone());
		json.put("email", msi.getM_email());
		json.put("role", msi.getM_role());
		json.put("sectionname", msi.getM_sectionname());
		json.put("id", msi.getM_id());
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 保存修改后的用户信息
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void saveeditmemberinfo() throws Exception {
		int role_num = 4;
		
		//根据用户的id查找用户信息
		MembershipInfo msi1 = systemsetService.findmemberinfoByid(id);
		if(m_email != null && m_email != ""){
			msi1.setM_email(Webtools.Change(m_email));
		}else {
			msi1.setM_email("-");
		}
		if(m_phone != null && m_phone != ""){
			msi1.setM_phone(m_phone);
		}else {
			msi1.setM_phone("-");
		}
		msi1.setM_email(Webtools.Change(m_email));
		msi1.setM_password(Webtools.Change(m_password));
		msi1.setM_phone(m_phone);
		msi1.setM_role(member_duty);
		msi1.setM_sectionname(m_section);
		msi1.setM_sex(m_sex);
		msi1.setM_truename(Webtools.Change(m_truename));
		msi1.setM_username(Webtools.Change(m_username));
		
		if(member_duty.equals("管理员")){
			role_num=1;
		}else if(member_duty.equals("组长")){
			role_num = 3;
		}else if(member_duty.equals("教师")){
			role_num = 2;
		}else {
			role_num = 4;
		}
		msi1.setRole_num(role_num);
		msi1.setM_userpicture("-");
		//修改成员信息的方法
		systemsetService.saveeditmemberinfo(msi1);
		this.refreshmembershipAciton();
	}
	
	/**
	 * 删除这个成员的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void deletethismember() throws Exception {
		MembershipInfo m = new MembershipInfo();
		m.setM_id(id);
		//删除这个成员的方法
		systemsetService.deletethismember(m);
		this.openblockupmember();
	}
	
	/**
	 * 重新启用该用户的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void startusingthismember() throws Exception {
		systemsetService.startusingthismember(id);
		this.openblockupmember();
	}
	
	/**
	 * 根据具体条件查询用户
	 * @author yangzijia
	 * @data 2016-10-24
	 */
	public void finduserByCondition() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<MembershipInfo> msi = systemsetService.finduserByCondition(finduser,m_state);
		JSONArray jsona = new JSONArray();
		//if(msi != null){
		for(int i=0;i<msi.size();i++){
			jsona.add(i, msi.get(i));
		}
		//}
		out.print(jsona);
		out.flush();
		out.close();
	}
	
	/**
	 * 批量删除人员的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2017-04-12
	 */
	public void batchdeletemember() throws Exception{
		request = ServletActionContext.getRequest();
		String items = request.getParameter("delitems");
		List<String> delList = new ArrayList<String>();
		String[] strs = items.split(",");
		for (String str : strs) {
		    delList.add(str);
		}
		//批量删除人员的方法
		systemsetService.batchdeletemember(delList);
		this.openblockupmember();
	}
	
	/**
	 * 批量启用人员的方法
	 * @throws Exception
	 */
	public void batchqiyongmember() throws Exception{
		request = ServletActionContext.getRequest();
		String items = request.getParameter("delitems");
		List<String> delList = new ArrayList<String>();
		String[] strs = items.split(",");
		for (String str : strs) {
		    delList.add(str);
		}
		//批量启用人员的方法
		systemsetService.batchqiyongmember(delList);
		this.openblockupmember();
	}
	
	/**
	 * 批量停用人员的方法
	 * @throws Exception
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public void batchupdatemember() throws Exception {
		request = ServletActionContext.getRequest();
		String items = request.getParameter("delitems");
		List<String> delList = new ArrayList<String>();
		String[] strs = items.split(",");
		for (String str : strs) {
		    delList.add(str);
		}
		//批量停用人员的方法
		systemsetService.batchupdatemember(delList);
		this.refreshmembershipAciton();
	}
	
	/**
	 * 打开批量导入人员的界面
	 */
	public String openbatchtoleadjsp() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//查询出所有的分组的方法
		List<Section> section = systemsetService.findsectioninfo();
		session.setAttribute("sectioninfo", section);
		return "success";
	}
	
	/**
	 * 上传文件的方法
	 */
	public void uploadSInfoAction() throws Exception {
		request = ServletActionContext.getRequest();
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置日期格式
		String aa = DateUtil.getLongDate();
		
		myFileFileName = new String(myFileFileName);
		
		newfilename = aa + myFileFileName;
		// 设置目标文件
		File toFile = new File("d:\\IISMP\\System_manage", newfilename);
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
		request.setAttribute("newfilename", newfilename);
	}
	
	/**
	 * 批量上传人员的方法
	 */
	@SuppressWarnings("deprecation")
	public String commitmemberfile() throws Exception{
		System.out.println("jsdljflksjdkfljksdklj");
		request = ServletActionContext.getRequest();
		
		ArrayList<UploadMember> alum = new ArrayList<UploadMember>();
		boolean checkusername = false;
		boolean checksection = false;
		//boolean checkduty = false;
		boolean ctruename = true;
		boolean csex = true;
		boolean cusername = true;
		boolean csectionname = true;
		boolean cduty = true;
		HSSFSheet sheet;
		HSSFRow row;
		//执行上传文件的方法
		this.uploadSInfoAction();
		newfilename = new String(newfilename);
		 // 对读取Excel表格标题测试
        InputStream is = new FileInputStream("d:/IISMP/System_manage/"+ newfilename);
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
       // int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第san行开始,第er行为表头的标题
        for (int i = 2; i <= rowNum; i++) {
            row = sheet.getRow(i); 
        	String struename = row.getCell((short) 0) + "";
        	String ssex = row.getCell((short) 1)+ "";
    		String susername = row.getCell((short) 2) + "";
    		String ssectionname = row.getCell((short) 3) + "";
    		String sduty = row.getCell((short) 4) + "";
    		
    		Cell cell5 = row.getCell(5);
    		cell5.setCellType(Cell.CELL_TYPE_STRING); 

			String sphone = cell5.toString();

    		//String sphone = ssphone+"";
    		String semail = row.getCell((short) 6) + "";
    		System.out.println(struename);
    		System.out.println(ssex);
    		System.out.println(susername);
    		System.out.println(ssectionname);
    		System.out.println(sduty);
    		System.out.println(sphone);
    		System.out.println(semail);
    		if(struename==""){
				//没有输入姓名
				ctruename = false;
				System.out.println("//没有输入姓名");
			}
			if(ssex==""){
				//没有输入性别
				csex = false;
				System.out.println("//没有输入性别");
			}
			if(susername==""){
				//没有输入登陆名
				cusername = false;
				System.out.println("//没有输入登陆名");
			}
			if(ssectionname==""){
				//组名为空
				csectionname = false;
				System.out.println("//组名为空");
			}
			if(sduty==""){
				//职务为空
				cduty = false;
				System.out.println("//职务为空");
			}
			if(ctruename && csex && cusername && csectionname && cduty){
				//验证用户名是否存在
				checkusername = systemsetService.checkusername(susername);
				//验证组名时候存在
				checksection = systemsetService.checksection(ssectionname);
				if(checkusername){
					//登陆名存在
					UploadMember um = new UploadMember();
					um.setRow(i);
					um.setTruename(struename);
					um.setDuty(sduty);
					um.setEmail(semail);
					um.setPhone(sphone);
					um.setSectionname(ssectionname);
					um.setSex(ssex);
					um.setUsername(susername);
					alum.add(um);
				}else if(checksection){
					//职务存在
					//创建这个新的分组
					Section s = new Section();
					s.setSection_name(ssectionname);
					s.setRemark("-");
					s.setTime(DateUtil.getNowStrDate());
					systemsetService.addnewgroup(s);
					
					MembershipInfo mb = new MembershipInfo();
					mb.setM_email(semail);
					mb.setM_entermiictime(DateUtil.getNowStrDate());
					mb.setM_password(m_password);
					mb.setM_phone(sphone);
					mb.setM_classname("-");
					mb.setM_qqchat("-");
					mb.setM_role(sduty);
					mb.setM_sectionname(ssectionname);
					mb.setM_sex(ssex);
					mb.setM_state("启用");
					mb.setM_truename(struename);
					mb.setM_username(susername);
					mb.setM_utpitp("-");
					int role_num=4;
					if(sduty.equals("管理员")){
						role_num=1;
					}else if(sduty.equals("组长")){
						role_num = 3;
					}else if(sduty.equals("教师")){
						role_num = 2;
					}else {
						role_num = 4;
					}
					
					mb.setRole_num(role_num);
					mb.setM_userpicture("-");
					//添加到数库中
					systemsetService.savememberinfos(mb);
				}/*else if(checkduty){
					if(checksection){
						Section s = new Section();
						s.setSection_name(ssectionname);
						systemsetService.addnewgroup(s);
					}
					//职务不存在，需要创建新的职务
					return "error";
				}*/else{
					MembershipInfo mb = new MembershipInfo();
					mb.setM_email(semail);
					mb.setM_entermiictime(DateUtil.getNowStrDate());
					mb.setM_password(m_password);
					mb.setM_phone(sphone);
					mb.setM_classname("-");
					mb.setM_qqchat("-");
					mb.setM_role(sduty);
					mb.setM_sectionname(ssectionname);
					mb.setM_sex(ssex);
					mb.setM_state("启用");
					mb.setM_truename(struename);
					mb.setM_username(susername);
					mb.setM_utpitp("-");
					mb.setM_userpicture("-");
					int role_num=4;
					if(sduty.equals("管理员")){
						role_num=1;
					}else if(sduty.equals("组长")){
						role_num = 3;
					}else if(sduty.equals("教师")){
						role_num = 2;
					}else {
						role_num = 4;
					}
					mb.setRole_num(role_num);
					//添加到数库中
					systemsetService.savememberinfos(mb);
				}
			}else{
				System.out.println("sdasd");
				UploadMember um = new UploadMember();
				um.setRow(i);
				um.setTruename(struename);
				um.setDuty(sduty);
				um.setEmail(semail);
				um.setPhone(sphone);
				um.setSectionname(ssectionname);
				um.setSex(ssex);
				um.setUsername(susername);
				alum.add(um);
			}
        }
		request.setAttribute("alum", alum);	
		return "success";
	}
	
	/**
	 * 修改qq号
	 */
	public void updateqqchat() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		String qqinfo1=Webtools.Change(qqinfo);
		
		mi.setM_qqchat(qqinfo1);
		//修改QQ
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！");
		json.put("newqq", qqinfo);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 修改shouji号
	 */
	public void updatephonechat() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		String m_phone1=Webtools.Change(m_phone);
		mi.setM_phone(m_phone1);
		//修改手机号
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！");
		json.put("newphone", m_phone);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 修改班级名称
	 */
	public void updateclassname() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		String m_classname1=Webtools.Change(m_classname);
		mi.setM_classname(m_classname1);
		//修改手机号
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！"); 
		json.put("newclassname", m_classname);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 修改班级名称
	 */
	public void updateremark() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		String remark1=Webtools.Change(remark);
		mi.setM_utpitp(remark1);
		//修改手机号
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！"); 
		json.put("newremark", remark);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 修改班级名称
	 */
	public void updateemail() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		String m_email1=Webtools.Change(m_email);
		mi.setM_email(m_email1);
		//修改手机号
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！"); 
		json.put("newemail", m_email);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 修改密码的方法
	 */
	public void updatepassword() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		String m_password1=Webtools.Change(m_password);
		mi.setM_password(m_password1);
		//修改手机号
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！"); 
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 上传头像的方法
	 */
	public String commituserpicturefile() throws Exception {
		System.out.println("sdfsdfsdfd");
		request = ServletActionContext.getRequest();
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置日期格式
		String aa = DateUtil.getLongDate();
		
		myFileFileName = new String(myFileFileName);
		
		newfilename = "userpicture_" + aa + myFileFileName;
		 //定义上传路径  
       /* String path = System.getProperty("user.dir").replace("bin", "webapps");
        path = path.replaceAll("\\\\", "/")+"/IISMP/userpicture/";*/
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\IISMP\\userpicture\\";
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		mi.setM_userpicture("userpicture/"+newfilename);
		//修改touxiang的方法
		systemsetService.updateMemberinfo(mi);
		return "success";
	}
	
	/**
	 * 保存头像信息到数据库
	 */
	public void savePictureSrcinfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo mi = (MembershipInfo)session.getAttribute("memberinfo");
		mi.setM_userpicture(pictureSrcInfo);
		systemsetService.updateMemberinfo(mi);
		JSONObject json = new JSONObject();
		json.put("infos", "操作成功！！"); 
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询出所有的分组情况
	 */
	public void findsectioninfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60);
		List<Section> sections=systemsetService.findsectioninfo();
		session.setAttribute("sections", sections);
	}
	
}
