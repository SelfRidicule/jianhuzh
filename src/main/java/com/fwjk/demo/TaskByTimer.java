package com.fwjk.demo;

import java.util.Timer;
import java.util.TimerTask;

public class TaskByTimer extends TimerTask{ 
	public void run() {
		DownLoadDemo down = new DownLoadDemo();
		down.callDownLoadLocal();
	}
	public static void main(String[] args){		
		//�����һ��ִ�ж�ʱ����ʱ��С�ڵ�ǰ��ʱ�� 
		Timer timer = new Timer();
		TaskByTimer task = new TaskByTimer();
		timer.schedule(task, 0,1*60*1000);
	}
}
