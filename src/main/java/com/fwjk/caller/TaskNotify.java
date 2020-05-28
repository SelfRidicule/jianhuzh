package com.fwjk.caller;

public abstract class TaskNotify {
	private TaskStatus status = TaskStatus.None;
	private String remoteFileUrl = "";
    private boolean finished = false;
    private boolean success = false;
 
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public String getRemoteFileUrl() {
		return remoteFileUrl;
	}
	public void setRemoteFileUrl(String fileUrl) {
		this.remoteFileUrl = fileUrl;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
