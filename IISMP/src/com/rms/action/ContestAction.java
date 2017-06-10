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

import com.rms.model.Contest;
import com.rms.model.MembershipInfo;
import com.rms.model.Project;
import com.rms.model.Section;
import com.rms.page.Page;
import com.rms.util.DateUtil;

/** * @author  作者 dzz: 
 * @date 创建时间：2016-11-27 下午9:14:36
 * @parameter  
 */
@SuppressWarnings("serial")
@Component("contestAction")
@Scope("prototype")
public class ContestAction extends BaseAction{
	HttpServletRequest request;
	private int rowCount;
	private String contets_url;
	private int pageCount;
	private int pageNow;
	private int contest_id;
	private int project_id;
	private String contest_title;
	private String contest_time;
	private String contest_place;
	private String project_name;
	private String project_member;
	private String project_info;
	private String project_awads;
	private String contest_experience;
	private String project_section;	
	private String project_file;
	private String myFile;
	private String myFileFileName;
	private String newfilename;
	
	public String getMyFile() {
		return myFile;
	}
	public void setMyFile(String myFile) {
		this.myFile = myFile;
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
	
	public String getProject_file() {
		return project_file;
	}
	public void setProject_file(String project_file) {
		this.project_file = project_file;
	}
	public String getProject_section() {
		return project_section;
	}
	public void setProject_section(String project_section) {
		this.project_section = project_section;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
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
	public int getContest_id() {
		return contest_id;
	}
	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}
	public String getContest_title() {
		return contest_title;
	}
	public void setContest_title(String contest_title) {
		this.contest_title = contest_title;
	}
	public String getContest_time() {
		return contest_time;
	}
	public void setContest_time(String contest_time) {
		this.contest_time = contest_time;
	}
	public String getContest_place() {
		return contest_place;
	}
	public void setContest_place(String contest_place) {
		this.contest_place = contest_place;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_member() {
		return project_member;
	}
	public void setProject_member(String project_member) {
		this.project_member = project_member;
	}
	public String getProject_info() {
		return project_info;
	}
	public void setProject_info(String project_info) {
		this.project_info = project_info;
	}
	public String getProject_awads() {
		return project_awads;
	}
	public void setProject_awads(String project_awads) {
		this.project_awads = project_awads;
	}
	public String getContest_experience() {
		return contest_experience;
	}
	public void setContest_experience(String contest_experience) {
		this.contest_experience = contest_experience;
	}
	public String getContets_url() {
		return contets_url;
	}
	public void setContets_url(String contets_url) {
		this.contets_url = contets_url;
	}
	
	/**
	 *初始界面显示比赛
	 */
	public String ShowContestAction() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Section> sections=systemsetService.findsectioninfo();
		List<Project> project =contestService.findAllP1();
		session.setAttribute("sections", sections);
		session.setAttribute("project", project);
		/*List<Contest> equipment =equipmentService.findAll(pageNow);//查询一页*/		
		List<Contest> contest=contestService.findAll();//查询所有名称
		session.setAttribute("contest", contest);
		session.setAttribute("membershipInfo", membershipInfo);
		return "success";
		
	}
	
	/**
	 * 根据id查看比赛详情
	 */
	public void findConByid() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		List<Contest> contest=contestService.findCbyid(contest_id);
		

		if(contest!=null&&contest.size()>0){
			Contest c=contest.get(0);	
			json.put("project_name",c.getProject_name() );
			json.put("project_member", c.getProject_member());
			json.put("contest_time",c.getContest_time() );
			json.put("contest_place",c.getContest_place() );
			json.put("project_info", c.getProject_info());
			json.put("project_awads", c.getProject_awads());
			json.put("contest_experience", c.getContest_experience());
			json.put("contest_id", c.getContest_id());
			json.put("c_image", c.getC_image());
			
			out.print(json);
			out.flush();
			out.close();
		}
	}
	
	/*
	 * 根据id查看比赛详情,进行编辑
	 * */
	public String findCByid() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Contest> contest=contestService.findCbyid(contest_id);
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Section>sections=systemsetService.findsectioninfo();
		/*if(contest!=null&contest.size()>0){
			Contest c=contest.get(0);
		}*/
		session.setAttribute("contest", contest);
		session.setAttribute("sections", sections);
		session.setAttribute("membershipInfo", membershipInfo);
		return "success";
		
	}
	
	
	//保存比赛编辑信息
	public void SaveCon() throws Exception{
		/*
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();*/
		List<Contest> contest=contestService.findCbyid(contest_id);
		if(contest!=null&&contest.size()>0){
			Contest c=contest.get(0);	
			c.setProject_name(project_name);
			c.setProject_awads(project_awads);
			c.setProject_member(project_member);
			c.setProject_info(project_info);
			c.setContest_place(contest_place);
			c.setContest_time(contest_time);
			c.setContest_experience(contest_experience);
		
			contestService.updateContest(c);
	}
		
}
	//增加比赛 
	public void addContest()throws Exception{
		/*request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();*/
		Contest con=new Contest();
		con.setContest_experience(contest_experience);
		con.setContest_id(contest_id);
		con.setContest_place(contest_place);
		con.setContest_time(contest_time);
		con.setContets_url(contets_url);
		con.setProject_member(project_member);
		con.setProject_name(project_name);
		con.setContest_title(contest_title);		
		
		contestService.addcon(con);
		
	}
	//查看参赛项目
	public String ShowProjectAction() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Project> project =contestService.findAllP(pageNow);
		List<Section>sections=systemsetService.findsectioninfo();
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(contestService.findAllCount());
		request.setAttribute("pageinfo", p);	
		request.setAttribute("project", project);
		session.setAttribute("membershipInfo", membershipInfo);
		session.setAttribute("section", sections);
		return "success";
	
	}
	
	//根据id查看项目详情
	public void findProByid() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		List<Project> project=contestService.findPbyid(project_id);
		if(project!=null&&project.size()>0){
			Project p=project.get(0);	
		json.put("project_name",p.getProject_name() );
		json.put("project_info", p.getProject_info());
		json.put("project_awards", p.getProject_awads());
		json.put("contest_experience", p.getContest_experience());
		json.put("project_section", p.getSection_name());
		out.print(json);
		out.flush();
		out.close();
		}
	}
	
	
	//增加项目
	public void addProject()throws Exception{
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		String time = DateUtil.getStringDate();
		Project pr=new Project();
		pr.setProject_id(project_id);
		pr.setProject_name(project_name);
		pr.setSection_name(project_section);
		pr.setProject_info(project_info);
		pr.setProject_uptime(time);
		pr.setProject_principal(memberinfo.getM_username());
		contestService.addproject(pr);
		
	}
	
	//对项目编辑信息进行保存
	public void saveProject()throws Exception{
		/*HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();*/
		
		List<Project> project=contestService.findPbyid(project_id);
		if(project!=null&&project.size()>0){
			Project p=project.get(0);	
			String time = DateUtil.getStringDate();
			p.setProject_name(project_name);
			p.setProject_info(project_info);
			p.setSection_name(project_section);
			p.setProject_uptime(time);
			contestService.upproject(p);
	}
}
	/**
	 * 上传文件的方法
	 */
	public String uploadProAction() throws Exception {
		request = ServletActionContext.getRequest();
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置日期格式
		String aa = DateUtil.getLongDate();
		
		myFileFileName = new String(myFileFileName);
		
		//修改tupian的方法
		
		request.setAttribute("newfilename", newfilename);
		project_file = aa + myFileFileName;
		HttpSession session = ServletActionContext.getRequest().getSession();
		@SuppressWarnings("unchecked")
		List<Project> con = (List<Project>)session.getAttribute("project");
		Project p=con.get(0);		
		p.setProject_file(project_file);
		contestService.upproject(p);
		// 设置目标文件
		File toFile = new File("d:\\IISMP\\Project_resource", project_file);
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
		
		return "success";
	}
	
	/**
	 * 比赛图片上传
	 * @return
	 * @throws Exception
	 */
	public String  updateconimage() throws Exception {
		request = ServletActionContext.getRequest();
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置日期格式
		String aa = DateUtil.getLongDate();	
		myFileFileName = new String(myFileFileName);
		newfilename = "contestimage_" + aa + myFileFileName;
		 //定义上传路径  
	    String path = System.getProperty("user.dir").replace("bin", "webapps");
	    path = path.replaceAll("\\\\", "/")+"/IISMP//contestimage/";
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		@SuppressWarnings("unchecked")
		List<Contest> con = (List<Contest>)session.getAttribute("contest");
		Contest cc=con.get(0);
		cc.setC_image("contestimage/"+newfilename);
		//修改tupian的方法
		contestService.updateContest(cc);
		return "success";
		
	}
	
	//刷新项目	
	public void refreshproject()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		int pagNow=1;
		List<Project> re=contestService.findAllP(pagNow);
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