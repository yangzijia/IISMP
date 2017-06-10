package com.rms.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.Anno_Sendee;
import com.rms.model.Announce_section;
import com.rms.model.Announcement;
import com.rms.page.AnnouncementQuery;
import com.rms.service.AnnouncementService;
import com.rms.service.BaseService;
@Component("announcementService")
public class AnnouncementServiceImpl extends BaseService implements AnnouncementService {

	
	
	//发布公告
	public void publish(Anno_Sendee as) {
			announcementDao.publish(as);
	}

	//查询公告总数
	public int findAllCount() {
		
		return this.announcementDao.findAllCount();
	}

	//查询公告
	public List<Announcement> findAll(int pageNow) {
		
		return this.announcementDao.findAll(pageNow);
	}


	//添加栏目
	public boolean addSection(Announce_section as) {
		
		return this.announcementDao.addSection(as);
	}


	//删除栏目
	public void deleteSection(Announce_section s) {
		announcementDao.deleteSection(s);
		
	}


	//查找栏目
	public List<Announce_section> findAll1() {
		
		return this.announcementDao.findall1();
	}


	//根据id修改栏目
	public Announce_section changeSectionByid(int as_id) {
		List<Announce_section> as_section =announcementDao.changeSectionByid(as_id);
		if(as_section != null && as_section.size() > 0){
			Announce_section s = as_section.get(0);
			return s;
		}
		return null;
	}


	//更新栏目信息
	public void updateA_sectioninfo(Announce_section s) {
		announcementDao.updateA_sectioninfo(s);
		
	}


	/*
	 * 根据栏目id查看已发布公告
	 * */
	public List<Announcement> findbyAsid(int as_id) {
		
		return this.announcementDao.findbyAsid(as_id);
	}
	
	/*
	 * 根据栏目id查看未发布公告
	 * */
	public List<Announcement> findbyAsid1(int as_id) {
		
		return this.announcementDao.findbyAsid1(as_id);
	}

	//根据id查看公告
	public List<Announcement> findAllinfobyid( int announcement_id) {
		// TODO Auto-generated method stub
		return this.announcementDao.findAllinfobyid(announcement_id);
	}

	//根据id删除公告
	public void deleteAbyid(Announcement s) {
		/*HttpServletRequest request = ServletActionContext.getRequest();		
		HttpSession session = request.getSession();
		MembershipInfo m = (MembershipInfo) session.getAttribute("memberinfo");*/
		//根据an_id来删除各个用户的通知
		announcementDao.deleteAnno_SendeeByAn_id(s.getAnnouncement_id());
		announcementDao.deleteAbyid(s);
	}

	public void changeviews(Announcement an) {
		announcementDao.changeviews(an);
	}

	//查询未发布公告总数
	public int findAll2Count() {
		return this.announcementDao.findAll2Count();
	}


	//查询未发布公告
	public List<Announcement> findAll2(int pageNow) {
		return this.announcementDao.findAll2(pageNow);
	}

	/*查看上一条公告
	 * 
	 * */
	public List<Announcement> findLoad(int id) {
		return this.announcementDao.findLoad(id);
	}

	/**
	 * 查看下一条公告
	 */
	public List<Announcement> findNext(int id) {
		// TODO Auto-generated method stub
		return this.announcementDao.findNext(id);
	}

	/**
	 * 查询公告信息（）
	 */
	public List<Announcement> findAnnoinfos(int pageNow, String announcement_type,String as_name) {
		 List<Announcement> anno=announcementDao.findAnnoinfos(pageNow,announcement_type,as_name);
		 if(anno!=null&&anno.size()>0){
			 return anno;
		 }
		return null;
	}
	
	
	public long findallasno(String announcement_type, String as_name) {
		List<Announcement> msi = announcementDao.findasnonum(announcement_type,as_name);
		if(msi != null && msi.size() > 0){
			System.out.println("+++++++++++++++++++--"+msi.size());
			return msi.size();
		}
		return 0;
	}

	@Override
	public void updateAnno(Announcement ann) {
		announcementDao.updateAnno(ann);
	}

	/**
	 * 查询出未发布的公告的数量
	 */
	public int findweifabunum() {
		List<Announcement> announcement = announcementDao.findasnonum("保存未发布", "全部公告");
		if(announcement!=null && announcement.size()>0){
			return announcement.size();
		}
		return 0;
	}

	/**
	 * 根据announcement_type 查询出已发布的公告数量
	 * @param announcement_type
	 * @return
	 */
	public int findyifabunumbytype(String announcement_type, String as_name) {
		List<Announcement> announcement = announcementDao.findasnonum(announcement_type, as_name);
		if(announcement!=null && announcement.size()>0){
			return announcement.size();
		}
		return 0;
	}

	/**
	 * 根据announcement_type 查询出wei 发布的公告数量
	 * @param announcement_type
	 * @return
	 */
	public int findweifabunumbytype(String announcement_type, String as_name) {
		List<Announcement> announcement = announcementDao.findasnonum("保存未发布", as_name);
		if(announcement!=null && announcement.size()>0){
			return announcement.size();
		}
		return 0;
	}

	/**
	 * 保存Announcement 的方法，并返回id号
	 * @param an
	 * @return
	 */
	public int saveAnnouncementToReturnId(Announcement an) {
		announcementDao.saveAnnouncement(an);
		List<Announcement> announ = announcementDao.findAnnouncementOrderById();
		return announ.get(0).getAnnouncement_id();
	}

	/**
	 * 根据as_name查询出未发布的公告
	 * @param as_name
	 * @return
	 */
	public int findweifabunumbyas_name(String as_name) {
		
		return announcementDao.findweifabunumbyas_name(as_name);
	}

	/**
	 * 分页查询 根据m_id所有的公告
	 * @param pageNow
	 * @param m_id
	 * @return
	 */
	public List<AnnouncementQuery> findAllannoBym_id(int pageNow, int m_id) {
		//根据m_id从Anno_Sendee分页查询出所属公告
		List<Anno_Sendee> annosen = announcementDao.findAnno_SendeeBym_id(m_id,pageNow);
		ArrayList<AnnouncementQuery> al = new ArrayList<AnnouncementQuery>();
		if(null != annosen){
			for (Anno_Sendee as : annosen) {
				AnnouncementQuery aq = new AnnouncementQuery();
				//根据an_id查询出Announcement的内容
				Announcement ann = announcementDao.findAnnouncementByan_id(as.getAn_id());
				aq.setAmount(ann.getAnnouncement_amount());
				aq.setAs_id(ann.getAs_id());
				aq.setAs_name(ann.getAs_name());
				aq.setId(ann.getAnnouncement_id());
				aq.setInfo(ann.getAnnouncement_info());
				aq.setM_username(ann.getM_username());
				aq.setState(as.getState());
				aq.setTime(ann.getAnnouncement_time());
				aq.setTitle(ann.getAnnoun_title());
				aq.setType(ann.getAnnouncement_type());
				aq.setViews(ann.getAnnouncement_views());
				al.add(aq);
			}
		}
		
		return al;
	}

	/**
	 * 查询出所有未读公告的数量
	 * @param m_id
	 * @return
	 */
	public int findnoStatenum(int m_id) {
		//根据m_id从Anno_Sendee分页查询出所属公告
		List<Anno_Sendee> annosen = announcementDao.findallAnno_SendeeBym_id(m_id);
		int nostate = 0;
		if(annosen!=null){
			for (Anno_Sendee as : annosen) {
				if(as.getState()==2){
					nostate++;
				}
			}
		}
		return nostate;
	}

	/**
	 * 查询出所有归属公告的数量
	 * @param m_id
	 * @return
	 */
	public long findAllannonumBym_id(int m_id) {
		List<Anno_Sendee> annosen = announcementDao.findallAnno_SendeeBym_id(m_id);
		if(annosen!=null){
			return annosen.size();
		}
		return 0;
	}

	/**
	 * 根据an_id和m_id从Anno_sendee修改所读取公告的state
	 * @param m_id
	 * @param announcement_id
	 */
	public void updateAnno_sendeeToState(int m_id, int announcement_id) {
		//根据an_id和m_id从Anno_sendee查询所读取公告的state
		List<Anno_Sendee> annosen = announcementDao.findAnno_SendeeBym_idAndan_id(m_id,announcement_id);
		
		if(annosen!=null){
			Anno_Sendee as = annosen.get(0);
			as.setState(1);
			announcementDao.updateAnno_sendeeToState(as);
		}
	}

	/**
	 * 根据an_id（announcement_id）删除所有的归属公告
	 * @param announcement_id
	 */
	public void deleteAnno_SendeeByan_id(int announcement_id) {
		announcementDao.deleteAnno_SendeeByAn_id(announcement_id);
	}
}
