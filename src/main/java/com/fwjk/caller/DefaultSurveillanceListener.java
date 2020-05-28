package com.fwjk.caller;

import com.fwjk.caller.inter.CallListener;

public class DefaultSurveillanceListener implements CallListener<SurveillanceNotify>{

	@Override
	public void notify(RBSPCallerBase sender, SurveillanceNotify notify) {
        String message = String.format(">>>[debug-Surveillance]: hit=%d, created remoteFilePath=%s",
        		notify.getHitCount(),
        		notify.getRemoteFileUrl());
		System.out.println(message);
	}

	@Override
	public boolean cancel(RBSPCallerBase sender) {
		return false;
	}

	@Override
	public void start(RBSPCallerBase sender) {
		String message = String.format(">>>[debug-Surveillance]: SenderId=%s ,ServiceId=%s, %s",
				sender.getSenderId(), sender.getServiceId(),
				"start ...");
		
		System.out.println(message);
	}

	@Override
	public void finished(RBSPCallerBase sender, Exception error, boolean cancel) {
		String message = "";
		if (error != null){
			message = String.format(">>>[error-Surveillance]: SenderId=%s ,ServiceId=%s, %s",
					sender.getSenderId(), sender.getServiceId(),
					error.getMessage());
			
			System.out.println(message);
			return;
		}
		
		if ( cancel ){
			message = String.format(">>>[debug-Surveillance]: SenderId=%s ,ServiceId=%s, %s",
					sender.getSenderId(), sender.getServiceId(),
					"user cancel task");
			
			System.out.println(message);
			return;
		}
		
		message = String.format(">>>[debug-Surveillance]: SenderId=%s ,ServiceId=%s, %s",
				sender.getSenderId(), sender.getServiceId(),
				"Comparison success!!!!!!!!!");
		System.out.println(message);
	}

}
