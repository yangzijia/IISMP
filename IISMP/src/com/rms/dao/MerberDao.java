package com.rms.dao;

import java.util.List;

import com.rms.model.MembershipInfo;

public interface MerberDao {
	
		//用户登录的方法
		public abstract List<MembershipInfo> Login(String m_username);
		
		/**
		 * 根据sectionname查询出所属的成员信息
		 * @param m_sectionname
		 * @return
		 */
		public abstract List<MembershipInfo> findallmemberinfos(
				String m_sectionname);
		public abstract List<MembershipInfo> findall();
}
