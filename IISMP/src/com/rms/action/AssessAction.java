package com.rms.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rms.model.Assess;
import com.rms.model.AssessChart;
import com.rms.model.AssessExportChart;
import com.rms.model.AssessOperator;
import com.rms.model.Attendance;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.page.FinalAssess;
import com.rms.page.Page;
import com.rms.util.DateUtil;



@SuppressWarnings({ "serial", "deprecation" })
@Component("assessAction")
@Scope("prototype")
public class AssessAction extends BaseAction{
	HttpServletRequest request;
	private int id;
	private int ac_id;
	private String assessname;
	private String operatorname;
	private String updatetime;
	private int pageNow;
	private String as_endtime;
	private String as_starttime;
	private String sectionname;
	private int kaoqin;
	private int biaoxian;
	private int xiangmu;
	private int xinde;
	private int heji;
	private String remark;
	private String typeinfo;
	private int operator_id;
	
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public String getTypeinfo() {
		return typeinfo;
	}
	public void setTypeinfo(String typeinfo) {
		this.typeinfo = typeinfo;
	}
	public int getKaoqin() {
		return kaoqin;
	}
	public void setKaoqin(int kaoqin) {
		this.kaoqin = kaoqin;
	}
	public int getBiaoxian() {
		return biaoxian;
	}
	public void setBiaoxian(int biaoxian) {
		this.biaoxian = biaoxian;
	}
	public int getXiangmu() {
		return xiangmu;
	}
	public void setXiangmu(int xiangmu) {
		this.xiangmu = xiangmu;
	}
	public int getXinde() {
		return xinde;
	}
	public void setXinde(int xinde) {
		this.xinde = xinde;
	}
	public int getHeji() {
		return heji;
	}
	public void setHeji(int heji) {
		this.heji = heji;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getAs_endtime() {
		return as_endtime;
	}
	public void setAs_endtime(String as_endtime) {
		this.as_endtime = as_endtime;
	}
	public String getAs_starttime() {
		return as_starttime;
	}
	public void setAs_starttime(String as_starttime) {
		this.as_starttime = as_starttime;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
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
	public String getAssessname() {
		return assessname;
	}
	public void setAssessname(String assessname) {
		this.assessname = assessname;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	
	/**
	 * 查询出评估界面信息
	 * @return
	 * @throws Exception
	 */
	public String findallassesschartinfo() throws Exception {
		request = ServletActionContext.getRequest();
		if(pageNow<1){
			pageNow=1;
		}
		//查询出评估表信息
		List<AssessChart> ac = assessService.findallassesschartinfo(pageNow);
		//if(ac!= null && ac.size() > 0){
		Page p = new Page();
		p.setPageSize(20);
		System.out.println("pageNow=="+pageNow);
		p.setPageNow(pageNow);
		long totalItemNumber = assessService.findassesstotalItemNumber();
		p.setTotalItemNumber(totalItemNumber);
		request.setAttribute("pinfo", p);
		request.setAttribute("acinfo", ac);
		return "success";
		//}
		//return "error";
	}
	
	/**
	 * 刷新界面的方法
	 */
	public void flushassesschartinfo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo m = (MembershipInfo)session.getAttribute("memberinfo");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		boolean isHasPrev = false;
		boolean isHasNext = false;
		long pageCount = 1;
		int prevpage =0;
		int nextpage = 0;
		JSONArray jsona = new JSONArray();
		if(pageNow<1){
			pageNow=1;
		}
		//查询出评估表信息
		List<AssessChart> ac = assessService.findallassesschartinfo(pageNow);
		if(ac != null && ac.size()> 0){
			isempty = true;
			for(int i=0;i<ac.size();i++){
				jsona.add(i, ac.get(i));
			}
		}
		long totalItemNumber = assessService.findassesstotalItemNumber();
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(totalItemNumber);
		if(totalItemNumber!=0){
			pageCount = p.getpageCount(totalItemNumber);
		}
		if(p.isHasPrev()){
			isHasPrev = p.isHasPrev();
			prevpage = p.getPrevPage();
		}
		if(p.isHasNext()){
			isHasNext = p.isHasNext();
			nextpage = p.getNextPage();
		}
		int role_num = m.getRole_num();
		//Thread.sleep(5000);
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isHasPrev", isHasPrev);
		json.put("isHasNext", isHasNext);
		json.put("pageNow", pageNow);
		json.put("pageCount", pageCount);
		json.put("isempty", isempty);
		json.put("prevpage", prevpage);
		json.put("nextpage", nextpage);
		json.put("role_num", role_num);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 添加新的评估表的方法
	 * @throws Exception
	 */
	public void saveassesschartinfo() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo m = (MembershipInfo)session.getAttribute("memberinfo");
		//根据评估表的名称查询出该评估表的所有信息
		List<AssessChart> acinfo = assessService.findassesschartByassessname(assessname);
		JSONObject json = new JSONObject();
		boolean isexitchart = false;
		if(acinfo==null || acinfo.size()==0){
			AssessChart ac = new AssessChart();
			ac.setAs_endtime(as_endtime);
			ac.setAs_starttime(as_starttime);
			ac.setAssessname(assessname);
			ac.setM_id(m.getM_id());
			ac.setOperatorname(m.getM_truename());
			ac.setUpdatetime(DateUtil.getNowStrDate());
			ac.setUpdatetimeinfo(DateUtil.getLongDateS());
			//添加新的评估表的方法
			assessService.saveassesschartinfo(ac);
		}else{
			isexitchart = true;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		boolean isHasPrev = false;
		boolean isHasNext = false;
		long pageCount = 1;
		int prevpage =0;
		int nextpage = 0;
		JSONArray jsona = new JSONArray();
		if(pageNow<1){
			pageNow=1;
		}
		//查询出评估表信息
		List<AssessChart> ac = assessService.findallassesschartinfo(pageNow);
		if(ac != null && ac.size()> 0){
			isempty = true;
			for(int i=0;i<ac.size();i++){
				jsona.add(i, ac.get(i));
			}
		}
		long totalItemNumber = assessService.findassesstotalItemNumber();
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(totalItemNumber);
		if(totalItemNumber!=0){
			pageCount = p.getpageCount(totalItemNumber);
		}
		if(p.isHasPrev()){
			isHasPrev = p.isHasPrev();
			prevpage = p.getPrevPage();
		}
		if(p.isHasNext()){
			isHasNext = p.isHasNext();
			nextpage = p.getNextPage();
		}
		int role_num = m.getRole_num();
		//Thread.sleep(5000);
		json.put("isexitchart", isexitchart);
		json.put("jsona", jsona);
		json.put("isHasPrev", isHasPrev);
		json.put("isHasNext", isHasNext);
		json.put("pageNow", pageNow);
		json.put("pageCount", pageCount);
		json.put("isempty", isempty);
		json.put("prevpage", prevpage);
		json.put("nextpage", nextpage);
		json.put("role_num", role_num);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 删除这条评估表的具体信息
	 */
	public void deletethisassess() throws Exception {
		//根据ID查询出评估表的具体信息
		
		List<AssessChart> ac = assessService.findthisassessinfobyid(id);
		AssessChart a = ac.get(0);
		assessService.deletethisassess(a);
		flushassesschartinfo();
	}
	
	/**
	 * 查询出评估界面的具体信息的方法
	 */
	public String openassessinfopage() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo m = (MembershipInfo)session.getAttribute("memberinfo");
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		//根据ac_id查询出AssessChart表的信息
		List<AssessChart> assesschart = assessService.findassesschartbyac_id(id);
		AssessChart a = assesschart.get(0);
		List<Assess> assess = null;
		//根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
		assess = assessService.findassessinfoByac_idandoperator_id(id,m.getM_id());
		if(assess.size()!=msi.size()){
			for(int i=0;i<msi.size();i++){
				MembershipInfo msi1 = msi.get(i);
				//根据成员的ID和operator_id和ac_id查询出信息进行判断是否存在
				if(assessService.isnotExitforAssess(id,m.getM_id(),msi1.getM_id())){
					//如果不存在
					
					int kaoqin = 0;
					//创建评估表内容
					Assess as = new Assess();
					as.setAc_id(a.getId());
					as.setBiaoxian(0);
					as.setHeji(0);
					as.setUpdatetime("-");
					as.setXinde(0);
					as.setXiangmu(0);
					as.setSectionname(msi1.getM_sectionname());
					as.setUsername(msi1.getM_truename());
					as.setUser_id(msi1.getM_id());
					as.setOperator_id(m.getM_id());
					//根据成员的id查询出as_starttime    到   as_endtime   的考勤情况
					List<Attendance> atten = attendanceService.findatteninfoByt1Tot2AndM_id(a.getAs_starttime(), a.getAs_endtime(), msi1.getM_id());
					if(atten != null){
						for(int j=0;j<atten.size();j++){
							Attendance att = atten.get(j);
							if(att.getA_state().equals("正常")){
								kaoqin++;
							}
						}
					}
					as.setKaoqin(kaoqin);
					//增加到assess数据表中
					assessService.addassessinfo(as);
				}
			}
			//根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
			assess = assessService.findassessinfoByac_idandoperator_id(id,m.getM_id());
		}
		
		//根据AC_id和m.getM_turename来判断该登录成员时候参与评估
		//List<AssessOperator> ao11 = assessService.findallassessoperator(ac_id);
		if(assessService.isexitassessoperatorbyac_idandturename(id, m.getM_id())){
			//不存在的话
			//新增assessoperator表，即添加操作人姓名
			AssessOperator ao = new AssessOperator();
			ao.setOperator_id(m.getM_id());
			ao.setUsername(m.getM_truename());
			ao.setAc_id(id);
			assessService.addassessoperatorinfo(ao);
		}
		if(typeinfo==null || typeinfo== ""){
			typeinfo = "pinggu";
		}
		//查询出所有分组信息
		List<Section> section = systemsetService.findsectioninfo();
		request.setAttribute("assesssection", section);
		request.setAttribute("typeinfo", typeinfo);
		request.setAttribute("assinfo", assess);
		return "success";
	}
	
	/**
	 * 根据分组查看评估的成员信息
	 * @throws Exception
	 */
	public void findassessinfoBysection() throws Exception {
		boolean isempty = false;
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo m = (MembershipInfo)session.getAttribute("memberinfo");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据ac_id和sectionname和operator_id查询出评估具体信息
		List<Assess> ass = assessService.findassessinfoBysectionnameAndid(sectionname,ac_id,m.getM_id());
		JSONArray jsona = new JSONArray();
		if(ass!=null){
			isempty = true;
			for(int i=0;i<ass.size();i++){
				jsona.add(i, ass.get(i));
			}
		}
		JSONObject json = new JSONObject();
		json.put("jsona", jsona);
		json.put("isempty", isempty);
		json.put("typeinfo", typeinfo);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据id查询出评估的成绩信息
	 * @throws Exception
	 */
	public void findassessinfobyidmotai() throws Exception{
		boolean isempty = false;
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据id查询出评估的具体信息
		List<Assess> ass = assessService.findassesspingguxinxibyid(id);
		JSONObject json = new JSONObject();
		if(ass!=null){
			isempty=true;
			Assess as = ass.get(0);
			json.put("kaoqin", as.getKaoqin());
			json.put("biaoxian", as.getBiaoxian());
			json.put("xiangmu", as.getXiangmu());
			json.put("xinde", as.getXinde());
			json.put("remarks", as.getRemark());
			json.put("username", as.getUsername());
			json.put("sectionname", as.getSectionname());
		}
		json.put("isempty", isempty);
System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 保存评估后的信息
	 */
	public void saveAssessgerengrade() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo m = (MembershipInfo)session.getAttribute("memberinfo");
		//根据id查找出评估信息
		List<Assess> ass = assessService.findassesspingguxinxibyid(id);
		Assess as = ass.get(0);
		as.setBiaoxian(biaoxian);
		as.setHeji(heji);
		as.setKaoqin(kaoqin);
		as.setXinde(xinde);
		as.setXiangmu(xiangmu);
		as.setUpdatetime(DateUtil.getNowStrDate());
		as.setRemark(remark);
		//更新assess表
		assessService.updateassessinfo(as);
		
		//根据AC_id和m.getM_turename来判断该登录成员时候参与评估
		//List<AssessOperator> ao11 = assessService.findallassessoperator(ac_id);
		if(assessService.isexitassessoperatorbyac_idandturename(ac_id, m.getM_id())){
			//不存在的话
			//新增assessoperator表，即添加操作人姓名
			AssessOperator ao = new AssessOperator();
			ao.setOperator_id(m.getM_id());
			ao.setUsername(m.getM_truename());
			ao.setAc_id(as.getAc_id());
			assessService.addassessoperatorinfo(ao);
		}
		findassessinfoBysection();
	}
	
	/**
	 * 查询出最终的评估结果的方法
	 */
	public String findfinalassessgrade() throws Exception{
		int kq=0;
		int xm=0;
		int xd=0;
		int bx=0;
		int hj=0;
		request = ServletActionContext.getRequest();
		//根据AC_id查询出有谁参与评估
		List<AssessOperator> ao = assessService.findallassessoperator(ac_id);
		//计算每位成员的最后成绩
		ArrayList<FinalAssess> arr = new ArrayList<FinalAssess>();
		//查询出所有成员信息的方法
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		if(msi!=null){
			for(int i=0;i<msi.size();i++){
				MembershipInfo mb = msi.get(i);
				FinalAssess fa = new FinalAssess();
				fa.setUsername(mb.getM_truename());
				fa.setSectionname(mb.getM_sectionname());
				//根据ac_id和userid查询出评估人对该成员评估的所有列表信息
				List<Assess> assess = assessService.findassessinfoByac_idandid(ac_id,mb.getM_id());
				int assessnum = 1;
				if(ao.size()>0){
					assessnum = ao.size();
				}
				if(assess!=null&& assess.size()>0){
					for(int j=0;j<assess.size();j++){
						Assess as = assess.get(j);
						kq = kq + as.getKaoqin();
						xm = xm + as.getXiangmu();
						xd = xd + as.getXinde();
						bx = bx + as.getBiaoxian();
						hj = hj+ as.getHeji();
					}
					//assessnum=assess.size();
				}
				fa.setBiaoxian(bx/assessnum);
				fa.setHeji(hj/assessnum);
				fa.setId(mb.getM_id());
				fa.setKaoqin(kq/assessnum);
				fa.setXiangmu(xm/assessnum);
				fa.setXinde(xd/assessnum);
				arr.add(fa);
				kq=0;
				xm=0;
				xd=0;
				bx=0;
				hj=0;
			}
		}
		//对arr进行排序
		Collections.sort(arr);
for(FinalAssess list : arr){
	System.out.println(list.toString());
}
		
		//查询出所有分组信息
		List<Section> section = systemsetService.findsectioninfo();
		
		request.setAttribute("ac_idinfo", ac_id);
		request.setAttribute("aoinfo", ao);
		request.setAttribute("assesssection", section);
		request.setAttribute("assinfo", arr);
		return "success";
	}
	
	/**
	 * 根据分组查询出每个人的考评最终成绩
	 */
	public void findfinalBysectionAndac_id() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		//根据AC_id查询出有谁参与评估
		List<AssessOperator> ao = assessService.findallassessoperator(ac_id);
		int kq=0;
		int xm=0;
		int xd=0;
		int bx=0;
		int hj=0;
		boolean isempty = false;
		//计算每位成员的最后成绩
		ArrayList<FinalAssess> arr = new ArrayList<FinalAssess>();
		JSONArray jsona = new JSONArray();
		//根据sectionname查询出所有成员信息的方法
		List<MembershipInfo> msi = assessService.findmembershipBysectionname(sectionname);
		if(msi!=null){
			for(int i=0;i<msi.size();i++){
				MembershipInfo mb = msi.get(i);
				FinalAssess fa = new FinalAssess();
				fa.setUsername(mb.getM_truename());
				fa.setSectionname(mb.getM_sectionname());
System.out.println("secttionname==="+sectionname);
				//根据ac_id和userid查询出评估人对该成员评估的所有列表信息
				List<Assess> assess = assessService.findassessinfoByac_idandid(ac_id,mb.getM_id());
				int assessnum = 1;
				if(ao.size()>0){
					assessnum = ao.size();
				}
				if(assess!=null&& assess.size()>0){
					for(int j=0;j<assess.size();j++){
						Assess as = assess.get(j);
						kq = kq + as.getKaoqin();
						xm = xm + as.getXiangmu();
						xd = xd + as.getXinde();
						bx = bx + as.getBiaoxian();
						hj = hj+ as.getHeji();
					}
				}
				/*fa.setBiaoxian(Double.parseDouble(PmnUtils.pmn(bx/assessnum)));
				fa.setHeji(Double.parseDouble(PmnUtils.pmn(hj/assessnum)));
				fa.setId(mb.getM_id());
				fa.setKaoqin(Double.parseDouble(PmnUtils.pmn(kq/assessnum)));
				fa.setXiangmu(Double.parseDouble(PmnUtils.pmn(xm/assessnum)));
				fa.setXinde(Double.parseDouble(PmnUtils.pmn(xd/assessnum)));*/
				fa.setBiaoxian(bx/assessnum);
				fa.setHeji(hj/assessnum);
				fa.setId(mb.getM_id());
				fa.setKaoqin(kq/assessnum);
				fa.setXiangmu(xm/assessnum);
				fa.setXinde(xd/assessnum);
				arr.add(fa);
				kq=0;
				xm=0;
				xd=0;
				bx=0;
				hj=0;
			}
		}
		//对arr进行排序
		Collections.sort(arr);
for(FinalAssess list : arr){
	System.out.println(list.toString());
}
		for(int i=0;i<arr.size();i++){
			isempty = true;
			FinalAssess f = arr.get(i);
			f.setPaiming(i+1);
			jsona.add(i, f);
		}
		JSONObject json = new JSONObject();
		json.put("isempty", isempty);
		json.put("ac_idinfo", ac_id);
		json.put("jsona", jsona);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 查看评估人评估的具体信息
	 */
	public String openfindassessoperatorinfobyid() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		MembershipInfo m = (MembershipInfo)session.getAttribute("memberinfo");
		List<MembershipInfo> msi = attendanceService.findallmemberinfo();
		//根据ac_id查询出AssessChart表的信息
		List<AssessChart> assesschart = assessService.findassesschartbyac_id(ac_id);
		AssessChart a = assesschart.get(0);
		List<Assess> assess = null;
		//根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
		assess = assessService.findassessinfoByac_idandoperator_id(ac_id,operator_id);
		if(assess.size()!=msi.size()){
			for(int i=0;i<msi.size();i++){
				MembershipInfo msi1 = msi.get(i);
				//根据成员的ID和operator_id和ac_id查询出信息进行判断是否存在
				if(assessService.isnotExitforAssess(ac_id,m.getM_id(),msi1.getM_id())){
					//如果不存在
					
					int kaoqin = 0;
					//创建评估表内容
					Assess as = new Assess();
					as.setAc_id(a.getId());
					as.setBiaoxian(0);
					as.setHeji(0);
					as.setUpdatetime("-");
					as.setXinde(0);
					as.setXiangmu(0);
					as.setSectionname(msi1.getM_sectionname());
					as.setUsername(msi1.getM_truename());
					as.setUser_id(msi1.getM_id());
					as.setOperator_id(m.getM_id());
					//根据成员的id查询出as_starttime    到   as_endtime   的考勤情况
					List<Attendance> atten = attendanceService.findatteninfoByt1Tot2AndM_id(a.getAs_starttime(), a.getAs_endtime(), msi1.getM_id());
					if(atten != null){
						for(int j=0;j<atten.size();j++){
							Attendance att = atten.get(j);
							if(att.getA_state().equals("正常")){
								kaoqin++;
							}
						}
					}
					as.setKaoqin(kaoqin);
					//增加到assess数据表中
					assessService.addassessinfo(as);
				}
			}
			//根据ac_id和operator_id查询出评估人对该成员评估的所有列表信息
			assess = assessService.findassessinfoByac_idandoperator_id(ac_id,m.getM_id());
		}
		
		//根据AC_id和m.getM_turename来判断该登录成员时候参与评估
		//List<AssessOperator> ao11 = assessService.findallassessoperator(ac_id);
		if(assessService.isexitassessoperatorbyac_idandturename(ac_id, m.getM_id())){
			//不存在的话
			//新增assessoperator表，即添加操作人姓名
			AssessOperator ao = new AssessOperator();
			ao.setOperator_id(m.getM_id());
			ao.setUsername(m.getM_truename());
			ao.setAc_id(ac_id);
			assessService.addassessoperatorinfo(ao);
		}
		
		//查询出所有分组信息
		List<Section> section = systemsetService.findsectioninfo();
		request.setAttribute("assesssection", section);
		request.setAttribute("typeinfo", "chakan");
		request.setAttribute("assinfo", assess);
		return "success";
	}
	
	/**
	 * 查看所有导出的评估表的方法
	 */
	public String findallexportassessinfo() throws Exception{
		request = ServletActionContext.getRequest();
		List<AssessExportChart> aec = assessService.findallAssessExportchart();
		//查询出所有的评估表
		List<AssessChart> ac = assessService.findassesschart();
		request.setAttribute("aecinfos", aec);
		request.setAttribute("acinfos", ac);
		return "success";
	}
	
	/**
	 * 导出评估表的方法
	 */
	public void committhisassesschart() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isexit = false;
		
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		//根据评估表的名称查询出该评估表的所有信息
		List<AssessChart> acinfo = assessService.findassesschartByassessname(assessname);
		
		AssessChart a = acinfo.get(0);
		int kq=0;
		int xm=0;
		int xd=0;
		int bx=0;
		int hj=0;
		
		String execlname = "创新实验室自学管理平台_"+assessname;
		String filename = execlname+a.getAs_starttime()+"~"+a.getAs_endtime()+".xls";
		//根据exportname判断导出表名是否重复
		if(assessService.isnotexitassessexportchart(filename)){
			
			
			
			//根据AC_id查询出有谁参与评估
			List<AssessOperator> ao = assessService.findallassessoperator(a.getId());
			//计算每位成员的最后成绩
			ArrayList<FinalAssess> arr = new ArrayList<FinalAssess>();
			//查询出所有成员信息的方法
			List<MembershipInfo> msi = attendanceService.findallmemberinfo();
			if(msi!=null){
				for(int i=0;i<msi.size();i++){
					MembershipInfo mb = msi.get(i);
					FinalAssess fa = new FinalAssess();
					fa.setUsername(mb.getM_truename());
					fa.setSectionname(mb.getM_sectionname());
					//根据ac_id和userid查询出评估人对该成员评估的所有列表信息
					List<Assess> assess = assessService.findassessinfoByac_idandid(a.getId(),mb.getM_id());
					int assessnum = 1;
					if(ao.size()>0){
						assessnum = ao.size();
					}
					if(assess!=null&& assess.size()>0){
						for(int j=0;j<assess.size();j++){
							Assess as = assess.get(j);
							kq = kq + as.getKaoqin();
							xm = xm + as.getXiangmu();
							xd = xd + as.getXinde();
							bx = bx + as.getBiaoxian();
							hj = hj+ as.getHeji();
						}
						//assessnum=assess.size();
					}
					fa.setBiaoxian(bx/assessnum);
					fa.setHeji(hj/assessnum);
					fa.setId(mb.getM_id());
					fa.setKaoqin(kq/assessnum);
					fa.setXiangmu(xm/assessnum);
					fa.setXinde(xd/assessnum);
					arr.add(fa);
					kq=0;
					xm=0;
					xd=0;
					bx=0;
					hj=0;
				}
			}
			//对arr进行排序
			Collections.sort(arr);
			
			/*
			 *导出表到excel的方法 
			 */
			
			
			try {
				//声明一个工作薄
				HSSFWorkbook workBook = new HSSFWorkbook(); // 创建 一个excel文档对象
				
				//*********************************
				//样式的设定
				//*********************************
				//表头的样式
				HSSFCellStyle style = workBook.createCellStyle(); // 创建样式对象
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //center
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
				HSSFFont font = workBook.createFont();// 创建字体对象
				font.setFontHeightInPoints((short) 12);
				font.setFontName("黑体");// 设置字体
				style.setFont(font);
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);
				
				//标题的样式
				HSSFCellStyle titleStyle = workBook.createCellStyle();// 创建表头样式对象
				titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
				titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
				HSSFFont titleFont = workBook.createFont();// 创建表头字体对象
				titleFont.setFontHeightInPoints((short) 25);
				titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
				titleFont.setFontName("黑体");// 设置字体
				titleStyle.setFont(titleFont);
				
				// 设置表单中字体样式
				HSSFCellStyle tableStyle = workBook.createCellStyle();
				tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
				tableStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
				HSSFFont tableFont = workBook.createFont();// 创建表格字体对象
				tableFont.setFontHeightInPoints((short) 11);
				tableFont.setFontName("宋体");// 设置字体
				tableStyle.setFont(tableFont);
				tableStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				tableStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				tableStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				tableStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				
				// 设置时间样式
				HSSFCellStyle timeStyle = workBook.createCellStyle();
				timeStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
				timeStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				timeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				timeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
				timeStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
				HSSFFont timeFont = workBook.createFont();// 创建表格字体对象
				timeFont.setFontHeightInPoints((short) 9);
				timeFont.setFontName("SansSerif");// 设置字体
				timeStyle.setFont(timeFont);
				
				//声明为评估 表
				HSSFSheet sheet1 = workBook.createSheet("评估表");
				HSSFCell cell1 = null; // 声明单元格对象 
				//设置列宽    2列
				sheet1.setColumnWidth(0, 4000);
				sheet1.setColumnWidth(1, 4000);
				sheet1.setColumnWidth(2, 4000);
				sheet1.setColumnWidth(3, 4000);
				sheet1.setColumnWidth(4, 4000);
				sheet1.setColumnWidth(5, 4000);
				sheet1.setColumnWidth(6, 4000);
				sheet1.setColumnWidth(7, 4000);
				
				//合并单元格
				sheet1.addMergedRegion(new Region((short)0,(short)0,(short)0,(short)7));
				sheet1.addMergedRegion(new Region((short)1,(short)0,(short)1,(short)7));
				//标题的设定
				HSSFRow row1 = sheet1.createRow(0);
				row1.setHeightInPoints(35);
				cell1 = row1.createCell(0);
				cell1.setCellStyle(titleStyle);
				cell1.setCellValue(a.getAssessname());
				
				HSSFRow row = sheet1.createRow(1);
				row.setHeightInPoints(20);
				cell1 = row.createCell(0);
				cell1.setCellStyle(timeStyle);
				cell1.setCellValue(a.getAs_starttime()+"~"+a.getAs_endtime());
				
				// 生成表头
				String[] bt = new String[] { "排名", "姓名", "分组", "考勤", "平时表现", "项目进度", "心得分享", "合计"};
				HSSFRow tableRow = sheet1.createRow(2); // 创建一个行对象
				tableRow.setHeightInPoints(25);
				for (int i = 0; i < bt.length; i++) {
					cell1 = tableRow.createCell(i);
					cell1.setCellStyle(style);
					cell1.setCellValue(new HSSFRichTextString(bt[i]));
				}
				
				// 写入表格内容
				for (int i = 0; i < arr.size(); i++) {
					tableRow = sheet1.createRow(i + 3); // 创建一个行对象
					tableRow.setHeightInPoints(20);
					FinalAssess a1 = arr.get(i);
					
					cell1 = tableRow.createCell(0);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(i+1+""));
					
					cell1 = tableRow.createCell(1);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getUsername().toString()));
					
					cell1 = tableRow.createCell(2);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getSectionname().toString()));
					
					cell1 = tableRow.createCell(3);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getKaoqin()+""));
					
					cell1 = tableRow.createCell(4);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getBiaoxian()+""));
					
					cell1 = tableRow.createCell(5);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getXiangmu()+""));
					
					cell1 = tableRow.createCell(6);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getXinde()+""));
					
					cell1 = tableRow.createCell(7);
					cell1.setCellStyle(tableStyle);
					cell1.setCellValue(new HSSFRichTextString(a1.getHeji()+""));
					
				}
				//将导出的excel表信息存入数据库中
				AssessExportChart abc = new AssessExportChart();
				abc.setExportname(execlname+a.getAs_starttime()+"~"+a.getAs_endtime()+".xls");
				abc.setUpdatetime(DateUtil.getNowStrDate());
				abc.setUsername(memberinfo.getM_truename());
				//add到数据库中AssessExportChart
				assessService.saveassessExportChart(abc);
				//保存excel表到 D:/IISMP/AssessExportChart/**.xls 下
				FileOutputStream fileOut = new FileOutputStream("D:/IISMP/AssessExportChart/"+execlname+a.getAs_starttime()+"~"+a.getAs_endtime()+".xls");
				workBook.write(fileOut);
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			//已经存在同样表名的文件
			isexit = true;
		}
		//查询出所有的导出评估表的方法
		List<AssessExportChart> aecinfo = assessService.findallAssessExportchart();
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		if(aecinfo!=null&& aecinfo.size()>0){
			isempty=true;
			for(int i=0;i<aecinfo.size();i++){
				jsona.add(i,aecinfo.get(i));
			}
		}
System.out.println("isempty=="+isempty);
		JSONObject json = new JSONObject();
		json.put("isempty", isempty);
		json.put("jsona", jsona);
		json.put("isexit", isexit);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 刷新导出评估表的方法
	 */
	public void flushexportassessaction() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isexit = false;
		//查询出所有的导出评估表的方法
		List<AssessExportChart> aecinfo = assessService.findallAssessExportchart();
		boolean isempty = false;
		JSONArray jsona = new JSONArray();
		if(aecinfo!=null&& aecinfo.size()>0){
			isempty=true;
			for(int i=0;i<aecinfo.size();i++){
				jsona.add(i,aecinfo.get(i));
			}
		}
System.out.println("isempty=="+isempty);
		JSONObject json = new JSONObject();
		json.put("isempty", isempty);
		json.put("jsona", jsona);
		json.put("isexit", isexit);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 删除导出的评估表的方法
	 */
	public void deleteassessexportchart() throws Exception{
	
		//根据id查询出导出评估表的方法
		List<AssessExportChart> aec = assessService.findassessexportchartByid(id);
		AssessExportChart a = aec.get(0);
		assessService.deleteassessexportchartByid(a);
		
		String sPath = "D:\\IISMP\\AssessExportChart\\"+a.getExportname();
		File file = new File(sPath);  
System.out.println(sPath);
		// 路径为文件且不为空则进行删除  
		if (file.isFile() && file.exists()) { 
			file.delete();  
		}  
		this.flushexportassessaction();
	}
	
	
	
}