package com.fwjk.caller;

/**
 * 请求方信息
 * @author gaox
 *
 */
public class CallerInformation {
	private String zdyhGmsfhm;
	private String zdyhXm; 
	private String zdyhDwbm; 
	private String zdyhDwmc; 
	private String zdyhJh; 
	private String xtmc; 
	private String zdyhIp; 
	private String zdyhMac;
	
	/**
	 * 获取公民身份证号
	 * @return
	 */
	public String getZdyhGmsfhm() {
		return zdyhGmsfhm;
	}
	
	public void setZdyhGmsfhm(String zdyhGmsfhm) {
		this.zdyhGmsfhm = zdyhGmsfhm;
	}
	
	public String getZdyhXm() {
		return zdyhXm;
	}
	
	public void setZdyhXm(String zdyhXm) {
		this.zdyhXm = zdyhXm;
	}
	
	public String getZdyhDwbm() {
		return zdyhDwbm;
	}
	
	public void setZdyhDwbm(String zdyhDwbm) {
		this.zdyhDwbm = zdyhDwbm;
	}
	
	public String getZdyhDwmc() {
		return zdyhDwmc;
	}
	
	public void setZdyhDwmc(String zdyhDwmc) {
		this.zdyhDwmc = zdyhDwmc;
	}
	
	public String getZdyhJh() {
		return zdyhJh;
	}
	
	public void setZdyhJh(String zdyhJh) {
		this.zdyhJh = zdyhJh;
	}
	
	public String getXtmc() {
		return xtmc;
	}
	
	public void setXtmc(String xtmc) {
		this.xtmc = xtmc;
	}
	
	public String getZdyhIp() {
		return zdyhIp;
	}
	public void setZdyhIp(String zdyhIp) {
		this.zdyhIp = zdyhIp;
	}
	
	public String getZdyhMac() {
		return zdyhMac;
	}
	public void setZdyhMac(String zdyhMac) {
		this.zdyhMac = zdyhMac;
	}
	
	public CallerInformation(String zdyhGmsfhm,
            String zdyhXm,
            String zdyhDwbm,
            String zdyhDwmc,
            String zdyhJh,
            String xtmc,
            String zdyhIp, 
            String zdyhMac){
		
		this.zdyhGmsfhm = zdyhGmsfhm;
		this.zdyhXm =zdyhXm;
		this.zdyhDwbm = zdyhDwbm;
		this.zdyhDwmc =zdyhDwmc;
		this.zdyhJh = zdyhJh;
		this.xtmc = xtmc;
		this.zdyhIp = zdyhIp;
		this.zdyhMac = zdyhMac;
	}
	
}
