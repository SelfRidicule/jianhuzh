package com.fwjk.caller;

public class SurveillanceNotify extends TaskNotify {
	private int hitCount = 0;
	private String hitTableDesc = "";

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
	public String getHitTableDesc() {
		return hitTableDesc;
	}

	public void setHitTableDesc(String hitTableDesc) {
		this.hitTableDesc = hitTableDesc;
	}
	
	public static final SurveillanceNotify Empty;

	static {
		Empty = new SurveillanceNotify();
	}

	public static SurveillanceNotify create(String text) {
		SurveillanceNotify notify = new SurveillanceNotify();

		String[] attrs = text.split("<>");
		if (attrs.length != 4)
			return SurveillanceNotify.Empty;

		TaskStatus status = createStatus(attrs[0]);
		if (status == TaskStatus.None)
			return SurveillanceNotify.Empty;

		notify.setStatus(status);
		if (status == TaskStatus.Hit) {
			// hit<>常住人口<>2<>http://10.32.92.233:18082/WA/xml//000776/3663359671386941_366387957865770.zip
			String tableDesc = attrs[1];
			notify.setHitTableDesc(tableDesc);
			
			int hitCount = Integer.parseInt(attrs[2]);
			notify.setHitCount(hitCount);
			String fileUrl = "";
			if (hitCount > 0) {
				fileUrl = attrs[3];
				notify.setRemoteFileUrl(fileUrl);
			}
		} else {
			// finish<>true<>null<>布控完成
			notify.setFinished(true);
			boolean success = Boolean.parseBoolean(attrs[1]);
			notify.setSuccess(success);
		}

		return notify;
	}

	private static TaskStatus createStatus(String text) {
		if (text == null)
			return TaskStatus.None;

		String tmp = text.trim();
		if (tmp.length() == 0)
			return TaskStatus.None;

		if (tmp.startsWith("hit"))
			return TaskStatus.Hit;

		if (tmp.startsWith("finish"))
			return TaskStatus.Finished;

		return TaskStatus.None;
	}

	
}
