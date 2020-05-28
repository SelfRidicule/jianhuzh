package com.fwjk.caller.inter;

import com.fwjk.caller.RBSPCallerBase;


public interface CallListener<T> {
	public void notify(RBSPCallerBase sender, T notify);
	public boolean cancel(RBSPCallerBase sender);
	
	public void start(RBSPCallerBase sender);
	public void finished(RBSPCallerBase sender, Exception error, boolean cancel);
	
}
