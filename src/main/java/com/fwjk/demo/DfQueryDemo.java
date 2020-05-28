package com.fwjk.demo;

import com.fwjk.caller.QueryCaller;
import com.fwjk.caller.ResourceServiceException;

/**
 * ��ѯ�ӿڲ���ʾ��
 * 
 * @author gaox
 *
 */
public class DfQueryDemo {
	/**
	 * ����Node
	 */
	static String ST_NODE_URL = "http://50.144.11.210:8585/node";

	public static void main(String[] args) {
		try {
			callQueryLocal();//����
			//callQuery();
			//getDataCount();
			//getDataCountLocal();//����
		} catch (ResourceServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	// ���Ա��ض������ݲ�ѯ�ӿ�
	private static void callQueryLocal() throws ResourceServiceException {
		// ��������
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000069";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S32-09000132";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320925196402240057"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ѧƽ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320925230000";// ��������Ϊstring ,�ն��û���λ���롣
		String zdyhDwmc = "�����ع�������Ϣͨ�ſ�";// ��������Ϊstring ,�ն��û���λ���ơ�
		String xtmc = "����ʡ�����ع����־��õ�����Ϣϵͳ�ۺ�Ӧ��ƽ̨";// ��������Ϊstring ,�ն�ϵͳ���ơ�
		String zdyhJh = "097032";// ��������Ϊstring ,�ն��û����š�
		String zdyhIp = "10.39.200.218";// ��������Ϊstring ,�ն��û�IP��ַ��
		String zdyhMac = "18:66:DA:9C:12:D2";// ��������Ϊstring ,�ն��û�MAC��ַ��
		// ��ѯ����
		String conditiion = "   rybh='r3209255900008391702'  ";// ��������Ϊstring

		int startRow = 0;
		int numRow = 2; // ��������Ϊint��ȡ��¼����
		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		caller.setTimeout(1500);
		String result = caller.queryInLocal(conditiion, startRow, numRow);
		System.out.println(">>>>[callQueryLocal]��ѯ���" + result);
	}
	// ���Ա������ݲ�ѯ�ӿ�
	private static void callQuery() throws ResourceServiceException {
		// ��������
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000069";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S32-09000132";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320925196402240057"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ѧƽ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320925230000";// ��������Ϊstring ,�ն��û���λ���롣
		String zdyhDwmc = "�����ع�������Ϣͨ�ſ�";// ��������Ϊstring ,�ն��û���λ���ơ�
		String xtmc = "����ʡ�����ع����־��õ�����Ϣϵͳ�ۺ�Ӧ��ƽ̨";// ��������Ϊstring ,�ն�ϵͳ���ơ�
		String zdyhJh = "097032";// ��������Ϊstring ,�ն��û����š�
		String zdyhIp = "10.39.200.218";// ��������Ϊstring ,�ն��û�IP��ַ��
		String zdyhMac = "18:66:DA:9C:12:D2";// ��������Ϊstring ,�ն��û�MAC��ַ��
		// ��ѯ����
		String conditiion = "  rybh='r3209255900008391702'   ";// ��������Ϊstring

		int startRow = 0;
		int numRow =30; // ��������Ϊint��ȡ��¼����
		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		caller.setTimeout(1500);
		String result = caller.query(conditiion, startRow, numRow);
		System.out.println(">>>>[callQueryLocal]��ѯ���" + result);
	}
	private static void getDataCount() throws ResourceServiceException {
		// ��������
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000069";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S32-09000155";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320925196402240057"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ѧƽ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320925230000";// ��������Ϊstring ,�ն��û���λ���롣
		String zdyhDwmc = "�����ع�������Ϣͨ�ſ�";// ��������Ϊstring ,�ն��û���λ���ơ�
		String xtmc = "����ʡ�����ع����־��õ�����Ϣϵͳ�ۺ�Ӧ��ƽ̨";// ��������Ϊstring ,�ն�ϵͳ���ơ�
		String zdyhJh = "097032";// ��������Ϊstring ,�ն��û����š�
		String zdyhIp = "10.39.200.218";// ��������Ϊstring ,�ն��û�IP��ַ��
		String zdyhMac = "18:66:DA:9C:12:D2";// ��������Ϊstring ,�ն��û�MAC��ַ��
		// ��ѯ����
		String conditiion = "  dic_name='����״̬'  ";// ��������Ϊstring
		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		String count = caller.queryCount(conditiion);
		System.out.println("����������" +count);
	}
	private static void getDataCountLocal() throws ResourceServiceException {
		// ��������
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000069";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S32-09000461";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320925196402240057"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ѧƽ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320925230000";// ��������Ϊstring ,�ն��û���λ���롣
		String zdyhDwmc = "�����ع�������Ϣͨ�ſ�";// ��������Ϊstring ,�ն��û���λ���ơ�
		String xtmc = "����ʡ�����ع����־��õ�����Ϣϵͳ�ۺ�Ӧ��ƽ̨";// ��������Ϊstring ,�ն�ϵͳ���ơ�
		String zdyhJh = "097032";// ��������Ϊstring ,�ն��û����š�
		String zdyhIp = "10.39.200.218";// ��������Ϊstring ,�ն��û�IP��ַ��
		String zdyhMac = "18:66:DA:9C:12:D2";// ��������Ϊstring ,�ն��û�MAC��ַ��
		// ��ѯ����
		String conditiion = "   zhdq='320925' and xgsj>=to_char(trunc(sysdate,'yyyy'),'yyyymmddhh24miss') and XGSJ<to_char(sysdate,'yyyymmddhhmiss') and trunc((to_char(sysdate,'yyyymmdd')-to_char(to_date(SUBSTR(GMSFHM,7,8),'yyyy-MM-dd'),'yyyymmdd'))/10000) between 16 and 25  ";// ��������Ϊstring

		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		String count = caller.queryCountInLocal(conditiion);
		System.out.println("����������" +count);
	}
}
