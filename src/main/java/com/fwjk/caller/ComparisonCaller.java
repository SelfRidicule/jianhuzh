package com.fwjk.caller;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.fwjk.RBSPMessageParser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �ȶԽӿڵ�����
 * @author gaox
 *
 */
public class ComparisonCaller extends RBSPTaskCallerBase<ComparisonNotify> {

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
	public ComparisonCaller(String nodeUrl, String pkiId, String senderId, String serviceId, String zdyhGmsfhm,
			String zdyhXm, String zdyhDwbm, String zdyhDwmc, String zdyhJh, String xtmc, String zdyhIp,
			String zdyhMac) {
		super(nodeUrl, pkiId, senderId, serviceId, zdyhGmsfhm, zdyhXm, zdyhDwbm, zdyhDwmc, zdyhJh, xtmc, zdyhIp,
				zdyhMac);
	}
	
	@Override
	protected void init(){
		setListener(new DefaultComparisonListener());
	}
	
	public static final String PARAM_KEY_CONDITION="condition";
	public static final String PARAM_KEY_UPDATA="xml_data";
	public static final String PARAM_KEY_UPEXEC_FILE="execel_file";
	public static final String PARAM_KEY_USE_UPFILE="use_file";
	public static final String PARAM_KEY_TASK_ID = "task_id";
	
	public void runByData(String condition, List<String> comparisonDatas){
		
		Map<String, Object> context = new HashMap<String, Object>();
		
		context.put(PARAM_KEY_CONDITION, condition);
		context.put(PARAM_KEY_USE_UPFILE, "false");
		context.put(PARAM_KEY_UPDATA, comparisonDatas);
		context.put(PARAM_KEY_UPEXEC_FILE, null);
		
		runCore(context,null);
	}
	
	public void runByExcelFile(String condition, String excelFile){
        Map<String, Object> context = new HashMap<String, Object>();
		
		context.put(PARAM_KEY_CONDITION, condition);
		context.put(PARAM_KEY_USE_UPFILE, "true");
		context.put(PARAM_KEY_UPDATA, null);
		context.put(PARAM_KEY_UPEXEC_FILE, excelFile);
		
		runCore(context,null);
	}
	
	
	@Override
	protected Map<String, Object> createTaskId(Map<String, Object> context) throws ResourceServiceException {
		
		String condition = (String) context.get(PARAM_KEY_CONDITION);
		
		RbspService service = this.createService();
		RbspCall call = this.createCall(service, "getJxbdTaskId");

		CallerInformation callInfo = getCallerInfomation();
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("zdyhGmsfhm", callInfo.getZdyhGmsfhm());
		params.put("zdyhXm", callInfo.getZdyhXm());
		params.put("zdyhDwbm", callInfo.getZdyhDwbm());
		params.put("zdyhDwmc", callInfo.getZdyhDwmc());
		params.put("zdyhJh", callInfo.getZdyhJh());
		params.put("xtmc", callInfo.getXtmc());
		params.put("zdyhIp", callInfo.getZdyhIp());
		params.put("zdyhMac", callInfo.getZdyhMac());
		
		params.put("conditiion", condition);
		String resultXml = this.invokeCall(call, params);
        
		String taskDesc = RBSPMessageParser.create(resultXml).getMethodStringValue();
		if( !isNumberString(taskDesc) ){
			if (taskDesc == "" ) taskDesc = "�������߳����������������ز�����"; 
			throw new ResourceServiceException(taskDesc);
		}
		
		context.put(PARAM_KEY_TASK_ID, taskDesc);
		return context;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void upTaskData(Map<String, Object> context) throws ResourceServiceException {
		String taskId = (String) context.get(PARAM_KEY_TASK_ID);
		List<String> datas = (List<String>) context.get(PARAM_KEY_UPDATA);
		String excelFile = (String) context.get(PARAM_KEY_UPEXEC_FILE);
		boolean useDataFile = Boolean.parseBoolean((String)context.get(PARAM_KEY_USE_UPFILE));
		
		RbspService service = this.createService();
		RbspCall call = this.createCall(service, "upDataJxbd");

		//CallerInformation callInfo = getCallerInfomation();
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("taskId", taskId);
		if(useDataFile){
			params.put("value", getByteArray(excelFile));
		}else{
			String dataXml = createConditionXml(datas);
			try {
				params.put("value", dataXml.getBytes("gbk"));
			} catch (UnsupportedEncodingException e) {
				throw new ResourceServiceException(e.getMessage());
			}
		}
		
		this.invokeCall(call, params);
	}
	
	
	@Override
	protected void executeTask(Map<String, Object> context) throws ResourceServiceException {
		String taskId = (String) context.get(PARAM_KEY_TASK_ID);
		RbspService service = this.createService();
		RbspCall call = this.createCall(service, "executeJxbd");
		
		//CallerInformation callInfo = getCallerInfomation();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskId", taskId);

		this.invokeCall(call, params);
	}
	
	@Override
	protected ComparisonNotify getPace(Map<String, Object> context) throws ResourceServiceException {
		String taskId = (String) context.get(PARAM_KEY_TASK_ID);

		RbspService service = this.createService();
		RbspCall call = this.createCall(service, "getPaceJxbdResult");
		
		//CallerInformation callInfo = getCallerInfomation();
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("taskId", taskId);
		String resultXml = this.invokeCall(call, params);
		
		String paceInfo = RBSPMessageParser.create(resultXml).getMethodStringValue();
		return createNotify(paceInfo);
	}
	
	@Override
	protected ComparisonNotify createNotify(String text){
		ComparisonNotify notify = ComparisonNotify.create(text);
		return notify;
	}
	
	
}
