package com.fwjk.caller;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.dragonsoft.pci.exception.InvokeServiceException;
import com.fwjk.RBSPMessageParser;

import java.util.Map;
import java.util.UUID;

public abstract class RBSPCallerBase {
	private String nodeUrl = null;
	private String senderId = null;
	private String serviceId = null;
	
	private String pkiId = null;
	private int serverTimeout = -1;
	
	private CallerInformation callInfo;
	private LocalVerifyer localVerifyer = null;
	private boolean printDebug = false;
	
	
	
	private LocalVerifyer getVerifyer(){
		if (localVerifyer != null) return localVerifyer;
		
		localVerifyer = LocalVerifyer.create();
		return localVerifyer;
	}
	
	private Boolean verifyResult = null;
	
	private boolean localVerify() throws ResourceServiceException {
		if (verifyResult != null) return verifyResult.booleanValue();
		
		boolean result = getVerifyer().verify(senderId, serviceId);
		verifyResult = Boolean.valueOf(result);
		
		return result;
	}
	
	/**
	 * ��ȡ���󷽻�����Ϣ
	 * @return
	 */
	public CallerInformation getCallerInfomation(){
		return callInfo;
	}
	
	/**
	 * ��ȡ���ߵ�ַ
	 * @return
	 */
	public String getNodeUrl(){
		return this.nodeUrl;
	}
	
	public void setPrintDebug(boolean flag){
		this.printDebug = flag;
	}
	
	public boolean getPrintDebug(){
		return this.printDebug;
	}
	
	/**
	 * ��ȡPKI֤����
	 * @return
	 */
	public String getPkiId(){
		return this.pkiId;
	}
	
	/**
	 * ����Id
	 * @return
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * ����Id
	 * @return
	 */
	public String getServiceId() {
		return serviceId;
	}

	
	
	/**
	 * 
	 * @param nodeUrl   ����Id
	 * @param pkiId PKI ֤����
	 * @param senderId  ����Id
	 * @param serviceId ���ͷ�Id
	 * @param zdyhGmsfhm �ն��û����֤��
	 * @param zdyhXm �ն��û�����
	 * @param zdyhDwbm �ն��û���λ����
	 * @param zdyhJh �ն��û�
	 * @param xtmc ����ϵͳ����
	 * @param zdyhIp �ն��û�IP
	 * @param zdyhMac �ն��û�MAC 
	 * 
	 */
	public RBSPCallerBase(String nodeUrl,
			               String pkiId,
			               String senderId,
			               String serviceId,
			               String zdyhGmsfhm,
			               String zdyhXm,
			               String zdyhDwbm,
			               String zdyhDwmc,
			               String zdyhJh,
			               String xtmc,
			               String zdyhIp, 
			               String zdyhMac
			               ){
		this.nodeUrl = nodeUrl;
		this.pkiId = pkiId;
		this.senderId = senderId;
		this.serviceId = serviceId;
		
		callInfo = new CallerInformation( zdyhGmsfhm, zdyhXm, 
				zdyhDwbm, zdyhDwmc, zdyhJh, xtmc, 
				zdyhIp,  zdyhMac);
		this.serverTimeout = -1;
	}
	
	
	public void setTimeout(int timeout){
		serverTimeout = timeout;
	}
	
	/**
	 * ��������
	 * @param senderID   ����Id
	 * @param serviceID  ����Id
	 * @return ����ʵ��
	 */
	protected RbspService createService(){
		RbspService service = new RbspService(getSenderId(), getServiceId(), pkiId);
		service.setTaskId(createRandomTaskId());
		if (serverTimeout > 0){
			service.setTimeOut(Integer.toString(serverTimeout));
		}
		
		CallerInformation callInfo = getCallerInfomation();
		service.setUserCardId(callInfo.getZdyhGmsfhm()); // �ն��û����֤��
		service.setUserDept(callInfo.getZdyhDwbm());     // �ն��û���λ����
		service.setUserName(callInfo.getZdyhXm());       // �ն��û�����
		
		return service;
	}
	
	protected static String createRandomTaskId(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * ��������
	 * @param service ����ʵ��
	 * @return
	 * @throws ResourceServiceException
	 */
	protected RbspCall createCall(RbspService service, String methodName){
		
		
		RbspCall call = service.createCall();
		call.setUrl(nodeUrl);
		call.setMethod(methodName); // ��������
		
		return call;
	}
	
	protected String invokeCallForStringResult(RbspCall call, Map<String, Object> params) throws ResourceServiceException {
		String xmlResult =  invokeCall(call, params);
		
		return RBSPMessageParser.create(xmlResult).getMethodStringValue();
	}
	
	protected String invokeCall(RbspCall call, Map<String, Object> params) throws ResourceServiceException {
        String xmlResult = "";
		
        localVerify();
		try {
			xmlResult = call.invokeWithThrow(params);
		} catch (InvokeServiceException e) {
			throw new ResourceServiceException(e);
		}
		if ( getPrintDebug() ) {
			System.out.println( String.format(">>> [node-debug-out][method: %s]: %s",
					RBSPMessageParser.create(xmlResult).getMethodName(),
					xmlResult));
		}
		return xmlResult;
	}
	
	protected static boolean isNumberString(String text){
		if (text == null) return false;
		if (text.length() == 0) return false;
		
		return text.matches("[0-9]+");
	}
	
	protected static void SleepWithoutException(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
}
