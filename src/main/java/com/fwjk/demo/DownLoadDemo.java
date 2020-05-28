package com.fwjk.demo;

import com.fwjk.caller.DownLoadCaller;
import com.fwjk.caller.DownLoadNotify;
import com.fwjk.caller.RBSPCallerBase;
import com.fwjk.caller.inter.CallListener;

/**
 * 下载接口测试用例
 * @author gaox
 *
 */
public class DownLoadDemo {

	//static String nodeUrl = "http://50.144.11.204:8585/node";
	static String nodeUrl = "http://50.144.11.210:8585/node";

	public static void main(String[] args) {
		callDownLoad();
	}
	// 下载接口调用
	public static void callDownLoad() {

		String pkiId = "";
		String SenderID = "C32-09000091";// 数据类型为string ,请求方编号 。
		String ServiceID = "S32-09000463";// 数据类型为string ,服务方编号。
		String zdyhGmsfhm = "320911197101212817"; // 数据类型为string ,终端用户身份证 。
		String zdyhXm = "还月明 ";// 数据类型为string ,终端用户姓名。
		String zdyhDwbm = "320903180000";// 数据类型为string ,终端用户单位编码。
		String zdyhDwmc = "江苏省盐城市盐都区公安局法制大队 ";// 数据类型为string ,终端用户单位名称。
		String xtmc = "江苏省盐城市盐都区公安局执法办案大数据监督管理平台 ";// 数据类型为string ,终端系统名称。
		String zdyhJh = "092216";// 数据类型为string ,终端用户警号。
		String zdyhIp = "50.145.139.9";// 数据类型为string ,终端用户IP地址。
		String zdyhMac = "E8:61:1F:29:A7:6A";// 数据类型为string ,终端用户MAC地址


		// 查询条件
		String condition = " 1=1  ";
		int startRow = 0;
		int numRow = 5;// 数据类型为int,下载获取纪录数。
		DownLoadCaller caller = new DownLoadCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		// 注册下载通知器
		DownLoadListener listener = new DownLoadListener();
		caller.setListener(listener);
		caller.setWaitCallNotifyIntervalTime(5 * 1000);
		// 运行下载
		caller.download(condition, startRow, numRow);
	}
	// 下载定制接口调用
	public static void callDownLoadLocal() {

		String pkiId = "";
		String SenderID = "C32-09000075";// 数据类型为string ,请求方编号 。
		String ServiceID = "S32-09000119";// 数据类型为string ,服务方编号。
		String zdyhGmsfhm = "320902199110160054"; // 数据类型为string ,终端用户身份证 。
		String zdyhXm = "吴星星";// 数据类型为string ,终端用户姓名。
		String zdyhDwbm = "320991310000";// 数据类型为string ,终端用户单位编码。
		String zdyhDwmc = "盐城市公安局经济开发区分局办公室 ";// 数据类型为string ,终端用户单位名称。
		String xtmc = "江苏省盐城市经济开发区分局全息图系统";// 数据类型为string ,终端系统名称。
		String zdyhJh = "091872";// 数据类型为string ,终端用户警号。
		String zdyhIp = "50.147.128.113";// 数据类型为string ,终端用户IP地址。
		String zdyhMac = "18:66:da:f1:ff:15";// 数据类型为string ,终端用户MAC地址。


		// 查询条件
		String condition = " ( XGSJ>='2019042300000000' and XGSJ<'2019042400000000' ) ";
		int startRow = 0;
		int numRow = 5;// 数据类型为int,下载获取纪录数。
		DownLoadCaller caller = new DownLoadCaller(nodeUrl, pkiId, SenderID, ServiceID, zdyhGmsfhm, zdyhXm, zdyhDwbm,
				zdyhDwmc, zdyhJh, xtmc, zdyhIp, zdyhMac);
		// 注册下载通知器
		DownLoadListener listener = new DownLoadListener();
		caller.setListener(listener);
		caller.setWaitCallNotifyIntervalTime(5 * 1000);
		// 运行下载
		caller.downloadInLocal(condition, startRow, numRow);
	}
}


class  DownLoadListener implements CallListener<DownLoadNotify> {
	private DownLoadNotify notify = null;
	
	@Override
	public void notify(RBSPCallerBase sender, DownLoadNotify notify) {
		String message = String.format("#####[debug]: created total=%d, download_count=%d, http_file=%s",
				notify.getTotalCount(),
				notify.getDownloadCount(),
				notify.getRemoteFileUrl());
		System.out.println(message);
		
		
		
		this.notify = notify;
	}

	@Override
	public boolean cancel(RBSPCallerBase sender) {
		return false;
	}

	@Override
	public void start(RBSPCallerBase sender) {
		String message = String.format("######[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
				sender.getServiceId(), "start ...");

		System.out.println(message);
	}

	@Override
	public void finished(RBSPCallerBase sender, Exception error, boolean cancel) {
		String message = "";
		if (error != null) {
			message = String.format("#######[error]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
					sender.getServiceId(), error.getMessage());

			System.out.println(message);
			return;
		}

		if (cancel) {
			message = String.format(">>>[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
					sender.getServiceId(), "user cancel task");

			System.out.println(message);
			return;
		}

		message = String.format("#######[debug]: SenderId=%s ,ServiceId=%s, %s", sender.getSenderId(),
				sender.getServiceId(), "download success!!!!!!!!!");
		System.out.println(message);
	}
}




