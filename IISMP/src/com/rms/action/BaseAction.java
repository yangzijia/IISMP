package com.rms.action;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import com.rms.service.AnnouncementService;
import com.rms.service.ApprovalService;
import com.rms.service.AssessService;
import com.rms.service.AttendanceService;
import com.rms.service.ContestService;
import com.rms.service.EquipmentService;
import com.rms.service.MerberService;
import com.rms.service.ResourceService;
import com.rms.service.StudyService;
import com.rms.service.SystemSettingService;
public abstract class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected  MerberService merberService;
	protected  AnnouncementService announcementService;
	protected  AttendanceService attendanceService; 
	protected  StudyService studyService;
	protected  ResourceService resourceService;
	protected  EquipmentService equipmentService;
	protected  AssessService assessService;
	protected SystemSettingService systemsetService;
	protected ContestService contestService;
	protected ApprovalService approvalService;
	
	public ApprovalService getApprovalService() {
		return approvalService;
	}
	@Resource
	public void setApprovalService(ApprovalService approvalService) {
		this.approvalService = approvalService;
	}
	public ContestService getContestService() {
		return contestService;
	}
	@Resource
	public void setContestService(ContestService contestService) {
		this.contestService = contestService;
	}
	public AssessService getAssessService() {
		return getAssessService();
	}
	@Resource
	public void setAssessService(AssessService assessService) {
		this.assessService = assessService;
	}
	public EquipmentService getEquipmentService() {
		return equipmentService;
	}
	@Resource
	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
	public ResourceService getResourceService() {
		return resourceService;
	}
	@Resource
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	public StudyService getStudyService() {
		return studyService;
	}
	@Resource
	public void setStudyService(StudyService studyService) {
		this.studyService = studyService;
	}
	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}
	@Resource
	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}
	public MerberService getMerberService() {
		return merberService;
	}
	@Resource
	public void setMerberService(MerberService merberService) {
		this.merberService = merberService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AttendanceService getAttendanceService() {
		return attendanceService;
	}
	@Resource
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	public SystemSettingService getSystemsetService() {
		return systemsetService;
	}
	@Resource
	public void setSystemsetService(SystemSettingService systemsetService) {
		this.systemsetService = systemsetService;
	}
	
	
	

}
