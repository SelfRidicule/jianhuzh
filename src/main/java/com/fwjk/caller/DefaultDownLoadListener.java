package com.fwjk.caller;

import com.fwjk.caller.inter.CallListener;


public class DefaultDownLoadListener implements CallListener<DownLoadNotify>{

	@Override
	public void notify(RBSPCallerBase sender, DownLoadNotify notify) {
        String message = String.format(">>>[debug]: created remoteFilePath=%s", notify.getRemoteFileUrl());
		System.out.println(message);
	}

	@Override
	public boolean cancel(RBSPCallerBase sender) {
		return false;
	}

	@Override
	public void start(RBSPCallerBase sender) {
		String message = String.format(">>>[debug]: SenderId=%s ,ServiceId=%s, %s",
				sender.getSenderId(), sender.getServiceId(),
				"start ...");
		
		System.out.println(message);
	}

	@Override
	public void finished(RBSPCallerBase sender, Exception error, boolean cancel) {
		String message = "";
		if (error != null){
			message = String.format(">>>[error]: SenderId=%s ,ServiceId=%s, %s",
					sender.getSenderId(), sender.getServiceId(),
					error.getMessage());
			
			System.out.println(message);
			return;
		}
		
		if ( cancel ){
			message = String.format(">>>[debug]: SenderId=%s ,ServiceId=%s, %s",
					sender.getSenderId(), sender.getServiceId(),
					"user cancel task");
			
			System.out.println(message);
			return;
		}
		
		message = String.format(">>>[error]: SenderId=%s ,ServiceId=%s, %s",
				sender.getSenderId(), sender.getServiceId(),
				"download success!!!!!!!!!");
		System.out.println(message);
	}

}
