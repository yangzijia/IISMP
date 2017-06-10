package com.rms.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;
import com.rms.dao.BaseDao;
import com.rms.dao.MerberDao;
import com.rms.model.MembershipInfo;

@Component("merberDao")
public class MerberDaoImpl extends BaseDao implements MerberDao{
	
	/**
	 * 用户登录
	 */
	public List<MembershipInfo> Login(String m_username) {
		@SuppressWarnings("unchecked")
		
		List<MembershipInfo> me = hibernateTemplate.find("from MembershipInfo where m_username='"+m_username+"' and m_state='启用'");
		
		System.out.println(m_username);
		if(me != null && me.size()>0) {
			return me;
		}
		return null;
	}

	/**
	 * 根据sectionname查询出所属的成员信息
	 * @param m_sectionname
	 * @return
	 */
	public List<MembershipInfo> findallmemberinfos(String m_sectionname) {
		System.out.println("sectionname==="+m_sectionname);
		String sql = "";
		if(m_sectionname=="allinfos" || m_sectionname.equals("allinfos")){
			sql = "from MembershipInfo where m_state='启用' order by role_num, m_entermiictime desc";
		}else{
			sql = "from MembershipInfo where m_state='启用' and m_sectionname='"+ m_sectionname +"' order by role_num, m_entermiictime desc";
		}
		@SuppressWarnings("unchecked")
		List<MembershipInfo> member = hibernateTemplate.find(sql);
		return member;
	}
	
	public List<MembershipInfo> findall() {
		@SuppressWarnings("unchecked")
		List<MembershipInfo> merber = hibernateTemplate
				.find("from MembershipInfo ");
		if(merber != null && merber.size() >0){
			return merber;
		}
		return null;
	}
}
