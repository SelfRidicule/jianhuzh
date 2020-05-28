package com.fwjk.demo;

import java.util.Timer;
import java.util.TimerTask;

public class TaskByTimer extends TimerTask{ 
	public void run() {
		DownLoadDemo down = new DownLoadDemo();
		down.callDownLoadLocal();
	}
	public static void main(String[] args){		
		//如果第一次执行定时任务时间小于当前的时间 
		Timer timer = new Timer();
		TaskByTimer task = new TaskByTimer();
		timer.schedule(task, 0,1*60*1000);
	}
}
