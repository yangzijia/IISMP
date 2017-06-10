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

import com.rms.model.Learning_Log;
import com.rms.model.Learning_plan;
import com.rms.model.Log_type;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.Page;
import com.rms.util.DateUtil;


@SuppressWarnings("serial")
@Component("studyAction")
@Scope("prototype")
public class StudyAction extends BaseAction{
	HttpServletRequest request;
	private int id;
	private String ltitle;
	private String lcontent;
	private String lsummarize;
	private String lstarttime;
	private String lendtime;
	private int pageNow;
	private String time11;
	private String time22;
	private String sectionname;
	private String lt_name;
	private int l_id;
	private String l_subject;//题目
	private String l_content;//内容
	private String l_time;
	private String l_state;//状态
	private int lt_id;
	private String lt_remark;
	private String l_comment;
	private String l_purview;
	
	
	
	
	/**dong
	 * @return the l_purview
	 */
	public String getL_purview() {
		return l_purview;
	}
	/**
	 * @param l_purview the l_purview to set
	 */
	public void setL_purview(String l_purview) {
		this.l_purview = l_purview;
	}
	/**dong
	 * @return the l_comment
	 */
	public String getL_comment() {
		return l_comment;
	}
	/**
	 * @param l_comment the l_comment to set
	 */
	public void setL_comment(String l_comment) {
		this.l_comment = l_comment;
	}
	/**dong
	 * @return the lt_remark
	 */
	public String getLt_remark() {
		return lt_remark;
	}
	/**
	 * @param lt_remark the lt_remark to set
	 */
	public void setLt_remark(String lt_remark) {
		this.lt_remark = lt_remark;
	}
	/**dong
	 * @return the lt_id
	 */
	public int getLt_id() {
		return lt_id;
	}
	/**
	 * @param lt_id the lt_id to set
	 */
	public void setLt_id(int lt_id) {
		this.lt_id = lt_id;
	}
	/**dong
	 * @return the l_id
	 */
	public int getL_id() {
		return l_id;
	}
	/**
	 * @param l_id the l_id to set
	 */
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	/**dong
	 * @return the l_subject
	 */
	public String getL_subject() {
		return l_subject;
	}
	/**
	 * @param l_subject the l_subject to set
	 */
	public void setL_subject(String l_subject) {
		this.l_subject = l_subject;
	}
	/**dong
	 * @return the l_content
	 */
	public String getL_content() {
		return l_content;
	}
	/**
	 * @param l_content the l_content to set
	 */
	public void setL_content(String l_content) {
		this.l_content = l_content;
	}
	/**dong
	 * @return the l_time
	 */
	public String getL_time() {
		return l_time;
	}
	/**
	 * @param l_time the l_time to set
	 */
	public void setL_time(String l_time) {
		this.l_time = l_time;
	}
	/**dong
	 * @return the l_state
	 */
	public String getL_state() {
		return l_state;
	}
	/**
	 * @param l_state the l_state to set
	 */
	public void setL_state(String l_state) {
		this.l_state = l_state;
	}
	/**dong
	 * @return the lt_name
	 */
	public String getLt_name() {
		return lt_name;
	}
	/**
	 * @param lt_name the lt_name to set
	 */
	public void setLt_name(String lt_name) {
		this.lt_name = lt_name;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getTime11() {
		return time11;
	}
	public void setTime11(String time11) {
		this.time11 = time11;
	}
	public String getTime22() {
		return time22;
	}
	public void setTime22(String time22) {
		this.time22 = time22;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLtitle() {
		return ltitle;
	}
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
	public String getLcontent() {
		return lcontent;
	}
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}
	public String getLsummarize() {
		return lsummarize;
	}
	public void setLsummarize(String lsummarize) {
		this.lsummarize = lsummarize;
	}
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
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	/**
	 * 查询出该用户的所有学习计划
	 */
	public String findlearnplaninfo() throws Exception {
		request = ServletActionContext.getRequest();
		if(pageNow<1){
			pageNow=1;
		}
		//查询出所有的学习计划
		List<Learning_plan> lp = studyService.findalllearnplan(pageNow,lstarttime,lendtime);
		long lpnums = studyService.findalllearnplannum(lstarttime,lendtime);
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(lpnums);
		request.setAttribute("lpinfo", lp);
		request.setAttribute("pinfo", p);
		request.setAttribute("lpnums", lpnums);
		return "success";
	}
	
	/**
	 * 动态刷新界面的方法
	 */
	public void flushlearnplaninfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONArray jsona = new JSONArray();
		boolean isempty= false;
		boolean isHasPrev = false;
		boolean isHasNext = false;
		long pageCount = 1;
		int prevpage =0;
		int nextpage = 0;

		if(pageNow<1){
			pageNow=1;
		}
		//查询出所有的学习计划

		List<Learning_plan> lp = studyService.findalllearnplan(pageNow,lstarttime,lendtime);
		if(lp != null && lp.size()>0){
			isempty = true;
			for(int i=0;i<lp.size();i++){
				jsona.add(i, lp.get(i));
			}
		}
		long lpnums = studyService.findalllearnplannum(lstarttime,lendtime);
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(lpnums);
		if(lpnums!=0){
			pageCount = p.getpageCount(lpnums);
		}
		if(p.isHasPrev()){
			isHasPrev = p.isHasPrev();
			prevpage = p.getPrevPage();
		}
		if(p.isHasNext()){
			isHasNext = p.isHasNext();
			nextpage = p.getNextPage();
		}
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isHasPrev", isHasPrev);
		json.put("isHasNext", isHasNext);
		json.put("pageNow", pageNow);
		json.put("pageCount", pageCount);
		json.put("isempty", isempty);
		json.put("prevpage", prevpage);
		json.put("nextpage", nextpage);
		out.print(json);
		out.flush(); 
		out.close();
	}
	
	/**
	 * 立即发布的方法
	 */
	public void lijifabumethod() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		Learning_plan lp = new Learning_plan();
		
		lp.setLcontent(lcontent);
		lp.setLendtime(lendtime);
		lp.setLstarttime(lstarttime);
		lp.setLsummarize(lsummarize);
		String daylong = DateUtil.getTwoDay(lendtime, lstarttime);
		lp.setLdaylong((Integer.parseInt(daylong)+1)+"");
		lp.setLtitle(ltitle);
		lp.setM_id(me.getM_id());
		lp.setUsername(me.getM_truename());
		lp.setSectionname(me.getM_sectionname());
		lp.setUpdatetime(DateUtil.getNowStrDate());
		
		studyService.addlearningplan(lp);
	}
	
	/**
	 * 根据id查询出计划信息并用json返回到前台界面
	 */
	public void findthisplaninfobyid() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据id查询出计划信息
		List<Learning_plan> lpinfo = studyService.findthislearningplaninfobyid(id);
		JSONObject json = new JSONObject();
		for(int i=0;i<lpinfo.size();i++){
			Learning_plan l = lpinfo.get(0);
			json.put("lcontent", l.getLcontent());
			json.put("lendtime", l.getLendtime());
			json.put("lstarttime", l.getLstarttime());
			json.put("lsummarize", l.getLsummarize());
			json.put("ltitle", l.getLtitle());
			json.put("updatetime", l.getUpdatetime());
			json.put("ldaylong", l.getLdaylong());
			json.put("id", l.getId());
		}
		out.print(json);
		out.flush(); 
		out.close();
	}
	
	/**
	 * 根据id查询出该条计划的详细信息，显示到编辑模态框上
	 * @author yangzijia
	 */
	public void findthisplaninfoandshow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据id查询出计划信息
		List<Learning_plan> lpinfo = studyService.findthislearningplaninfobyid(id);
		JSONObject json = new JSONObject();
		for(int i=0;i<lpinfo.size();i++){
		Learning_plan l = lpinfo.get(0);
		json.put("lcontent", l.getLcontent());
		json.put("lendtime", l.getLendtime());
		json.put("lstarttime", l.getLstarttime());
		json.put("lsummarize", l.getLsummarize());
		json.put("ltitle", l.getLtitle());
		json.put("updatetime", l.getUpdatetime());
		json.put("ldaylong", l.getLdaylong());
		json.put("id", l.getId());
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 保存修改后的计划信息
	 * @throws Exception
	 */
	public void updatelearnplan() throws Exception {
		//根据id查询出计划信息
		List<Learning_plan> lpinfo = studyService.findthislearningplaninfobyid(id);
		Learning_plan lp = lpinfo.get(0);
		lp.setLcontent(lcontent);
		lp.setLendtime(time22);
		lp.setLstarttime(time11);
		lp.setLsummarize(lsummarize);
		String daylong = DateUtil.getTwoDay(time22, time11);
		lp.setLdaylong((Integer.parseInt(daylong)+1)+"");
		lp.setLtitle(ltitle);
		lp.setUpdatetime(DateUtil.getNowStrDate());
		//将修改后的计划信息保存到数据库中
		studyService.updatelearnplan(lp);
		flushlearnplaninfo();
	}
	
	/**
	 * 根据id删除这条计划的方法
	 */
	public void deletethisplanbyid() throws Exception {
		//根据id查询出计划信息
		List<Learning_plan> lpinfo = studyService.findthislearningplaninfobyid(id);
		Learning_plan lp = lpinfo.get(0);
		studyService.deletethisplanbyid(lp);
		flushlearnplaninfo();
	}
	
	/**
	 * 查询出所有成员的计划的方法
	 */
	public String findallplaninfo() throws Exception {
		request = ServletActionContext.getRequest();
		if(pageNow<1){
			pageNow=1;
		}
		List<Learning_plan> lp = studyService.findalluserplan(lstarttime,lendtime,pageNow,sectionname);
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(studyService.findalluserplannum(lstarttime,lendtime,sectionname));
		//查询出所有分组的方法
		List<Section> section = systemsetService.findsectioninfo();
		request.setAttribute("sectioninfo", section);
		request.setAttribute("lpinfo", lp);
		request.setAttribute("pinfo", p);
		return "success";
	}
	
	/**
	 * 分页查看所有成员计划的方法
	 * @throws Exception
	 */
	public void flushallplaninfo() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		JSONArray jsona = new JSONArray();
		boolean isempty= false;
		boolean isHasPrev = false;
		boolean isHasNext = false;
		long pageCount = 1;
		int prevpage =0;
		int nextpage = 0;
		if(pageNow<1){
			pageNow=1;
		}
		//查询出所有的学习计划
		List<Learning_plan> lp = studyService.findalluserplan(time11,time22,pageNow,sectionname);
		if(lp != null && lp.size()>0){
			isempty = true;
			for(int i=0;i<lp.size();i++){
				jsona.add(i, lp.get(i));
			}
		}
		long lpnums = studyService.findalluserplannum(time11,time22,sectionname);
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(lpnums);
		if(lpnums!=0){
			pageCount = p.getpageCount(p.getTotalItemNumber());
		}
		if(p.isHasPrev()){
			isHasPrev = p.isHasPrev();
			prevpage = p.getPrevPage();
		}
		if(p.isHasNext()){
			isHasNext = p.isHasNext();
			nextpage = p.getNextPage();
		}
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isHasPrev", isHasPrev);
		json.put("isHasNext", isHasNext);
		json.put("pageNow", pageNow);
		json.put("pageCount", pageCount);
		json.put("isempty", isempty);
		json.put("prevpage", prevpage);
		json.put("nextpage", nextpage);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据id查询出计划的详细方法
	 * @throws Exception
	 */
	public void findallplaninfobyid() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据id查询出计划信息
		List<Learning_plan> lpinfo = studyService.findthislearningplaninfobyid(id);
		JSONObject json = new JSONObject();
		for(int i=0;i<lpinfo.size();i++){
			Learning_plan l = lpinfo.get(0);
			json.put("lcontent", l.getLcontent());
			json.put("lendtime", l.getLendtime());
			json.put("lstarttime", l.getLstarttime());
			json.put("lsummarize", l.getLsummarize());
			json.put("username", l.getUsername());
			json.put("ltitle", l.getLtitle());
			json.put("updatetime", l.getUpdatetime());
			json.put("ldaylong", l.getLdaylong());
			json.put("id", l.getId());
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	
	///日志模块
	/**
	 * 查询全部日志
	 */
	public String findloginfo() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow=1;
		}
		
		//查询出所有的学习日志
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		String memname=me.getM_username();
		List<Learning_Log> log = studyService.findLog(pageNow,memname);//查询不是自己的日志
		List<Learning_Log> mylog=studyService.findmylog(memname);//查询自己的日志
		List<Log_type> ltype=studyService.findltype();
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);		
		request.setAttribute("log", log);
		request.setAttribute("mylog", mylog);
		request.setAttribute("pinfo", p);		
		session.setAttribute("logtype", ltype);
		
		return "success";
	}
	
	/**
	 * 根据日志类型查看日志
	 */
	public void ViewLogbyType() throws Exception{
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
		
		//分页查询出公告的列表信息
		List<Learning_Log> llog = studyService.findLogs(pageNow, lt_id);	
		List<Log_type> logtype=studyService.findLTbyid(lt_id);	
		lt_name=logtype.get(0).getLt_name();
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		if(llog != null && llog.size() > 0){		
		for(int i=0;i<llog.size();i++){
		jsona.add(i, llog.get(i));
		
		}
		
		p.setTotalItemNumber(studyService.findlogs_num(lt_id));
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
		json.put("lt_name", lt_name);
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
	
	//查看日志类型
	public String  ViewLogtype()throws Exception{
		request = ServletActionContext.getRequest();
		List<Log_type> logtype=studyService.findltype();
		request.setAttribute("logtype", logtype);
		return "success";		
	}
	
	
	
	//根据id查看日志类型 log_type
	public void findLTbyid()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Log_type> logtype=studyService.findLTbyid(lt_id);	
		Log_type lltype=logtype.get(0);
		JSONObject json = new JSONObject();
		json.put("lt_name",lltype.getLt_name() );	
		out.print(json);
		out.flush();
		out.close();		
	}
	
	//保存日志类型logtype修改信息
	public void save_logtype()throws Exception{
		List<Log_type> logtype=studyService.findLTbyid(lt_id);	
		Log_type lltype=logtype.get(0);
		lltype.setLt_name(lt_name);
		studyService.update(lltype);
	}
	
	//增加日志类型
	
	public void addLogtype() throws Exception{
		String time=DateUtil.getStringDate();
		Log_type lp=new Log_type();
		lp.setLt_id(lt_id);
		lp.setLt_name(lt_name);
		lp.setLt_remark(lt_remark);
		lp.setLt_time(time);
		studyService.addLogtype(lp);
	}
	
	//删除类型
	public void deleteLtype()throws Exception{
		Log_type logt=new Log_type();
		logt.setLt_id(lt_id);
		studyService.deleteltype(logt);
		
		
		
	}
	
	//对日志类型信息进行刷新
	
	public void refreshLtype()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Log_type> logtype=studyService.findltype();
		boolean isempty = false;
		//int pagNow=1;	
		JSONArray jsona = new JSONArray();
		for(int i=0;i<logtype.size();i++){
			jsona.add(i, logtype.get(i));		
		}	
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
	}
	
	//增加日志
	public String addLog()throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		String time = DateUtil.getNowStrDate();
		Learning_Log ll=new Learning_Log();
		ll.setL_id(l_id);
		ll.setL_content(l_content);
		ll.setL_state("fabu");//保存为发布
		ll.setL_subject(l_subject);
		ll.setL_time(time);
		ll.setLt_name(lt_name);
		ll.setL_member(me.getM_username());
		studyService.addlog(ll);
		return "success";				
	}
	
	//将日志保存到草稿箱
	public String addDrafts()throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		//String time = DateUtil.getNowStrDate();
		Learning_Log ll=new Learning_Log();
		ll.setL_id(l_id);
		ll.setL_content(l_content);
		ll.setL_state("caogao");//保存到草稿箱
		ll.setL_subject(l_subject);
		ll.setL_time(l_time);
		ll.setLt_name(lt_name);		
		ll.setL_member(me.getM_username());
		studyService.addDraft(ll);
		return "success";		
	}
	
	//查看草稿箱
	public String Viewdraft()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo me = (MembershipInfo)session.getAttribute("memberinfo");
		String memname=me.getM_username();
		if(pageNow<1){
			pageNow=1;
		}
		//查询出草稿箱的日志
		List<Learning_Log> log_draft=studyService.findmydraft(pageNow,memname);//查询自己的日志
		/*List<Learning_Log> log_draft = studyService.findDrafts(pageNow);*/	
		List<Log_type> ltype=studyService.findltype();
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);		
		request.setAttribute("log_draft", log_draft);
		request.setAttribute("pinfo", p);		
		session.setAttribute("logtype", ltype);
		return "success";
	}

	
	//根据id查看发表的日志详情
	public void findLogByid()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Learning_Log> log1=studyService.findlogByid(l_id);
		Learning_Log log2=log1.get(0);
		JSONObject json = new JSONObject();
		json.put("l_subject",log2.getL_subject());
		json.put("l_content",log2.getL_subject());
		json.put("l_time",log2.getL_subject());
		
		json.put("l_member",log2.getL_member());
		json.put("l_zan",log2.getL_subject());
		json.put("l_comment",log2.getL_subject());
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	//根据id删除日志
	public void deletelogByid()throws Exception{
		List<Learning_Log> log1=studyService.findlogByid(l_id);
		Learning_Log log2=log1.get(0);
		this.studyService.deletelogByid(log2);
	}
	
	/*//操作之后的日志刷新
	public void refreshLog() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		int pagNow=1;
		
		
		List<Log_type> ltype=studyService.findltype();
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
	}*/
	
	//对编辑的日志进行发布
	public void EditLog()throws Exception{
		List<Learning_Log> log1=studyService.findlogByid(l_id);
		Learning_Log log2=log1.get(0);
		String time = DateUtil.getNowStrDate();
		log2.setL_comment(l_comment);
		log2.setL_purview(l_purview);
		log2.setLt_name(lt_name);
		log2.setL_time(time);
		log2.setL_state("fabu");
		this.studyService.editlog(log2);
		
	}
	
	//对编辑的日志保存（不发布）
	public void EditLog2()throws Exception{
		List<Learning_Log> log1=studyService.findlogByid(l_id);
		Learning_Log log2=log1.get(0);
		String time = DateUtil.getNowStrDate();
		log2.setL_comment(l_comment);
		log2.setL_purview(l_purview);
		log2.setLt_name(lt_name);
		log2.setL_time(time);
		log2.setL_state("caogao");
		this.studyService.editlog(log2);
	}
}
