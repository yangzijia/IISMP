package com.rms.page;

public class FinalAssess implements Comparable<FinalAssess> {
	private int id;
	private int paiming;
	private String username;
	private String sectionname;
	private int kaoqin;
	private int biaoxian;
	private int xiangmu;
	private int xinde;
	private int heji;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPaiming() {
		return paiming;
	}
	public void setPaiming(int paiming) {
		this.paiming = paiming;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	
	public int getKaoqin() {
		return kaoqin;
	}
	public void setKaoqin(int kaoqin) {
		this.kaoqin = kaoqin;
	}
	public int getBiaoxian() {
		return biaoxian;
	}
	public void setBiaoxian(int biaoxian) {
		this.biaoxian = biaoxian;
	}
	public int getXiangmu() {
		return xiangmu;
	}
	public void setXiangmu(int xiangmu) {
		this.xiangmu = xiangmu;
	}
	public int getXinde() {
		return xinde;
	}
	public void setXinde(int xinde) {
		this.xinde = xinde;
	}
	public int getHeji() {
		return heji;
	}
	public void setHeji(int heji) {
		this.heji = heji;
	}
	@Override
	public String toString() {
		return "FinalAssess [id=" + id + ", username=" + username
				+ ", sectionname=" + sectionname + ", kaoqin=" + kaoqin
				+ ", biaoxian=" + biaoxian + ", xiangmu=" + xiangmu
				+ ", xinde=" + xinde + ", heji=" + heji + "]";
	}
	
	@Override
	public int compareTo(FinalAssess o) {
		int num = (this.getHeji() < o.getHeji() ? 1 :(this.getHeji() == o.getHeji() ? 0 : -1));
		return num;
	}
	
}
