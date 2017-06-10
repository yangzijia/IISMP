package com.rms.dao;

import java.util.List;

import com.rms.model.Anno_Sendee;
import com.rms.model.Announce_section;
import com.rms.model.Announcement;
public interface AnnouncementDao {
	
	//添加公告
	public abstract void publish(Anno_Sendee as);
	
	public abstract int findAllCount();

	public abstract List<Announcement> findAll(int pageNow);

	public abstract boolean addSection(Announce_section as);

	public abstract void deleteSection(Announce_section s);

	public abstract List<Announce_section> findall1();

	public abstract List<Announce_section> changeSectionByid(int as_id);

	public abstract void updateA_sectioninfo(Announce_section s);

	public abstract List<Announcement> findbyAsid(int as_id);

	public abstract List<Announcement> findAllinfobyid(int announcement_id);

	public abstract void deleteAbyid(Announcement s);

	public abstract void changeviews(Announcement an);

	public abstract int findAll2Count();

	public abstract List<Announcement> findAll2(int pageNow);

	public abstract List<Announcement> findLoad(int id);

	public abstract List<Announcement> findNext(int id);

	public abstract List<Announcement> findbyAsid1(int as_id);

	public abstract List<Announcement> findAnnoinfos(int pageNow,
			String announcement_type, String as_name);

	public abstract List<Announcement> findasnonum(String announcement_type,
			String as_name);

	
	//编辑未发布公告
	public abstract void updateAnno(Announcement ann);

	/**
	 * 保存Announcement的方法
	 * @param an
	 */
	public abstract void saveAnnouncement(Announcement an);

	/**
	 * 倒叙查询出Announcement的内容
	 * @return
	 */
	public abstract List<Announcement> findAnnouncementOrderById();

	/**
	 * 根据as_name查询出未发布的公告
	 * @param as_name
	 * @return
	 */
	public abstract int findweifabunumbyas_name(String as_name);

	/**
	 * 根据m_id从Anno_Sendee分页查询出所属公告
	 * @param m_id
	 * @param pageNow
	 * @return
	 */
	public abstract List<Anno_Sendee> findAnno_SendeeBym_id(int m_id,
			int pageNow);

	/**
	 * 根据an_id查询出Announcement的内容
	 * @param an_id
	 * @return
	 */
	public abstract Announcement findAnnouncementByan_id(int an_id);

	/**
	 * 根据m_id查询出所有的归属公告信息
	 * @param m_id
	 * @return
	 */
	public abstract List<Anno_Sendee> findallAnno_SendeeBym_id(int m_id);

	/**
	 * 根据an_id和m_id从Anno_sendee查询所读取公告的state
	 * @param m_id
	 * @param announcement_id
	 * @return
	 */
	public abstract List<Anno_Sendee> findAnno_SendeeBym_idAndan_id(int m_id,
			int announcement_id);

	/**
	 * 更新Anno_Sendee表
	 * @param m_id
	 * @param announcement_id
	 */
	public abstract void updateAnno_sendeeToState(Anno_Sendee as);

	/**
	 * //根据an_id来删除各个用户的通知
	 * @param as
	 */
	public abstract void deleteAnno_SendeeByAn_id(int id);
	

	


}
