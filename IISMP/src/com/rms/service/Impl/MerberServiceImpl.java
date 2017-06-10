package com.rms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Component;
import com.rms.model.MembershipInfo;
import com.rms.service.BaseService;
import com.rms.service.MerberService;
@Component("merberService")
public class MerberServiceImpl extends BaseService implements MerberService{

	public List<MembershipInfo> Login(String m_username) {
		List<MembershipInfo> m = merberDao.Login(m_username);
		if(m != null && m.size() >0) {
			return m;
		}
		return null;
	}

	/**
	 * 根据sectionname查询出所属的成员信息
	 * @param m_sectionname
	 * @return
	 */
	public List<MembershipInfo> findallmemberinfos(String m_sectionname) {
		return this.merberDao.findallmemberinfos(m_sectionname);
	}
	


	@Override
	public List<MembershipInfo> findall() {
		// TODO Auto-generated method stub
		return this.merberDao.findall();
	}
	
}
