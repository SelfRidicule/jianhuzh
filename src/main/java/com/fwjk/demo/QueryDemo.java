package com.fwjk.demo;

import com.fwjk.caller.QueryCaller;
import com.fwjk.caller.ResourceServiceException;

/**
 * 查询接口测试示例
 * 
 * @author gaox
 *
 */
public class QueryDemo {
	/**
	 * 总线Node
	 */
	static String ST_NODE_URL = "http://50.144.11.204:8585/node";

	public static void main(String[] args) {
		try {
			//callQueryLocal();//非定制,全市数据接口   S32-09000347   S32-09000346  S32-09000344  S32-09000321 S32-09000264 
			callQueryLocal();
		} catch (ResourceServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	// 测试数据查询接口
	public static String callQuery() throws ResourceServiceException {
		// 基本参数
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000041";// 数据类型为string ,请求方编号 。
		String ServiceID = "S32-09000157";// 数据类型为string ,服务方编号。
		String zdyhGmsfhm = "320902198608310043"; // 数据类型为string ,终端用户身份证 。
		String zdyhXm = "周洁";// 数据类型为string ,终端用户姓名。
		String zdyhDwbm = "320900230000";// 数据类型为string ,终端用户单位编码。
		String zdyhDwmc = "盐城市公安局信息通信处 ";// 数据类型为string ,终端用户单位名称。
		String xtmc = "江苏省盐城市民政局社会救助中心核查系统";// 数据类型为string ,终端系统名称。
		String zdyhJh = "091528";// 数据类型为string ,终端用户警号。
		String zdyhIp = "50.144.70.14";// 数据类型为string ,终端用户IP地址。
		String zdyhMac = "78:45:C4:08:30:59";// 数据类型为string ,终端用户MAC地址。
		// 查询条件
		//String conditiion = " DJSJ like '20171102%' ";// 数据类型为string
		String conditiion = " gmsfhm='320911199008141224' ";// 数据类型为string
		int startRow = 0;
		int numRow = 1; // 数据类型为int获取纪录数。
		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		caller.setTimeout(1500);
		String result = caller.query(conditiion, startRow, numRow);
		System.out.println(">>>>[callQueryLocal]查询结果" + result);

		return result;
	}
	
	
	
	private static void callQueryLocal() throws ResourceServiceException {
		// 基本参数
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000092";// 数据类型为string ,请求方编号 。
		String ServiceID = "S32-09000468";// 数据类型为string ,服务方编号。
		String zdyhGmsfhm = "320925197909260035"; // 数据类型为string ,终端用户身份证 。
		String zdyhXm = "徐飞";// 数据类型为string ,终端用户姓名。
		String zdyhDwbm = "320925230000";// 数据类型为string ,终端用户单位编码。
		String zdyhDwmc = "建湖县公安局信息通信科 ";// 数据类型为string ,终端用户单位名称。
		String xtmc = "江苏省盐城市建湖县派出所综合指挥平台";// 数据类型为string ,终端系统名称。
		String zdyhJh = "097139";// 数据类型为string ,终端用户警号。
		String zdyhIp = "50.145.199.12";// 数据类型为string ,终端用户IP地址。
		String zdyhMac = "20:04:0F:F8:D8:DC";// 数据类型为string ,终端用户MAC地址。
		// 查询条件
		String conditiion = " yycsdm='32092510000036'  ";// 数据类型为string
		int startRow = 0;
		int numRow = 1; // 数据类型为int获取纪录数。
		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		caller.setTimeout(1500);
		String result = caller.queryInLocal(conditiion, startRow, numRow);
		System.out.println(">>>>[callQueryLocal]查询结果" + result);
	}


    /**
     *

     */
    public String selfCallQueryLocal(String serviceID , String condition , int startRow , int numRow ) throws ResourceServiceException {
		// 基本参数
		String nodeUrl = ST_NODE_URL;
		String pkiId = "";
		String SenderID = "C32-09000092";// 数据类型为string ,请求方编号 。
//		String ServiceID = "S32-09000468";// 数据类型为string ,服务方编号。
		String zdyhGmsfhm = "320925197909260035"; // 数据类型为string ,终端用户身份证 。
		String zdyhXm = "徐飞";// 数据类型为string ,终端用户姓名。
		String zdyhDwbm = "320925230000";// 数据类型为string ,终端用户单位编码。
		String zdyhDwmc = "建湖县公安局信息通信科 ";// 数据类型为string ,终端用户单位名称。
		String xtmc = "江苏省盐城市建湖县派出所综合指挥平台";// 数据类型为string ,终端系统名称。
		String zdyhJh = "097139";// 数据类型为string ,终端用户警号。
		String zdyhIp = "50.145.199.12";// 数据类型为string ,终端用户IP地址。
		String zdyhMac = "20:04:0F:F8:D8:DC";// 数据类型为string ,终端用户MAC地址。
		// 查询条件
//		String conditiion = " yycsdm='32092510000036'  ";// 数据类型为string


		if(serviceID == null || "".equals(serviceID)){
			serviceID =  "";// 数据类型为string ,服务方编号。
		}

		if(condition == null || "".equals(condition)){
			condition =   "";// 数据类型为string
		}

		QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, serviceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		caller.setTimeout(1500);
		String result = caller.queryInLocal(condition, startRow, numRow);
		System.out.println(">>>>[callQueryLocal]查询结果" + result);





		return result;
    }


    public String selfCallQueryCountInLocal(String serviceID , String condition) throws ResourceServiceException {
        // 基本参数
        String nodeUrl = ST_NODE_URL;
        String pkiId = "";
        String SenderID = "C32-09000092";// 数据类型为string ,请求方编号 。
//		String ServiceID = "S32-09000468";// 数据类型为string ,服务方编号。
        String zdyhGmsfhm = "320925197909260035"; // 数据类型为string ,终端用户身份证 。
        String zdyhXm = "徐飞";// 数据类型为string ,终端用户姓名。
        String zdyhDwbm = "320925230000";// 数据类型为string ,终端用户单位编码。
        String zdyhDwmc = "建湖县公安局信息通信科 ";// 数据类型为string ,终端用户单位名称。
        String xtmc = "江苏省盐城市建湖县派出所综合指挥平台";// 数据类型为string ,终端系统名称。
        String zdyhJh = "097139";// 数据类型为string ,终端用户警号。
        String zdyhIp = "50.145.199.12";// 数据类型为string ,终端用户IP地址。
        String zdyhMac = "20:04:0F:F8:D8:DC";// 数据类型为string ,终端用户MAC地址。
        // 查询条件
//		String conditiion = " yycsdm='32092510000036'  ";// 数据类型为string


        if(serviceID == null || "".equals(serviceID)){
            serviceID =  "";// 数据类型为string ,服务方编号。
        }

        if(condition == null || "".equals(condition)){
            condition =   "";// 数据类型为string
        }

        QueryCaller caller = new QueryCaller(nodeUrl, pkiId, SenderID, serviceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
                zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
        caller.setTimeout(1500);
        String result = caller.queryCountInLocal(condition);
        System.out.println(">>>>[queryCount]查询结果" + result);



        return result;
    }


	
}
