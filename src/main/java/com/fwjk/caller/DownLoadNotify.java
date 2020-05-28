package com.fwjk.caller;

/**
 * 下载通知
 * @author gaox
 *
 */
public class DownLoadNotify {
	
	private int totalCount = 0;
	private int downloadCount = 0;
	private boolean successs = false;
	private String message = "";
	private String remoteFileUrl = "";
	
	public static final DownLoadNotify Empty;
	static {
		Empty = new DownLoadNotify();
	}
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 获取下载记录数
	 * @return
	 */
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public boolean getSuccesss() {
		return successs;
	}
	public void setSuccesss(boolean successs) {
		this.successs = successs;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 获取下载文件路径
	 * @return
	 */
	public String getRemoteFileUrl() {
		return remoteFileUrl;
	}
	public void setRemoteFileUrl(String remoteFileUrl) {
		this.remoteFileUrl = remoteFileUrl;
	}
	
	public static DownLoadNotify create(String text){
		
		DownLoadNotify notify = new DownLoadNotify();
		String[] attrs = text.split("<>");
		if(attrs.length != 5) return Empty;
		
		if ( !attrs[0].equals("null") ){
			notify.setTotalCount(Integer.parseInt(attrs[0]));
		}
		
        if ( !attrs[1].equals("null") ){
        	notify.setDownloadCount(Integer.parseInt(attrs[1]));
		}
		
        if ( !attrs[2].equals("null") ){
        	notify.setSuccesss(Boolean.parseBoolean(attrs[2]));
		}
        
        if ( !attrs[3].equals("null") ){
        	notify.setMessage(attrs[3]);
		}
        
        if ( notify.getSuccesss() && !attrs[4].equals("null") ){
        	if (notify.getDownloadCount() == 0){
        		notify.setRemoteFileUrl("");
        	}else{
        	    notify.setRemoteFileUrl(attrs[4]);
        	}
		}
		
		return notify;
	}
}
