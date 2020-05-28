package com.fwjk.caller;

public class RBSPNotifyCallerBase extends RBSPCallerBase {

	private long waitCallNotifyIntervalTime = 500L;

	/**
	 * ��ȡ����֪ͨ��ʱ����
	 * @return
	 */
	public long getWaitCallNotifyIntervalTime() {
		return waitCallNotifyIntervalTime;
	}
	
	/**
	 * ���õ���֪ͨ��ʱ����
	 * @param waitNotifyIntervalTime
	 */
	public void setWaitCallNotifyIntervalTime(long waitCallNotifyIntervalTime) {
		this.waitCallNotifyIntervalTime = Math.max(waitCallNotifyIntervalTime, 100L);
	}

	
	public RBSPNotifyCallerBase(String nodeUrl, String pkiId, String senderId, String serviceId, String zdyhGmsfhm,
			String zdyhXm, String zdyhDwbm, String zdyhDwmc, String zdyhJh, String xtmc, String zdyhIp,
			String zdyhMac) {
		super(nodeUrl, pkiId, senderId, serviceId, zdyhGmsfhm, zdyhXm, zdyhDwbm, zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		// TODO Auto-generated constructor stub
	}
	
}
