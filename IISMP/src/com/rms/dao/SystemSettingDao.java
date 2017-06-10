package com.rms.dao;

import java.util.List;

import com.rms.model.MembershipInfo;
import com.rms.model.Section;

public interface SystemSettingDao {

	/**
	 * 查询出所有的分组的方法
	 * @return List<Section>
	 * @author yangzijia
	 * @date 2016-10-19
	 */
	public abstract List<Section> findsectioninfo();

	/**
	 * 往section里增加数据
	 * @author yangzijia
	 * @date 2016-10-19
	 * @return null
	 */
	public abstract void addnewgroup(Section s);

	/**
	 * 根据id查找出该组的信息
	 * @param id
	 * @return List<Section> 一组数据
	 * @author yangzijia
	 * date 2016-10-21
	 */
	public abstract List<Section> findsectioninfoById(int id);

	/**
	 * 刷新section数据表的数据
	 * @param s
	 * @author yangzijia
	 * @date 2016-10-21
	 */
	public abstract void updateSctioninfo(Section s);

	/**
	 * 删除分组的方法
	 * @param id
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public abstract void deletesectionById(Section s);

	/**
	 * 分页查询出用户的列表信息
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @param pageNow 
	 * @param member_duty 
	 * @param section_names 
	 * @data 2106-10-21
	 */
	public abstract List<MembershipInfo> findMembershipInfos(int pageNow, String member_duty, String section_names);

	/**
	 * 查询出所有的成员
	 * @return List<MembershipInfo> 
	 * @author yangzijia
	 * @param member_duty 
	 * @param section_names 
	 * @data 2016-10-22
	 */
	public abstract List<MembershipInfo> findmembershipnum(String member_duty, String section_names);

	/**
	 * 添加新成员的方法
	 * @param msi1
	 * @author yangzijia
	 * @data 2016-10-22
	 */
	public abstract void savememberinfos(MembershipInfo msi1);

	/**
	 * 根据id查找用户的信息
	 * @param id
	 * @return MembershipInfo
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract List<MembershipInfo> findmembershipinfoByid(int id);

	/**
	 * 更新成员信息
	 * @param m
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract void updatememberinfo(MembershipInfo m);

	/**
	 * 分页查询出停用成员的列表信息
	 * @param pageNow
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @param m_duty 
	 * @date 2016-10-22
	 */
	public abstract List<MembershipInfo> findblockupMemberInfos(int pageNow, String m_duty);

	/**
	 * 查询出停用成员的数量
	 * @return size()
	 * @author yangzijia
	 * @param m_duty 
	 * @date 2016-10-22
	 */
	public abstract List<MembershipInfo> findblockupMembershipnum(String m_duty);

	/**
	 * 删除这个成员的方法
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract void deletethismember(MembershipInfo m);

	/**
	 * 根据姓名查找成员信息
	 * @param finduser
	 * @param m_state 
	 * @return List<MembershipInfo>
	 * @data 2016-10-25
	 */
	public abstract List<MembershipInfo> finduserByusername(String finduser, String m_state);

	/**
	 * 根据手机查找成员信息
	 * @param finduser
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public abstract List<MembershipInfo> finduserByphone(String finduser, String m_state);

	/**
	 * 根据邮箱查找成员信息
	 * @param finduser
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public abstract List<MembershipInfo> finduserByemail(String finduser, String m_state);

	/**
	 * 验证用户名是否存在
	 * @param susername
	 * @return boolean
	 */
	public abstract List<MembershipInfo> findmemberByusername(String susername);

	/**
	 * 验证组名时候存在
	 * @param csectionname
	 * @return boolean
	 */
	public abstract List<Section> findsectionByname(String csectionname);

	/**
	 * 根据m_id批量删除人员的方法
	 * @param m_id
	 * @author yangzijia
	 */
	public abstract void batchdeletememberbyId(int m_id);

	/**
	 * 查询出所有启用的人员
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public abstract List<MembershipInfo> findAllUseMember();

}
