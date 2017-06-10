package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rms.model.MembershipInfo;
import com.rms.model.Section;
import com.rms.service.BaseService;
import com.rms.service.SystemSettingService;

@Component("systemsetService")
public class SystemSettingServiceImpl extends BaseService implements SystemSettingService {

	/**
	 * 查询出所有的分组的方法
	 * @return List<Section>
	 * @author yangzijia
	 * @date 2016-10-19
	 */
	public List<Section> findsectioninfo() {
		List<Section> section = systemsetDao.findsectioninfo();
		return section;
	}

	/**
	 * 往section里增加数据
	 * @author yangzijia
	 * @date 2016-10-19
	 * @return null
	 */
	public void addnewgroup(Section s) {
		systemsetDao.addnewgroup(s);
	}

	/**
	 * 根据id查找出该组的信息
	 * @param id
	 * @return Section 一组数据
	 * @author yangzijia
	 * date 2016-10-21
	 */
	public Section findsectioninfoById(int id) {
		List<Section> section = systemsetDao.findsectioninfoById(id);
		if(section != null && section.size() > 0){
			Section s = section.get(0);
			return s;
		}
		return null;
	}

	/**
	 * 刷新section数据表的数据
	 * @param s
	 * @author yangzijia
	 * @date 2016-10-21
	 */
	public void updateSctioninfo(Section s) {
		systemsetDao.updateSctioninfo(s);
	}

	/**
	 * 删除分组的方法
	 * @param id
	 * @author yangzijia
	 * @data 2016-10-21
	 */
	public void deletesectionById(Section s) {
		systemsetDao.deletesectionById(s);
	}

	/**
	 * 查询出用户的列表信息
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @data 2106-10-21
	 */
	public List<MembershipInfo> findMembershipInfos(int pageNow, String member_duty, String section_names) {
		List<MembershipInfo> msi = systemsetDao.findMembershipInfos(pageNow,member_duty,section_names);
		if(msi != null && msi.size() > 0){
			return msi;
		}
		return null;
	}

	/**
	 * 查询出成员的总数
	 * @return long number 
	 * @author yangzijia
	 * @data 2016-10-22
	 */
	public long findMembershipnum(String member_duty, String section_names) {
		List<MembershipInfo> msi = systemsetDao.findmembershipnum(member_duty,section_names);
		if(msi != null && msi.size() > 0){
			return msi.size();
		}
		return 0;
	}

	/**
	 * 添加新成员的方法
	 * @param msi1
	 * @author yangzijia
	 * @data 2016-10-22
	 */
	public void savememberinfos(MembershipInfo msi1) {
		systemsetDao.savememberinfos(msi1);
	}

	/**
	 * 根据id查找用户的信息
	 * @param id
	 * @return MembershipInfo
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public boolean blockupthismemberByid(int id) {
		List<MembershipInfo> msi = systemsetDao.findmembershipinfoByid(id);
		if(msi != null && msi.size() > 0){
			MembershipInfo  m = msi.get(0);
			m.setM_state("停用");
			//更新成员信息
			systemsetDao.updatememberinfo(m);
			return true;
		}
		return false;
	}

	/**
	 * 根据用户的id查找用户信息
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public MembershipInfo findmemberinfoByid(int id) {
		List<MembershipInfo> msi = systemsetDao.findmembershipinfoByid(id);
		if(msi != null && msi.size() > 0){
			MembershipInfo  m = msi.get(0);
			return m;
		}
		return null;
	}

	/**
	 * 修改成员信息的方法
	 * @param msi1
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void saveeditmemberinfo(MembershipInfo msi1) {
		//更新成员信息
		systemsetDao.updatememberinfo(msi1);
	}

	/**
	 * 分页查询出停用成员的列表信息
	 * @param pageNow
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public List<MembershipInfo> findblockupMemberInfos(int pageNow,String m_duty) {
		List<MembershipInfo> msi = systemsetDao.findblockupMemberInfos(pageNow,m_duty);
		if(msi != null && msi.size() > 0){
			return msi;
		}
		return null;
	}

	/**
	 * 查询出停用成员的数量
	 * @return size()
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public long findblockupMembershipnum(String m_duty) {
		List<MembershipInfo> msi = systemsetDao.findblockupMembershipnum(m_duty);
		if(msi != null && msi.size() > 0){
			return msi.size();
		}
		return 0;
	}

	/**
	 * 删除这个成员的方法
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void deletethismember(MembershipInfo m) {
		systemsetDao.deletethismember(m);
	}

	/**
	 * 重新启用该用户的方法
	 * @throws Exception
	 * @author yangzijia
	 * @date 2016-10-22
	 */
	public void startusingthismember(int id) {
		//根据id查询用户信息
		List<MembershipInfo> msi = systemsetDao.findmembershipinfoByid(id);
		if(msi != null && msi.size() > 0){
			MembershipInfo m = msi.get(0);
			m.setM_state("启用");
			systemsetDao.updatememberinfo(m);
		}
	}

	/**
	 * 根据具体条件查询用户
	 * @author yangzijia
	 * @data 2016-10-24
	 */
	public List<MembershipInfo> finduserByCondition(String finduser ,String m_state) {
		String state = null;
		if(m_state.equals("启用人员")){
			state = "启用";
		}else if(m_state.equals("停用人员")){
			state = "停用";
		}
		//根据姓名查找成员信息
		List<MembershipInfo> msi = systemsetDao.finduserByusername(finduser,state);
		if(msi != null && msi.size() > 0){
			return msi;
		}else {
			//根据手机查找成员信息
			List<MembershipInfo> msi1 = systemsetDao.finduserByphone(finduser,state);
			if(msi1 != null && msi1.size() > 0){
				return msi1;
			}else {
				//根据邮箱查找成员信息
				List<MembershipInfo> msi2 = systemsetDao.finduserByemail(finduser,state);
				if(msi2 != null && msi2.size() > 0){
					return msi2;
				}
			}
		}
		return null;
	}

	/**
	 * 验证用户名是否存在
	 * @param susername
	 * @return boolean
	 */
	public boolean checkusername(String susername) {
		List<MembershipInfo> msi = systemsetDao.findmemberByusername(susername);
		if(msi != null && msi.size() > 0){
			return true;
		}
		return false;
	}

	/**
	 * 验证组名时候存在
	 * @param csectionname
	 * @return boolean
	 */
	public boolean checksection(String csectionname) {
		List<Section> s = systemsetDao.findsectionByname(csectionname);
		if(s != null && s.size() > 0){
			return false;
		}
		return true;
	}
	/**
	 * 修改QQ
	 * @param mi
	 * @author yangzijia
	 */
	public void updateMemberinfo(MembershipInfo mi) {
		systemsetDao.updatememberinfo(mi);
	}

	/**
	 * 批量停用人员的方法
	 * @param delList
	 * @author yangzijia
	 * @data 2016-10-25
	 */
	public void batchupdatemember(List<String> delList) {
		for(int i=0;i<delList.size();i++){
			List<MembershipInfo> msi = systemsetDao.findmembershipinfoByid(Integer.parseInt(delList.get(i)));
			MembershipInfo m = msi.get(0);
			m.setM_state("停用");
			systemsetDao.updatememberinfo(m);
		}
	}
	
	/**
	 * 批量删除人员的方法
	 * @param delList
	 * @author yangzijia
	 */
	public void batchdeletemember(List<String> delList) {
		for(int i=0;i<delList.size();i++){
			systemsetDao.batchdeletememberbyId(Integer.parseInt(delList.get(i)));
		}
	}

	/**
	 * 批量启用人员的方法
	 * @param delList
	 * @author yangzijia
	 */
	public void batchqiyongmember(List<String> delList) {
		for(int i=0;i<delList.size();i++){
			List<MembershipInfo> msi = systemsetDao.findmembershipinfoByid(Integer.parseInt(delList.get(i)));
			MembershipInfo m = msi.get(0);
			m.setM_state("启用");
			systemsetDao.updatememberinfo(m);
		}
	}

	/**
	 * 查询出所有启用的人员
	 * @return List<MembershipInfo>
	 * @author yangzijia
	 */
	public List<MembershipInfo> findAllUseMember() {
		return systemsetDao.findAllUseMember();
	}

}
