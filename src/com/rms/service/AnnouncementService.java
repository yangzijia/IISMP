package com.rms.service;

import java.util.List;

import com.rms.model.Anno_Sendee;
import com.rms.model.Announce_section;
import com.rms.model.Announcement;
import com.rms.page.AnnouncementQuery;


public interface AnnouncementService {
	
	//发布公告
	public abstract void publish(Anno_Sendee as);
	
	//查询公告总数
	public abstract int findAllCount();
	
	//查询公告
	public abstract List<Announcement> findAll(int pageNow);
	
	//添加栏目
	public abstract boolean addSection(Announce_section as);
	//删除栏目
	public abstract void deleteSection(Announce_section s);
	//查找栏目
	public abstract List<Announce_section> findAll1();
	//根据id修改栏目
	public abstract Announce_section changeSectionByid(int as_id);
	//更新栏目信息
	public abstract void updateA_sectioninfo(Announce_section s);
	//根据栏目查询已发布公告
	public abstract List<Announcement> findbyAsid(int  as_id);
	//根据栏目查询未发布公告
	public abstract List<Announcement> findbyAsid1(int as_id);
	//根据id查看公告
	public abstract List<Announcement> findAllinfobyid(int announcement_id);
	//根据id删除公告
	public abstract void deleteAbyid(Announcement s);

	public abstract void changeviews(Announcement an);
	//查询未发布公告总数
	public abstract int findAll2Count();
	//查询未发布公告
	public abstract List<Announcement> findAll2(int pageNow);
	//查看上一条公告
	public abstract List<Announcement> findLoad(int id);
	//查看下一条公告
	public abstract List<Announcement> findNext(int id);
	//翻页（根据公告类型，公告栏目名）查询
	public abstract List<Announcement> findAnnoinfos(int pageNow,
			String announcement_type, String as_name);
	//（根据公告类型，公告栏目名）查询数量
	public abstract long findallasno(String announcement_type, String as_name);
//编辑未发布公告
	public abstract void updateAnno(Announcement ann);

	//查询出未发布的公告的数量
	public abstract int findweifabunum();

	/**
	 * 根据announcement_type 查询出已发布的公告数量
	 * @param announcement_type
	 * @return
	 */
	public abstract int findyifabunumbytype(String announcement_type,String as_name);

	/**
	 * 根据announcement_type 查询出wei 发布的公告数量
	 * @param announcement_type
	 * @return
	 */
	public abstract int findweifabunumbytype(String announcement_type,
			String as_name);

	/**
	 * 保存Announcement 的方法，并返回id号
	 * @param an
	 * @return
	 */
	public abstract int saveAnnouncementToReturnId(Announcement an);

	/**
	 * 根据as_name查询出未发布的公告
	 * @param as_name
	 * @return
	 */
	public abstract int findweifabunumbyas_name(String as_name);

	/**
	 * 分页查询 根据m_id所有的公告
	 * @param pageNow
	 * @param m_id
	 * @return
	 */
	public abstract List<AnnouncementQuery> findAllannoBym_id(int pageNow, int m_id);

	/**
	 * 查询出所有未读公告的数量
	 * @param m_id
	 * @return
	 */
	public abstract int findnoStatenum(int m_id);

	/**
	 * 查询出所有归属公告的数量
	 * @param m_id
	 * @return
	 */
	public abstract long findAllannonumBym_id(int m_id);

	/**
	 * 根据an_id和m_id从Anno_sendee修改所读取公告的state
	 * @param m_id
	 * @param announcement_id
	 */
	public abstract void updateAnno_sendeeToState(int m_id, int announcement_id);

	/**
	 * 根据an_id（announcement_id）删除所有的归属公告
	 * @param announcement_id
	 */
	public abstract void deleteAnno_SendeeByan_id(int announcement_id);

}
