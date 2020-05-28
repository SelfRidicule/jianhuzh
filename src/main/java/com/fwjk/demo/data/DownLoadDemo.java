package com.fwjk.demo.data;

import com.fwjk.caller.DownLoadCaller;
import com.fwjk.caller.DownLoadNotify;
import com.fwjk.caller.RBSPCallerBase;
import com.fwjk.caller.inter.CallListener;

/**
 * ���ؽӿڲ�������
 * @author gaox
 *
 */
public class DownLoadDemo {

	static String nodeUrl = "http://10.39.128.48:8585/node";

	public static void main(String[] args) {
		callDownLoad();
	}
	// �������ؽӿڵ���
	private static void callDownLoadLocal() {

		String pkiId = "";
		String SenderID = "C32-09000045";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S32-09000186";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320924197906029018"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ΰ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320900230000";// ��������Ϊstring ,�ն��û���λ���롣
		String zdyhDwmc = "�γ��й�������Ϣͨ�Ŵ�";// ��������Ϊstring ,�ն��û���λ���ơ�
		String xtmc = "����ʡ�γ��й�����ͤ���־�ȫϢͼ";// ��������Ϊstring ,�ն�ϵͳ���ơ�
		String zdyhJh = "090947";// ��������Ϊstring ,�ն��û����š�
		String zdyhIp = "10.39.162.48";// ��������Ϊstring ,�ն��û�IP��ַ��
		String zdyhMac = "2C:9D:1E:C1:A7:CE";// ��������Ϊstring ,�ն��û�MAC��ַ��

		// ��ѯ����
		String condition = "  DJSJ>='20170201000000'  ";
		//djsj>='20160126000000'
		
		int startRow = 0;
		int numRow = 5;// ��������Ϊint,���ػ�ȡ��¼����

		
		DownLoadCaller caller = new DownLoadCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		// ע������֪ͨ��
		DemoDownLoadListener listener = new DemoDownLoadListener();
		caller.setListener(listener);
		// ��������
		caller.downloadInLocal(condition, startRow, numRow);
	}
	// ���ؽӿڵ���
	private static void callDownLoad() {

		String pkiId = "";
		String SenderID = "C32-09000043";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S32-09000174";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320924197906029018"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ΰ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320900230000";// ��������Ϊstring ,�ն��û���λ���롣
		String zdyhDwmc = "�γ��й�������Ϣͨ�Ŵ�";// ��������Ϊstring ,�ն��û���λ���ơ�
		String xtmc = "����ʡ�γ��н�ͨ�¹��ྯ��";// ��������Ϊstring ,�ն�ϵͳ���ơ�
		String zdyhJh = "090947";// ��������Ϊstring ,�ն��û����š�
		String zdyhIp = "10.39.128.108";// ��������Ϊstring ,�ն��û�IP��ַ��
		String zdyhMac = "00:50:56:A4:E7:2E";// ��������Ϊstring ,�ն��û�MAC��ַ��

		// ��ѯ����
		String condition = "  JJRQSJ>='20170201000000' ";
		int startRow = 0;
		int numRow = 5;// ��������Ϊint,���ػ�ȡ��¼����
		DownLoadCaller caller = new DownLoadCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		// ע������֪ͨ��
		DemoDownLoadListener listener = new DemoDownLoadListener();
		caller.setListener(listener);
		// ��������
		caller.download(condition, startRow, numRow);
	}
}


class  DemoDownLoadListener implements CallListener<DownLoadNotify> {
	private DownLoadNotify notify = null;
	
	@Override
	public void notify(RBSPCallerBase sender, DownLoadNotify notify) {
		String message = String.format("#####[debug]: created total=%d, download_count=%d, http_file=%s",
				notify.getTotalCount(),
				notify.getDownloadCount(),
				notify.getRemoteFileUrl());
		System.out.println(message);
		
		
		
		this.notify = notify;
	}

	@Override
	public boolean cancel(RBSPCallerBase sender) {
		return false;
	}

	@Override
	public void start(RBSPCallerBase sender) {
		String message = String.format("######[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
				sender.getServiceId(), "start ...");

		System.out.println(message);
	}

	@Override
	public void finished(RBSPCallerBase sender, Exception error, boolean cancel) {
		String message = "";
		if (error != null) {
			message = String.format("#######[error]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
					sender.getServiceId(), error.getMessage());

			System.out.println(message);
			return;
		}

		if (cancel) {
			message = String.format(">>>[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
					sender.getServiceId(), "user cancel task");

			System.out.println(message);
			return;
		}

		message = String.format("#######[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
				sender.getServiceId(), "download success!!!!!!!!!");
		System.out.println(message);
	}
}




