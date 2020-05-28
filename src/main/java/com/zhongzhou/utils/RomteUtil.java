package com.zhongzhou.utils;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class RomteUtil
{
	private String serviceName;
	private String method;
	private String[] keys;
	private String[] values;
	/**
	 * 调用服务器接口
	 * 
	 * @param serviceName
	 *            调用的接口名称
	 * @param method
	 *            调用的方法名称
	 * @param parmers
	 *            key:parmers[0]<br>
	 *            value:parmers[1] 参数
	 *    
	 *            
	 */
	public RomteUtil(String serviceName, String method)
	{

		this.serviceName = serviceName;
		this.method = method;
		
	}
	public RomteUtil(String serviceName, String method, String[] keys, String[] values)
	{

		this.serviceName = serviceName;
		this.method = method;
		this.keys = keys;
		this.values = values;
	}

	/**
	 * 执行
	 * 
	 * @return String
	 */
	public String invoke()
	{

		//String endpoint = "http://183.213.191.21:805/services/cmcc_mas_wbs";
		String endpoint = "http://183.213.191.21:813/services/"+serviceName+"?wsdl";
		//String endpoint = "http://192.168.0.10:8080/HZManagerWeb/service/" + serviceName + "Service?wsdl";

		String result = null;
		Service service = new Service();
		Call call;
		try
		{
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(endpoint);
//			call.setOperationName(new QName("http://www.csapi.org/service", method));
			call.setOperationName(method);
			
			if(keys!=null)
			{
				
				for (int i = 0; i < keys.length; i++)
				{
					call.addParameter(keys[i], // 参数名
							null, // 参数类型:String
							javax.xml.rpc.ParameterMode.IN);// 参数模式：'IN' or'OUT'
//					call.addParameter(keys[i], // 参数名
//							org.apache.axis.encoding.XMLType.XSD_STRING, // 参数类型:String
//							javax.xml.rpc.ParameterMode.IN);// 参数模式：'IN' or'OUT'
					//log.info("--keys:"+keys[i]+"--values:"+values[i]);
					System.out.println("--keys:"+keys[i]+"--values:"+values[i]);
//					values[i] = DateSecret.encryptDES(values[i]); 
	
				}
			}
			
				call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 返回值类型：String
				Object cc = call.invoke(values);
			result = (String) cc;
//			result = DateSecret.decryptDES(result);
		} catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.toString());
		}

		return result;
	}

	
	public void setUrl(String url)
	{
		this.serviceName = url;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public void setKeys(String[] keys)
	{
		this.keys = keys;
	}

	public void setValues(String[] values)
	{
		this.values = values;
	}

}
