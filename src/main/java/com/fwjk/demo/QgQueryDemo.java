package com.fwjk.demo;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspConsts;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.dragonsoft.pci.exception.InvokeServiceException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ��ѯ�ӿڲ���ʾ��
 * 
 * @author gaox
 *
 */
public class QgQueryDemo {
	/**
	 * ����Node
	 */
	static String ST_NODE_URL = "http://10.32.203.231:8080/node";
	public static void main(String[] args) {
		System.out.println(String.format("==================== NodeURL= %s  ====================", ST_NODE_URL));
		System.out.println("==================== ����ʡȫ�������ѯ����ӿ�  ====================");
		try {
			testQqfwCzrk();//��ס�˿�
			//testQqfwZtryQuery();//������Ա
		} catch (InvokeServiceException e) {
			e.printStackTrace();
			System.out.println("==================== ����ʧ��  ====================");
		}
		
	}
	private static void testQqfwCzrk() throws InvokeServiceException {
		String pkiId = "cd0a95f55c234ee59c5afe6c3c2807f3";
		String SenderID = "C32-00000185";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S10-00000298";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320924197906029018"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ΰ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320900230000";// ��������Ϊstring ,�ն��û���λ���롣
		String conditiion = " SFZH='320911199008141224' ";// ��������Ϊstring ,��������
		String xmlData = qqfwQuery(pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm, "B033", "1", conditiion,
				new String[] { "XM"});
		System.out.println(xmlData);
	}
	private static void testQqfwZtryQuery() throws InvokeServiceException {
		String pkiId = "";
		String SenderID = "C32-09000075";// ��������Ϊstring ,���󷽱�� ��
		String ServiceID = "S10-00000068";// ��������Ϊstring ,���񷽱�š�
		String zdyhGmsfhm = "320924197906029018"; // ��������Ϊstring ,�ն��û����֤ ��
		String zdyhXm = "��ΰ";// ��������Ϊstring ,�ն��û�������
		String zdyhDwbm = "320900230000";// ��������Ϊstring ,�ն��û���λ���롣
		String conditiion = " SFZH='34040619711108325X' ";// ��������Ϊstring ,��������
		String xmlData = qqfwQuery(pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm, "A091", "1", conditiion,
				new String[] { "XM"});
		System.out.println(xmlData);
	}
	
	
	
	
	/**
	 * ȫ����������ѯ����
	 * @throws InvokeServiceException 
	 */
	private static String qqfwQuery(String pkiId, String SenderID, String ServiceID, String zdyhGmsfhm, String zdyhXm,
			String zdyhDwbm, String DataObjectCode, String InfoCodeMode, String Condition, String[] RequiredItems) throws InvokeServiceException {

		String taskId = UUID.randomUUID().toString().replace("-", "");
		String pkiValue = "";
		if ( pkiId == null || "".equals(pkiId)){
			pkiValue = taskId;
		}
		RbspService service = new RbspService(SenderID, ServiceID, pkiValue);
		service.setTaskId(taskId);

		service.setUserCardId(zdyhGmsfhm);
		service.setUserDept(zdyhDwbm);
		service.setUserName(zdyhXm);

		RbspCall call = service.createCall();
		call.setUrl(ST_NODE_URL);
		call.setMethod(RbspConsts.METHOD_QUERY);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("DataObjectCode", DataObjectCode); // "A001"//
		// ��Լ���������˵�����������ƺ��Ӧ����
		params.put("InfoCodeMode", InfoCodeMode); // "1"
		params.put("Condition", Condition); // "0=0"
		params.put("RequiredItems", RequiredItems); // new String[] { "XM",
		// "XB", "SFZH" } //��Լ�е������

		String result = call.invokeWithThrow(params);
		return result;
	}
	
}
