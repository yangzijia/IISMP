package com.rms.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dao.AnnouncementDao;
import com.rms.dao.ApprovalDao;
import com.rms.dao.AssessDao;
import com.rms.dao.AttendanceDao;
import com.rms.dao.ContestDao;
import com.rms.dao.EquipmentDao;
import com.rms.dao.MerberDao;
import com.rms.dao.ResourceDao;
import com.rms.dao.StudyDao;
import com.rms.dao.SystemSettingDao;
public abstract class BaseService {

	protected MerberDao merberDao;
	@Autowired
	protected AnnouncementDao announcementDao;
	protected AttendanceDao attendanceDao;
	protected StudyDao studyDao;
	protected ResourceDao resourceDao;
	protected EquipmentDao equipmentDao;
	protected AssessDao assessDao;
	protected SystemSettingDao systemsetDao;
	protected ContestDao contestDao;
	protected ApprovalDao approvalDao;
	public ApprovalDao getApprovalDao() {
		return approvalDao;
	}
	@Resource
	public void setApprovalDao(ApprovalDao approvalDao) {
		this.approvalDao = approvalDao;
	}
	public ContestDao getContestDao() {
		return contestDao;
	}
	@Resource
	public void setContestDao(ContestDao contestDao) {
		this.contestDao = contestDao;
	}
	public AssessDao getAssessDao() {
		return assessDao;
	}
	@Resource
	public void setAssessDao(AssessDao assessDao) {
		this.assessDao = assessDao;
	}
	public ResourceDao getResourceDao() {
		return resourceDao;
	}
	@Resource
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	public EquipmentDao getEquipmentDao() {
		return equipmentDao;
	}
	@Resource
	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}
	public AttendanceDao getAttendanceDao() {
		return attendanceDao;
	}
	@Resource 
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}
	public StudyDao getStudyDao() {
		return studyDao;
	}
	@Resource 
	public void setStudyDao(StudyDao studyDao) {
		this.studyDao = studyDao;
	}
	/*public AnnouncementDao getAnnouncementDao() {
		return announcementDao;
	}
	@Resource 
	public void setAnnouncementDao(AnnouncementDao announcementDao) {
		this.announcementDao = announcementDao;
	}*/
	public MerberDao getMerberDao() {
		return merberDao;
	}
	@Resource
	public void setMerberDao(MerberDao merberDao) {
		this.merberDao = merberDao;
	}
	public SystemSettingDao getSystemsetDao() {
		return systemsetDao;
	}
	@Resource
	public void setSystemsetDao(SystemSettingDao systemsetDao) {
		this.systemsetDao = systemsetDao;
	}
	
	
	
}
