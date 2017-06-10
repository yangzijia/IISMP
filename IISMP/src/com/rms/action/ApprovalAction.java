package com.rms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import com.rms.model.Apply;
import com.rms.model.Approval;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.Page;
import com.rms.util.DateUtil;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-12-11 下午6:50:46
 * @parameter  
 */

@SuppressWarnings("serial")
@Component("approvalAction")
@Scope("prototype")
public class ApprovalAction extends BaseAction{
	HttpServletRequest request;	
	private int approval_id;
	private String approval_type;
	private String apply_time;
	private String approval_time;
	private String approval_member;
	private String approval_section;
	private String approval_schedule;
	private int apply_id;
	private String apply_info;
	private int pageNow;
	private int rowCount;
	private int pageCount;	
	private String mydeal;
	private String approval_info;
	private String apply_member;
	private String member_section;
	private String apply_resource;
	
	
	/**dong
	 * @return the apply_resource
	 */
	public String getApply_resource() {
		return apply_resource;
	}
	/**
	 * @param apply_resource the apply_resource to set
	 */
	public void setApply_resource(String apply_resource) {
		this.apply_resource = apply_resource;
	}

	// myFile属性用来封装上传的文件
	private File myFile;
	
	// myFileContentType属性用来封装上传文件的类型
	private String myFileContentType;

	// myFileFileName属性用来封装上传文件的文件名
	private String myFileFileName;

	
	
	
	/**dong
	 * @return the myFile
	 */
	public File getMyFile() {
		return myFile;
	}
	/**
	 * @param myFile the myFile to set
	 */
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	/**dong
	 * @return the myFileContentType
	 */
	public String getMyFileContentType() {
		return myFileContentType;
	}
	/**
	 * @param myFileContentType the myFileContentType to set
	 */
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	/**dong
	 * @return the myFileFileName
	 */
	public String getMyFileFileName() {
		return myFileFileName;
	}
	/**
	 * @param myFileFileName the myFileFileName to set
	 */
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getApply_member() {
		return apply_member;
	}
	public void setApply_member(String apply_member) {
		this.apply_member = apply_member;
	}
	public String getMember_section() {
		return member_section;
	}
	public void setMember_section(String member_section) {
		this.member_section = member_section;
	}
	public String getApproval_info() {
		return approval_info;
	}
	public void setApproval_info(String approval_info) {
		this.approval_info = approval_info;
	}
	public String getMydeal() {
		return mydeal;
	}
	public void setMydeal(String mydeal) {
		this.mydeal = mydeal;
	}
	public int getApply_id() {
		return apply_id;
	}
	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
	}
	public String getApply_info() {
		return apply_info;
	}
	public void setApply_info(String apply_info) {
		this.apply_info = apply_info;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
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
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public int getApproval_id() {
		return approval_id;
	}
	public void setApproval_id(int approval_id) {
		this.approval_id = approval_id;
	}
	public String getApproval_type() {
		return approval_type;
	}
	public void setApproval_type(String approval_type) {
		this.approval_type = approval_type;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getApproval_time() {
		return approval_time;
	}
	public void setApproval_time(String approval_time) {
		this.approval_time = approval_time;
	}
	public String getApproval_member() {
		return approval_member;
	}
	public void setApproval_member(String approval_member) {
		this.approval_member = approval_member;
	}
	public String getApproval_section() {
		return approval_section;
	}
	public void setApproval_section(String approval_section) {
		this.approval_section = approval_section;
	}
	public String getApproval_schedule() {
		return approval_schedule;
	}
	public void setApproval_schedule(String approval_schedule) {
		this.approval_schedule = approval_schedule;
	}
	
	
	//查看首页全部审批（管理员权限）
	public String ViewAllapproval()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);			
		List<Approval> approval=approvalService.findAllapproval();
		p.setTotalItemNumber(approvalService.findAllappCount());			
		request.setAttribute("pageinfo", p);
		session.setAttribute("approval", approval);
		return "success";
		
	}
	//查看我的申请（组员和组长）
	public String ViewApply() throws Exception{		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);	
		MembershipInfo ms = (MembershipInfo)session.getAttribute("memberinfo");
		List<Apply> apply=approvalService.findAllapply(ms.getM_username());
		p.setTotalItemNumber(approvalService.findAllapplyCount(ms.getM_username()));	
		List<Approval> approval=approvalService.findAllapproval();
		List<MembershipInfo> mm=merberService.findall();
		List<Section> section = systemsetService.findsectioninfo();
		session.setAttribute("approval", approval);
		session.setAttribute("sectioninfo", section);
		session.setAttribute("allmember", mm);
		request.setAttribute("pageinfo", p);
		session.setAttribute("apply", apply);
		
		return "success";		
	}
	
	//查看我的审批	
	public String findMyapproval()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);	
		MembershipInfo ms = (MembershipInfo)session.getAttribute("memberinfo");
		List<Approval> approval=approvalService.findApprovalBymyname(ms.getM_truename());	
		p.setTotalItemNumber(approvalService.findmyAppCount(ms.getM_truename()));			
		request.setAttribute("pageinfo", p);
		request.setAttribute("myapproval", approval);
		return "success";
	}
	
	
	//根据审批进度查看我的申请
	public void findmyapplyBys() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		if(pageNow<1){
			pageNow = 1;
		}
		//分页查询出公告的列表信息
		List<Apply> app = approvalService.findMyapply(pageNow, approval_schedule);		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		if(app != null && app.size() > 0){
			
			for(int i=0;i<app.size();i++){
				jsona.add(i, app.get(i));
				approval_schedule=app.get(0).getApproval_schedule();
			}
			p.setTotalItemNumber(approvalService.findmshenqing(approval_schedule));
		}else {
			p.setTotalItemNumber(1);
			isempty = true;
		}
		isHasNext = p.isHasNext();
		isHasPrev = p.isHasPrev();
		pageCount = p.getpageCount(p.getTotalItemNumber());		
		//转化为json字符串，再次可以打印出查看一下
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("approval_schedule", approval_schedule);
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
	
	//根据id查看我的申请的详细信息
	public void findapplyByid() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();	
		List<Apply> app = approvalService.findapplyByid(apply_id);			
		JSONObject json = new JSONObject();	
		if(app != null && app.size() > 0){				
		Apply myapply=app.get(0);
		json.put("approval_schedule", myapply.getApproval_schedule());
		json.put("apply_info", myapply.getApply_info());
		json.put("apply_member", myapply.getApproval_member());
		json.put("apply_section", myapply.getMember_section());
		json.put("apply_type", myapply.getApproval_type());
		json.put("apply_time", myapply.getApply_time());
		json.put("approval_member", myapply.getApproval_member());
		
		}
		out.print(json);
		out.flush();
		out.close();	
	}
	
	
	
	
	//根据审批进度查看全部审批
	public void findAllshenpi() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		if(pageNow<1){
			pageNow = 1;
		}	
		List<Approval> app = approvalService.findAllshenpi(pageNow, approval_schedule);	
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		if(app != null && app.size() > 0){
			
			for(int i=0;i<app.size();i++){
				jsona.add(i, app.get(i));
				approval_schedule=app.get(0).getApproval_schedule();
			}
			p.setTotalItemNumber(approvalService.findallshenpin(approval_schedule));
		}else {
			p.setTotalItemNumber(1);
			isempty = true;
		}
		isHasNext = p.isHasNext();
		isHasPrev = p.isHasPrev();
		pageCount = p.getpageCount(p.getTotalItemNumber());
		
		//转化为json字符串，再次可以打印出查看一下
	
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("approval_schedule", approval_schedule);
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
	
	
	
	//根据审批进度查看我的审批
	public void findMyshenpi() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		if(pageNow<1){
			pageNow = 1;
		}
		MembershipInfo ms = (MembershipInfo)session.getAttribute("memberinfo");
		String username =ms.getM_username();
		List<Approval> app = approvalService.findMyshenpi(pageNow, approval_schedule,username);	
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
	
		if(app != null && app.size() > 0){
			
			for(int i=0;i<app.size();i++){
				jsona.add(i, app.get(i));
				approval_schedule=app.get(0).getApproval_schedule();
			}
			p.setTotalItemNumber(approvalService.findmyshenpi(approval_schedule,username));
		}else {
			p.setTotalItemNumber(1);
			isempty = true;
		}
		isHasNext = p.isHasNext();
		isHasPrev = p.isHasPrev();
		pageCount = p.getpageCount(p.getTotalItemNumber());
		
		//转化为json字符串，再次可以打印出查看一下
	
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("approval_schedule", approval_schedule);
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
	
	
	//根据id查看我的审批的详细信息
	public void findmyshenpi() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();	
		List<Approval> app = approvalService.findmyshenpiByid(approval_id);			
		JSONObject json = new JSONObject();	
		if(app != null && app.size() > 0){				
			Approval myshenpi=app.get(0);
		json.put("approval_schedule", myshenpi.getApproval_schedule());
		json.put("apply_info", myshenpi.getApply_info());
		json.put("apply_member", myshenpi.getApproval_member());
		json.put("apply_section", myshenpi.getApproval_section());
		json.put("apply_type", myshenpi.getApproval_type());
		json.put("apply_time", myshenpi.getApply_time());
		json.put("approval_member", myshenpi.getApproval_member());
		json.put("apply_resource", myshenpi.getApply_resource());
		out.print(json);
		out.flush();
		out.close();	
		}
	
	}
	//进行审批
	public void shenpi()throws Exception{
	
		List<Approval> apps = approvalService.findmyshenpiByid(approval_id);
		String time = DateUtil.getNowStrDate();		
		Approval app=apps.get(0);
		System.out.println(approval_info);
		if(mydeal.equals("option1")){
		
		app.setApproval_info(approval_info);
		app.setApproval_schedule("已审批");
		app.setApproval_time(time);
		approvalService.update(app);
	}else{
		
		app.setApproval_info(approval_info);
		app.setApproval_schedule("未审批");
		app.setApproval_time(time);
		approvalService.update(app);
		}
		
		this.findMyapproval();
		}
		
	//新建申请（测试）
	public String addApply() throws Exception {
			
		String time = DateUtil.getNowStrDate();		
		// 设置上传文件目录
		String uploadPath = "d:\\IISMP\\Apply_file\\";
		//基于myFile创建一个文件输入流
		if(myFile.exists()&&myFile.length()>0){
		InputStream is = new FileInputStream(myFile);
		// 设置目标文件
		File toFile = new File(uploadPath, this.getMyFileFileName());
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);
		//设置缓存
		byte[] buffer = new byte[1024];
		int length = 0;
		myFileFileName = new String(myFileFileName);
		apply_resource = myFileFileName;
		//读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		Apply app=new Apply();
		app.setApply_id(apply_id);
		app.setApproval_member(apply_member);
		app.setApproval_type(approval_type);
		app.setApply_info(apply_info);
		app.setApply_time(time);
		app.setApply_member(apply_member);
		app.setApproval_schedule("未审批");
		app.setMember_section(member_section);
		
		Approval apr=new Approval();
		apr.setApproval_id(approval_id);
		apr.setApply_member(apply_member);
		apr.setApply_time(time);
		apr.setApproval_member(approval_member);
		apr.setApproval_section(member_section);
		apr.setApply_info(apply_info);
		apr.setApproval_schedule("未审批");
		apr.setApproval_type(approval_type);
		apr.setApply_resource(apply_resource);
		approvalService.addappro(apr);
		approvalService.addMyapply(app);
		
		
		//关闭输入流
		is.close();
		//关闭输出流
		os.close();
		this.ViewApply();
		}
		return "success";
		}
}
