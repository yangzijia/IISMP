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

import com.rms.model.MembershipInfo;
import com.rms.model.ResourceInfo;
import com.rms.model.Resource_Type;
import com.rms.page.Page;
import com.rms.util.DateUtil;

@SuppressWarnings("serial")
@Component("resourceAction")
@Scope("prototype")
public class ResourceAction extends BaseAction{
	HttpServletRequest request;
	
	private int pageNow;
	private int rt_id;
	private String rt_name;
	private String rt_remark;

	private int resource_id;
	private String resource_issuer;
	private String resource_name;
	private File myFile;
	private String myFileFileName;
	private String resource_remark;
	private String resource_time;
	@SuppressWarnings("unused")
	private InputStream fileInput;  
    private String fileName;  
	
	public String getResource_time() {
		return resource_time;
	}
	public void setResource_time(String resource_time) {
		this.resource_time = resource_time;
	}
	public String getResource_remark() {
		return resource_remark;
	}
	public void setResource_remark(String resource_remark) {
		this.resource_remark = resource_remark;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getResource_issuer() {
		return resource_issuer;
	}
	public void setResource_issuer(String resource_issuer) {
		this.resource_issuer = resource_issuer;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public int getResource_id() {
		return resource_id;
	}
	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}
	public String getRt_name() {
		return rt_name;
	}
	public void setRt_name(String rt_name) {
		this.rt_name = rt_name;
	}
	public String getRt_remark() {
		return rt_remark;
	}
	public void setRt_remark(String rt_remark) {
		this.rt_remark = rt_remark;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
    public String getFileName() {  
        return fileName;  
    }  
    public void setFileName(String fileName) {  
        this.fileName = fileName;  
    }  
    public InputStream getFileInput() {  
        return ServletActionContext.getServletContext().getResourceAsStream("upload\\"+fileName);  
    }  
    public void setFileInput(InputStream fileInput) {  
        this.fileInput = fileInput;  
    }  
    public String execute() throws Exception{  
        fileInput=ServletActionContext.getServletContext().getResourceAsStream("upload\\"+fileName);  
        return "success";  
	}  
	
	/**
	 * 分页查看所有资源
	 * @return
	 * @throws Exception
	 */
	public String showRAction() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		List<MembershipInfo> membershipInfo =merberService.findall();
		List<Resource_Type> type=resourceService.findtype();
		List<ResourceInfo> reinfo=resourceService.findreinfo(pageNow);//分页查看所有资源
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20); 
		p.setTotalItemNumber(resourceService.findAllres());	//查看全部资源数量
		request.setAttribute("pageinfo", p);
		request.setAttribute("membershipInfo", membershipInfo);
		session.setAttribute("type", type);
		request.setAttribute("reinfo", reinfo);
		return "success";
	}
	

	
	/**
	 * 根据id删除资源库
	 * @throws Exception
	 */
	public void deleteRTbyidAction()throws Exception{
		List<Resource_Type> rt= resourceService.findtypeByid(rt_id);
		List<ResourceInfo> reinfo=resourceService.findallres(rt_id);
		Resource_Type rtt=rt.get(0);
		if(reinfo!=null&&reinfo.size()>0){
			for(int i=0;i<reinfo.size();i++){
				ResourceInfo rein=reinfo.get(i);
				File file =new File("D:"+File.separator+"IISMP" +File.separator+"System_source"+File.separator+rein.getResource_name());
				if(file.exists()){
				file.delete();
				resourceService.deleterebyid(rein);	
				}
				else{
				System.out.println("文件不存在");
				}
			}
		}
	
		resourceService.deleteRTbyid(rtt);
	}
	
	/**
	 * 查看管理 资源库
	 * @return
	 * @throws Exception
	 */
	public String showRTaction() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(pageNow<1){
			pageNow = 1;
		}
		List<Resource_Type> type=resourceService.findtype();
		this.findamount();
		Page p = new Page();
		p.setPageNow(pageNow);		
		p.setPageSize(20);
		request.setAttribute("pageinfo", p);
		request.setAttribute("rttype",type);
		return "success";
	}
	
	/**
	 * 增加资源库
	 * @throws Exception
	 */
	public void addRtype() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		Resource_Type rt=new Resource_Type();
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		String time = DateUtil.getStrDate_24();
		rt.setRt_id(rt_id);
		rt.setRt_remark(rt_remark);
		rt.setRt_name(rt_name);
		rt.setRt_issuer(memberinfo.getM_truename());
		rt.setRt_updatime(time);
		resourceService.addRtype(rt);
		
		
	}
	
	/**
	 * 根据资源库名进行查看  
	 * @throws Exception
	 */
	public String findRbytype()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session = request.getSession();
		if(pageNow<1){
			pageNow = 1;
		}
		List<ResourceInfo> reinfo=resourceService.findrinfoByrt(pageNow,rt_id);//根据文件库类型查看文件
		List<Resource_Type> re=resourceService.findtypeByid(rt_id);
		
		Page p = new Page();
		p.setPageNow(pageNow);
		p.setPageSize(20);
		p.setTotalItemNumber(resourceService.findallresByrt(rt_id));
		request.setAttribute("pageinfo", p);
		request.setAttribute("resourceInfo", reinfo);
		request.setAttribute("Resource_Type", re);
		
		return "success";
		
	}
	
	
	//删除资源
	public void deleteRebyidAction()throws Exception{
		List<ResourceInfo> reinfo= resourceService.findrinfo(resource_id);
		ResourceInfo re=reinfo.get(0);
		File file =new File("D:"+File.separator+"IISMP" +File.separator+"System_source"+File.separator+re.getResource_name());
		if(file.exists()){
		file.delete();
			}
		else{
		System.out.println("文件不存在");
		}
		
		resourceService.deleterebyid(re);
		
		
	}

	/**
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	public String commitresource() throws Exception {
		request = ServletActionContext.getRequest();
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置上传文件目录	
		// 设置日期格式
		String aa = DateUtil.getNowStrDate();
		myFileFileName = new String(myFileFileName);
		resource_name = myFileFileName;
		
		List<MembershipInfo> membershipInfo =merberService.findall();
		MembershipInfo m=membershipInfo.get(0);
		ResourceInfo re = new ResourceInfo();
		re.setResource_id(resource_id);
		re.setResource_issuer(m.getM_truename());
		re.setResource_name(resource_name);
		re.setResource_time(aa);
		re.setResource_remark(resource_remark);
		re.setRt_id(rt_id);
		
		resourceService.upload(re);
		// 设置目标文件
		File toFile = new File("d:\\IISMP\\System_source", resource_name);
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);
		// 设置缓存
		byte[] buffer = new byte[1024];
		int length = 0;
		// 读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		// 关闭输入流
		is.close();
		// 关闭输出流
		os.close();
		this.findRbytype();
		return "success";
	}
	
	/**
	 * 查询资源库中有多少文件
	 * @throws Exception
	 */
	public void findamount() throws Exception{
		List<Resource_Type> type=resourceService.findtype();
		List<ResourceInfo> reinfo=resourceService.findreinfo2();	
		for(int i=0;i<type.size();i++){		
			Resource_Type tt=type.get(i);
			for(int j=0;j<reinfo.size();j++){
				//ResourceInfo ree=reinfo.get(j);
				//if(ree.getRt_id()==tt.getRt_id());
				int id=tt.getRt_id();	
				int amount =resourceService.findreamount(id);		
				List<Resource_Type> tt1=resourceService.findtyByid(id);	
				Resource_Type tt2=tt1.get(0);
				tt1.get(0).setRe_amount(amount);
				resourceService.edittype(tt2);
			}						
		}
		
	}
	
	//刷新资源库
	
	public void refreshtype()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		List<Resource_Type> re=resourceService.findtype();
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
	
	//翻页刷新资源
	
	public void Fanyere() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if(pageNow < 1){
			pageNow = 1;
		}
		//接受查看的栏目 
		boolean isHasNext = false;
		boolean isHasPrev = false;
		int pageCount = 0;
		boolean isempty = true;
		JSONArray jsona = new JSONArray();
		
		//分页查的列表信息
		List<ResourceInfo> reinfo=resourceService.findrinfoByrt(pageNow,rt_id);//根据文件库类型查看文件
		//List<Resource_Type> re=resourceService.findtypeByid(rt_id);
		Page p = new Page();
		//rt_name=re.get(0).getRt_name();
		if(reinfo != null && reinfo.size() > 0){
			
			for(int i=0;i<reinfo.size();i++){
				jsona.add(i, reinfo.get(i));
			}
			p.setTotalItemNumber(resourceService.findallresByrt(rt_id));
		}else {
			p.setTotalItemNumber(1);
			isempty = false;
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
//System.out.println(json.toString());
		//json.put("rt_name", rt_name);
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	//增加删除操作之后的资源刷新显示

	public void refreshResour()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		if(pageNow<0){
			pageNow = 1;
		}
		List<ResourceInfo> re=resourceService.findreinfo(pageNow);
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
	
	//根据资源库 id查看资源库说明
	public void findrtbyid()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		boolean isempty = false;
		List<Resource_Type> re=resourceService.findrtbyid(rt_id);
		Resource_Type ree=re.get(0);
	
		JSONObject json = new JSONObject();
		json.put("rt_name", ree.getRt_name());
		json.put("rt_remark", ree.getRt_remark());
		json.put("isempty", isempty);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 更新资源库的方法
	 * @throws Exception
	 */
	public void updateRestype() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		MembershipInfo memberinfo = (MembershipInfo)session.getAttribute("memberinfo");
		String time = DateUtil.getStrDate_24();
		Resource_Type rt=new Resource_Type();
		
		rt.setRt_id(rt_id);
		rt.setRt_remark(rt_remark);
		rt.setRt_name(rt_name);
		rt.setRt_issuer(memberinfo.getM_truename());
		rt.setRt_updatime(time);
		resourceService.updateRestype(rt);
		
		
		this.refreshtype();
	}
	
}
