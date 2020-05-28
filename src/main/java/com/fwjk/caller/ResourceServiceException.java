package com.fwjk.caller;

import com.dragonsoft.pci.exception.InvokeServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * ��Դ����ͻ��˵����쳣
 * @author gaox
 *
 */
public class ResourceServiceException extends Exception{

private static Map<String, String> droganErrorMap = new HashMap<String, String>();
	
	private static final long serialVersionUID = 8003619806109623616L;

	private String errorCode = "";
	private String errorDesc = "";
	
	public String getErrorCode() {
		return errorCode;
	}

	static {
		initErrorCodeMap();
	}
	
	private static void initErrorCodeMap(){
		Properties prop = new Properties();
		InputStream inStream = LocalVerifyer.class.getResourceAsStream("node.error.properties");
		try {
			if (inStream == null) return;
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
			prop.load(bf);
			
			bf.close();
			inStream.close();
		} catch (IOException e) {}
		
		Iterator< Entry<Object,Object> > iter = prop.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Object,Object> entry = iter.next();
			String tmpKey = (String)entry.getKey();
			String errorMessage = (String)entry.getValue();
			
			String[] keyArray = tmpKey.split("\\.");
			String errorCode = keyArray[keyArray.length -1];
			droganErrorMap.put(errorCode, errorMessage);
		}
	}
	
	private static String getNodeMessage(String code){
		if (code == null || "".equals(code)) return "unknow node error";
		
		String errMessage = droganErrorMap.get(code);
		if (errMessage == null) return String.format("error-code=%s", code);
		
		return errMessage;
	}
	
	public ResourceServiceException(){
		super();
	}
	
	public ResourceServiceException(String message){
		super(message);

		init(null, message);
	}
	
	public ResourceServiceException(String code, String message){
		super(message);
		init(code, message);
	}
	
	public ResourceServiceException(Exception error){
		super(error);
		
		if ( InvokeServiceException.class.equals( error.getClass() ) ){
			InvokeServiceException drganError = (InvokeServiceException)error;
			
			String message = drganError.getErrorMessage();
			if( message == null || "".equals(message)){
				message = getNodeMessage(drganError.getErrorCode());
			}
			init(drganError.getErrorCode(), message);	
		}
	}
	
	private void init(String code, String message){
		errorCode = (code == null) ? "": code;
		errorDesc = (message==null) ? "": message;
	}
	
	@Override
	public String getMessage(){
		if (errorCode == "") return errorDesc;
		
		return String.format("[%s] %s", errorCode, errorDesc);
	}
	
	

}
