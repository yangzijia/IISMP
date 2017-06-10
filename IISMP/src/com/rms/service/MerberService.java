package com.rms.service;

import java.util.List;

import com.rms.model.MembershipInfo;

public interface MerberService {
	
	/**
	 * 登陆查询的方法
	 * @param m_username
	 * @return List<MembershipInfo>
	 */
	public abstract List<MembershipInfo> Login(String m_username);
	public abstract List<MembershipInfo> findall();
	/**
	 * 根据sectionname查询出所属的成员信息
	 * @param m_sectionname
	 * @return
	 */
	public abstract List<MembershipInfo> findallmemberinfos(String m_sectionname);
	
	

}
