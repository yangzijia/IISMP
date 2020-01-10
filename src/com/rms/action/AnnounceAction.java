package com.rms.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rms.model.Anno_Sendee;
import com.rms.model.Announce_section;
import com.rms.model.Announcement;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.Page;
import com.rms.util.DateUtil;

@SuppressWarnings("serial")
@Component("announceAction")
@Scope("prototype")
public class AnnounceAction extends BaseAction{
	
	HttpServletRequest request;
	private String announcement_info;
	private String announcement_time;
	private int announcement_id;
	private String announcement_title;
	private String as_updatetime;
	private int pageNow;
	private int as_amount;
	private int rowCount;
	private int pageCount;
	private String as_name;
	private int as_id;
	private String as_description;
	private List<Announcement> announcement;
	private List<Announce_section> announce_section;
	private String m_username;
	private String m_role;
	private int announcement_views;
	private String announcement_type;
	private String anno_editnote;
	private int id;
	private String an_jieshouren;
	private String getanno_member;
	private String an_type;
	
	
	public String getAn_type() {
		return an_type;
	}
	public void setAn_type(String an_type) {
		this.an_type = an_type;
	}
	public String getGetanno_member() {
		return getanno_member;
	}
	public void setGetanno_member(String getanno_member) {
		this.getanno_member = getanno_member;
	}
	public String getAn_jieshouren() {
		return an_jieshouren;
	}
	public void setAn_jieshouren(String an_jieshouren) {
		this.an_jieshouren = an_jieshouren;
	}
	public String getAnno_editnote() {
		return anno_editnote;
	}
	public void setAnno_editnote(String anno_editnote) {
		this.anno_editnote = anno_editnote;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnnouncement_type() {
		return announcement_type;
	}
	public void setAnnouncement_type(String announcement_type) {
		this.announcement_type = announcement_type;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public int getAnnouncement_views() {
		return announcement_views;
	}
	public void setAnnouncement_views(int announcement_views) {
		this.announcement_views = announcement_views;
	}
	public String getM_role() {
		return m_role;
	}
	public void setM_role(String m_role) {
		this.m_role = m_role;
	}
	public int getAs_amount() {
		return as_amount;
	}
	public void setAs_amount(int as_amount) {
		this.as_amount = as_amount;
	}
	public String getAs_updatetime() {
		return as_updatetime;
	}
	public void setAs_updatetime(String as_updatetime) {
		this.as_updatetime = as_updatetime;
	}
	public List<Announce_section> getAnnounce_section() {
		return announce_section;
	}
	public void setAnnounce_section(
			List<Announce_section> announce_section) {
		this.announce_section = announce_section;
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
	public List<Announcement> getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(List<Announcement> announcement) {
		this.announcement = announcement;
	}
	public String getAnnouncement_title() {
		return announcement_title;
	}
	public void setAnnouncement_title(String announcement_title) {
		this.announcement_title = announcement_title;
	}
	public int getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getAnnouncement_info() {
		return announcement_info;
	}
	public void setAnnouncement_info(String announcement_info) {
		this.announcement_info = announcement_info;
	}
	public String getAnnouncement_time() {
		return announcement_time;
	}
	public void setAnnouncement_time(String announcement_time) {
		this.announcement_time = announcement_time;
	}
	public String getAs_name() {
		return as_name;
	}
	public void setAs_name(String as_name) {
		this.as_name = as_name;
	}
	public int getAs_id() {
		return as_id;
	}
	public void setAs_id(int as_id) {
		this.as_id = as_id;
	}
	public String getAs_description() {
		return as_description;
	}
	public void setAs_description(String as_description) {
		this.as_description = as_description;
	}
	
	
	/**
	 * 显示已发布公告
	 */
	public String showAnnounceAction()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Announcement> announcement =announcementService.findAll(pageNow);
		List<Announce_section> an_section=announcementService.findAll1();
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);

		p.setTotalItemNumber(announcementService.findAllCount());
		request.setAttribute("weifabunum", announcementService.findweifabunum());
		request.setAttribute("pageinfo", p);
		session.setAttribute("anno_section", an_section);
		request.setAttribute("announcement", announcement);
		session.setAttribute("membershipInfo", membershipInfo);
		this.showSection();
		return "success";
	}
	
	/**
	 * 显示未发布公告
	 */
	public void showfAnnounceAction()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//接受查看的栏目 
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		if(pageNow<1){
			pageNow = 1;
		}

		List<Announcement> announcement =announcementService.findAnnoinfos(pageNow, announcement_type, as_name);
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		
		if(announcement != null && announcement.size() > 0){
			
			for(int i=0;i<announcement.size();i++){
				jsona.add(i, announcement.get(i));
				announcement_type=announcement.get(0).getAnnouncement_type();
			}
			p.setTotalItemNumber(announcementService.findallasno(announcement_type,as_name));
		}else {
			p.setTotalItemNumber(1);
			isempty = true;
		}
		isHasNext = p.isHasNext();
		isHasPrev = p.isHasPrev();
		pageCount = p.getpageCount(p.getTotalItemNumber());

		
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("m_role", m_role);
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
		this.showSection();
	}
	
	/**
	 * 保存并发布公告
	 */
	public void  publish1Action() throws Exception{
		System.out.println("slkdfjldj----------");
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		String time = DateUtil.getStringDate();
System.out.println(an_jieshouren);
		List<String> delList = new ArrayList<String>();
		String[] strs = an_jieshouren.split(",");
		for (String str : strs) {
		    delList.add(str);
		}
		
		if("add".equals(an_type)){
			Announcement an=new Announcement();
			an.setAs_name(as_name);
			an.setAnnouncement_title(announcement_title);
System.out.println("announcement_title.length()======"+announcement_title.length());
			if(announcement_title.length()>14){
				an.setAnnoun_title(announcement_title.substring(0,13)+"...");
			}else{
				an.setAnnoun_title(announcement_title);
			}
			an.setAnnouncement_info(announcement_info);
			an.setAnnouncement_time(time);
			an.setM_username(memberinfo.getM_truename());
			an.setAnnouncement_type("保存并发布");
			an.setAn_jieshouren(an_jieshouren);
			an.setGetanno_member(getanno_member);
			int anno_id = announcementService.saveAnnouncementToReturnId(an);
			for(int i=0;i<delList.size();i++){
				Anno_Sendee as = new Anno_Sendee();
				as.setM_id(Integer.parseInt(delList.get(i)));
				as.setState(2);
				as.setAn_id(anno_id);
				announcementService.publish(as);	
			}
		}else if("edit".equals(an_type)){
			Announcement an=new Announcement();
			an.setAs_name(as_name);
			an.setAnnouncement_title(announcement_title);
			if(announcement_title.length()>14){
				an.setAnnoun_title(announcement_title.substring(0,13)+"...");
			}else{
				an.setAnnoun_title(announcement_title);
			}
			an.setAnnouncement_info(announcement_info);
			an.setAnnouncement_time(time);
			an.setAnnouncement_id(announcement_id);
			an.setM_username(memberinfo.getM_truename());
			an.setAnnouncement_type("保存并发布");
			an.setAn_jieshouren(an_jieshouren);
			an.setGetanno_member(getanno_member);
			//根据announcement_id更改Announcement的内容
			announcementService.updateAnno(an);
			//根据an_id（announcement_id）删除所有的归属公告
			announcementService.deleteAnno_SendeeByan_id(announcement_id);
			//重新添加归属公告
			for(int i=0;i<delList.size();i++){
				Anno_Sendee as = new Anno_Sendee();
				as.setM_id(Integer.parseInt(delList.get(i)));
				as.setState(2);
				as.setAn_id(announcement_id);
				announcementService.publish(as);	
			}
		}
	}
		
	/**
	 * 保存公告
	 */
	public void  publish2Action()throws Exception{
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		String time = DateUtil.getStringDate();
		List<String> delList = new ArrayList<String>();
		String[] strs = an_jieshouren.split(",");
		for (String str : strs) {
		    delList.add(str);
		}
		
		Announcement an=new Announcement();
		an.setAs_name(as_name);
		an.setAnnouncement_title(announcement_title);
		if(announcement_title.length()>14){
			an.setAnnoun_title(announcement_title.substring(0,13)+"...");
		}else{
			an.setAnnoun_title(announcement_title);
		}
		an.setAnnouncement_info(announcement_info);
		an.setAnnouncement_time(time);
		//an.setM_role(m_role);
		an.setM_username(memberinfo.getM_truename());
		an.setAnnouncement_type("保存未发布");
		an.setAn_jieshouren(an_jieshouren);
		an.setGetanno_member(getanno_member);
		int anno_id = announcementService.saveAnnouncementToReturnId(an);
		for(int i=0;i<delList.size();i++){
			Anno_Sendee as = new Anno_Sendee();
			as.setM_id(Integer.parseInt(delList.get(i)));
			as.setState(2);
			as.setAn_id(anno_id);
			announcementService.publish(as);	
		}			
	}
		
	/**
	 * 根据id详细查看公告
	 */
	public String findAinfobyid()throws Exception{
		request = ServletActionContext.getRequest();
		List<Announcement> announcement=announcementService.findAllinfobyid(announcement_id);
		
		if(announcement!=null&&announcement.size()>0){
		Announcement an=announcement.get(0);
		ServletActionContext.getServletContext().setAttribute("views", an.getAnnouncement_views());
	
		request.setAttribute("announcementinfo",announcement);
		//ServletContext application = request.getSession().getServletContext(); 
		
		an.setAnnouncement_views(an.getAnnouncement_views()+1);
		announcementService.changeviews(an);
		
		return "success";
		}
		return "error";
	}
		
	/**
	 * 查看上一条详细公告
	 */
	/*public void  findLast()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
	
		List<Announcement> announcement1=announcementService.findLoad(id);	
		if(announcement1!=null&&announcement1.size()>0){
		Announcement an=announcement1.get(0);	
		List<Announcement> announcement=announcementService.findAllinfobyid(an.getAnnouncement_id());	
		if(announcement!=null&&announcement.size()>0){
		Announcement ann=announcement.get(0);
		JSONObject json = new JSONObject();

		json.put("announcement_title", ann.getAnnouncement_title());
		json.put("an_username", ann.getM_username());
		json.put("announcement_time", ann.getAnnouncement_time());
		json.put("as_name", ann.getAs_name());
		json.put("announcement_views", ann.getAnnouncement_views());
		json.put("announcement_info", ann.getAnnouncement_info());
		json.put("announcement_id", ann.getAnnouncement_id());
		out.print(json);
		out.flush();
		out.close();
	
		}

		}
	}*/
		
	/**
	 * 查看下一条详细公告
	 */
	/*public void findNext()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Announcement> announcement2=announcementService.findNext(id);	
		if(announcement2!=null&&announcement2.size()>0){
			Announcement an=announcement2.get(0);
			List<Announcement> announcement=announcementService.findAllinfobyid(an.getAnnouncement_id());	
			if(announcement!=null&&announcement.size()>0){
			Announcement ann=announcement.get(0);
			JSONObject json = new JSONObject();
			json.put("announcement_title", ann.getAnnouncement_title());
			json.put("an_username", ann.getM_username());
			json.put("announcement_time", ann.getAnnouncement_time());
			json.put("as_name", ann.getAs_name());
			json.put("announcement_views", ann.getAnnouncement_views());
			json.put("announcement_info", ann.getAnnouncement_info());
			json.put("announcement_id", ann.getAnnouncement_id());
			out.print(json);
			out.flush();
			out.close();
	
			}
		}
	}*/
		
	/**
	 * 根据id删除公告
	 */
	public void deletethisannounbyid() throws Exception{
		Announcement s = new Announcement();
		s.setAnnouncement_id(announcement_id);
		//删除栏目的方法
		announcementService.deleteAbyid(s);
		this.fanye();
	}	
		
	/**
	 * 查看栏目
	 */
	public String showSection() throws Exception{
		request = ServletActionContext.getRequest();
		List<Announce_section> as =announcementService.findAll1();
		request.setAttribute("an_section", as);
		return "success";
	}

	/**
	 * 添加栏目
	 * dzz
	 */
	public void addSection()throws Exception{
	/*	HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();*/
		String time = DateUtil.getNowStrDate();
		Announce_section as=new Announce_section();
		as.setAs_name(as_name);
		as.setAs_description(as_description);	
		as.setAs_updatetime(time);
		announcementService.addSection(as);
		this.refreshAsectionAciton();
	}
	
	/**
	 * 编辑栏目
	 */
	public void changeSectionByid()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Announce_section as=announcementService.changeSectionByid(as_id);
		JSONObject json = new JSONObject();
		json.put("as_name", as.getAs_name());
		json.put("as_description",as.getAs_description() );
		json.put("as_id", as.getAs_id());
		json.put("as_updatetime", as.getAs_updatetime());
		out.print(json);
		out.flush();
		out.close();
		
}
	
	/**
	 * 删除栏目的方法
	 * @throws Exception
	 * @author dzz
	 * @data 2016-10-21
	 */
	public void deleteAsectionbyid() throws Exception {
		Announce_section s = new Announce_section();
		s.setAs_id(as_id);
		//删除栏目的方法
		announcementService.deleteSection(s);
		//刷新section的列表信息
		this.refreshAsectionAciton();
	}

	/**
	 *保存编辑后的栏目信息
	 * @throws Exception
	 * @author dzz
	 * @data 2016-10-21
	 */
	public void save_Aseditinfo() throws Exception {
		String time = DateUtil.getNowStrDate();
		Announce_section s=announcementService.changeSectionByid(as_id);		
		s.setAs_name(as_name);
		s.setAs_description(as_description);
		s.setAs_amount(as_amount);
		s.setAs_updatetime(time);
		//刷新Announce_section数据表的数据
		announcementService.updateA_sectioninfo(s);
		//刷新Announce_section的列表信息
		this.refreshAsectionAciton();
	}
	
	/**
	 * 刷新栏目列表的信息的方法
	 * @throws Exception
	 * @author dzz
	 * @data 2016-10-21
	 */
	public void refreshAsectionAciton() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//查询出所有的栏目的方法
		List<Announce_section> section = announcementService.findAll1();
		
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
	 * 翻页刷新页面
	 * @throws Exception
	 */
	public  void fanye() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//接受查看的栏目 
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		
		//分页查的列表信息
		List<Announcement> ano = announcementService.findAnnoinfos(pageNow,announcement_type,as_name);
		Page p = new Page();
		if(ano != null && ano.size() > 0){
			
			for(int i=0;i<ano.size();i++){
				jsona.add(i, ano.get(i));
			}
			p.setTotalItemNumber(announcementService.findallasno(announcement_type, as_name));
		}else {
			p.setTotalItemNumber(1);
			isempty = true;
		}
		
		//查询出该栏目有多少条已发布和未发布的方法
		int yifabunum = announcementService.findyifabunumbytype(announcement_type,as_name);
		int weifabunum = announcementService.findweifabunumbytype(announcement_type,as_name);
		
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
		json.put("yifabunum", yifabunum);
		json.put("weifabunum", weifabunum);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据栏目名查看公告
	 * @throws Exception
	 */
	public String findasanno() throws Exception{
		System.out.println(pageNow+"-"+announcement_type+"-"+as_name);
		request = ServletActionContext.getRequest();
		//接受查看的栏目 
		if(pageNow<1){
			pageNow = 1;
		}
		//分页查询出公告的列表信息
		announcement_type = new String(request.getParameter("announcement_type").getBytes("ISO8859-1"), "UTF-8");
		as_name = new String(request.getParameter("as_name").getBytes("ISO8859-1"), "UTF-8");
		System.out.println(pageNow+"-"+announcement_type+"-"+as_name);
		List<Announcement> msi = announcementService.findAnnoinfos(pageNow, announcement_type, as_name);
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(announcementService.findyifabunumbytype(announcement_type, as_name));
		pageCount = p.getpageCount(p.getTotalItemNumber());
		
		request.setAttribute("pageinfo", p);
		request.setAttribute("announcement", msi);
		request.setAttribute("weifabunum", announcementService.findallasno("保存未发布",as_name));
		request.setAttribute("returnas_name", as_name);
		this.showSection();
		return "success";
	}
	
	/**
	 * 根据id对未发布的公告进行编辑发布
	 * @return
	 * @throws Exception
	 */
	public String  editAnnoByid()throws Exception{
		request = ServletActionContext.getRequest();
		List<Announcement> ament=announcementService.findAllinfobyid(announcement_id);
		if(ament!=null&&ament.size()>0){
			//Announcement ann=ament.get(0);gg
			List<Section> section = systemsetService.findsectioninfo();
			List<MembershipInfo> msi = systemsetService.findAllUseMember();
			request.setAttribute("sectioninfo", section);
			request.setAttribute("msiinfo", msi);
			request.setAttribute("ament", ament);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 编辑公告的方法
	 * @throws Exception
	 */
	public void editanno() throws Exception {
		/*HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();*/
		String time = DateUtil.getStrDate_24();
		
		List<Announcement> ament=announcementService.findAllinfobyid(announcement_id);
		if(ament!=null&&ament.size()>0){
			Announcement ann=ament.get(0);
			ann.setAnnouncement_info(announcement_info);
			ann.setAs_name(as_name);
			ann.setAnnouncement_time(time);
			if(announcement_title.length()>14){
				ann.setAnnoun_title(announcement_title.substring(0,13)+"...");
			}else{
				ann.setAnnoun_title(announcement_title);
			}
			ann.setAnnouncement_title(announcement_title);
			ann.setAnnouncement_type("保存并发布");
			announcementService.updateAnno(ann);
		}
	}
	
	/**
	 * 根据id查看公告的详细信息的方法
	 */
	public void findthisannouncementinfoByid() throws Exception{
		System.out.println("aaaaaaaaaa");
		request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		MembershipInfo m = (MembershipInfo) session.getAttribute("memberinfo");

		//根据an_id和m_id从Anno_sendee修改所读取公告的state
		announcementService.updateAnno_sendeeToState(m.getM_id(),announcement_id);
		
		//查询出所有未读公告的数量
		int noState = announcementService.findnoStatenum(m.getM_id());
		
		List<Announcement> announcement=announcementService.findAllinfobyid(announcement_id);
		System.out.println(announcement_id);
		//浏览次数+1
		Announcement an=announcement.get(0);
		an.setAnnouncement_views(an.getAnnouncement_views()+1);
		announcementService.changeviews(an);
		
		JSONObject json = new JSONObject();
		json.put("announcement_title", an.getAnnouncement_title());
		json.put("announcement_views", an.getAnnouncement_views());
		json.put("announcement_time", an.getAnnouncement_time());
		json.put("faburen", an.getM_username());
		json.put("suoshuleixing", an.getAs_name());
		json.put("announinfo", an.getAnnouncement_info());
		json.put("noState", noState);
		out.print(json);
		out.flush();
		out.close();	
	}
	
	/**
	 * 将json数据返回到前端界面的方法
	 * @param json
	 * @throws IOException
	 */
	public void setPrintWritermethod(JSONObject json) throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	} 
	
	/**
	 * 查看所有的成员分组和成员信息的方法
	 * @throws Exception
	 */
	public String openanno_newpage() throws Exception{
		System.out.println("openanno_newpage");
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Section> section = systemsetService.findsectioninfo();
		List<MembershipInfo> msi = systemsetService.findAllUseMember();
		request.setAttribute("sectioninfo", section);
		request.setAttribute("msiinfo", msi);
		return "success";
	}
	
}