package com.fwjk.caller;

import org.codehaus.xfire.client.Client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
//import org.hamcrest.core.Is;

public class LocalVerifyer {
	private String url = "";
	private Client client = null;
	private boolean isNeedVerifyer = true;
	
	private LocalVerifyer(String url){
		if (url == null) isNeedVerifyer = false;
		if ( "".equals(url.trim())) isNeedVerifyer = false;
		
		this.url = String.format("%s?wsdl", url);
	}
	
	public static LocalVerifyer create(){
		String url = getDefaultUrl();
		return new LocalVerifyer(url);
	}
	
	public static String getDefaultUrl(){
		String url = "";
		
		Properties prop = new Properties();
		InputStream inStream = LocalVerifyer.class.getResourceAsStream("/node.properties");
		try {
			if (inStream == null) return "";
			
			prop.load(inStream);
			inStream.close();
		} catch (IOException e) {}
		
		url = prop.getProperty("fwzy.verify.url");
		return url;
	}
	
	
	
	public static LocalVerifyer create(String url){
		return new LocalVerifyer(url);
	}
	
	
	
	private boolean needVerifyer(){
		return this.isNeedVerifyer;
	}
	
	private synchronized Client getClient() throws ResourceServiceException {
		if (this.client != null) return this.client;
		
		Client client = null;
		try {
			client = new Client(new URL(this.url));
		} catch (MalformedURLException e) {
			throw new ResourceServiceException(e);
		} catch (Exception e) {
			throw new ResourceServiceException(e);
		}
		
		return client;
	}
	
	public boolean verify(String senderId,String serviceId ) throws ResourceServiceException {
		if ( !needVerifyer() ) return true;
		
		boolean verifyResult = false;
		Client client = getClient();
		Object[] result = null;
		
		try {
			result = client.invoke("verify", new Object[]{senderId, serviceId});
			verifyResult = Boolean.parseBoolean(result[0].toString());
		} catch (Exception e) {
			e.printStackTrace();
			String msg = String.format("[url=%s] message=%s", this.url, e.getMessage());
			throw new ResourceServiceException(msg);
		}
		
		return verifyResult;
	}
	
	
}
