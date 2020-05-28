package com.fwjk.caller;

import com.fwjk.caller.inter.CallListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public abstract class RBSPTaskCallerBase<T extends TaskNotify> extends RBSPNotifyCallerBase {

	private CallListener<T> listener = null;

	public CallListener<T> getListener() {
		return listener;
	}

	public void setListener(CallListener<T> listener) {
		this.listener = listener;
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
	public RBSPTaskCallerBase(String nodeUrl, String pkiId, String senderId, String serviceId, String zdyhGmsfhm,
			String zdyhXm, String zdyhDwbm, String zdyhDwmc, String zdyhJh, String xtmc, String zdyhIp,
			String zdyhMac) {
		super(nodeUrl, pkiId, senderId, serviceId, zdyhGmsfhm, zdyhXm, zdyhDwbm, zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		
		init();
	}
	
	protected abstract void init();
	
	protected boolean isStop(StopTrigger trigger){
		if(trigger != null)
			return trigger.stop();
		
		return false;
	}

    protected void runCore(Map<String, Object> context, StopTrigger stopTrigger){
		
		Exception error = null;
		boolean cancel = false;
		
		try
		{
			context = createTaskId(context);
			upTaskData(context);
			
			executeTask(context);
			while(true){
				cancel = listener.cancel(this);
				if(cancel) break;
				
				if(isStop(stopTrigger)) {
					cancel = true;
					break;
				}
				
				T notify = getPace(context);
				
				if (notify.getStatus() == TaskStatus.None){
					SleepWithoutException(this.getWaitCallNotifyIntervalTime());
					continue;
				}
				
				if (notify.getStatus() == TaskStatus.Hit){
					listener.notify(this, notify);
					SleepWithoutException(this.getWaitCallNotifyIntervalTime());
					continue;
				}
				
				if (notify.getStatus() == TaskStatus.Finished){
					break;
				}
			}
		}catch(Exception e){
			error = e;
		}finally{
			listener.finished(this, error, cancel);
		}
	}
	
	protected abstract Map<String, Object> createTaskId(Map<String, Object> context) 
			throws ResourceServiceException;
			
	protected abstract void upTaskData(Map<String, Object> context)
			throws ResourceServiceException;
	
	protected abstract void executeTask(Map<String, Object> context)
			throws ResourceServiceException;

	protected abstract T getPace(Map<String, Object> context)
			throws ResourceServiceException;
	
	protected abstract T createNotify(String text);
	
	protected static String createConditionXml(List<String> datas){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<DATA>");
		for(String item: datas){
			sb.append("  <RECORD>");
			
			sb.append("    <index>");
			sb.append(item);
			sb.append("</index>");
			
			sb.append("  </RECORD>");
		}
		sb.append("</DATA>");
		
		return sb.toString();
	}
	
	protected static byte[] getByteArray(String pathfile) {

		try {
			File file = new File(pathfile);
			FileInputStream in;
			in = new FileInputStream(file);

			byte[] by = new byte[(int) file.length()];
			in.read(by, 0, (int) file.length());
			in.close();
			
			return by;
		} catch (Exception e) {
			return new byte[]{};
		}
	}
}
