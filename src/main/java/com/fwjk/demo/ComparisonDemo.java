package com.fwjk.demo;

import com.fwjk.caller.ComparisonCaller;
import com.fwjk.caller.ComparisonNotify;
import com.fwjk.caller.RBSPCallerBase;
import com.fwjk.caller.inter.CallListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * �ԱȽӿڲ���ʾ�� PKI ��ȡ��ʽ����֤���PKI_ID.html�Զ���ȡ֤����
 * 
 * @author gaox
 *
 */
public class ComparisonDemo {
	/**
	 * ����ʡ�����߷���ڵ�
	 */
	static String ST_NODE_URL = "http://10.32.203.231:8080/node";

	public static void main(String[] args) {
		callByDatas();
	}

	private static void callByDatas() {
		// ��������
		String nodeUrl = ST_NODE_URL; // ����ڵ�URL
		String pkiId = UUID.randomUUID().toString().replace("-","");
		String SenderID = "C32-00000192"; // ���󷽱�� ��
		String ServiceID = "S32-00002174";// ���񷽱�š�
		String zdyhGmsfhm = "320723198503052210"; // �ն��û����֤ ��
		String zdyhXm = "�տ�"; // �ն��û�������
		String zdyhDwbm = "320000330000"; // �ն��û���λ���롣
		String zdyhDwmc = "���Ŵ�"; // �ն��û���λ���ơ�
		String xtmc = "320�켣"; // �ն�ϵͳ���ơ�
		String zdyhJh = "000776"; // �ն��û����š�
		String zdyhIp = "10.32.206.5"; // �ն��û�IP��ַ��
		String zdyhMac = "F4:4D:30:17:A0:18";// �ն��û�MAC��ַ��

		// Ŀ����������
		String condition = "";// gmsfhm='321302198711280020'  

		
		ComparisonCaller caller = new ComparisonCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm,
				zdyhDwbm, zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		// ���öԱȻص�������
		caller.setListener(new DemoComparisonListener());

		// �Ա����������֤�š����ƺ��룩
		List<String> comparisonDatas = new ArrayList<String>();
		comparisonDatas.add("321302198711280020");
		comparisonDatas.add("320621199102134721");
		// ��������
		caller.runByData(condition, comparisonDatas);
	}
}

/**
 * �ȶ�֪ͨ������
 * @author gaox
 *
 */
class DemoComparisonListener implements CallListener<ComparisonNotify> {

	/**
	 * �ȶ�����ִ��ǰ����
	 */
	@Override
	public void start(RBSPCallerBase sender) {
		String message = String.format(">>>[debug]: ����Id=%s ,����Id=%s, %s", sender.getSenderId(),
				sender.getServiceId(), "start ...");

		System.out.println(message);
	}
	
	/**
	 * ��������ʱ����
	 * @param notify ����֪ͨ��Ϣʵ��
	 */
	@Override
	public void notify(RBSPCallerBase sender, ComparisonNotify notify) {
		String message = String.format(">>>[debug-Comparison]: ������=%d, Զ�̽���ļ�URL=%s", 
				notify.getHitCount(),
				notify.getRemoteFileUrl());
		System.out.println(message);
	}

	@Override
	public boolean cancel(RBSPCallerBase sender) {
		return false;
	}
	
	/**
	 * �ȶ�������ɺ󴥷�
	 */
	@Override
	public void finished(RBSPCallerBase sender, Exception error, boolean cancel) {
		String message = "";
		if (error != null) {
			// ���������з����쳣
			message = String.format(">>>[error]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
					sender.getServiceId(), error.getMessage());

			System.out.println(message);
			error.printStackTrace();
			return;
		}

		if (cancel) {
			// ��������ʱ���û�ȡ��
			message = String.format(">>>[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
					sender.getServiceId(), "user cancel task");

			System.out.println(message);
			return;
		}

		message = String.format(">>>[debug-demo]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
				sender.getServiceId(), "Comparison success!!!!!!!!!");
		System.out.println(message);
	}

}
