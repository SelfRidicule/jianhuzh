package com.fwjk.caller;

import java.util.HashMap;
import java.util.Map;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspService;

/**
 * 查询接口调用器
 * @author gaox
 *
 */
public class QueryCaller extends RBSPCallerBase {


    /**
     *
     * @param nodeUrl   总线Id
     * @param pkiId PKI 证书编号
     * @param senderId  请求方Id
     * @param serviceId 发送方Id
     * @param zdyhGmsfhm 终端用户身份证号
     * @param zdyhXm 终端用户姓名
     * @param zdyhDwbm 终端用户单位编码
     * @param zdyhJh 终端用户
     * @param xtmc 调用系统名称
     * @param zdyhIp 终端用户IP
     * @param zdyhMac 终端用户MAC
     *
     */
    public QueryCaller(String nodeUrl,
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

    }

    /**
     * 查询接口--查询满足条件的数据
     * @param conditiion 查询条件
     * @param startRow 起始纪录索引（从0开始）
     * @param numRow 获取记录数
     * @return
     * @throws ResourceServiceException
     */
    public String query(String condition, int startRow, int numRow) throws ResourceServiceException {
        return queryCore("getData", condition, startRow, numRow);
    }

    /**
     * 本地数据接口--查询请求所属行政区划下满足条件的数据
     * @param condition 查询条件
     * @param startRow 起始纪录索引（从0开始）
     * @param numRow 获取记录数
     * @return
     * @throws ResourceServiceException
     */
    public String queryInLocal(String condition, int startRow, int numRow) throws ResourceServiceException{

        return queryCore("getDwData", condition, startRow, numRow);
    }

    private String queryCore(String methodName, String condition, int startRow, int numRow) throws ResourceServiceException {
        RbspService service = this.createService();
        RbspCall call = this.createCall(service, methodName);

        CallerInformation callInfo = getCallerInfomation();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("zdyhGmsfhm",  callInfo.getZdyhGmsfhm() ); // 终端用户身份证号
        params.put("zdyhXm", callInfo.getZdyhXm()); // 终端用户姓名
        params.put("zdyhDwbm", callInfo.getZdyhDwbm());// 终端用户单位编码
        params.put("zdyhDwmc", callInfo.getZdyhDwmc());// 终端用户单位名称
        params.put("zdyhJh", callInfo.getZdyhJh());// 终端用户警号
        params.put("xtmc", callInfo.getXtmc()); // 系统名称
        params.put("zdyhIp", callInfo.getZdyhIp());// 终端用户IP
        params.put("zdyhMac", callInfo.getZdyhMac()); // 终端用户MAC

        params.put("conditiion", condition);// 终端用户条件
        params.put("startRow", startRow);// 终端用户开始纪录数
        params.put("numRow", numRow);// 终端用户获取条数

        return this.invokeCall(call, params);
    }



    /**
     * 查询接口--获取满足条件的数据记录数
     * @param condition 查询条件
     * @return 记录数
     * @throws ResourceServiceException
     */
    public String queryCount(String condition) throws ResourceServiceException{

        return queryCountCore("getDataCount", condition);
    }

    /**
     * 本地接口--获取满足条件的数据记录数
     * @param conditiion 查询条件
     * @return 记录数
     * @throws ResourceServiceException
     */
    public String queryCountInLocal(String condition) throws ResourceServiceException{
        return queryCountCore("getDwDataCount", condition);
    }

    private String queryCountCore(String methodName, String condition) throws ResourceServiceException{
        RbspService service = this.createService();
        RbspCall call = this.createCall(service, methodName);

        CallerInformation callInfo = getCallerInfomation();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("zdyhGmsfhm",  callInfo.getZdyhGmsfhm() ); // 终端用户身份证号
        params.put("zdyhXm", callInfo.getZdyhXm()); // 终端用户姓名
        params.put("zdyhDwbm", callInfo.getZdyhDwbm());// 终端用户单位编码
        params.put("zdyhDwmc", callInfo.getZdyhDwmc());// 终端用户单位名称
        params.put("zdyhJh", callInfo.getZdyhJh());// 终端用户警号
        params.put("xtmc", callInfo.getXtmc()); // 系统名称
        params.put("zdyhIp", callInfo.getZdyhIp());// 终端用户IP
        params.put("zdyhMac", callInfo.getZdyhMac()); // 终端用户MAC

        params.put("conditiion", condition);// 终端用户条件

        String result = this.invokeCallForStringResult(call, params);
        return result;
    }

}
