package com.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rms.dao.BaseDao;
import com.rms.dao.SystemSettingDao;
import com.rms.model.MembershipInfo;
import com.rms.model.Section;

@Component("systemsetDao")
public class SystemSettingDaoImpl extends BaseDao implements SystemSettingDao{

	/**
	 * 查询出所有的分组的方法
	 * @return List<Section>
	 * @author yangzijia
	 * @date 2016-10-19
	 */
	public List<Section> findsectioninfo() {
		@SuppressWarnings("unchecked")
		List<Section> section = hibernateTemplate.
				find("from Section order by section_name asc");
		return section;
	}

	/**
	 * 往section里增加数据
	 * @author yangzijia
	 * @date 2016-10-19
	 * @return null
	 */
	public void addnewgroup(Section s) {
		hibernateTemplate.save(s);
	}

	/**
	 * 根据id查找出该组的信息
	 * @param id
	 * @return List<Section> 一组数据
	 * @author yangzijia
	 * date 2016-10-21
	 */
	public List<Section> findsectioninfoById(int id) {
		@SuppressWarnings("unchecked")
		List<Section> section = hibernateTemplate.find("from Section where id = '"+id+"'");
		return section;
	}

	/**
	 * 刷新section数据表的数据
	 * @param s
	 * @author yangzijia
	 * @date 2016-10-21
	 */
	public void updateSctioninfo(Section s) {
		hibernateTemplate.update(s);
	}

	/**
	 * 删除分组的方法
	 * @param id
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public void deletesectionById(Section s) {
		hibernateTemplate.delete(s);
	}

	/**
	 * 分页查询出用户的列表信息
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @data 2106-10-21
	 */
	public List<MembershipInfo> findMembershipInfos(int pageNow, String member_duty,String section_names) {
		String sql = "";

		if(member_duty.equals("全部职务")||member_duty.equals(null)){
			if(section_names!= "" && section_names != null){
				sql = "from MembershipInfo where m_state = '启用' and m_sectionname='"+ section_names +"' order by role_num,m_entermiictime desc";
			}else {
				sql = "from MembershipInfo where m_state = '启用' order by role_num,m_entermiictime desc";
			}
		}else{
			if(section_names!= "" && section_names !=null){
				sql = "from MembershipInfo where m_state = '启用' and m_role='"+member_duty+"' and m_sectionname='"+ section_names +"' order by role_num,m_entermiictime desc";
			}else{
				sql = "from MembershipInfo where m_state = '启用' and m_role='"+member_duty+"' order by role_num,m_entermiictime desc";
			}
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi =  query.list();
		session.close();
		return msi;
	}

	/**
	 * 查询出所有的成员
	 * @return List<MembershipInfo> 
	 * @author yangzijia
	 * @data 2016-10-22
	 */
	public List<MembershipInfo> findmembershipnum(String member_duty, String section_names) {
		String sql = "";
		if(member_duty.equals("全部职务")||member_duty.equals(null)){
			if(section_names!= "" && section_names !=null){
				sql = "from MembershipInfo where m_state = '启用' and m_sectionname='"+ section_names +"'";
			}else {
				sql = "from MembershipInfo where m_state = '启用'";
			}
		}else{
			if(section_names!= "" && section_names !=null){
				sql = "from MembershipInfo where m_state = '启用' and m_role='"+member_duty+"' and m_sectionname='"+ section_names +"'";
			}else{
				sql = "from MembershipInfo where m_state = '启用' and m_role='"+member_duty+"'";
			}
		}
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate.find(sql);
		return msi;
	}

	/**
	 * 添加新成员的方法
	 * @param msi1
	 * @author yangzijia
	 * @data 2016-10-22
	 */
	public void savememberinfos(MembershipInfo msi1) {
		hibernateTemplate.save(msi1);
	}

	/**
	 * 根据id查找用户的信息
	 * @param id
	 * @return MembershipInfo
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public List<MembershipInfo> findmembershipinfoByid(int id) {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> m = hibernateTemplate.find("from MembershipInfo where id= '"+id+"'");
		return m;
	}

	/**
	 * 更新成员信息
	 * @param m
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void updatememberinfo(MembershipInfo m) {
		System.out.println(m.getM_userpicture().length());
		hibernateTemplate.update(m);
	}

	/**
	 * 分页查询出停用成员的列表信息
	 * @param pageNow
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public List<MembershipInfo> findblockupMemberInfos(int pageNow,String m_duty) {
		String sql = "";
		if(m_duty.equals("全部职务")){
			sql = "from MembershipInfo where m_state = '停用' order by role_num, m_entermiictime desc";
		}else {
			sql = "from MembershipInfo where m_state = '停用' and m_role='"+m_duty+"' order by role_num, m_entermiictime desc";
		}
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult((pageNow - 1) * 20);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi =  query.list();
		session.close();
		return msi;
	}

	/**
	 * 查询出停用成员的数量
	 * @return size()
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public List<MembershipInfo> findblockupMembershipnum(String m_duty) {
		String sql = "";
		if(m_duty.equals("全部职务")){
			sql = "from MembershipInfo where m_state = '停用'";
		}else {
			sql = "from MembershipInfo where m_state = '停用' and m_role='"+m_duty+"'";
		}
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate.find(sql);
		return msi;
	}

	/**
	 * 删除这个成员的方法
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void deletethismember(MembershipInfo m) {
		hibernateTemplate.delete(m);
	}

	/**
	 * 根据姓名查找成员信息
	 * @param finduser
	 * @return List<MembershipInfo>
	 * @data 2016-10-25
	 */
	public List<MembershipInfo> finduserByusername(String finduser, String m_state) {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate
				.find("from MembershipInfo where m_truename like '%"+finduser+"%' and m_state='"+m_state+"' order by role_num, m_entermiictime desc");
		return msi;
	}

	/**
	 * 根据手机查找成员信息
	 * @param finduser
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public List<MembershipInfo> finduserByphone(String finduser, String m_state) {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate
				.find("from MembershipInfo where m_phone like '%"+finduser+"%' and m_state='"+m_state+"' order by role_num, m_entermiictime desc");
		return msi;
	}

	/**
	 * 根据邮箱查找成员信息
	 * @param finduser
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public List<MembershipInfo> finduserByemail(String finduser, String m_state) {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate
				.find("from MembershipInfo where m_email like '%"+finduser+"%' and m_state='"+m_state+"' order by role_num, m_entermiictime desc");
		return msi;
	}

	/**
	 * 验证用户名是否存在
	 * @param susername
	 * @return boolean
	 */
	public List<MembershipInfo> findmemberByusername(String susername) {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> msi = hibernateTemplate
				.find("from MembershipInfo where m_username='"+susername+"'");
		return msi;
	}

	/**
	 * 验证组名时候存在
	 * @param csectionname
	 * @return boolean
	 */
	public List<Section> findsectionByname(String csectionname) {
		@SuppressWarnings("unchecked")
		List<Section> s = hibernateTemplate.find("from Section where section_name='"+csectionname+"'");
		return s;
	}

	/**
	 * 根据m_id批量删除人员的方法
	 * @param m_id
	 * @author yangzijia
	 */
	public void batchdeletememberbyId(int m_id) {
		MembershipInfo msi = new MembershipInfo();
		msi.setM_id(m_id);
		hibernateTemplate.delete(msi);
	}

	/**
	 * 查询出所有启用的人员
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public List<MembershipInfo> findAllUseMember() {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> s = hibernateTemplate.find("from MembershipInfo m where m.m_state='启用'");
		return s;
	}

}
