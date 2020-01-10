package com.rms.action;

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

import com.rms.model.Learning_plan;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.AnnouncementQuery;


@SuppressWarnings("serial")
@Component("merberAction")
@Scope("prototype")
public class MerberAction extends BaseAction {
	HttpServletRequest request;
	private String m_username;
	private String m_password;
	private String m_truename;
	private String m_sectionname;
	private int m_id;
	private String lstarttime;
	private String lendtime;
	private int pageNow;
	
	
	public String getLstarttime() {
		return lstarttime;
	}
	public void setLstarttime(String lstarttime) {
		this.lstarttime = lstarttime;
	}
	public String getLendtime() {
		return lendtime;
	}
	public void setLendtime(String lendtime) {
		this.lendtime = lendtime;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_truename() {
		return m_truename;
	}
	public void setM_truename(String m_truename) {
		this.m_truename = m_truename;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_sectionname() {
		return m_sectionname;
	}
	public void setM_sectionname(String m_sectionname) {
		this.m_sectionname = m_sectionname;
	}
	/**
	 * 用户登录的方法
	 */
	public String loginAction() throws Exception {
		request = ServletActionContext.getRequest();		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60);
		//根据用户名查找用户
		List<MembershipInfo> merber = merberService.Login(m_username);
		//List<Announcement> announcement =announcementService.findAll(pageNow);
		String error = "";
		if(merber != null && merber.size()>0) {
			MembershipInfo m = merber.get(0);
			String pwd = m.getM_password();
			String passwd = m_password;
			if(pwd.equals(passwd)) {
				//查询出分组情况
				
				List<Section> section = systemsetService.findsectioninfo();
				request.setAttribute("sectionindex", section);
				session.setAttribute("memberinfo", m);
				
				if(pageNow<1){
					pageNow = 1;
				}
				//分页查询出所有的公告
				List<AnnouncementQuery> announcementQuery =announcementService.findAllannoBym_id(pageNow,m.getM_id());
				//查询出所有未读公告的数量
				int noState = announcementService.findnoStatenum(m.getM_id());
				request.setAttribute("noState", noState);
				session.setAttribute("announcementQuery", announcementQuery);
				
				/*Page p = new Page();
				p.setPageNow(pageNow);
				p.setPageSize(20);

				p.setTotalItemNumber(announcementService.findAllannonumBym_id(m.getM_id()));*/
				/*request.setAttribute("pageinfo", p);*/
				//List<MembershipInfo> membershipInfo =merberService.findall();
				//List<Announce_section> an_section=announcementService.findAll1();
				//request.setAttribute("weifabunum", announcementService.findweifabunum());
				//session.setAttribute("anno_section", an_section);
				//session.setAttribute("membershipInfo", membershipInfo);
				
				return "success";
			}
			//密码错误
			error = "密码输入错误，请重新输入！！";
			request.setAttribute("error", error);
			return "error";	
		}
		//用户名错误
		error = "用户名输入错误，请重新输入！！";
	
		//session.setAttribute("announcement", announcement);
		request.setAttribute("error", error);
		return "error";
	}
	
	/**
	 * 用户退出登录的方法
	 */
	public String logoutAction(){
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("memberinfo");
		return "success";
	}
	
	/**
	 * 查看通讯录
	 * @return
	 * @throws Exception
	 */
	public void openmemberinfosmethod() throws Exception{
		boolean isempty = false;
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		
		List<MembershipInfo> member = merberService.findallmemberinfos(m_sectionname);
		JSONArray jsona = new JSONArray();
		if(member != null && member.size() > 0){
			isempty = true;
			for(int i=0;i<member.size();i++){
				jsona.add(i, member.get(i));
			}
		}
		//Thread.sleep(5000);
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 首页查询出分组的方法
	 * @return
	 * @throws Exception
	 */
	public String findindexinfo() throws Exception{
		request = ServletActionContext.getRequest();	
		HttpSession session = request.getSession();
		MembershipInfo m = (MembershipInfo) session.getAttribute("memberinfo");
		//查询出分组情况
		List<Section> section = systemsetService.findsectioninfo();
		if(pageNow<1){
			pageNow = 1;
		}
		//分页查询出所有的公告
		List<AnnouncementQuery> announcementQuery =announcementService.findAllannoBym_id(pageNow,m.getM_id());
		//查询出所有未读公告的数量
		int noState = announcementService.findnoStatenum(m.getM_id());
		request.setAttribute("noState", noState);
		session.setAttribute("announcementQuery", announcementQuery);
		request.setAttribute("sectionindex", section);
		return "success";
	}
	
	/**
	 * 首页查看出学习计划的方法
	 */
	public void openmyplaninfosindex() throws Exception {
		request = ServletActionContext.getRequest();		
		HttpSession session = request.getSession();
		MembershipInfo ms = (MembershipInfo)session.getAttribute("memberinfo");
		boolean isempty = false;
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONArray jsona = new JSONArray();
		List<Learning_plan> lp = studyService.findalllearningplanindex(ms.getM_id(),lstarttime,lendtime); 
		if(lp!=null && lp.size()>0){
			isempty = true;
			for(int i=0;i<lp.size();i++){
				jsona.add(i, lp.get(i));
			}
		}
		JSONObject json = new JSONObject();
		json.put("isempty", isempty);
		json.put("jsona", jsona);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 首页查询出公告的方法
	 */
	public void findIndexAnnoun() throws Exception {
		request = ServletActionContext.getRequest();		
		HttpSession session = request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isEmpty= false;
		MembershipInfo m = (MembershipInfo) session.getAttribute("memberinfo");
		
		if(pageNow<1){
			pageNow = 1;
		}
		//分页查询出所有的公告
		List<AnnouncementQuery> announcementQuery =announcementService.findAllannoBym_id(pageNow,m.getM_id());
		JSONArray jsona = new JSONArray();
		for (AnnouncementQuery aq : announcementQuery) {
			jsona.add(aq);
		}
		
		//查询出所有未读公告的数量
		int noState = announcementService.findnoStatenum(m.getM_id());
		
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("noState", noState);
		json.put("isempty", isEmpty);
		out.print(json);
		out.flush();
		out.close();
	}
}
