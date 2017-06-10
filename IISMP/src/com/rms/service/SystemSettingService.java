package com.rms.service;

import java.util.List;

import com.rms.model.MembershipInfo;
import com.rms.model.Section;

public interface SystemSettingService {

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
	 * @return Section 一zu数据
	 * @author yangzijia
	 * @date 2016-10-21
	 */
	public abstract Section findsectioninfoById(int id);

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
	 * 查询出用户的列表信息
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @param pageNow 
	 * @param member_duty 
	 * @param section_names 
	 * @param finduser 
	 * @data 2106-10-21
	 */
	public abstract List<MembershipInfo> findMembershipInfos(int pageNow, String member_duty, String section_names);

	/**
	 * 查询出成员的总数
	 * @return long number 
	 * @author yangzijia
	 * @param member_duty 
	 * @param section_names 
	 * @data 2016-10-22
	 */
	public abstract long findMembershipnum(String member_duty, String section_names);

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
	public abstract boolean blockupthismemberByid(int id);

	/**
	 * 根据用户的id查找用户信息
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract MembershipInfo findmemberinfoByid(int id);

	/**
	 * 修改成员信息的方法
	 * @param msi1
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract void saveeditmemberinfo(MembershipInfo msi1);

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
	public abstract long findblockupMembershipnum(String m_duty);

	/**
	 * 删除这个成员的方法
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract void deletethismember(MembershipInfo m);

	/**
	 * 重新启用该用户的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public abstract void startusingthismember(int id);

	/**
	 * 根据具体条件查询用户
	 * @author yangzijia
	 * @param m_state 
	 * @data 2016-10-24
	 */
	public abstract List<MembershipInfo> finduserByCondition(String finduser, String m_state);

	/**
	 * 批量停用人员的方法
	 * @param delList
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public abstract void batchupdatemember(List<String> delList);

	/**
	 * 验证用户名是否存在
	 * @param susername
	 * @return boolean
	 */
	public abstract boolean checkusername(String susername);

	/**
	 * 验证组名时候存在
	 * @param ssectionname
	 * @return boolean
	 */
	public abstract boolean checksection(String ssectionname);

	/**
	 * 修改QQ
	 * @param mi
	 * @author yangzijia
	 */
	public abstract void updateMemberinfo(MembershipInfo mi);

	/**
	 * 批量删除人员的方法
	 * @param delList
	 * @author yangzijia
	 */
	public abstract void batchdeletemember(List<String> delList);

	/**
	 * 批量启用人员的方法
	 * @param delList
	 * @author yangzijia
	 */
	public abstract void batchqiyongmember(List<String> delList);

	/**
	 * 查询出所有启用的人员
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public abstract List<MembershipInfo> findAllUseMember();




}
