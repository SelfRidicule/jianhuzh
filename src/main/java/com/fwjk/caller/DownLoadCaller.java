package com.fwjk.caller;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.fwjk.RBSPMessageParser;
import com.fwjk.caller.inter.CallListener;

import java.util.HashMap;
import java.util.Map;


public class DownLoadCaller extends RBSPNotifyCallerBase {

    private CallListener<DownLoadNotify> listener = null;
	
    public CallListener<DownLoadNotify> getListener() {
		return listener;
	}
    
    /**
     * ע������֪ͨ��
     * @param listener
     */
	public void setListener(CallListener<DownLoadNotify> listener) {
		this.listener = listener;
	}

	public DownLoadCaller(String nodeUrl,
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
            String zdyhMac) {
		
		super(nodeUrl, pkiId, senderId, serviceId, zdyhGmsfhm, zdyhXm, zdyhDwbm, zdyhDwmc, zdyhJh, 
				xtmc, zdyhIp, zdyhMac);
		listener = new DefaultDownLoadListener();
	}

	public void download(String condition, 
			int startRow, int numRow){
		
		String downLoadFunName = "executeDownLoadDataFunction";
		downloadCore(downLoadFunName, condition, startRow, numRow);
	}
	
	public void downloadInLocal(String condition, 
			int startRow, int numRow){
		
		String downLoadFunName = "executeDownLoadDataDwFunction";
		downloadCore(downLoadFunName, condition, startRow, numRow);
	}
	
	private void downloadCore(String downLoadFunName,String condition, 
			int startRow, int numRow){
		String paceFunName = "getPace";
		
		Exception error = null;
		boolean cancel = false;
		try
		{
			listener.start(this);
		
			String taskXml = this.executeDownloadCore(downLoadFunName, 
					condition, startRow, numRow);
			String taskDesc = RBSPMessageParser.create(taskXml).getMethodStringValue();
			if( !isNumberString(taskDesc) ){
				if (taskDesc == "" ) taskDesc = "�������߳����������������ز�����"; 
				throw new ResourceServiceException(taskDesc);
			}
			
			String taskId = taskDesc;
			while(true){
				cancel = listener.cancel(this);
				if(cancel) break;
				
				String paceXml = getPaceCore(paceFunName, taskId);
				String paceInfo = RBSPMessageParser.create(paceXml).getMethodStringValue();
				
				DownLoadNotify notify = DownLoadNotify.create(paceInfo);
				if (notify.getSuccesss()){
					listener.notify(this, notify);
					break;
				}
				
				RBSPCallerBase.SleepWithoutException(this.getWaitCallNotifyIntervalTime());
			}
		
		}catch(Exception e){
			error = e;
		}finally{
			listener.finished(this, error, cancel);
		}
	}
	
	private String executeDownloadCore(String methodName, String condition, 
			int startRow, int numRow) throws ResourceServiceException {
		
		RbspService service = this.createService();
		RbspCall call = this.createCall(service, methodName);

		CallerInformation callInfo = getCallerInfomation();
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("zdyhGmsfhm",  callInfo.getZdyhGmsfhm() ); // �ն��û����֤��
		params.put("zdyhXm", callInfo.getZdyhXm()); // �ն��û�����
		params.put("zdyhDwbm", callInfo.getZdyhDwbm());// �ն��û���λ����
		params.put("zdyhDwmc", callInfo.getZdyhDwmc());// �ն��û���λ����
		params.put("zdyhJh", callInfo.getZdyhJh());// �ն��û�����
		if ( methodName.equalsIgnoreCase("executeDownLoadDataFunction") ){
			params.put("zdyh_xm", callInfo.getXtmc()); // ϵͳ����
		}else{
			params.put("xtmc", callInfo.getXtmc()); // ϵͳ����
		}
		params.put("zdyhIp", callInfo.getZdyhIp());// �ն��û�IP
		params.put("zdyhMac", callInfo.getZdyhMac()); // �ն��û�MAC
		
		params.put("conditiion", condition);
		params.put("startRow", startRow);
		params.put("numRow", numRow);
		
		String result = this.invokeCall(call, params);
		return result;
	}
	

	private String getPaceCore(String methodName, String taskId) throws ResourceServiceException {
		RbspService service = this.createService();
		RbspCall call = this.createCall(service, methodName);
	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("guid", taskId);

		String result = call.invoke(params);
		return result;
	}

	

}
