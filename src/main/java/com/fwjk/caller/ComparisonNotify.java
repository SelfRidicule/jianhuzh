package com.fwjk.caller;

/**
 * 对比通知
 * @author gaox
 *
 */
public class ComparisonNotify extends TaskNotify {
	
	private int hitCount = 0;
	
    public static final ComparisonNotify Empty;
    
    static {
    	Empty = new ComparisonNotify();
    }
    
	
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
	
    public static ComparisonNotify create(String text){
    	ComparisonNotify notify = new ComparisonNotify();
    	
    	String[] attrs = text.split("<>");
		if(attrs.length != 3) return ComparisonNotify.Empty;
		
		TaskStatus status = createStatus( attrs[0] );
		if ( status == TaskStatus.None) 
			return ComparisonNotify.Empty;
		
		notify.setStatus(status);
		if(status == TaskStatus.Hit){
			int hitCount = Integer.parseInt(attrs[1]);
			notify.setHitCount(hitCount);
			String fileUrl = "";
			if (hitCount > 0){
				fileUrl = attrs[2];
				notify.setRemoteFileUrl(fileUrl);
			}
		}else {
			// finish<>true<>比对完成！
			notify.setFinished(true);
			boolean success = Boolean.parseBoolean(attrs[1]);
			notify.setSuccess(success);
		}
    	
    	return notify;
    }
    
    
    private static TaskStatus createStatus(String text){
    	if (text == null) return TaskStatus.None;
    	
    	String tmp = text.trim();
    	if (tmp.length() == 0) return TaskStatus.None;
    	
    	if(tmp.startsWith("hit")) return TaskStatus.Hit;
    	
    	if(tmp.startsWith("finish")) return TaskStatus.Finished;
    		
    	return TaskStatus.None;
    }
}
